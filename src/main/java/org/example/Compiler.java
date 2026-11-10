package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.compiler.Utils;
import org.example.compiler.ValueHolder;
import org.example.compiler.generated.MarsikBaseVisitor;
import org.example.compiler.generated.MarsikLexer;
import org.example.compiler.generated.MarsikParser;

public class Compiler extends MarsikBaseVisitor<String> {

  public final HashMap<String, ValueHolder> variablesAndConstants = new HashMap<>();
  public final Set<String> imports = new HashSet<>();;
  public final StringBuilder code = new StringBuilder();
  private final StringBuilder functionDefinitions = new StringBuilder();
  private final StringBuilder functionDeclarations = new StringBuilder();
  private final StringBuilder typeDefinitions = new StringBuilder();
  private String sharedTypeDefinitions = "";
  private String sharedFunctionDeclarations = "";
  private String moduleName;
  private Set<String> importedModuleNames = Set.of();
  private Set<String> localFunctionNames = Set.of();

  public static Path getProjectRoot() {
    return Path.of("").toAbsolutePath();
  }

  @Override
  public String visitProgram(MarsikParser.ProgramContext ctx) {
    imports.add("#include \"marsik_runtime.hpp\"\n");
    localFunctionNames = ctx.top_level_item().stream()
            .filter(item -> item.function_def() != null)
            .map(item -> item.function_def().NAME().getText())
            .collect(java.util.stream.Collectors.toSet());
    for (var child : ctx.children) {
        this.visit(child);
    }
    return null;
  }

  @Override
  public String visitFunction_call(MarsikParser.Function_callContext ctx) {
    return renderFunctionCall(ctx, null, null);
  }

  private String renderFunctionCall(MarsikParser.Function_callContext ctx,
                                    String genericModule, String genericArguments) {
    List<String> nameParts = ctx.qualified_name().NAME().stream()
            .map(ParseTree::getText).toList();
    String name = ctx.qualified_name().getText();
    if (nameParts.size() == 2) {
      String module = nameParts.get(0);
      String function = nameParts.get(1);
      String builtInFunction = Utils.builtInModuleFunction(module, function);
      if (builtInFunction != null) {
        name = builtInFunction;
        if (function.equals("init") && module.equals(genericModule) && genericArguments != null) {
          name += "<" + genericArguments + ">";
        }
      } else if (Utils.isBuiltInLibraryMethod(module, function)) {
        name = function;
      } else if (Utils.isBuiltInModule(module)) {
        throw new IllegalArgumentException("Unknown " + module + " module function: " + function);
      } else if (importedModuleNames.contains(module)) {
        name = moduleFunctionName(module, function);
      }
    } else if (nameParts.size() == 1 && moduleName != null
            && localFunctionNames.contains(nameParts.get(0))) {
      name = moduleFunctionName(moduleName, name);
    }
    return name + "(" + renderArguments(ctx.arguments()) + ")";
  }

  @Override
  public String visitFunction_def(MarsikParser.Function_defContext ctx) {
    String returnType = ctx.return_type == null ? "void" : visit(ctx.return_type);
    String name = moduleName == null
            ? ctx.NAME().getText() : moduleFunctionName(moduleName, ctx.NAME().getText());
    String parameters = ctx.parameters() == null ? "" : visit(ctx.parameters());
    String signature = returnType + " " + name + "(" + parameters + ")";

    HashMap<String, ValueHolder> outerVariables = new HashMap<>(variablesAndConstants);
    if (ctx.parameters() != null) {
      for (MarsikParser.ParameterContext parameter : ctx.parameters().parameter()) {
        variablesAndConstants.put(parameter.NAME().getText(),
                new ValueHolder(parameter.type_label().getText(), true, false));
      }
    }

    int functionBodyStart = code.length();
    visit(ctx.block());
    String body = code.substring(functionBodyStart);
    code.setLength(functionBodyStart);
    variablesAndConstants.clear();
    variablesAndConstants.putAll(outerVariables);

    functionDeclarations.append(signature).append(";\n");
    functionDefinitions.append(signature).append(' ').append(body);
    return null;
  }

  @Override
  public String visitType_label(MarsikParser.Type_labelContext ctx) {
    return Utils.toCppType(ctx.getText());
  }

  @Override
  public String visitCustom_type(MarsikParser.Custom_typeContext ctx) {
    String typeName = ctx.NAME(0).getText();
    List<String> fieldTypes = new ArrayList<>();
    List<String> fieldNames = new ArrayList<>();
    for (int i = 0; i < ctx.type_label().size(); i++) {
      fieldTypes.add(visit(ctx.type_label(i)));
      fieldNames.add(ctx.NAME(i + 1).getText());
    }

    typeDefinitions.append("struct ").append(typeName).append(" {\n");
    for (int i = 0; i < fieldTypes.size(); i++) {
      typeDefinitions.append("  ").append(fieldTypes.get(i)).append(' ')
              .append(fieldNames.get(i)).append(";\n");
    }
    typeDefinitions.append("};\n");
    typeDefinitions.append("inline ").append(typeName).append(" init_")
            .append(typeName.toLowerCase(Locale.ROOT)).append('(');
    for (int i = 0; i < fieldTypes.size(); i++) {
      if (i > 0) {
        typeDefinitions.append(", ");
      }
      typeDefinitions.append(fieldTypes.get(i)).append(" value").append(i);
    }
    typeDefinitions.append(") {\n  ").append(typeName).append(" result{};\n");
    for (int i = 0; i < fieldNames.size(); i++) {
      typeDefinitions.append("  result.").append(fieldNames.get(i)).append(" = value")
              .append(i).append(";\n");
    }
    typeDefinitions.append("  return result;\n}\n");
    return null;
  }

  @Override
  public String visitStmt(MarsikParser.StmtContext ctx) {
    if (ctx.print_stmt() != null) {
      code.append(visit(ctx.print_stmt()));
    }
    if (ctx.println_stmt() != null) {
      code.append(visit(ctx.println_stmt()));
    }
    if (ctx.exit_stmt() != null) {
      code.append(visit(ctx.exit_stmt()));
    }
    if (ctx.function_call() != null) {
      code.append(visit(ctx.function_call())).append(";\n");
    }
    return super.visitStmt(ctx);
  }

  @Override
  public String visitObject_stmt(MarsikParser.Object_stmtContext ctx) {
    // Person p = ("Bob", 22)
    String objectType = ctx.NAME(0).getText();
    String objectVariable = ctx.NAME(ctx.NAME().size() - 1).getText();

    if (variablesAndConstants.containsKey(objectVariable)) {
      throw new RuntimeException("Variable " + objectVariable + " already exists");
    }
    String type = "";
    type = ctx.getRuleContexts(MarsikParser.Type_labelContext.class).isEmpty()
              ? "" : "<" + ctx.getRuleContexts(MarsikParser.Type_labelContext.class).stream()
                      .map(ParseTree::getText).collect(java.util.stream.Collectors.joining(", ")) + ">";
    if (Utils.isForbiddenName(objectVariable)) {
      throw new RuntimeException("Name " + objectVariable + " is forbidden for variable names");
    }
    String parameters = renderArguments(ctx.arguments());
    variablesAndConstants.put(objectVariable, new ValueHolder(objectType + type, true, false));
    appendObjectInitialization(objectType, objectVariable, type, parameters);
    return null;
  }

  private void appendObjectInitialization(String objectType, String variable,
                                          String type, String parameters) {
    code.append("struct ").append(objectType).append(" ").append(type)
            .append(variable).append(" = init_").append(objectType.toLowerCase(Locale.ROOT))
            .append(type).append("(")
            .append(parameters).append(");\n");
  }

  private String renderArguments(MarsikParser.ArgumentsContext ctx) {
    return String.join(", ", renderArgumentList(ctx));
  }

  private List<String> renderArgumentList(MarsikParser.ArgumentsContext ctx) {
    List<String> args = new ArrayList<>();
    if (ctx != null) {
      for (var expr : ctx.expr()) {
        args.add(visit(expr));
      }
    }
    return args;
  }

  @Override
  public String visitVar_decl(MarsikParser.Var_declContext ctx) {
    String name = ctx.NAME().getText();
    String declaredType = ctx.type_label().getText();
    String runtimeType = declaredType.contains("<")
            ? declaredType.substring(0, declaredType.indexOf('<')) : declaredType;
    if (Utils.isForbiddenName(name)) {
      throw new RuntimeException("Name " + name + " is forbidden for variable names");
    }
    if (variablesAndConstants.containsKey(name)) {
      throw new RuntimeException("Variable " + name + " already exists");
    }
    String type = Utils.toCppType(declaredType);
    if (ctx.scan_stmt() != null) {
      appendScanDeclaration(ctx.scan_stmt(), type, name);
      variablesAndConstants.put(name, new ValueHolder(runtimeType, true, false));
      return "";
    }

    String init = renderInitializer(ctx);
    if (init != null) {
      code.append(type).append(" ").append(name).append(" = ").append(init).append(";\n");
      variablesAndConstants.put(name, new ValueHolder(runtimeType, true, false));
    } else {
      code.append(type).append(" ").append(name).append(";\n");
      variablesAndConstants.put(name, new ValueHolder(runtimeType, false, false));
    }
    return null;
  }

  private String renderInitializer(MarsikParser.Var_declContext ctx) {
    if (ctx.type() != null) {
      Utils.validateLiteralType(ctx.type_label().getText(), ctx.type());
      return ctx.type().getText();
    }
    if (ctx.function_call() != null) {
      String declaredType = ctx.type_label().getText();
      int genericStart = declaredType.indexOf('<');
      int genericEnd = declaredType.lastIndexOf('>');
      if (genericStart >= 0 && genericEnd > genericStart) {
        List<String> callNameParts = ctx.function_call().qualified_name().NAME().stream()
                .map(ParseTree::getText).toList();
        if (callNameParts.size() == 2 && callNameParts.get(1).equals("init")
                && callNameParts.get(0).equals(declaredType.substring(0, genericStart))
                && Utils.buildInTypedObjects.contains(callNameParts.get(0))) {
          return renderFunctionCall(ctx.function_call(), callNameParts.get(0),
                  declaredType.substring(genericStart + 1, genericEnd));
        }
      }
      return visit(ctx.function_call());
    }
    if (ctx.expr() != null) {
      return visit(ctx.expr());
    }
    return null;
  }

  private void appendScanDeclaration(MarsikParser.Scan_stmtContext scan,
                                     String type, String name) {
    code.append(type).append(" ").append(name).append(";\n");
    code.append("std::cout");
    for (MarsikParser.Print_argContext arg : scan.print_arg()) {
      code.append(" << ");
      code.append(arg.STRING() != null ? arg.STRING().getText() : visit(arg.expr()));
    }
    code.append(";\n");
    code.append("std::cin >> ").append(name).append(";\n");
  }

  @Override
  public String visitConst_decl(MarsikParser.Const_declContext ctx) {
    String name = ctx.NAME().getText();
    if (variablesAndConstants.containsKey(name)) {
      throw new RuntimeException("A Constant with the name " + name + " already exists");
    }
    if (Utils.isForbiddenName(name)) {
      throw new RuntimeException("Name " + name + " is forbidden for declaring constants");
    }
    String type = Utils.toCppType(ctx.type_label().getText());
    String value = ctx.type().getText();
    Utils.validateLiteralType(ctx.type_label().getText(), ctx.type());
    code.append("const ").append(type).append(" ").append(name)
            .append(" = ").append(value).append(";\n");
    variablesAndConstants.put(name, new ValueHolder(type, true, true));
    return null;
  }

  @Override
  public String visitAssign_stmt(MarsikParser.Assign_stmtContext ctx) {
    String target = ctx.qualified_name().getText();
    String variableName = target.substring(0, target.indexOf('.') >= 0 ? target.indexOf('.') : target.length());
    if (variablesAndConstants.containsKey(variableName) && variablesAndConstants.get(variableName).isConst) {
      throw new RuntimeException("Cannot assign to const: " + variableName);
    }
    ValueHolder variable = variablesAndConstants.get(variableName);
    if (variable == null) {
      throw new RuntimeException("Variable " + variableName + " does not exist");
    }
    if (ctx.type() != null && target.equals(variableName)) {
      Utils.validateLiteralType(variable.getType(), ctx.type());
    }

    String value = ctx.type() != null ? ctx.type().getText()
            : ctx.expr() != null ? visit(ctx.expr()) : visit(ctx.function_call());
    code.append(target).append(" = ").append(value).append(";\n");
    return null;
  }

  @Override
  public String visitArray_decl(MarsikParser.Array_declContext ctx) {
    int size = ctx.INTEGER() == null ? ctx.type().size() : Integer.parseInt(ctx.INTEGER().getText());
    String typeLabel = ctx.type_label().getText();
    String name = ctx.NAME().getText();
    if (ctx.function_call() != null) {
      variablesAndConstants.put(name, new ValueHolder("array", true, false));
      code.append("struct Array<").append(typeLabel).append("> ").append(name)
              .append(" = ").append(visit(ctx.function_call())).append(";\n");
      return null;
    }
    if (ctx.type().size() > size) {
      throw new RuntimeException("Array size " + size + " does not match number of elements");
    }
    for (MarsikParser.TypeContext value : ctx.type()) {
      if (!Utils.isCompatibleLiteral(typeLabel, value)) {
        throw new RuntimeException("Array element " + value.getText() + " does not match " + typeLabel);
      }
    }
    variablesAndConstants.put(name, new ValueHolder("array", true, false));

    StringBuilder compoundLiteral = new StringBuilder();
    compoundLiteral.append("{");
    for (int i = 0; i < ctx.type().size(); i++) {
      if (i > 0) {
        compoundLiteral.append(",");
      }
      compoundLiteral.append(ctx.type(i).getText());
    }
    compoundLiteral.append("}");

    code.append("struct Array<").append(typeLabel).append("> ").append(name).append(" = {")
            .append(compoundLiteral).append(", ").append(size).append(", \"")
            .append(typeLabel).append("\"}").append(";\n");
    return null;
  }

  @Override
  public String visitParameters(MarsikParser.ParametersContext ctx) {
    List<String> params = new ArrayList<>();
    for (MarsikParser.ParameterContext p : ctx.parameter()) {
      params.add(visit(p));
    }
    return String.join(", ", params);
  }

  @Override
  public String visitParameter(MarsikParser.ParameterContext ctx) {
    String type = visit(ctx.type_label());
    String name = ctx.NAME().getText();
    if (Utils.isForbiddenName(name)) {
      throw new RuntimeException("Name " + name + " is forbidden for variable names");
    }
    boolean primitive = List.of("int", "double", "char", "boolean", "string")
            .contains(ctx.type_label().getText());
    return type + (primitive ? " " : "& ") + name;
  }

  @Override
  public String visitIf_stmt(MarsikParser.If_stmtContext ctx) {
    code.append("if (").append(visit(ctx.expr())).append(") ");
    visit(ctx.block(0));
    if (ctx.ELSE() != null) {
      code.append(" else ");
      visit(ctx.block(1));
    }
    return null;
  }

  @Override
  public String visitWhile_stmt(MarsikParser.While_stmtContext ctx) {
    String cond = visit(ctx.expr());
    code.append("while (").append(cond).append(") ");
    visit(ctx.block());
    return null;
  }

  @Override
  public String visitBlock(MarsikParser.BlockContext ctx) {
    code.append("{\n");
    visitChildren(ctx);
    code.append("}\n");
    return null;
  }

  @Override
  public String visitFor_stmt(MarsikParser.For_stmtContext ctx) {
    code.append("for (");
    if (ctx.for_init() != null) {
      visit(ctx.for_init());
    }
    if (ctx.expr() != null) {
      code.append(visit(ctx.expr()));
    }
    if (ctx.for_update() != null) {
      ctx.for_update();
    }
    code.append("; ").append(ctx.for_update().getText());
    code.append(") ");
    visit(ctx.block());
    return null;
  }

  @Override
  public String visitFor_update(MarsikParser.For_updateContext ctx) {
    return ctx.inc_stmt() != null ? ctx.inc_stmt().getText() : ctx.dec_stmt().getText();
  }

  @Override
  public String visitInc_stmt(MarsikParser.Inc_stmtContext ctx) {
    String name = ctx.qualified_name().getText();
    if (ctx.INTEGER() != null) {
      code.append(name).append("+=").append(ctx.INTEGER().getText()).append(";\n");
    } else {
      code.append(name).append("++").append(";\n");
    }
    return null;
  }

  @Override
  public String visitDec_stmt(MarsikParser.Dec_stmtContext ctx) {
    String name = ctx.qualified_name().getText();
    if (ctx.INTEGER() != null) {
      code.append(name).append("-=").append(ctx.INTEGER().getText()).append(";\n");
    }  else {
      code.append(name).append("--").append(";\n");
    }
    return null;
  }

  @Override
  public String visitPrint_stmt(MarsikParser.Print_stmtContext ctx) {
    return renderPrintArguments(ctx.print_arg()) + ";\n";
  }

  @Override
  public String visitPrintln_stmt(MarsikParser.Println_stmtContext ctx) {
    return renderPrintArguments(ctx.print_arg()) + "<< '\\n';\n";
  }

  private String renderPrintArguments(List<MarsikParser.Print_argContext> args) {
    StringBuilder cpp = new StringBuilder("std::cout");
    for (MarsikParser.Print_argContext arg : args) {
      cpp.append(" << ");
      cpp.append(arg.STRING() != null ? arg.STRING().getText() : visit(arg.expr()));
    }
    return cpp.toString();
  }

  @Override
  public String visitExit_stmt(MarsikParser.Exit_stmtContext ctx) {
    String exitCode = ctx.INTEGER() != null ? ctx.INTEGER().getText() : "0";
    return "exit(" + exitCode + ");\n";
  }

  @Override
  public String visitReturn_stmt(MarsikParser.Return_stmtContext ctx) {
    code.append("return ").append(ctx.expr() != null ? visit(ctx.expr()) : "").append(";\n");
    return null;
  }

  @Override
  public String visitExpr(MarsikParser.ExprContext ctx) {
    return super.visitExpr(ctx);
  }

  @Override
  public String visitOr_expr(MarsikParser.Or_exprContext ctx) {
    return Utils.joinBinaryExpressions(ctx.and_expr(), this::visit, "||");
  }

  @Override
  public String visitAnd_expr(MarsikParser.And_exprContext ctx) {
    return Utils.joinBinaryExpressions(ctx.equality_expr(), this::visit, "&&");
  }

  @Override
  public String visitEquality_expr(MarsikParser.Equality_exprContext ctx) {
    return Utils.joinBinaryExpressions(ctx.relational_expr(), this::visit, ctx);
  }

  @Override
  public String visitRelational_expr(MarsikParser.Relational_exprContext ctx) {
    return Utils.joinBinaryExpressions(ctx.additive_expr(), this::visit, ctx);
  }

  @Override
  public String visitAdditive_expr(MarsikParser.Additive_exprContext ctx) {
    return Utils.joinBinaryExpressions(ctx.multiplicative_expr(), this::visit, ctx);
  }

  @Override
  public String visitMultiplicative_expr(MarsikParser.Multiplicative_exprContext ctx) {
    return Utils.joinBinaryExpressions(ctx.unary_expr(), this::visit, ctx);
  }

  @Override
  public String visitUnary_expr(MarsikParser.Unary_exprContext ctx) {
    if (ctx.getChildCount() == 2) {
      return ctx.getChild(0).getText() + " " + visit(ctx.unary_expr());
    } else {
      return visit(ctx.power_expr());
    }
  }

  @Override
  public String visitPower_expr(MarsikParser.Power_exprContext ctx) {
    if (ctx.getChildCount() == 3) {
      return "pow(" + visit(ctx.atom_expr()) + "," + visit(ctx.unary_expr()) + ")";
    } else {
      return visit(ctx.atom_expr());
    }
  }

  @Override
  public String visitAtom_expr(MarsikParser.Atom_exprContext ctx) {
    if (ctx.function_call() != null) {
      return visit(ctx.function_call());
    }
    if (ctx.qualified_name() != null) {
      return ctx.qualified_name().getText();
    }
    if (ctx.INTEGER() != null) {
      return ctx.INTEGER().getText();
    }
    if (ctx.DOUBLE() != null) {
      return ctx.DOUBLE().getText();
    }
    if (ctx.STRING() != null) {
      return ctx.STRING().getText();
    }
    if (ctx.CHAR() != null) {
      return ctx.CHAR().getText();
    }
    if (ctx.BOOLEAN() != null) {
      return ctx.BOOLEAN().getText();
    }
    if (ctx.expr() != null) {
      return visit(ctx.expr());
    }
    return "";
  }

  public String generateC() {
    return Utils.generateC(imports, code.toString(),
            sharedTypeDefinitions + sharedFunctionDeclarations + functionDeclarations)
        + "\n" + functionDefinitions;
  }

  void compile(String srcPath, String outDir) throws IOException, InterruptedException {
    Path sourcePath = Path.of(srcPath).toAbsolutePath().normalize();
    Path outputDir = Path.of(outDir).toAbsolutePath().normalize();
    Files.createDirectories(outputDir);
    Path runtimeDir = findRuntimeDirectory(sourcePath);

    List<SourceModule> modules = loadModules(sourcePath);
    modules.get(0).compiler().moduleName = null;
    Set<String> moduleNames = new HashSet<>();
    for (SourceModule module : modules) {
      if (module.name() != null) {
        moduleNames.add(module.name());
      }
    }

    for (SourceModule module : modules) {
      if (module.name() != null) {
        requireModuleDeclarationsOnly(module);
        module.compiler().moduleName = module.name();
      }
      module.compiler().importedModuleNames = moduleNames;
    }
    importedModuleNames = moduleNames;
    modules.set(0, new SourceModule(sourcePath, null, modules.get(0).program(), this));

    for (int i = 1; i < modules.size(); i++) {
      SourceModule module = modules.get(i);
      module.compiler().visit(module.program());
    }
    visit(modules.get(0).program());

    String allModuleDeclarations = modules.stream().skip(1)
            .map(module -> module.compiler().functionDeclarations.toString())
            .collect(java.util.stream.Collectors.joining());
    String allTypeDefinitions = modules.stream()
            .map(module -> module.compiler().typeDefinitions.toString())
            .collect(java.util.stream.Collectors.joining());
    ensureUniqueTypes(modules);

    sharedTypeDefinitions = allTypeDefinitions;
    sharedFunctionDeclarations = allModuleDeclarations;
    for (int i = 1; i < modules.size(); i++) {
      SourceModule module = modules.get(i);
      module.compiler().sharedTypeDefinitions = allTypeDefinitions;
      module.compiler().sharedFunctionDeclarations = allModuleDeclarations;
      Path moduleCpp = outputDir.resolve("module_" + module.name() + ".cpp");
      Files.writeString(moduleCpp, module.compiler().generateModuleCpp());
    }

    Path mainCpp = outputDir.resolve("generated.cpp");
    Files.writeString(mainCpp, generateC());

    Path executable = outputDir.resolve("app.exe");
    List<String> command = new ArrayList<>();
    command.add(findCppCompiler());
    command.add(mainCpp.toString());
    for (int i = 1; i < modules.size(); i++) {
      command.add(outputDir.resolve("module_" + modules.get(i).name() + ".cpp").toString());
    }
    try (var runtimeSources = Files.walk(runtimeDir)) {
      runtimeSources.filter(Files::isRegularFile)
              .filter(path -> path.toString().endsWith(".cpp"))
              .sorted()
              .map(path -> path.toAbsolutePath().normalize().toString())
              .forEach(command::add);
    }
    command.add("-I" + runtimeDir);
    command.add("-I" + outputDir);
    command.add("-std=gnu++17");
    command.add("-static-libgcc");
    command.add("-static-libstdc++");
    command.add("-Wall");
    command.add("-O2");
    command.add("-o");
    command.add(executable.toString());

    System.out.println("Compiling using Command: \n" + String.join(" ", command));
    ProcessBuilder processBuilder = new ProcessBuilder(command);
    processBuilder.redirectErrorStream(true);
    Process process = processBuilder.start();
    try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(process.getInputStream()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
        String regex = "^(.*?):(\\d+):(\\d+):\\s+(error|warning|note):\\s+(.*)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
          int lineNumber = Integer.parseInt(matcher.group(2));
          String severity = matcher.group(4);
          String message = matcher.group(5);
          Pattern optionPattern = Pattern.compile("\\[([^]]+)]$");
          Matcher optionMatcher = optionPattern.matcher(message);
          if (optionMatcher.find()) {
            message = message.substring(0, optionMatcher.start()).trim();
          }
          switch (severity) {
              case "error" -> {
                  Utils.printError("[ERROR] a fatal error happened: " + message + " in Line: " + lineNumber);
              }
              case "warning" -> {
                  Utils.printWarning("[WARNING] marsik needs to tell you something: " + message + " in Line: " + lineNumber);
              }
          }
        }
      }
    }
    int exitCode = process.waitFor();
    if (exitCode != 0) {
      throw new IOException("C++ compilation failed with exit code " + exitCode
              + ". Generated source: " + mainCpp);
    }
    Utils.printSuccess("Compilation successful!");
  }

  private String generateModuleCpp() {
    StringBuilder generated = new StringBuilder();
    generated.append("#include <stdbool.h>\n#include <string>\n#include <iostream>\n");
    for (String include : imports) {
      generated.append(include);
    }
    generated.append(sharedTypeDefinitions)
            .append(sharedFunctionDeclarations)
            .append(functionDefinitions);
    return generated.toString();
  }

  private static String moduleFunctionName(String module, String function) {
    return module + "__" + function;
  }

  static String findCppCompiler() {
    String configuredCompiler = System.getenv("CXX");
    if (configuredCompiler != null && !configuredCompiler.isBlank()) {
      return configuredCompiler;
    }
    Path windowsCompiler = Path.of("C:\\Program Files\\gcc\\bin\\g++.exe");
    return Files.isExecutable(windowsCompiler) ? windowsCompiler.toString() : "g++";
  }

  private static Path findRuntimeDirectory(Path sourcePath) throws IOException {
    Path projectRuntime = getProjectRoot().resolve("src/main/java/org/example/runtime");
    if (Files.isRegularFile(projectRuntime.resolve("marsik_runtime.hpp"))) {
      return projectRuntime.toAbsolutePath().normalize();
    }
    for (Path parent = sourcePath.getParent(); parent != null; parent = parent.getParent()) {
      Path runtime = parent.resolve("runtime");
      if (Files.isRegularFile(runtime.resolve("marsik_runtime.hpp"))) {
        return runtime;
      }
      runtime = parent.resolve("src/main/java/org/example/runtime");
      if (Files.isRegularFile(runtime.resolve("marsik_runtime.hpp"))) {
        return runtime;
      }
    }
    throw new IOException("Could not locate runtime directory containing marsik_runtime.hpp");
  }

  private static List<SourceModule> loadModules(Path mainSource) throws IOException {
    List<SourceModule> modules = new ArrayList<>();
    Map<Path, SourceModule> loaded = new HashMap<>();
    Map<String, Path> names = new HashMap<>();
    List<Path> pending = new ArrayList<>();
    pending.add(mainSource);

    while (!pending.isEmpty()) {
      Path source = pending.remove(0).toAbsolutePath().normalize();
      if (loaded.containsKey(source)) {
        continue;
      }
      ParsedSource parsed = new Compiler().parseSource(source);
      boolean isMain = source.equals(mainSource.toAbsolutePath().normalize());
      String name = isMain ? null : moduleName(source);
      if (name != null) {
        Path previous = names.putIfAbsent(name, source);
        if (previous != null && !previous.equals(source)) {
          throw new IOException("Imported files " + previous + " and " + source
                  + " have the same module name " + name);
        }
      }
      SourceModule module = new SourceModule(source, name, parsed.program(), new Compiler());
      loaded.put(source, module);
      modules.add(module);

      for (MarsikParser.Import_declContext importDecl : parsed.imports().import_decl()) {
        pending.add(resolveImport(source, importDecl.STRING().getText()));
      }
    }
    return modules;
  }

  private static Path resolveImport(Path importingFile, String stringLiteral) throws IOException {
    String importPath = stringLiteral.substring(1, stringLiteral.length() - 1)
            .replace("\\\"", "\"").replace("\\\\", "\\");
    Path requested = Path.of(importPath);
    if (!requested.isAbsolute()) {
      requested = importingFile.getParent().resolve(requested);
    }
    if (!requested.getFileName().toString().endsWith(".marsik")) {
      requested = requested.resolveSibling(requested.getFileName() + ".marsik");
    }
    requested = requested.toAbsolutePath().normalize();
    if (!Files.isRegularFile(requested)) {
      throw new IOException("Imported Marsik file not found: " + requested
              + " (imported from " + importingFile + ")");
    }
    return requested;
  }

  private static String moduleName(Path source) throws IOException {
    String fileName = source.getFileName().toString();
    String name = fileName.substring(0, fileName.length() - ".marsik".length());
    if (!name.matches("[A-Za-z_][A-Za-z_0-9]*") || Utils.isForbiddenName(name)) {
      throw new IOException("Imported file name must be a valid module identifier: " + fileName);
    }
    return name;
  }

  private static void requireModuleDeclarationsOnly(SourceModule module) throws IOException {
    for (MarsikParser.Top_level_itemContext item : module.program().top_level_item()) {
      if (item.stmt() != null) {
        throw new IOException("Imported module " + module.source()
                + " may contain only types and functions, not executable statements");
      }
    }
  }

  private static void ensureUniqueTypes(List<SourceModule> modules) throws IOException {
    Map<String, Path> types = new HashMap<>();
    for (SourceModule module : modules) {
      for (MarsikParser.Top_level_itemContext item : module.program().top_level_item()) {
        if (item.custom_type() != null) {
          String name = item.custom_type().NAME(0).getText();
          Path previous = types.putIfAbsent(name, module.source());
          if (previous != null) {
            throw new IOException("Type " + name + " is declared in both " + previous
                    + " and " + module.source());
          }
        }
      }
    }
  }

  /**
   * Start the compiler in CLI using:
   * gradle.bat -p C:\Marsik\MarsikLang run --args="src/main/java/org/example/tests/datastructureTests/testMatrix.marsik"
   * Choose the file you want to compile and optionally specify the output directory.
   */
  void main(String[] args) throws IOException, InterruptedException {
    if (args.length == 0 || args.length > 2) {
      System.out.println("Usage: Compiler <input.marsik> [output-directory]");
      return;
    }
    String input = args[0];
    String output = args.length == 2 ? args[1]: "src/main/java/org/example/out";
    compile(input, output);
  }

  private record ParsedSource(MarsikParser.ImportsContext imports, MarsikParser.ProgramContext program) {}

  private record SourceModule(
          Path source, String name, MarsikParser.ProgramContext program, Compiler compiler) {}

  private ParsedSource parseSource(Path sourcePath) throws IOException {
    if (!Files.isRegularFile(sourcePath)) {
      throw new IOException("Marsik source file not found: " + sourcePath);
    }
    CharStream input = CharStreams.fromPath(sourcePath);
    MarsikLexer lexer = new MarsikLexer(input);
    lexer.removeErrorListeners();
    lexer.addErrorListener(throwingSyntaxErrorListener(sourcePath));
    MarsikParser parser = new MarsikParser(new CommonTokenStream(lexer));
    parser.removeErrorListeners();
    parser.addErrorListener(throwingSyntaxErrorListener(sourcePath));
    MarsikParser.ProgramContext program = parser.program();
    return new ParsedSource(program.imports(), program);
  }

  private BaseErrorListener throwingSyntaxErrorListener(Path sourcePath) {
    return new BaseErrorListener() {
      @Override
      public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                              int charPositionInLine, String message, RecognitionException exception) {
        throw new IllegalArgumentException(sourcePath + ":" + line + ":"
                + (charPositionInLine + 1) + ": " + message, exception);
      }
    };
  }
}
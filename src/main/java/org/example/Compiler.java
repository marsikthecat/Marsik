package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.compiler.CustomObjectGenerator;
import org.example.compiler.CustomObjectHolder;
import org.example.compiler.FieldHolder;
import org.example.compiler.GeneratedFilesTracker;
import org.example.compiler.MethodHolder;
import org.example.compiler.ParamHolder;
import org.example.compiler.Utils;
import org.example.compiler.ValueHolder;
import org.example.compiler.generated.MarsikBaseVisitor;
import org.example.compiler.generated.MarsikLexer;
import org.example.compiler.generated.MarsikParser;

public class Compiler extends MarsikBaseVisitor<String> {

  public final HashMap<String, ValueHolder> variables = new HashMap<>();
  public final HashMap<String, ValueHolder> constants = new HashMap<>();
  public final StringBuilder code = new StringBuilder();
  public final Set<String> imports = new HashSet<>();
  public final HashMap<String, CustomObjectHolder> customObjects = new HashMap<>();
  public CustomObjectHolder currentCustomObject = null;

  @Override
  public String visitProgram(MarsikParser.ProgramContext ctx) {
    // First pass: collect all custom object definitions
    for (var child : ctx.children) {
      if (child instanceof MarsikParser.Class_defContext classDef) {
        visitClass_def(classDef);
      }
    }
    // Second pass: process statements
    for (var child : ctx.children) {
      if (!(child instanceof MarsikParser.Class_defContext)) {
        this.visit(child);
      }
    }
    return null;
  }

  @Override
  public String visitType_label(MarsikParser.Type_labelContext ctx) {
    return Utils.toCppType(ctx.getText(), imports);
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
    if (ctx.method_call() != null) {
      code.append(visit(ctx.method_call())).append(";\n");
    }
    return super.visitStmt(ctx);
  }

  @Override
  public String visitObject_stmt(MarsikParser.Object_stmtContext ctx) {
    String objectType = Objects.requireNonNull(ctx.NAME(0).getText());
    String variable = Objects.requireNonNull(ctx.NAME(1).getText());
    String newObjectName = Objects.requireNonNull(ctx.NAME(2).getText());
    if (!objectType.equals(newObjectName)) {
      throw new RuntimeException("Object " + objectType + " and " + newObjectName + " do not match");
    }

    variables.put(variable, new ValueHolder(objectType, true));
    String parameters = renderArguments(ctx.arguments());
    if (customObjects.containsKey(objectType)) {
      appendObjectInitialization(objectType, variable, "", parameters);
      return null;
    }

    boolean isTyped = registerBuiltInObject(objectType, ctx.type_label());
    String type = isTyped ? "<" + ctx.type_label().getText() + ">" : "";
    appendObjectInitialization(objectType, variable, type, parameters);
    return null;
  }

  private void appendObjectInitialization(String objectType, String variable,
                                          String type, String parameters) {
    code.append("struct ").append(objectType).append(" ").append(type)
            .append(variable).append(" = init_").append(objectType.toLowerCase()).append(type).append("(")
            .append(parameters).append(");\n");
  }

  private boolean registerBuiltInObject(String objectType,
                                        MarsikParser.Type_labelContext typeLabel) {
    if (Utils.buildInTypedObjects.contains(objectType)) {
      if (typeLabel == null) {
        throw new RuntimeException("Type is not specified");
      }
      String subdirectory = Utils.multiEquals(objectType, "AvlTree", "BinaryTree", "TreeNode")
              ? "trees/" : "";
      imports.add("#include \"../runtime/datastructures/" + subdirectory
              + objectType.toLowerCase() + ".hpp\"\n");
      return true;
    }
    if (Utils.getBuildInUnTypedObjects.contains(objectType)) {
      String normalizedObjectType = Objects.requireNonNull(objectType);
      String subdirectory = switch (objectType) {
        case "Edge", "Graph", "Node" -> "../runtime/datastructures/graphs/";
        case "Matrix" -> "../runtime/extra/";
        default -> "../runtime/datastructures/";
      };
      imports.add("#include \"" + subdirectory + normalizedObjectType.toLowerCase() + ".hpp\"\n");
      return false;
    }
    throw new RuntimeException("Unknown Type of Elements detected");
  }

  @Override
  public String visitMethod_call(MarsikParser.Method_callContext ctx) {
    String target = ctx.NAME(0).getText();
    String method = ctx.NAME(1).getText();

    if (Utils.isBuiltInLibraryMethod(target, method)) {
      return visitBuiltInLibraryMethodCall(ctx, target, method);
    }
    ValueHolder targetValue = variables.get(target);
    if (targetValue == null) {
      throw new RuntimeException("Variable " + target + " does not exist");
    }
    String type = targetValue.type;
    CustomObjectHolder customObject = customObjects.get(type);
    if (customObject != null) {
      boolean methodFound = customObject.methods.stream()
              .anyMatch(candidate -> candidate.name.equals(method));
      if (!methodFound) {
        throw new RuntimeException("Method " + method + " not found in class " + customObject.name);
      }
    } else {
      if (type.equals("string") && !Utils.stringMethods.contains(method)) {
        throw new RuntimeException("Unknown method " + method + " for String: " + target);
      }
      if (type.equals("array") && !Utils.arrayMethods.contains(method)) {
        throw new RuntimeException("Unknown method " + method + " for Array: " + target);
      }
    }
    List<String> args = renderArgumentList(ctx.arguments());

    String joinedArgs = String.join(", ", args);
    String targetArgument = customObject != null ? "&" + target : target;
    return type.toLowerCase() + "_" + method + "(" + targetArgument
            + (joinedArgs.isEmpty() ? "" : ", " + joinedArgs) + ")";
  }

  private String visitBuiltInLibraryMethodCall(MarsikParser.Method_callContext ctx, String target, String method) {
    if (!Utils.multiEquals(target, "Math", "FileHandler", "DateTime", "Crypto", "Caster")) {
      throw new RuntimeException("Unknown builtin target: " + target);
    }
    imports.add("#include \"../runtime/" + target.toLowerCase() + ".hpp\"\n");                                            
    List<String> args = new ArrayList<>();
    if (ctx.arguments() != null) {
      for (var e : ctx.arguments().expr()) {
        args.add(renderBuiltInArgument(e));
      }
    }
    return method + "(" + String.join(", ", args) + ")";
  }

  private String renderBuiltInArgument(MarsikParser.ExprContext expr) {
    return visit(expr);
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
    if (variables.containsKey(name)) {
      throw new RuntimeException("Variable " + name + " already exists");
    }
    String type = Utils.toCppType(ctx.type_label().getText(), imports);
    if (ctx.scan_stmt() != null) {
      appendScanDeclaration(ctx.scan_stmt(), type, name);
      variables.put(name, new ValueHolder(type, true));
      return "";
    }

    String init = renderInitializer(ctx);
    if (init != null) {
      code.append(type).append(" ").append(name).append(" = ").append(init).append(";\n");
      variables.put(name, new ValueHolder(type, true));
    } else {
      code.append(type).append(" ").append(name).append(";\n");
      variables.put(name, new ValueHolder(type, false));
    }
    return null;
  }

  private String renderInitializer(MarsikParser.Var_declContext ctx) {
    if (ctx.type() != null) {
      Utils.validateLiteralType(ctx.type_label().getText(), ctx.type());
      return ctx.type().getText();
    }
    if (ctx.expr() != null) {
      return visit(ctx.expr());
    }
    if (ctx.method_call() != null) {
      return visit(ctx.method_call());
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
    if (constants.containsKey(name)) {
      throw new RuntimeException("Constant " + name + " already exists");
    }
    String type = Utils.toCppType(ctx.type_label().getText(), imports);
    String value = ctx.type().getText();
    Utils.validateLiteralType(ctx.type_label().getText(), ctx.type());
    code.append("const ").append(type).append(" ").append(name)
            .append(" = ").append(value).append(";\n");
    constants.put(name, new ValueHolder(type, true));
    return null;
  }

  @Override
  public String visitAssign_stmt(MarsikParser.Assign_stmtContext ctx) {
    String name = ctx.NAME().getText();
    if (constants.containsKey(name)) {
      throw new RuntimeException("Cannot assign to const: " + name);
    }
    ValueHolder variable = variables.get(name);
    if (variable == null) {
      throw new RuntimeException("Variable " + name + " does not exist");
    }

    if (ctx.type() != null) {
      Utils.validateLiteralType(variable.getType(), ctx.type());
    }

    String value = ctx.type() != null ? ctx.type().getText()
            : ctx.expr() != null ? visit(ctx.expr())
            : visit(ctx.method_call());
    code.append(name).append(" = ").append(value).append(";\n");
    return null;
  }

  @Override
  public String visitArray_decl(MarsikParser.Array_declContext ctx) {
    int size = Integer.parseInt(ctx.INTEGER().getText());
    if (ctx.type().size() > size) {
      throw new RuntimeException("Array size " + size + " does not match number of elements");
    }
    String typeLabel = ctx.type_label().getText();
    for (MarsikParser.TypeContext value : ctx.type()) {
      if (!Utils.isCompatibleLiteral(typeLabel, value)) {
        throw new RuntimeException("Array element " + value.getText() + " does not match " + typeLabel);
      }
    }
    String name = ctx.NAME().getText();
    variables.put(name, new ValueHolder("array", true));

    StringBuilder compoundLiteral = new StringBuilder();
    compoundLiteral.append("{");
    for (int i = 0; i < ctx.type().size(); i++) {
      if (i > 0) {
        compoundLiteral.append(",");
      }
      compoundLiteral.append(ctx.type(i).getText());
    }
    compoundLiteral.append("}");

    imports.add("#include \"../runtime/datastructures/array.hpp\"\n");
    code.append("struct Array<").append(typeLabel).append("> ").append(name).append(" = {")
            .append(compoundLiteral).append(", ").append(size).append(", \"")
            .append(typeLabel).append("\"}").append(";\n");
    return null;
  }

  @Override
  public String visitFuncdef(MarsikParser.FuncdefContext ctx) {
    String name = ctx.NAME().getText();
    code.append("static void ").append(name).append("(");
    if (ctx.parameters() != null) {
      code.append(visit(ctx.parameters()));
    }
    code.append(") ");
    visit(ctx.block());
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
    return type + " " + name;
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
    String name = ctx.NAME().getText();
    if (ctx.INTEGER() != null) {
      code.append(name).append("+=").append(ctx.INTEGER().getText()).append(";\n");
    } else {
      code.append(name).append("++").append(";\n");
    }
    return null;
  }

  @Override
  public String visitDec_stmt(MarsikParser.Dec_stmtContext ctx) {
    String name = ctx.NAME().getText();
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
  public String visitClass_def(MarsikParser.Class_defContext ctx) {
    String className = ctx.NAME().getText();
    // Create custom object holder
    CustomObjectHolder customObj = new CustomObjectHolder(className);
    currentCustomObject = customObj;
    // First pass: Process all fields to make them available in the scope
    for (var member : ctx.class_member()) {
      if (member.field_decl() != null) {
        FieldHolder field = new FieldHolder();
        field.type = member.field_decl().type_label().getText();
        field.name = member.field_decl().NAME().getText();
        field.isPublic = member.field_decl().getText().contains("public");
        field.isConst = member.field_decl().getText().contains("const");
        customObj.fields.add(field);

        // Add field to variables scope for method access
        variables.put(field.name, new ValueHolder(Utils.toCppType(field.type, imports), true));
      }
    }
    // Second pass: Process all methods (without appending to main code)
    StringBuilder tempCodeStorage = new StringBuilder(code.toString());
    code.setLength(0); // Clear main code temporarily
    for (var member : ctx.class_member()) {
      if (member.method_decl() != null) {
        MethodHolder method = new MethodHolder();
        MarsikParser.Method_declContext methodCtx = member.method_decl();
        method.name = methodCtx.NAME().getText();
        method.returnType = methodCtx.type_label() != null ? methodCtx.type_label().getText() : "void";
        method.isInternal = methodCtx.getText().startsWith("internal");

        if (methodCtx.parameters() != null) {
          for (var p : methodCtx.parameters().parameter()) {
            method.params.add(new ParamHolder(
                    p.type_label().getText(),
                    p.NAME().getText()
            ));
                variables.put(p.NAME().getText(), new ValueHolder(
                  Utils.toCppType(p.type_label().getText(), imports), true));
          }
        }
        // Capture method body without appending to main code
        visitBlock(methodCtx.block());
        method.body = code.toString();
        code.setLength(0); // Reset for next method
        customObj.methods.add(method);
        for (ParamHolder param : method.params) {
          variables.remove(param.name);
        }
      }
    }
    code.append(tempCodeStorage); // Restore main code

    customObjects.put(className, customObj);
    CustomObjectGenerator.generateCustomObject(customObj);
    imports.add("#include \"" + className.toLowerCase() + ".hpp\"\n");

    // Clear field variables after processing the class
    for (FieldHolder field : customObj.fields) {
      variables.remove(field.name);
    }
    currentCustomObject = null;
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
      imports.add("#include <math.h> \n");
      return "pow(" + visit(ctx.atom_expr()) + "," + visit(ctx.unary_expr()) + ")";
    } else {
      return visit(ctx.atom_expr());
    }
  }

  @Override
  public String visitAtom_expr(MarsikParser.Atom_exprContext ctx) {
    if (ctx.method_call() != null) {
      return visit(ctx.method_call());
    }
    if (ctx.NAME() != null) {
      return ctx.NAME().getText();
    }
    if (ctx.INTEGER() != null) {
      return ctx.INTEGER().getText();
    }
    if (ctx.BABY_INTEGER() != null) {
      return ctx.BABY_INTEGER().getText();
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
    return Utils.generateC(imports, code.toString());
  }

  private static void compile(String srcPath, String outDir) throws IOException, InterruptedException {
    File sourceFile = new File(srcPath);
    File outputDir = new File(outDir);
    if (!outputDir.exists()) {
      outputDir.mkdirs();
    }
    // ----------------------------
    // 1. PARSE + C/CPP CODEGEN
    // ----------------------------
    CharStream input = CharStreams.fromFileName(sourceFile.getAbsolutePath());
    MarsikLexer lexer = new MarsikLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    MarsikParser parser = new MarsikParser(tokens);
    ParseTree tree = parser.program();
    Compiler compiler = new Compiler();
    CustomObjectGenerator.setOutputFolder(outputDir.getAbsolutePath());
    compiler.visit(tree);
    String cppCode = compiler.generateC();
    File cppFile = new File(outputDir, "generated.cpp");
    if (cppFile.exists()) {
      cppFile.delete();
    }
    try (FileWriter writer = new FileWriter(cppFile)) {
      writer.write(cppCode);
    }
    // ----------------------------
    // 2. BUILD CPP COMMAND
    // ----------------------------
    File exeFile = new File(outputDir, "app.exe");

    List<String> command = new ArrayList<>();
    command.add("C:\\Program Files\\gcc\\bin\\g++.exe");
    command.add(cppFile.getAbsolutePath());

    // add only used runtime sources (C files based on includes in generated code)
    File runtimeDir = new File(outputDir.getParent(), "runtime");
    if (runtimeDir.exists()) {
      Set<String> usedIncludes = extractUsedIncludes(cppFile);
      addUsedRuntimeSources(runtimeDir, usedIncludes, command);
      command.add("-I" + runtimeDir.getAbsolutePath());
    }
    addGeneratedObjectSources(command);
    command.add("-I" + outputDir.getAbsolutePath());
    command.add("-std=gnu++17");
    command.add("-static-libgcc");
    command.add("-static-libstdc++");
    command.add("-Wall");
    command.add("-O2");
    command.add("-o");
    command.add(exeFile.getAbsolutePath());

    System.out.println("Compiling using Command: \n" + String.join(" ", command));
    // ----------------------------
    // 3. RUN CPP COMMAND TO CREATE EXECUTABLE
    // ----------------------------
    ProcessBuilder pb = new ProcessBuilder(command);
    pb.redirectErrorStream(true);
    Process process = pb.start();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    }
    int exitCode = process.waitFor();
    if (exitCode == 0) {
      System.out.println("Compilation successful!");
    } else {
      System.out.println("Compilation failed! Exit code: " + exitCode);
    }
  }

  private static Set<String> extractUsedIncludes(File cppFile) throws IOException {
    Set<String> includes = new HashSet<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(cppFile))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.contains("#include")) {
          int startQuote = line.indexOf('"');
          int endQuote = line.lastIndexOf('"');
          if (startQuote >= 0 && endQuote > startQuote) {
            String include = line.substring(startQuote + 1, endQuote);
            includes.add(include);
          }
        }
      }
    }
    return includes;
  }

  private static void addUsedRuntimeSources(File runtimeDir, Set<String> usedIncludes, List<String> command) {
    Set<String> addedFiles = new HashSet<>();
    
    // Always include core runtime files
    addCoreRuntimeFile(runtimeDir, "error.cpp", command, addedFiles);
    addCoreRuntimeFile(runtimeDir, "allocator.cpp", command, addedFiles);
    
    // Add sources for all included headers
    for (String include : usedIncludes) {
      String headerName = include.contains("/") ? include.substring(include.lastIndexOf("/") + 1) : include;
      String sourceFileName = headerName.replace(".hpp", ".cpp").replace(".h", ".c");
      
      File sourceFile = findSourceFile(runtimeDir, sourceFileName);
      if (sourceFile != null && sourceFile.exists() && addedFiles.add(sourceFile.getAbsolutePath())) {
        command.add(sourceFile.getAbsolutePath());
      }
    }
  }

  private static void addGeneratedObjectSources(List<String> command) {
    for (String generatedFile : GeneratedFilesTracker.getGeneratedFilesSnapshot()) {
      if (generatedFile.endsWith(".cpp") || generatedFile.endsWith(".c")) {
        command.add(new File(generatedFile).getAbsolutePath());
      }
    }
  }

  private static void addCoreRuntimeFile(File runtimeDir, String fileName, List<String> command, Set<String> addedFiles) {
    File sourceFile = findSourceFile(runtimeDir, fileName);
    if (sourceFile != null && sourceFile.exists() && addedFiles.add(sourceFile.getAbsolutePath())) {
      command.add(sourceFile.getAbsolutePath());
    }
  }

  private static File findSourceFile(File dir, String fileName) {
    if (!dir.isDirectory()) {
      return null;
    }
    File[] files = dir.listFiles();
    if (files != null) {
      for (File file : files) {
        if (file.isFile() && file.getName().equals(fileName)) {
          return file;
        } else if (file.isDirectory()) {
          File found = findSourceFile(file, fileName);
          if (found != null) {
            return found;
          }
        }
      }
    }
    return null;
  }

  /**
   * Compiles all generated .c/c++ files in the out folder using g++;
   */
  static void main(String[] args) throws IOException, InterruptedException {

    compile("C:\\Marsik\\MarsikLang\\src\\main\\java\\org\\example\\tests\\testMath.marsik",
            "C:\\Marsik\\MarsikLang\\src\\main\\java\\org\\example\\out");
  }
}
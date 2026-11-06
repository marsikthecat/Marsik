package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.compiler.CustomObjectGenerator;
import org.example.compiler.CustomModuleGenerator;
import org.example.compiler.GeneratedFilesTracker;
import org.example.compiler.ModuleHolder;
import org.example.compiler.ObjectHolder;
import org.example.compiler.Utils;
import org.example.compiler.ValueHolder;
import org.example.compiler.generated.MarsikBaseVisitor;
import org.example.compiler.generated.MarsikLexer;
import org.example.compiler.generated.MarsikParser;

public class Compiler extends MarsikBaseVisitor<String> {

  public final HashMap<String, ValueHolder> variables = new HashMap<>();
  public final HashMap<String, ValueHolder> constants = new HashMap<>();
  public Path projectRoot = Path.of("").toAbsolutePath();
  private final Map<String, Path> availableHeadersForImports = new HashMap<>();
  public final StringBuilder code = new StringBuilder();
  private final StringBuilder functionDefinitions = new StringBuilder();
  private final StringBuilder functionDeclarations = new StringBuilder();
  public final Set<String> imports = new HashSet<>();
  public final HashMap<String, ObjectHolder> customObjects = new HashMap<>();
  public final HashMap<String, ModuleHolder> modules = new HashMap<>();
  private final Map<String, ModuleHolder> moduleAliases = new HashMap<>();
  private final Set<Path> importedSources = new HashSet<>();
  private final Set<Path> importingSources = new HashSet<>();
  public ObjectHolder currentCustomObject = null;
  private ModuleHolder currentModule = null;
  public boolean isObjectFile = false;

  @Override
  public String visitProgram(MarsikParser.ProgramContext ctx) {
    // Collect declarations first so static calls can be resolved in function bodies.
    for (var child : ctx.children) {
        switch (child) {
            case MarsikParser.Class_defContext classDef -> visitClass_def(classDef);
            case MarsikParser.Module_defContext moduleDef -> visitModule_def(moduleDef);
            default -> {
            }
        }
    }
    // Process executable statements after declarations are available.
    for (var child : ctx.children) {
      if (!(child instanceof MarsikParser.Class_defContext)
              && !(child instanceof MarsikParser.Module_defContext)
              && !(child instanceof org.antlr.v4.runtime.tree.TerminalNode)) {
        this.visit(child);
      }
    }
    return null;
  }

  @Override
  public String visitFunction_call(MarsikParser.Function_callContext ctx) {
    return ctx.NAME().getText() + "(" + renderArguments(ctx.arguments()) + ")";
  }

  @Override
  public String visitType_label(MarsikParser.Type_labelContext ctx) {
    return Utils.toCppType(ctx.getText());
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
    if (ctx.function_call() != null) {
      code.append(visit(ctx.function_call())).append(";\n");
    }
    return super.visitStmt(ctx);
  }

  @Override
  public String visitObject_stmt(MarsikParser.Object_stmtContext ctx) {
    boolean isAssignment = ctx.NAME().size() == 2;
    String variable;
    String objectType;
    String type = "";
    if (isAssignment) {
      variable = ctx.NAME(0).getText();
      objectType = ctx.NAME(1).getText();
      if (constants.containsKey(variable)) {
        throw new RuntimeException("Cannot assign to const: " + variable);
      }
      ValueHolder target = variables.get(variable);
      if (target == null) {
        throw new RuntimeException("Variable " + variable + " does not exist");
      }
      String declaredType = target.type;
      int genericStart = declaredType.indexOf('<');
      String declaredObjectType = genericStart < 0 ? declaredType : declaredType.substring(0, genericStart);
      if (!declaredObjectType.equals(objectType)) {
        throw new RuntimeException("Cannot assign " + objectType + " to " + declaredType);
      }
      if (genericStart >= 0) {
        type = declaredType.substring(genericStart);
      }
    } else {
      int newObjectIndex = ctx.NAME().size() - 1;
      variable = ctx.NAME(newObjectIndex - 1).getText();
      objectType = ctx.NAME(newObjectIndex).getText();
      type = ctx.getRuleContexts(MarsikParser.Type_labelContext.class).isEmpty()
              ? "" : "<" + ctx.getRuleContexts(MarsikParser.Type_labelContext.class).stream()
                      .map(ParseTree::getText).collect(java.util.stream.Collectors.joining(", ")) + ">";
      if (!ctx.NAME(0).getText().equals(objectType)) {
        throw new RuntimeException("Object " + ctx.NAME(0).getText() + " and " + objectType + " do not match");
      }
      if (Utils.isForbiddenName(variable)) {
        throw new RuntimeException("Name " + variable + " is forbidden for variable names");
      }
    }

    String parameters = renderArguments(ctx.arguments());
    String initializer = renderObjectInitializer(objectType, type, ctx.arguments());
    if (isAssignment) {
      code.append(variable).append(" = ").append(initializer).append(";\n");
      return null;
    }

    variables.put(variable, new ValueHolder(objectType + type, true));
    appendObjectInitialization(objectType, variable, type, parameters);
    return null;
  }

  private String renderObjectInitializer(String objectType, String type,
                                         MarsikParser.ArgumentsContext argumentsContext) {
    String arguments = renderArguments(argumentsContext);
    ObjectHolder customObject = customObjects.get(objectType);
    if (customObject != null) {
      int expectedArguments = customObject.hasConstructor
              ? customObject.constructorParameters.size() : 0;
      int actualArguments = argumentsContext == null ? 0 : argumentsContext.expr().size();
      if (actualArguments != expectedArguments) {
        throw new RuntimeException("Constructor for " + objectType + " expects "
                + expectedArguments + " arguments, got " + actualArguments);
      }
    } else {
      registerObject(objectType, !type.isEmpty());
    }
    return "init_" + objectType.toLowerCase() + type + "(" + arguments + ")";
  }

  private void appendObjectInitialization(String objectType, String variable,
                                          String type, String parameters) {
    code.append("struct ").append(objectType).append(" ").append(type)
            .append(variable).append(" = init_").append(objectType.toLowerCase()).append(type).append("(")
            .append(parameters).append(");\n");
  }

  private boolean registerObject(String objectType, boolean hasTypeLabel) {
    Path header = availableHeadersForImports.get(objectType.toLowerCase());
    if (header == null) {
        throw new RuntimeException("Unable to find compiled implementation of object: "
         + objectType);
    }
    if (Utils.buildInTypedObjects.contains(objectType) && !hasTypeLabel) {
        throw new RuntimeException("Type is not specified");
    }
    imports.add("#include \"" + header.toString().replace("\\", "/") + "\"\n");
    return Utils.buildInTypedObjects.contains(objectType);
  }

  @Override
  public String visitMethod_call(MarsikParser.Method_callContext ctx) {
    String target = ctx.NAME(0).getText();
    String method = ctx.NAME(1).getText();

    if (Utils.isBuiltInLibraryMethod(target, method)) {
      return visitBuiltInLibraryMethodCall(ctx, target, method);
    }

    ModuleHolder module = findModule(target);
    if (module != null) {
      ModuleHolder.Function moduleFunction = module.functions.stream()
              .filter(candidate -> candidate.name.equals(method))
              .findFirst()
              .orElseThrow(() -> new RuntimeException("Function " + method
                      + " not found in module " + module.name));
      if (ctx.arguments() != null
              && ctx.arguments().expr().size() != moduleFunction.parameters.size()) {
        throw new RuntimeException("Function " + method + " in module " + module.name + " expects "
                + moduleFunction.parameters.size() + " arguments, got "
                + ctx.arguments().expr().size());
      }
      addFunctionDeclaration(module, moduleFunction);
      return module.name.toLowerCase() + "_" + method
              + "(" + renderArguments(ctx.arguments()) + ")";
    }

    ObjectHolder classTarget = customObjects.get(target);
    if (classTarget != null) {
      ObjectHolder.Method classMethod = classTarget.methods.stream()
              .filter(candidate -> candidate.name.equals(method))
              .findFirst()
              .orElseThrow(() -> new RuntimeException("Function " + method
                      + " not found in class " + classTarget.name));
      if (!classMethod.isStatic) {
        throw new RuntimeException("Instance method " + method
                + " must be called on an object of class " + classTarget.name);
      }
      if (ctx.arguments() != null
              && ctx.arguments().expr().size() != classMethod.parameters.size()) {
        throw new RuntimeException("Static function " + method + " in class " + classTarget.name
                + " expects " + classMethod.parameters.size() + " arguments, got "
                + ctx.arguments().expr().size());
      }
      addObjectInclude(classTarget);
      return classTarget.name.toLowerCase() + "_" + method
              + "(" + renderArguments(ctx.arguments()) + ")";
    }

    Path classHeader = availableHeadersForImports.get(target.toLowerCase());
    if (classHeader != null && !variables.containsKey(target)) {
      String include = "#include \"" + classHeader.toString().replace("\\", "/") + "\"\n";
      imports.add(include);
      if (currentCustomObject != null) {
        currentCustomObject.requiredIncludes.add(include);
      }
      return target.toLowerCase() + "_" + method
              + "(" + renderArguments(ctx.arguments()) + ")";
    }

    ValueHolder targetValue = variables.get(target);
    if (targetValue == null) {
      throw new RuntimeException("Variable " + target + " does not exist");
    }
    String type = targetValue.type;
    String baseType = type.contains("<") ? type.substring(0, type.indexOf('<')) : type;
    ObjectHolder customObject = customObjects.get(baseType);
    if (customObject != null) {
      ObjectHolder.Method objectMethod = customObject.methods.stream()
              .filter(candidate -> candidate.name.equals(method))
              .findFirst()
              .orElse(null);
      if (objectMethod == null) {
        throw new RuntimeException("Method " + method + " not found in class " + customObject.name);
      }
      if (objectMethod.isStatic) {
        throw new RuntimeException("Static function " + method
                + " must be called on class " + customObject.name);
      }
    } else {
      if (baseType.equals("string") && !Utils.stringMethods.contains(method)) {
        throw new RuntimeException("Unknown method " + method + " for String: " + target);
      }
      if (baseType.equals("array") && !Utils.arrayMethods.contains(method)) {
        throw new RuntimeException("Unknown method " + method + " for Array: " + target);
      }
    }
    List<String> args = renderArgumentList(ctx.arguments());

    String joinedArgs = String.join(", ", args);
    return baseType.toLowerCase() + "_" + method + "(" + target
            + (joinedArgs.isEmpty() ? "" : ", " + joinedArgs) + ")";
  }

  private String visitBuiltInLibraryMethodCall(MarsikParser.Method_callContext ctx, String target, String method) {
    if (!Utils.multiEquals(target, "Math", "FileHandler", "DateTime", "Caster")) {
      throw new RuntimeException("Unknown builtin target: " + target);
    }
    String include = "#include \"../runtime/" + target.toLowerCase() + ".hpp\"\n";
    addRequiredInclude(include);
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
    String declaredType = ctx.type_label().getText();
    String runtimeType = declaredType.contains("<")
            ? declaredType.substring(0, declaredType.indexOf('<')) : declaredType;
    if (Utils.isForbiddenName(name)) {
      throw new RuntimeException("Name " + name + " is forbidden for variable names");
    }
    if (variables.containsKey(name)) {
      throw new RuntimeException("Variable " + name + " already exists");
    }
    if (ctx.type_label().NAME() != null && !customObjects.containsKey(runtimeType)) {
      registerObject(runtimeType, declaredType.contains("<"));
    }
    String type = Utils.toCppType(declaredType);
    if (ctx.scan_stmt() != null) {
      appendScanDeclaration(ctx.scan_stmt(), type, name);
      variables.put(name, new ValueHolder(runtimeType, true));
      return "";
    }

    String init = renderInitializer(ctx);
    if (init != null) {
      code.append(type).append(" ").append(name).append(" = ").append(init).append(";\n");
      variables.put(name, new ValueHolder(runtimeType, true));
    } else {
      code.append(type).append(" ").append(name).append(";\n");
      variables.put(name, new ValueHolder(runtimeType, false));
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
    if (Utils.isForbiddenName(name)) {
      throw new RuntimeException("Name " + name + " is forbidden for variable names");
    }
    String type = Utils.toCppType(ctx.type_label().getText());
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
    String typeLabel = ctx.type_label().getText();
    String name = ctx.NAME().getText();
    imports.add("#include \"../runtime/datastructures/array.hpp\"\n");

    if (ctx.method_call() != null) {
      variables.put(name, new ValueHolder("array", true));
      code.append("struct Array<").append(typeLabel).append("> ").append(name)
              .append(" = ").append(visit(ctx.method_call())).append(";\n");
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

    code.append("struct Array<").append(typeLabel).append("> ").append(name).append(" = {")
            .append(compoundLiteral).append(", ").append(size).append(", \"")
            .append(typeLabel).append("\"}").append(";\n");
    return null;
  }

  @Override
  public String visitFuncdef(MarsikParser.FuncdefContext ctx) {
    MarsikParser.Function_signatureContext signature = ctx.function_signature();
    String name = signature.NAME().getText();
    StringBuilder mainCode = new StringBuilder(code);
    code.setLength(0);
    try {
      String functionReturnType = signature.type_label() != null ?
       signature.type_label().getText() + " " : "void ";
      code.append("static ").append(functionReturnType)
          .append(name).append("(");
      if (signature.parameters() != null) {
        code.append(visit(signature.parameters()));
      }
      code.append(") ");
      functionDeclarations.append(code, 0, code.length() - 1).append(";\n");
      visit(ctx.block());
      functionDefinitions.append(code).append('\n');
    } finally {
      code.setLength(0);
      code.append(mainCode);
    }
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
    return type + "& " + name;
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
    ensureContainerNameIsAvailable(className);
    // Create custom object holder
    ObjectHolder customObj = new ObjectHolder(className);
    customObjects.put(className, customObj);
    currentCustomObject = customObj;
    // First pass: Process all fields to make them available in the scope
    for (var member : ctx.class_member()) {
      if (member.field_decl() != null) {
        ObjectHolder.Field field = new ObjectHolder.Field();
        field.type = member.field_decl().type_label().getText();
        field.name = member.field_decl().NAME().getText();
        field.isPublic = member.field_decl().getText().contains("public");
        field.isConst = member.field_decl().getText().contains("const");
        customObj.fields.add(field);

        // Add field to variables scope for method access
        variables.put(field.name, new ValueHolder(Utils.toCppType(field.type), true));
      }
    }
    // Second pass: Process all methods (without appending to main code)
    StringBuilder tempCodeStorage = new StringBuilder(code.toString());
    code.setLength(0); // Clear main code temporarily
    for (var member : ctx.class_member()) {
      if (member.method_decl() != null) {
        MarsikParser.Method_declContext methodCtx = member.method_decl();
        MarsikParser.Function_signatureContext signature = methodCtx.function_signature();
        customObj.methods.add(captureMethod(signature, methodCtx.block(), false,
                methodCtx.getText().startsWith("internal")));
      } else if (member.funcdef() != null) {
        MarsikParser.FuncdefContext functionCtx = member.funcdef();
        customObj.methods.add(captureMethod(functionCtx.function_signature(), functionCtx.block(),
                true, false));
      }
      if (member.constructor_decl() != null) {
        if (customObj.hasConstructor) {
          throw new RuntimeException("Class " + className + " can only have one constructor");
        }
        customObj.hasConstructor = true;
        MarsikParser.Constructor_declContext constructorCtx = member.constructor_decl();
        if (constructorCtx.parameters() != null) {
          for (var parameter : constructorCtx.parameters().parameter()) {
            String parameterName = parameter.NAME().getText();
            if (Utils.isForbiddenName(parameterName)) {
              throw new RuntimeException("Name " + parameterName + " is forbidden for constructor parameters");
            }
            if (customObj.fields.stream().anyMatch(field -> field.name.equals(parameterName))) {
              throw new RuntimeException("Constructor parameter " + parameterName
                      + " must have a different name from every field in " + className);
            }
            if (customObj.constructorParameters.stream()
                    .anyMatch(existing -> existing.name.equals(parameterName))) {
              throw new RuntimeException("Duplicate constructor parameter: " + parameterName);
            }
            customObj.constructorParameters.add(new ObjectHolder.Parameter(
                    parameter.type_label().getText(), parameterName));
            variables.put(parameterName, new ValueHolder(
                    Utils.toCppType(parameter.type_label().getText()), true));
          }
        }
        visitBlock(constructorCtx.block());
        customObj.constructorBody = code.toString();
        code.setLength(0);
        for (ObjectHolder.Parameter parameter : customObj.constructorParameters) {
          variables.remove(parameter.name);
        }
      }
    }
    code.append(tempCodeStorage); // Restore main code

    CustomObjectGenerator.generateCustomObject(customObj);
    imports.add("#include \"" + className.toLowerCase() + ".hpp\"\n");

    // Clear field variables after processing the class
    for (ObjectHolder.Field field : customObj.fields) {
      variables.remove(field.name);
    }
    currentCustomObject = null;
    isObjectFile = true;
    return null;
  }

  @Override
  public String visitModule_def(MarsikParser.Module_defContext ctx) {
    String moduleName = ctx.NAME().getText();
    ensureContainerNameIsAvailable(moduleName);
    ModuleHolder module = new ModuleHolder(moduleName);
    modules.put(moduleName, module);

    ObjectHolder previousCustomObject = currentCustomObject;
    ModuleHolder previousModule = currentModule;
    currentCustomObject = null;
    currentModule = module;
    StringBuilder previousCode = new StringBuilder(code);
    code.setLength(0);
    try {
      for (MarsikParser.FuncdefContext function : ctx.funcdef()) {
        module.functions.add(createModuleFunction(function.function_signature(), module));
      }
      for (int i = 0; i < ctx.funcdef().size(); i++) {
        captureModuleFunction(module.functions.get(i), ctx.funcdef(i).block());
      }
    } finally {
      code.setLength(0);
      code.append(previousCode);
      currentCustomObject = previousCustomObject;
      currentModule = previousModule;
    }

    CustomModuleGenerator.generateModule(module);
    isObjectFile = true;
    return null;
  }

  private ModuleHolder.Function createModuleFunction(
      MarsikParser.Function_signatureContext signature,
      ModuleHolder module) {
    String functionName = signature.NAME().getText();
    if (module.functions.stream().anyMatch(function -> function.name.equals(functionName))) {
      throw new IllegalArgumentException("Duplicate function " + functionName
              + " in module " + module.name);
    }

    ModuleHolder.Function function = new ModuleHolder.Function();
    function.name = functionName;
    function.returnType = signature.type_label() == null ? "void" : signature.type_label().getText();
    if (signature.parameters() != null) {
      for (MarsikParser.ParameterContext parameter : signature.parameters().parameter()) {
        String parameterName = parameter.NAME().getText();
        if (Utils.isForbiddenName(parameterName)) {
          throw new RuntimeException("Name " + parameterName + " is forbidden for function parameters");
        }
        function.parameters.add(new ModuleHolder.Parameter(
                parameter.type_label().getText(), parameterName));
      }
    }
    return function;
  }

  private void captureModuleFunction(ModuleHolder.Function function,
                                     MarsikParser.BlockContext block) {
    for (ModuleHolder.Parameter parameter : function.parameters) {
      variables.put(parameter.name, new ValueHolder(Utils.toCppType(parameter.type), true));
    }
    StringBuilder previousCode = new StringBuilder(code);
    code.setLength(0);
    try {
      visitBlock(block);
      function.body = code.toString();
    } finally {
      code.setLength(0);
      code.append(previousCode);
      for (ModuleHolder.Parameter parameter : function.parameters) {
        variables.remove(parameter.name);
      }
    }
  }

  private ObjectHolder.Method captureMethod(MarsikParser.Function_signatureContext signature,
                                             MarsikParser.BlockContext block,
                                             boolean isStatic, boolean isInternal) {
    String methodName = signature.NAME().getText();
    if (currentCustomObject.methods.stream().anyMatch(method -> method.name.equals(methodName))) {
      throw new IllegalArgumentException("Duplicate function " + methodName
              + " in " + currentCustomObject.name);
    }

    ObjectHolder.Method method = new ObjectHolder.Method();
    method.name = methodName;
    method.returnType = signature.type_label() == null ? "void" : signature.type_label().getText();
    method.isStatic = isStatic;
    method.isInternal = isInternal;

    if (signature.parameters() != null) {
      for (MarsikParser.ParameterContext parameter : signature.parameters().parameter()) {
        String parameterName = parameter.NAME().getText();
        if (Utils.isForbiddenName(parameterName)) {
          throw new RuntimeException("Name " + parameterName + " is forbidden for function parameters");
        }
        method.parameters.add(new ObjectHolder.Parameter(
                parameter.type_label().getText(), parameterName));
        variables.put(parameterName, new ValueHolder(
                Utils.toCppType(parameter.type_label().getText()), true));
      }
    }

    StringBuilder previousCode = new StringBuilder(code);
    code.setLength(0);
    try {
      visitBlock(block);
      method.body = code.toString();
    } finally {
      code.setLength(0);
      code.append(previousCode);
      for (ObjectHolder.Parameter parameter : method.parameters) {
        variables.remove(parameter.name);
      }
    }
    return method;
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
    if (ctx.function_call() != null) {
      return visit(ctx.function_call());
    }
    if (ctx.NAME() != null) {
      return ctx.NAME().getText();
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
    return Utils.generateC(imports, code.toString(), functionDeclarations.toString())
        + "\n" + functionDefinitions;
  }

  private void compile(String srcPath, String outDir) throws IOException, InterruptedException {
    Path sourcePath = Path.of(srcPath).toAbsolutePath().normalize();
    File sourceFile = sourcePath.toFile();
    File outputDir = new File(outDir);
    if (!outputDir.exists()) {
      outputDir.mkdirs();
    }
    Utils.addAllHeaderFiles(this.projectRoot, this.availableHeadersForImports);
    // ----------------------------
    // 1. PARSE + C/CPP CODEGEN
    // ----------------------------
    importedSources.clear();
    importingSources.clear();
    ParsedSource parsedSource = parseSource(sourcePath);
    CustomObjectGenerator.setOutputFolder(outputDir.getAbsolutePath());
    CustomModuleGenerator.setOutputFolder(outputDir.getAbsolutePath());
    if (!importingSources.add(sourcePath)) {
      throw new IllegalStateException("Entry source is already being imported: " + sourcePath);
    }
    try {
      processImports(parsedSource.imports(), sourcePath);
      importedSources.add(sourcePath);
    } finally {
      importingSources.remove(sourcePath);
    }
    this.visit(parsedSource.program());
    String cppCode = this.generateC();
    File cppFile = new File(outputDir, "generated.cpp");
    if (cppFile.exists()) {
      cppFile.delete();
    }
    try (FileWriter writer = new FileWriter(cppFile)) {
      writer.write(cppCode);
    }
    if (isObjectFile) return; // No executable for object files
    // ----------------------------
    // 2. BUILD CPP COMMAND
    // ----------------------------
    File exeFile = new File(outputDir, "app.exe");

    List<String> command = new ArrayList<>();
    command.add("C:\\Program Files\\gcc\\bin\\g++.exe");
    command.add(cppFile.getAbsolutePath());

    // add only used runtime sources (C files based on includes in generated code)
    File runtimeDir = new File(outputDir.getParent(), "runtime");
    if (!runtimeDir.exists()) {
      runtimeDir = new File("src/main/java/org/example/runtime");
    }
    if (runtimeDir.exists()) {
      List<File> translationUnits = new ArrayList<>();
      translationUnits.add(cppFile);
      try (Stream<Path> paths = Files.walk(outputDir.toPath())) {
        paths
          .filter(Files::isRegularFile)
          .filter(p -> p.toString().endsWith(".cpp"))
          .filter(p -> !p.toFile().equals(cppFile))
          .map(Path::toFile)
          .forEach(translationUnits::add);
      }
      for (String generatedFile : GeneratedFilesTracker.getGeneratedFilesSnapshot()) {
        if (generatedFile.endsWith(".cpp")) {
          File trackedFile = new File(generatedFile);
          if (translationUnits.stream().noneMatch(existing ->
                  existing.toPath().toAbsolutePath().normalize()
                          .equals(trackedFile.toPath().toAbsolutePath().normalize()))) {
            translationUnits.add(trackedFile);
          }
        }
      }
      Set<String> usedIncludes = extractUsedIncludes(translationUnits, runtimeDir, outputDir);
      addUsedRuntimeSources(runtimeDir, usedIncludes, command);
      command.add("-I" + runtimeDir.getAbsolutePath());
    }
    try (Stream<Path> paths = Files.walk(outputDir.toPath())) {
      paths
        .filter(Files::isRegularFile)
        .filter(p -> p.toString().endsWith(".cpp"))
        .filter(p -> !p.toFile().equals(cppFile))
        .forEach(p -> {
        addSourceFile(command, p.toFile());
        });
    }
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
                  System.out.println("Check out " + cppFile.getAbsolutePath() + " for intermediate representation");
              }
              case "warning" -> {
                  Utils.printWarning("[WARNING] marsik needs to tell you something: " + message + " in Line: " + lineNumber);
                  System.out.println("Check out " + cppFile.getAbsolutePath() + " for intermediate representation");
              }
          }
        }
      }
    }
    int exitCode = process.waitFor();
    if (exitCode == 0) {
      Utils.printSuccess("Compilation successful!");
    } else {
      Utils.printError("Compilation failed! Exit code: " + exitCode);
    }
  }

  private static Set<String> extractUsedIncludes(
      List<File> sourceFiles, File runtimeDir, File outputDir) throws IOException {
    Set<String> includes = new HashSet<>();
    Set<Path> scannedFiles = new HashSet<>();
    for (File sourceFile : sourceFiles) {
      collectUsedIncludes(sourceFile, runtimeDir, outputDir, includes, scannedFiles);
    }
    return includes;
  }

  private static void collectUsedIncludes(
      File sourceFile, File runtimeDir, File outputDir, Set<String> includes, Set<Path> scannedFiles)
      throws IOException {
    Path sourcePath = sourceFile.toPath().toAbsolutePath().normalize();
    if (!scannedFiles.add(sourcePath) || !sourceFile.isFile()) {
      return;
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.contains("#include")) {
          int startQuote = line.indexOf('"');
          int endQuote = line.lastIndexOf('"');
          if (startQuote >= 0 && endQuote > startQuote) {
            String include = line.substring(startQuote + 1, endQuote);
            includes.add(include);
            File includedFile = resolveInclude(include, sourceFile.getParentFile(), runtimeDir, outputDir);
            if (includedFile != null) {
              collectUsedIncludes(includedFile, runtimeDir, outputDir, includes, scannedFiles);
            }
          }
        }
      }
    }
  }

  private static File resolveInclude(String include, File includingDirectory, File runtimeDir, File outputDir) {
    File[] candidates = {
        new File(includingDirectory, include),
        new File(include),
        new File(runtimeDir, include),
        new File(outputDir, include)
    };
    for (File candidate : candidates) {
      if (candidate.isFile()) {
        return candidate;
      }
    }
    return null;
  }

  private static void addUsedRuntimeSources(File runtimeDir, Set<String> usedIncludes, List<String> command) {
    Set<String> addedFiles = new HashSet<>();
    
    // Always include core runtime files
    addCoreRuntimeFile(runtimeDir, "error.cpp", command, addedFiles);
    addCoreRuntimeFile(runtimeDir, "allocator.cpp", command, addedFiles);
    
    // Add sources for all included headers
    for (String include : usedIncludes) {
      String normalizedInclude = include.replace('\\', '/');
      String headerName = normalizedInclude.substring(normalizedInclude.lastIndexOf('/') + 1);
      String sourceFileName = headerName.replace(".hpp", ".cpp").replace(".h", ".c");
      
      File sourceFile = findSourceFile(runtimeDir, sourceFileName);
      if (sourceFile != null && sourceFile.exists() && addedFiles.add(sourceFile.getAbsolutePath())) {
        addSourceFile(command, sourceFile);
      }
    }
  }

  private static void addCoreRuntimeFile(File runtimeDir, String fileName, List<String> command, Set<String> addedFiles) {
    File sourceFile = findSourceFile(runtimeDir, fileName);
    if (sourceFile != null && sourceFile.exists() && addedFiles.add(sourceFile.getAbsolutePath())) {
      addSourceFile(command, sourceFile);
    }
  }

  private static void addSourceFile(List<String> command, File sourceFile) {
    Path sourcePath = sourceFile.toPath().toAbsolutePath().normalize();
    boolean alreadyAdded = command.stream()
            .filter(argument -> !argument.startsWith("-"))
            .map(argument -> Path.of(argument).toAbsolutePath().normalize())
            .anyMatch(sourcePath::equals);
    if (!alreadyAdded) {
      command.add(sourcePath.toString());
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
    MarsikParser.ImportsContext sourceImports = parser.imports();
    return new ParsedSource(sourceImports, parser.program());
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

  private void processImports(MarsikParser.ImportsContext sourceImports, Path importingFile)
      throws IOException {
    for (MarsikParser.Import_declContext importDecl : sourceImports.import_decl()) {
      String importPath = importDecl.STRING().getText();
      if (!importPath.endsWith(".marsik\"")) {
        throw new IllegalArgumentException("Imported file must have a .marsik extension: "
                + importPath);
      }
      Path importedPath = importingFile.getParent()
              .resolve(importPath.substring(1, importPath.length() - 1))
              .toAbsolutePath()
              .normalize();
      if (importedSources.contains(importedPath)) {
        continue;
      }
      if (!importingSources.add(importedPath)) {
        throw new IllegalArgumentException("Circular Marsik import: " + importedPath
                + " imported from " + importingFile);
      }

      try {
        ParsedSource importedSource = parseSource(importedPath);
        if (importedSource.program().class_def() == null
                && importedSource.program().module_def() == null) {
          throw new IllegalArgumentException("Imported Marsik source must define a class or module: "
                  + importedPath);
        }
        processImports(importedSource.imports(), importedPath);

        boolean wasObjectFile = isObjectFile;
        try {
          visit(importedSource.program());
        } finally {
          isObjectFile = wasObjectFile;
        }
        if (importedSource.program().module_def() != null) {
          String moduleAlias = importedPath.getFileName().toString();
          moduleAlias = moduleAlias.substring(0, moduleAlias.length() - ".marsik".length());
          ModuleHolder module = modules.get(importedSource.program().module_def().NAME().getText());
          ModuleHolder previousAlias = moduleAliases.putIfAbsent(moduleAlias.toLowerCase(), module);
          if (previousAlias != null && previousAlias != module) {
            throw new IllegalArgumentException("Module import name " + moduleAlias
                    + " is ambiguous in " + importingFile);
          }
        }
        importedSources.add(importedPath);
      } finally {
        importingSources.remove(importedPath);
      }
    }
  }

  private void addObjectInclude(ObjectHolder object) {
    String include = "#include \"" + object.name.toLowerCase() + ".hpp\"\n";
    imports.add(include);
    if (currentCustomObject != null && currentCustomObject != object) {
      currentCustomObject.requiredIncludes.add(include);
    }
    if (currentModule != null) {
      currentModule.requiredIncludes.add(include);
    }
  }

  private void addFunctionDeclaration(ModuleHolder owner, ModuleHolder.Function function) {
    StringBuilder declaration = new StringBuilder();
    declaration.append(Utils.toCppType(function.returnType)).append(' ')
            .append(owner.name.toLowerCase()).append('_').append(function.name).append('(');
    for (int i = 0; i < function.parameters.size(); i++) {
      ModuleHolder.Parameter parameter = function.parameters.get(i);
      if (i > 0) {
        declaration.append(", ");
      }
      declaration.append(Utils.toCppType(parameter.type)).append(' ').append(parameter.name);
      Path parameterHeader = availableHeadersForImports.get(parameter.type.toLowerCase());
      if (parameterHeader != null) {
        addRequiredInclude("#include \"" + parameterHeader.toString().replace("\\", "/") + "\"\n");
      }
    }
    declaration.append(");");
    Path returnHeader = availableHeadersForImports.get(function.returnType.toLowerCase());
    if (returnHeader != null) {
      addRequiredInclude("#include \"" + returnHeader.toString().replace("\\", "/") + "\"\n");
    }
    String functionDeclaration = declaration.toString();
    if (currentModule != null) {
      currentModule.requiredDeclarations.add(functionDeclaration);
    } else {
      functionDeclarations.append(functionDeclaration).append('\n');
    }
    if (currentCustomObject != null) {
      currentCustomObject.requiredDeclarations.add(functionDeclaration);
    }
  }

  private void ensureContainerNameIsAvailable(String name) {
    if (customObjects.containsKey(name) || modules.containsKey(name)) {
      throw new IllegalArgumentException("Duplicate class or module name: " + name);
    }
  }

  private ModuleHolder findModule(String name) {
    ModuleHolder module = modules.get(name);
    return module != null ? module : moduleAliases.get(name.toLowerCase());
  }

  private void addRequiredInclude(String include) {
    imports.add(include);
    if (currentCustomObject != null) {
      currentCustomObject.requiredIncludes.add(include);
    }
    if (currentModule != null) {
      currentModule.requiredIncludes.add(include);
    }
  }
}
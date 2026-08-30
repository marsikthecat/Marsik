package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.compiler.*;
import org.example.org.example.MarsikBaseVisitor;
import org.example.org.example.MarsikLexer;
import org.example.org.example.MarsikParser;

/**
 * Transforms marsik-code into java code and inserts it in a file.
 */
public class Compiler extends MarsikBaseVisitor<String> {

  public final HashMap<String, ValueHolder> variables = new HashMap<>();
  public final HashMap<String, ValueHolder> constants = new HashMap<>();
  public final StringBuilder code = new StringBuilder();
  public final Set<String> imports = new HashSet<>();
  public final HashMap<String, CustomObjectHolder> customObjects = new HashMap<>();
  public CustomObjectHolder currentCustomObject = null;
  public ClassHolder currentClass = null;

  @Override
  public String visitProgram(MarsikParser.ProgramContext ctx) {
    // First pass: collect all custom object definitions
    for (var child : ctx.children) {
      if (child instanceof MarsikParser.Class_defContext) {
        visitClass_def((MarsikParser.Class_defContext) child);
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
    return toCppType(ctx.getText());
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
    String objectType = ctx.NAME(0).getText();
    String variable = ctx.NAME(1).getText();
    String newObjectName = ctx.NAME(2).getText();
    boolean isTyped = false;
    if (objectType.equals(newObjectName)) {
      // Check if it's a custom object
      if (customObjects.containsKey(objectType)) {
        variables.put(variable, new ValueHolder(objectType, true));
        // Get arguments and convert them properly
        List<String> args = new ArrayList<>();
        if (ctx.arguments() != null) {
          for (var e : ctx.arguments().expr()) {
            args.add(visit(e));
          }
        }
        String parameters = String.join(", ", args);

        code.append("struct ").append(objectType).append(" ").append(variable).append(" = init_")
                .append(objectType.toLowerCase()).append("(").append(parameters).append(");\n");
      } else {

        if (Utils.buildInTypedObjects.contains(objectType)) {
          if (ctx.type_label() != null) {
            StringBuilder importString = new StringBuilder("#include \"../runtime/datastructures/");
            if (objectType.equals("AvlTree") || objectType.equals("BinaryTree") || objectType.equals("TreeNode")) {
              importString.append("trees/");
            }
            importString.append(objectType.toLowerCase()).append(".hpp\"\n");
            imports.add(importString.toString());
            isTyped = true;
          } else {
            throw new RuntimeException("Type is not specified");
          }
        } else if (Utils.getBuildInUnTypedObjects.contains(objectType)) {
            StringBuilder importString = new StringBuilder("#include \"");
            if (objectType.equals("Edge") || objectType.equals("Graph") || objectType.equals("Node")) {
              importString.append("../runtime/datastructures/graphs/");
            } else if (objectType.equals("Matrix")) {
              importString.append("../runtime/extra/");
            } else {
              importString.append("../runtime/datastructures/");
            }
            importString.append(objectType.toLowerCase()).append(".hpp\"\n");
            imports.add(importString.toString());
          } else {
            throw new RuntimeException("Unknown Type of Elements detected");
          }
      }
      variables.put(variable, new ValueHolder(objectType, true));
      List<String> args = new ArrayList<>();
      if (ctx.arguments() != null) {
        for (var e : ctx.arguments().expr()) {
          args.add(visit(e));
        }
      }
      String parameters = String.join(", ", args);
      String type = isTyped ? "<" + ctx.type_label().getText() + ">" : "";
      code.append("struct ").append(objectType).append(type)
              .append(variable).append(" = init_").append(objectType.toLowerCase()).append(type).append("(")
              .append(parameters).append(");\n");
    } else {
      throw new RuntimeException("Object " + objectType + " and " + newObjectName + " do not match");
    }
    return null;
  }

  @Override
  public String visitMethod_call(MarsikParser.Method_callContext ctx) {
    String target = ctx.NAME(0).getText();
    String method = ctx.NAME(1).getText();

    if (isBuiltInLibraryMethod(target, method)) {
      return visitBuiltInLibraryMethodCall(ctx, target, method);
    }
    if (variables.containsKey(target) && customObjects.containsKey(variables.get(target).type)) {
      CustomObjectHolder customObject = customObjects.get(variables.get(target).type);
      boolean methodFound = false;
      for (MethodHolder m : customObject.methods) {
        if (m.name.equals(method)) {
          methodFound = true;
          break;
        }
      }
      if (!methodFound) {
        throw new RuntimeException("Method " + method + " not found in class " + customObject.name);
      }
    } else {
      if (!variables.containsKey(target)) {
        throw new RuntimeException("Variable " + target + " does not exist");
      } else {
        String type = variables.get(target).type;
        if (type.equals("string") && !Utils.stringMethods.contains(method)) {
          throw new RuntimeException("Unknown method " + method + " for String: " + target);
        }
        if (type.equals("array") && !Utils.arrayMethods.contains(method)) {
          throw new RuntimeException("Unknown method " + method + " for Array: " + target);
        }
      }
    }
    List<String> args = new ArrayList<>();
    if (ctx.arguments() != null) {
      for (var e : ctx.arguments().expr()) {
        args.add(visit(e));
      }
    }

    if (variables.containsKey(target) && variables.get(target).type.equals("string") && method.equals("reverse")) {
      return "std::string(" + target + ".rbegin(), " + target + ".rend())";
    }

    // Check if target is a built-in object and format method name accordingly
    String methodPrefix = "";
    if (variables.containsKey(target)) {
      String type = variables.get(target).type;
      if (customObjects.containsKey(type)) {
        String joinedArgs = String.join(", ", args);
        return type.toLowerCase() + "_" + method + "(&" + target
                + (joinedArgs.isEmpty() ? "" : ", " + joinedArgs) + ")";
      }
      // Apply naming convention: [objecttype]_[method] for built-in objects
      if (Utils.buildInTypedObjects.contains(type) || Utils.getBuildInUnTypedObjects.contains(type) || type.equals("array")) {
        methodPrefix = type.toLowerCase() + "_";
      }
      if (Utils.stringMethods.contains(type) || type.equals("string")) {
        methodPrefix =  "str_";
      }
    }

    String joinedArgs = String.join(", ", args);
    return methodPrefix + method + "(" + target + (joinedArgs.isEmpty() ? "" : ", " + joinedArgs) + ")";
  }


  private boolean isBuiltInLibraryMethod(String target, String method) {
    return Utils.libraryMethodsLookup.containsKey(target)
            && Utils.libraryMethodsLookup.get(target).contains(method);
  }

  private String visitBuiltInLibraryMethodCall(MarsikParser.Method_callContext ctx,
                                               String target, String method) {
    switch (target) {
      case "Math" -> imports.add("#include \"../runtime/math.hpp\"\n");
      case "FileHandler" -> imports.add("#include \"../runtime/filehandler.hpp\"\n");
      case "DateTime" -> imports.add("#include \"../runtime/datetime.hpp\"\n");
      case "Crypto" -> imports.add("#include \"../runtime/crypto.hpp\"\n");
      case "Caster" -> imports.add("#include \"../runtime/caster.hpp\"\n");
      default -> throw new RuntimeException("Unknown builtin target: " + target);
    }
    List<String> args = new ArrayList<>();
    if (ctx.arguments() != null) {
      for (var e : ctx.arguments().expr()) {
        args.add(renderBuiltInArgument(target, e));
      }
    }
    return method + "(" + String.join(", ", args) + ")";
  }

  private String renderBuiltInArgument(String target, MarsikParser.ExprContext expr) {
    String rendered = visit(expr);
    String rawText = expr.getText();
    if ((target.equals("FileHandler") || target.equals("Crypto") || target.equals("DateTime")
            || target.equals("Caster") || target.equals("Math")) && variables.containsKey(rawText)) {
      variables.get(rawText);
    }
    return rendered;
  }

  @Override
  public String visitVar_decl(MarsikParser.Var_declContext ctx) {
    String name = ctx.NAME().getText();
    if (variables.containsKey(name)) {
      throw new RuntimeException("Variable " + name + " already exists");
    }
    String type = ctx.type_label().getText();
    if (type.equals("boolean")) {
      type = "bool";
    }
    if (type.equals("baby_int")) {
      imports.add("#include \"stdint.h\"\n");
      type = "uint8_t";
    }
    if (ctx.scan_stmt() != null) {
      code.append(type).append(" ").append(name).append(";\n");
      code.append("std::cout");
      for (MarsikParser.Print_argContext arg : ctx.scan_stmt().print_arg()) {
        code.append(" << ");
        if (arg.STRING() != null) {
          code.append(arg.STRING().getText());
        } else {
          code.append(visit(arg.expr()));
        }
      }
      code.append(";\n");
      code.append("std::cin >> ").append(name).append(";\n");
      return "";
    }
    String init = ctx.expr() != null ? visit(ctx.expr()) : ctx.type() != null
            ? ctx.type().getText() : ctx.method_call() != null ? visit(ctx.method_call()) : null;
    if (init != null) {
      // Initializing variable and assigning value
      if (ctx.type() != null && checkCorrectValueForLiteral(ctx.type_label(), ctx.type())) {
        // Check if atomic primitive datatype matches literal
        throw new RuntimeException("Literal " + ctx.type_label().getText()
                + " does not match Value " + ctx.type().getText());
      }
      code.append(type).append(" ").append(name).append(" = ").append(init).append(";\n");
      variables.put(name, new ValueHolder(type, true));
    } else {
      // Initializing variable without value
      code.append(type).append(" ").append(name).append(";\n");
      variables.put(name, new ValueHolder(type, false));
    }
    return null;
  }

  private boolean checkCorrectValueForLiteral(MarsikParser.Type_labelContext typeLabelContext,
                                              MarsikParser.TypeContext type) {
    if (typeLabelContext.STRING_TYPE() != null) {
      return type.STRING() == null;
    } else if (typeLabelContext.BOOL_TYPE() != null) {
      return type.BOOLEAN() == null;
    } else if (typeLabelContext.INT_TYPE() != null) {
      return type.INTEGER() == null;
    } else if (typeLabelContext.DOUBLE_TYPE() != null) {
      return type.DOUBLE() == null;
    } else if (typeLabelContext.CHAR_TYPE() != null) {
      return type.CHAR() == null;
    } else if (typeLabelContext.BABY_INT_TYPE() != null) {
      // Accept both BABY_INTEGER and INTEGER tokens for baby_int type
      // BABY_INTEGER matches 1-255, but INTEGER may also be used for values in that range
      return type.BABY_INTEGER() == null && type.INTEGER() == null;
    } else {
      return false;
    }
  }

  @Override
  public String visitConst_decl(MarsikParser.Const_declContext ctx) {
    String name = ctx.NAME().getText();
    if (constants.containsKey(name)) {
      throw new RuntimeException("Constant " + name + " already exists");
    }
    String type = ctx.type_label().getText();
    if (type.equals("boolean")) {
      type = "bool";
    }
    if (type.equals("baby_int")) {
      imports.add("#include \"stdint.h\"\n");
      type = "uint8_t";
    }
    String value = ctx.type().getText();
    if (checkCorrectValueForLiteral(ctx.type_label(), ctx.type())) {
      throw new RuntimeException("Literal " + ctx.type_label().getText()
              + " does not match Value " + ctx.type().getText());
    }
    code.append("const ").append(type).append(" ").append(name)
            .append(" = ").append(value).append(";\n");
    constants.put(name, new ValueHolder(type, true));
    return null;
  }

  @Override
  public String visitAssign_stmt(MarsikParser.Assign_stmtContext ctx) {
    String name = ctx.NAME().getText();
    String value = ctx.type() != null ? ctx.type().getText()
            : ctx.expr() != null ? visit(ctx.expr())
            : visit(ctx.method_call());
    if (constants.containsKey(name)) {
      throw new RuntimeException("Cannot assign to const: " + name);
    }
    // Check if variable exists
    if (!variables.containsKey(name)) {
      throw new RuntimeException("Variable " + name + " does not exist");
    }
    String type = variables.get(name).getType();
    if (ctx.type() != null) {
      if (type.equals("string") && ctx.type().STRING() == null) {
        throw new RuntimeException("Value " + ctx.type().getText() + "does not match String");
      } else if (type.equals("int") && ctx.type().INTEGER() == null) {
        throw new RuntimeException("Value " + ctx.type().getText() + "does not match Integer");
      } else if (type.equals("double") && ctx.type().DOUBLE() == null) {
        throw new RuntimeException("Value " + ctx.type().getText() + "does not match Double");
      } else if (type.equals("bool") && ctx.type().BOOLEAN() == null) {
        throw new RuntimeException("Value " + ctx.type().getText() + "does not match Boolean");
      } else if (type.equals("char") && ctx.type().CHAR() == null) {
        throw new RuntimeException("Value " + ctx.type().getText() + "does not match Character");
      } else if (type.equals("baby_int") && ctx.type().BABY_INTEGER() == null && ctx.type().INTEGER() == null) {
        throw new RuntimeException("Value " + ctx.type().getText() + "does not match Baby Integer");
      }
    }
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
    for (int i = 0; i < size; i++) {
      if (typeLabel.equals("string") && ctx.type(i).STRING() == null ||
          typeLabel.equals("int") && ctx.type(i).INTEGER() == null ||
          typeLabel.equals("double") && ctx.type(i).DOUBLE() == null ||
          typeLabel.equals("bool") && ctx.type(i).BOOLEAN() == null ||
          typeLabel.equals("char") && ctx.type(i).CHAR() == null ||
          typeLabel.equals("baby_int") && ctx.type(i).BABY_INTEGER() == null) {
        throw new RuntimeException("Array element " + ctx.type(i).getText() + " does not match " + typeLabel);
      }
    }
    String name = ctx.NAME().getText();
    variables.put(name, new ValueHolder("array", true));

    StringBuilder compoundLiteral = new StringBuilder();
    compoundLiteral.append("{");
    for (int i = 0; i < ctx.type().size() - 1; i++) {
      compoundLiteral.append(ctx.type().get(i).getText()).append(",");
    }
    compoundLiteral.append(ctx.type().getLast().getText()).append("}");

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

  private String toCppType(String marsikType) {
    return switch (marsikType) {
      case "boolean" -> "bool";
      case "baby_int" -> {
        imports.add("#include <stdint.h>\n");
        yield "uint8_t";
      }
      default -> marsikType;
    };
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
    StringBuilder cpp = new StringBuilder("std::cout");
    for (MarsikParser.Print_argContext arg : ctx.print_arg()) {
      cpp.append(" << ");
      if (arg.STRING() != null) {
        cpp.append(arg.STRING().getText());
      } else {
        cpp.append(visit(arg.expr()));
      }
    }
    cpp.append(";\n");
    return cpp.toString();
  }

  @Override
  public String visitPrintln_stmt(MarsikParser.Println_stmtContext ctx) {
    StringBuilder cpp = new StringBuilder("std::cout");
    for (MarsikParser.Print_argContext arg : ctx.print_arg()) {
      cpp.append(" << ");
      if (arg.STRING() != null) {
        cpp.append(arg.STRING().getText());
      } else {
        cpp.append(visit(arg.expr()));
      }
    }
    cpp.append("<< '\\n';\n");
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
        variables.put(field.name, new ValueHolder(toCppType(field.type), true));
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
            variables.put(p.NAME().getText(), new ValueHolder(toCppType(p.type_label().getText()), true));
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
  public String visitField_decl(MarsikParser.Field_declContext ctx) {
    FieldHolder f = new FieldHolder();
    f.type = ctx.type_label().getText();
    f.name = ctx.NAME().getText();
    f.isPublic = ctx.getText().contains("public");
    f.isConst = ctx.getText().contains("const");
    currentClass.fields.add(f);
    return null;
  }

  @Override
  public String visitMethod_decl(MarsikParser.Method_declContext ctx) {
    MethodHolder m = new MethodHolder();
    m.name = ctx.NAME().getText();
    m.isInternal = ctx.getText().startsWith("internal");
    m.returnType = ctx.type_label() != null ? ctx.type_label().getText() : "void";
    if (ctx.parameters() != null) {
      for (var p : ctx.parameters().parameter()) {
        m.params.add(new ParamHolder(
                p.type_label().getText(),
                p.NAME().getText()
        ));
      }
    }
    m.body = visitBlock(ctx.block());
    currentClass.methods.add(m);
    return null;
  }

  @Override
  public String visitExpr(MarsikParser.ExprContext ctx) {
    return super.visitExpr(ctx);
  }

  @Override
  public String visitOr_expr(MarsikParser.Or_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.and_expr(0)));
    for (int i = 1; i < ctx.and_expr().size(); i++) {
      result.append(" || ").append(visit(ctx.and_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitAnd_expr(MarsikParser.And_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.equality_expr(0)));
    for (int i = 1; i < ctx.equality_expr().size(); i++) {
      result.append(" && ").append(visit(ctx.equality_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitEquality_expr(MarsikParser.Equality_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.relational_expr(0)));
    for (int i = 1; i < ctx.relational_expr().size(); i++) {
      result.append(" ").append(ctx.getChild(1).getText()).append(" ")
              .append(visit(ctx.relational_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitRelational_expr(MarsikParser.Relational_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.additive_expr(0)));
    for (int i = 1; i < ctx.additive_expr().size(); i++) {
      result.append(" ").append(ctx.getChild(1).getText()).append(" ")
              .append(visit(ctx.additive_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitAdditive_expr(MarsikParser.Additive_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.multiplicative_expr(0)));
    for (int i = 1; i < ctx.multiplicative_expr().size(); i++) {
      result.append(" ").append(ctx.getChild(1).getText()).append(" ")
              .append(visit(ctx.multiplicative_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitMultiplicative_expr(MarsikParser.Multiplicative_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.unary_expr(0)));
    for (int i = 1; i < ctx.unary_expr().size(); i++) {
      result.append(" ").append(ctx.getChild(1).getText()).append(" ")
              .append(visit(ctx.unary_expr(i)));
    }
    return result.toString();
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

  /**
   * Generates full C/C++ code.
   */
  public String generateC() {
    StringBuilder importsAsString = new StringBuilder();
    for (String anImport : imports) {
      importsAsString.append(anImport);
    }
    return
            """
            #include <iostream>
            #include <stdbool.h>
            #include <string>
            #include "stringUtils.hpp"
            %s
           
            int main() {
              %s
              std::cout << "Press ENTER to exit...";
              std::cin.get();
              return 0;
            }
            """.formatted(importsAsString, code.toString());
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
    try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(process.getInputStream()))) {
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

   /* compile("C:\\Marsik\\MarsikLang\\src\\main\\java\\org\\example\\tests\\testString.marsik",
            "C:\\Marsik\\MarsikLang\\src\\main\\java\\org\\example\\out");*/

    compile("C:\\Marsik\\MarsikLang\\src\\main\\java\\org\\example\\tests\\datastructureTests\\testList.marsik",
            "C:\\Marsik\\MarsikLang\\src\\main\\java\\org\\example\\out");
  }
}
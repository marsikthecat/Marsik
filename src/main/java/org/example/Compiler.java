package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
import org.example.utils.FileHandler;
import org.example.compiler.CustomObjectGenerator;

/**
 * Transforms marsik-code into java code and inserts it in a file.
 */
public class Compiler extends org.example.MarsikBaseVisitor<String> {

  public final HashMap<String, ValueHolder> variables = new HashMap<>();
  public final HashMap<String, ValueHolder> constants = new HashMap<>();
  public final StringBuilder code = new StringBuilder();
  public final Set<String> imports = new HashSet<>();
  public final HashMap<String, CustomObjectHolder> customObjects = new HashMap<>();
  private ClassHolder currentClass;
  private CustomObjectHolder currentCustomObject; // Track current custom object for 'this' access

  @Override
  public String visitProgram(org.example.MarsikParser.ProgramContext ctx) {
    // First pass: collect all custom object definitions
    for (var child : ctx.children) {
      if (child instanceof org.example.MarsikParser.Class_defContext) {
        visitClass_def((org.example.MarsikParser.Class_defContext) child);
      }
    }

    // Second pass: process statements
    for (var child : ctx.children) {
      if (!(child instanceof org.example.MarsikParser.Class_defContext)) {
        this.visit(child);
      }
    }
    return null;
  }

  @Override
  public String visitType_label(org.example.MarsikParser.Type_labelContext ctx) {
    return super.visitType_label(ctx);
  }

  @Override
  public String visitStmt(org.example.MarsikParser.StmtContext ctx) {
    if (ctx.print_stmt() != null) {
      code.append(visit(ctx.print_stmt()));
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
  public String visitObject_stmt(org.example.MarsikParser.Object_stmtContext ctx) {
    String objectType = ctx.NAME(0).getText();
    String variable = ctx.NAME(1).getText();
    String newObjectName = ctx.NAME(2).getText();

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
      } else if (Utils.buildInObjectsDatastructures.contains(objectType)) {
        // Handle built-in objects
        if (ctx.type_label() != null && !objectType.equals("BitSet")) {
          imports.add("#include \"../runtime/datastructures/" + objectType.toLowerCase() + ".h\"\n");
        }  else if (objectType.equals("Alert")) {
          imports.add("#include \"../runtime/dialogs/alert.h\"\n");
        }  else if (objectType.equals("Dialog")) {
          imports.add("#include \"../runtime/dialogs/dialog.h\"\n");
        } else {
          throw new RuntimeException("Unknown Type of Elements detected");
        }
        variables.put(variable, new ValueHolder(objectType, true));

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
        throw new RuntimeException("Unknown object type: " + objectType);
      }
    } else {
      throw new RuntimeException("Object " + objectType + " and " + newObjectName + " do not match");
    }
    return null;
  }

  @Override
  public String visitMethod_call(org.example.MarsikParser.Method_callContext ctx) {
    String target = ctx.NAME(0).getText();
    String method = ctx.NAME(1).getText();

    if (isBuiltInLibraryMethod(target, method)) {
      return visitBuiltInLibraryMethodCall(ctx, target, method);
    }
    if (currentClass != null) {
      boolean methodFound = false;
      for (MethodHolder m : currentClass.methods) {
        if (m.name.equals(method)) {
          methodFound = true;
          break;
        }
      }
      if (!methodFound) {
        throw new RuntimeException("Method " + method + " not found in class " + currentClass.name);
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

    // Check if target is a built-in object and format method name accordingly
    String methodPrefix = "";
    if (variables.containsKey(target)) {
      String type = variables.get(target).type;
      // Apply naming convention: [objecttype]_[method] for built-in objects
      if (Utils.buildInObjectsDatastructures.contains(type) || type.equals("array")) {
        methodPrefix = type.toLowerCase() + "_";
      }
    }

    String joinedArgs = String.join(", ", args);
    return methodPrefix + method + "(&" + target + (joinedArgs.isEmpty() ? "" : ", " + joinedArgs) + ")";
  }


  private boolean isBuiltInLibraryMethod(String target, String method) {
    return Utils.libraryMethodsLookup.containsKey(target)
            && Utils.libraryMethodsLookup.get(target).contains(method);
  }

  private String visitBuiltInLibraryMethodCall(org.example.MarsikParser.Method_callContext ctx,
                                               String target, String method) {
    switch (target) {
      case "Math" -> imports.add("#include \"../runtime/math.h\"\n");
      case "FileHandler" -> imports.add("#include \"../runtime/filehandler.h\"\n");
      case "DateTime" -> imports.add("#include \"../runtime/datetime.h\"\n");
      case "Crypto" -> imports.add("#include \"../runtime/crypto.h\"\n");
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

  private String renderBuiltInArgument(String target, org.example.MarsikParser.ExprContext expr) {
    String rendered = visit(expr);
    String rawText = expr.getText();
    if ((target.equals("FileHandler") || target.equals("Crypto") || target.equals("DateTime"))
            && variables.containsKey(rawText)
            && "string".equals(variables.get(rawText).type)) {
      return "&" + rendered;
    }
    return rendered;
  }

  @Override
  public String visitVar_decl(org.example.MarsikParser.Var_declContext ctx) {
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
      code.append("printf(").append(ctx.scan_stmt().STRING().getText()).append(");\n");
      String formatSpecifier = switch (type) {
        case "bool" -> "%i";
        case "int" -> "%d";
        case "double" -> "%f";
        case "char" -> "%c";
        case "string" -> "%s";
        case "uint8_t" -> "%u";
        default -> throw new RuntimeException("Only primitive Types are supported for user input");
      };
      code.append("scanf(\"").append(formatSpecifier).append("\", &").append(name).append(");\n");
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
      String strInit = shouldWrapStringInitialization(type, ctx.type(), ctx.method_call())
              ? "init(" + init + ")" : init;
      code.append(type).append(" ").append(name).append(" = ").append(strInit).append(";\n");
      variables.put(name, new ValueHolder(type, true));
    } else {
      // Initializing variable without value
      code.append(type).append(" ").append(name).append(";\n");
      variables.put(name, new ValueHolder(type, false));
    }
    return null;
  }

  private boolean checkCorrectValueForLiteral(org.example.MarsikParser.Type_labelContext typeLabelContext,
                                              org.example.MarsikParser.TypeContext type) {
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
  public String visitConst_decl(org.example.MarsikParser.Const_declContext ctx) {
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
  public String visitAssign_stmt(org.example.MarsikParser.Assign_stmtContext ctx) {
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
    // Check if value matches literal
    // Example:
    // int a
    // a = 5 <- Correct
    // a = "5" <- RuntimeException, because it's string and not int
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

  private boolean shouldWrapStringInitialization(String type,
                                                 org.example.MarsikParser.TypeContext literalValue,
                                                 org.example.MarsikParser.Method_callContext methodCall) {
    return type.equals("string") && literalValue != null && literalValue.STRING() != null && methodCall == null;
  }

  @Override
  public String visitArray_decl(org.example.MarsikParser.Array_declContext ctx) {
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
    compoundLiteral.append("(").append(typeLabel).append("[]){");
    for (int i = 0; i < ctx.type().size() - 1; i++) {
      compoundLiteral.append(ctx.type().get(i).getText()).append(",");
    }
    compoundLiteral.append(ctx.type().getLast().getText()).append("}");

    imports.add("#include \"../runtime/datastructures/array.h\"\n");
    code.append("struct Array ").append(name).append(" = {")
            .append(compoundLiteral).append(", sizeof(").append(typeLabel)
            .append("), ").append(size).append(", ").append(typeLabel.toUpperCase()).append("};\n");
    return null;
  }

  @Override
  public String visitFuncdef(org.example.MarsikParser.FuncdefContext ctx) {
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
  public String visitParameters(org.example.MarsikParser.ParametersContext ctx) {
    List<String> params = new ArrayList<>();
    for (org.example.MarsikParser.ParameterContext p : ctx.parameter()) {
      params.add(visit(p));
    }
    return String.join(", ", params);
  }

  @Override
  public String visitParameter(org.example.MarsikParser.ParameterContext ctx) {
    String type = visit(ctx.type_label());
    String name = ctx.NAME().getText();
    return type + " " + name;
  }

  @Override
  public String visitIf_stmt(org.example.MarsikParser.If_stmtContext ctx) {
    code.append("if (").append(visit(ctx.expr())).append(") ");
    visit(ctx.block(0));
    if (ctx.ELSE() != null) {
      code.append(" else ");
      visit(ctx.block(1));
    }
    return null;
  }

  @Override
  public String visitWhile_stmt(org.example.MarsikParser.While_stmtContext ctx) {
    String cond = visit(ctx.expr());
    code.append("while (").append(cond).append(") ");
    visit(ctx.block());
    return null;
  }

  @Override
  public String visitBlock(org.example.MarsikParser.BlockContext ctx) {
    code.append("{\n");
    visitChildren(ctx);
    code.append("}\n");
    return null;
  }

  @Override
  public String visitFor_stmt(org.example.MarsikParser.For_stmtContext ctx) {
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
  public String visitFor_update(org.example.MarsikParser.For_updateContext ctx) {
    return ctx.inc_stmt() != null ? ctx.inc_stmt().getText() : ctx.dec_stmt().getText();
  }

  @Override
  public String visitInc_stmt(org.example.MarsikParser.Inc_stmtContext ctx) {
    String name = ctx.NAME().getText();
    if (ctx.INTEGER() != null) {
      code.append(name).append("+=").append(ctx.INTEGER().getText()).append(";\n");
    } else {
      code.append(name).append("++").append(";\n");
    }
    return null;
  }

  @Override
  public String visitDec_stmt(org.example.MarsikParser.Dec_stmtContext ctx) {
    String name = ctx.NAME().getText();
    if (ctx.INTEGER() != null) {
      code.append(name).append("-=").append(ctx.INTEGER().getText()).append(";\n");
    }  else {
      code.append(name).append("--").append(";\n");
    }
    return null;
  }

  @Override
  public String visitPrint_stmt(org.example.MarsikParser.Print_stmtContext ctx) {
    if (ctx.STRING() != null) {
      return "printf(" + ctx.STRING().getText() + ");\n";
    } else {
      // Must determine the type of expression and use appropriate format specifier
      String exprText = visit(ctx.expr());
      String exprRawText = ctx.expr().getText();
      
      // Check if it's a variable to determine type
      String formatSpec = "%d"; // default to int
      if (variables.containsKey(exprRawText)) {
        String type = variables.get(exprRawText).type;
        formatSpec = switch (type) {
          case "string" -> "%s";
          case "double" -> "%f";
          case "char" -> "%c";
          case "bool" -> "%i";
          case "uint8_t" -> "%u";
          default -> "%d";
        };
      }
      return "printf(\"" + formatSpec + "\", " + exprText + ");\n";
    }
  }

  @Override
  public String visitExit_stmt(org.example.MarsikParser.Exit_stmtContext ctx) {
    String exitCode = ctx.INTEGER() != null ? ctx.INTEGER().getText() : "0";
    return "exit(" + exitCode + ");\n";
  }

  @Override
  public String visitReturn_stmt(org.example.MarsikParser.Return_stmtContext ctx) {
    code.append("return ").append(ctx.expr() != null ? visit(ctx.expr()) : "").append(";\n");
    return null;
  }

  @Override
  public String visitClass_def(org.example.MarsikParser.Class_defContext ctx) {
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
        String fieldType = field.type;
        if (fieldType.equals("boolean")) {
          fieldType = "bool";
        }
        if (fieldType.equals("baby_int")) {
          fieldType = "uint8_t";
        }
        variables.put(field.name, new ValueHolder(fieldType, true));
      }
    }

    // Second pass: Process all methods (without appending to main code)
    StringBuilder tempCodeStorage = new StringBuilder(code.toString());
    code.setLength(0); // Clear main code temporarily

    for (var member : ctx.class_member()) {
      if (member.method_decl() != null) {
        MethodHolder method = new MethodHolder();
        org.example.MarsikParser.Method_declContext methodCtx = member.method_decl();
        method.name = methodCtx.NAME().getText();
        method.returnType = methodCtx.type_label() != null ? methodCtx.type_label().getText() : "void";
        method.isInternal = methodCtx.getText().startsWith("internal");

        if (methodCtx.parameters() != null) {
          for (var p : methodCtx.parameters().parameter()) {
            method.params.add(new ParamHolder(
                    p.type_label().getText(),
                    p.NAME().getText()
            ));
          }
        }

        // Capture method body without appending to main code
        visitBlock(methodCtx.block());
        method.body = code.toString();
        code.setLength(0); // Reset for next method
        customObj.methods.add(method);
      }
    }

    code.append(tempCodeStorage); // Restore main code

    customObjects.put(className, customObj);
    CustomObjectGenerator.generateCustomObject(customObj);
    imports.add("#include \"" + className.toLowerCase() + ".h\"\n");

    // Clear field variables after processing the class
    for (FieldHolder field : customObj.fields) {
      variables.remove(field.name);
    }

    currentCustomObject = null;
    return null;
  }

  @Override
  public String visitField_decl(org.example.MarsikParser.Field_declContext ctx) {
    FieldHolder f = new FieldHolder();
    f.type = ctx.type_label().getText();
    f.name = ctx.NAME().getText();
    f.isPublic = ctx.getText().contains("public");
    f.isConst = ctx.getText().contains("const");
    currentClass.fields.add(f);
    return null;
  }

  @Override
  public String visitMethod_decl(org.example.MarsikParser.Method_declContext ctx) {
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
  public String visitExpr(org.example.MarsikParser.ExprContext ctx) {
    return super.visitExpr(ctx);
  }

  @Override
  public String visitOr_expr(org.example.MarsikParser.Or_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.and_expr(0)));
    for (int i = 1; i < ctx.and_expr().size(); i++) {
      result.append(" || ").append(visit(ctx.and_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitAnd_expr(org.example.MarsikParser.And_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.equality_expr(0)));
    for (int i = 1; i < ctx.equality_expr().size(); i++) {
      result.append(" && ").append(visit(ctx.equality_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitEquality_expr(org.example.MarsikParser.Equality_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.relational_expr(0)));
    for (int i = 1; i < ctx.relational_expr().size(); i++) {
      result.append(" ").append(ctx.getChild(1).getText()).append(" ")
              .append(visit(ctx.relational_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitRelational_expr(org.example.MarsikParser.Relational_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.additive_expr(0)));
    for (int i = 1; i < ctx.additive_expr().size(); i++) {
      result.append(" ").append(ctx.getChild(1).getText()).append(" ")
              .append(visit(ctx.additive_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitAdditive_expr(org.example.MarsikParser.Additive_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.multiplicative_expr(0)));
    for (int i = 1; i < ctx.multiplicative_expr().size(); i++) {
      result.append(" ").append(ctx.getChild(1).getText()).append(" ")
              .append(visit(ctx.multiplicative_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitMultiplicative_expr(org.example.MarsikParser.Multiplicative_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.unary_expr(0)));
    for (int i = 1; i < ctx.unary_expr().size(); i++) {
      result.append(" ").append(ctx.getChild(1).getText()).append(" ")
              .append(visit(ctx.unary_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitUnary_expr(org.example.MarsikParser.Unary_exprContext ctx) {
    if (ctx.getChildCount() == 2) {
      return ctx.getChild(0).getText() + " " + visit(ctx.unary_expr());
    } else {
      return visit(ctx.power_expr());
    }
  }

  @Override
  public String visitPower_expr(org.example.MarsikParser.Power_exprContext ctx) {
    if (ctx.getChildCount() == 3) {
      imports.add("#include \"math.h\"\n");
      return "pow(" + visit(ctx.atom_expr()) + "," + visit(ctx.unary_expr()) + ")";
    } else {
      return visit(ctx.atom_expr());
    }
  }

  @Override
  public String visitAtom_expr(org.example.MarsikParser.Atom_exprContext ctx) {
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
   * Generates full C code.
   *
   * @return full C code
   */
  public String generateC() {
    StringBuilder importsAsString = new StringBuilder();
    for (String anImport : imports) {
      importsAsString.append(anImport);
    }
    return
            """
            #include <stdio.h>
            #include <stdlib.h>
            #include <stdbool.h>
            #include "string.h"
            %s
           
            int main() {
              %s
              return 0;
            }
            """.formatted(importsAsString, code.toString());
  }

  private static void compile(String srcFilePath) {
    try {
      CharStream input = CharStreams.fromFileName(srcFilePath);
      org.example.MarsikLexer lexer = new org.example.MarsikLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      org.example.MarsikParser parser = new org.example.MarsikParser(tokens);
      ParseTree tree = parser.program();
      Compiler compiler = new Compiler();
      compiler.visit(tree);
      
      // Ensure out folder exists
      File outFolder = new File("C:\\Users\\dani_\\Desktop\\MarsikLang2\\src\\main\\java\\org\\example\\out");
      if (!outFolder.exists()) {
        outFolder.mkdirs();
      }
      
      // Only generate output C file if there is actual code (not just class definitions)
      String generatedCode = compiler.code.toString().trim();
      if (!generatedCode.isEmpty()) {
        String outputFileName = new File(srcFilePath).getName().replace(".marsik", ".c");
        File generatedFile = new File(outFolder, outputFileName);
        
        if (generatedFile.exists()) {
          FileHandler.deleteFile(generatedFile.getAbsolutePath());
        }
        FileHandler.createNewFile(generatedFile.getAbsolutePath());
        FileHandler.writeToFile(generatedFile.getAbsolutePath(), compiler.generateC());
        
        System.out.println("Generated: " + generatedFile.getAbsolutePath());
      } else {
        System.out.println("No main code generated for: " + srcFilePath + " (only class definitions)");
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void cleanUp() {
    org.example.compiler.GeneratedFilesTracker.cleanupGeneratedFiles();
  }

  /**
   * Compiles all generated .c files in the out folder using GCC.
   *
   * @param outFolder Path to the output folder containing all .c and .h files
   * @throws IOException If an I/O error occurs
   * @throws InterruptedException If the process is interrupted
   */
  private static void compileWithGCC(String outFolder) throws IOException, InterruptedException {
    System.out.println("\n=== Compiling with GCC ===\n");

    // Find all .c files in the out folder
    File folder = new File(outFolder);
    File[] cFiles = folder.listFiles((dir, name) -> name.endsWith(".c"));

    if (cFiles == null || cFiles.length == 0) {
      System.out.println("❌ No .c files found in: " + outFolder);
      return;
    }

    System.out.println("Found " + cFiles.length + " .c files to compile\n");
    List<String> command = new ArrayList<>();
    command.add("C:\\Program Files\\gcc\\bin\\gcc.exe");
    command.add("-Wall");
    command.add("-I" + outFolder);

    // Add all .c files
    for (File cFile : cFiles) {
      command.add(cFile.getAbsolutePath());
      System.out.println("  Adding: " + cFile.getName());
    }

    String outputPath = outFolder + "\\..\\output.exe";
    command.add("-o");
    command.add(outputPath);
    command.add("-lm");

    System.out.println("\n📦 GCC Command:");
    System.out.println(String.join(" ", command));
    System.out.println("\n⏳ Compiling...\n");

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
    System.out.println();

    if (exitCode == 0) {
      System.out.println("✅ Compilation successful!");
      System.out.println("📁 Executable created at: " + outputPath);
    } else {
      System.out.println("❌ Compilation failed! (Exit Code: " + exitCode + ")");
    }
  }

  static void main(String[] args) throws IOException, InterruptedException {
    String outFolder = "C:\\Users\\dani_\\Desktop\\MarsikLang2\\src\\main\\java\\org\\example\\out";

    compile("C:\\Users\\dani_\\Desktop\\MarsikLang2\\src\\main\\java\\org\\example\\example.marsik");
    // compile("C:\\Users\\dani_\\Desktop\\MarsikLang2\\src\\main\\java\\org\\example\\person.marsik");
    compileWithGCC(outFolder);

    // Optional: Uncomment to delete the "out" folder after compilation
    // cleanUp();
  }
}
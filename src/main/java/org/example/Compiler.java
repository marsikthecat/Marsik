package org.example;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.internals.compiler.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Compiler extends org.example.MarsikBaseVisitor<String> {

  public final HashMap<String, ValueHolder> variables = new HashMap<>();

  public final HashMap<String, ValueHolder> constants = new HashMap<>();
  public final StringBuilder code = new StringBuilder();
  private ClassHolder currentClass;

  @Override
  public String visitType_label(org.example.MarsikParser.Type_labelContext ctx) {
    return super.visitType_label(ctx);
  }

  @Override
  public String visitStmt(org.example.MarsikParser.StmtContext ctx) {
    if (ctx.print_stmt() != null) {
      code.append(visit(ctx.print_stmt()));
    }
    if (ctx.printLn_stmt() != null) {
      code.append(visit(ctx.printLn_stmt()));
    }
    if (ctx.exit_stmt() != null) {
      code.append(visit(ctx.exit_stmt()));
    }
    return super.visitStmt(ctx);
  }

  @Override
  public String visitBuild_in_stmt(org.example.MarsikParser.Build_in_stmtContext ctx) {
    String type = ctx.type_label().getText();
    if (ctx.type_label().STRING_TYPE() != null) {
      type = "String";
    }
    String name = ctx.NAME().getText();
    String value;
    if (ctx.method_call() != null) {
      value = ctx.method_call().getText();
    } else {
      value = visit(ctx.getChild(3)); // all build-in
    }
    if (constants.containsKey(name)) {
      throw new RuntimeException("Constant " + name + " already exists");
    }
    code.append(type).append(" ").append(name).append(" = ").append(value).append(";\n");
    return null;
  }

  @Override
  public String visitObject_stmt(MarsikParser.Object_stmtContext ctx) {
    List<String> buildInObjects = List.of("HashMap", "BitSet", "Array", "BinaryTree", "AVLTree",
            "BTree", "SplayTree", "Graph", "WeightedGraph", "SplayArray", "CircularBuffer", "GapBuffer");
    String objectAtStart = ctx.NAME(0).getText();
    String variable = ctx.NAME(1).getText();
    String objectAtEnd = ctx.NAME(2).getText();
    String translatedObject;
    if (objectAtStart.equals(objectAtEnd)) {
      // Here we translate the build-in objects into the Marsik objects of the runtime
      if (buildInObjects.contains(objectAtStart)) {
        translatedObject = "Marsik" + objectAtStart;
      } else {
        translatedObject = objectAtStart;
      }
      variables.put(variable, new ValueHolder(translatedObject, variable));
      String parameters = ctx.parameters() != null ? ctx.parameters().getText() : "";
      code.append(translatedObject).append(" ").append(variable).append(" = new ").append(translatedObject).
              append("(").append(parameters).append(");\n");
    } else {
      throw new RuntimeException("Object " + objectAtStart + " and " + objectAtEnd + " do not match");
    }
    return null;
  }

  @Override
  public String visitMethod_call(MarsikParser.Method_callContext ctx) {
    String target = ctx.NAME(0).getText();   // a
    String method = ctx.NAME(1).getText();   // toUpperCase

    if (!variables.containsKey(target)) {
      throw new RuntimeException("Variable " + target + " does not exist");
    }

    String type = variables.get(target).javaType;
    if (type.equals("String")) {
      List<String> stringMethods = List.of("setCharAt", "getCharAt", "length", "isEmpty", "print", "indexOf",
              "allIndexOf", "firstIndexOf", "lastIndexOf", "contains", "count", "replaceAll",
              "reverse", "append", "subString", "toUpperCase", "toLowerCase", "startsWith", "endsWith",
              "isPalindrome", "alphabetIndex", "hasOnlyDigits", "hasDigits", "hasOnlyLetters", "hasLetters",
              "isAlphaNumeric", "capitalize", "removeWhiteSpaces", "abbreviation", "numberOfVowels", "numberOfConsonants");
      if (!stringMethods.contains(method)) {
        throw new RuntimeException("Method " + method + " does not exist for strings");
      }
    }
    List<String> args = new ArrayList<>();
    if (ctx.arguments() != null) {
      for (var e : ctx.arguments().expr()) {
        args.add(visit(e));
      }
    }
    code.append(target).append(".").append(method).append("(").append(String.join(", ", args)).append(");\n");
    return null;
  }

  @Override
  public String visitVar_decl(org.example.MarsikParser.Var_declContext ctx) {
    String name = ctx.NAME().getText();
    if (variables.containsKey(name)) {
      throw new RuntimeException("Variable " + name + " already exists");
    }
    String type = ctx.type_label().getText();
    if (ctx.type_label().STRING_TYPE() != null) {
      type = "MarsikString";
    }
    String init = ctx.expr() != null
            ? visit(ctx.expr())
            : ctx.type() != null
            ? ctx.type().getText()
            : null;

    if (init != null) {
      if (type.equals("MarsikString")) {
        code.append("MarsikString ").append(name).append(" = new MarsikString(").append(init).append(");\n");
      } else {
        code.append(type).append(" ").append(name).append(" = ").append(init).append(";\n");
      }
    } else {
      if (type.equals("MarsikString")) {
        code.append("MarsikString ").append(name).append(";\n");
      } else {
        code.append(type).append(" ").append(name).append(";\n");
      }
    }
    variables.put(name, new ValueHolder(type, name));
    return null;
  }

  @Override
  public String visitConst_decl(org.example.MarsikParser.Const_declContext ctx) {
    String name = ctx.NAME().getText();
    if (constants.containsKey(name)) {
      throw new RuntimeException("Constant " + name + " already exists");
    }
    String type = ctx.type_label().getText();
    String value = ctx.type().getText();
    code.append("final ").append(type)
            .append(" ").append(name)
            .append(" = ").append(value).append(";\n");
    constants.put(name, new ValueHolder(type, name));
    return null;
  }

  @Override
  public String visitAssign_stmt(org.example.MarsikParser.Assign_stmtContext ctx) {
    String name = ctx.NAME().getText();
    String value = visit(ctx.type());
    if (constants.containsKey(name))
      throw new RuntimeException("Cannot assign to const: " + name);

    code.append(name).append(" = ").append(value).append(";\n");
    return null;
  }

  @Override
  public String visitArray_decl(org.example.MarsikParser.Array_declContext ctx) {
    variables.put(ctx.NAME().getText(), new ValueHolder(ctx.type_label().getText(), ctx.NAME().getText()));
    code.append("MarsikArray<").append(ctx.type_label().getText()).append("> ").append(ctx.NAME().getText()).append(" = new MarsikArray();\n");
    for (int i = 0; i < ctx.type().size(); i++) {
      code.append(ctx.NAME()).append(".put(").append(i).append(",")
              .append(ctx.type().get(i).getText()).append(");\n");
    }
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
    for (MarsikParser.ParameterContext p : ctx.parameter()) {
      params.add(visit(p));
    }
    return String.join(", ", params);
  }

  @Override
  public String visitParameter(org.example.MarsikParser.ParameterContext ctx) {
    String type = visit(ctx.type());
    String name = ctx.NAME().getText();
    return type + " " + name;
  }

  @Override
  public String visitIf_stmt(org.example.MarsikParser.If_stmtContext ctx) {
    code.append("if (").append(ctx.expr().getText()).append(") ");
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
    if (ctx.for_init() != null) visit(ctx.for_init());
    if (ctx.expr() != null) code.append(visit(ctx.expr()));
    if (ctx.for_update() != null) ctx.for_update();
    code.append("; ").append(ctx.for_update().getText());
    code.append(") ");
    visit(ctx.block());
    return null;
  }

  @Override
  public String visitFor_update(MarsikParser.For_updateContext ctx) {
    if (ctx.inc_stmt() != null) return ctx.inc_stmt().getText();
    else {
      return ctx.dec_stmt().getText();
    }
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
  public String visitPrint_stmt(org.example.MarsikParser.Print_stmtContext ctx) {
    String val = ctx.expr() != null ? visit(ctx.expr()) : ctx.STRING().getText();
    return "System.out.print(" + val + ");\n";
  }

  @Override
  public String visitPrintLn_stmt(org.example.MarsikParser.PrintLn_stmtContext ctx) {
    String message = ctx.STRING() != null ? ctx.STRING().getText() : ctx.expr().getText();
    return "System.out.println(" + message + ");\n";
  }

  @Override
  public String visitScan_stmt(org.example.MarsikParser.Scan_stmtContext ctx) {
    return "new java.util.Scanner(System.in).nextLine()";
  }

  @Override
  public String visitExit_stmt(org.example.MarsikParser.Exit_stmtContext ctx) {
    if (ctx.INTEGER() != null) {
      return "System.exit(" + ctx.INTEGER().getText() + ")\n";
    } else {
      return "System.exit();\n";
    }
  }

  @Override
  public String visitTime_stmt(org.example.MarsikParser.Time_stmtContext ctx) {
    return "System.currentTimeMillis()";
  }

  @Override
  public String visitOther_stmt(org.example.MarsikParser.Other_stmtContext ctx) {
    String libraryObject = ctx.STANDARDLIBS().getText();
    String function = ctx.NAME().getText();
    List<String> params = new ArrayList<>();
    if (ctx.arguments() != null) {
      for (var expr : ctx.arguments().expr()) {
        params.add(expr.getText());
      }
    }
    return libraryObject + "." +  function + "(" + String.join(", ", params) + ")";
  }

  @Override
  public String visitReturn_stmt(org.example.MarsikParser.Return_stmtContext ctx) {
    if (ctx.expr() != null) {
      code.append("return ").append(visit(ctx.expr())).append(";\n");
    } else {
      code.append("return;\n");
    }
    return null;
  }

  @Override
  public String visitClass_def(MarsikParser.Class_defContext ctx) {
    ClassHolder cls = new ClassHolder();
    cls.name = ctx.NAME().getText();
    currentClass = cls;
    visitChildren(ctx);
    return null;
  }

  @Override
  public String visitField_decl(MarsikParser.Field_declContext ctx) {
    FieldHolder f = new FieldHolder();
    f.type = ctx.type().getText();
    f.name = ctx.NAME().getText();
    f.isPublic = ctx.getText().contains("public");
    f.isConst = ctx.getText().contains("const");
    currentClass.fields.add(f);
    return null;
  }

  @Override
  public String visitConstructor_decl(MarsikParser.Constructor_declContext ctx) {
    ConstructorHolder c = new ConstructorHolder();
    if (ctx.parameters() != null) {
      for (var p : ctx.parameters().parameter()) {
        c.params.add(new ParamHolder(
                p.type().getText(),
                p.NAME().getText()
        ));
      }
    }
    c.body = visitBlock(ctx.block());
    currentClass.constructor = c;
    return null;
  }

  @Override
  public String visitMethod_decl(MarsikParser.Method_declContext ctx) {
    MethodHolder m = new MethodHolder();
    m.name = ctx.NAME().getText();
    m.isInternal = ctx.getText().startsWith("internal");
    m.returnType = ctx.type() != null ? ctx.type().getText() : "void";
    if (ctx.parameters() != null) {
      for (var p : ctx.parameters().parameter()) {
        m.params.add(new ParamHolder(
                p.type().getText(),
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
      result.append(" ").append(ctx.getChild(1).getText()).append(" ").append(visit(ctx.relational_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitRelational_expr(org.example.MarsikParser.Relational_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.additive_expr(0)));
    for (int i = 1; i < ctx.additive_expr().size(); i++) {
      result.append(" ").append(ctx.getChild(1).getText()).append(" ").append(visit(ctx.additive_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitAdditive_expr(org.example.MarsikParser.Additive_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.multiplicative_expr(0)));
    for (int i = 1; i < ctx.multiplicative_expr().size(); i++) {
      result.append(" ").append(ctx.getChild(1).getText()).append(" ").append(visit(ctx.multiplicative_expr(i)));
    }
    return result.toString();
  }

  @Override
  public String visitMultiplicative_expr(org.example.MarsikParser.Multiplicative_exprContext ctx) {
    StringBuilder result = new StringBuilder(visit(ctx.unary_expr(0)));
    for (int i = 1; i < ctx.unary_expr().size(); i++) {
      result.append(" ").append(ctx.getChild(1).getText()).append(" ").append(visit(ctx.unary_expr(i)));
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
      return visit(ctx.atom_expr()) + " ** " + visit(ctx.unary_expr());
    } else {
      return visit(ctx.atom_expr());
    }
  }

  @Override
  public String visitAtom_expr(org.example.MarsikParser.Atom_exprContext ctx) {
    if (ctx.other_stmt() != null) return visitOther_stmt(ctx.other_stmt());
    if (ctx.NAME() != null) return ctx.NAME().getText();
    if (ctx.INTEGER() != null) return ctx.INTEGER().getText();
    if (ctx.BABY_INTEGER() != null) return ctx.BABY_INTEGER().getText();
    if (ctx.DOUBLE() != null) return ctx.DOUBLE().getText();
    if (ctx.STRING() != null) return ctx.STRING().getText();
    if (ctx.CHAR() != null) return ctx.CHAR().getText();
    if (ctx.BOOLEAN() != null) return ctx.BOOLEAN().getText();
    if (ctx.expr() != null) return visit(ctx.expr());
    return "";
  }

  public String generateJava() {
    return """
    public class GeneratedProgram {
        public static void main(String[] args) {
            %s
        }
    }
    """.formatted(code.toString());
  }


  static void main() throws IOException {
    String marsikFile = "C:\\Marsik\\MarsikLang\\src\\main\\java\\org\\example\\example.txt";
    CharStream input = CharStreams.fromFileName(marsikFile);
    MarsikLexer lexer = new MarsikLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    MarsikParser parser = new MarsikParser(tokens);
    ParseTree tree = parser.program();
    Compiler compiler = new Compiler();
    compiler.visit(tree);
    System.out.println(compiler.generateJava());
  }
}
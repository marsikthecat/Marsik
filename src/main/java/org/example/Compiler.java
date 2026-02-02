package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.internals.FileHandler;
import org.example.internals.compiler.ClassHolder;
import org.example.internals.compiler.ConstructorHolder;
import org.example.internals.compiler.FieldHolder;
import org.example.internals.compiler.MethodHolder;
import org.example.internals.compiler.ParamHolder;
import org.example.internals.compiler.ValueHolder;

/**
 * Transforms marsik-code into java code and inserts it in a file.
 */
public class Compiler extends org.example.MarsikBaseVisitor<String> {

  public final HashMap<String, ValueHolder> variables = new HashMap<>();
  public final HashMap<String, ValueHolder> constants = new HashMap<>();
  public final StringBuilder code = new StringBuilder();
  public final Set<String> imports = new HashSet<>();
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
      value = visitMethod_call(ctx.method_call());
    } else {
      value = visit(ctx.getChild(3)); // all build-in
    }
    if (constants.containsKey(name)) {
      throw new RuntimeException("Constant " + name + " already exists");
    }
    if (variables.containsKey(name)) {
      throw new RuntimeException("Variable " + name + " already exists");
    }
    code.append(type).append(" ").append(name).append(" = ").append(value).append(";\n");
    return null;
  }

  @Override
  public String visitObject_stmt(MarsikParser.Object_stmtContext ctx) {
    // All instantiatable objects of the marsik runtime
    List<String> buildInObjects = List.of("Stack", "SparseArray", "Set", "Queue", "List",
            "HashMap", "PerfectHashMap", "BitSet", "Array", "BinaryTree", "AvlTree", "Btree",
            "SplayTree", "Graph", "WeightedGraph", "SplayArray", "CircularBuffer", "GapBuffer");
    String objectAtStart = ctx.NAME(0).getText();
    String variable = ctx.NAME(1).getText();
    String objectAtEnd = ctx.NAME(2).getText();
    String translatedObject;
    if (objectAtStart.equals(objectAtEnd)) {
      // Here we translate the build-in objects into the Marsik objects of the runtime
      if (buildInObjects.contains(objectAtStart)) {
        // Bitset has no datatype to store
        if (ctx.type_label() != null && !objectAtStart.equals("BitSet")) {
          String type = ctx.type_label().getText();
          // Creating Types for generic: list<int> => MarsikList<Integer>
          String genericType = switch (type) {
            case "string" -> "String";
            case "int" -> "Integer";
            case "boolean" -> "Boolean";
            case "double" -> "Double";
            case "char" -> "Character";
            default -> "Object";
          };
          imports.add("import org.example.internals.datastructures.*;\n");
          translatedObject = "Marsik" + objectAtStart + "<" + genericType + ">";
        } else {
          throw new RuntimeException("Unknown Type of Elements detected");
        }
      } else {
        // Custom objects + BitSet, Matrix and Pointer because I forgot to put Marsik in the filename
        translatedObject = objectAtStart;
        // TODO: Matrix + Points which have no generic types
      }
      variables.put(variable, new ValueHolder(objectAtStart, true));
      String parameters = ctx.arguments() != null ? ctx.arguments().getText() : "";
      code.append(translatedObject).append(" ").append(variable).append(" = new ").append("Marsik")
              .append(objectAtEnd).append("<>(").append(parameters).append(");\n");
    } else {
      throw new RuntimeException("Object " + objectAtStart + " and " + objectAtEnd
              + " do not match");
    }
    return null;
  }

  @Override
  public String visitMethod_call(MarsikParser.Method_callContext ctx) {
    String target = ctx.NAME(0).getText();
    String method = ctx.NAME(1).getText();

    if (!variables.containsKey(target)) {
      throw new RuntimeException("Variable " + target + " does not exist");
    }
    String type = variables.get(target).getType();
    if (type.equals("array")) {
      List<MarsikParser.ExprContext> args = ctx.arguments().expr();
      if (method.equals("get")) {
        // arr.get(1) gets transformed to arr[1]
        return target + "[" + args.getFirst().getText() + "]";
      } else if (method.equals("set")) {
        // arr.set(5, 6) gets transformed to arr[5] = 6
        return target + "[" + args.getFirst().getText() + "] = "
                + args.getFirst().getText() + ";\n";
      } else {
        List<String> argList = new ArrayList<>();
        for (MarsikParser.ExprContext exprContext : args) {
          argList.add(exprContext.getText());
        }
        return "ArrayUtils." + method + "(" + target + ", "
                + String.join(",", argList) + ")";
      }
    } else {
      List<String> extendedStringMethods = List.of("setCharAt", "allIndexOf",
              "firstIndexOf", "lastIndexOf", "count", "reverse", "appendChar", "capitalize",
              "isPalindrome", "alphabetIndexes", "hasOnlyDigits", "replacePart",
              "hasDigits", "hasOnlyLetters", "hasLetters", "isAlphaNumeric", "capitalize",
              "numberOfVowels", "numberOfConsonants", "isOnlyLowerCase", "inOnlyUpperCase",
              "isOnlyWhiteSpace", "numberOfWhiteSpaces");
      if (type.equals("String") && extendedStringMethods.contains(method)) {
        List<String> args = new ArrayList<>();
        if (ctx.arguments() != null) {
          for (var e : ctx.arguments().expr()) {
            args.add(visit(e));
          }
        }
        code.append("StringUtils.").append(method).append("(").append(target).append(",")
                .append(String.join(", ", args)).append(");\n");
        return null;
      }
      List<String> args = new ArrayList<>();
      if (ctx.arguments() != null) {
        for (var e : ctx.arguments().expr()) {
          args.add(visit(e));
        }
      }
      code.append(target).append(".").append(method).append("(").append(
              String.join(", ", args)).append(");\n");
    }
    return null;
  }

  @Override
  public String visitVar_decl(org.example.MarsikParser.Var_declContext ctx) {
    String name = ctx.NAME().getText();
    if (variables.containsKey(name)) {
      throw new RuntimeException("Variable " + name + " already exists");
    }
    String type = ctx.type_label().getText();
    String init = ctx.expr() != null ? visit(ctx.expr()) : ctx.type() != null
            ? ctx.type().getText() : null;

    if (type.equals("string")) {
      type = "String";
    }
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
    String value = ctx.type().getText();
    if (checkCorrectValueForLiteral(ctx.type_label(), ctx.type())) {
      throw new RuntimeException("Literal " + ctx.type_label().getText()
              + " does not match Value " + ctx.type().getText());
    }
    if (type.equals("string")) {
      type = "String";
    }
    code.append("final ").append(type).append(" ").append(name)
            .append(" = ").append(value).append(";\n");
    constants.put(name, new ValueHolder(type, true));
    return null;
  }

  @Override
  public String visitAssign_stmt(org.example.MarsikParser.Assign_stmtContext ctx) {
    String name = ctx.NAME().getText();
    String value = ctx.type() != null ? ctx.type().getText() : ctx.expr().getText();
    if (constants.containsKey(name)) {
      throw new RuntimeException("Cannot assign to const: " + name);
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
      } else if (type.equals("boolean") && ctx.type().BOOLEAN() == null) {
        throw new RuntimeException("Value " + ctx.type().getText() + "does not match Boolean");
      } else if (type.equals("char") && ctx.type().CHAR() == null) {
        throw new RuntimeException("Value " + ctx.type().getText() + "does not match Character");
      }
    }
    code.append(name).append(" = ").append(value).append(";\n");
    return null;
  }

  @Override
  public String visitArray_decl(org.example.MarsikParser.Array_declContext ctx) {
    MarsikParser.Type_labelContext context = ctx.type_label();
    String type = context.INT_TYPE() != null ? context.INT_TYPE().getText()
            : context.STRING_TYPE() != null ? context.STRING_TYPE().getText()
            : context.BOOL_TYPE() != null ? context.BOOL_TYPE().getText()
            : context.DOUBLE_TYPE() != null ? context.DOUBLE_TYPE().getText()
            : context.CHAR_TYPE() != null ? context.CHAR_TYPE().getText() : "";
    if (type.equals("string")) {
      type = "String";
    }
    int size = Integer.parseInt(ctx.INTEGER().getText());
    if (ctx.type().size() > size) {
      throw new RuntimeException("Array size " + size + " does not match elements");
    }
    String name = ctx.NAME().getText();
    variables.put(name, new ValueHolder("array", true));
    for (int i = 0; i < ctx.type().size(); i++) {
      if (context.INT_TYPE() != null) {
        if (ctx.type().get(i).INTEGER() == null) {
          throw new RuntimeException("Value " + ctx.type().get(i) + " does not match Integer");
        }
      } else if (context.DOUBLE_TYPE() != null) {
        if (ctx.type().get(i).DOUBLE() == null) {
          throw new RuntimeException("Value " + ctx.type().get(i) + " does not match Double");
        }
      } else if (context.CHAR_TYPE() != null) {
        if (ctx.type().get(i).CHAR() == null) {
          throw new RuntimeException("Value " + ctx.type().get(i) + " does not match Character");
        }
      } else if (context.BOOL_TYPE() != null) {
        if (ctx.type().get(i).BOOLEAN() == null) {
          throw new RuntimeException("Value " + ctx.type().get(i) + " does not match Boolean");
        }
      } else if (context.STRING_TYPE() != null) {
        if (ctx.type().get(i).STRING() == null) {
          throw new RuntimeException("Value " + ctx.type().get(i) + " does not match String");
        }
      }
    }
    code.append(type).append("[] ").append(name).append(" = new ").append(type).append("[")
            .append(size).append("];\n");
    for (int i = 0; i < ctx.type().size(); i++) {
      code.append(name).append("[").append(i).append("] = ")
              .append(ctx.type().get(i).getText()).append(";\n");
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
    String msg = ctx.STRING().getText();
    code.append("System.out.println(").append(msg).append(");\n");
    return "new java.util.Scanner(System.in).nextLine()";
  }

  @Override
  public String visitExit_stmt(org.example.MarsikParser.Exit_stmtContext ctx) {
    String exitCode = ctx.INTEGER() != null ? ctx.INTEGER().getText() : "0";
    return "System.exit(" + exitCode + ");\n";
  }

  @Override
  public String visitTime_stmt(org.example.MarsikParser.Time_stmtContext ctx) {
    return "String.valueOf(System.currentTimeMillis())";
  }

  @Override
  public String visitOther_stmt(org.example.MarsikParser.Other_stmtContext ctx) {
    String libraryObject = ctx.STANDARDLIBS().getText();
    // TODO: find out why the hell it doesn't include math import
    //  despite being recognized as a Standard library
    switch (libraryObject) {
      case "Sys" -> imports.add("import org.example.internals.Sys;\n");
      case "Math" -> imports.add("import org.example.internals.math.Math;\n");
      case "FileHandler" -> imports.add("import org.example.internals.FileHandler;\n");
      case "Crypto" -> imports.add("import org.example.internals.crypto.*;\n");
      case "Validator" -> imports.add("import org.example.internals.Validator;\n");
      case "DateTime" -> imports.add("import org.example.internals.time.DateTime;\n");
      case "RequestSender" ->
          imports.add("import org.example.internals.internet.MarsikRequestSender;\n");
      case "TypeCaster" -> imports.add("import org.example.internals.TypeCaster;\n");
      default -> imports.add("");
    }
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
      return "java.lang.Math.pow(" + visit(ctx.atom_expr()) + "," + visit(ctx.unary_expr()) + ")";
    } else {
      return visit(ctx.atom_expr());
    }
  }

  @Override
  public String visitAtom_expr(org.example.MarsikParser.Atom_exprContext ctx) {
    if (ctx.other_stmt() != null) {
      return visitOther_stmt(ctx.other_stmt());
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
   * Generates full java code in a main method and class.
   *
   * @return full java code
   */
  public String generateJava() {
    StringBuilder importsAsString = new StringBuilder();
    for (String anImport : imports) {
      importsAsString.append(anImport);
    }
    return
    """
    
    package org.example;
    
    import org.example.internals.math.Math;
    %s
    
    public class GeneratedProgram {
        static void main(String[] args) {
            %s
        }
    }
    """.formatted(importsAsString, code.toString());
  }

  /**
   * Generates code lines without wrapping them in a java main method (for tests).
   *
   * @return code lines
   */
  public String generateHalfJava() {
    return code.toString();
  }

  static void main() throws IOException {
    // Path of the marsik file
    String marsikFile = "C:\\Marsik\\MarsikLang\\src\\main\\java\\org\\example\\example.txt";
    CharStream input = CharStreams.fromFileName(marsikFile);
    MarsikLexer lexer = new MarsikLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    MarsikParser parser = new MarsikParser(tokens);
    ParseTree tree = parser.program();
    Compiler compiler = new Compiler();
    compiler.visit(tree);
    // location of java file
    File generatedFile = new File(
            "C:\\Marsik\\MarsikLang\\src\\main\\java\\org\\example\\GeneratedProgram.java");
    if (generatedFile.exists()) {
      FileHandler.deleteFile(generatedFile.getAbsolutePath());
    }
    FileHandler.createNewFile(generatedFile.getAbsolutePath());
    FileHandler.writeToFile(generatedFile.getAbsolutePath(),
            compiler.generateJava());
  }
}
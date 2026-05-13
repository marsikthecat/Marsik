import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStringConvertion {

  private final Compiler compiler = new Compiler();

  public String compile(CharStream input) {
    MarsikLexer lexer = new MarsikLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    MarsikParser parser = new MarsikParser(tokens);
    ParseTree tree = parser.program();
    compiler.visit(tree);
    return compiler.generateHalfJava();
  }

  /**
   * Tests whether the string type is converted to the Runtime String object
   * string s = "a" should transform to MarsikString s = new MarsikString("a");
   */
  @Test
  public void testStringConvertionOne() {
    CharStream input = CharStreams.fromString("""
    string s = "a"
    """);
    String compiled = compile(input);
    Assertions.assertEquals("MarsikString s = new MarsikString(\"a\");\n", compiled);
  }

  @Test
  public void testStringConvertionTwo() {
    CharStream input = CharStreams.fromString("""
    int a = 5
    string b = TypeCaster.intToString(a)
    """);
    String compiled = compile(input);
    Assertions.assertEquals("int a = 5;\nMarsikString b = new MarsikString(TypeCaster.intToString(a));\n", compiled);
  }
}
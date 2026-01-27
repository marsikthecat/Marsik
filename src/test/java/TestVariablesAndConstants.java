import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.Compiler;
import org.example.MarsikLexer;
import org.example.MarsikParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestVariablesAndConstants {
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
   * Test declaring variables again
   */
  @Test
  public void testSameDeclaration() {
    CharStream input = CharStreams.fromString("""
    double num1 = 5.6
    num1 = 5.5
    """);
    Assertions.assertDoesNotThrow(() -> compile(input));
    Assertions.assertEquals("double num1 = 5.6;\nnum1 = 5.5;\n", compile(input));
  }

  /**
   * Tests all possible wrong declarations
   */
  @Test
  public void testAllPossibleWrongDeclarations() {
    CharStream input = CharStreams.fromString("""
    double num = "I am a double bubble!"
    """);
    CharStream input2 = CharStreams.fromString("""
    double num = 1
    """);
    CharStream input3 = CharStreams.fromString("""
    double num = false
    """);
    CharStream input4 = CharStreams.fromString("""
    double num = 'a'
    """);
    CharStream input5 = CharStreams.fromString("""
    int num = 5.5
    """);
    CharStream input6 = CharStreams.fromString("""
    int num = "1"
    """);
    CharStream input7 = CharStreams.fromString("""
    int num = false
    """);
    CharStream input8 = CharStreams.fromString("""
    int num = 'Z'
    """);
    CharStream input9 = CharStreams.fromString("""
    boolean b = 5
    """);
    CharStream input10 = CharStreams.fromString("""
    boolean b = 6.4838383838
    """);
    CharStream input11 = CharStreams.fromString("""
    boolean b = "false"
    """);
    CharStream input12 = CharStreams.fromString("""
    boolean b = 'c'
    """);
    CharStream input13 = CharStreams.fromString("""
    char c = "Character"
    """);
    CharStream input14 = CharStreams.fromString("""
    char c = 6.4838383838
    """);
    CharStream input15 = CharStreams.fromString("""
    char c = false
    """);
    CharStream input16 = CharStreams.fromString("""
    char c = 66
    """);
    CharStream input17 = CharStreams.fromString("""
    string s = 'a'
    """);
    CharStream input18 = CharStreams.fromString("""
    string s = 6.4838383838
    """);
    CharStream input19 = CharStreams.fromString("""
    string s = false
    """);
    CharStream input20 = CharStreams.fromString("""
    string s = 66
    """);
    Assertions.assertThrows(RuntimeException.class, () -> compile(input));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input2));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input3));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input4));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input5));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input6));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input7));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input8));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input9));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input10));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input11));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input12));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input13));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input14));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input15));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input16));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input17));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input18));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input19));
    Assertions.assertThrows(RuntimeException.class, () -> compile(input20));
  }

  /**
   * Tests initializing variable and declare it later.
   */
  @Test
  public void testVariableDeclaration() {
    CharStream input = CharStreams.fromString("""
    double num1
    num1 = 5.6
    """);
    Assertions.assertEquals("double num1;\nnum1 = 5.6;\n", compile(input));
  }

  /**
   * Test multiple declarations for same variable
   */
  @Test
  public void testVariableDeclarationTwo() {
    CharStream input = CharStreams.fromString("""
    double num1
    num1 = 5.6
    num1 = 5.5
    """);
    Assertions.assertDoesNotThrow(() -> compile(input));
    Assertions.assertEquals("double num1;\nnum1 = 5.6;\nnum1 = 5.5;\n", compile(input));
  }

  /**
   * Test bad declaration for same variable
   */
  @Test
  public void testBadVariableDeclaration() {
    CharStream input = CharStreams.fromString("""
    double num1
    num1 = "banana"
    """);
    Assertions.assertThrows(RuntimeException.class, () -> compile(input));
  }

  /**
   * Test bad declaration for constants
   */
  @Test
  public void testBadConstantDeclaration() {
    CharStream input = CharStreams.fromString("""
    const double num1 = 1000
    """);
    Assertions.assertThrows(RuntimeException.class, () -> compile(input));
  }
}
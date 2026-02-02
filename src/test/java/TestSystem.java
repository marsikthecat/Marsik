import org.example.internals.Sys;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestSystem {

  @Test
  void copiesStringToClipboardAndStoresInternally() {
    String testString = "Hello, World!";
    Sys.copyToClipBoard(testString);
    assertEquals(testString, Sys.getClipBoardContent());
  }

  @Test
  void returnsNullWhenClipboardIsEmpty() {
    Sys.copyToClipBoard(null);
    assertNull(Sys.getClipBoardContent());
  }

  @Test
  void overwritesPreviousClipboardContent() {
    String firstString = "First String";
    String secondString = "Second String";
    Sys.copyToClipBoard(firstString);
    Sys.copyToClipBoard(secondString);
    assertEquals(secondString, Sys.getClipBoardContent());
  }

}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TestTypeCaster {

  @Test
  void stringToIntParsesValidIntegerString() {
    assertEquals(123, TypeCaster.stringToInt("123"));
  }

  @Test
  void stringToIntThrowsExceptionForInvalidString() {
    assertThrows(NumberFormatException.class, () -> TypeCaster.stringToInt("abc"));
  }

  @Test
  void stringToIntThrowsExceptionForEmptyString() {
    assertThrows(NumberFormatException.class, () -> TypeCaster.stringToInt(""));
  }

  @Test
  void stringToDoubleParsesValidDoubleString() {
    assertEquals(123.45, TypeCaster.stringToDouble("123.45"));
  }

  @Test
  void stringToDoubleThrowsExceptionForInvalidString() {
    assertThrows(NumberFormatException.class, () -> TypeCaster.stringToDouble("abc"));
  }

  @Test
  void stringToBooleanParsesTrueString() {
    assertTrue(TypeCaster.stringToBoolean("true"));
  }

  @Test
  void stringToBooleanParsesFalseString() {
    assertFalse(TypeCaster.stringToBoolean("false"));
  }

  @Test
  void stringToBooleanParsesCaseInsensitiveTrue() {
    assertTrue(TypeCaster.stringToBoolean("TrUe"));
  }

  @Test
  void stringToBooleanParsesNonTrueAsFalse() {
    assertFalse(TypeCaster.stringToBoolean("yes"));
  }

  @Test
  void stringToCharReturnsFirstCharacter() {
    assertEquals('a', TypeCaster.stringToChar("abc"));
  }

  @Test
  void stringToCharThrowsExceptionForEmptyString() {
    assertThrows(StringIndexOutOfBoundsException.class, () -> TypeCaster.stringToChar(""));
  }

  @Test
  void intToDoubleConvertsIntegerToDouble() {
    assertEquals(123.0, TypeCaster.intToDouble(123));
  }

  @Test
  void intToCharConvertsIntegerToChar() {
    assertEquals('A', TypeCaster.intToChar(65));
  }

  @Test
  void intToStringConvertsIntegerToString() {
    assertEquals("123", TypeCaster.intToString(123));
  }

  @Test
  void doubleToIntTruncatesFractionalPart() {
    assertEquals(123, TypeCaster.doubleToInt(123.45));
  }

  @Test
  void doubleToStringConvertsDoubleToString() {
    assertEquals("123", TypeCaster.doubleToString(123));
  }

  @Test
  void booleanToStringConvertsTrueToString() {
    assertEquals("true", TypeCaster.booleanToString(true));
  }

  @Test
  void booleanToStringConvertsFalseToString() {
    assertEquals("false", TypeCaster.booleanToString(false));
  }
}
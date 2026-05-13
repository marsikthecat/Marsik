package datastructureTests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestStringUtils {

  @Test
  void throwsExceptionWhenSettingCharAtInvalidIndex() {
    String s = "hello";
    assertThrows(IndexOutOfBoundsException.class, () -> StringUtils.setCharAt(s, -1, 'a'));
    assertThrows(IndexOutOfBoundsException.class, () -> StringUtils.setCharAt(s, 5, 'a'));
  }

  @Test
  void setsCharacterAtValidIndex() {
    String s = "hello";
    assertEquals("hallo", StringUtils.setCharAt(s, 1, 'a'));
  }

  @Test
  void returnsAllIndicesOfCharacterInString() {
    int[] indices = StringUtils.allIndexOf("banana", 'a');
    assertArrayEquals(new int[]{1, 3, 5}, indices);
  }

  @Test
  void returnsEmptyArrayWhenCharacterNotFound() {
    int[] indices = StringUtils.allIndexOf("banana", 'z');
    assertArrayEquals(new int[]{}, indices);
  }

  @Test
  void returnsIndicesForCharacterAtStartAndEnd() {
    int[] indices = StringUtils.allIndexOf("abcba", 'a');
    assertArrayEquals(new int[]{0, 4}, indices);
  }

  @Test
  void handlesEmptyStringForAllIndexOf() {
    int[] indices = StringUtils.allIndexOf("", 'a');
    assertArrayEquals(new int[]{}, indices);
  }
  @Test
  void returnsLastIndexOfCharacterInString() {
    assertEquals(4, StringUtils.lastIndexOf("hello", 'o'));
  }

  @Test
  void returnsNegativeOneWhenCharacterNotFoundInLastIndexOf() {
    assertEquals(-1, StringUtils.lastIndexOf("hello", 'z'));
  }

  @Test
  void returnsLastIndexOfCharacterAtStart() {
    assertEquals(4, StringUtils.lastIndexOf("abcba", 'a'));
  }

  @Test
  void countsOccurrencesOfCharacterInString() {
    assertEquals(3, StringUtils.count("banana", 'a'));
  }

  @Test
  void returnsZeroWhenCharacterNotFoundInCount() {
    assertEquals(0, StringUtils.count("banana", 'z'));
  }

  @Test
  void reversesStringCorrectly() {
    String s = "hello";
    assertEquals("olleh", StringUtils.reverse(s));
  }

  @Test
  void handlesEmptyStringInReverse() {
    String s = "";
    assertEquals("", StringUtils.reverse(s));
  }

  @Test
  void appendsCharacterToEndOfString() {
    String s = "hello";
    assertEquals("hello!", StringUtils.appendChar(s, '!'));
  }

  @Test
  void appendsCharacterToEmptyString() {
    String s = "";
    assertEquals("a", StringUtils.appendChar(s, 'a'));
  }

  @Test
  void replacePart_validReplacement() {
    String result = StringUtils.replacePart("abcdef", 2, 4, "XY");
    assertEquals("abXYef", result);
  }

  @Test
  void replacePart_invalidIndexes() {
    assertThrows(IndexOutOfBoundsException.class,
            () -> StringUtils.replacePart("abc", -1, 2, "XY"));
  }

  @Test
  void replacePart_invalidReplacementLength() {
    assertThrows(IllegalArgumentException.class,
            () -> StringUtils.replacePart("abc", 1, 3, "X"));
  }

  @Test
  void isPalindrome() {
    assertTrue(StringUtils.isPalindrome("racecar"));
    assertFalse(StringUtils.isPalindrome("hello"));
    assertTrue(StringUtils.isPalindrome("a"));
  }


  @Test
  void alphabetIndexes_valid() {
    int[] result = StringUtils.alphabetIndexes("abc");
    assertArrayEquals(new int[]{0, 1, 2}, result);
    assertThrows(IllegalStateException.class,
            () -> StringUtils.alphabetIndexes("ab1"));
  }

  @Test
  void hasOnlyDigits() {
    assertTrue(StringUtils.hasOnlyDigits("12345"));
    assertFalse(StringUtils.hasOnlyDigits("12a45"));
  }

  @Test
  void hasDigits() {
    assertTrue(StringUtils.hasDigits("abc1"));
    assertFalse(StringUtils.hasDigits("abc"));
  }

  @Test
  void hasOnlyLetters() {
    assertTrue(StringUtils.hasOnlyLetters("abcDEF"));
    assertFalse(StringUtils.hasOnlyLetters("abc1"));
  }

  @Test
  void hasLetters() {
    assertTrue(StringUtils.hasLetters("123a"));
    assertFalse(StringUtils.hasLetters("123"));
  }

  @Test
  void isAlphaNumeric_true() {
    assertTrue(StringUtils.isAlphaNumeric("abc123"));
    assertFalse(StringUtils.isAlphaNumeric("abc-123"));
  }

  @Test
  void capitalize() {
    assertEquals("Hello", StringUtils.capitalize("hELLo"));
    assertEquals("", StringUtils.capitalize(""));
  }

  @Test
  void isOnlyLowercase() {
    assertTrue(StringUtils.isOnlyLowercase("abc"));
    assertFalse(StringUtils.isOnlyLowercase("Abc"));
  }

  @Test
  void isOnlyUppercase() {
    assertTrue(StringUtils.isOnlyUppercase("ABC"));
    assertFalse(StringUtils.isOnlyUppercase("ABc"));
  }

  @Test
  void WhiteSpace() {
    assertTrue(StringUtils.isOnlyWhiteSpace(" \t\n"));
    assertFalse(StringUtils.isOnlyWhiteSpace(" a "));
    assertEquals(3, StringUtils.numberOfWhiteSpaces(" a b "));
  }

  @Test
  void numberOfVowelsAndNumberOfConsonants() {
    assertEquals(5, StringUtils.numberOfVowels("Education"));
    assertEquals(4, StringUtils.numberOfConsonants("Education"));
  }

}

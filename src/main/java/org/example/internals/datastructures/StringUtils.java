package org.example.internals.datastructures;

/**
 * A utility class that offers more methods relating to strings.
 */
public class StringUtils {

  /**
   * Utility class: no instantiation, my friend.
   */
  public StringUtils() {}

  /**
   * Sets the character at the specified index.
   *
   * @param s     String to be handled.
   * @param index The position of the character to set.
   * @param c     The character to set.
   * @return      new String.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
  public static String setCharAt(String s, int index, char c) {
    if (index < 0 || index >= s.length()) {
      throw new IndexOutOfBoundsException("Index out of bounds: " + index + " my friend!");
    }
    char[] chars = s.toCharArray();
    chars[index] = c;
    return new String(chars);
  }

  /**
   * Returns all indices of the specified character.
   *
   * @param s     String to be handled.
   * @param c The character to search for.
   * @return A MarsikArray of integers representing all indices where the character occurs.
   */
  public static int[] allIndexOf(String s, char c) {
    int[] indexes = new int[count(s, c)];
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        indexes[j] = i;
        j++;
      }
    }
    return indexes;
  }

  /**
   * Returns the first index of a character, identical to indexOf.
   *
   * @param c The character to search for.
   * @return The first index or -1 if not found.
   */
  public static int firstIndexOf(String s, char c) {
    return s.indexOf(c);
  }

  /**
   * Returns the last index of a character.
   *
   * @param s     String to be handled.
   * @param c The character to search for.
   * @return The last index or -1 if not found.
   */
  public static int lastIndexOf(String s, char c) {
    int index = -1;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == c) {
        index = i;
        break;
      }
    }
    return index;
  }

  /**
   * Counts how many times a character occurs in the string.
   *
   * @param c The character to count.
   * @return The number of occurrences.
   */
  public static int count(String s, char c) {
    int found = 0;
    for (char chr : s.toCharArray()) {
      if (chr == c) {
        found++;
      }
    }
    return found;
  }

  /**
   * Reverses the string in-place.
   *
   * @param s String to be handled.
   * @return reversed string.
   */
  public static String reverse(String s) {
    char[] data = s.toCharArray();
    int size = data.length;
    for (int i = 0; i < size / 2; i++) {
      char tmp = data[i];
      data[i] = data[size - 1 - i];
      data[size - 1 - i] = tmp;
    }
    return new String(data);
  }

  /**
   * Appends a single character to the end of the string.
   *
   * @param s     String to be handled.
   * @param c The character to append.
   * @return new String.
   */
  public static String appendChar(String s, char c) {
    char[] data = new char[s.length() + 1];
    for (int i = 0; i < s.length(); i++) {
      data[i] = s.charAt(i);
    }
    data[s.length()] = c;
    return new String(data);
  }

  /**
   * Replaces a part of this string with another MarsikString.
   * The replacement must have the same length as the part being replaced.
   *
   * @param s     String to be handled.
   * @param start       the starting index of the part to replace
   * @param end         the ending index (exclusive) of the part to replace
   * @param replacement the replacement string
   * @return new String
   * @throws IndexOutOfBoundsException if start or end are invalid
   * @throws IllegalArgumentException  if the replacement length does not match the replaced section
   */
  public static String replacePart(String s, int start, int end, String replacement) {
    if (start < 0 || end > s.length() || start > end) {
      throw new IndexOutOfBoundsException("start and end are not valid, my friend!");
    }
    if (replacement.isEmpty() || replacement.length() != end - start) {
      throw new IllegalArgumentException("replacement-string must have same length as the "
              + "size of the part you want to replace, my friend!");
    }
    char[] data = s.toCharArray();
    for (int i = start; i < end; i++) {
      data[i] = replacement.charAt(i - start);
    }
    return new String(data);
  }

  /**
   * Checks if this string is a palindrome.
   *
   * @param s the String to be handled
   * @return true if the string reads the same forwards and backwards
   */
  public static boolean isPalindrome(String s) {
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns the alphabet index (0-25) of each letter in the string.
   * Only works if the string contains letters exclusively.
   *
   * @param s the String to be handled
   * @return a MarsikArray of alphabet indexes
   * @throws IllegalStateException if the string contains non-letter characters
   */

  public static int[] alphabetIndexes(String s) {
    if (!hasOnlyLetters(s)) {
      throw new IllegalStateException("String has non-alphabetic characters, my friend!");
    }
    int[] alphabetIndexes = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      alphabetIndexes[i] = s.charAt(i) - 'a';
    }
    return alphabetIndexes;
  }

  /**
   * Checks if this string contains only digit characters.
   *
   * @param s the String to be handled
   * @return true if all characters are digits
   */
  public static boolean hasOnlyDigits(String s) {
    for (char c : s.toCharArray()) {
      if (!Character.isDigit(c)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if this string contains at least one digit.
   *
   * @param s the String to be handled
   * @return true if at least one character is a digit
   */
  public static boolean hasDigits(String s) {
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if this string contains only letters.
   *
   * @param s the String to be handled
   * @return true if all characters are letters
   */
  public static boolean hasOnlyLetters(String s) {
    for (char c : s.toCharArray()) {
      if (!Character.isLetter(c)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if this string contains at least one letter.
   *
   * @param s the String to be handled
   * @return true if at least one character is a letter
   */
  public static boolean hasLetters(String s) {
    for (char c : s.toCharArray()) {
      if (Character.isLetter(c)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Checks if this string contains only alphanumeric characters (letters and digits).
   *
   * @param s the String to be handled
   * @return true if all characters are letters or digits
   */
  public static boolean isAlphaNumeric(String s) {
    for (char c : s.toCharArray()) {
      if (!Character.isLetterOrDigit(c)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Capitalizes the first character and converts all other letters to lowercase.
   *
   * @param s the String to be handled
   */
  public static String capitalize(String s) {
    int size = s.length();
    if (size == 0) {
      return "";
    }
    char[] chars = s.toCharArray();
    if (chars[0] >= 'a' && chars[0] <= 'z') {
      chars[0] = (char) (chars[0] - 32);
    }
    for (int i = 1; i < size; i++) {
      if (chars[i] >= 'A' && chars[i] <= 'Z') {
        chars[i] = (char) (chars[i] + 32);
      }
    }
    return new String(chars);
  }

  /**
   * Checks if the string contains only lowercase letters.
   *
   * @param s the String to be handled
   * @return true if all letters are lowercase
   */
  public static boolean isOnlyLowercase(String s) {
    for (char c : s.toCharArray()) {
      if (Character.isUpperCase(c)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if the string contains only uppercase letters.
   *
   * @param s the String to be handled
   * @return true if all letters are uppercase
   */
  public static boolean isOnlyUppercase(String s) {
    for (char c : s.toCharArray()) {
      if (Character.isLowerCase(c)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if the string contains only whitespace characters.
   *
   * @param s the String to be handled
   * @return true if all characters are whitespace
   */
  public static boolean isOnlyWhiteSpace(String s) {
    for (char c : s.toCharArray()) {
      if (!Character.isWhitespace(c)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Counts the number of whitespace characters in the string.
   *
   * @param s the String to be handled
   * @return the count of whitespace characters
   */
  public static int numberOfWhiteSpaces(String s) {
    int count = 0;
    for (Character c : s.toCharArray()) {
      if (Character.isWhitespace(c)) {
        count++;
      }
    }
    return count;
  }

  /**
   * Counts the number of vowels in the string (lowercase only).
   *
   * @param s the String to be handled
   * @return the number of vowels
   */
  public static int numberOfVowels(String s) {
    int count = 0;
    for (char c : s.toCharArray()) {
      if (isVowel(Character.toLowerCase(c))) {
        count++;
      }
    }
    return count;
  }

  private static boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }

  /**
   * Counts the number of consonant letters in the string (letters excluding vowels).
   *
   * @param s the String to be handled
   * @return the number of consonants
   */
  public static int numberOfConsonants(String s) {
    int count = 0;
    for (char c : s.toCharArray()) {
      if (Character.isLetter(c) && !isVowel(Character.toLowerCase(c))) {
        count++;
      }
    }
    return count;
  }
}
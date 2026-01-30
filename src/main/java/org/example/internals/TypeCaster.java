package org.example.internals;

/**
 * Utility class for converting between different types.
 * Supports conversions between String, int, double, boolean and char.
 */
public class TypeCaster {

  /**
   * Converts a String to an int.
   *
   * @param value the String to convert
   * @return the integer value
   * @throws NumberFormatException if the string cannot be parsed as an int
   */
  public static int stringToInt(String value) {
    return Integer.parseInt(value);
  }

  /**
   * Converts a String to a double.
   *
   * @param value the String to convert
   * @return the double value
   * @throws NumberFormatException if the string cannot be parsed as a double
   */
  public static double stringToDouble(String value) {
    return Double.parseDouble(value);
  }

  /**
   * Converts a String to a boolean.
   * "true" (ignoring case) returns true; anything else returns false.
   *
   * @param value the String to convert
   * @return the boolean value
   */
  public static boolean stringToBoolean(String value) {
    return Boolean.parseBoolean(value);
  }

  /**
   * Converts a String to a char.
   * Only the first character of the string is used.
   *
   * @param value the String to convert
   * @return the first character of the string
   * @throws StringIndexOutOfBoundsException if the string is empty
   */
  public static char stringToChar(String value) {
    return value.charAt(0);
  }

  /**
   * Converts an int to a double.
   *
   * @param value the integer value
   * @return the double value
   */
  public static double intToDouble(int value) {
    return value;
  }

  /**
   * Converts an int to a char using type casting.
   *
   * @param value the integer value
   * @return the corresponding char
   */
  public static char intToChar(int value) {
    return (char) value;
  }

  /**
   * Converts an int to a String.
   *
   * @param value the integer value
   * @return the String representation
   */
  public static String intToString(int value) {
    return String.valueOf(value);
  }

  /**
   * Converts a double to an int by truncating the fractional part.
   *
   * @param value the double value
   * @return the integer value
   */
  public static int doubleToInt(double value) {
    return (int) value;
  }

  /**
   * Converts a double to a String.
   *
   * @param value the double value
   * @return the String representation
   */
  public static String doubleToString(int value) {
    return String.valueOf(value);
  }

  /**
   * Converts a boolean to a String.
   *
   * @param value the boolean value
   * @return the String representation
   */
  public static String booleanToString(boolean value) {
    return String.valueOf(value);
  }
}
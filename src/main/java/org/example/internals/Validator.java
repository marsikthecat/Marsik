package org.example.internals;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class for validating strings and common data formats.
 * This class allows setting various validation rules such as length,
 * required characters (letters, digits, symbols), forbidden symbols,
 * and whitespace restrictions.
 * Contains static methods for common format validations (email, phone, URL, IP, MAC, ISO8601 date).
 */

public class Validator {

  private int minSize = 0;
  private int maxSize = Integer.MAX_VALUE;
  private final Set<Character> forbiddenSymbols = new HashSet<>();
  private static final Set<Character> SYMBOLS = Set.of(
          '!', '@', '#', '$', '%', '^', '&', '*', '(', ')',
          '-', '_', '=', '+', '[', ']', '{', '}', ';', ':',
          '\'', ',', '.', '<', '>', '?', '/', '|'
  );
  private boolean whiteSpaceForbidden = false;
  private int minLetters = 0;
  private int minDigits = 0;
  private int minSymbols = 0;
  private int minLowerCase = 0;
  private int minUpperCase = 0;

  /**
   * Utility class: No instantiation, bro.
   */
  private Validator() {}

  /**
   * Sets the minimum and maximum allowed length for the input string.
   *
   * @param minSize minimum length (must be >= 0)
   * @param maxSize maximum length (must be >= minSize)
   * @throws IllegalArgumentException if minSize < 0 or minSize > maxSize
   */
  public void requireLength(int minSize, int maxSize) {
    if (minSize > maxSize) {
      throw new IllegalArgumentException("Min-size cannot be bigger than maxsize, bro!");
    }
    if (minSize < 0) {
      throw new IllegalArgumentException("Sizes must be positive, bro!");
    }
    this.minSize = minSize;
    this.maxSize = maxSize;
  }

  /**
   * Marks specific characters as forbidden in the input string.
   *
   * @param chars characters to forbid
   */
  public void forbiddenSymbols(char... chars) {
    for (char c : chars) {
      forbiddenSymbols.add(c);
    }
  }

  /**
   * Configures whether whitespace is forbidden in the input string.
   *
   * @param forbid true to forbid whitespace, false otherwise
   */
  public void forbidWhiteSpace(boolean forbid) {
    this.whiteSpaceForbidden = forbid;
  }

  /**
   * Sets the minimum required number of letters.
   *
   * @param n number of letters (must be >= 0)
   * @throws IllegalArgumentException if n < 0
   */
  public void atLeastLetters(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Number must be positive or Zero");
    }
    this.minLetters = n;
  }

  /**
   * Sets the minimum required number of digits.
   *
   * @param n number of digits (must be >= 0)
   * @throws IllegalArgumentException if n < 0
   */
  public void atLeastDigits(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Number must be positive or Zero");
    }
    this.minDigits = n;
  }

  /**
   * Sets the minimum required number of symbols (from predefined SYMBOLS set).
   *
   * @param n number of symbols (must be >= 0)
   * @throws IllegalArgumentException if n < 0
   */
  public void atLeastSymbols(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Number must be positive or Zero");
    }
    this.minSymbols = n;
  }

  /**
   * Sets the minimum required number of lowercase letters.
   *
   * @param n number of lowercase letters (must be >= 0)
   * @throws IllegalArgumentException if n < 0
   */
  public void atLeastLowerCase(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Number must be positive or Zero");
    }
    this.minLowerCase = n;
  }

  /**
   * Sets the minimum required number of uppercase letters.
   *
   * @param n number of uppercase letters (must be >= 0)
   * @throws IllegalArgumentException if n < 0
   */
  public void atLeastUpperCase(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("Number must be positive or Zero");
    }
    this.minUpperCase = n;
  }

  /**
   * Validates whether the given string is a valid email.
   *
   * @param email string to validate
   * @return true if valid, false otherwise
   */
  public static boolean isValidEmail(String email) {
    return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
  }

  /**
   * Validates whether the given string is a valid phone number.
   *
   * @param phoneNumber string to validate
   * @return true if valid, false otherwise
   */
  public static boolean isValidPhoneNumber(String phoneNumber) {
    return phoneNumber.matches("\\+?(\\d{1,3})?[\\s.-]?\\(?\\d{1,4}\\)?[\\s.-]?\\d"
            + "{1,4}[\\s.-]?\\d{1,9}([\\s.-]?\\d{1,9})?");
  }

  /**
   * Validates whether the given string is a valid URL.
   *
   * @param url string to validate
   * @return true if valid, false otherwise
   */
  public static boolean isValidUrl(String url) {
    return url.matches("\\b[a-zA-Z][a-zA-Z0-9+\\-.]*://[^\\s/?#]+"
            + "(:\\d+)?(/[^\\s?#]*)?(\\?[^\\s#]*)?(#\\S*)?");
  }

  /**
   * Validates whether the given string is a valid IPv4 or IPv6 address.
   *
   * @param ip string to validate
   * @return true if valid, false otherwise
   */
  public static boolean isValidIpAddress(String ip) {
    return ip.matches("\\b((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\"
            + ".(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d))"
            + "{3})\\b|((([0-9a-fA-F]{1,4}:){7}([0-9a-fA-F]"
            + "{1,4}|:))|(([0-9a-fA-F]{1,4}:){1,7}:)|(([0-9a-fA-F]{1,4}:)"
            + "{1,6}:[0-9a-fA-F]{1,4})|(([0-9a-fA-F]{1,4}:){1,5}"
            + "(:[0-9a-fA-F]{1,4}){1,2})|(([0-9a-fA-F]{1,4}:){1,4}"
            + "(:[0-9a-fA-F]{1,4}){1,3})|(([0-9a-fA-F]{1,4}:)"
            + "{1,3}(:[0-9a-fA-F]{1,4}){1,4})|(([0-9a-fA-F]{1,4}:){1,2}"
            + "(:[0-9a-fA-F]{1,4}){1,5})|(([0-9a-fA-F]{1,4}:)"
            + "(:[0-9a-fA-F]{1,4}){1,6})|(:((:[0-9a-fA-F]{1,4})"
            + "{1,7}|:)))(%.+)?\\b");
  }

  /**
   * Validates whether the given string is a valid MAC address.
   *
   * @param macAddress string to validate
   * @return true if valid, false otherwise
   */
  public static boolean isValidMacAddress(String macAddress) {
    return macAddress.matches("\\b([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})\\b");
  }

  /**
   * Validates whether the given string matches ISO 8601 date format (YYYY-MM-DD).
   *
   * @param date string to validate
   * @return true if valid, false otherwise
   */
  public static boolean isValidIso860Date(String date) {
    return date.matches("\\b\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])\\b");
  }

  /**
   * Validates the input string against all configured rules.
   *
   * @param input string to validate
   * @return true if input passes all validation rules, false otherwise
   */
  public boolean validate(String input) {
    if (input.length() < minSize || input.length() > maxSize) {
      Sys.printError("Length of String doesn't fit: " + input.length()
              + ". Required: " + "At least " + minSize + " at most " + maxSize);
      return false;
    }

    int numberOfDigits = 0;
    int numberOfLetters = 0;
    int numberOfSymbols = 0;
    int numberOfLowerCaseLetters = 0;
    int numberOfUpperCaseLetters = 0;

    for (char c : input.toCharArray()) {
      if (Character.isDigit(c)) {
        numberOfDigits++;
      }
      if (Character.isLetter(c)) {
        numberOfLetters++;
      }
      if (SYMBOLS.contains(c)) {
        numberOfSymbols++;
      }
      if (Character.isLowerCase(c)) {
        numberOfLowerCaseLetters++;
      }
      if (Character.isUpperCase(c)) {
        numberOfUpperCaseLetters++;
      }
      if (whiteSpaceForbidden && Character.isWhitespace(c)) {
        Sys.printError("Whitespace forbidden but found: '" + c + "'");
        return false;
      }
      if (forbiddenSymbols.contains(c)) {
        Sys.printError("Forbidden symbol detected: '" + c + "'");
        return false;
      }
    }

    if (numberOfDigits < minDigits) {
      Sys.printError("At least " + minDigits + " Digits required!");
      return false;
    }
    if (numberOfLetters < minLetters) {
      Sys.printError("At least " + minLetters + " Letters required!");
      return false;
    }
    if (numberOfSymbols < minSymbols) {
      Sys.printError("At least " + minSymbols + " Symbols required!");
      return false;
    }
    if (numberOfLowerCaseLetters < minLowerCase) {
      Sys.printError("At least " + minLowerCase + " Lowercase letters required!");
      return false;
    }
    if (numberOfUpperCaseLetters < minUpperCase) {
      Sys.printError("At least " + minUpperCase + " Uppercase letters required!");
      return false;
    }
    return true;
  }
}
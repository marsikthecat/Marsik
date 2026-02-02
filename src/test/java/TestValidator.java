import org.example.internals.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestValidator {

  @Test
  void requireLengthThrowsExceptionWhenMinSizeIsNegative() {
    assertThrows(IllegalArgumentException.class, () -> Validator.requireLength(-1, 5));
  }

  @Test
  void requireLengthThrowsExceptionWhenMinSizeGreaterThanMaxSize() {
    assertThrows(IllegalArgumentException.class, () -> Validator.requireLength(10, 5));
  }

  @Test
  void requireLengthSetsValidMinAndMaxSize() {
    Validator.requireLength(5, 10);
    assertTrue(Validator.validate("12345"));
    assertTrue(Validator.validate("abcdefg"));
    assertFalse(Validator.validate("1234"));
    assertFalse(Validator.validate("12345678901"));
  }

  @Test
  void forbiddenSymbolsRejectsStringWithForbiddenCharacters() {
    Validator.reset();
    Validator.forbiddenSymbols('!', '@', '#');
    assertFalse(Validator.validate("Hello!"));
    assertFalse(Validator.validate("Test@123"));
    assertTrue(Validator.validate("Are you sure?"));
    assertTrue(Validator.validate("Hello123"));
  }

  @Test
  void forbidWhiteSpaceRejectsStringWithSpacesWhenEnabled() {
    Validator.reset();
    Validator.forbidWhiteSpace(true);
    assertFalse(Validator.validate("Hello World"));
    assertTrue(Validator.validate("HelloWorld"));
  }

  @Test
  void atLeastLettersThrowsExceptionForNegativeInput() {
    assertThrows(IllegalArgumentException.class, () -> Validator.atLeastLetters(-1));
  }

  @Test
  void atLeastLettersValidatesMinimumLetters() {
    Validator.reset();
    Validator.atLeastLetters(3);
    assertTrue(Validator.validate("abc123"));
    assertFalse(Validator.validate("12345"));
    assertFalse(Validator.validate("12"));
  }

  @Test
  void atLeastDigitsThrowsExceptionForNegativeInput() {
    assertThrows(IllegalArgumentException.class, () -> Validator.atLeastDigits(-1));
  }

  @Test
  void atLeastDigitsValidatesMinimumDigits() {
    Validator.reset();
    Validator.atLeastDigits(2);
    assertTrue(Validator.validate("a1b2"));
    assertFalse(Validator.validate("abc"));
  }

  @Test
  void atLeastSymbolsThrowsExceptionForNegativeInput() {
    assertThrows(IllegalArgumentException.class, () -> Validator.atLeastSymbols(-1));
  }

  @Test
  void atLeastSymbolsValidatesMinimumSymbols() {
    Validator.reset();
    Validator.atLeastSymbols(2);
    assertTrue(Validator.validate("a!@"));
    assertFalse(Validator.validate("a1b2c3%"));
    assertFalse(Validator.validate("abc"));
  }

  @Test
  void atLeastLowerCaseThrowsExceptionForNegativeInput() {
    assertThrows(IllegalArgumentException.class, () -> Validator.atLeastLowerCase(-1));
  }

  @Test
  void atLeastLowerCaseValidatesMinimumLowerCaseLetters() {
    Validator.reset();
    Validator.atLeastLowerCase(2);
    assertTrue(Validator.validate("aabbCC"));
    assertTrue(Validator.validate("abAB"));
    assertFalse(Validator.validate("AABBCC"));
  }

  @Test
  void atLeastUpperCaseThrowsExceptionForNegativeInput() {
    assertThrows(IllegalArgumentException.class, () -> Validator.atLeastUpperCase(-1));
  }

  @Test
  void atLeastUpperCaseValidatesMinimumUpperCaseLetters() {
    Validator.reset();
    Validator.atLeastUpperCase(2);
    assertTrue(Validator.validate("ABc"));
    assertFalse(Validator.validate("aa"));
  }

  @Test
  void validEmailReturnsTrue() {
    assertTrue(Validator.isValidEmail("test@example.com"));
    assertTrue(Validator.isValidEmail("user.name+tag+sorting@example.com"));
    assertTrue(Validator.isValidEmail("user_name@example.co.uk"));
  }

  @Test
  void invalidEmailReturnsFalse() {
    assertFalse(Validator.isValidEmail("plainaddress"));
    assertFalse(Validator.isValidEmail("@missingusername.com"));
    assertFalse(Validator.isValidEmail("username@.com"));
    assertFalse(Validator.isValidEmail("username@com"));
    assertFalse(Validator.isValidEmail("username@.com."));
  }

  @Test
  void validPhoneNumberReturnsTrue() {
    assertTrue(Validator.isValidPhoneNumber("+1234567890"));
    assertTrue(Validator.isValidPhoneNumber("123-456-7890"));
    assertTrue(Validator.isValidPhoneNumber("(123) 456-7890"));
  }

  @Test
  void invalidPhoneNumberReturnsFalse() {
    assertFalse(Validator.isValidPhoneNumber("12345+"));
    assertFalse(Validator.isValidPhoneNumber("phone123"));
    assertFalse(Validator.isValidPhoneNumber("123-abc-7890"));
  }

  @Test
  void validUrlReturnsTrue() {
    assertTrue(Validator.isValidUrl("http://example.com"));
    assertTrue(Validator.isValidUrl("https://www.example.com"));
    assertTrue(Validator.isValidUrl("ftp://files.example.com"));
  }

  @Test
  void invalidUrlReturnsFalse() {
    // TODO: fix that
    assertFalse(Validator.isValidUrl("htp://example.com"));
    assertFalse(Validator.isValidUrl("://missingprotocol.com"));
    assertFalse(Validator.isValidUrl("http//missingcolon.com"));
  }

  @Test
  void validIpAddressReturnsTrue() {
    assertTrue(Validator.isValidIpAddress("192.168.1.1"));
    assertTrue(Validator.isValidIpAddress("255.255.255.255"));
    assertTrue(Validator.isValidIpAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334"));
  }

  @Test
  void invalidIpAddressReturnsFalse() {
    assertFalse(Validator.isValidIpAddress("256.256.256.256"));
    assertFalse(Validator.isValidIpAddress("192.168.1"));
    assertFalse(Validator.isValidIpAddress("2001:db8:::1"));
  }

  @Test
  void validMacAddressReturnsTrue() {
    assertTrue(Validator.isValidMacAddress("00:1A:2B:3C:4D:5E"));
    assertTrue(Validator.isValidMacAddress("00-1A-2B-3C-4D-5E"));
  }

  @Test
  void invalidMacAddressReturnsFalse() {
    assertFalse(Validator.isValidMacAddress("00:1A:2B:3C:4D"));
    assertFalse(Validator.isValidMacAddress("001A2B3C4D5E"));
    assertFalse(Validator.isValidMacAddress("00:1A:2B:3C:4D:5G"));
  }

  @Test
  void validIso8601DateReturnsTrue() {
    assertTrue(Validator.isValidIso860Date("2023-12-25"));
    assertTrue(Validator.isValidIso860Date("2000-02-29"));
  }

  @Test
  void invalidIso8601DateReturnsFalse() {
    assertFalse(Validator.isValidIso860Date("2023-13-01"));
    assertFalse(Validator.isValidIso860Date("2023/12/25"));
  }

}
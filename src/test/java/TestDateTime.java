import org.example.internals.time.DateTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestDateTime {

  @Test
  void createsNewDateTimeWithYearOnly() {
    String result = DateTime.newDateTime(2023);
    assertEquals("2023-01-01T00:00:00", result);
  }

  @Test
  void createsNewDateTimeWithYearMonthDay() {
    String result = DateTime.newDateTime(2023, 12, 25);
    assertEquals("2023-12-25T00:00:00", result);
  }

  @Test
  void createsNewDateTimeWithoutSeconds() {
    String result = DateTime.newDateTime(2023, 12, 25, 15, 30);
    assertEquals("2023-12-25T15:30:00", result);
  }

  @Test
  void createsFullySpecifiedDateTime() {
    String result = DateTime.newDateTime(2023, 12, 25, 15, 30, 45);
    assertEquals("2023-12-25T15:30:45", result);
  }

  @Test
  void extractsYearFromDateTimeString() {
    int result = DateTime.year("2023-12-25T15:30:45");
    assertEquals(2023, result);
  }

  @Test
  void extractsMonthFromDateTimeString() {
    int result = DateTime.month("2023-12-25T15:30:45");
    assertEquals(12, result);
  }

  @Test
  void extractsDayFromDateTimeString() {
    int result = DateTime.day("2023-12-25T15:30:45");
    assertEquals(25, result);
  }

  @Test
  void extractsHourFromDateTimeString() {
    int result = DateTime.hour("2023-12-25T15:30:45");
    assertEquals(15, result);
  }

  @Test
  void extractsMinuteFromDateTimeString() {
    int result = DateTime.minute("2023-12-25T15:30:45");
    assertEquals(30, result);
  }

  @Test
  void extractsSecondFromDateTimeString() {
    int result = DateTime.second("2023-12-25T15:30:45");
    assertEquals(45, result);
  }

  @Test
  void extractsMillisecondFromDateTimeString() {
    int result = DateTime.millisecond("2023-12-25T15:30:45.123");
    assertEquals(123, result);
  }

  @org.junit.jupiter.api.Test
  void addsYearsToDateTime() {
    String result = DateTime.addYears("2023-12-25T15:30:45", 2);
    assertEquals("2025-12-25T15:30:45", result);
  }

  @Test
  void addsMonthsToDateTime() {
    String result = DateTime.addMonths("2023-12-25T15:30:45", 2);
    assertEquals("2024-02-25T15:30:45", result);
  }

  @Test
  void addsDaysToDateTime() {
    String result = DateTime.addDays("2023-12-25T15:30:45", 7);
    assertEquals("2024-01-01T15:30:45", result);
  }

  @Test
  void addsHoursToDateTime() {
    String result = DateTime.addHours("2023-12-25T15:30:45", 10);
    assertEquals("2023-12-26T01:30:45", result);
  }

  @Test
  void addsMinutesToDateTime() {
    String result = DateTime.addMinutes("2023-12-25T15:30:45", 90);
    assertEquals("2023-12-25T17:00:45", result);
  }

  @Test
  void addsSecondsToDateTime() {
    String result = DateTime.addSeconds("2023-12-25T15:30:45", 75);
    assertEquals("2023-12-25T15:32:00", result);
  }

  @Test
  void determinesLeapYearCorrectly() {
    assertTrue(DateTime.isLeapYear("2020-01-01T00:00:00"));
    assertFalse(DateTime.isLeapYear("2023-01-01T00:00:00"));
  }

  @Test
  void convertsToUtcStringCorrectly() {
    String result = DateTime.toUtcString("2023-12-25T15:30:45");
    assertEquals("Mon, 25 Dec 2023 15:30:45 GMT", result);
  }

  @Test
  void replacesYearInDateTimeString() {
    String result = DateTime.setYears("2023-12-25T15:30:45", 2025);
    assertEquals("2025-12-25T15:30:45", result);
  }

  @Test
  void replacesMonthInDateTimeString() {
    String result = DateTime.setMonths("2023-12-25T15:30:45", 11);
    assertEquals("2023-11-25T15:30:45", result);
  }

  @Test
  void throwsExceptionForInvalidMonth() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      DateTime.setMonths("2023-12-25T15:30:45", 13);
    });
    assertEquals("Invalid months: 13", exception.getMessage());
  }

  @Test
  void replacesDayInDateTimeString() {
    String result = DateTime.setDays("2023-12-25T15:30:45", 15);
    assertEquals("2023-12-15T15:30:45", result);
  }

  @Test
  void replacesHourInDateTimeString() {
    String result = DateTime.setHours("2023-12-25T15:30:45", 10);
    assertEquals("2023-12-25T10:30:45", result);
  }

  @Test
  void replacesMinuteInDateTimeString() {
    String result = DateTime.setMinutes("2023-12-25T15:30:45", 45);
    assertEquals("2023-12-25T15:45:45", result);
  }

  @Test
  void replacesSecondInDateTimeString() {
    String result = DateTime.setSeconds("2023-12-25T15:30:45", 50);
    assertEquals("2023-12-25T15:30:50", result);
  }

  @Test
  void replacesMillisecondInDateTimeString() {
    String result = DateTime.setMilliseconds("2023-12-25T15:30:45.123", 456);
    assertEquals("2023-12-25T15:30:45.456", result);
  }

  @Test
  void returnsCurrentMonthNameCorrectly() {
    String result = DateTime.currentMonthName();
    assertNotNull(result);
    assertTrue(result.matches("January|February|March|April|May|June|July|August|September|October|November|December"));
  }

  @Test
  void returnsCurrentDayNameCorrectly() {
    String result = DateTime.currentFullDayName();
    assertNotNull(result);
    // You need to manually insert the current day name here in your language!
    assertEquals("Samstag", result);
  }
}
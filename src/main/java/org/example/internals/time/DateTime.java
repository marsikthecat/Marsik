package org.example.internals.time;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Utility class for date and time operations.
 * Works with ISO-8601 formatted date-time strings and provides
 * creation, extraction, modification and calculation methods.
 */

public class DateTime {

  /**
   * Utility class – no instantiation, bro.
   */
  private DateTime() {}

  /**
   * Creates a new date-time with only the year specified.
   * Month and day are set to January 1st, time is set to 00:00:00.
   *
   * @param year the year
   * @return new date-time as a String
   */
  public static String newDateTime(int year) {
    LocalDateTime newDateTime = LocalDateTime.of(year, 1, 1, 0, 0, 0);
    return newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  /**
   * Creates a new date-time with year, month and day.
   * Time is set to 00:00:00.
   *
   * @param year  the year
   * @param month the month (1–12)
   * @param day   the day of month
   * @return new date-time as a String
   */
  public static String newDateTime(int year, int month, int day) {
    LocalDateTime newDateTime = LocalDateTime.of(year, month, day, 0, 0, 0);
    return newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  /**
   * Creates a new date-time without seconds.
   *
   * @param year   the year
   * @param month  the month
   * @param day    the day
   * @param hour   the hour
   * @param minute the minute
   * @return new date-time as a String
   */
  public static String newDateTime(int year, int month, int day, int hour, int minute) {
    LocalDateTime newDateTime = LocalDateTime.of(year, month, day, hour, minute, 0);
    return newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  /**
   * Creates a fully specified date-time.
   *
   * @param year   the year
   * @param month  the month
   * @param day    the day
   * @param hour   the hour
   * @param minute the minute
   * @param second the second
   * @return new date-time as a String
   */
  public static String newDateTime(int year, int month, int day, int hour,
                                        int minute, int second) {
    LocalDateTime newDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
    return newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  /**
   * Returns the timestamp captured when the class was initialized.
   *
   * @return date-time as a String
   */
  public static String now() {
    return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  /**
   * Extracts the year from a date-time string.
   *
   * @param string date-time in ISO format
   * @return the year
   */
  public static int year(String string) {
    return Integer.parseInt(string.substring(0, 4));
  }

  /**
   * Extracts the month from a date-time string.
   *
   * @param string date-time in ISO format
   * @return the month (1–12)
   */
  public static int month(String string) {
    return Integer.parseInt(string.substring(5, 7));
  }

  /**
   * Returns the English month name of the given date.
   *
   * @param string date-time
   * @return month name as a String
   */
  public static String monthName(String string) {
    return switch (month(string)) {
      case 1 -> "January";
      case 2 -> "February";
      case 3 -> "March";
      case 4 -> "April";
      case 5 -> "May";
      case 6 -> "June";
      case 7 -> "July";
      case 8 -> "August";
      case 9 -> "September";
      case 10 -> "October";
      case 11 -> "November";
      case 12 -> "December";
      default -> throw new IllegalStateException("Unexpected value:" + string);
    };
  }

  /**
   * Returns the full name of the current day (e.g. "Monday").
   *
   * @return current day name as a String
   */
  public static String currentFullDayName() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
    return simpleDateFormat.format(new Date());
  }

  /**
   * Returns the full name of the current month.
   *
   * @return current month name as a String
   */
  public static String currentMonthName() {
    return monthName(now());
  }

  /**
   * Extracts the day of month from an ISO-8601 date-time string.
   *
   * @param string date-time in ISO-8601 format
   * @return day of month (1–31)
   * @throws NumberFormatException if the extracted value is not numeric
   * @throws StringIndexOutOfBoundsException if the string is too short
   */
  public static int day(String string) {
    return Integer.parseInt(string.substring(8, 10));
  }

  /**
   * Extracts the hour component from an ISO-8601 date-time string.
   *
   * @param string date-time in ISO-8601 format
   * @return hour value (0–23)
   * @throws NumberFormatException if the extracted value is not numeric
   * @throws StringIndexOutOfBoundsException if the string is too short
   */
  public static int hour(String string) {
    return Integer.parseInt(string.substring(11, 13));
  }

  /**
   * Extracts the minute component from an ISO-8601 date-time string.
   *
   * @param string date-time in ISO-8601 format
   * @return minute value (0–59)
   * @throws NumberFormatException if the extracted value is not numeric
   * @throws StringIndexOutOfBoundsException if the string is too short
   */
  public static int minute(String string) {
    return Integer.parseInt(string.substring(14, 16));
  }

  /**
   * Extracts the second component from an ISO-8601 date-time string.
   *
   * @param string date-time in ISO-8601 format
   * @return second value (0–59)
   * @throws NumberFormatException if the extracted value is not numeric
   * @throws StringIndexOutOfBoundsException if the string is too short
   */
  public static int second(String string) {
    return Integer.parseInt(string.substring(17, 19));
  }

  /**
   * Extracts the millisecond component from an ISO-8601 date-time string.
   * This method assumes the presence of milliseconds in the format
   * {@code yyyy-MM-dd'T'HH:mm:ss.SSS}.
   *
   * @param string date-time in ISO-8601 format with milliseconds
   * @return millisecond value (0–999)
   * @throws NumberFormatException if the extracted value is not numeric
   * @throws StringIndexOutOfBoundsException if the string is too short
   */
  public static int millisecond(String string) {
    return Integer.parseInt(string.substring(20, 24));
  }

  /**
   * Adds years to a date-time.
   *
   * @param date base date
   * @param years number of years to add
   * @return modified date-time
   */
  public static String addYears(String date, int years) {
    LocalDateTime localDateTime1 = LocalDateTime.parse(date,
            DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    LocalDateTime newlocalDateTime = localDateTime1.plusYears(years);
    return newlocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  /**
   * Adds months to a date-time.
   *
   * @param date base date
   * @param months number of years to add
   * @return modified date-time
   */
  public static String addMonths(String date, int months) {
    LocalDateTime localDateTime1 = LocalDateTime.parse(date,
            DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    LocalDateTime newlocalDateTime = localDateTime1.plusMonths(months);
    return newlocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  /**
   * Adds days to a date-time.
   *
   * @param date base date
   * @param days number of days to add
   * @return modified date-time
   */
  public static String addDays(String date, int days) {
    LocalDateTime localDateTime1 = LocalDateTime.parse(date,
            DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    LocalDateTime newlocalDateTime = localDateTime1.plusDays(days);
    return newlocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  /**
   * Adds hours to a date-time.
   *
   * @param date base date
   * @param hours number of hours to add
   * @return modified date-time
   */
  public static String addHours(String date, int hours) {
    LocalDateTime localDateTime1 = LocalDateTime.parse(date,
            DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    LocalDateTime newlocalDateTime = localDateTime1.plusHours(hours);
    return newlocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  /**
   * Adds minutes to a date-time.
   *
   * @param date base date
   * @param minutes number of minutes to add
   * @return modified date-time
   */
  public static String addMinutes(String date, int minutes) {
    LocalDateTime localDateTime1 = LocalDateTime.parse(date,
            DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    LocalDateTime newlocalDateTime = localDateTime1.plusMinutes(minutes);
    return newlocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  /**
   * Adds years to a date-time.
   *
   * @param date base date
   * @param seconds number of seconds to add
   * @return modified date-time
   */
  public static String addSeconds(String date, int seconds) {
    LocalDateTime localDateTime = LocalDateTime.parse(date,
            DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    LocalDateTime newlocalDateTime = localDateTime.plusSeconds(seconds);
    return newlocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
  }

  /**
   * Replaces the year component of the given date-time.
   * This method performs a direct string replacement and does not validate
   * whether the resulting date is semantically valid.
   *
   * @param date  date-time in ISO-8601 format
   * @param years new year value (e.g. 2026)
   * @return modified date-time as a String
   */
  public static String setYears(String date, int years) {
    return replacePartOfString(date, 0, 4, String.valueOf(years));
  }

  /**
   * Replaces the month component of the given date-time.
   * Month is expected to be in the range 01–12. No validation is performed.
   *
   * @param date   date-time in ISO-8601 format
   * @param months new month value
   * @return modified date-time as a String
   */
  public static String setMonths(String date, int months) {
    if (months < 0 || months > 12) {
      throw new IllegalArgumentException("Invalid months: " + months);
    }
    return replacePartOfString(date, 5, 7, String.valueOf(months));
  }

  /**
   * Replaces the day component of the given date-time.
   *
   * @param date date-time in ISO-8601 format
   * @param days new day of month
   * @return modified date-time as a String
   */
  public static String setDays(String date, int days) {
    return replacePartOfString(date, 8, 10, String.valueOf(days));
  }

  /**
   * Replaces the hour component of the given date-time.
   *
   * @param date  date-time in ISO-8601 format
   * @param hours new hour value (0–23)
   * @return modified date-time as a String
   */
  public static String setHours(String date, int hours) {
    return replacePartOfString(date, 11, 13, String.valueOf(hours));
  }

  /**
   * Replaces the minute component of the given date-time.
   *
   * @param date    date-time in ISO-8601 format
   * @param minutes new minute value (0–59)
   * @return modified date-time as a String
   */
  public static String setMinutes(String date, int minutes) {
    return replacePartOfString(date, 14, 16, String.valueOf(minutes));
  }

  /**
   * Replaces the second component of the given date-time.
   *
   * @param date    date-time in ISO-8601 format
   * @param seconds new second value (0–59)
   * @return modified date-time as a String
   */
  public static String setSeconds(String date, int seconds) {
    return replacePartOfString(date, 17, 19, String.valueOf(seconds));
  }

  /**
   * Replaces the millisecond component of the given date-time.
   * This method assumes the date-time string contains milliseconds.
   *
   * @param date         date-time in ISO-8601 format
   * @param milliseconds new millisecond value
   * @return modified date-time as a String
   */
  public static String setMilliseconds(String date, int milliseconds) {
    return replacePartOfString(date, 20, 24, String.valueOf(milliseconds));
  }

  /**
   * Replaces a specific part of a date-time string with a new value.
   * This method performs a direct character-level replacement on the underlying
   * ISO-8601 date-time string. No validation is performed to ensure that the
   * resulting date-time is semantically valid.
   *
   * @param a           the original date-time as a String
   * @param begin       start index (inclusive) of the replacement range
   * @param end         end index (exclusive) of the replacement range
   * @param replacement replacement string whose length must match (end - begin)
   * @return a new String with the replaced segment
   * @throws StringIndexOutOfBoundsException if indices are invalid or replacement length mismatches
   */
  private static String replacePartOfString(String a, int begin,
                                                 int end, String replacement) {
    char[] chars = a.toCharArray();
    for (int i = begin; i < end; i++) {
      chars[i] = replacement.charAt(i -  begin);
    }
    return new String(chars);
  }

  /**
   * Determines whether the year of the given date-time is a leap year.
   * Leap year rules:
   * <ul>
   *   <li>Divisible by 4 → leap year</li>
   *   <li>Divisible by 100 → not a leap year</li>
   *   <li>Divisible by 400 → leap year</li>
   * </ul>
   *
   * @param date date-time in ISO-8601 format
   * @return {@code true} if the year is a leap year, otherwise {@code false}
   */
  public static boolean isLeapYear(String date) {
    int year = year(date);
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
  }

  /**
   * Converts a local ISO-8601 date-time into a UTC string representation.
   * The returned string follows the RFC 1123 date-time format and is expressed
   * in the GMT (UTC) time zone.
   *
   * @param string date-time in ISO-8601 format
   * @return UTC date-time formatted according to RFC 1123 as a String
   */
  public static String toUtcString(String string) {
    LocalDateTime localDateTime = LocalDateTime.parse(string,
            DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    ZonedDateTime now = ZonedDateTime.of(localDateTime, ZoneId.of("GMT"));
    return now.withZoneSameInstant(ZoneId.of("GMT"))
            .format(DateTimeFormatter.RFC_1123_DATE_TIME);
  }
}
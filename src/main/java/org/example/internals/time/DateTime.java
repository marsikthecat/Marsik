package org.example.internals.time;

import org.example.internals.datastructures.MarsikString;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

public class DateTime {

  private static final LocalDateTime localDateTime = LocalDateTime.now();

  public static MarsikString newDateTime(int year) {
    LocalDateTime newDateTime = LocalDateTime.of(year, 1, 1, 0, 0, 0);
    return new MarsikString(newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }

  public static MarsikString newDateTime(int year, int month, int day) {
    LocalDateTime newDateTime = LocalDateTime.of(year, month, day, 0, 0, 0);
    return  new MarsikString(newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }

  public static MarsikString newDateTime(int year, int month, int day, int hour, int minute) {
    LocalDateTime newDateTime = LocalDateTime.of(year, month, day, hour, minute, 0);
    return new MarsikString(newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }

  public static MarsikString newDateTime(int year, int month, int day, int hour, int minute, int second) {
    LocalDateTime newDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
    return new MarsikString(newDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }

  public static MarsikString now() {
    return new MarsikString(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }

  public static int year(MarsikString string) {
    return Integer.parseInt(string.subString(0, 4).toJavaString());
  }

  public static int month(MarsikString string) {
    return Integer.parseInt(string.subString(5, 7).toJavaString());
  }

  public static MarsikString monthName(MarsikString string) {
    return switch (month(string)) {
      case 1 -> new MarsikString("January");
      case 2 -> new MarsikString("February");
      case 3 -> new MarsikString("March");
      case 4 -> new MarsikString("April");
      case 5 -> new MarsikString("May");
      case 6 -> new MarsikString("June");
      case 7 -> new MarsikString("July");
      case 8 -> new MarsikString("August");
      case 9 -> new MarsikString("September");
      case 10 -> new MarsikString("October");
      case 11 -> new MarsikString("November");
      case 12 -> new MarsikString("December");
      default -> throw new IllegalStateException("Unexpected value:" + string);
    };
  }

  public static MarsikString currentFullDayName() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
    return new MarsikString(simpleDateFormat.format(new Date()));
  }

  public static MarsikString currentMonthName() {
    return monthName(now());
  }

  public static int day(MarsikString string) {
    return Integer.parseInt(string.subString(8, 10).toJavaString());
  }

  public static int hour(MarsikString string) {
    return Integer.parseInt(string.subString(11, 13).toJavaString());
  }

  public static int minute(MarsikString string) {
    return Integer.parseInt(string.subString(14, 16).toJavaString());
  }

  public static int second(MarsikString string) {
    return Integer.parseInt(string.subString(17, 19).toJavaString());
  }

  public static int millisecond(MarsikString string) {
    return Integer.parseInt(string.subString(20, 24).toJavaString());
  }

  public static MarsikString addYears(MarsikString date, int years) {
    LocalDateTime localDateTime1 = LocalDateTime.parse(date.toJavaString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    LocalDateTime newlocalDateTime = localDateTime1.plusYears(years);
    return new MarsikString(newlocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)) ;
  }

  public static MarsikString addMonths(MarsikString date, int months) {
    LocalDateTime localDateTime1 = LocalDateTime.parse(date.toJavaString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    LocalDateTime newlocalDateTime = localDateTime1.plusMonths(months);
    return new MarsikString(newlocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }

  public static MarsikString addDays(MarsikString date, int days) {
    LocalDateTime localDateTime1 = LocalDateTime.parse(date.toJavaString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    LocalDateTime newlocalDateTime = localDateTime1.plusDays(days);
    return new MarsikString(newlocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }

  public static MarsikString addHours(MarsikString date, int hours) {
    LocalDateTime localDateTime1 = LocalDateTime.parse(date.toJavaString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    LocalDateTime newlocalDateTime = localDateTime1.plusHours(hours);
    return new MarsikString(newlocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)) ;
  }

  public static MarsikString addMinutes(MarsikString date, int minutes) {
    LocalDateTime localDateTime1 = LocalDateTime.parse(date.toJavaString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    LocalDateTime newlocalDateTime = localDateTime1.plusMinutes(minutes);
    return new MarsikString(newlocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }

  public static MarsikString addSeconds(MarsikString date, int seconds) {
    LocalDateTime localDateTime = LocalDateTime.parse(date.toJavaString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    LocalDateTime newlocalDateTime = localDateTime.plusSeconds(seconds);
    return new MarsikString(newlocalDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
  }

  public static MarsikString setYears(MarsikString date, int years) {
    return replacePartOfString(date, 0, 4, String.valueOf(years));
  }

  public static MarsikString setMonths(MarsikString date, int months) {
    return replacePartOfString(date, 5, 7, String.valueOf(months));
  }

  public static MarsikString setDays(MarsikString date, int days) {
    return replacePartOfString(date, 8, 10, String.valueOf(days));
  }

  public static MarsikString setHours(MarsikString date, int hours) {
    return replacePartOfString(date, 11, 13, String.valueOf(hours));
  }

  public static MarsikString setMinutes(MarsikString date, int minutes) {
    return replacePartOfString(date, 14, 16, String.valueOf(minutes));
  }

  public static MarsikString setSeconds(MarsikString date, int seconds) {
    return replacePartOfString(date, 17, 19, String.valueOf(seconds));
  }

  public static MarsikString setMilliseconds(MarsikString date, int milliseconds) {
    return replacePartOfString(date, 20, 24, String.valueOf(milliseconds));
  }

  private static MarsikString replacePartOfString(MarsikString a, int begin, int end, String replacement) {
    String s = a.toJavaString();
    char[] chars = s.toCharArray();
    for (int i = begin; i < end; i++) {
      chars[i] = replacement.charAt(i -  begin);
    }
    return new MarsikString(Arrays.toString(chars));
  }

  public static boolean isLeapYear(MarsikString date) {
    int year = year(date);
    return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
  }

  public MarsikString toUtcString(String date) {
    LocalDateTime localDateTime = LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    ZonedDateTime now = ZonedDateTime.of(localDateTime, ZoneId.of("GMT"));
    String s = now.withZoneSameInstant(ZoneId.of("GMT")).format(DateTimeFormatter.RFC_1123_DATE_TIME);
    return new MarsikString(s);
  }
}
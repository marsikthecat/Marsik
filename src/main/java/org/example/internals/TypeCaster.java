package org.example.internals;

import org.example.internals.datastructures.MarsikString;

public class TypeCaster {

  public static int stringToInt(MarsikString value) {
    return Integer.parseInt(value.toJavaString());
  }

  public static double stringToDouble(MarsikString value) {
    return Double.parseDouble(value.toJavaString());
  }

  public static boolean stringToBoolean(MarsikString value) {
    return Boolean.parseBoolean(value.toJavaString());
  }

  public static char stringToChar(MarsikString value) {
    return value.toJavaString().charAt(0);
  }

  public static double intToDouble(int value) {
    return value;
  }

  public static char intToChar(int value) {
    return (char) value;
  }

  public static MarsikString intToString(int value) {
    return new MarsikString(String.valueOf(value));
  }

  public static int doubleToInt(double value) {
    return (int) value;
  }

  public static MarsikString doubleToString(int value) {
    return new MarsikString(String.valueOf(value));
  }

  public static String booleanToString(boolean value) {
    return String.valueOf(value);
  }
}
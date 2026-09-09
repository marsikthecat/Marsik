package org.example.compiler;

import java.util.ArrayList;

public class LibraryDispatch {

  private final ArrayList<MarsikPerfectHashMap<String>> libraryMethods = new ArrayList<>(4);

  public LibraryDispatch() {
    libraryMethods.add(new MarsikPerfectHashMap<>(
                   "roundBasic", "roundUp", "roundDown", "ln", "logarithm", "ePowX",
                   "gcd", "scd", "modInverse", "factorial", "fibonacci", "hypotenuse", "hypotenuse3D",
                   "isEven", "isNegative", "isPrime", "areCongruentModuloM", "calculateCapital", "increasingSum",
                   "max", "min", "sum", "avg", "median", "randomInt", "randomDouble", "variance",
                   "standardDeviation", "binomialCoefficient", "squareRoot", "cubeRoot", "toRadians",
                   "toDegrees", "posDifference", "sine", "cosine", "tangent", "asine", "acosine",
                   "atangent", "pi", "e", "phi"));
                   
    libraryMethods.add(new MarsikPerfectHashMap<>(
                    "now", "currentDateISO", "currentMillis", "currentYear", "currentMonth",
                    "currentDay", "currentHour", "currentMinute", "currentSeconds", "currentDateTime",
                    "getSeconds", "getMinutes", "getHours", "getDay", "getMonth", "getYear", "setSeconds",
                    "setMinutes", "setHours", "setDay", "setMonth", "setYear", "isLeapYear",
                    "isBefore", "isAfter", "toIsoFormat", "monthName", "dayName"));
                    
    libraryMethods.add(new MarsikPerfectHashMap<>(
                    "intToDouble", "intToChar", "intToString", "booleanToString",
                    "doubleToInt", "doubleToString", "stringToInt", "stringToBoolean",
                    "stringToDouble", "booleanToInt", "intToBoolean"));

    libraryMethods.add(new MarsikPerfectHashMap<>(
                    "writeContentToFile", "appendContentToFile", "clearFile",
                    "doesFileExist", "deleteFile", "readFile", "createFile"));
  }

  /**
   * Returns whether the runtime provides the given method for the given library.
   */
  public boolean isLibraryMethod(String libraryName, String method) {
    if (libraryName == null || method == null) {
      return false;
    }

    int idx = switch (libraryName) {
      case "Math" -> 0;
      case "DateTime" -> 1;
      case "Caster" -> 2;
      case "FileHandler" -> 3;
      default -> -1;
    };
    if (idx < 0) {
      return false;
    }

    MarsikPerfectHashMap<String> methods = libraryMethods.get(idx);
    String methodName = methods.get(method);
    return methodName != null && methodName.equals(method);
  }
}
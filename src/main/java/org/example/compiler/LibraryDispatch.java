package org.example.compiler;

import java.util.ArrayList;

public class LibraryDispatch {

  private final String[] libraryNames = {"FileHandler", "DateTime", "Caster", "Math"};

  private final ArrayList<MarsikPerfectHashMap<String>> libraryMethods = new ArrayList<>(4);

  public LibraryDispatch() {
    libraryMethods.add(new MarsikPerfectHashMap<>(
                   "roundBasic", "roundUp", "roundDown", "ln", "logarithm", "ePowX",
                   "gcd", "scd", "modInverse", "factorial", "fibonacci", "hypotenuse", "hypotenuse3D",
                   "isEven", "isPrime", "areCongruentModuloM", "calculateCapital", "increasingSum",
                   "max", "min", "sum", "avg", "median", "randomInt", "randomDouble", "variance",
                   "standardDeviation", "binomialCoefficient", "squareRoot", "cubeRoot", "toRadians",
                   "toDegrees", "posDifference", "sine", "cosine", "tangent", "asine", "aconsine",
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
   * Checks whether the library and the method is supported in the runtime.
   */
  public void checkLibraryAndMethodExistence(String libraryName, String method) {
      // Perfect hash function for the 4 library name keys:
      // "Caster" -> 2, "Math" -> 0, "FileHandler" -> 3, "DateTime" -> 1
      int idx = libraryName.charAt(0) % 4;
      if (!libraryName.equals(libraryNames[idx])) {
        return;
      }
      MarsikPerfectHashMap<String> methods = libraryMethods.get(idx);
      String methodName = methods.get(method);
      if (methodName == null || !methodName.equals(method)) {
        throw new RuntimeException("Runtime method " + method + " for " + libraryName + " does not exist");
      }
  }
}
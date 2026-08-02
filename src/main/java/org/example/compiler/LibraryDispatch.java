package org.example.compiler;

public class LibraryDispatch extends MarsikPerfectHashMap<MarsikPerfectHashMap<String>>{

  private final String[] libraryNames = {"FileHandler", "DateTime", "Caster", "Math", "Crypto"};

  public LibraryDispatch() {
    super(5);
    init();
  }

  public void init() {
    set("FileHandler",
            new MarsikPerfectHashMap<>(
                    "writeContentToFile", "appendContentToFile", "clearFile",
                    "doesFileExist", "deleteFile", "readFile", "createFile")
    );
    set("DateTime",
            new MarsikPerfectHashMap<>(
                    "now", "currentDateISO", "currentMillis", "currentYear", "currentMonth",
                    "currentDay", "currentHour", "currentMinute", "currentSeconds", "currentDateTime",
                    "getSeconds", "getMinutes", "getHours", "getDay", "getMonth", "getYear", "setSeconds",
                    "setMinutes", "setHours", "setDay", "setMonth", "setYear", "isLeapYear",
                    "isBefore", "isAfter", "toIsoFormat", "monthName", "dayName")
    );

    set("Caster",
            new MarsikPerfectHashMap<>(
                    "intToDouble", "intToChar", "intToString", "booleanToString",
                    "doubleToInt", "doubleToString", "stringToInt", "stringToBoolean",
                    "stringToDouble", "booleanToInt", "intToBoolean")
    );

    set("Math",
            new MarsikPerfectHashMap<>(
                   "roundBasic", "roundUp", "roundDown", "ln", "logarithm", "ePowX",
                   "gcd", "scd", "modInverse", "factorial", "fibonacci", "hypotenuse", "hypotenuse3D",
                   "isEven", "isPrime", "areCongruentModuloM", "calculateCapital", "increasingSum",
                   "max", "min", "sum", "avg", "median", "randomInt", "randomDouble", "variance",
                   "standardDeviation", "binomialCoefficient", "squareRoot", "cubeRoot", "toRadians",
                   "toDegrees", "posDifference", "sine", "cosine", "tangent", "asine", "aconsine",
                   "atangent", "pi", "e", "phi")
    );

    set("Crypto", new MarsikPerfectHashMap<>(
            "encrypt", "decrypt", "generateKey")
    );
  }

  /**
   * Checks whether the library and the method is supported in the runtime.
   * It throws a runtime exception if something does not match with the runtime.
   */
  public void checkLibraryAndMethodExistence(String libraryName, String method) {
      int idx = libraryPerfectHash(libraryName);
      if (!libraryName.equals(libraryNames[idx])) {
        return;
      }
      MarsikPerfectHashMap<String> methods = get(libraryName);
      String methodName = methods.get(method);
      if (methodName == null || !methodName.equals(method)) {
        throw new RuntimeException("Runtime method " + method + " for " + libraryName + " does not exist");
      }
  }

  /**
   * Perfect hash function for the 5 library name keys "Caster", "Crypto", "Math", "FileHandler", "DateTime":
   * (lib.charAt(0) * (lib.charAt(1) << lib.charAt(0))) % 5;
   */
  private int libraryPerfectHash(String lib) {
    return (lib.charAt(0) * (lib.charAt(1) << lib.charAt(0))) % 5;
  }
}
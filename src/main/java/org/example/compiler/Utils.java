package org.example.compiler;

import java.util.List;
import java.util.Map;

public class Utils {

  // All instantiatable datastructures objects of the marsik runtime
  public static final List<String> buildInObjectsDatastructures = List.of(
          "Array", "Stack", "SparseArray", "Set", "Queue", "List",
          "HashMap", "PerfectHashMap", "BitSet", "Array", "BinaryTree",
          "AvlTree", "Btree", "SplayTree", "Graph", "WeightedGraph",
          "SplayArray", "CircularBuffer", "GapBuffer");

  public static final List<String> stringMethods = List.of(
          "setCharAt", "allIndexOf", "firstIndexOf", "lastIndexOf", "stringEquals",
          "count", "reverseString", "appendChar", "capitalize", "isEqual", "stringIndexOf",
          "isPalindrome", "alphabetIndexes", "hasOnlyDigits", "replacePart", "hasWhiteSpace",
          "hasDigits", "hasOnlyLetters", "hasLetters", "isAlphaNumeric", "capitalize",
          "numberOfVowels", "numberOfConsonants", "isOnlyLowerCase", "inOnlyUpperCase",
          "isOnlyWhiteSpace", "numberOfWhiteSpaces", "stringLength", "getCharAt",
          "printString", "append", "toUpperCase", "toLowerCase", "trim", "countOccurrence");

  public static final List<String> arrayMethods = List.of(
          "set", "get", "length", "memorySize", "isEmpty",
          "contains", "indexOf", "getRandomElement", "slice",
          "reverse", "removeDuplicates", "removeDuplicateOf", "sort",
          "clone", "mostAppearingElement", "printArray", "shuffle",
          "isNumericArray"
  );

  public static final Map<String, List<String>> libraryMethodsLookup = Map.of(
          "DateTime", List.of(
                  "now", "currentDateISO", "currentMillis",
                  "currentYear", "currentMonth", "currentDay",
                  "currentHour", "currentMinute", "currentSeconds",
                  "currentDateTime", "getSeconds", "getMinutes", "getHours", "getDay",
                  "getMonth", "getYear", "setSeconds", "setMinutes",
                  "setHours", "setDay", "setMonth", "setYear", "isLeapYear",
                  "isBefore", "isAfter", "toIsoFormat", "monthName", "dayName"
          ),
          "FileHandler", List.of(
                  "writeContentToFile", "appendContentToFile", "clearFile",
                  "doesFileExist", "deleteFile", "readFile", "createFile"
          ),
          "Math", List.of(
                  "roundBasic", "roundUp", "roundDown", "ln", "logarithm", "ePowX",
                  "gcd", "scd", "modInverse", "factorial", "fibonacci", "hypotenuse", "hypotenuse3D",
                  "isEven", "isPrime", "areCongruentModuloM", "calculateCapital", "increasingSum",
                  "max", "min", "sum", "avg", "median", "randomInt", "randomDouble", "variance", "standardDeviation",
                  "binomialCoefficient", "squareRoot", "cubeRoot", "toRadians", "toDegrees", "posDifference",
                  "sine", "cosine", "tangent", "asine", "aconsine", "atangent", "pi", "e", "phi"
          ),
          "Crypto", List.of(
                  "encrypt", "decrypt", "generateKey"
          ),
          "Caster", List.of("intToDouble", "intToChar", "intToString",
                  "booleanToString", "doubleToInt", "doubleToString", "stringToInt", "stringToBoolean",
                  "stringToDouble", "booleanToInt", "intToBoolean"
          )
  );

  static void main() {
    LibraryDispatch l = new LibraryDispatch();
    l.checkLibraryAndMethodExistence("Math", "phi");
  }
}
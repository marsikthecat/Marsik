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
          "setCharAt", "allIndexOf", "firstIndexOf", "lastIndexOf",
          "count", "reverse", "appendChar", "capitalize", "isEqual",
          "isPalindrome", "alphabetIndexes", "hasOnlyDigits", "replacePart",
          "hasDigits", "hasOnlyLetters", "hasLetters", "isAlphaNumeric", "capitalize",
          "numberOfVowels", "numberOfConsonants", "isOnlyLowerCase", "inOnlyUpperCase",
          "isOnlyWhiteSpace", "numberOfWhiteSpaces", "stringLength", "getCharAt");

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
                  "doesFileExist", "deleteFile", "readFile"
          ),
          "Math", List.of(
                  "roundBasic", "roundUp", "roundDown", "ln", "logarithm", "ePowX",
                  "gcd", "scd", "modInverse", "factorial", "fibonacci", "hypotenuse", "hypotenuse3D",
                  "isEven", "isPrime", "areCongruentModuloM", "calculateCapital", "increasingSum",
                  "max", "min", "sum", "avg", "median", "randomInt", "variance", "standardDeviation",
                  "binomialCoefficient"
          ),
          "Crypto", List.of(
                  "encrypt", "decrypt", "generateKey"
          )
  );
}
package org.example.compiler;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.compiler.generated.MarsikParser;

public class Utils {

  public static final Set<String> buildInTypedObjects = Set.of(
          "HashMap", "List", "PerfectHashMap", "Queue", "Set", "SplayArray", "Stack",
          "AvlTree", "BinaryTree", "TreeNode");

  public static final Set<String> getBuildInUnTypedObjects = Set.of(
          "BitSet", "GapBuffer", "GenericList", "Node", "Edge", "Graph", "Matrix");

  public static final Set<String> stringMethods = Set.of(
          "setCharAt", "allIndexOf", "lastIndexOf", "length", "substring", "contains",
          "count", "reverse", "append", "capitalize", "indexOf", "equals",
          "isPalindrome", "alphabetIndexes", "hasOnlyDigits", "replacePart", "hasWhiteSpace",
          "hasDigits", "hasOnlyLetters", "hasLetters", "isAlphaNumeric",
          "numberOfVowels", "numberOfConsonants", "isOnlyLowerCase", "isOnlyUpperCase",
          "isOnlyWhiteSpace", "numberOfWhiteSpaces", "stringLength", "getCharAt",
          "toUpperCase", "toLowerCase", "trim", "countOccurrence");

  public static final Set<String> arrayMethods = Set.of(
          "set", "get", "length", "memorySize", "isEmpty",
          "contains", "indexOf", "getRandomElement", "slice",
          "reverse", "removeDuplicates", "removeDuplicateOf", "sort",
          "clone", "mostAppearingElement", "printArray", "shuffle",
          "isNumericArray"
  );

  public static final Map<String, Set<String>> libraryMethodsLookup = Map.of(
          "DateTime", Set.of(
                  "now", "currentDateISO", "currentMillis",
                  "currentYear", "currentMonth", "currentDay",
                  "currentHour", "currentMinute", "currentSeconds",
                  "currentDateTime", "getSeconds", "getMinutes", "getHours", "getDay",
                  "getMonth", "getYear", "setSeconds", "setMinutes",
                  "setHours", "setDay", "setMonth", "setYear", "isLeapYear",
                  "isBefore", "isAfter", "toIsoFormat", "monthName", "dayName"
          ),
          "FileHandler", Set.of(
                  "writeContentToFile", "appendContentToFile", "clearFile",
                  "doesFileExist", "deleteFile", "readFile", "createFile"
          ),
          "Math", Set.of(
                  "roundBasic", "roundUp", "roundDown", "ln", "logarithm", "ePowX",
                  "gcd", "scd", "modInverse", "factorial", "fibonacci", "hypotenuse", "hypotenuse3D",
                  "isEven", "isPrime", "areCongruentModuloM", "calculateCapital", "increasingSum",
                  "max", "min", "sum", "avg", "median", "randomInt", "randomDouble", "variance", "standardDeviation",
                  "binomialCoefficient", "squareRoot", "cubeRoot", "toRadians", "toDegrees", "posDifference",
                  "sine", "cosine", "tangent", "asine", "aconsine", "atangent", "pi", "e", "phi"
          ),
          "Crypto", Set.of(
                  "encrypt", "decrypt", "generateKey"
          ),
          "Caster", Set.of("intToDouble", "intToChar", "intToString",
                  "booleanToString", "doubleToInt", "doubleToString", "stringToInt", "stringToBoolean",
                  "stringToDouble", "booleanToInt", "intToBoolean"
          )
  );

  public static boolean multiEquals(String value, String... strings) {
    for (String str : strings) {
      if (value.equals(str)) {
        return true;
      }
    }
    return false;    
  }

  public static boolean isBuiltInLibraryMethod(String target, String method) {
    return libraryMethodsLookup.containsKey(target)
       && libraryMethodsLookup.get(target).contains(method);
  }

  public static boolean isCompatibleLiteral(String declaredType, MarsikParser.TypeContext value) {
    return switch (declaredType) {
      case "string" -> value.STRING() != null;
      case "bool" -> value.BOOLEAN() != null;
      case "int" -> value.INTEGER() != null;
      case "double" -> value.DOUBLE() != null;
      case "char" -> value.CHAR() != null;
      case "baby_int", "uint8_t" -> value.BABY_INTEGER() != null || value.INTEGER() != null;
      default -> false;
    };
  }

  public static void validateLiteralType(String declaredType, MarsikParser.TypeContext value) {
    if (!isCompatibleLiteral(declaredType, value)) {
      throw new RuntimeException("Literal " + declaredType
                + " does not match Value " + value.getText());
      }
  }

  public static String toCppType(String marsikType, Set<String> imports) {
    return switch (marsikType) {
      case "boolean" -> "bool";
      case "baby_int" -> {
        imports.add("#include <stdint.h>\n");
        yield "uint8_t";
      }
      default -> marsikType;
    };
  }

  public static String joinBinaryExpressions(List<? extends ParseTree> expressions, Function<ParseTree, String> renderer, String operator) {
    StringBuilder result = new StringBuilder(renderer.apply(expressions.get(0)));
    for (int i = 1; i < expressions.size(); i++) {
      result.append(" ").append(operator).append(" ").append(renderer.apply(expressions.get(i)));
    }
    return result.toString();
  }

  public static String joinBinaryExpressions(List<? extends ParseTree> expressions, Function<ParseTree, String> renderer, ParseTree parent) {
    StringBuilder result = new StringBuilder(renderer.apply(expressions.get(0)));
    for (int i = 1; i < expressions.size(); i++) {
      result.append(" ").append(parent.getChild(2 * i - 1).getText()).append(" ")
                .append(renderer.apply(expressions.get(i)));
    }
    return result.toString();
  }

  public static String generateC(Set<String> imports, String code) {
    StringBuilder importsAsString = new StringBuilder();
    for (String anImport : imports) {
      importsAsString.append(anImport);
   }
   return """
        #include <iostream>
        #include <stdbool.h>
        #include <string>
        #include "stringUtils.hpp"
        %s

        int main() {
            %s
            std::cout << "Press ENTER to exit...";
            std::cin.get();
            return 0;
        }""".formatted(importsAsString, code);
  }

  static void main() {
    LibraryDispatch l = new LibraryDispatch();
    l.checkLibraryAndMethodExistence("Math", "phi");
  }
}
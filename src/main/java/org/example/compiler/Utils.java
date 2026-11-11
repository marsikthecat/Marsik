package org.example.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.compiler.generated.MarsikParser;

public class Utils {

  public enum GenericCount {
    NOT(0),
    ONE(1),
    TWO(2);

    private final int count;

    GenericCount(int count) {
      this.count = count;
    }

    public int count() {
      return count;
    }
  }

  public record BuiltInModule(
          String type, GenericCount genericCount, Set<String> methods) {}

  private static final Map<String, BuiltInModule> BUILT_IN_MODULES = Map.ofEntries(
          Map.entry("Math", libraryModule(
                  "roundBasic", "roundUp", "roundDown", "ln", "logarithm", "ePowX", "gcd", "scd",
                  "modInverse", "factorial", "fibonacci", "hypotenuse", "hypotenuse3D", "isEven",
                  "isNegative", "isPrime", "areCongruentModuloM", "calculateCapital", "increasingSum",
                  "max", "min", "sum", "avg", "median", "randomInt", "randomDouble", "variance",
                  "standardDeviation", "binomialCoefficient", "squareRoot", "cubeRoot", "toRadians",
                  "toDegrees", "posDifference", "sine", "cosine", "tangent", "asine", "acosine",
                  "atangent", "pi", "e", "phi")),
          Map.entry("DateTime", libraryModule(
                  "now", "currentDateISO", "currentMillis", "currentYear", "currentMonth", "currentDay",
                  "currentDayOfWeek", "currentHour", "currentMinute", "currentSeconds", "currentDateTime",
                  "getSeconds", "getMinutes", "getHours", "getDay", "getMonth", "getYear", "setSeconds",
                  "setMinutes", "setHours", "setDay", "setMonth", "setYear", "isLeapYear", "isBefore",
                  "isAfter", "toGermanFormat", "toIsoUtcFormat", "monthName", "getCurrentMonthName",
                  "dayName", "getCurrentDayName")),
          Map.entry("Caster", libraryModule(
                  "intToDouble", "intToChar", "intToString", "booleanToString", "doubleToInt",
                  "doubleToString", "stringToInt", "stringToBoolean", "stringToDouble",
                  "booleanToInt", "intToBoolean")),
          Map.entry("FileHandler", libraryModule(
                  "writeContentToFile", "appendContentToFile", "clearFile", "doesFileExist",
                  "deleteFile", "readFile", "createFile")),
          Map.entry("String", runtimeModule("String", GenericCount.NOT,
                  "hash", "setCharAt", "lastIndexOf", "length", "substring", "contains", "reverse",
                  "append", "capitalize", "indexOf", "equals", "isPalindrome", "alphabetIndexes",
                  "hasOnlyDigits", "hasWhiteSpace", "hasDigits", "hasOnlyLetters", "hasLetters",
                  "isAlphaNumeric", "numberOfVowels", "numberOfConsonants", "isLowercase",
                  "isUppercase", "isWhiteSpace", "numberOfWhiteSpaces", "getCharAt", "toUpperCase",
                  "toLowerCase", "startsWith", "endsWith", "countOccurrence")),
          Map.entry("Array", runtimeModule("Array", GenericCount.ONE,
                  "set", "get", "length", "memorySize", "isEmpty", "contains", "indexOf",
                  "getRandomElement", "getRandomElementFromRange", "slice", "reverse", "sort", "clone",
                  "mostAppearingElement", "mostAppearingElementCount", "printArray", "shuffle",
                  "isNumericArray", "unionWith", "intersectionWith", "containsDuplicateElements")),
          Map.entry("BitSet", runtimeModule("BitSet", GenericCount.NOT,
                  "init", "set", "get", "toggle", "clear", "setAll", "clearAll", "count", "isEmpty", "isFull")),
          Map.entry("GapBuffer", runtimeModule("GapBuffer", GenericCount.NOT,
                  "init", "insert", "moveCursor", "moveGapLeft", "moveGapRight")),
          Map.entry("GenericList", runtimeModule("GenericList", GenericCount.NOT,
                  "init", "addBool", "addChar", "addDouble", "addFloat", "addInt", "addString", "allNumeric",
                  "allSameType", "allStrings", "clear", "contains", "get", "getType", "indexOf",
                  "isEmpty", "remove", "size")),
          Map.entry("HashMap", runtimeModule("HashMap", GenericCount.TWO,
                  "init", "capacity", "clear", "containsKey", "get", "isEmpty", "put", "remove", "size")),
          Map.entry("PerfectHashMap", runtimeModule("PerfectHashMap", GenericCount.ONE,
                  "init", "capacity", "clear", "containsKey",
                  "defineKey", "get", "isEmpty", "put", "remove", "size")),
          Map.entry("List", runtimeModule("List", GenericCount.ONE,
                  "init", "add", "addAt", "capacity", "clear", "clone", "contains", "get", "indexOf",
                  "isEmpty", "lastIndexOf", "mostAppearingElement", "mostAppearingElementCount",
                  "printList", "randomElement", "randomElementInRange", "remove", "removeAll",
                  "removeAt", "removeDuplicateOf", "removeDuplicates", "removeRetrieve", "resize",
                  "reverse", "set", "size", "sort", "toSet", "trim", "withoutDuplicates")),
          Map.entry("Matrix", runtimeModule("Matrix", GenericCount.NOT, 
                  "init", "add", "clone", "fill", "get", "getDeterminant", "isInvertible", "multiply",
                  "normal", "numberOfColumns", "numberOfRows", "set", "sum", "trace", "transpose", "printMatrix")),
          Map.entry("Queue", runtimeModule("Queue", GenericCount.ONE,
                  "init", "dequeue", "enqueue", "isEmpty", "isFull", "peek", "size")),
          Map.entry("Set", runtimeModule("Set", GenericCount.ONE,
                  "init", "add", "capacity", "clear", "contains", "isEmpty", "remove", "size")),
          Map.entry("SparseArray", runtimeModule("SparseArray", GenericCount.ONE,
                  "init", "clear", "contains", "firstfreeSpot", "get", "getRandomElement",
                  "has", "holeCount", "indexOf", "isEmpty", "lastfreeSpot", "lastIndexOf", "maxIndex",
                  "printArray", "pushfromEnd", "pushfromStart", "remove", "set", "size", "toArray")),
          Map.entry("SplayArray", runtimeModule("SplayArray", GenericCount.ONE,
                  "init", "clone", "contains", "get", "getRandomElement", "indexOf",
                  "isEmpty", "isNumericArray", "length", "memorySize", "mostAppearingElement",
                  "printArray", "rearrange", "removeAt", "removeDuplicateOf", "removeDuplicates",
                  "reverse", "set", "shuffle", "slice", "sort")),
          Map.entry("Stack", runtimeModule("Stack", GenericCount.ONE,
                  "init", "isEmpty", "isFull", "peek", "pop", "push", "size")),
          Map.entry("AvlTree", runtimeModule("AvlTree", GenericCount.ONE,
                  "init", "contains", "delete", "height", "inorder", "postorder", "preorder", "search", "insert")),
          Map.entry("BinaryTree", runtimeModule("BinaryTree", GenericCount.ONE,
                  "init", "height", "inorder", "levelorder", "postorder", "preorder", "search", "insert", "remove")),
          Map.entry("TreeNode", runtimeModule("TreeNode", GenericCount.ONE,
                  "init", "getData", "getLeft", "getRight", "setData")),
          Map.entry("Graph", runtimeModule("Graph", GenericCount.NOT,
                  "init", "addNode", "containsNode", "print", "removeNode")),
          Map.entry("Node", runtimeModule("Node", GenericCount.NOT,
                  "init", "addEdge", "containsEdge", "getIdentifier", "getNumberOfEdges", "removeEdge")),
          Map.entry("Edge", runtimeModule("Edge", GenericCount.NOT,
                  "init", "getDestination", "getWeight", "setDestination", "setWeight")));

  private static BuiltInModule libraryModule(String... methods) {
    return new BuiltInModule(null, GenericCount.NOT, Set.of(methods));
  }

  private static BuiltInModule runtimeModule(String type, GenericCount genericCount, String... methods) {
    return new BuiltInModule(type, genericCount, Set.of(methods));
  }

  public static final Set<String> forbiddenNamesforVariables = Set.of(
    "alignas", "alignof", "and", "and_eq", "asm", "auto",
    "bitand", "bitor", "bool", "break", "case", "catch",
    "char", "char8_t", "char16_t", "char32_t", "class",
    "compl", "concept", "const", "consteval", "constexpr",
    "constinit", "const_cast", "continue", "co_await",
    "co_return", "co_yield", "decltype", "default", "delete",
    "do", "double", "dynamic_cast", "else", "enum", "explicit",
    "export", "extern", "false", "float", "for", "friend",
    "goto", "if", "inline", "int", "long", "mutable",
    "namespace", "new", "noexcept", "not", "not_eq", "nullptr",
    "operator", "or", "or_eq", "private", "protected", "public",
    "register", "reinterpret_cast", "requires", "return",
    "short", "signed", "sizeof", "static", "static_assert",
    "static_cast", "struct", "switch", "template", "this",
    "thread_local", "throw", "true", "try", "typedef", "typeid",
    "typename", "union", "unsigned", "using", "virtual", "void",
    "volatile", "wchar_t", "while", "xor", "xor_eq", "boolean"
  );

  public static boolean isForbiddenName(String variableName) {
    return forbiddenNamesforVariables.contains(variableName);
  }

  public static BuiltInModule builtInModule(String module) {
    return BUILT_IN_MODULES.get(module);
  }

  public static boolean isBuiltInModule(String module) {
    return BUILT_IN_MODULES.containsKey(module);
  }

  public static boolean isBuiltInType(String type) {
    BuiltInModule module = BUILT_IN_MODULES.get(type);
    return module != null && module.type() != null;
  }

  public static String builtInModuleFunction(String module, String method) {
    BuiltInModule builtIn = BUILT_IN_MODULES.get(module);
    if (builtIn == null) {
      return null;
    }
    if (!builtIn.methods().contains(method)) {
      return null;
    }
    if (builtIn.type() == null) {
      return method;
    }
    String typeName = builtIn.type().toLowerCase(Locale.ROOT);
    return method.equals("init") ? "init_" + typeName : typeName + "_" + method;
  }

  public static boolean isCompatibleLiteral(String declaredType, MarsikParser.TypeContext value) {
    return switch (declaredType) {
      case "string" -> value.STRING() != null;
      case "boolean" -> value.BOOLEAN() != null;
      case "int" -> value.INTEGER() != null;
      case "double" -> value.DOUBLE() != null;
      case "char" -> value.CHAR() != null;
      default -> false;
    };
  }

  public static void validateLiteralType(String declaredType, MarsikParser.TypeContext value) {
    if (!isCompatibleLiteral(declaredType, value)) {
      throw new RuntimeException("Literal " + declaredType
                + " does not match Value " + value.getText());
      }
  }

  public static String toCppType(String marsikType) {
    return marsikType.equals("boolean") ? "bool" : marsikType;
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
    return generateC(imports, code, "");
  }

  public static String generateC(Set<String> imports, String code, String declarations) {
    StringBuilder importsAsString = new StringBuilder();
    for (String anImport : imports) {
      importsAsString.append(anImport);
   }
   return """
        #include <iostream>
        #include <stdbool.h>
        #include <string>
        %s
        %s

        int main() {
            %s
            std::cout << "Press ENTER to exit...";
            std::cin.get();
            return 0;
        }""".formatted(importsAsString, declarations, code);
  }

  public static void printError(String s) {
    System.out.println("\u001B[31m" + s + "\u001B[0m");
  }

  public static void printWarning(String s) {
    System.out.println("\u001B[33m" + s + "\u001B[0m");
  }

  public static void printSuccess(String s) {
    System.out.println("\u001B[32m" + s + "\u001B[0m");
  }
}
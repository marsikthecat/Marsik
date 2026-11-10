package org.example.compiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import org.antlr.v4.runtime.tree.ParseTree;
import org.example.compiler.generated.MarsikParser;

public class Utils {

  public static final Set<String> BUILT_IN_MODULES = Set.of(
          "Math", "DateTime", "Caster", "FileHandler", "String", "Array", "BitSet",
          "GapBuffer", "GenericList", "HashMap", "PerfectHashMap", "List", "Matrix",
          "Queue", "Set", "SparseArray", "SplayArray", "Stack", "AvlTree", "BinaryTree",
          "TreeNode", "Graph", "Node", "Edge");

  public static final Set<String> buildInTypedObjects = Set.of(
          "HashMap", "List", "PerfectHashMap", "Queue", "Set", "SparseArray", "SplayArray", "Stack",
          "AvlTree", "BinaryTree", "TreeNode");

  public static final Set<String> getBuildInUnTypedObjects = Set.of(
          "BitSet", "GapBuffer", "GenericList", "Node", "Edge", "Graph", "Matrix");

  public static final Set<String> stringMethods = Set.of(
          "hash", "setCharAt", "lastIndexOf", "length", "substring", "contains",
          "reverse", "append", "capitalize", "indexOf", "equals",
          "isPalindrome", "alphabetIndexes", "hasOnlyDigits", "hasWhiteSpace",
          "hasDigits", "hasOnlyLetters", "hasLetters", "isAlphaNumeric",
          "numberOfVowels", "numberOfConsonants", "isLowercase", "isUppercase",
          "isWhiteSpace", "numberOfWhiteSpaces", "getCharAt", "toUpperCase",
          "toLowerCase", "startsWith", "endsWith", "countOccurrence");

  public static final Set<String> arrayMethods = Set.of(
          "set", "get", "length", "memorySize", "isEmpty", "contains", "indexOf",
          "getRandomElement", "getRandomElementFromRange", "slice", "reverse", "sort",
          "clone", "mostAppearingElement", "mostAppearingElementCount", "printArray",
          "shuffle", "isNumericArray", "unionWith", "intersectionWith",
          "containsDuplicateElements"
  );

  private static final Map<String, String> RUNTIME_MODULE_PREFIXES = Map.ofEntries(
          Map.entry("Array", "array_"),
          Map.entry("BitSet", "bitset_"),
          Map.entry("GapBuffer", "gapbuffer_"),
          Map.entry("GenericList", "genericlist_"),
          Map.entry("HashMap", "hashmap_"),
          Map.entry("PerfectHashMap", "perfecthashmap_"),
          Map.entry("List", "list_"),
          Map.entry("Matrix", "matrix_"),
          Map.entry("Queue", "queue_"),
          Map.entry("Set", "set_"),
          Map.entry("SparseArray", "sparsearray_"),
          Map.entry("SplayArray", "splayarray_"),
          Map.entry("Stack", "stack_"),
          Map.entry("AvlTree", "avltree_"),
          Map.entry("BinaryTree", "binarytree_"),
          Map.entry("TreeNode", "treenode_"),
          Map.entry("Graph", "graph_"),
          Map.entry("Node", "node_"),
          Map.entry("Edge", "edge_"));

  private static final Map<String, Set<String>> RUNTIME_MODULE_METHODS = Map.ofEntries(
          Map.entry("Array", arrayMethods),
          Map.entry("BitSet", Set.of("set", "get", "toggle", "clear", "setAll", "clearAll", "count", "isEmpty", "isFull")),
          Map.entry("GapBuffer", Set.of("insert", "moveCursor", "moveGapLeft", "moveGapRight")),
          Map.entry("GenericList", Set.of("addBool", "addChar", "addDouble", "addFloat", "addInt", "addString",
                  "allNumeric", "allSameType", "allStrings", "clear", "contains", "get", "getType",
                  "indexOf", "isEmpty", "remove", "size")),
          Map.entry("HashMap", Set.of("capacity", "clear", "containsKey", "get", "isEmpty", "put", "remove", "size")),
          Map.entry("PerfectHashMap", Set.of("capacity", "clear", "containsKey", "defineKey", "get", "isEmpty", "put", "remove", "size")),
          Map.entry("List", Set.of("add", "addAt", "capacity", "clear", "clone", "contains", "get", "indexOf",
                  "isEmpty", "lastIndexOf", "mostAppearingElement", "mostAppearingElementCount", "printList",
                  "randomElement", "randomElementInRange", "remove", "removeAll", "removeAt", "removeDuplicateOf",
                  "removeDuplicates", "removeRetrieve", "resize", "reverse", "set", "size", "sort", "toSet",
                  "trim", "withoutDuplicates")),
          Map.entry("Matrix", Set.of("add", "clone", "fill", "get", "getDeterminant", "isInvertible", "multiply",
                  "normal", "numberOfColumns", "numberOfRows", "printMatrix", "set", "sum", "trace", "transpose")),
          Map.entry("Queue", Set.of("dequeue", "enqueue", "isEmpty", "isFull", "peek", "size")),
          Map.entry("Set", Set.of("add", "capacity", "clear", "contains", "isEmpty", "remove", "size")),
          Map.entry("SparseArray", Set.of("clear", "contains", "firstfreeSpot", "get", "getRandomElement", "has",
                  "holeCount", "indexOf", "isEmpty", "lastfreeSpot", "lastIndexOf", "maxIndex", "printArray",
                  "pushfromEnd", "pushfromStart", "remove", "set", "size", "toArray")),
          Map.entry("SplayArray", Set.of("clone", "contains", "get", "getRandomElement", "indexOf", "isEmpty",
                  "isNumericArray", "length", "memorySize", "mostAppearingElement", "printArray", "rearrange",
                  "removeAt", "removeDuplicateOf", "removeDuplicates", "reverse", "set", "shuffle", "slice", "sort")),
          Map.entry("Stack", Set.of("isEmpty", "isFull", "peek", "pop", "push", "size")),
          Map.entry("AvlTree", Set.of("contains", "delete", "height", "inorder", "postorder", "preorder", "search", "insert")),
          Map.entry("BinaryTree", Set.of("height", "inorder", "levelorder", "postorder", "preorder", "search", "insert", "remove")),
          Map.entry("TreeNode", Set.of("getData", "getLeft", "getRight", "setData")),
          Map.entry("Graph", Set.of("addNode", "containsNode", "print", "removeNode")),
          Map.entry("Node", Set.of("addEdge", "containsEdge", "getIdentifier", "getNumberOfEdges", "removeEdge")),
          Map.entry("Edge", Set.of("getDestination", "getWeight", "setDestination", "setWeight")));

  private static final Map<String, String> RUNTIME_MODULE_INITIALIZERS = Map.ofEntries(
          Map.entry("BitSet", "init_bitset"),
          Map.entry("GapBuffer", "init_gapbuffer"),
          Map.entry("GenericList", "init_genericlist"),
          Map.entry("HashMap", "init_hashmap"),
          Map.entry("PerfectHashMap", "init_perfecthashmap"),
          Map.entry("List", "init_list"),
          Map.entry("Matrix", "init_matrix"),
          Map.entry("Queue", "init_queue"),
          Map.entry("Set", "init_set"),
          Map.entry("SparseArray", "init_sparsearray"),
          Map.entry("SplayArray", "init_splayarray"),
          Map.entry("Stack", "init_stack"),
          Map.entry("AvlTree", "init_avltree"),
          Map.entry("BinaryTree", "init_binarytree"),
          Map.entry("TreeNode", "init_treenode"),
          Map.entry("Graph", "init_graph"),
          Map.entry("Node", "init_node"),
          Map.entry("Edge", "init_edge"));

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

  private static final LibraryDispatch libraryDispatch = new LibraryDispatch();

  public static boolean multiEquals(String value, String... strings) {
    for (String str : strings) {
      if (value.equals(str)) {
        return true;
      }
    }
    return false;    
  }

  public static boolean isBuiltInLibraryMethod(String target, String method) {
    return libraryDispatch.isLibraryMethod(target, method);
  }

  public static boolean isBuiltInModule(String module) {
    return BUILT_IN_MODULES.contains(module);
  }

  public static String builtInModuleFunction(String module, String method) {
    if (module.equals("String")) {
      return stringMethods.contains(method) ? "string_" + method : null;
    }
    if (method.equals("init")) {
      return RUNTIME_MODULE_INITIALIZERS.get(module);
    }
    String prefix = RUNTIME_MODULE_PREFIXES.get(module);
    Set<String> methods = RUNTIME_MODULE_METHODS.get(module);
    if (prefix == null || methods == null || !methods.contains(method)) {
      return null;
    }
    return module.equals("Matrix") && method.equals("printMatrix") ? "matrix_print" : prefix + method;
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

  public static void addAllHeaderFiles(Path projectRoot, Map<String, Path> headerFiles) {
    try (Stream<Path> paths = Files.walk(projectRoot)) {
        paths.filter(Files::isRegularFile)
            .filter(path -> path.toString().endsWith(".hpp"))
            .forEach(path -> {
                String fileName = path.getFileName().toString();
                String objectType = fileName.substring( 0, fileName.length() - 4);
                headerFiles.put(objectType.toLowerCase(), path);
            });
    } catch (IOException e) {
        throw new RuntimeException("Failed to index project headers", e);
    }
  }
}
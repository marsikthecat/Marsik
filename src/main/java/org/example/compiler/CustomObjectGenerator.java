package org.example.compiler;

import org.example.utils.FileHandler;

/**
 * Generates C header (.h) and implementation (.c) files for custom objects.
 * Each custom object gets its own pair of files in the generated objects folder.
 */
public class CustomObjectGenerator {
  private static final String OBJECTS_FOLDER = "C:\\Users\\dani_\\Desktop\\MarsikLang2\\src\\main\\java\\org\\example\\out\\";

  /**
   * Generate .h and .c files for a custom object.
   *
   * @param customObject the custom object definition
   */
  public static void generateCustomObject(CustomObjectHolder customObject) {
    try {
      ensureFolderExists();

      String headerContent = generateHeaderFile(customObject);
      String implContent = generateImplementationFile(customObject);

      String headerPath = OBJECTS_FOLDER + customObject.name.toLowerCase() + ".h";
      String implPath = OBJECTS_FOLDER + customObject.name.toLowerCase() + ".c";

      // Create and write header file
      if (!FileHandler.doesFileExist(headerPath)) {
        FileHandler.createNewFile(headerPath);
      }
      FileHandler.writeToFile(headerPath, headerContent);
      GeneratedFilesTracker.registerGeneratedFile(headerPath);

      // Create and write implementation file
      if (!FileHandler.doesFileExist(implPath)) {
        FileHandler.createNewFile(implPath);
      }
      FileHandler.writeToFile(implPath, implContent);
      GeneratedFilesTracker.registerGeneratedFile(implPath);

      customObject.isGenerated = true;
    } catch (Exception e) {
      System.err.println("Error generating custom object files for " + customObject.name + ": " + e.getMessage());
    }
  }

  /**
   * Generate the header file content for a custom object.
   *
   * @param customObject the custom object definition
   * @return the header file content
   */
  private static String generateHeaderFile(CustomObjectHolder customObject) {
    StringBuilder header = new StringBuilder();
    String guardName = customObject.name.toUpperCase() + "_H";

    header.append("#ifndef ").append(guardName).append("\n");
    header.append("#define ").append(guardName).append("\n\n");
    header.append("#include <stdlib.h>\n");
    header.append("#include <stdbool.h>\n");
    header.append("#include <stdint.h>\n\n");

    // Struct definition
    header.append("struct ").append(customObject.name).append(" {\n");
    for (FieldHolder field : customObject.fields) {
      String cType = mapTypeToCType(field.type);
      header.append("  ").append(cType).append(" ").append(field.name).append(";\n");
    }
    header.append("};\n\n");

    // Initialization function declaration
    header.append("struct ").append(customObject.name).append(" init_")
            .append(customObject.name.toLowerCase()).append("(");

    header.append(");\n\n");

    // Method declarations
    for (MethodHolder method : customObject.methods) {
      String returnType = mapTypeToCType(method.returnType != null && !method.returnType.equals("void") ? method.returnType : "void");
      if (method.returnType == null || method.returnType.equals("void")) {
        returnType = "void";
      }
      header.append(returnType).append(" ").append(customObject.name.toLowerCase()).append("_")
              .append(method.name).append("(struct ").append(customObject.name).append("* obj");
      for (ParamHolder param : method.params) {
        String paramType = mapTypeToCType(param.type);
        header.append(", ").append(paramType).append(" ").append(param.name);
      }
      header.append(");\n");
    }

    header.append("\n#endif\n");
    return header.toString();
  }

  /**
   * Generate the implementation file content for a custom object.
   *
   * @param customObject the custom object definition
   * @return the implementation file content
   */
  private static String generateImplementationFile(CustomObjectHolder customObject) {
    StringBuilder impl = new StringBuilder();

    impl.append("#include \"").append(customObject.name.toLowerCase()).append(".h\"\n\n");

    // Initialization function implementation
    impl.append("struct ").append(customObject.name).append(" init_")
            .append(customObject.name.toLowerCase()).append("(");

    impl.append(") {\n");
    impl.append("  struct ").append(customObject.name).append(" obj;\n");

    for (FieldHolder field : customObject.fields) {
      String cType = mapTypeToCType(field.type);
      String defaultValue = getDefaultValueForType(cType);
      impl.append("  obj.").append(field.name).append(" = ").append(defaultValue).append(";\n");
    }

    impl.append("  return obj;\n");
    impl.append("}\n\n");

    // Method implementations
    for (MethodHolder method : customObject.methods) {
      String returnType = mapTypeToCType(method.returnType != null && !method.returnType.equals("void") ? method.returnType : "void");
      if (method.returnType == null || method.returnType.equals("void")) {
        returnType = "void";
      }
      impl.append(returnType).append(" ").append(customObject.name.toLowerCase()).append("_")
              .append(method.name).append("(struct ").append(customObject.name).append("* obj");
      for (ParamHolder param : method.params) {
        String paramType = mapTypeToCType(param.type);
        impl.append(", ").append(paramType).append(" ").append(param.name);
      }
      impl.append(") ");

      // Process method body: replace field names with obj->fieldname
      String body = method.body != null ? method.body : "{\n}\n";
      body = replaceFieldNamesInBody(body, customObject);
      impl.append(body);
    }

    return impl.toString();
  }

  /**
   * Replace field names in method body with obj->fieldname.
   * This converts `age = value` to `obj->age = value`.
   *
   * @param body the method body
   * @param customObject the custom object definition
   * @return the processed body with correct field references
   */
  private static String replaceFieldNamesInBody(String body, CustomObjectHolder customObject) {
    String result = body;
    for (FieldHolder field : customObject.fields) {
      result = result.replaceAll("\\b" + field.name + "\\b", "obj->" + field.name);
    }
    return result;
  }

  /**
   * Map Marsik type names to C types.
   *
   * @param marsikType the Marsik type name
   * @return the corresponding C type
   */
  private static String mapTypeToCType(String marsikType) {
    return switch (marsikType) {
      case "int" -> "int";
      case "double" -> "double";
      case "string" -> "string";
      case "char" -> "char";
      case "boolean" -> "bool";
      case "baby_int" -> "uint8_t";
      default -> "void*";
    };
  }

  /**
   * Get the default initial value for a C type.
   *
   * @param cType the C type name
   * @return the default value
   */
  private static String getDefaultValueForType(String cType) {
    return switch (cType) {
      case "int", "uint8_t" -> "0";
      case "double" -> "0.0";
      case "char" -> "'\\0'";
      case "bool" -> "false";
      default -> "NULL";
    };
  }

  /**
   * Ensure that the generated_objects folder exists.
   */
  private static void ensureFolderExists() {
    java.io.File folder = new java.io.File(OBJECTS_FOLDER);
    if (!folder.exists()) {
      boolean success = folder.mkdirs();
      if (success) {
        System.out.println("Created generated_objects folder: " + OBJECTS_FOLDER);
      } else {
        System.err.println("Failed to create generated_objects folder");
      }
    }
  }
}


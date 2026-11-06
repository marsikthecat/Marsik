package org.example.compiler;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Generates C++ header (.hpp) and implementation (.cpp) files for custom objects.
 */
public class CustomObjectGenerator {
  private static String objectsFolder = "src/main/java/org/example/out";

  public static void setOutputFolder(String outputFolder) {
    objectsFolder = outputFolder;
  }

  /**
   * Generate .hpp and .cpp files for a custom object.
   *
   * @param customObject the custom object definition
   */
  public static void generateCustomObject(ObjectHolder customObject) {
    try {
      ensureFolderExists();

      String implContent = generateImplementationFile(customObject);

      String basePath = new File(objectsFolder).getAbsolutePath() + File.separator;
      String headerPath = basePath + customObject.name.toLowerCase() + ".hpp";
      String implPath = basePath + customObject.name.toLowerCase() + ".cpp";

      String headerContent = generateHeaderFile(customObject);
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

    } catch (Exception e) {
      System.err.println("Error generating custom object files for " + customObject.name + ": " + e.getMessage());
    }
  }

  /**
   * Generate the header file content for a custom object.
   *
   * @param customObject the custom object definition
   * @return the hpp file content
   */
  private static String generateHeaderFile(ObjectHolder customObject) {
    Path projectRoot = Path.of("").toAbsolutePath();
    Map<String, Path> availableHeadersForImports = new HashMap<>();
    Utils.addAllHeaderFiles(projectRoot, availableHeadersForImports);
    StringBuilder headerImports = new StringBuilder();
    StringBuilder headerContent = new StringBuilder();
    StringBuilder header = new StringBuilder();
    headerImports.append("#pragma once\n");
    headerImports.append("#include <stdbool.h>\n");
    headerImports.append("#include <stdint.h>\n");
    headerImports.append("#include <string>\n");
    headerContent.append("using namespace std;\n\n");
    /*
      Define struct of custom object with attributes/fields

      typedef struct Car {
         int horsepower;
         string brand;
      } Car;
    */
    headerContent.append("typedef struct ").append(customObject.name).append(" {\n");
    for (ObjectHolder.Field field : customObject.fields) {
      String cType = Utils.toCppType(field.type);
      String includeString = getIncludePathOfObject(cType, availableHeadersForImports);
      if (!includeString.isEmpty()) {
        headerImports.append(includeString);
      }
      headerContent.append("  ").append(cType).append(" ").append(field.name).append(";\n");
    }
    headerContent.append("} ").append(customObject.name).append(";\n\n");

    /*
      Declare initialization function for the custom object

      Car init_car(string brand, int hoursePower);
    */
    headerContent.append(customObject.name).append(" init_")
            .append(customObject.name.toLowerCase()).append("(");
      appendConstructorParameters(headerContent, customObject);
    headerContent.append(");\n\n");

    /*
      Declare methods for the custom object

      int car_getHorsepower(Car obj);
      void car_setHorsepower(Car obj, int horsepower);
    */
    for (ObjectHolder.Method method : customObject.methods) {
      String returnType = Utils.toCppType(method.returnType != null && !method.returnType.equals("void") ? method.returnType : "void");
      if (method.returnType == null || method.returnType.equals("void")) {
        returnType = "void";
      }
      String includeString = getIncludePathOfObject(returnType, availableHeadersForImports);
      if (!includeString.isEmpty()) {
        headerImports.append(includeString);
      }
      headerContent.append(returnType).append(" ").append(customObject.name.toLowerCase()).append("_")
              .append(method.name).append("(");
      if (!method.isStatic) {
        headerContent.append(customObject.name).append("& obj");
      }
      for (int i = 0; i < method.parameters.size(); i++) {
        ObjectHolder.Parameter param = method.parameters.get(i);
        String paramType = Utils.toCppType(param.type);
        includeString = getIncludePathOfObject(paramType, availableHeadersForImports);
        if (!includeString.isEmpty()) {
          headerImports.append(includeString);
        }
        if (i > 0 || !method.isStatic) {
          headerContent.append(", ");
        }
        headerContent.append(paramType).append(" ").append(param.name);
      }
      headerContent.append(");\n");
    }
    headerImports.append("\n");
    header.append(headerImports).append(headerContent);
    return header.toString();
  }

  /**
   * Generate the implementation file content for a custom object.
   * 
   * @param customObject the custom object definition
   * @return the cpp file content 
   */
  private static String generateImplementationFile(ObjectHolder customObject) {
    StringBuilder impl = new StringBuilder();

    impl.append("#include \"").append(customObject.name.toLowerCase()).append(".hpp\"\n");
    impl.append("#include \"../runtime/stringUtils.hpp\"\n");
    impl.append("#include <iostream>\n");
    impl.append("#include <string>\n\n");
    for (String requiredInclude : customObject.requiredIncludes) {
      impl.append(requiredInclude);
    }
    for (String requiredDeclaration : customObject.requiredDeclarations) {
      impl.append(requiredDeclaration).append('\n');
    }

    // Initialization function implementation
    impl.append(customObject.name).append(" init_")
            .append(customObject.name.toLowerCase()).append("(");
      appendConstructorParameters(impl, customObject);
    impl.append(") {\n");
    impl.append(customObject.name).append(" obj;\n");
    if (customObject.constructorBody != null) {
      String constructorBody = customObject.constructorBody;
      int bodyStart = constructorBody.indexOf('{');
      int bodyEnd = constructorBody.lastIndexOf('}');
      if (bodyStart >= 0 && bodyEnd > bodyStart) {
        constructorBody = constructorBody.substring(bodyStart + 1, bodyEnd);
      }
      impl.append(replaceFieldNamesInBody(constructorBody, customObject));
    }
    impl.append("  return obj;\n");
    impl.append("}\n\n");

    // Method implementations
    for (ObjectHolder.Method method : customObject.methods) {
      String returnType = Utils.toCppType(method.returnType != null && !method.returnType.equals("void") ? method.returnType : "void");
      if (method.returnType == null || method.returnType.equals("void")) {
        returnType = "void";
      }
      impl.append(returnType).append(" ").append(customObject.name.toLowerCase()).append("_")
              .append(method.name).append("(");
      if (!method.isStatic) {
        impl.append(customObject.name).append("& obj");
      }
      for (int i = 0; i < method.parameters.size(); i++) {
        ObjectHolder.Parameter param = method.parameters.get(i);
        String paramType = Utils.toCppType(param.type);
        if (i > 0 || !method.isStatic) {
          impl.append(", ");
        }
        impl.append(paramType).append(" ").append(param.name);
      }
      impl.append(") ");

      // Instance method bodies access fields through the generated object reference.
      String body = method.body != null ? method.body : "{\n}\n";
      /*
        Reference to object itself only passed if it is not static

        // static: //
        
        function printBrand(String brand) {
          print("Brand: ", brand)
        }

        Car.printBrand("Audi")

        // object-bound: //

        setBrand(Car& car, String newBrand) {
           car.brand = newBrand
        }
        
        Car car = new Car("Vw", 60) 
        car.setBrand("Audi")  
      */
      if (!method.isStatic) {
        body = replaceFieldNamesInBody(body, customObject);
      }
      impl.append(body);
    }
    return impl.toString();
  }

  private static void appendConstructorParameters(StringBuilder output, ObjectHolder customObject) {
    for (int i = 0; i < customObject.constructorParameters.size(); i++) {
      ObjectHolder.Parameter parameter = customObject.constructorParameters.get(i);
      if (i > 0) {
        output.append(", ");
      }
      output.append(Utils.toCppType(parameter.type)).append(" ").append(parameter.name);
    }
  }

  /**
   * Replace field names in method body with obj.fieldname.
   * This converts `age = value` to `obj.age = value`.
   * Also it removes <Type> so it fits to the method
   *
   * @param body the method body
   * @param customObject the custom object definition
   * @return the processed body with correct field references
   */
  private static String replaceFieldNamesInBody(String body, ObjectHolder customObject) {
    String result = body;
    for (ObjectHolder.Field field : customObject.fields) {
      result = result.replaceAll("\\b" + field.name + "\\b", "obj." + field.name);
    }
    for (ObjectHolder.Field field : customObject.fields) {
      int genericStart = field.type.indexOf('<');
      if (genericStart < 0) {
        continue;
      }
      String objectType = field.type.substring(0, genericStart).trim();
      String genericArguments = field.type.substring(genericStart);
      String initializer = "obj." + field.name + " = init_" + objectType.toLowerCase() + "(";
      String typedInitializer = "obj." + field.name + " = init_" + objectType.toLowerCase()
              + genericArguments + "(";
      result = result.replace(initializer, typedInitializer);
    }
    for (ObjectHolder.Field field : customObject.fields) {
      if (!field.type.equals("string") && !field.type.equals("char")) {
        String fieldAccess = "obj." + field.name;
        result = result.replaceAll("\\+\\s*" + java.util.regex.Pattern.quote(fieldAccess),
                "+ std::to_string(" + fieldAccess + ")");
      }
    }
    return result;
  }

  /**
   * Ensure that the generated_objects folder exists.
   */
  private static void ensureFolderExists() {
    File folder = new File(objectsFolder);
    if (!folder.exists()) {
      boolean success = folder.mkdirs();
      if (success) {
        System.out.println("Created generated_objects folder: " + objectsFolder);
      } else {
        System.err.println("Failed to create generated_objects folder");
      }
    }
  }

  /*
    Retrieves the include strings necessary for fields from runtime or custom fields.
    If no hpp for the field is found it is supposed to be a primitive field.
  */
  private static String getIncludePathOfObject(String object, Map<String, Path> availableHeaders) {
    // Remove the <...> from the object e.g List<string> -> List to search possible hpp file
    String cleanObject = object.contains("<") 
      ? object.substring(0, object.indexOf("<")) : object;
    Path header = availableHeaders.get(cleanObject.toLowerCase());
    if (header == null) {
       return "";
    }
    return "#include \"" + header.toString().replace("\\", "/") + "\"\n";
  }
}
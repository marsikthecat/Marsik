package org.example.compiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomModuleGenerator {
  private static String outputFolder = "src/main/java/org/example/out";

  private CustomModuleGenerator() {}

  public static void setOutputFolder(String folder) {
    outputFolder = folder;
  }

  public static void generateModule(ModuleHolder module) {
    try {
      Path folder = Path.of(outputFolder).toAbsolutePath();
      Files.createDirectories(folder);
      Path headerPath = folder.resolve(module.name.toLowerCase() + ".hpp");
      Files.deleteIfExists(headerPath);

      Path implementationPath = folder.resolve(module.name.toLowerCase() + ".cpp");
      Files.writeString(implementationPath, generateImplementation(module));
      GeneratedFilesTracker.registerGeneratedFile(implementationPath.toString());
    } catch (IOException exception) {
      throw new IllegalStateException("Failed to generate module " + module.name, exception);
    }
  }

  private static String generateImplementation(ModuleHolder module) {
    StringBuilder implementation = new StringBuilder();
    implementation.append("#include \"../runtime/stringUtils.hpp\"\n")
            .append("#include <iostream>\n")
            .append("#include <string>\n");
    for (String include : module.requiredIncludes) {
      implementation.append(include);
    }
    implementation.append('\n');

    for (String declaration : module.requiredDeclarations) {
      implementation.append(declaration).append('\n');
    }
    if (!module.requiredDeclarations.isEmpty()) {
      implementation.append('\n');
    }

    for (ModuleHolder.Function function : module.functions) {
      implementation.append(Utils.toCppType(function.returnType)).append(' ')
              .append(module.name.toLowerCase()).append('_').append(function.name).append('(');
      for (int i = 0; i < function.parameters.size(); i++) {
        ModuleHolder.Parameter parameter = function.parameters.get(i);
        if (i > 0) {
          implementation.append(", ");
        }
        implementation.append(Utils.toCppType(parameter.type)).append(' ')
                .append(parameter.name);
      }
      implementation.append(") ").append(function.body).append('\n');
    }
    return implementation.toString();
  }
}

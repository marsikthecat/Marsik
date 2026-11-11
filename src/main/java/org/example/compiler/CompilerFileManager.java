package org.example.compiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class CompilerFileManager {

  private final Path projectRoot;

  /** Creates a file manager using the project root for runtime discovery. */
  public CompilerFileManager(Path projectRoot) {
    this.projectRoot = projectRoot.toAbsolutePath().normalize();
  }

  /** Creates the output directory if needed and returns its normalized absolute path. */
  public Path prepareOutputDirectory(Path outputDirectory) throws IOException {
    Path normalized = outputDirectory.toAbsolutePath().normalize();
    Files.createDirectories(normalized);
    return normalized;
  }

  /** Finds the runtime directory containing the umbrella header. */
  public Path findRuntimeDirectory(Path sourcePath) throws IOException {
    Path projectRuntime = projectRoot.resolve("src/main/java/org/example/runtime");
    if (Files.isRegularFile(projectRuntime.resolve("marsik_runtime.hpp"))) {
      return projectRuntime;
    }
    for (Path parent = sourcePath.toAbsolutePath().normalize().getParent();
         parent != null; parent = parent.getParent()) {
      Path runtime = parent.resolve("runtime");
      if (Files.isRegularFile(runtime.resolve("marsik_runtime.hpp"))) {
        return runtime;
      }
      runtime = parent.resolve("src/main/java/org/example/runtime");
      if (Files.isRegularFile(runtime.resolve("marsik_runtime.hpp"))) {
        return runtime;
      }
    }
    throw new IOException("Could not locate runtime directory containing marsik_runtime.hpp");
  }

  /** Returns the sorted C++ source files that must be linked from the runtime. */
  public List<Path> runtimeSources(Path runtimeDirectory) throws IOException {
    try (var paths = Files.walk(runtimeDirectory)) {
      return paths.filter(Files::isRegularFile)
              .filter(path -> path.toString().endsWith(".cpp"))
              .map(path -> path.toAbsolutePath().normalize())
              .sorted()
              .toList();
    }
  }

  /** Writes the generated main translation unit and returns its path. */
  public Path writeMainSource(Path outputDirectory, String source) throws IOException {
    return writeGeneratedSource(outputDirectory.resolve("generated.cpp"), source);
  }

  /** Writes an imported module translation unit and returns its path. */
  public Path writeModuleSource(Path outputDirectory, String moduleName, String source)
          throws IOException {
    return writeGeneratedSource(outputDirectory.resolve("module_" + moduleName + ".cpp"), source);
  }

  /** Returns the expected path of the compiled application executable. */
  public Path executablePath(Path outputDirectory) {
    return outputDirectory.resolve("app.exe");
  }

  /** Returns the shared build directory used for cached runtime artifacts. */
  public Path runtimeBuildDirectory() {
    return projectRoot.resolve("build/marsik-runtime");
  }

  /** Returns the expected generated C++ path for an imported module. */
  public Path moduleSourcePath(Path outputDirectory, String moduleName) {
    return outputDirectory.resolve("module_" + moduleName + ".cpp");
  }

  /** Reads a Marsik source file, failing if the path does not identify a regular file. */
  public String readSource(Path sourcePath) throws IOException {
    Path normalized = sourcePath.toAbsolutePath().normalize();
    if (!Files.isRegularFile(normalized)) {
      throw new IOException("Marsik source file not found: " + normalized);
    }
    return Files.readString(normalized);
  }

  /** Resolves an import string relative to its importing file and verifies that it exists. */
  public Path resolveImport(Path importingFile, String stringLiteral) throws IOException {
    String importPath = stringLiteral.substring(1, stringLiteral.length() - 1)
            .replace("\\\"", "\"").replace("\\\\", "\\");
    Path requested = Path.of(importPath);
    if (!requested.isAbsolute()) {
      requested = importingFile.getParent().resolve(requested);
    }
    if (!requested.getFileName().toString().endsWith(".marsik")) {
      requested = requested.resolveSibling(requested.getFileName() + ".marsik");
    }
    requested = requested.toAbsolutePath().normalize();
    if (!Files.isRegularFile(requested)) {
      throw new IOException("Imported Marsik file not found: " + requested
              + " (imported from " + importingFile + ")");
    }
    return requested;
  }

  /** Validates and returns the module identifier derived from a Marsik filename. */
  public String moduleName(Path source) throws IOException {
    String fileName = source.getFileName().toString();
    if (!fileName.endsWith(".marsik")) {
      throw new IOException("Imported file name must end with .marsik: " + fileName);
    }
    String name = fileName.substring(0, fileName.length() - ".marsik".length());
    if (!name.matches("[A-Za-z_][A-Za-z_0-9]*") || Utils.isForbiddenName(name)) {
      throw new IOException("Imported file name must be a valid module identifier: " + fileName);
    }
    return name;
  }

  /** Writes generated C++ source to the requested path and returns that path. */
  private Path writeGeneratedSource(Path path, String source) throws IOException {
    Files.writeString(path, source);
    return path;
  }
}

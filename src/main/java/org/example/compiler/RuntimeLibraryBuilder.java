package org.example.compiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HexFormat;
import java.util.List;

public final class RuntimeLibraryBuilder {

  private static final List<String> COMPILE_FLAGS =
          List.of("-std=gnu++17", "-O2", "-Wall");

  private final Path buildDirectory;

  public RuntimeLibraryBuilder(Path buildDirectory) {
    this.buildDirectory = buildDirectory.toAbsolutePath().normalize();
  }

  public Path build(Path runtimeDirectory, List<Path> runtimeSources, String cppCompiler)
          throws IOException, InterruptedException {
    Files.createDirectories(buildDirectory);
    String archiver = findArchiver(cppCompiler);
    String fingerprint = fingerprint(runtimeDirectory, cppCompiler, archiver);
    Path library = buildDirectory.resolve("libmarsik_runtime.a");
    Path fingerprintFile = buildDirectory.resolve("runtime.fingerprint");
    if (Files.isRegularFile(library) && Files.isRegularFile(fingerprintFile)
            && Files.readString(fingerprintFile).equals(fingerprint)) {
      return library;
    }

    Path temporaryDirectory = Files.createTempDirectory(buildDirectory, "runtime-build-");
    try {
      List<Path> objects = new ArrayList<>();
      for (Path source : runtimeSources) {
        Path relativeSource = runtimeDirectory.toAbsolutePath().normalize().relativize(source);
        Path object = temporaryDirectory.resolve(relativeSource).resolveSibling(
                relativeSource.getFileName().toString().replaceFirst("\\.[^.]+$", ".o"));
        Files.createDirectories(object.getParent());

        List<String> command = new ArrayList<>();
        command.add(cppCompiler);
        command.addAll(COMPILE_FLAGS);
        command.add("-I" + runtimeDirectory);
        command.add("-c");
        command.add(source.toString());
        command.add("-o");
        command.add(object.toString());
        run(command, true);
        objects.add(object);
      }

      Path temporaryLibrary = temporaryDirectory.resolve("libmarsik_runtime.a");
      List<String> archiveCommand = new ArrayList<>(List.of(archiver, "rcs", temporaryLibrary.toString()));
      objects.stream().map(Path::toString).forEach(archiveCommand::add);
      run(archiveCommand, true);

      Path temporaryFingerprint = temporaryDirectory.resolve("runtime.fingerprint");
      Files.writeString(temporaryFingerprint, fingerprint, StandardCharsets.UTF_8);
      replaceFile(temporaryLibrary, library);
      replaceFile(temporaryFingerprint, fingerprintFile);
      return library;
    } finally {
      deleteTree(temporaryDirectory);
    }
  }

  private static String fingerprint(Path runtimeDirectory, String cppCompiler, String archiver)
          throws IOException, InterruptedException {
    MessageDigest digest = sha256();
    digest.update(cppCompiler.getBytes(StandardCharsets.UTF_8));
    digest.update(run(List.of(cppCompiler, "--version"), false).getBytes(StandardCharsets.UTF_8));
    digest.update(run(List.of(cppCompiler, "-dumpmachine"), false).getBytes(StandardCharsets.UTF_8));
    digest.update(archiver.getBytes(StandardCharsets.UTF_8));
    digest.update(run(List.of(archiver, "--version"), false).getBytes(StandardCharsets.UTF_8));
    COMPILE_FLAGS.forEach(flag -> digest.update(flag.getBytes(StandardCharsets.UTF_8)));

    Path normalizedRuntimeDirectory = runtimeDirectory.toAbsolutePath().normalize();
    digest.update(normalizedRuntimeDirectory.toString().getBytes(StandardCharsets.UTF_8));
    try (var files = Files.walk(normalizedRuntimeDirectory)) {
      for (Path file : files.filter(Files::isRegularFile).sorted().toList()) {
        digest.update(normalizedRuntimeDirectory.relativize(file).toString()
                .getBytes(StandardCharsets.UTF_8));
        digest.update(Files.readAllBytes(file));
      }
    }
    return HexFormat.of().formatHex(digest.digest());
  }

  private static String findArchiver(String cppCompiler) {
    Path compilerPath = Path.of(cppCompiler);
    if (compilerPath.getParent() != null) {
      Path compilerDirectory = compilerPath.toAbsolutePath().normalize().getParent();
      for (String name : List.of("ar.exe", "ar")) {
        Path archiver = compilerDirectory.resolve(name);
        if (Files.isExecutable(archiver)) {
          return archiver.toString();
        }
      }
    }
    return System.getProperty("os.name").toLowerCase().contains("win") ? "ar.exe" : "ar";
  }

  private static String run(List<String> command, boolean printOutput)
          throws IOException, InterruptedException {
    Process process = new ProcessBuilder(command).redirectErrorStream(true).start();
    StringBuilder output = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line).append(System.lineSeparator());
        if (printOutput) {
          System.out.println(line);
        }
      }
    }
    int exitCode = process.waitFor();
    if (exitCode != 0) {
      throw new IOException("Command failed with exit code " + exitCode + ": "
              + String.join(" ", command) + System.lineSeparator() + output);
    }
    return output.toString().trim();
  }

  private static MessageDigest sha256() {
    try {
      return MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException exception) {
      throw new IllegalStateException("SHA-256 is unavailable", exception);
    }
  }

  private static void replaceFile(Path source, Path destination) throws IOException {
    try {
      Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING,
              StandardCopyOption.ATOMIC_MOVE);
    } catch (AtomicMoveNotSupportedException exception) {
      Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }
  }

  private static void deleteTree(Path directory) throws IOException {
    if (!Files.exists(directory)) {
      return;
    }
    try (var paths = Files.walk(directory)) {
      for (Path path : paths.sorted(Comparator.reverseOrder()).toList()) {
        Files.deleteIfExists(path);
      }
    }
  }
}

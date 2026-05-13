package org.example.compiler;

import java.util.HashSet;
import java.util.Set;
import org.example.utils.FileHandler;

/**
 * Tracks all generated custom object files (.h and .c) for cleanup.
 * Provides functionality to register and delete generated files when the program terminates.
 */
public class GeneratedFilesTracker {
  private static final Set<String> generatedFiles = new HashSet<>();

  /**
   * Register a generated file for later cleanup.
   *
   * @param filePath the absolute path to the generated file
   */
  public static void registerGeneratedFile(String filePath) {
    generatedFiles.add(filePath);
  }

  /**
   * Delete all tracked generated files and the "out" folder.
   * This should be called before program termination.
   */
  public static void cleanupGeneratedFiles() {
    for (String filePath : generatedFiles) {
      if (FileHandler.doesFileExist(filePath)) {
        FileHandler.deleteFile(filePath);
      }
    }
    generatedFiles.clear();

    // Delete the "out" folder
    String outFolderPath = "C:\\Users\\dani_\\Desktop\\MarsikLang2\\src\\main\\java\\org\\example\\out";
    java.io.File outFolder = new java.io.File(outFolderPath);
    if (outFolder.exists() && outFolder.isDirectory()) {
      deleteDirectoryRecursive(outFolder);
    }
  }

  /**
   * Recursively delete a directory and all its contents.
   *
   * @param dir the directory to delete
   */
  private static void deleteDirectoryRecursive(java.io.File dir) {
    if (dir.isDirectory()) {
      java.io.File[] files = dir.listFiles();
      if (files != null) {
        for (java.io.File file : files) {
          deleteDirectoryRecursive(file);
        }
      }
    }
    dir.delete();
  }

  /**
   * Get the number of tracked generated files.
   *
   * @return count of generated files
   */
  public static int getGeneratedFileCount() {
    return generatedFiles.size();
  }

  /**
   * Clear all tracked files without deleting them from disk.
   */
  public static void reset() {
    generatedFiles.clear();
  }
}


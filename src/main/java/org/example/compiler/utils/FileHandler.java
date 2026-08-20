package org.example.compiler.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System;
import java.util.Scanner;

/**
 * Utility class for basic file operations.
 * Provides methods for creating, writing, reading, deleting
 * and checking the existence of files using String paths.
 */
public class FileHandler {

  /**
   * Utility class: No instantiation or your toilet will be clogged.
   */
  private FileHandler() {}

  /**
   * Creates a new file at the given path.
   *
   * @param pathWithFileName full path including file name
   * @return true if the file was created successfully,
   *         false if the file already exists or an error occurred
   */
  public static boolean createNewFile(String pathWithFileName) {
    try {
      File file = new File(pathWithFileName);
      if (file.createNewFile()) {
        System.out.println("File successfully created: " + file.getName());
        return true;
      } else {
        System.out.println("File already exists: " + file.getName());
        return false;
      }
    } catch (IOException e) {
      System.err.println("An error occurred while creating file " + pathWithFileName
              + " : " + e.getMessage());
      return false;
    }
  }

  /**
   * Writes content to a file.
   * If the file already exists, its content will be overwritten.
   *
   * @param pathWithFileName full path including file name
   * @param content          content to write into the file
   * @return true if writing was successful, false otherwise
   */
  public static boolean writeToFile(String pathWithFileName, String content) {
    try {
      FileWriter myWriter = new FileWriter(pathWithFileName);
      myWriter.write(content);
      myWriter.close();
      System.out.println("Successfully wrote to file: " + pathWithFileName);
      return true;
    } catch (IOException e) {
      System.err.println("An error occurred while writing to file " + pathWithFileName
              + " : " + e.getMessage());
      return false;
    }
  }

  /**
   * Reads the content of a file.
   *
   * @param pathWithFileName full path including file name
   * @return file content as a MarsikString (empty if file could not be read)
   */
  public static String readFile(String pathWithFileName) {
    StringBuilder builder = new StringBuilder();
    try {
      File myObj = new File(pathWithFileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        builder.append(myReader.nextLine()).append("\n");
      }
      myReader.close();
      System.out.println("Successfully read file: " + pathWithFileName);
    } catch (FileNotFoundException e) {
      System.err.println("An error occurred while reading file " + pathWithFileName
              + " : " + e.getMessage());
    }
    return builder.toString();
  }

  /**
   * Deletes a file at the given path.
   *
   * @param pathWithFileName full path including file name
   * @return true if the file was deleted successfully, false otherwise
   */
  public static boolean deleteFile(String pathWithFileName) {
    File myObj = new File(pathWithFileName);
    if (myObj.delete()) {
      System.out.println("Successfully deleted the file: " + myObj.getName());
      return true;
    } else {
      System.err.println("Not able to delete File: " + myObj.getName());
      return false;
    }
  }

  /**
   * Checks whether a file exists at the given path.
   *
   * @param pathWithFileName full path including file name
   * @return true if the file exists, false otherwise
   */
  public static boolean doesFileExist(String pathWithFileName) {
    return new File(pathWithFileName).exists();
  }
}
package org.example.internals;

import java.io.*;
import java.lang.System;
import java.util.Scanner;

public class FileHandler {

  private FileHandler() {
    // No instantiation or your toilet will be clogged.
  }

  public static boolean createNewFile(String pathWithFileName) {
    try {
      File file = new File(pathWithFileName);
      if (file.createNewFile()) {
        java.lang.System.out.println("File successfully created: " +  file.getName());
        return true;
      } else {
        java.lang.System.out.println("File already exists: " + file.getName());
        return false;
      }
    } catch (IOException e) {
      java.lang.System.err.println("An error occurred while creating file " + pathWithFileName + " : "
              + e.getMessage());
      return false;
    }
  }

  public static boolean writeToFile(String pathWithFileName, String content) {
    try {
      FileWriter myWriter = new FileWriter(pathWithFileName);
      myWriter.write(content);
      myWriter.close();
      java.lang.System.out.println("Successfully wrote to file: " + pathWithFileName);
      return true;
    } catch (IOException e) {
      java.lang.System.err.println("An error occurred while writing to file " + pathWithFileName + " : "
              + e.getMessage());
      return false;
    }
  }

  public static String readFile(String pathWithFileName) {
    StringBuilder builder = new StringBuilder();
    try {
      File myObj = new File(pathWithFileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        builder.append(myReader.nextLine()).append("\n");
      }
      myReader.close();
      java.lang.System.out.println("Successfully read file: " + pathWithFileName);
    } catch (FileNotFoundException e) {
      java.lang.System.err.println("An error occurred while reading file " + pathWithFileName + " : "
              + e.getMessage());
    }
    return builder.toString();
  }

  public static boolean deleteFile(String pathWithFileName) {
    File myObj = new File(pathWithFileName);
    if (myObj.delete()) {
      java.lang.System.out.println("Successfully deleted the file: " + myObj.getName());
      return true;
    } else {
      System.err.println("Not able to delete File: " + myObj.getName());
      return false;
    }
  }

  public static boolean doesFileExist(String pathWithFileName) {
    File myObj = new File(pathWithFileName);
    return myObj.exists();
  }
}
package org.example.internals;

import org.example.internals.datastructures.MarsikString;

import java.io.*;
import java.lang.System;
import java.util.Scanner;

public class FileHandler {

  private FileHandler() {
    // No instantiation or your toilet will be clogged.
  }

  public static boolean createNewFile(MarsikString pathWithFileName) {
    try {
      File file = new File(pathWithFileName.toJavaString());
      if (file.createNewFile()) {
        java.lang.System.out.println("File successfully created: " +  file.getName());
        return true;
      } else {
        java.lang.System.out.println("File already exists: " + file.getName());
        return false;
      }
    } catch (IOException e) {
      java.lang.System.err.println("An error occurred while creating file " + pathWithFileName.toJavaString()
              + " : " + e.getMessage());
      return false;
    }
  }

  public static boolean writeToFile(MarsikString pathWithFileName, MarsikString content) {
    try {
      FileWriter myWriter = new FileWriter(pathWithFileName.toJavaString());
      myWriter.write(content.toJavaString());
      myWriter.close();
      java.lang.System.out.println("Successfully wrote to file: " + pathWithFileName.toJavaString());
      return true;
    } catch (IOException e) {
      java.lang.System.err.println("An error occurred while writing to file " + pathWithFileName.toJavaString()
              + " : " + e.getMessage());
      return false;
    }
  }

  public static MarsikString readFile(MarsikString pathWithFileName) {
    StringBuilder builder = new StringBuilder();
    try {
      File myObj = new File(pathWithFileName.toJavaString());
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        builder.append(myReader.nextLine()).append("\n");
      }
      myReader.close();
      java.lang.System.out.println("Successfully read file: " + pathWithFileName.toJavaString());
    } catch (FileNotFoundException e) {
      java.lang.System.err.println("An error occurred while reading file " + pathWithFileName.toJavaString()
              + " : " + e.getMessage());
    }
    return new MarsikString(builder.toString());
  }

  public static boolean deleteFile(MarsikString pathWithFileName) {
    File myObj = new File(pathWithFileName.toJavaString());
    if (myObj.delete()) {
      java.lang.System.out.println("Successfully deleted the file: " + myObj.getName());
      return true;
    } else {
      System.err.println("Not able to delete File: " + myObj.getName());
      return false;
    }
  }

  public static boolean doesFileExist(MarsikString pathWithFileName) {
    File myObj = new File(pathWithFileName.toJavaString());
    return myObj.exists();
  }
}
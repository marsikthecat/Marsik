package org.example.internals.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * A lightweight, fixed-size generic array wrapper providing
 * utility methods for all primitive types.
 * This class stores elements internally in a plain array and does
 * not support resizing.
 */
public class ArrayUtils {

  /**
   * Returns the number of elements in the array.
   *
   * @return the array size
   */
  public static int length(int[] array) {
    return array.length;
  }

  /**
   * Checks whether the array contains the given value.
   *
   * @param value the value to search for
   * @return {@code true} if the value exists, otherwise {@code false}
   */
  public static boolean contains(int[] array, int value) {
    return indexOf(array, value) != -1;
  }

  /**
   * Checks whether the array contains the given value.
   *
   * @param value the value to search for
   * @return {@code true} if the value exists, otherwise {@code false}
   */
  public static boolean contains(double[] array, double value) {
    return indexOf(array, value) != -1;
  }

  /**
   * Checks whether the array contains the given value.
   *
   * @param value the value to search for
   * @return {@code true} if the value exists, otherwise {@code false}
   */
  public static boolean contains(char[] array, char value) {
    return indexOf(array, value) != -1;
  }

  /**
   * Checks whether the array contains the given value.
   *
   * @param value the value to search for
   * @return {@code true} if the value exists, otherwise {@code false}
   */
  public static boolean contains(String[] array, String value) {
    return indexOf(array, value) != -1;
  }

  /**
   * Checks whether the array contains the given value.
   *
   * @param value the value to search for
   * @return {@code true} if the value exists, otherwise {@code false}
   */
  public static boolean contains(boolean[] array, boolean value) {
    return indexOf(array, value) != -1;
  }

  /**
   * Returns the index of the given value.
   *
   * @param value the value to search for
   * @return the index of the value, or {@code -1} if not found
   */
  public static int indexOf(int[] array, int value) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == value) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns the index of the given value.
   *
   * @param value the value to search for
   * @return the index of the value, or {@code -1} if not found
   */
  public static int indexOf(double[] array, double value) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == value) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns the index of the given value.
   *
   * @param value the value to search for
   * @return the index of the value, or {@code -1} if not found
   */
  public static int indexOf(char[] array, char value) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == value) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns the index of the given value.
   *
   * @param value the value to search for
   * @return the index of the value, or {@code -1} if not found
   */
  public static int indexOf(String[] array, String value) {
    for (int i = 0; i < array.length; i++) {
      if (array[i].equals(value)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns the index of the given value.
   *
   * @param value the value to search for
   * @return the index of the value, or {@code -1} if not found
   */
  public static int indexOf(boolean[] array, boolean value) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == value) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns a random element from the array.
   *
   * @return a randomly selected element
   */
  public static int getRandomElement(int[] array) {
    return array[(int) (Math.random() * array.length)];
  }

  /**
   * Returns a random element from the array.
   *
   * @return a randomly selected element
   */
  public static double getRandomElement(double[] array) {
    return array[(int) (Math.random() * array.length)];
  }

  /**
   * Returns a random element from the array.
   *
   * @return a randomly selected element
   */
  public static char getRandomElement(char[] array) {
    return array[(int) (Math.random() * array.length)];
  }

  /**
   * Returns a random element from the array.
   *
   * @return a randomly selected element
   */
  public static String getRandomElement(String[] array) {
    return array[(int) (Math.random() * array.length)];
  }

  /**
   * Returns a random element from the array.
   *
   * @return a randomly selected element
   */
  public static boolean getRandomElement(boolean[] array) {
    return array[(int) (Math.random() * array.length)];
  }

  /**
   * Returns a subarray from {@code start} (inclusive) to {@code end} (exclusive).
   *
   * @param start start index (inclusive)
   * @param end end index (exclusive)
   * @return a new {@code MarsikArray} containing the slice
   * @throws IllegalArgumentException if parameters are invalid
   */
  public static int[] slice(int[] arr, int start, int end) {
    if (start > end || start < 0 || end >= arr.length) {
      throw new IllegalArgumentException("Invalid parameters");
    }
    int[] res = new int[end - start];
    System.arraycopy(arr, start, res, 0, end - start);
    return res;
  }

  /**
   * Returns a subarray from {@code start} (inclusive) to {@code end} (exclusive).
   *
   * @param start start index (inclusive)
   * @param end end index (exclusive)
   * @return a new {@code MarsikArray} containing the slice
   * @throws IllegalArgumentException if parameters are invalid
   */
  public static double[] slice(double[] arr, int start, int end) {
    if (start > end || start < 0 || end >= arr.length) {
      throw new IllegalArgumentException("Invalid parameters");
    }
    double[] res = new double[end - start];
    System.arraycopy(arr, start, res, 0, end - start);
    return res;
  }

  /**
   * Returns a subarray from {@code start} (inclusive) to {@code end} (exclusive).
   *
   * @param start start index (inclusive)
   * @param end end index (exclusive)
   * @return a new {@code MarsikArray} containing the slice
   * @throws IllegalArgumentException if parameters are invalid
   */
  public static char[] slice(char[] arr, int start, int end) {
    if (start > end || start < 0 || end >= arr.length) {
      throw new IllegalArgumentException("Invalid parameters");
    }
    char[] res = new char[end - start];
    System.arraycopy(arr, start, res, 0, end - start);
    return res;
  }

  /**
   * Returns a subarray from {@code start} (inclusive) to {@code end} (exclusive).
   *
   * @param start start index (inclusive)
   * @param end end index (exclusive)
   * @return a new {@code MarsikArray} containing the slice
   * @throws IllegalArgumentException if parameters are invalid
   */
  public static String[] slice(String[] arr, int start, int end) {
    if (start > end || start < 0 || end >= arr.length) {
      throw new IllegalArgumentException("Invalid parameters");
    }
    String[] res = new String[end - start];
    System.arraycopy(arr, start, res, 0, end - start);
    return res;
  }

  /**
   * Returns a subarray from {@code start} (inclusive) to {@code end} (exclusive).
   *
   * @param start start index (inclusive)
   * @param end end index (exclusive)
   * @return a new {@code MarsikArray} containing the slice
   * @throws IllegalArgumentException if parameters are invalid
   */
  public static boolean[] slice(boolean[] arr, int start, int end) {
    if (start > end || start < 0 || end >= arr.length) {
      throw new IllegalArgumentException("Invalid parameters");
    }
    boolean[] res = new boolean[end - start];
    System.arraycopy(arr, start, res, 0, end - start);
    return res;
  }

  /**
   * Removes duplicate occurrences of the given element,
   * keeping only the first occurrence.
   *
   * @param elem the element whose duplicates should be removed
   * @return a new array without duplicate occurrences
   */
  public static int[] removeDuplicateOf(int[] arr, int elem) {
    ArrayList<Integer> list = new ArrayList<>();
    boolean found = false;
    for (int j : arr) {
      if (j == elem && !found) {
        found = true;
        list.add(j);
      }
    }
    return list.stream().mapToInt(i -> i).toArray();
  }

  /**
   * Removes duplicate occurrences of the given element,
   * keeping only the first occurrence.
   *
   * @param elem the element whose duplicates should be removed
   * @return a new array without duplicate occurrences
   */
  public static double[] removeDuplicateOf(double[] arr, double elem) {
    ArrayList<Double> list = new ArrayList<>();
    boolean found = false;
    for (double v : arr) {
      if (v == elem && !found) {
        found = true;
        list.add(v);
      }
    }
    return list.stream().mapToDouble(i -> i).toArray();
  }

  /**
   * Removes all duplicate elements.
   *
   * @return a new array containing only unique elements
   */
  public static int[] withoutDuplicates(int[] arr) {
    HashSet<Integer> s = new HashSet<>();
    for (int j : arr) {
      s.add(j);
    }
    return s.stream().mapToInt(i -> i).toArray();
  }

  /**
   * Removes all duplicate elements.
   *
   * @return a new array containing only unique elements
   */
  public static double[] withoutDuplicates(double[] arr) {
    HashSet<Double> s = new HashSet<>();
    for (double j : arr) {
      s.add(j);
    }
    return s.stream().mapToDouble(i -> i).toArray();
  }

  /**
   * Creates a shallow duplicate of this array.
   *
   * @return a new {@code MarsikArray} with copied contents
   */
  public static int[] duplicate(int[] array) {
    return array.clone();
  }

  /**
   * Creates a shallow duplicate of this array.
   *
   * @return a new {@code MarsikArray} with copied contents
   */
  public static double[] duplicate(double[] array) {
    return array.clone();
  }

  /**
   * Creates a shallow duplicate of this array.
   *
   * @return a new {@code MarsikArray} with copied contents
   */
  public static char[] duplicate(char[] array) {
    return array.clone();
  }

  /**
   * Creates a shallow duplicate of this array.
   *
   * @return a new {@code MarsikArray} with copied contents
   */
  public static boolean[] duplicate(boolean[] array) {
    return array.clone();
  }

  /**
   * Creates a shallow duplicate of this array.
   *
   * @return a new {@code MarsikArray} with copied contents
   */
  public static String[] duplicate(String[] array) {
    return array.clone();
  }

  /**
   * Sorts the array if the elements are {@link Comparable}.
   *
   * @throws IllegalStateException if elements are not comparable
   */
  public static void sort(int[] array) {
    Arrays.sort(array);
  }

  /**
   * Sorts the array if the elements are {@link Comparable}.
   *
   * @throws IllegalStateException if elements are not comparable
   */
  public static void sort(double[] array) {
    Arrays.sort(array);
  }

  /**
   * Sorts the array if the elements are {@link Comparable}.
   *
   * @throws IllegalStateException if elements are not comparable
   */
  public static void sort(char[] array) {
    Arrays.sort(array);
  }

  /**
   * Sorts the array if the elements are {@link Comparable}.
   *
   * @throws IllegalStateException if elements are not comparable
   */
  public static void sort(boolean[] array) {
    // TODO: this
  }

  /**
   * Sorts the array if the elements are {@link Comparable}.
   *
   * @throws IllegalStateException if elements are not comparable
   */
  public static void sort(String[] array) {
    Arrays.sort(array);
  }

  /**
   * Returns the maximum numeric value in the array.
   *
   * @return the maximum value
   * @throws IllegalArgumentException if elements are not numbers
   */
  public static int max(int[] array) {
    int max = 0;
    for (int e : array) {
      if (e > max) {
        max = e;
      }
    }
    return max;
  }

  /**
   * Returns the maximum numeric value in the array.
   *
   * @return the maximum value
   * @throws IllegalArgumentException if elements are not numbers
   */
  public static double max(double[] array) {
    double max = 0;
    for (double e : array) {
      if (e > max) {
        max = e;
      }
    }
    return max;
  }

  /**
   * Returns the minimum numeric value in the array.
   *
   * @return the minimum value
   * @throws IllegalArgumentException if elements are not numbers
   */
  public static int min(int[] array) {
    int min = array[0];
    for (int e : array) {
      if (e < min) {
        min = e;
      }
    }
    return min;
  }

  /**
   * Returns the minimum numeric value in the array.
   *
   * @return the minimum value
   * @throws IllegalArgumentException if elements are not numbers
   */
  public static double min(double[] array) {
    double min = array[0];
    for (double e : array) {
      if (e < min) {
        min = e;
      }
    }
    return min;
  }

  /**
   * Returns the sum of all numeric elements.
   *
   * @return the sum
   * @throws NoSuchElementException if elements are not numeric
   */
  public static int sum(int[] array) {
    int sum = 0;
    for (int element : array) {
      sum += element;
    }
    return sum;
  }

  /**
   * Returns the sum of all numeric elements.
   *
   * @return the sum
   * @throws NoSuchElementException if elements are not numeric
   */
  public static double sum(double[] array) {
    double sum = 0;
    for (double element : array) {
      sum += element;
    }
    return sum;
  }

  /**
   * Returns the average of all numeric elements.
   *
   * @return the average value
   */
  public static int avg(int[] array) {
    return sum(array) / array.length;
  }

  /**
   * Returns the average of all numeric elements.
   *
   * @return the average value
   */
  public static double avg(double[] array) {
    return sum(array) / array.length;
  }

  /**
   * Returns the most frequently appearing element.
   *
   * @return the most common element
   */
  public int mostAppearingElement(int[] array) {
    HashMap<Object, Integer> map = new HashMap<>();
    for (Object o : array) {
      map.merge(o, 1, Integer::sum);
    }
    int mostElement = 0;
    int maxCount = 0;
    for (Map.Entry<Object, Integer> entry : map.entrySet()) {
      if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        mostElement = (int) entry.getKey();
      }
    }
    return mostElement;
  }

  /**
   * Returns the most frequently appearing element.
   *
   * @return the most common element
   */
  public double mostAppearingElement(double[] array) {
    HashMap<Object, Integer> map = new HashMap<>();
    for (Object o : array) {
      map.merge(o, 1, Integer::sum);
    }
    double mostElement = 0;
    int maxCount = 0;
    for (Map.Entry<Object, Integer> entry : map.entrySet()) {
      if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        mostElement = (double) entry.getKey();
      }
    }
    return mostElement;
  }

  /**
   * Returns the most frequently appearing element.
   *
   * @return the most common element
   */
  public char mostAppearingElement(char[] array) {
    HashMap<Object, Integer> map = new HashMap<>();
    for (Object o : array) {
      map.merge(o, 1, Integer::sum);
    }
    char mostElement = 0;
    int maxCount = 0;
    for (Map.Entry<Object, Integer> entry : map.entrySet()) {
      if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        mostElement = (char) entry.getKey();
      }
    }
    return mostElement;
  }

  /**
   * Returns the most frequently appearing element.
   *
   * @return the most common element
   */
  public String mostAppearingElement(String[] array) {
    HashMap<Object, Integer> map = new HashMap<>();
    for (Object o : array) {
      map.merge(o, 1, Integer::sum);
    }
    String mostElement = "";
    int maxCount = 0;
    for (Map.Entry<Object, Integer> entry : map.entrySet()) {
      if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        mostElement = (String) entry.getKey();
      }
    }
    return mostElement;
  }

  /**
   * Returns the most frequently appearing element.
   *
   * @return the most common element
   */
  public boolean mostAppearingElement(boolean[] array) {
    HashMap<Object, Integer> map = new HashMap<>();
    for (Object o : array) {
      map.merge(o, 1, Integer::sum);
    }
    boolean mostElement = true;
    int maxCount = 0;
    for (Map.Entry<Object, Integer> entry : map.entrySet()) {
      if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        mostElement = (boolean) entry.getKey();
      }
    }
    return mostElement;
  }

  /**
   * Prints the array contents to standard output.
   */
  public static void print(int[] array) {
    for (int i = 0; i < array.length + 1; i++) {
      System.out.println("Array[" + i + "]" + " : " + array[i]);
    }
  }

  /**
   * Prints the array contents to standard output.
   */
  public static void print(double[] array) {
    for (int i = 0; i < array.length + 1; i++) {
      System.out.println("Array[" + i + "]" + " : " + array[i]);
    }
  }

  /**
   * Prints the array contents to standard output.
   */
  public static void print(char[] array) {
    for (int i = 0; i < array.length + 1; i++) {
      System.out.println("Array[" + i + "]" + " : " + array[i]);
    }
  }

  /**
   * Prints the array contents to standard output.
   */
  public static void print(boolean[] array) {
    for (int i = 0; i < array.length + 1; i++) {
      System.out.println("Array[" + i + "]" + " : " + array[i]);
    }
  }

  /**
   * Prints the array contents to standard output.
   */
  public static void print(String[] array) {
    for (int i = 0; i < array.length + 1; i++) {
      System.out.println("Array[" + i + "]" + " : " + array[i]);
    }
  }
}
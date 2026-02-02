package org.example.internals.datastructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A dynamic generic list with additional utility methods
 * such as random element selection, statistics functions, and duplicate handling.
 *
 * @param <E> the type of elements stored in this list
 */
public class MarsikList<E> {

  private E[] elements;
  private int size = 0;

  /**
   * Constructs an empty list with an initial capacity of 10.
   */
  @SuppressWarnings("unchecked")
  public MarsikList() {
    elements = (E[]) new Object[10];
  }

  /**
   * Constructs a list containing the given elements.
   *
   * @param elem the elements to be added to the list
   */
  @SafeVarargs
  @SuppressWarnings("unchecked")
  public MarsikList(E... elem) {
    elements = (E[]) new Object[Math.max(10, elem.length)];
    System.arraycopy(elem, 0, elements, 0, elem.length);
    size = elem.length;
  }

  /**
   * Returns the number of elements in this list.
   *
   * @return the current size of the list
   */
  public int size() {
    return size;
  }

  private void ensureCapacity(int minCapacity) {
    if (minCapacity > elements.length) {
      elements = Arrays.copyOf(elements, Math.max(elements.length * 2, minCapacity));
    }
  }

  /**
   * Adds an element to the end of the list.
   *
   * @param value the element to add
   */
  public void add(E value) {
    ensureCapacity(size + 1);
    elements[size++] = value;
  }

  /**
   * Inserts an element at the specified index, shifting subsequent elements to the right.
   *
   * @param index the position at which to insert the element
   * @param value the element to insert
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size)
   */
  public void add(int index, E value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    ensureCapacity(size + 1);
    System.arraycopy(elements, index, elements, index + 1, size - index);
    elements[index] = value;
    size++;
  }

  /**
   * Returns the element at the specified position in this list.
   *
   * @param index the index of the element to return
   * @return the element at the specified index
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
   */
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return elements[index];
  }

  /**
   * Replaces the element at the specified position with the given element.
   *
   * @param index the index of the element to replace
   * @param value the element to set
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
   */
  public void set(int index, E value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    elements[index] = value;
  }

  /**
   * Removes the element at the specified position and shifts subsequent elements left.
   *
   * @param index the index of the element to remove
   * @return the removed element
   * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size)
   */
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    E removed = elements[index];
    System.arraycopy(elements, index + 1, elements, index, size - index - 1);
    elements[--size] = null;
    return removed;
  }

  /**
   * Removes the first occurrence of the specified element, if present.
   *
   * @param value the element to remove
   * @return true if the element was removed, false otherwise
   */
  public boolean remove(E value) {
    int idx = indexOf(value);
    if (idx != -1) {
      remove(idx);
      return true;
    }
    return false;
  }

  /**
   * Removes all occurrences of the specified element.
   *
   * @param value the element to remove
   */
  public void removeAll(E value) {
    for (int i = size - 1; i >= 0; i--) {
      if (Objects.equals(elements[i], value)) {
        remove(i);
      }
    }
  }

  /**
   * Returns the index of the first occurrence of the specified element,
   * or -1 if the element is not found.
   *
   * @param value the element to search for
   * @return the index of the first occurrence, or -1 if not found
   */
  public int indexOf(E value) {
    for (int i = 0; i < size; i++) {
      if (Objects.equals(elements[i], value)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns the index of the last occurrence of the specified element,
   * or -1 if the element is not found.
   *
   * @param value the element to search for
   * @return the index of the last occurrence, or -1 if not found
   */
  public int lastIndexOf(E value) {
    for (int i = size - 1; i >= 0; i--) {
      if (Objects.equals(elements[i], value)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns true if the list contains the specified element.
   *
   * @param value the element to check
   * @return true if the element exists, false otherwise
   */
  public boolean contains(E value) {
    return indexOf(value) != -1;
  }

  /**
   * Removes all elements from the list.
   */
  public void clear() {
    Arrays.fill(elements, 0, size, null);
    size = 0;
  }

  /**
   * Removes duplicates of a specific element, keeping only the first occurrence.
   *
   * @param elem the element for which duplicates should be removed
   */
  @SuppressWarnings("unchecked")
  public void removeDuplicateOf(E elem) {
    boolean found = false;
    E[] newElements = (E[]) new Object[elements.length];
    int newSize = 0;
    for (int i = 0; i < size; i++) {
      if (Objects.equals(elements[i], elem)) {
        if (!found) {
          newElements[newSize++] = elements[i];
          found = true;
        }
      } else {
        newElements[newSize++] = elements[i];
      }
    }
    elements = newElements;
    size = newSize;
  }

  /**
   * Returns a new list with all duplicates removed.
   *
   * @return a new {@link MarsikList} containing only unique elements
   */
  @SuppressWarnings("unchecked")
  public MarsikList<E> withoutDuplicates() {
    HashSet<E> set = new HashSet<>(Arrays.asList(elements).subList(0, size));
    return new MarsikList<>(set.toArray((E[]) new Object[0]));
  }

  /**
   * Creates a shallow copy of this list.
   *
   * @return a new {@link MarsikList} containing the same elements
   */
  public MarsikList<E> duplicate() {
    return new MarsikList<>(Arrays.copyOf(elements, size));
  }

  /**
   * Sorts the elements of the list if they implement {@link Comparable}.
   *
   * @throws IllegalStateException if the elements are not comparable
   */
  public void sort() {
    if (!(elements[0] instanceof Comparable)) {
      throw new IllegalStateException("Elements are not comparable!");
    }
    Arrays.sort(elements, 0, size);
  }

  /**
   * Checks whether all elements are instances of {@link Number}.
   *
   * @return true if all elements are numbers, false otherwise
   */
  public boolean allNumbers() {
    for (int i = 0; i < size; i++) {
      E element = elements[i];
      if (!(element instanceof Integer)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns the sum of numeric elements.
   *
   * @return the sum as double
   * @throws NoSuchElementException if there are no numeric elements
   */
  public double sum() {
    if (!allNumbers()) {
      throw new NoSuchElementException("Sum only possible if all elements are numbers!");
    }
    double sum = 0;
    for (int i = 0; i < size; i++) {
      sum += ((Number) elements[i]).doubleValue();
    }
    return sum;
  }

  /**
   * Returns the average of numeric elements.
   *
   * @return the average as double
   */
  public double avg() {
    return sum() / size;
  }

  /**
   * Returns the percentile element (requires numeric elements and comparable).
   *
   * @param percentile a value between 0 and 1
   * @return the element at the given percentile
   * @throws NoSuchElementException if the list has no numeric elements
   */
  public E percentile(double percentile) {
    if (!allNumbers()) {
      throw new NoSuchElementException("Percentile only for numbers!");
    }
    MarsikList<E> copy = duplicate();
    copy.sort();
    int index = (int) Math.round(percentile * (copy.size - 1));
    return copy.get(index);
  }

  /**
   * Returns the element that appears most frequently in the list.
   *
   * @return the most frequent element, or null if the list is empty
   */
  public E mostAppearingElement() {
    HashMap<E, Integer> map = new HashMap<>();
    for (int i = 0; i < size; i++) {
      map.merge(elements[i], 1, Integer::sum);
    }
    E most = null;
    int max = 0;
    for (Map.Entry<E, Integer> entry : map.entrySet()) {
      if (entry.getValue() > max) {
        max = entry.getValue();
        most = entry.getKey();
      }
    }
    return most;
  }

  /**
   * Returns the count of occurrences of the most frequent element.
   *
   * @return the frequency of the most common element
   */
  public int mostAppearingElementCount() {
    HashMap<E, Integer> map = new HashMap<>();
    for (int i = 0; i < size; i++) {
      map.merge(elements[i], 1, Integer::sum);
    }
    int max = 0;
    for (Map.Entry<E, Integer> entry : map.entrySet()) {
      max = Math.max(max, entry.getValue());
    }
    return max;
  }

  /**
   * Returns a random element from the list.
   *
   * @return a random element
   * @throws IllegalStateException if the list is empty
   */
  public E randomElement() {
    if (size == 0) {
      throw new IllegalStateException("Empty list!");
    }
    return elements[(int) (Math.random() * size)];
  }

  /**
   * Generates a new MarsikList of random integers within a specified range.
   *
   * @param smallest the smallest possible integer (inclusive)
   * @param largest the largest possible integer (inclusive)
   * @param numberOfElements the number of elements to generate
   * @return a MarsikList containing the generated random integers
   */
  public MarsikList<Integer> randomIntegerList(int smallest, int largest, int numberOfElements) {
    MarsikList<Integer> list = new MarsikList<>();
    for (int i = 0; i < numberOfElements; i++) {
      list.add(org.example.internals.math.Math.random(smallest, largest));
    }
    return list;
  }

  /**
   * Generates a new MarsikList of random doubles within a specified range.
   *
   * @param smallest the smallest possible double (inclusive)
   * @param largest the largest possible double (inclusive)
   * @param numberOfElements the number of elements to generate
   * @return a MarsikList containing the generated random doubles
   */
  public MarsikList<Double> randomDoubleList(double smallest, double largest,
                                             int numberOfElements) {
    MarsikList<Double> list = new MarsikList<>();
    for (int i = 0; i < numberOfElements; i++) {
      list.add(org.example.internals.math.Math.random(smallest, largest));
    }
    return list;
  }

  /**
   * Prints the list to the console.
   */
  public void print() {
    System.out.print("[");
    for (int i = 0; i < size; i++) {
      System.out.print(elements[i]);
      if (i != size - 1) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }
}
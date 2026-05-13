package org.example.internals.datastructures;

import org.example.internals.Sys;

import java.util.*;

/**
 * A sparse array implementation that allows elements to be "removed" by setting them to null,
 * leaving holes in the array. Supports appending, accessing, and removing elements, as well as
 * pushing elements into free spaces from start or end.
 *
 * @param <E> the type of elements stored in the sparse array
 */
public class MarsikSparseArray<E> {
  private E[] elements;
  private int top = -1;
  private Set<Integer> holeIndexes = new HashSet<>();

  /**
   * Constructs a sparse array and initializes it with the given elements.
   * The internal array is twice the size of the initial elements so the array is full and has no holes.
   *
   * @param elem initial elements to store
   */
  @SafeVarargs
  @SuppressWarnings("unchecked")
  public MarsikSparseArray(E... elem) {
    elements = (E[]) new Object[elem.length * 2];
    System.arraycopy(elem, 0, elements, 0, elem.length);
    top += elem.length;
    for (int i = elem.length; i < elements.length; i++) {
      holeIndexes.add(i);
    }
  }

  /**
   * Constructs an empty sparse array with a default size of 20.
   */
  @SuppressWarnings("unchecked")
  public MarsikSparseArray() {
    elements = (E[]) new Object[20];
    for (int i = 0; i < 20; i++) {
      holeIndexes.add(i);
    }
  }

  /**
   * Constructs an empty sparse array with the specified size.
   *
   * @param size initial capacity of the array
   */
  @SuppressWarnings("unchecked")
  public MarsikSparseArray(int size) {
    elements = (E[]) new Object[size];
    for (int i = 0; i < size; i++) {
      holeIndexes.add(i);
    }
  }

  /**
   * Returns the element at the specified index.
   *
   * @param index the index of the element
   * @return the element at the index
   * @throws IllegalArgumentException if the index is out of bounds
   */
  public E get(int index) {
    checkIndex(index);
    return elements[index];
  }

  /**
   * Removes the element at the given index (sets it to null).
   *
   * @param index the index to remove
   * @throws IllegalArgumentException if the index is invalid
   */
  public void remove(int index) {
    checkIndex(index);
    elements[index] = null;
    holeIndexes.add(index);
  }

  /**
   * Removes the first occurrence of the specified value in the array.
   *
   * @param value the element to remove
   */
  public void remove(E value) {
    int idx = indexOf(value);
    if (idx != -1) {
      elements[idx] = null;
      holeIndexes.add(idx);
    }
  }

  /**
   * Removes the element at the specified index and returns it.
   *
   * @param index the index of the element
   * @return the removed element
   * @throws IllegalArgumentException if the index is invalid
   */
  public E removeAndRetrieve(int index) {
    E element = get(index);
    elements[index] = null;
    holeIndexes.add(index);
    return element;
  }

  /**
   * Removes all occurrences of a given value from the array.
   *
   * @param value the element to remove
   */
  public void removeAll(E value) {
    for (int i = 0; i < length(); i++) {
      if (Objects.equals(elements[i], value)) {
        elements[i] = null;
        holeIndexes.add(i);
      }
    }
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= length()) {
      throw new IllegalArgumentException("Index is out of the Array");
    }
  }

  /**
   * Sets the element at the specified index to a new value.
   *
   * @param index the index to set
   * @param value the new value
   */
  public void set(int index, E value) {
    checkIndex(index);
    if (elements[index] == null) {
      holeIndexes.remove(index);
    }
    elements[index] = value;
  }

  /**
   * Returns the index of the first free spot in the array
   *
   * @return first spot where value is null
   */
  public int nextFreeSpot() {
    return holeIndexes.stream().sorted().mapToInt(Integer::intValue).toArray()[0];
  }

  /**
   * Returns the length of the array (including nulls)
   *
   * @return length of array
   */
  public int length() {
    return elements.length;
  }

  /**
   * Appends new elements to the end of the sparse array.
   *
   * @param elem elements to append
   */
  @SafeVarargs
  public final void append(E... elem) {
    int[] holes = holeIndexes.stream().sorted().mapToInt(Integer::intValue).toArray();
    if (holes.length > elem.length) {
      throw new IllegalArgumentException("Not enough space in the array to append");
    }
    int oldTop = top;
    top += elem.length;
    System.arraycopy(elem, 0, elements, oldTop + 1, elem.length);
  }

  /**
   * Checks if the array contains the specified element.
   *
   * @param value the element to check
   * @return true if the element exists, false otherwise
   */
  public boolean contains(E value) {
    return indexOf(value) != -1;
  }

  /**
   * Finds the last free (null) index in the array.
   *
   * @return last free index or -1 if none
   */
  public int lastFreeIndex() {
    for (int i = length() - 1; i >= 0; i--) {
      if (elements[i] == null) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Places a value into the last free index.
   *
   * @param value element to push
   * @throws IllegalArgumentException if no free slot exists
   */
  public void pushFromEnd(E value) {
    int lastFreeIndex = lastFreeIndex();
    if (lastFreeIndex == -1) {
      throw new IllegalArgumentException("Array is full, bro");
    }
    elements[lastFreeIndex] = value;
  }

  /**
   * Finds the first free (null) index in the array.
   *
   * @return first free index or -1 if none
   */
  public int firstFreeIndex() {
    for (int i = 0; i < elements.length; i++) {
      if (elements[i] == null) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Places a value into the first free index.
   *
   * @param value element to push
   * @throws IllegalArgumentException if no free slot exists
   */
  public void pushFromStart(E value) {
    int firstFreeIndex = firstFreeIndex();
    if (firstFreeIndex == -1) {
      throw new IllegalArgumentException("Array is full, bro");
    }
    elements[firstFreeIndex] = value;
  }

  /**
   * Returns the index of the first occurrence of a value.
   *
   * @param value element to search
   * @return index or -1 if not found
   */
  public int indexOf(E value) {
    for (int i = 0; i < elements.length; i++) {
      if (Objects.equals(elements[i], value)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns the index of the last occurrence of a value.
   *
   * @param value element to search
   * @return index or -1 if not found
   */
  public int lastIndexOf(E value) {
    for (int i = top; i >= 0; i--) {
      if (Objects.equals(elements[i], value)) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Checks if the sparse array has no elements.
   *
   * @return true if empty
   */
  public boolean isEmpty() {
    return top == -1;
  }

  /**
   * Checks if the array has any holes (null elements).
   *
   * @return true if there are holes
   */
  public boolean hasHoles() {
    return !holeIndexes.isEmpty();
  }

  /**
   * Returns the number of holes in the array.
   *
   * @return number of null elements
   */
  public int numberOfHoles() {
    return holeIndexes.size();
  }

  /**
   * Returns a slice of the array as a new MarsikArray from start (inclusive) to end (exclusive).
   *
   * @param start start index
   * @param end end index
   * @return new MarsikArray containing elements in the specified range
   */
  public Object[] slice(int start, int end) {
    if (start > end || start < 0 || end >= elements.length) {
      throw new IllegalArgumentException("Invalid parameters");
    }
    return Arrays.copyOfRange(elements, start, end);
  }

  /**
   * Removes duplicates of the specified element, keeping only the first occurrence.
   *
   * @param elem element to deduplicate
   */
  public void removeDuplicateOf(E elem) {
    boolean found = false;
    int removingDuplicatesFromThere = 0;
    for (int i = 0; i < elements.length; i++) {
      if (elements[i] == elem) {
        found = true;
        removingDuplicatesFromThere = i;
        break;
      }
    }
    if (!found) {
      return;
    }
    for (int j = removingDuplicatesFromThere + 1; j < length(); j++) {
      if (elements[j] != null && elements[j].equals(elem)) {
        elements[j] = null;
      }
    }
  }

  /**
   * Removes all duplicate elements in the sparse array,
   * leaving only the first occurrence of each element.
   */
  public void removeAllDuplicates() {
    HashSet<E> s = new HashSet<>();
    for (int i = 0; i < length(); i++) {
      if (s.contains(elements[i])) {
        elements[i] = null;
      } else {
        s.add(elements[i]);
      }
    }
  }

  /**
   * Returns a duplicate of this sparse array as a MarsikArray.
   *
   * @return a new MarsikArray containing all elements
   */
  public MarsikSparseArray<E> duplicate() {
    E[] elems = elements;
    MarsikSparseArray<E> marsikSparseArray = new MarsikSparseArray<>(elems.length);
    marsikSparseArray.append(elems);
    return marsikSparseArray;
  }

  /**
   * Returns a Set containing the union of this sparse array and another sparse array.
   *
   * @param other another MarsikSparseArray
   * @return a Set containing all unique elements from both arrays
   */
  public MarsikSparseArray<E> unionWith(MarsikSparseArray<E> other) {
    HashSet<E> union = new HashSet<>();
    Collections.addAll(union, elements);
    Collections.addAll(union, other.elements);
    MarsikSparseArray<E> marsikSparseArray = new MarsikSparseArray<>(union.size());
    for (E elem : union) {
      marsikSparseArray.append(elem);
    }
    return marsikSparseArray;
  }

  /**
   * Returns a Set containing the intersection of this sparse array and another sparse array.
   *
   * @param other another MarsikSparseArray
   * @return a Set containing elements present in both arrays
   */
  public Set<E> intersectionWith(MarsikSparseArray<E> other) {
    HashSet<E> hashSet = new HashSet<>(Arrays.asList(elements).subList(0, length()));
    HashSet<E> intersectionElements = new HashSet<>();
    for (int i = 0; i <= other.top; i++) {
      if (hashSet.contains(other.get(i))) {
        intersectionElements.add(other.get(i));
      }
    }
    return intersectionElements;
  }

  /**
   * Sorts the sparse array in natural order.
   * Only works if elements implement Comparable.
   *
   * @throws IllegalStateException if elements are not Comparable
   */
  public void sort() {
    Arrays.sort(elements, 0, length());
  }

  /**
   * Returns the maximum element of the array.
   *
   * @return the maximum Number in the array
   * @throws IllegalArgumentException if not all elements are numbers
   */
  public Number max() {
    if (!allNumbers()) {
      throw new IllegalArgumentException("Elements should be all numbers");
    }
    Number i = (Number) elements[0];
    for (int j = 1; j < length(); j++) {
      Number n = (Number) elements[j];
      if (n instanceof Integer) {
        if (n.intValue() > i.intValue()) {
          i = n;
        }
      }  else if (n instanceof Double) {
        if (n.doubleValue() > i.doubleValue()) {
          i = n;
        }
      }
    }
    return i;
  }

  /**
   * Returns the minimum element of the array.
   *
   * @return the minimum Number in the array
   * @throws IllegalArgumentException if not all elements are numbers
   */
  public Number min() {
    if (!allNumbers()) {
      throw new IllegalArgumentException("Elements should be all numbers");
    }
    Number i = (Number) elements[0];
    for (int j = 1; j < length(); j++) {
      Number n = (Number) elements[j];
      if (n instanceof Integer) {
        if (n.intValue() < i.intValue()) {
          i = n;
        }
      }  else if (n instanceof Double) {
        if (n.doubleValue() < i.doubleValue()) {
          i = n;
        }
      }
    }
    return i;
  }

  /**
   * Checks whether all elements in the sparse array are numbers.
   *
   * @return true if all elements are instances of Number
   */
  public boolean allNumbers() {
    for (int i = 0; i <= top; i++) {
      if (elements[i] == null) {
        continue;
      }
      if (!(elements[i] instanceof Number)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns the sum of all number elements.
   *
   * @return sum of numbers
   * @throws NoSuchElementException if no elements are numbers
   */
  public double sum() {
    if (allNumbers()) {
      double sum = 0;
      for (int i = 0; i < length(); i++) {
        if (elements[i] == null) {
          continue;
        }
        sum += ((Number) elements[i]).doubleValue();
      }
      return sum;
    }
    throw new NoSuchElementException("There are no Numbers in the Array!");
  }

  /**
   * Returns the average of all number elements.
   *
   * @return average value
   */
  public double avg() {
    return sum() / (length() - holeIndexes.size());
  }

  /**
   * Returns the element at the specified percentile.
   *
   * @param percentile percentile between 0 and 1
   * @return the element at the percentile
   * @throws NoSuchElementException if elements are not numbers
   */
  public E percentile(double percentile) {
    MarsikSparseArray<E> array = duplicate();
    array.defragmentationAndTrim();
    array.print();
    if (allNumbers()) {
      array.sort();
      return array.get((int) Math.round(percentile * (array.length() - 1)));
    }
    throw new NoSuchElementException("Percentile is only supported for numbers in the Array!");
  }

  /**
   * Returns the most frequently appearing element.
   *
   * @return the element with the highest frequency
   */
  public E mostAppearingElement() {
    HashMap<E, Integer> map = new HashMap<>();
    for (int i = 0; i < length(); i++) {
      map.merge(elements[i], 1, Integer::sum);
    }
    E mostElement = null;
    int maxCount = 0;
    for (Map.Entry<E, Integer> entry : map.entrySet()) {
      if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
        mostElement = entry.getKey();
      }
    }
    return mostElement;
  }

  /**
   * Returns the count of the most frequently appearing element.
   *
   * @return frequency of the most common element
   */
  public int mostAppearingElementCount() {
    HashMap<E, Integer> map = new HashMap<>();
    for (int i = 0; i < length(); i++) {
      map.merge(elements[i], 1, Integer::sum);
    }
    int maxCount = 0;
    for (Map.Entry<E, Integer> entry : map.entrySet()) {
      if (entry.getValue() > maxCount) {
        maxCount = entry.getValue();
      }
    }
    return maxCount;
  }

  /**
   * Returns a random element from the array.
   *
   * @return a random element
   */
  public E randomElement() {
    return get(org.example.internals.math.Math.random(0,  length() - 1));
  }

  /**
   * Returns a random element from a specific range of indices.
   *
   * @param start start index (inclusive)
   * @param end end index (inclusive)
   * @return a random element in the range
   * @throws IndexOutOfBoundsException if indices are invalid
   */
  public E randomElementFromRange(int start, int end) {
    if (start > end || end > length() || start < 0) {
      throw new IndexOutOfBoundsException("Index out of bounds!");
    }
    return get(org.example.internals.math.Math.random(start, end));
  }

  /**
   * Defragments the array by removing holes (null elements) and shifting elements.
   */
  public void defragmentation() {
    int nextFree = 0;
    for (int i = 0; i <= length(); i++) {
      E el = elements[i];
      if (el != null) {
        if (nextFree != i) {
          elements[nextFree] = el;
        }
        nextFree++;
      }
    }
    Arrays.fill(elements, nextFree, top + 1, null);
  }

  /**
   * Defragments the array by removing holes (null elements) and shifting elements, before
   * trimming the array so that all nulls gets erased.
   */
  @SuppressWarnings("unchecked")
  public void defragmentationAndTrim() {
    Object[] elements = new Object[length() - holeIndexes.size()];
    int nextFree = 0;
    for (int i = 0; i <= length(); i++) {
      E el = (E) elements[i];
      if (el != null) {
        if (nextFree != i) {
          elements[nextFree] = el;
        }
        nextFree++;
      }
    }
    this.elements = (E[]) elements;
  }

  /**
   * Clears all elements in the sparse array.
   */
  public void clear() {
    Arrays.fill(elements, null);
    top = -1;
    holeIndexes.clear();
  }

  /**
   * Destroys the sparse array, removing all elements and references.
   */
  public void destroy() {
    elements = null;
    top = -1;
    holeIndexes = null;
  }

  /**
   * Prints the sparse array to the console with indices.
   */
  public void print() {
    for (int i = 0; i < length(); i++) {
      System.out.println("Array[" + i + "]" + " : " + elements[i]);
    }
  }
}
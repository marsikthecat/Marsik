package org.example.internals.datastructures;

import java.util.*;

public class MarsikArray<E> {

  private final E[] elements;
  private final int size;

  @SafeVarargs @SuppressWarnings("unchecked")
  public MarsikArray(E... elem) {
    elements = (E[]) new Object[elem.length];
    System.arraycopy(elem, 0, elements, 0, elem.length);
    size = elem.length;
  }

  public E get(int index) {
    checkIndex(index);
    return elements[index];
  }

  public void set(int index, E value) {
    checkIndex(index);
    elements[index] = value;
  }

  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Index is out of the Array");
    }
  }

  public int size() {
    return size;
  }


  public boolean contains(E value) {
    return indexOf(value) != -1;
  }


  public int indexOf(E value) {
    for (int i = 0; i < size; i++) {
      if (Objects.equals(elements[i], value)) {
        return i;
      }
    }
    return -1;
  }

  public E getRandomElement() {
    return elements[(int)(Math.random() * size)];
  }

  public MarsikArray<E> slice(int start, int end) {
    if (start > end || start < 0 || end >= size) {
      throw new IllegalArgumentException("Invalid parameters");
    }
    return new MarsikArray<>(Arrays.copyOfRange(elements, start, end));
  }

  @SuppressWarnings("unchecked")
  public MarsikArray<E> removeDuplicateOf(E elem) {
    ArrayList<E> list = new ArrayList<>(Arrays.asList(elements));
    boolean found = false;
    for (int j = 0; j < size; j++) {
      E e = elements[j];
      if (!e.equals(elem) || (e.equals(elem) && !found)) {
        list.add(e);
        if (e.equals(elem)) found = true;
      }
    }
    return new MarsikArray<>((E[]) list.toArray());
  }

  @SuppressWarnings("unchecked")
  public MarsikArray<E> withoutDuplicates() {
    HashSet<E> s = new HashSet<>();
    Collections.addAll(s, elements);
    return new MarsikArray<>((E[]) s.toArray());
  }

  public MarsikArray<E> duplicate() {
    return new MarsikArray<>(Arrays.copyOf(elements, size + 1));
  }

  public Set<E> unionWith(MarsikArray<E> other) {
    HashSet<E> hashSet = new HashSet<>(Arrays.asList(elements).subList(0, size));
    for (int i = 0; i < other.size(); i++) {
      hashSet.add(other.get(i));
    }
    return hashSet;
  }

  public Set<E> intersectionWith(MarsikArray<E> other) {
    HashSet<E> hashSet = new HashSet<>(Arrays.asList(elements).subList(0, size));
    HashSet<E> intersectionElements = new HashSet<>();
    for (int i = 0; i < other.size(); i++) {
      if (hashSet.contains(other.get(i))) {
        intersectionElements.add(other.get(i));
      }
      hashSet.add(other.get(i));
    }
    return intersectionElements;
  }

  public void sort() {
    if (elements.length > 0 && !(elements[0] instanceof Comparable)) {
      throw new IllegalStateException("Elements are not comparable, my friend!");
    }
    Arrays.sort(elements, 0, size);
  }

  public Number max() {
    if (!allNumbers()) {
      throw new IllegalArgumentException("Elements should be all numbers");
    }
    Number i = (Number) elements[0];
    for (E e : elements) {
      if (e instanceof Comparable<?>) {
        if (((Comparable<Number>) e).compareTo(i) > 0) {
          i = (Number) e;
        }
      }
    }
    return i;
  }

  public Number min() {
    if (!allNumbers()) {
      throw new IllegalArgumentException("Elements should be all numbers");
    }
    Number i = (Number) elements[0];
    for (E e : elements) {
      if (e instanceof Comparable<?>) {
        if (((Comparable<Number>) e).compareTo(i) < 0) {
          i = (Number) e;
        }
      }
    }
    return i;
  }

  public boolean allNumbers() {
    for (int i = 0; i < size; i++) {
      if (!(elements[i] instanceof Number)) {
        return false;
      }
    }
    return true;
  }

  public double sum() {
    if (allNumbers()) {
      double sum = 0;
      for (E element : elements) {
        sum += ((Number) element).doubleValue();
      }
      return sum;
    }
    throw new NoSuchElementException("There are no Numbers in the Array!");
  }

  public double avg() {
    return sum() / size;
  }

  public E percentile(double percentile) {
    if (allNumbers()) {
      MarsikArray<E> array = new MarsikArray<>(elements);
      array.sort();
      return array.get((int) Math.round(percentile * (size - 1)));
    }
    throw new NoSuchElementException("Percentile is only supported for numbers in the Array!");
  }

  public E mostAppearingElement() {
    HashMap<E, Integer> map = new HashMap<>();
    for (int i = 0; i < size; i++) {
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

  public int mostAppearingElementCount() {
    HashMap<E, Integer> map = new HashMap<>();
    for (int i = 0; i < size; i++) {
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

  public static MarsikArray<Integer> randomIntegerArray(int smallest, int largest, int numberOfElements) {
    MarsikArray<Integer> marsikArray = new MarsikArray<>(numberOfElements);
    for (int i = 0; i < numberOfElements; i++) {
      marsikArray.set(i, org.example.internals.math.Math.random(smallest, largest));
    }
    return marsikArray;
  }

  public static MarsikArray<Double> randomDoubleArray(double smallest, double largest, int numberOfElements) {
    MarsikArray<Double> marsikArray = new MarsikArray<>();
    for (int i = 0; i < numberOfElements; i++) {
      marsikArray.set(i, org.example.internals.math.Math.random(smallest, largest));
    }
    return marsikArray;
  }

  public void print() {
    for (int i = 0; i < size + 1; i++) {
      System.out.println("Array[" + i + "]" + " : " + elements[i]);
    }
  }
}
package org.example.internals.datastructures;

import java.util.*;

public class MarsikList<E> {

  private E[] elements;
  private int size = 0;

  @SuppressWarnings("unchecked")
  public MarsikList() {
    elements = (E[]) new Object[10];
  }

  @SafeVarargs
  @SuppressWarnings("unchecked")
  public MarsikList(E... elem) {
    elements = (E[]) new Object[Math.max(10, elem.length)];
    System.arraycopy(elem, 0, elements, 0, elem.length);
    size = elem.length;
  }

  public int size() {
    return size;
  }

  private void ensureCapacity(int minCapacity) {
    if (minCapacity > elements.length) {
      elements = Arrays.copyOf(elements, Math.max(elements.length * 2, minCapacity));
    }
  }

  public void add(E value) {
    ensureCapacity(size + 1);
    elements[size++] = value;
  }

  public void add(int index, E value) {
    if (index < 0 || index > size) throw new IndexOutOfBoundsException();
    ensureCapacity(size + 1);
    System.arraycopy(elements, index, elements, index + 1, size - index);
    elements[index] = value;
    size++;
  }

  public E get(int index) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    return elements[index];
  }

  public void set(int index, E value) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    elements[index] = value;
  }

  public E remove(int index) {
    if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    E removed = elements[index];
    System.arraycopy(elements, index + 1, elements, index, size - index - 1);
    elements[--size] = null;
    return removed;
  }

  public void removeAll(E value) {
    for (int i = size - 1; i >= 0; i--) {
      if (Objects.equals(elements[i], value)) remove(i);
    }
  }

  public boolean remove(E value) {
    int idx = indexOf(value);
    if (idx != -1) {
      remove(idx);
      return true;
    }
    return false;
  }

  public int indexOf(E value) {
    for (int i = 0; i < size; i++) {
      if (Objects.equals(elements[i], value)) return i;
    }
    return -1;
  }

  public int lastIndexOf(E value) {
    for (int i = size - 1; i >= 0; i--) {
      if (Objects.equals(elements[i], value)) return i;
    }
    return -1;
  }

  public boolean contains(E value) {
    return indexOf(value) != -1;
  }

  public void clear() {
    Arrays.fill(elements, 0, size, null);
    size = 0;
  }

  public void removeDuplicateOf(E elem) {
    boolean found = false;
    int idx = 0;
    for (int i = 0; i < size; i++) {
      E e = elements[i];
      if (!Objects.equals(e, elem) || (Objects.equals(e, elem) && !found)) {
        elements[idx++] = e;
        if (Objects.equals(e, elem)) found = true;
      }
    }
    for (int i = idx; i < size; i++) elements[i] = null;
    size = idx;
  }

  @SuppressWarnings("unchecked")
  public MarsikList<E> withoutDuplicates() {
    HashSet<E> set = new HashSet<>(Arrays.asList(elements).subList(0, size));
    return new MarsikList<>((E[]) set.toArray());
  }

  public MarsikList<E> duplicate() {
    return new MarsikList<>(Arrays.copyOf(elements, size));
  }

  public void sort() {
    if (size > 0 && !(elements[0] instanceof Comparable)) {
      throw new IllegalStateException("Elements are not comparable!");
    }
    Arrays.sort(elements, 0, size);
  }

  public boolean allNumbers() {
    for (int i = 0; i < size; i++) {
      if (!(elements[i] instanceof Number)) return true;
    }
    return false;
  }

  public double sum() {
    if (allNumbers()) throw new NoSuchElementException("No numbers!");
    double sum = 0;
    for (int i = 0; i < size; i++) sum += ((Number) elements[i]).doubleValue();
    return sum;
  }

  public double avg() {
    return sum() / size;
  }

  public E percentile(double percentile) {
    if (allNumbers()) throw new NoSuchElementException("Percentile only for numbers!");
    MarsikList<E> copy = duplicate();
    copy.sort();
    int index = (int) Math.round(percentile * (copy.size - 1));
    return copy.get(index);
  }

  public E mostAppearingElement() {
    HashMap<E, Integer> map = new HashMap<>();
    for (int i = 0; i < size; i++) map.merge(elements[i], 1, Integer::sum);
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

  public int mostAppearingElementCount() {
    HashMap<E, Integer> map = new HashMap<>();
    for (int i = 0; i < size; i++) map.merge(elements[i], 1, Integer::sum);
    int max = 0;
    for (Map.Entry<E, Integer> entry : map.entrySet()) max = Math.max(max, entry.getValue());
    return max;
  }

  public E randomElement() {
    if (size == 0) throw new IllegalStateException("Empty list!");
    return elements[(int) (Math.random() * size)];
  }

  public MarsikList<Integer> randomIntegerList(int smallest, int largest, int numberOfElements) {
    MarsikList<Integer> list = new MarsikList<>();
    for (int i = 0; i < numberOfElements; i++)
      list.add(org.example.internals.math.Math.random(smallest, largest));
    return list;
  }

  public MarsikList<Double> randomDoubleList(double smallest, double largest, int numberOfElements) {
    MarsikList<Double> list = new MarsikList<>();
    for (int i = 0; i < numberOfElements; i++)
      list.add(org.example.internals.math.Math.random(smallest, largest));
    return list;
  }

  public void print() {
    System.out.print("[");
    for (int i = 0; i < size; i++) {
      System.out.print(elements[i]);
      if (i != size - 1) System.out.print(", ");
    }
    System.out.println("]");
  }
}
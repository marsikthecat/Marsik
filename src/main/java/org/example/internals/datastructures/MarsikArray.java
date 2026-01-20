package org.example.internals.datastructures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class MarsikArray<E> {

  private E[] elements;
  private int top = -1;
  private int holeCount = 0;

  @SafeVarargs
  public MarsikArray(E... elem) {
    elements = Arrays.copyOf(elem, elem.length);
    top += elem.length;
  }

  public E get(int index) {
    checkIndex(index);
    return elements[index];
  }

  public void remove(int index) {
    checkIndex(index);
    elements[index] = null;
    holeCount++;
  }

  public void remove(E value) {
    int idx = indexOf(value);
    if (idx != -1) {
      elements[idx] = null;
      holeCount++;
    }
  }

  public E removeAndRetrieve(int index) {
    E element = get(index);
    elements[index] = null;
    holeCount++;
    return element;
  }

  public void removeAll(E value) {
    for (int i = 0; i < elements.length; i++) {
      if (Objects.equals(elements[i], value)) {
        elements[i] = null;
        holeCount++;
      }
    }
  }

  private void checkIndex(int index) {
    if (index < 0 || index > top) {
      throw new IllegalArgumentException("Index is out of the Array");
    }
  }

  public void set(int index, E value) {
    checkIndex(index);
    elements[index] = value;
  }

  public int length() {
    return top + 1;
  }

  public E pop() {
    if (top < 0) {
      throw new IllegalStateException("Array is empty");
    }
    return elements[top--];
  }

  public void push(E value) {
    if (top >= elements.length - 1) {
      throw new IndexOutOfBoundsException("Array is full, my friend!");
    }
    elements[++top] = value;
  }

  public E peek() {
    if (top < 0) {
      throw new IllegalStateException("Array is empty");
    }
    return elements[top];
  }

  @SafeVarargs
  public final void append(E... elem) {
    int oldTop = top;
    top += elem.length;
    elements = Arrays.copyOf(elements, top + 1);
    System.arraycopy(elem, 0, elements, oldTop + 1, elem.length);
  }

  public boolean contains(E value) {
    return indexOf(value) != -1;
  }

  public int lastFreeIndex() {
    for (int i = top; i >= 0 ; i--) {
      if (elements[i] == null) {
        return i;
      }
    }
    return -1;
  }

  public void pushFromEnd(E value) {
    int lastFreeIndex = lastFreeIndex();
    if (lastFreeIndex == -1) {
      throw new IllegalArgumentException("Array is full, bro");
    }
    elements[lastFreeIndex] = value;
  }

  public int firstFreeIndex() {
    for (int i = 0; i <= top ; i++) {
      if (elements[i] == null) {
        return i;
      }
    }
    return -1;
  }

  public void pushFromStart(E value) {
    int firstFreeIndex = firstFreeIndex();
    if (firstFreeIndex == -1) {
      throw new IllegalArgumentException("Array is full, bro");
    }
    elements[firstFreeIndex] = value;
  }

  public int indexOf(E value) {
    for (int i = 0; i <= top; i++) {
      if (Objects.equals(elements[i], value)) {
        return i;
      }
    }
    return -1;
  }

  public int lastIndexOf(E value) {
    for (int i = top; i >= 0; i--) {
      if (Objects.equals(elements[i], value)) {
        return i;
      }
    }
    return -1;
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public boolean hasHoles() {
    return holeCount > 0;
  }

  public int numberOfHoles() {
    return holeCount;
  }

  public MarsikArray<E> slice(int start, int end) {
    if (start > end || start < 0 || end > top) {
      throw new IllegalArgumentException("Invalid parameters");
    }
    return new MarsikArray<>(Arrays.copyOfRange(elements, start, end + 1));
  }

  public void removeDuplicateOf(E elem) {
    int idx = 0;
    boolean found = false;
    for (int j = 0; j < length(); j++) {
      E e = elements[j];
      if (!e.equals(elem) || (e.equals(elem) && !found)) {
        elements[idx++] = e;
        if (e.equals(elem)) found = true;
      }
    }
    Arrays.fill(elements, idx, length(), null);
  }

  public void removeAllDuplicates() {
    HashSet<E> s = new HashSet<>();
    int idx = 0;
    for (int i = 0; i < elements.length; i++) {
      if (!s.contains(elements[i])) {
        s.add(elements[i]);
        elements[idx++] = elements[i];
      }
    }
    Arrays.fill(elements, idx, length(), null);
  }

  public MarsikArray<E> duplicate() {
    return new MarsikArray<>(Arrays.copyOf(elements, top + 1));
  }

  public Set<E> unionWith(MarsikArray<E> other) {
    HashSet<E> hashSet = new HashSet<>(Arrays.asList(elements).subList(0, length()));
    for (int i = 0; i < other.length(); i++) {
      hashSet.add(other.get(i));
    }
    return hashSet;
  }

  public Set<E> intersectionWith(MarsikArray<E> other) {
    HashSet<E> hashSet = new HashSet<>(Arrays.asList(elements).subList(0, length()));
    HashSet<E> intersectionElements = new HashSet<>();
    for (int i = 0; i < other.length(); i++) {
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
    defragmentation();
    Arrays.sort(elements);
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
    for (E e : elements) {
      if (!(e instanceof Number)) return false;
    }
    return true;
  }

  public double sum() {
    if (holeCount > 0) {
      defragmentation();
    }
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
    return sum() / elements.length;
  }

  public void defragmentation() {
    int nextFree = 0;
    for (int i = 0; i <= top; i++) {
      E el = elements[i];
      if (el != null) {
        if (nextFree != i) elements[nextFree] = el;
        nextFree++;
      }
    }
    Arrays.fill(elements, nextFree, top + 1, null);
    top = nextFree - 1;
    holeCount = 0;
    elements = Arrays.copyOf(elements, nextFree);
  }

  public void clear() {
    Arrays.fill(elements, null);
    top = -1;
    holeCount = 0;
  }

  public void destroy() {
    elements = null;
    top = -1;
    holeCount = 0;
  }

  public void print() {
    for (int i = 0; i < top + 1; i++) {
      System.out.println("Array[" + i + "]" + " : " + elements[i]);
    }
  }
}
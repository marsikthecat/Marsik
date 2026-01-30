package org.example.internals.datastructures;

import java.util.HashMap;
import java.util.Set;

/**
 * A lightweight generic Set implementation backed by a {@link HashMap}.
 * The associated values are dummy placeholders and have no semantic meaning.
 * This implementation does not preserve insertion order.
 */

public class MarsikSet<E> {

  private final HashMap<E, Byte> map;

  /**
   * Constructs an empty {@code MarsikSet} with default initial capacity.
   */
  public MarsikSet() {
    map = new HashMap<>();
  }

  /**
   * Constructs a new {@code MarsikSet} containing all elements
   * from the given set.
   *
   * @param set the set whose elements are to be copied
   * @throws NullPointerException if the provided set is {@code null}
   */
  public MarsikSet(MarsikSet<E> set) {
    map = new HashMap<>(set.map);
  }

  /**
   * Constructs a new {@code MarsikSet} containing all elements
   * from the given JavaSet.
   *
   * @param set the set whose elements are to be copied
   * @throws NullPointerException if the provided set is {@code null}
   */
  public MarsikSet(Set<E> set) {
    map = new HashMap<>(set.size());
    for (E e : set) {
      add(e);
    }
  }

  /**
   * Constructs an empty {@code MarsikSet} with the specified initial capacity.
   *
   * @param capacity the initial capacity of the backing {@link HashMap}
   * @throws IllegalArgumentException if the capacity is negative
   */
  public MarsikSet(int capacity) {
    map = new HashMap<>(capacity);
  }

  /**
   * Returns the number of elements in this set.
   *
   * @return the number of elements stored in the set
   */
  public int size() {
    return map.size();
  }

  /**
   * Checks whether this set contains no elements.
   *
   * @return {@code true} if the set is empty, {@code false} otherwise
   */
  public boolean isEmpty() {
    return map.isEmpty();
  }

  /**
   * Checks whether the specified element exists in this set.
   *
   * @param o the element whose presence is to be tested
   * @return {@code true} if the element is contained in the set,
   *         {@code false} otherwise
   */
  public boolean contains(E o) {
    return map.containsKey(o);
  }

  /**
   * Adds the specified element to this set.
   * If the element already exists, the set remains unchanged.
   *
   * @param o the element to be added
   */
  public void add(E o) {
    Byte fillObject = 0;
    map.put(o, fillObject);
  }

  /**
   * Removes the specified element from this set if it exists.
   *
   * @param o the element to be removed
   */
  public void remove(E o) {
    map.remove(o);
  }

  /**
   * Removes all elements from this set.
   */
  public void clear() {
    map.clear();
  }

  /**
   * Creates and returns a shallow copy of this set.
   *
   * @return a new {@code MarsikSet} containing the same elements
   */
  public MarsikSet<E> copy() {
    return new MarsikSet<>(this);
  }
}
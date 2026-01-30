package org.example.internals.datastructures.extendedarrays;

import java.util.Arrays;
import org.example.internals.datastructures.ArrayUtils;
import org.example.internals.datastructures.MarsikList;

/**
 * A Splay-like array that moves frequently accessed elements toward the front.
 * This class extends {@link ArrayUtils} and tracks how often each element
 * is accessed (via {@link #get}, {@link #set}, or {@link #indexOf}).
 * When the total access count reaches a threshold, the array is partially
 * rearranged so that more frequently accessed elements are closer to the front,
 * improving access performance for hot elements.
 *
 * @param <E> the type of elements stored, must implement {@link Comparable}
 */
public class MarsikSplayArray<E extends Comparable<E>> extends MarsikList<E> {

  private final int[] visited;

  /**
   * Constructs a new MarsikSplayArray containing the given elements.
   *
   * @param elem the elements to initialize the array with
   */
  @SafeVarargs
  public MarsikSplayArray(E... elem) {
    super(elem);
    visited = new int[elem.length];
    Arrays.fill(visited, 0);
  }

  /**
   * Returns the index of the given value in the array.
   * Also increments the access counter for the element and triggers a rearrangement
   * if the total accesses reach the rearrangement threshold.
   *
   * @param value the element to search for
   * @return the index of the element, or -1 if not found
   */
  @Override
  public int indexOf(E value) {
    int idx = super.indexOf(value);
    updateVisited(idx);
    return idx;
  }

  /**
   * Returns the element at the given index.
   * Updates the access counter and may trigger a rearrangement.
   *
   * @param idx the index to retrieve
   * @return the element at the specified index
   */
  @Override
  public E get(int idx) {
    updateVisited(idx);
    return super.get(idx);
  }

  /**
   * Sets the element at the given index.
   * Updates the access counter and may trigger a rearrangement.
   *
   * @param idx   the index to update
   * @param value the new value to store
   */
  @Override
  public void set(int idx, E value) {
    updateVisited(idx);
    super.set(idx, value);
  }

  /**
   * Returns {@code true} if the array contains the given element.
   *
   * @param value the element to check for
   * @return true if the array contains the element
   */
  @Override
  public boolean contains(E value) {
    return indexOf(value) != -1;
  }

  /**
   * Updates the visited count for the element at the given index.
   * If the total accesses reach a threshold (half the array size), the array is
   * rearranged so that more frequently accessed elements move toward the front.
   *
   * @param idxOfElem the index of the element to update
   */
  private void updateVisited(int idxOfElem) {
    if (idxOfElem != -1) {
      int visitedCount = visited[idxOfElem];
      visited[idxOfElem] = ++visitedCount;
    }
    if (Arrays.stream(visited).sum() % (size() / 2) == 0) {
      rearrange();
    }
  }

  /**
   * Rearranges the array elements based on their access counts.
   * Elements with higher access counts are moved toward the front, while
   * less frequently accessed elements move toward the back.
   */
  @SuppressWarnings("unchecked")
  private void rearrange() {
    Object[][] pairs = new Object[size()][2];
    for (int i = 0; i < size(); i++) {
      pairs[i][0] = get(i);
      pairs[i][1] = visited[i];
    }
    Arrays.sort(pairs, (a, b) -> Integer.compare((int) b[1], (int) a[1]));
    for (int i = 0; i < pairs.length; i++) {
      set(i, (E) pairs[i][0]);
      visited[i] = (int) pairs[i][1];
    }
  }
}
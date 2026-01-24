package org.example.internals.datastructures.extendedArrays;

import org.example.internals.datastructures.MarsikArray;
import java.util.Arrays;

public class MarsikSplayArray<E extends Comparable<E>> extends MarsikArray<E> {

  private final int[] visited;

  @SafeVarargs
  public MarsikSplayArray(E... elem) {
    super(elem);
    visited = new int[elem.length];
    Arrays.fill(visited, 0);
  }

  @Override
  public int indexOf(E value) {
    int idx = super.indexOf(value);
    updateVisited(idx);
    return idx;
  }

  @Override
  public E get(int idx) {
    updateVisited(idx);
    return super.get(idx);
  }

  @Override
  public void set(int idx, E value) {
    updateVisited(idx);
    super.set(idx, value);
  }

  @Override
  public boolean contains(E value) {
    return indexOf(value) != -1;
  }

  private void updateVisited(int idxOfElem) {
    if (idxOfElem != -1) {
      int visitedCount = visited[idxOfElem];
      visited[idxOfElem] = ++visitedCount;
    }
    if (Arrays.stream(visited).sum() % (size() / 2) == 0) {
      rearrange();
    }
  }

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
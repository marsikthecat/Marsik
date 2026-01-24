package org.example.internals.datastructures;

import java.util.HashMap;

public class MarsikSet<E> {

  private final HashMap<E, Byte> map;

  public MarsikSet() {
    map = new HashMap<>();
  }

  public MarsikSet(MarsikSet<E> set) {
    map = new HashMap<>(set.map);
  }

  public MarsikSet(int capacity) {
    map = new HashMap<>(capacity);
  }

  public int size() {
    return map.size();
  }

  public boolean isEmpty() {
    return map.isEmpty();
  }

  public boolean contains(E o) {
    return map.containsKey(o);
  }

  public void add(E o) {
    Byte fillObject = (byte) 0;
    map.put(o, fillObject);
  }

  public void remove(E o) {
    map.remove(o);
  }

  public void clear() {
    map.clear();
  }

  public MarsikSet<E> copy() {
    return new MarsikSet<>(this);
  }
}
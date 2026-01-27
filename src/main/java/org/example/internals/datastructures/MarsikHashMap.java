package org.example.internals.datastructures;

import java.util.*;

public class MarsikHashMap<K, V> extends HashMap<K, V> {

  //TODO: add some extra spice

  public MarsikHashMap(int initialCapacity, float loadFactor) {
    super(initialCapacity, loadFactor);
  }

  public MarsikHashMap(int initialCapacity) {
    super(initialCapacity);
  }

  public MarsikHashMap() {
    super();
  }

  @Override
  public int size() {
    return super.size();
  }

  @Override
  public boolean isEmpty() {
    return super.isEmpty();
  }

  @Override
  public V get(Object key) {
    return super.get(key);
  }

  @Override
  public boolean containsKey(Object key) {
    return super.containsKey(key);
  }

  @Override
  public V put(K key, V value) {
    return super.put(key, value);
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> m) {
    super.putAll(m);
  }

  @Override
  public V remove(Object key) {
    return super.remove(key);
  }

  @Override
  public void clear() {
    super.clear();
  }

  @Override
  public boolean containsValue(Object value) {
    return super.containsValue(value);
  }

  @Override
  public Set<K> keySet() {
    return super.keySet();
  }

  @Override
  public Collection<V> values() {
    return super.values();
  }

  @Override
  public Set<Entry<K, V>> entrySet() {
    return super.entrySet();
  }
}
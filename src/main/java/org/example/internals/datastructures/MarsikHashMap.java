package org.example.internals.datastructures;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * A custom {@link HashMap} implementation used in the Marsik runtime.
 * This class currently acts as a thin wrapper around {@link HashMap},
 * but provides convenience methods that return Marsik-specific
 * collection types such as {@link MarsikList} and {@link MarsikSet}.
 * Intended as a future extension point for a custom runtime-compatible
 * map implementation.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class MarsikHashMap<K, V> extends HashMap<K, V> {

  /**
   * Constructs an empty {@code MarsikHashMap} with the specified initial
   * capacity and load factor.
   *
   * @param initialCapacity the initial capacity
   * @param loadFactor the load factor (will be cast to {@code float})
   */
  public MarsikHashMap(int initialCapacity, double loadFactor) {
    super(initialCapacity, (float) loadFactor);
  }

  /**
   * Constructs an empty {@code MarsikHashMap} with the specified initial capacity
   * and the default load factor.
   *
   * @param initialCapacity the initial capacity
   */
  public MarsikHashMap(int initialCapacity) {
    super(initialCapacity);
  }

  /**
   * Constructs an empty {@code MarsikHashMap} with default capacity
   * and load factor.
   */
  public MarsikHashMap() {
    super();
  }

  /**
   * Returns the number of key-value mappings in this map.
   *
   * @return the number of entries in this map
   */
  @Override
  public int size() {
    return super.size();
  }

  /**
   * Returns {@code true} if this map contains no key-value mappings.
   *
   * @return {@code true} if this map is empty, otherwise {@code false}
   */
  @Override
  public boolean isEmpty() {
    return super.isEmpty();
  }

  /**
   * Returns the value to which the specified key is mapped,
   * or {@code null} if this map contains no mapping for the key.
   *
   * @param key the key whose associated value is to be returned
   * @return the value associated with the key, or {@code null}
   */
  @Override
  public V get(Object key) {
    return super.get(key);
  }

  /**
   * Returns {@code true} if this map contains a mapping for the specified key.
   *
   * @param key the key whose presence in this map is to be tested
   * @return {@code true} if this map contains the key
   */
  @Override
  public boolean containsKey(Object key) {
    return super.containsKey(key);
  }

  /**
   * Associates the specified value with the specified key in this map.
   *
   * @param key the key with which the specified value is to be associated
   * @param value the value to be associated with the key
   * @return the previous value associated with the key, or {@code null}
   */
  @Override
  public V put(K key, V value) {
    return super.put(key, value);
  }

  /**
   * Removes the mapping for the specified key from this map if present.
   *
   * @param key the key whose mapping is to be removed
   * @return the previous value associated with the key, or {@code null}
   */
  @Override
  public V remove(Object key) {
    return super.remove(key);
  }

  /**
   * Removes all mappings from this map.
   */
  @Override
  public void clear() {
    super.clear();
  }

  /**
   * Returns {@code true} if this map maps one or more keys to the specified value.
   *
   * @param value value whose presence in this map is to be tested
   * @return {@code true} if this map contains the value
   */
  @Override
  public boolean containsValue(Object value) {
    return super.containsValue(value);
  }

  /**
   * Returns all keys of this map as a {@link MarsikSet}.
   *
   * @return a {@code MarsikSet} containing all keys
   */
  public MarsikSet<K> keyList() {
    return new MarsikSet<>(super.keySet());
  }

  /**
   * Returns all values of this map as a {@link MarsikList}.
   *
   * @return a {@code MarsikList} containing all values
   */
  public MarsikList<V> valueList() {
    Collection<V> values = super.values();
    MarsikList<V> marsikList = new MarsikList<>();
    for (V value : values) {
      marsikList.add(value);
    }
    return marsikList;
  }

  /**
   * Returns all entries of this map as a {@link MarsikList} of {@code Object[]}.
   * Each array contains exactly two elements:
   * <ul>
   *   <li>index 0: the key</li>
   *   <li>index 1: the value</li>
   * </ul>
   *
   * @return a {@code MarsikList} containing key-value pairs as {@code Object[]}
   */
  public MarsikList<Object[]> entryList() {
    MarsikList<Object[]> marsikList = new MarsikList<>();
    Set<Entry<K, V>> entrySet = super.entrySet();
    for (Entry<K, V> entry : entrySet) {
      marsikList.add(new Object[]{entry.getKey(), entry.getValue()});
    }
    return marsikList;
  }
}

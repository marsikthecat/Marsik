package org.example.internals.datastructures;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * == SuperHashMap vs. java Hashmap ==
 * (Note: This benchmark was done before this project without Runtime extra stuff!)
 * Setup: Java destroys me apocalyptically (cuz I need to check if hashes for keys are unique)
 * Performance of Set and Get methods: Java gets destroyed
 * Performance of Getter for key-set and values: Java gets destroyed apocalyptically.
 * Performance of Remove: Java gets destroyed.
 * Storage for 50 keys: Java got 2.8kb data, mine got 2.1kb data,
 * even if my Object[] array can be over 10 time bigger than key size, cuz java has big overhead,
 * so Java gets destroyed.
 * Collision: Mine is collision free, java's is not, I destroy java apocalyptically.
 * Example Benchmark results for 50 keys and 5 Runs:
 * Java HashMap setup : 0.0467 ms
 * SuperHashMap setup : 18.1265 ms (400 times slower :(, but only once)
 * Java HashMap set() average : 30.949 ms
 * SuperHashMap set() average: 27.761 ms
 * Java HashMap get() average: 12.087 ms
 * SuperHashMap get() average: 8.602 ms
 * Java HashMap remove() average: 22.133 ms
 * SuperHashMap remove() average: 11.356 ms
 * Java HashMap getKeySet() average: 0.00334 ms
 * SuperHashMap getKeySet() average: 0.00008 ms
 * Java HashMap getValues() average: 0.00390 ms
 * SuperHashMap getValues() average: 0.00010 ms
 */

public class MarsikPerfectHashMap<E> {

  private final Set<Object> keySet = new HashSet<>();
  private E[] values;
  private int growFactor = 1;
  private final int initialSize;

  /**
   * Constructs a {@code MarsikPerfectHashMap} with the specified initial size.
   *
   * @param size initial size for the internal storage
   */
  @SuppressWarnings("unchecked")
  public MarsikPerfectHashMap(int size) {
    initialSize = size;
    values = (E[]) new Object[size];
  }

  /**
   * Constructs a {@code MarsikPerfectHashMap} with a default initial size of 20.
   */
  @SuppressWarnings("unchecked")
  public MarsikPerfectHashMap() {
    initialSize = 20;
    values = (E[]) new Object[initialSize];
  }

  /**
   * Defines the set of keys that this map will use.
   * The method attempts to create a perfect hash by adjusting the internal array size.
   *
   * @param keys the keys to define
   * @throws UnsupportedOperationException if a perfect hash cannot be created
   */
  @SuppressWarnings("unchecked")
  public void defineKeys(String... keys) {
    boolean mapperResult;
    do {
      mapperResult = hash(keys);
      growFactor++;
      values = (E[]) new Object[initialSize * growFactor];
      System.out.print("Trying growFactor " + growFactor);
      if (growFactor > 64) {
        throw new UnsupportedOperationException("Cannot make perfect hashing out of these keys");
      } else {
        keySet.addAll(List.of(keys));
      }
    } while (!mapperResult);
  }

  /**
   * Returns the value associated with the specified key.
   *
   * @param key the key to retrieve
   * @return the value associated with the key, or null if not set
   */
  public E get(String key) {
    return values[hash(key)];
  }

  /**
   * Sets the value for the specified key.
   *
   * @param key the key to associate with the value
   * @param value the value to store
   */
  public void set(String key, E value) {
    values[hash(key)] = value;
  }

  /**
   * Removes the key and its associated value from the map.
   *
   * @param key the key to remove
   * @return the removed value, or null if not present
   */
  public E remove(String key) {
    keySet.remove(key);
    int idx = hash(key);
    E o = values[idx];
    values[idx] = null;
    return o;
  }

  /**
   * Checks if a value is associated with the given key.
   *
   * @param key the key to check
   * @return true if a value exists for the key, false otherwise
   */
  public boolean hasValue(String key) {
    return values[hash(key)] != null;
  }

  /**
   * Returns the set of keys in the map.
   *
   * @return a set of keys
   */
  @SuppressWarnings("unchecked")
  public MarsikSet<E> keySet() {
    MarsikSet<E> set = new MarsikSet<>();
    for (Object key : keySet) {
      set.add((E) key);
    }
    return set;
  }

  /**
   * Returns all values in a MarsikList.
   *
   * @return a list of values
   */
  @SuppressWarnings("unchecked")
  public MarsikList<E> values() {
    MarsikList<E> list = new MarsikList<>();
    for (Object key : keySet) {
      list.add((E) key);
    }
    return list;
  }

  /**
   * Checks whether the given keys can be mapped perfectly without collisions.
   *
   * @param keys the keys to check
   * @return true if perfect hashing is possible, false otherwise
   */
  public boolean hash(String... keys) {
    HashSet<Integer> integerHashSet = new HashSet<>();
    for (String key : keys) {
      int hash = key.hashCode() ^ (key.hashCode() >>> 16);
      integerHashSet.add(hash % values.length);
    }
    return integerHashSet.size() == keys.length;
  }

  /**
   * Computes the perfect hash index for the given key.
   *
   * @param key the key to hash
   * @return the index in the internal array
   */
  public int hash(String key) {
    int h = key.hashCode() ^ (key.hashCode() >>> 16);
    return Math.floorMod(h, values.length);
  }
}
package org.example.internals.datastructures;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * == SuperHashMap comparison with java Hashmap ==
 * Setup: Java destroys me apocalyptically (cuz I need to check if hashes for keys are unique)
 * Performance of Set and Get methods: Java gets destroyed
 * Performance of Getter for key-set and values: Java gets destroyed apocalyptically.
 * Performance of Remove: Java gets destroyed.
 * Storage for 50 keys: Java got 2.8kb data, mine got 2.1kb data,
 * even if my Object[] array can be over 10 time bigger than key size, cuz java has big overhead,
 * so Java gets destroyed.
 * Collision: Mine is collision free, java's is not, I destroy java apocalyptically.

 * <p>
 * Example Benchmark results for 50 keys and 5 Runs:
 * <p>
 * Java HashMap setup : 0.0467 ms
 * SuperHashMap setup : 18.1265 ms (400 times slower :(, but only once)
 * <p>
 * Java HashMap set() average : 30.949 ms
 * SuperHashMap set() average: 27.761 ms
 * <p>
 * Java HashMap get() average: 12.087 ms
 * SuperHashMap get() average: 8.602 ms
 * <p>
 * Java HashMap remove() average: 22.133 ms
 * SuperHashMap remove() average: 11.356 ms
 * <p>
 * Java HashMap getKeySet() average: 0.00334 ms
 * SuperHashMap getKeySet() average: 0.00008 ms
 * <p>
 * Java HashMap getValues() average: 0.00390 ms
 * SuperHashMap getValues() average: 0.00010 ms
 */

public class MarsikHashMap {

  private final Set<Object> keySet = new HashSet<>();
  private Object[] values;
  private int growFactor = 1;
  private final int initialSize;

  public MarsikHashMap(int size) {
    initialSize = size;
    values = new Object[size];
  }

  public MarsikHashMap() {
    initialSize = 20;
    values = new Object[initialSize];
  }

  public void defineKeys(String... keys) {
    boolean mapperResult;
    do {
      mapperResult = hash(keys);
      growFactor++;
      values = new Object[initialSize*growFactor];
      System.out.print("Trying growFactor " + growFactor);
      if (growFactor > 64) {
        throw new UnsupportedOperationException("Cannot make perfect hashing out of these keys");
      } else {
        keySet.addAll(List.of(keys));
      }
    } while (!mapperResult);
  }

  public Object get(String key) {
    return values[hash(key)];
  }

  public void set(String key, Object value) {
    values[hash(key)] = value;
  }

  public Object remove(String key) {
    keySet.remove(key);
    int idx = hash(key);
    Object o = values[idx];
    values[idx] = null;
    return o;
  }

  public boolean hasValue(String key) {
    return values[hash(key)] != null;
  }

  public Set<Object> keySet() {
    return keySet;
  }

  public Object[] values() {
    return values;
  }

  public boolean hash(String... keys) {
    HashSet<Integer> integerHashSet = new HashSet<>();
    for (String key : keys) {
      int hash = key.hashCode() ^ (key.hashCode() >>> 16);
      integerHashSet.add(hash % values.length);
    }
    return integerHashSet.size() == keys.length;
  }

  public int hash(String key) {
    int h = key.hashCode() ^ (key.hashCode() >>> 16);
    return Math.floorMod(h, values.length);
  }
}
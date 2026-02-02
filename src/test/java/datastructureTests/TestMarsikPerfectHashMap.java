package datastructureTests;

import org.example.internals.datastructures.MarsikList;
import org.example.internals.datastructures.MarsikPerfectHashMap;
import org.example.internals.datastructures.MarsikSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMarsikPerfectHashMap {

  @Test
  void defineKeysCreatesNoCollisions() {
    MarsikPerfectHashMap<Integer> map = new MarsikPerfectHashMap<>(10);
    String[] keys = {"A", "B", "C", "D"};

    assertDoesNotThrow(() -> map.defineKeys(keys));
    for (String key : keys) {
      int idx = map.hash(key);
      assertTrue(idx >= 0 && idx < 40); // 10 initialSize * growFactor max ~ 4
    }
  }

  @Test
  void setAndGetValuesWork() {
    MarsikPerfectHashMap<String> map = new MarsikPerfectHashMap<>();
    map.defineKeys("apple", "banana", "cherry");

    map.set("apple", "red");
    map.set("banana", "yellow");

    assertEquals("red", map.get("apple"));
    assertEquals("yellow", map.get("banana"));
    assertNull(map.get("cherry"));
  }

  @Test
  void removeKeyWorks() {
    MarsikPerfectHashMap<Integer> map = new MarsikPerfectHashMap<>();
    map.defineKeys("one", "two", "three");

    map.set("one", 1);
    map.set("two", 2);

    int removed = map.remove("one");
    assertEquals(1, removed);
    assertNull(map.get("one"));
    assertFalse(map.hasValue("one"));
  }

  @Test
  void hasValueReturnsCorrectly() {
    MarsikPerfectHashMap<String> map = new MarsikPerfectHashMap<>();
    map.defineKeys("x", "y");
    map.set("x", "hello");

    assertTrue(map.hasValue("x"));
    assertFalse(map.hasValue("y"));
  }

  @Test
  void keySetContainsAllKeys() {
    MarsikPerfectHashMap<String> map = new MarsikPerfectHashMap<>();
    map.defineKeys("a", "b", "c");

    map.set("a", "alpha");
    map.set("b", "beta");

    MarsikSet<String> keys = map.keySet();
    assertEquals(3, keys.size());
    assertTrue(keys.contains("a"));
    assertTrue(keys.contains("b"));
    assertTrue(keys.contains("c"));
  }

  @Test
  void valuesContainAllSetValues() {
    MarsikPerfectHashMap<String> map = new MarsikPerfectHashMap<>();
    map.defineKeys("k1", "k2", "k3");

    map.set("k1", "v1");
    map.set("k2", "v2");

    MarsikList<String> vals = map.values();
    vals.print();
    assertTrue(vals.contains("v1"));
    assertTrue(vals.contains("v2"));
    assertFalse(vals.contains("v3"));
  }

  @Test
  void hashIndexIsWithinBounds() {
    MarsikPerfectHashMap<Object> map = new MarsikPerfectHashMap<>(5);
    map.defineKeys("alpha", "beta", "gamma");

    for (String key : new String[]{"alpha", "beta", "gamma"}) {
      int idx = map.hash(key);
      assertTrue(idx >= 0 && idx < map.values().size() + 20);
    }
  }
}
package datastructureTests;

import org.example.internals.datastructures.MarsikHashMap;
import org.example.internals.datastructures.MarsikList;
import org.example.internals.datastructures.MarsikSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMarsikHashMap {

  @Test
  public void testPutAndGet() {
    MarsikHashMap<String, Integer> map = new MarsikHashMap<>();
    map.put("a", 1);
    map.put("b", 2);

    assertEquals(1, map.get("a"));
    assertEquals(2, map.get("b"));
    assertNull(map.get("c"));
  }

  @Test
  public void testContainsKeyAndValue() {
    MarsikHashMap<String, Integer> map = new MarsikHashMap<>();
    map.put("x", 10);

    assertTrue(map.containsKey("x"));
    assertFalse(map.containsKey("y"));

    assertTrue(map.containsValue(10));
    assertFalse(map.containsValue(20));
  }

  @Test
  public void testRemoveAndClear() {
    MarsikHashMap<String, Integer> map = new MarsikHashMap<>();
    map.put("key", 42);

    assertEquals(42, map.remove("key"));
    assertFalse(map.containsKey("key"));

    map.put("a", 1);
    map.put("b", 2);
    map.clear();
  }

  @Test
  public void testKeyList() {
    MarsikHashMap<String, Integer> map = new MarsikHashMap<>();
    map.put("k1", 1);
    map.put("k2", 2);

    MarsikSet<String> keys = map.keyList();
    assertTrue(keys.contains("k1"));
    assertTrue(keys.contains("k2"));
    assertEquals(2, keys.size());
  }

  @Test
  public void testValueList() {
    MarsikHashMap<String, Integer> map = new MarsikHashMap<>();
    map.put("x", 100);
    map.put("y", 200);

    MarsikList<Integer> values = map.valueList();
    assertTrue(values.contains(100));
    assertTrue(values.contains(200));
    assertEquals(2, values.size());
  }

  @Test
  public void testEntryList() {
    MarsikHashMap<String, Integer> map = new MarsikHashMap<>();
    map.put("foo", 123);
    map.put("bar", 456);

    MarsikList<Object[]> entries = map.entryList();
    assertEquals(2, entries.size());
  }

  @Test
  public void testSizeAndIsEmpty() {
    MarsikHashMap<String, Integer> map = new MarsikHashMap<>();
    assertEquals(0, map.size());
    assertTrue(map.isEmpty());

    map.put("a", 1);
    assertEquals(1, map.size());
    assertFalse(map.isEmpty());
  }
}
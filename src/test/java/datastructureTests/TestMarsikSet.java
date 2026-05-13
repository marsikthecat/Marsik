package datastructureTests;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class TestMarsikSet {

  @Test
  void newSetIsEmpty() {
    MarsikSet<Integer> set = new MarsikSet<>();
    assertTrue(set.isEmpty());
    assertEquals(0, set.size());
    MarsikSet<Integer> set2 = new MarsikSet<>(10);
    assertTrue(set2.isEmpty());
  }

  @Test
  void addSingleElement() {
    MarsikSet<String> set = new MarsikSet<>();
    set.add("a");

    assertFalse(set.isEmpty());
    assertEquals(1, set.size());
    assertTrue(set.contains("a"));
  }

  @Test
  void addDuplicateDoesNotIncreaseSize() {
    MarsikSet<Integer> set = new MarsikSet<>();
    set.add(1);
    set.add(1);
    set.add(1);

    assertEquals(1, set.size());
    assertTrue(set.contains(1));
  }

  @Test
  void removeElement() {
    MarsikSet<Integer> set = new MarsikSet<>();
    set.add(1);
    set.add(2);

    set.remove(1);

    assertFalse(set.contains(1));
    assertTrue(set.contains(2));
    assertEquals(1, set.size());
  }

  @Test
  void removeNonExistingDoesNothing() {
    MarsikSet<Integer> set = new MarsikSet<>();
    set.add(1);

    set.remove(999);

    assertEquals(1, set.size());
    assertTrue(set.contains(1));
  }

  @Test
  void clearEmptiesSet() {
    MarsikSet<String> set = new MarsikSet<>();
    set.add("a");
    set.add("b");

    set.clear();

    assertTrue(set.isEmpty());
    assertEquals(0, set.size());
  }

  @Test
  void copyCreatesIndependentSet() {
    MarsikSet<Integer> original = new MarsikSet<>();
    original.add(1);
    original.add(2);

    MarsikSet<Integer> copy = original.copy();
    copy.add(3);

    assertEquals(2, original.size());
    assertEquals(3, copy.size());
    assertFalse(original.contains(3));
  }

  @Test
  void constructFromJavaSet() {
    Set<String> javaSet = new HashSet<>();
    javaSet.add("a");
    javaSet.add("b");

    MarsikSet<String> set = new MarsikSet<>(javaSet);

    assertEquals(2, set.size());
    assertTrue(set.contains("a"));
    assertTrue(set.contains("b"));
  }

  @Test
  void containsNullIfAllowed() {
    MarsikSet<String> set = new MarsikSet<>();
    set.add(null);

    assertTrue(set.contains(null));
    assertEquals(1, set.size());
  }

  @Test
  void sizeReflectsUniqueElements() {
    MarsikSet<Integer> set = new MarsikSet<>();
    for (int i = 0; i < 100; i++) {
      set.add(i % 10);
    }

    assertEquals(10, set.size());
  }
}

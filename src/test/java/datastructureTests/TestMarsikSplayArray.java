package datastructureTests;

import org.example.internals.datastructures.MarsikSplayArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMarsikSplayArray {

  @Test
  void indexOf_incrementsVisitedAndKeepsIndex() {
    MarsikSplayArray<Integer> arr = new MarsikSplayArray<>(1, 2, 3, 4);

    int idx1 = arr.indexOf(3);
    int idx2 = arr.indexOf(3);

    assertEquals(2, idx1);
    assertEquals(2, idx2);
    assertEquals(3, arr.get(2));
  }

  @Test
  void get_incrementsVisited() {
    MarsikSplayArray<String> arr = new MarsikSplayArray<>("a", "b", "c");

    assertEquals("b", arr.get(1));
    assertEquals("b", arr.get(1));
    assertTrue(arr.contains("b"));
  }

  @Test
  void rearrange_movesFrequentlyAccessedElementForward() {
    MarsikSplayArray<Integer> arr = new MarsikSplayArray<>(1, 2, 3, 4);
    for (int i = 0; i < 10; i++) {
      arr.indexOf(4);
    }
    for (int i = 0; i < 8; i++) {
      arr.indexOf(1);
    }
    assertEquals(4, arr.get(0), "Most accessed element should be moved to front");
    assertEquals(1, arr.get(1), "Second most accessed element should be moved to second position");
  }

  @Test
  void contains_triggersVisitedUpdate() {
    MarsikSplayArray<Integer> arr = new MarsikSplayArray<>(10, 20, 30);

    // Trigger 20, three times (size of arr) to rearrange it to the first index
    assertTrue(arr.contains(20));
    assertTrue(arr.contains(20));
    assertTrue(arr.contains(20));
    arr.contains(10);

    assertEquals(20, arr.get(0));
  }

  @Test
  void indexOf_notFoundDoesNotCrash() {
    MarsikSplayArray<Integer> arr = new MarsikSplayArray<>(1, 2, 3);

    int idx = arr.indexOf(99);

    assertEquals(-1, idx);
    assertEquals(3, arr.size());
  }

  @Test
  void rearrange_preservesAllElements() {
    MarsikSplayArray<Integer> arr = new MarsikSplayArray<>(1, 2, 3, 4, 5);

    for (int i = 0; i < 5; i++) {
      arr.indexOf(3);
    }
    arr.indexOf(1);

    assertTrue(arr.contains(1));
    assertTrue(arr.contains(2));
    assertTrue(arr.contains(3));
    assertTrue(arr.contains(4));
    assertTrue(arr.contains(5));
    assertEquals(5, arr.size());
  }
}
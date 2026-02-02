package datastructureTests;

import org.example.internals.datastructures.MarsikList;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestMarsikList {

  @Test
  void testAddAndGetSize() {
    MarsikList<String> list = new MarsikList<>();
    assertEquals(0, list.size());

    list.add("a");
    list.add("b");
    assertEquals(2, list.size());
    assertEquals("a", list.get(0));
    assertEquals("b", list.get(1));
  }

  @Test
  void testAddAtIndex() {
    MarsikList<String> list = new MarsikList<>("x", "y", "z");
    list.add(1, "new");

    assertEquals(4, list.size());
    assertEquals("x", list.get(0));
    assertEquals("new", list.get(1));
    assertEquals("y", list.get(2));
    assertEquals("z", list.get(3));
  }

  @Test
  void testSetElement() {
    MarsikList<Integer> list = new MarsikList<>(1, 2, 3);
    list.set(1, 20);

    assertEquals(3, list.size());
    assertEquals(20, list.get(1));
  }

  @Test
  void testRemoveByIndex() {
    MarsikList<String> list = new MarsikList<>("a", "b", "c");
    String removed = list.remove(1);

    assertEquals("b", removed);
    assertEquals(2, list.size());
    assertEquals("c", list.get(1));
  }

  @Test
  void testRemoveByValue() {
    MarsikList<String> list = new MarsikList<>("apple", "banana", "cherry");
    boolean removed = list.remove("banana");

    assertTrue(removed);
    assertEquals(2, list.size());
    assertFalse(list.remove("banana")); // schon weg
  }

  @Test
  void testRemoveAll() {
    MarsikList<String> list = new MarsikList<>("a", "b", "a", "c", "a");
    list.removeAll("a");

    assertEquals(2, list.size());
    assertEquals("b", list.get(0));
    assertEquals("c", list.get(1));
  }

  @Test
  void testIndexOfAndLastIndexOf() {
    MarsikList<String> list = new MarsikList<>("x", "y", "x", "z");
    assertEquals(0, list.indexOf("x"));
    assertEquals(2, list.lastIndexOf("x"));
    assertEquals(-1, list.indexOf("notfound"));
  }

  @Test
  void testGetThrowsOnInvalidIndex() {
    MarsikList<String> list = new MarsikList<>();
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
  }

  @Test
  void testSetThrowsOnInvalidIndex() {
    MarsikList<String> list = new MarsikList<>();
    assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "x"));
  }

  @Test
  void testAddAtIndexThrowsOnInvalidIndex() {
    MarsikList<String> list = new MarsikList<>();
    assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, "x"));
  }

  @Test
  void testContains() {
    MarsikList<String> list = new MarsikList<>("a", "b", "c");
    assertTrue(list.contains("b"));
    assertFalse(list.contains("x"));
  }

  @Test
  void testClear() {
    MarsikList<Integer> list = new MarsikList<>(1, 2, 3);
    list.clear();
    assertEquals(0, list.size());
    assertFalse(list.contains(1));
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
  }

  @Test
  void testRemoveDuplicateOf() {
    MarsikList<String> list = new MarsikList<>("a", "b", "a", "c", "a");
    list.print();
    list.removeDuplicateOf("a");
    list.print();

    assertEquals(3, list.size());
    assertEquals("a", list.get(0));
    assertEquals("b", list.get(1));
    assertEquals("c", list.get(2));
  }

  @Test
  void testWithoutDuplicates() {
    MarsikList<String> list = new MarsikList<>("x", "y", "x", "z", "y");
    MarsikList<String> unique = list.withoutDuplicates();

    assertEquals(3, unique.size());
    assertTrue(unique.contains("x"));
    assertTrue(unique.contains("y"));
    assertTrue(unique.contains("z"));
  }

  @Test
  void testDuplicate() {
    MarsikList<Integer> list = new MarsikList<>(1, 2, 3);
    MarsikList<Integer> copy = list.duplicate();

    assertEquals(list.size(), copy.size());
    for (int i = 0; i < list.size(); i++) {
      assertEquals(list.get(i), copy.get(i));
    }

    list.set(0, 10);
    assertEquals(1, copy.get(0));
    assertEquals(10, list.get(0));
  }

  @Test
  public void testSortAndNumbers() {
    MarsikList<Integer> list = new MarsikList<>(5, 3, 8, 1);
    list.sort();
    assertEquals(1, list.get(0));
    assertEquals(8, list.get(list.size() - 1));
    assertTrue(list.allNumbers());
    assertEquals(17.0, list.sum());
    assertEquals(4.25, list.avg());
  }

  @Test
  public void testSumException() {
    MarsikList<Object> list = new MarsikList<>("a", "b");
    assertFalse(list.allNumbers());
    assertThrows(NoSuchElementException.class, list::sum);
  }

  @Test
  public void testPercentile() {
    MarsikList<Integer> list = new MarsikList<>(10, 20, 30, 40, 50);
    assertEquals(10, list.percentile(0.0));
    assertEquals(50, list.percentile(1.0));
    assertEquals(30, list.percentile(0.5));
  }

  @Test
  public void testMostAppearing() {
    MarsikList<String> list = new MarsikList<>("a","b","a","c","b","a");
    assertEquals("a", list.mostAppearingElement());
    assertEquals(3, list.mostAppearingElementCount());
  }

  @Test
  public void testRandomElement() {
    MarsikList<Integer> list = new MarsikList<>(1, 2, 3, 4, 5);
    int val = list.randomElement();
    assertTrue(val >= 1 && val <= 5);
  }

  @Test
  public void testRandomElementEmpty() {
    MarsikList<Integer> empty = new MarsikList<>();
    assertThrows(IllegalStateException.class, empty::randomElement);
  }

  @Test
  public void testRandomIntegerList() {
    MarsikList<Integer> randomInts = new MarsikList<>().randomIntegerList(1, 10, 100);
    assertEquals(100, randomInts.size());
  }

  @Test
  public void testRandomDoubleList() {
    MarsikList<Double> randomDoubles = new MarsikList<>().randomDoubleList(0.0, 1.0, 50);
    assertEquals(50, randomDoubles.size());
  }
}
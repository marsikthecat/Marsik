package datastructureTests;

import org.example.internals.datastructures.MarsikSparseArray;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestMarsikSparseArray {

  @Test
  void defaultConstructor_createsEmptyArray() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>();
    assertEquals(0, arr.firstFreeIndex());
    assertEquals(20, arr.length()); // <- default array size
  }

  @Test
  void constructorWithElements_initializesCorrectly() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B", "C");
    assertEquals(3, arr.firstFreeIndex());
    assertEquals("A", arr.get(0));
    assertEquals("B", arr.get(1));
    assertEquals("C", arr.get(2));
  }

  @Test
  void get_validIndex_returnsElement() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2, 3);
    assertEquals(2, arr.get(1));
  }

  @Test
  void get_invalidIndex_throwsException() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2, 3);
    assertThrows(IllegalArgumentException.class, () -> arr.get(21));
  }

  @Test
  void set_replacesElement() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B");
    arr.set(1, "X");
    assertEquals("X", arr.get(1));
  }

  @Test
  void set_invalidIndex_throwsException() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A");
    assertThrows(IllegalArgumentException.class, () -> arr.set(2, "X"));
  }

  @Test
  void removeByIndex_setsNull() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2, 3);
    arr.remove(1);
    arr.print();
    assertNull(arr.get(1));
    assertEquals(1, arr.firstFreeIndex());
  }

  @Test
  void removeByIndex_invalidIndex_throwsException() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2);
    assertThrows(IllegalArgumentException.class, () -> arr.remove(5));
  }

  @Test
  void removeByValue_removesFirstOccurrence() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B", "A");
    arr.remove("A");
    assertNull(arr.get(0));
    assertEquals("B", arr.get(1));
    assertEquals("A", arr.get(2));
  }

  @Test
  void removeByValue_notFound_doesNothing() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B");
    arr.remove("X");
    assertEquals("A", arr.get(0));
    assertEquals("B", arr.get(1));
  }

  @Test
  void removeAndRetrieve_returnsAndRemovesElement() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(10, 20, 30);
    Integer removed = arr.removeAndRetrieve(1);
    assertEquals(20, removed);
    assertNull(arr.get(1));
  }

  @Test
  void removeAndRetrieve_invalidIndex_throwsException() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1);
    assertThrows(IllegalArgumentException.class, () -> arr.removeAndRetrieve(2));
  }

  @Test
  void removeAll_removesAllOccurrences() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B", "A", "C", "A");
    arr.removeAll("A");
    assertNull(arr.get(0));
    assertEquals("B", arr.get(1));
    assertNull(arr.get(2));
    assertEquals("C", arr.get(3));
    assertNull(arr.get(4));
  }

  @Test
  void removeAll_valueNotPresent_doesNothing() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B");
    arr.removeAll("X");
    assertEquals("A", arr.get(0));
    assertEquals("B", arr.get(1));
  }

  @Test
  void length_ignoresHoles() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2, 3);
    arr.remove(0);
    arr.remove(2);
    arr.print();
    assertEquals(0, arr.firstFreeIndex());
    assertNull(arr.get(0));
    assertNull(arr.get(2));
  }

  @Test
  void append_addsElementsAtEnd() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2, 4, 4, 5);
    arr.append(3, 4);
    arr.print();
    assertEquals(7, arr.firstFreeIndex());
    assertEquals(1, arr.get(0));
    assertEquals(4, arr.get(3));
  }

  @Test
  void contains_existingElement() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B", "C");
    assertTrue(arr.contains("B"));
  }

  @Test
  void contains_nonExistingElement() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B");
    assertFalse(arr.contains("X"));
  }

  @Test
  void indexOf_returnsFirstIndex() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B", "A");
    assertEquals(0, arr.indexOf("A"));
  }

  @Test
  void lastIndexOf_returnsLastIndex() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B", "A");
    assertEquals(2, arr.lastIndexOf("A"));
  }

  @Test
  void firstFreeIndex_findsFirstNull() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2, 3);
    arr.remove(1);
    assertEquals(1, arr.firstFreeIndex());
  }

  @Test
  void lastFreeIndex_findsLastNull() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2, 3, 4);
    arr.remove(1);
    arr.remove(3);
    arr.print();
    assertEquals(7, arr.lastFreeIndex());
  }

  @Test
  void pushFromStart_fillsFirstHole() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B", "C");
    arr.remove(0);
    arr.pushFromStart("X");
    assertEquals("X", arr.get(0));
  }

  @Test
  void pushFromEnd_fillsLastHole() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B", "C", "D");
    arr.remove(1);
    arr.remove(3);
    arr.pushFromEnd("X");
    assertEquals("X", arr.get(7));
  }

  @Test
  void pushFromStart_noHole_throwsException() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2);
    assertThrows(IllegalArgumentException.class, () -> arr.pushFromStart(3));
  }

  @Test
  void isEmpty_newArrayTrue() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>();
    assertTrue(arr.isEmpty());
  }

  @Test
  void hasHoles_trueAfterRemove() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2);
    arr.remove(0);
    assertTrue(arr.hasHoles());
    assertEquals(1, arr.numberOfHoles());
  }

  @Test
  void slice_returnsCorrectSubArray() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B", "C", "D");
    Object[] slice = arr.slice(1, 3);
    assertArrayEquals(new Object[]{"B", "C"}, slice);
  }

  @Test
  void slice_invalidRange_throwsException() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2);
    assertThrows(IllegalArgumentException.class, () -> arr.slice(2, 1));
  }

  @Test
  void removeDuplicateOf_keepsFirstOccurrenceOnly() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B", "A", "A", "C");
    arr.removeDuplicateOf("A");
    assertEquals("A", arr.get(0));
    assertEquals("B", arr.get(1));
    assertNull(arr.get(2));
    assertNull(arr.get(3));
    assertEquals("C", arr.get(4));
    arr.print();
  }

  @Test
  void removeAllDuplicates_removesAllDuplicates() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B", "A", "C", "B");
    arr.removeAllDuplicates();
    arr.print();
    assertEquals("A", arr.get(0));
    assertEquals("B", arr.get(1));
    assertNull(arr.get(2));
    assertEquals("C", arr.get(3));
    assertNull(arr.get(4));
  }

  @Test
  void duplicate_createsIndependentCopy() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2, 3);
    MarsikSparseArray<Integer> copy = arr.duplicate();
    assertEquals(arr.length(), copy.length());
    assertEquals(arr.get(1), copy.get(1));
    copy.set(1, 99);
    assertEquals(2, arr.get(1));
  }


  @Test
  void unionWith_combinesUniqueElements() {
    MarsikSparseArray<Integer> a = new MarsikSparseArray<>(1, 2, 3);
    MarsikSparseArray<Integer> b = new MarsikSparseArray<>(3, 4, 5);
    MarsikSparseArray<Integer> union = a.unionWith(b);
    assertTrue(union.contains(1));
    assertTrue(union.contains(5));
    union.print();
    assertEquals(5, union.length());
  }

  @Test
  void intersectionWith_returnsCommonElements() {
    MarsikSparseArray<String> a = new MarsikSparseArray<>("A", "B", "C");
    MarsikSparseArray<String> b = new MarsikSparseArray<>("B", "C", "D");
    Set<String> intersection = a.intersectionWith(b);
    assertEquals(2, intersection.size());
    assertTrue(intersection.contains("B"));
    assertTrue(intersection.contains("C"));
  }

  @Test
  void sort_ordersElementsNaturally() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(3, 1, 2);
    arr.sort();
    assertEquals(1, arr.get(0));
    assertEquals(2, arr.get(1));
    assertEquals(3, arr.get(2));
  }

  @Test
  void sort_nonComparable_throwsException() {
    MarsikSparseArray<Object> arr = new MarsikSparseArray<>(new Object(), new Object());
    assertThrows(IllegalStateException.class, arr::sort);
  }

  @Test
  void max_returnsMaximumNumber() {
    MarsikSparseArray<Number> arr = new MarsikSparseArray<>(1, 5, 3);
    assertEquals(5, arr.max());
  }

  @Test
  void min_returnsMinimumNumber() {
    MarsikSparseArray<Number> arr = new MarsikSparseArray<>(1, 5, 3);
    assertEquals(1, arr.min());
  }

  @Test
  void max_nonNumbers_throwException() {
    MarsikSparseArray<Object> arr = new MarsikSparseArray<>("A", "B");
    assertThrows(IllegalArgumentException.class, arr::max);
  }

  @Test
  void sum_returnsCorrectSum() {
    MarsikSparseArray<Number> arr = new MarsikSparseArray<>(1, 2, 3);
    assertEquals(6.0, arr.sum());
  }

  @Test
  void avg_returnsCorrectAverage() {
    MarsikSparseArray<Number> arr = new MarsikSparseArray<>(2, 4, 6);
    assertEquals(4.0, arr.avg());
  }

  @Test
  void sum_noNumbers_throwsException() {
    MarsikSparseArray<Object> arr = new MarsikSparseArray<>("A");
    assertThrows(NoSuchElementException.class, arr::sum);
  }

  @Test
  void percentile_returnsCorrectElement() {
    MarsikSparseArray<Number> arr = new MarsikSparseArray<>(10, 20, 30, 40);
    assertEquals(30, arr.percentile(0.75));
  }

  @Test
  void percentile_nonNumbers_throwsException() {
    MarsikSparseArray<Object> arr = new MarsikSparseArray<>("A", "B");
    assertThrows(NoSuchElementException.class, () -> arr.percentile(0.5));
  }

  @Test
  void mostAppearingElement_returnsCorrectElement() {
    MarsikSparseArray<String> arr = new MarsikSparseArray<>("A", "B", "A", "C", "A");
    assertEquals("A", arr.mostAppearingElement());
  }

  @Test
  void mostAppearingElementCount_returnsCorrectCount() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2, 2, 3, 2);
    assertEquals(3, arr.mostAppearingElementCount());
  }

  @Test
  void randomElement_returnsValidElement() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2, 3);
    Integer value = arr.randomElement();
    assertTrue(arr.contains(value));
  }

  @Test
  void randomElementFromRange_returnsValidElement() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(10, 20, 30, 40);
    Integer value = arr.randomElementFromRange(1, 2);
    assertTrue(value == 20 || value == 30);
  }

  @Test
  void randomElementFromRange_invalidRange_throwsException() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2, 3);
    assertThrows(IndexOutOfBoundsException.class, () -> arr.randomElementFromRange(2, 10));
  }

  @Test
  void defragmentation_removesHolesAndShrinks() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2, 3, 4);
    arr.print();
    arr.remove(1);
    arr.remove(3);
    arr.defragmentation();
    arr.print();
    assertEquals(8, arr.length());
    assertEquals(1, arr.get(0));
    assertEquals(3, arr.get(1));
    assertNull(arr.get(2));
    assertNull(arr.get(3));
    assertNull(arr.get(4));
    assertNull(arr.get(5));
    assertNull(arr.get(6));
    assertNull(arr.get(7));
  }

  @Test
  void clear_removesAllElements() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2);
    arr.clear();
    assertTrue(arr.isEmpty());
  }


  @Test
  void destroy_nullsInternalState() {
    MarsikSparseArray<Integer> arr = new MarsikSparseArray<>(1, 2);
    arr.destroy();
    assertThrows(NullPointerException.class, arr::length);
  }
}

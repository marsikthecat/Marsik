package datastructureTests;

import org.example.internals.datastructures.MarsikQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMarsikQueue {

  @Test
  void newQueueIsEmpty() {
    MarsikQueue<Integer> queue = new MarsikQueue<>(10);
    assertTrue(queue.isEmpty());
    assertEquals(0, queue.size());
    assertEquals(0, queue.length());
    assertNull(queue.peek());
    assertNull(queue.dequeue());
  }

  @Test
  void enqueueIncreasesSize() {
    MarsikQueue<String> queue = new MarsikQueue<>(5);
    queue.enqueue("A");
    queue.enqueue("B");

    assertFalse(queue.isEmpty());
    assertEquals(2, queue.size());
    assertEquals(2, queue.length());
  }

  @Test
  void dequeueRemovesInOrder() {
    MarsikQueue<Integer> queue = new MarsikQueue<>(5);
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);

    assertEquals(1, queue.dequeue());
    assertEquals(2, queue.dequeue());
    assertEquals(3, queue.dequeue());
    assertNull(queue.dequeue());
    assertTrue(queue.isEmpty());
  }

  @Test
  void peekDoesNotRemove() {
    MarsikQueue<String> queue = new MarsikQueue<>(5);
    queue.enqueue("X");
    queue.enqueue("Y");

    assertEquals("X", queue.peek());
    assertEquals("X", queue.peek());
    assertEquals(2, queue.size());
  }

  @Test
  void sizeAndLengthConsistency() {
    MarsikQueue<Integer> queue = new MarsikQueue<>(3);
    queue.enqueue(10);
    queue.enqueue(20);

    assertEquals(queue.size(), queue.length());
  }

  @Test
  void dequeueEmptyQueueReturnsNull() {
    MarsikQueue<Double> queue = new MarsikQueue<>(2);
    assertNull(queue.dequeue());
    assertTrue(queue.isEmpty());
  }

  @Test
  void enqueueAndDequeueMultipleElements() {
    MarsikQueue<Integer> queue = new MarsikQueue<>(10);
    for (int i = 0; i < 5; i++) {
      queue.enqueue(i);
    }
    for (int i = 0; i < 5; i++) {
      assertEquals(i, queue.dequeue());
    }
    assertTrue(queue.isEmpty());
  }
}
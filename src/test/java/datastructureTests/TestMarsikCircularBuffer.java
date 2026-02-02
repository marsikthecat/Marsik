package datastructureTests;

import org.example.internals.datastructures.MarsikCircularBuffer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMarsikCircularBuffer {

  @Test
  void offer_and_poll_singleElement() {
    MarsikCircularBuffer<Integer> buffer = new MarsikCircularBuffer<>(4);

    assertTrue(buffer.offer(1));
    assertEquals(1, buffer.poll());
    assertNull(buffer.poll());
  }

  @Test
  void poll_onEmptyBuffer_returnsNull() {
    MarsikCircularBuffer<String> buffer = new MarsikCircularBuffer<>(3);

    assertNull(buffer.poll());
  }

  @Test
  void fillBuffer_untilFull() {
    MarsikCircularBuffer<Integer> buffer = new MarsikCircularBuffer<>(3);

    assertTrue(buffer.offer(1));
    assertTrue(buffer.offer(2));
    assertTrue(buffer.offer(3));

    assertFalse(buffer.offer(4));
  }

  @Test
  void fifo_order_isPreserved() {
    MarsikCircularBuffer<Integer> buffer = new MarsikCircularBuffer<>(5);

    buffer.offer(1);
    buffer.offer(2);
    buffer.offer(3);

    assertEquals(1, buffer.poll());
    assertEquals(2, buffer.poll());
    assertEquals(3, buffer.poll());
  }

  @Test
  void wrapAround_writePointer() {
    MarsikCircularBuffer<Integer> buffer = new MarsikCircularBuffer<>(3);

    buffer.offer(1);
    buffer.offer(2);
    buffer.offer(3);

    assertEquals(1, buffer.poll());
    assertEquals(2, buffer.poll());

    assertTrue(buffer.offer(4));
    assertTrue(buffer.offer(5));

    assertEquals(3, buffer.poll());
    assertEquals(4, buffer.poll());
    assertEquals(5, buffer.poll());
  }

  @Test
  void wrapAround_readPointer() {
    MarsikCircularBuffer<Integer> buffer = new MarsikCircularBuffer<>(2);

    buffer.offer(1);
    buffer.offer(2);

    assertEquals(1, buffer.poll());
    assertTrue(buffer.offer(3));

    assertEquals(2, buffer.poll());
    assertEquals(3, buffer.poll());
  }

  @Test
  void alternating_offer_poll() {
    MarsikCircularBuffer<Integer> buffer = new MarsikCircularBuffer<>(2);

    assertTrue(buffer.offer(1));
    assertEquals(1, buffer.poll());

    assertTrue(buffer.offer(2));
    assertEquals(2, buffer.poll());

    assertTrue(buffer.offer(3));
    assertEquals(3, buffer.poll());
  }

  @Test
  void capacityLessThanOne_defaultsTo16() {
    MarsikCircularBuffer<Integer> buffer = new MarsikCircularBuffer<>(0);

    for (int i = 0; i < 16; i++) {
      assertTrue(buffer.offer(i));
    }
    assertFalse(buffer.offer(17));
  }

  @Test
  void poll_doesNotClearSlot_butStillWorks() {
    MarsikCircularBuffer<Integer> buffer = new MarsikCircularBuffer<>(3);

    buffer.offer(1);
    buffer.offer(2);

    assertEquals(1, buffer.poll());
    assertEquals(2, buffer.poll());
    assertNull(buffer.poll());

    assertTrue(buffer.offer(3));
    assertEquals(3, buffer.poll());
  }
}
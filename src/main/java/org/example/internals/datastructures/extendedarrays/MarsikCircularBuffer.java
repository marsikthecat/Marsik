package org.example.internals.datastructures.extendedarrays;

/**
 * A fixed-size circular (ring) buffer implementation.
 * This buffer allows elements to be added and removed in a FIFO (first-in, first-out) manner.
 * When the buffer reaches its capacity, new elements cannot be added until space is freed.
 *
 * @param <E> the type of elements held in this buffer
 */
public class MarsikCircularBuffer<E> {

  private final int capacity;
  private final E[] data;
  private int readPointer;
  private int writePointer;

  /**
   * Constructs a new circular buffer with the given capacity.
   * If the specified capacity is less than 1, a default capacity of 16 is used.
   *
   * @param capacity the maximum number of elements the buffer can hold
   */
  @SuppressWarnings("unchecked")
  public MarsikCircularBuffer(int capacity) {
    this.capacity = (capacity < 1) ? 16 : capacity;
    this.data = (E[]) new Object[this.capacity];
    this.readPointer = 0;
    this.writePointer = -1;
  }

  /**
   * Attempts to add the specified element to the buffer.
   * If the buffer is full, the element is not added and the method returns {@code false}.
   *
   * @param element the element to add
   * @return {@code true} if the element was added successfully, {@code false} if the buffer is full
   */
  public boolean offer(E element) {
    boolean isFull = (writePointer - readPointer) + 1 == capacity;
    if (!isFull) {
      int nextWriteSeq = writePointer + 1;
      data[nextWriteSeq % capacity] = element;
      writePointer++;
      return true;
    }
    return false;
  }

  /**
   * Retrieves and removes the next element from the buffer.
   * If the buffer is empty, {@code null} is returned.
   *
   * @return the next element in the buffer, or {@code null} if the buffer is empty
   */
  public E poll() {
    boolean isEmpty = writePointer < readPointer;
    if (!isEmpty) {
      E nextValue = data[readPointer % capacity];
      readPointer++;
      return nextValue;
    }
    return null;
  }
}
package org.example.internals.datastructures.extendedArrays;

public class MarsikCircularBuffer<E> {

  private final int capacity;
  private final E[] data;
  private int readPointer;
  private int writePointer;

  @SuppressWarnings("unchecked")
  public MarsikCircularBuffer(int capacity) {
    this.capacity = (capacity < 1) ? 16 : capacity;
    this.data = (E[]) new Object[this.capacity];
    this.readPointer = 0;
    this.writePointer = -1;
  }

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
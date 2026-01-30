package org.example.internals.datastructures;

import java.util.ArrayDeque;

/**
 * A generic queue implementation backed by an {@link ArrayDeque}.
 * Elements are added at the tail and removed from the head (FIFO order).
 *
 * @param <E> the type of elements held in this queue
 */
public class MarsikQueue<E> {

  private final ArrayDeque<E> arrayDeque;

  /**
   * Constructs a {@code MarsikQueue} with the specified initial capacity.
   *
   * @param capacity the initial capacity of the queue
   */
  public MarsikQueue(int capacity) {
    arrayDeque = new ArrayDeque<>(capacity);
  }

  /**
   * Adds the specified element to the tail of the queue.
   *
   * @param e the element to add
   */
  public void enqueue(E e) {
    arrayDeque.offer(e);
  }

  /**
   * Retrieves and removes the head of the queue, or returns {@code null} if empty.
   *
   * @return the head element, or {@code null} if the queue is empty
   */
  public E dequeue() {
    return arrayDeque.poll();
  }

  /**
   * Retrieves, but does not remove, the head of the queue,
   * or returns {@code null} if empty.
   *
   * @return the head element, or {@code null} if the queue is empty
   */
  public E peek() {
    return arrayDeque.peek();
  }

  /**
   * Returns the number of elements currently in the queue.
   *
   * @return the number of elements in the queue
   */
  public int size() {
    return arrayDeque.size();
  }

  /**
   * Returns the number of elements currently in the queue.
   * This is an alias for {@link #size()}.
   *
   * @return the number of elements in the queue
   */
  public int length() {
    return size();
  }

  /**
   * Returns whether the queue is empty.
   *
   * @return true if there are no elements in the queue, otherwise false
   */
  public boolean isEmpty() {
    return arrayDeque.isEmpty();
  }
}
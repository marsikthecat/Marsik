package org.example.internals.datastructures;

import java.util.ArrayDeque;

public class MarsikQueue<E> {

  private final ArrayDeque<E> arrayDeque;

  public MarsikQueue(int capacity) {
    arrayDeque = new ArrayDeque<>(capacity);
  }

  public void enqueue(E e) {
    arrayDeque.offer(e);
  }

  public E dequeue() {
    return arrayDeque.poll();
  }

  public E peek() {
    return arrayDeque.peek();
  }
}
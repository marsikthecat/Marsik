package org.example.internals.datastructures;

public class MarsikStack<E> {

  private final E[] data;
  private int top = -1;

  @SuppressWarnings("unchecked")
  public MarsikStack() {
    data = (E[]) new Object[10];
  }

  @SuppressWarnings("unchecked")
  public MarsikStack(int capacity) {
    data = (E[]) new Object[capacity];
  }

  public boolean isEmpty() {
    return top == -1;
  }

  public boolean isFull() {
    return top == data.length - 1;
  }

  public int size() {
    return top + 1;
  }

  public void push(E e) {
    if (isFull()) {
      throw new IllegalStateException("Stack is full!");
    }
    data[++top] = e;
  }

  public E pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty!");
    }
    return data[top--];
  }

  public E peek() {
    if (isFull()) {
      throw new IllegalStateException("Stack is empty!");
    }
    return data[top];
  }
}
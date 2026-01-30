package org.example.internals.datastructures;

/**
 * A generic stack implementation using a fixed-size array.
 * Provides standard stack operations like push, pop, and peek.
 *
 * @param <E> the type of elements held in this stack
 */
public class MarsikStack<E> {

  private final E[] data;
  private int top = -1;

  /**
   * Constructs a stack with a default capacity of 10.
   */
  @SuppressWarnings("unchecked")
  public MarsikStack() {
    data = (E[]) new Object[10];
  }

  /**
   * Constructs a stack with the specified capacity.
   *
   * @param capacity the maximum number of elements this stack can hold
   */
  @SuppressWarnings("unchecked")
  public MarsikStack(int capacity) {
    data = (E[]) new Object[capacity];
  }

  /**
   * Checks whether the stack is empty.
   *
   * @return true if the stack has no elements, false otherwise
   */
  public boolean isEmpty() {
    return top == -1;
  }

  /**
   * Checks whether the stack is full.
   *
   * @return true if the stack has reached its capacity, false otherwise
   */
  public boolean isFull() {
    return top == data.length - 1;
  }

  /**
   * Returns the number of elements currently in the stack.
   *
   * @return the size of the stack
   */
  public int size() {
    return top + 1;
  }

  /**
   * Pushes an element onto the top of the stack.
   *
   * @param e the element to be added
   * @throws IllegalStateException if the stack is full
   */
  public void push(E e) {
    if (isFull()) {
      throw new IllegalStateException("Stack is full!");
    }
    data[++top] = e;
  }

  /**
   * Removes and returns the element at the top of the stack.
   *
   * @return the element removed from the top
   * @throws IllegalStateException if the stack is empty
   */
  public E pop() {
    if (isEmpty()) {
      throw new IllegalStateException("Stack is empty!");
    }
    return data[top--];
  }

  /**
   * Returns the element at the top of the stack without removing it.
   *
   * @return the element at the top
   * @throws IllegalStateException if the stack is empty
   */
  public E peek() {
    if (isFull()) {
      throw new IllegalStateException("Stack is empty!");
    }
    return data[top];
  }
}
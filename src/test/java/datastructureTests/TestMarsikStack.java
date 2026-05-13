package datastructureTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMarsikStack {

  @Test
  void defaultConstructor_createsEmptyStack() {
    MarsikStack<Integer> stack = new MarsikStack<>();
    assertTrue(stack.isEmpty());
    assertEquals(0, stack.size());
  }

  @Test
  void customCapacityConstructor_works() {
    MarsikStack<String> stack = new MarsikStack<>(5);
    assertTrue(stack.isEmpty());
    assertFalse(stack.isFull());
  }

  @Test
  void push_changesSizeAndEmptyState() {
    MarsikStack<Integer> stack = new MarsikStack<>(2);
    stack.push(1);
    assertFalse(stack.isEmpty());
    assertEquals(1, stack.size());
  }

  @Test
  void stackBecomesFull() {
    MarsikStack<Integer> stack = new MarsikStack<>(1);
    stack.push(42);
    assertTrue(stack.isFull());
    assertEquals(1, stack.size());
  }

  @Test
  void push_whenFull_throwsException() {
    MarsikStack<Integer> stack = new MarsikStack<>(1);
    stack.push(1);
    assertThrows(IllegalStateException.class, () -> stack.push(2));
  }

  @Test
  void pop_returnsLastPushedElement() {
    MarsikStack<Integer> stack = new MarsikStack<>();
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.pop());
    assertEquals(1, stack.pop());
    assertEquals(0, stack.size());
  }

  @Test
  void pop_decreasesSize() {
    MarsikStack<String> stack = new MarsikStack<>();
    stack.push("A");
    stack.push("B");
    stack.pop();
    assertEquals(1, stack.size());
  }

  @Test
  void pop_whenEmpty_throwsException() {
    MarsikStack<Integer> stack = new MarsikStack<>();
    assertThrows(IllegalStateException.class, stack::pop);
  }

  @Test
  void peek_returnsTopWithoutRemoving() {
    MarsikStack<Integer> stack = new MarsikStack<>();
    stack.push(10);
    stack.push(20);
    assertEquals(20, stack.peek());
    assertEquals(2, stack.size());
  }

  @Test
  void peek_whenEmpty_throwsException() {
    MarsikStack<Integer> stack = new MarsikStack<>();
    assertThrows(IllegalStateException.class, stack::peek);
  }
}
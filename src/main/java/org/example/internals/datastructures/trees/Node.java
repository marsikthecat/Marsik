package org.example.internals.datastructures.trees;

public class Node<T extends Comparable<T>> {

  private T value;
  private Node<T> leftNode;
  private Node<T> rightNode;

  public Node(T value) {
    this.value = value;
    leftNode = null;
    rightNode = null;
  }

  public Node<T> getLeftNode() {
    return leftNode;
  }

  public Node<T> getRightNode() {
    return rightNode;
  }

  public T getValue() {
    return value;
  }

  public void setLeftNode(Node<T> leftNode) {
    this.leftNode = leftNode;
  }

  public void setRightNode(Node<T> rightNode) {
    this.rightNode = rightNode;
  }

  public void setValue(T value) {
    this.value = value;
  }
}
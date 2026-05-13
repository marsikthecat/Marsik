package org.example.internals.datastructures.trees;

/**
 * Represents a node in a binary tree.
 *
 * @param <T> the type of value stored in the node, must implement {@link Comparable}
 */
public class Node<T extends Comparable<T>> {

  private T value;
  private Node<T> leftNode;
  private Node<T> rightNode;

  /**
   * Constructs a new node with the specified value.
   * Left and right child references are initialized to null.
   *
   * @param value the value to store in this node
   */
  public Node(T value) {
    this.value = value;
    leftNode = null;
    rightNode = null;
  }

  /**
   * Returns the left child node.
   *
   * @return the left child node, or null if none
   */
  public Node<T> getLeftNode() {
    return leftNode;
  }

  /**
   * Returns the right child node.
   *
   * @return the right child node, or null if none
   */
  public Node<T> getRightNode() {
    return rightNode;
  }

  /**
   * Returns the value stored in this node.
   *
   * @return the value of this node
   */
  public T getValue() {
    return value;
  }

  /**
   * Sets the left child node.
   *
   * @param leftNode the new left child node
   */
  public void setLeftNode(Node<T> leftNode) {
    this.leftNode = leftNode;
  }

  /**
   * Sets the right child node.
   *
   * @param rightNode the new right child node
   */
  public void setRightNode(Node<T> rightNode) {
    this.rightNode = rightNode;
  }

  /**
   * Sets the value stored in this node.
   *
   * @param value the new value
   */
  public void setValue(T value) {
    this.value = value;
  }
}
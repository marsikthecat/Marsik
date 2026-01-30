package org.example.internals.datastructures.trees;

/**
 * Represents a node in a Splay Tree.
 *
 * @param <T> the type of data stored in the node, must implement {@link Comparable}
 */
public class SplayNode<T extends Comparable<T>> {
  private T data;
  private SplayNode<T> left;
  private SplayNode<T> right;
  private SplayNode<T> parent;

  /**
   * Constructs a new SplayNode with the specified data.
   * Child and parent references are initialized to null.
   *
   * @param data the value to store in this node
   */
  public SplayNode(T data) {
    this.data = data;
    this.left = null;
    this.right = null;
    this.parent = null;
  }

  /**
   * Returns the data stored in this node.
   *
   * @return the data value
   */
  public T getData() {
    return data;
  }

  /**
   * Sets the data for this node.
   *
   * @param data the new data value
   */
  public void setData(T data) {
    this.data = data;
  }

  /**
   * Returns the left child of this node.
   *
   * @return the left child node, or null if none
   */
  public SplayNode<T> getLeft() {
    return left;
  }

  /**
   * Sets the left child of this node.
   *
   * @param left the new left child node
   */
  public void setLeft(SplayNode<T> left) {
    this.left = left;
  }

  /**
   * Returns the right child of this node.
   *
   * @return the right child node, or null if none
   */
  public SplayNode<T> getRight() {
    return right;
  }

  /**
   * Sets the right child of this node.
   *
   * @param right the new right child node
   */
  public void setRight(SplayNode<T> right) {
    this.right = right;
  }

  /**
   * Returns the parent of this node.
   *
   * @return the parent node, or null if this node is the root
   */
  public SplayNode<T> getParent() {
    return parent;
  }

  /**
   * Sets the parent of this node.
   *
   * @param parent the new parent node
   */
  public void setParent(SplayNode<T> parent) {
    this.parent = parent;
  }
}
package org.example.internals.datastructures.trees;

/**
 * Represents a node in an AVL (Adelson-Velsky and Landis) self-balancing binary search tree.
 * Each node stores a value of type T, references to its left and right child nodes,
 * and its height in the tree. The height is used to maintain the balance property
 * of the AVL tree.
 *
 * @param <T> the type of value stored in the node; must implement {@link Comparable}
 */
public class AvlNode<T extends Comparable<T>> {

  private T value;
  private int height;
  private AvlNode<T> left;
  private AvlNode<T> right;

  /**
   * Constructs a new AVL node with the given value.
   * The height is initialized to 1 (assuming a single node is at height 1),
   * and the left and right children are set to null.
   *
   * @param value the value to store in this node
   */
  public AvlNode(T value) {
    this.value = value;
    this.height = 1;
    this.left = null;
    this.right = null;
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
   * Sets the value stored in this node.
   *
   * @param value the new value to set
   */
  public void setValue(T value) {
    this.value = value;
  }

  /**
   * Returns the height of this node.
   *
   * @return the height
   */
  public int getHeight() {
    return height;
  }

  /**
   * Sets the height of this node.
   *
   * @param height the height to set
   */
  public void setHeight(int height) {
    this.height = height;
  }

  /**
   * Returns the left child of this node.
   *
   * @return the left child node, or null if none
   */
  public AvlNode<T> getLeft() {
    return left;
  }

  /**
   * Sets the left child of this node.
   *
   * @param left the left child node
   */
  public void setLeft(AvlNode<T> left) {
    this.left = left;
  }

  /**
   * Returns the right child of this node.
   *
   * @return the right child node, or null if none
   */
  public AvlNode<T> getRight() {
    return right;
  }

  /**
   * Sets the right child of this node.
   *
   * @param right the right child node
   */
  public void setRight(AvlNode<T> right) {
    this.right = right;
  }
}
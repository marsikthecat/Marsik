package org.example.internals.datastructures.trees;

/**
 * Represents a node in a B-Tree.
 * Each node contains an array of keys (data), an array of children,
 * a reference to its parent node, and information about its size
 * (number of keys stored) and whether it is a leaf node.
 *
 * @param <T> the type of elements stored in the node; must implement {@link Comparable}
 */
public class Bnode<T extends Comparable<T>> {
  private T[] data;
  private final Bnode<T>[] children;
  private Bnode<T> parent;
  private int size;
  private boolean isLeaf;

  /**
   * Creates a new B-Tree node with a given minimum degree.
   * A node can store a maximum of 2*t - 1 keys and have 2*t children.
   *
   * @param t the minimum degree of the B-Tree
   */
  @SuppressWarnings("unchecked")
  public Bnode(int t) {
    this.data = (T[]) new Comparable[2 * t - 1];
    this.children = (Bnode<T>[]) new Bnode[2 * t];
    this.parent = null;
    this.isLeaf = true;
  }

  /**
   * Returns the array of keys stored in this node.
   *
   * @return the keys in this node
   */
  public T[] getData() {
    return data;
  }

  /**
   * Replaces the entire array of keys with a new array.
   *
   * @param data the new array of keys
   */
  public void setData(T[] data) {
    this.data = data;
  }

  /**
   * Sets a single key at a specified index.
   *
   * @param data the key to set
   * @param idx  the index at which to set the key
   */
  public void setData(T data, int idx) {
    this.data[idx] = data;
  }

  /**
   * Returns the array of child nodes.
   *
   * @return the children of this node
   */
  public Bnode<T>[] getChildren() {
    return children;
  }

  /**
   * Sets a child node at the specified index.
   *
   * @param children the child node to set
   * @param idx      the index at which to set the child
   */
  public void setChildren(Bnode<T> children, int idx) {
    this.children[idx] = children;
  }

  /**
   * Returns the parent of this node.
   *
   * @return the parent node, or null if this is the root
   */
  public Bnode<T> getParent() {
    return parent;
  }

  /**
   * Sets the parent of this node.
   *
   * @param parent the parent node
   */
  public void setParent(Bnode<T> parent) {
    this.parent = parent;
  }

  /**
   * Returns the number of keys currently stored in this node.
   *
   * @return the size of this node
   */
  public int getSize() {
    return size;
  }

  /**
   * Sets the number of keys in this node.
   *
   * @param size the number of keys
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * Returns whether this node is a leaf.
   *
   * @return true if the node is a leaf, false otherwise
   */
  public boolean isLeaf() {
    return isLeaf;
  }

  /**
   * Sets whether this node is a leaf.
   *
   * @param leaf true if the node should be a leaf, false otherwise
   */
  public void setLeaf(boolean leaf) {
    isLeaf = leaf;
  }
}
package org.example.internals.datastructures.trees;

public class BNode<T extends Comparable<T>> {
  private T[] data;
  private final BNode<T>[] children;
  private BNode<T> parent;
  private int size;
  private boolean isLeaf;

  @SuppressWarnings("unchecked")
  public BNode(int t){
    this.data = (T[]) new Comparable[2 * t - 1];
    this.children = (BNode<T>[]) new BNode[2 * t];
    this.parent = null;
    this.isLeaf = true;
  }

  public T[] getData() {
    return data;
  }

  public void setData(T[] data) {
    this.data = data;
  }

  public void setData(T data, int idx) {
    this.data[idx] = data;
  }

  public BNode<T>[] getChildren() {
    return children;
  }

  public void setChildren(BNode<T> children, int idx) {
    this.children[idx] = children;
  }

  public BNode<T> getParent() {
    return parent;
  }

  public void setParent(BNode<T> parent) {
    this.parent = parent;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public boolean isLeaf() {
    return isLeaf;
  }

  public void setLeaf(boolean leaf) {
    isLeaf = leaf;
  }
}
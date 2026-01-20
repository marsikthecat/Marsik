package org.example.internals.datastructures.trees;

public class SplayNode<T extends Comparable<T>> {
  private T data;
  private SplayNode<T> left;
  private SplayNode<T> right;
  private SplayNode<T> parent;

  public SplayNode(T data){
    this.data = data;
    this.left = null;
    this.right = null;
    this.parent = null;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public SplayNode<T> getLeft() {
    return left;
  }

  public void setLeft(SplayNode<T> left) {
    this.left = left;
  }

  public SplayNode<T> getRight() {
    return right;
  }

  public void setRight(SplayNode<T> right) {
    this.right = right;
  }

  public SplayNode<T> getParent() {
    return parent;
  }

  public void setParent(SplayNode<T> parent) {
    this.parent = parent;
  }
}
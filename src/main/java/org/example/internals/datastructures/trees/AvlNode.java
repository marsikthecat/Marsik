package org.example.internals.datastructures.trees;

public class AvlNode<T extends Comparable<T>> {

  private T value;
  private int height;
  private AvlNode<T> left;
  private AvlNode<T> right;

  public AvlNode(T value){
    this.value = value;
    this.height = 1;
    this.left = null;
    this.right = null;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public AvlNode<T> getLeft() {
    return left;
  }

  public void setLeft(AvlNode<T> left) {
    this.left = left;
  }

  public AvlNode<T> getRight() {
    return right;
  }

  public void setRight(AvlNode<T> right) {
    this.right = right;
  }
}
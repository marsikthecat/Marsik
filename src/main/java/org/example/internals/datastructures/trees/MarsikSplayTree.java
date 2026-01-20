package org.example.internals.datastructures.trees;

public class MarsikSplayTree<T extends Comparable<T>> {

  private SplayNode<T> root;

  private void leftRotate(SplayNode<T> node){
    SplayNode<T> parent = node.getParent();
    SplayNode<T> left = node.getLeft();
    if (left != null) {
      left.setParent(parent);
    }
    SplayNode<T> node1 = node.getParent().getParent();
    parent.setParent(node);
    node.setParent(node1);
    if (node1 == null) {
      root = node;
    } else {
      if (node1.getLeft() == parent) {
        node1.setLeft(node);
      } else {
        node1.setRight(node);
      }
    }
  }

  private void rightRotate(SplayNode<T> node) {
    SplayNode<T> parent = node.getParent();
    SplayNode<T> right = node.getRight();
    node.setRight(parent);
    parent.setLeft(right);
    if (right != null) {
      right.setParent(parent);
    }
    SplayNode<T> node1 = parent.getRight();
    node.setParent(node1);
    parent.setParent(node);

    if (node1 == null) {
      root = node;
    } else {
      if (node1.getLeft() == parent) {
        node1.setLeft(node);
      } else {
        node1.setRight(node);
      }
    }
  }

  private void splay(SplayNode<T> node) {
    if (node.getParent() == null) {
      root = node;
      return;
    }
    if (node.getParent().getParent() == null) {
      if (node.getParent().getRight() == node) {
        leftRotate(node);
        root = node;
      } else {
        rightRotate(node);
        root = node;
      }
      return;
    }
    if (node.getParent().getRight() == node
            && node.getParent().getParent().getLeft() == node.getParent()) {
      leftRotate(node);
      rightRotate(node);
      splay(node);
      return;
    }
    if (node.getParent().getLeft() == node
            && node.getParent().getParent().getRight() == node.getParent()) {
      rightRotate(node);
      leftRotate(node);
      splay(node);
      return;
    }
    if (node.getParent().getRight() == node
            && node.getParent().getParent().getRight() == node.getParent()) {
      leftRotate(node.getParent());
      leftRotate(node);
      splay(node);
      return;
    }
    if (node.getParent().getLeft() == node
            && node.getParent().getParent().getLeft() == node.getParent()) {
      rightRotate(node.getParent());
      rightRotate(node);
      splay(node);
    }
  }


  public void add(T data) {
    SplayNode<T> node = new SplayNode<>(data);
    if (root == null){
      root = node;
      return;
    }

    SplayNode<T> temp = root;
    while(true){
      if (temp.getData().compareTo(data) > 0) {
        if (temp.getLeft() == null){
          temp.setLeft(node);
          node.setParent(temp);
          splay(node);
          return;
        }
        temp = temp.getLeft();
      }
      if (temp.getData().compareTo(data) < 0) {
        if (temp.getRight() == null) {
          temp.setRight(node);
          node.setParent(temp);
          splay(node);
          return;
        }
        temp = temp.getRight();
      }
    }
  }

  public SplayNode<T> find(T data) {
    if (root == null) {
      return null;
    }
    SplayNode<T> temp = root;
    while (temp != null) {
      if (temp.getData().equals(data)) {
        splay(temp);
        return temp;
      }
      if (temp.getData().compareTo(data) > 0) {
        temp = temp.getLeft();
      } else {
        temp = temp.getRight();
      }
    }
    return null;
  }

  public SplayNode<T> findMin(SplayNode<T> node){
    if (node==null) {
      return null;
    }
    SplayNode<T> min = node;
    while(min.getLeft() != null){
      min = min.getLeft();
    }
    splay(min);
    return min;
  }

  public void delete(T data){
    SplayNode<T> node = find(data);
    if (node==null) {
      return;
    }
    SplayNode<T> min = findMin(node.getRight());
    if (min == null) {
      root = root.getLeft();
      root.setParent(null);
      return;
    }
    root.setLeft(root.getLeft().getLeft());
    if (root.getLeft() != null) {
      root.getLeft().setParent(root);
    }
  }

  private void preOrder(SplayNode<T> node){
    if (node == null) {
      return;
    }
    preOrder(node.getLeft());
    preOrder(node.getRight());
  }

  public void display() {
    preOrder(root);
  }
}
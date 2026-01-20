package org.example.internals.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MarsikBinaryTree<T extends Comparable<T>> {

  private Node<T> root;

  @SafeVarargs
  public MarsikBinaryTree(T... elem) {
    for (T t : elem) {
      insert(t);
    }
  }

  public void insert(T value) {
    root = insertRecursive(root, value);
  }

  private Node<T> insertRecursive(Node<T> current, T value) {
    if (current == null){
      current = new Node<>(value);
      return current;
    }
    if (value.compareTo(current.getValue()) < 0){
      current.setLeftNode(insertRecursive(current.getLeftNode(), value));
    } else {
      current.setRightNode(insertRecursive(current.getRightNode(), value));
    }
    return current;
  }

  public boolean contains(T value) {
    return searchElement(root, value);
  }

  private boolean searchElement(Node<T> current, T value) {
    if (current == null) {
      return false;
    }
    if (current.getValue().equals(value)) {
      return true;
    }
    if (value.compareTo(current.getValue()) < 0) {
      return searchElement(current.getLeftNode(), value);
    } else {
      return searchElement(current.getRightNode(), value);
    }
  }

  public void remove(T value) {
    root = removeRecursive(root, value);
  }

  private Node<T> removeRecursive(Node<T> current, T value) {
    if (current == null) {
      return null;
    }
    int cmp = value.compareTo(current.getValue());
    if (cmp < 0) {
      current.setLeftNode(removeRecursive(current.getLeftNode(), value));
    } else if (cmp > 0) {
      current.setRightNode(removeRecursive(current.getRightNode(), value));
    } else {
      if (current.getLeftNode() == null && current.getRightNode() == null) {
        return null;
      }
      if (current.getLeftNode() == null) {
        return current.getRightNode();
      }
      if (current.getRightNode() == null) {
        return current.getLeftNode();
      }
      T smallestValue = smallestValue(current.getRightNode());
      current.setValue(smallestValue);
      current.setRightNode(removeRecursive(current.getRightNode(), smallestValue));
    }
    return current;
  }

  private T smallestValue(Node<T> root) {
    return root.getLeftNode() == null ? root.getValue() : smallestValue(root.getLeftNode());
  }

  public void printInOrder() {
    inOrder(root);
  }

  private void inOrder(Node<T> node) {
    if (node != null) {
      inOrder(node.getLeftNode());
      System.out.println(" " + node.getValue());
      inOrder(node.getRightNode());
    }
  }

  public void printPreOrder() {
    preOrder(root);
  }

  private void preOrder(Node<T> node) {
    if (node != null) {
      System.out.println(" " + node.getValue());
      preOrder(node.getLeftNode());
      preOrder(node.getRightNode());
    }
  }

  public void printPostOrder() {
    postOrder(root);
  }

  private void postOrder(Node<T> node) {
    if (node != null) {
      postOrder(node.getLeftNode());
      postOrder(node.getRightNode());
      System.out.println(" " + node.getValue());
    }
  }

  public void printLevelOrder() {
    levelOrder();
  }

  private void levelOrder() {
    if (root == null){
      return;
    }
    Queue<Node<T>> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      Node<T> node = nodes.remove();
      System.out.println(" " + node.getValue());
      if (node.getLeftNode() != null){
        nodes.add(node.getLeftNode());
      }
      if (node.getRightNode() != null){
        nodes.add(node.getRightNode());
      }
    }
  }
}
package org.example.internals.datastructures.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementation of a generic Binary Search Tree (BST).
 * This tree stores elements in sorted order according to their natural ordering
 * (elements must implement {@link Comparable}). It supports insertion, deletion,
 * search, and different traversal strategies (in-order, pre-order, post-order,
 * and level-order).
 *
 * @param <T> the type of elements stored in the tree; must implement {@link Comparable}
 */
public class MarsikBinaryTree<T extends Comparable<T>> {

  private Node<T> root;

  /**
   * Constructs a new binary tree and inserts the provided elements.
   *
   * @param elem the initial elements to insert into the tree
   */
  @SafeVarargs
  public MarsikBinaryTree(T... elem) {
    for (T t : elem) {
      insert(t);
    }
  }

  /**
   * Inserts a new value into the tree.
   *
   * @param value the value to insert
   */
  public void insert(T value) {
    root = insertRecursive(root, value);
  }

  /**
   * Recursively inserts a value into the tree starting from the given node.
   *
   * @param current the current node in the traversal
   * @param value   the value to insert
   * @return the updated node after insertion
   */
  private Node<T> insertRecursive(Node<T> current, T value) {
    if (current == null) {
      current = new Node<>(value);
      return current;
    }
    if (value.compareTo(current.getValue()) < 0) {
      current.setLeftNode(insertRecursive(current.getLeftNode(), value));
    } else {
      current.setRightNode(insertRecursive(current.getRightNode(), value));
    }
    return current;
  }

  /**
   * Checks if a value exists in the tree.
   *
   * @param value the value to search for
   * @return true if the value exists, false otherwise
   */
  public boolean contains(T value) {
    return searchElement(root, value);
  }

  /**
   * Recursively searches for a value starting from the given node.
   *
   * @param current the current node in the traversal
   * @param value   the value to search for
   * @return true if the value exists, false otherwise
   */
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

  /**
   * Removes a value from the tree if it exists.
   *
   * @param value the value to remove
   */
  public void remove(T value) {
    root = removeRecursive(root, value);
  }

  /**
   * Recursively removes a value starting from the given node.
   *
   * @param current the current node in the traversal
   * @param value   the value to remove
   * @return the updated node after removal
   */
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

  /**
   * Finds the smallest value in the subtree rooted at the given node.
   *
   * @param root the root of the subtree
   * @return the smallest value
   */
  private T smallestValue(Node<T> root) {
    return root.getLeftNode() == null ? root.getValue() : smallestValue(root.getLeftNode());
  }

  /**
   * Prints the tree in in-order traversal (left, root, right).
   */
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

  /**
   * Prints the tree in pre-order traversal (root, left, right).
   */
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

  /**
   * Prints the tree in post-order traversal (left, right, root).
   */
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

  /**
   * Prints the tree in level-order traversal (breadth-first).
   */
  public void printLevelOrder() {
    levelOrder();
  }

  private void levelOrder() {
    if (root == null) {
      return;
    }
    Queue<Node<T>> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
      Node<T> node = nodes.remove();
      System.out.println(" " + node.getValue());
      if (node.getLeftNode() != null) {
        nodes.add(node.getLeftNode());
      }
      if (node.getRightNode() != null) {
        nodes.add(node.getRightNode());
      }
    }
  }
}
package org.example.internals.datastructures.trees;

/**
 * Implementation of a B-Tree data structure.
 * A B-Tree is a self-balancing search tree in which nodes can have multiple children
 * and multiple keys. It is commonly used in databases and filesystems to maintain
 * sorted data for efficient insertion, deletion, and search operations.
 *
 * @param <T> the type of elements stored in the tree; must implement {@link Comparable}
 */
public class MarsikBtree<T extends Comparable<T>> {

  private Bnode<T> root;

  /**
   * Inserts a value into the given node by shifting existing values to make space.
   * This method is used internally when inserting a key into a node that is not full.
   *
   * @param node the node to insert the value into
   * @param data the value to insert
   */
  private void insertData(Bnode<T> node, T data) {
    int index = node.getSize();
    for (int i = node.getSize() - 1; i > -1; i--) {
      T d = node.getData()[i];
      if (data.compareTo(d) < 0) {
        node.setData(node.getData()[i], i + 1);;
        index = i;
      } else {
        break;
      }
    }
    node.setData(data, index);
    node.setSize(node.getSize() + 1);
  }

  /**
   * Splits a node that has reached its maximum capacity.
   * The middle key is promoted to the parent node, and the node is divided into two child nodes.
   * If the node has no parent (i.e., it is the root), a new root is created.
   *
   * @param node the node to split
   * @param key the key being inserted, used to determine which child to return
   * @return the child node into which the new key should be inserted
   */
  @SuppressWarnings("unchecked")
  private Bnode<T> splitNode(Bnode<T> node, T key) {
    int mid = node.getSize() / 2;
    int t = 3;
    Bnode<T> node1 = new Bnode<>(t);
    Bnode<T> node2 = new Bnode<>(t);

    for (int i = 0; i < mid; i++) {
      node1.setData(node.getData()[i], i);
      node1.setChildren(node.getChildren()[i], i);
      node1.setSize(node1.getSize() + 1);
    }
    node1.setChildren(node.getChildren()[mid], mid);
    int j = 0;
    for (int i = mid + 1; i < node.getSize(); i++) {
      node2.setData(node.getData()[i], j);
      node2.setChildren(node.getChildren()[i], j);
      node2.setSize(node2.getSize() + 1);
      j++;
    }
    node2.setChildren(node.getChildren()[node.getSize()], mid);

    node1.setLeaf(node.isLeaf());
    node2.setLeaf(node.isLeaf());

    Bnode<T> parent = node.getParent();
    if (parent == null) {
      T temp = node.getData()[mid];
      node.setData((T[]) new Comparable[2 * t - 1]);
      node.setData(temp, 0);
      node.setSize(1);
      node.setLeaf(false);
      node.setChildren(node1, 0);
      node.setChildren(node2, 1);
      node1.setParent(node);
      node2.setParent(node);

      return key.compareTo(temp) > 0 ? node2 : node1;
    }
    int index = parent.getSize();
    T data = node.getData()[mid];
    for (int i = parent.getSize() - 1; i > -1; i--) {
      if (data.compareTo(parent.getData()[i]) < 0) {
        parent.setData(parent.getData()[i], i + 1);
        parent.setChildren(parent.getChildren()[i + 1], i + 2);
        index = i;
      } else {
        break;
      }
    }
    parent.setData(data, index);
    parent.setChildren(node1, index);
    parent.setChildren(node2, index + 1);
    parent.setSize(parent.getSize() + 1);
    node1.setParent(parent);
    node2.setParent(parent);
    return key.compareTo(data) > 0 ? node2 : node1;
  }

  /**
   * Displays the B-Tree structure starting from the specified node.
   * Uses a recursive approach to print each node's level and its stored keys.
   * Leaf nodes are printed last.
   *
   * @param node  the node to start displaying from (usually root)
   * @param level the current tree level (root level is 0)
   */
  public void display(Bnode<T> node, int level) {
    if (node == null) {
      return;
    }
    System.out.println("Level : " + level + " " + "Data : ");
    for (int i = 0; i < node.getSize(); i++) {
      System.out.println(node.getData()[i] + " ");
    }
    System.out.println(" ");
    if (node.isLeaf()) {
      return;
    }
    for (int i = 0; i < node.getSize() + 1; i++) {
      display(node.getChildren()[i], level + 1);
    }
  }
}
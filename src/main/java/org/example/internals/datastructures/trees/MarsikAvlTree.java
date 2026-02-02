package org.example.internals.datastructures.trees;

/**
 * Implementation of a generic AVL Tree (self-balancing binary search tree).
 * This AVL tree maintains a balance factor for every node to ensure that the
 * tree remains approximately balanced, which guarantees O(log n) time complexity
 * for insertion, deletion, and search operations.
 *
 * @param <T> the type of elements stored in the AVL tree; must implement {@link Comparable}
 */
public class MarsikAvlTree<T extends Comparable<T>>  {

  /**
   * Returns the height of a given node.
   *
   * @param avlNode the node to get the height for
   * @return the height of the node, or 0 if the node is null
   */
  public int getHeightOfNode(AvlNode<T> avlNode) {
    return avlNode == null ? 0 : avlNode.getHeight();
  }

  /**
   * Calculates the balance factor of a node.
   * Balance factor is defined as: height(right subtree) - height(left subtree).
   *
   * @param avlNode the node to calculate the balance for
   * @return the balance factor of the node
   */
  public int balance(AvlNode<T> avlNode) {
    return avlNode == null ? 0
            : getHeightOfNode(avlNode.getRight()) - getHeightOfNode(avlNode.getLeft());
  }

  /**
   * Updates the height of a given node based on its children's heights.
   *
   * @param avlNode the node whose height is to be updated
   */
  public void updateHeight(AvlNode<T> avlNode) {
    int heightOfLeft = getHeightOfNode(avlNode.getLeft());
    int heightOfRight = getHeightOfNode(avlNode.getRight());
    avlNode.setHeight(Math.max(heightOfLeft, heightOfRight) + 1);
  }

  /**
   * Performs a left rotation on the given node.
   *
   * @param avlNode the node to rotate
   * @return the new root of the rotated subtree
   */
  public AvlNode<T> rotateLeft(AvlNode<T> avlNode) {
    AvlNode<T> n1 = avlNode.getRight();
    AvlNode<T> n2 = n1.getLeft();

    n1.setLeft(avlNode);
    avlNode.setRight(n2);

    updateHeight(avlNode);
    updateHeight(n1);

    return n1;
  }

  /**
   * Performs a right rotation on the given node.
   *
   * @param avlNode the node to rotate
   * @return the new root of the rotated subtree
   */
  public AvlNode<T> rotateRight(AvlNode<T> avlNode) {
    AvlNode<T> n1 = avlNode.getLeft();
    AvlNode<T> n2 = n1.getRight();

    n1.setRight(avlNode);
    avlNode.setLeft(n2);

    updateHeight(avlNode);
    updateHeight(n1);

    return n1;
  }

  /**
   * Balances a subtree rooted at the given node, performing rotations if needed.
   *
   * @param root the root of the subtree
   * @return the new root after balancing
   */
  public AvlNode<T> bringTreeToBalance(AvlNode<T> root) {
    updateHeight(root);
    int balance = balance(root);
    if (balance > 1) {
      if (balance(root.getRight()) < 0) {
        root.setRight(rotateRight(root.getRight()));
      }
      return rotateLeft(root);
    }
    if (balance < -1) {
      if (balance(root.getLeft()) > 0) {
        root.setLeft(rotateLeft(root.getLeft()));
      }
      return rotateRight(root);
    }
    return root;
  }

  /**
   * Inserts a new key into the AVL tree using standard BST insertion, then balances the tree.
   *
   * @param root the root of the subtree
   * @param key  the value to insert
   * @return the new root of the subtree after insertion and balancing
   */
  public AvlNode<T> bstInsert(AvlNode<T> root, T key) {
    if (root == null) {
      return new AvlNode<>(key);
    } else if (key.compareTo(root.getValue()) < 0) {
      root.setLeft(bstInsert(root.getLeft(), key));
    } else {
      root.setRight(bstInsert(root.getRight(), key));
    }
    return bringTreeToBalance(root);
  }

  /**
   * Finds the in-order successor of a node (smallest node in the given subtree).
   *
   * @param root the subtree to find the successor in
   * @return the successor node
   */
  public AvlNode<T> successor(AvlNode<T> root) {
    return root.getLeft() == null ? root : successor(root.getLeft());
  }

  AvlNode<T> root;

  /**
   * Removes a key from the AVL tree and rebalances the tree.
   *
   * @param root the root of the subtree
   * @param key  the value to remove
   * @return the new root of the subtree after deletion
   */
  public AvlNode<T> remove(AvlNode<T> root, T key) {
    if (root == null) {
      return null;
    } else if (key.compareTo(root.getValue()) < 0) {
      root.setLeft(remove(root.getLeft(), key));
    } else if (key.compareTo(root.getValue()) > 0) {
      root.setRight(remove(root.getRight(), key));
    } else {
      if (root.getRight() == null) {
        root = root.getLeft();
      } else if (root.getLeft() == null) {
        root = root.getRight();
      } else {
        AvlNode<T> n = successor(root.getRight());
        root.setValue(n.getValue());
        root.setRight(remove(root.getRight(), root.getValue()));
      }
    }
    if (root == null) {
      return null;
    } else {
      return bringTreeToBalance(root);
    }
  }

  /**
   * Searches for a node containing the given key.
   *
   * @param root the root of the subtree
   * @param key  the value to search for
   * @return the node containing the key, or null if not found
   */
  public AvlNode<T> findNode(AvlNode<T> root, T key) {
    if (root == null || key.equals(root.getValue())) {
      return root;
    }
    return key.compareTo(root.getValue()) < 0
            ? findNode(root.getLeft(), key) : findNode(root.getRight(), key);
  }

  /**
   * Adds a key to the AVL tree if it does not already exist.
   *
   * @param key the value to add
   * @return true if the key was added, false if it already existed
   */
  public boolean add(T key) {
    if (findNode(root, key) == null) {
      root = bstInsert(root, key);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks if a key exists in the AVL tree.
   *
   * @param key the value to check
   * @return true if the key exists, false otherwise
   */
  public boolean contains(T key) {
    return findNode(root, key) != null;
  }

  /**
   * Deletes a key from the AVL tree.
   *
   * @param key the value to delete
   * @return true if the key was deleted, false if it was not found
   */
  public boolean delete(T key) {
    if (findNode(root, key) != null) {
      root = remove(root, key);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Prints the tree in in-order traversal (left, root, right).
   *
   * @param root the root node to start traversal from
   */
  public void printInOrder(AvlNode<T> root) {
    if (root == null) {
      System.out.println("Tree does not have any nodes");
      return;
    }
    if (root.getLeft() != null) {
      printInOrder(root.getLeft());
    }
    System.out.println(root.getValue() + " ");
    if (root.getRight() != null) {
      printInOrder(root.getRight());
    }
  }

  /**
   * Prints the tree in pre-order traversal (root, left, right).
   *
   * @param root the root node to start traversal from
   */
  public void printPreOrder(AvlNode<T> root) {
    if (root == null) {
      System.out.println("Tree does not have any nodes");
      return;
    }
    System.out.println(root.getValue() + " ");
    if (root.getLeft() != null) {
      printPreOrder(root.getLeft());
    }
    if (root.getRight() != null) {
      printPreOrder(root.getRight());
    }
  }

  /**
   * Prints the tree in post-order traversal (left, right, root).
   *
   * @param root the root node to start traversal from
   */
  public void printPostOrder(AvlNode<T> root) {
    if (root == null) {
      System.out.println("No nodes in the tree");
      return;
    }
    if (root.getLeft() != null) {
      printPostOrder(root.getLeft());
    }
    if (root.getRight() != null) {
      printPostOrder(root.getRight());
    }
    System.out.println(root.getValue() + " ");
  }

  /**
   * For tests
   */
  public AvlNode<T> getRoot() {
    return root;
  }
}
package org.example.internals.datastructures.trees;

public class MarsikAVLTree<T extends Comparable<T>>  {

  public int getHeightOfNode(AvlNode<T> avlNode) {
    return avlNode == null ? 0 : avlNode.getHeight();
  }

  public int balance(AvlNode<T> avlNode) {
    return avlNode == null ? 0
            : getHeightOfNode(avlNode.getRight()) - getHeightOfNode(avlNode.getLeft());
  }

  public void updateHeight(AvlNode<T> avlNode) {
    int heightOfLeft = getHeightOfNode(avlNode.getLeft());
    int heightOfRight = getHeightOfNode(avlNode.getRight());
    avlNode.setHeight(Math.max(heightOfLeft, heightOfRight));
  }

  public AvlNode<T> rotateLeft(AvlNode<T> avlNode) {
    AvlNode<T> n1 = avlNode.getRight();
    AvlNode<T> n2 = n1.getLeft();

    n1.setLeft(avlNode);
    avlNode.setRight(n2);

    updateHeight(avlNode);
    updateHeight(n1);

    return n1;
  }

  public AvlNode<T> rotateRight(AvlNode<T> avlNode) {
    AvlNode<T> n1 = avlNode.getLeft();
    AvlNode<T> n2 = n1.getRight();

    n1.setRight(avlNode);
    avlNode.setLeft(n2);

    updateHeight(avlNode);
    updateHeight(n1);

    return n1;
  }

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

  public AvlNode<T> BSTInsert(AvlNode<T> root, T key) {
    if (root == null) {
      return new AvlNode<>(key);
    }
    else if (key.compareTo(root.getValue()) < 0) {
      root.setLeft(BSTInsert(root.getLeft(), key));
    } else {
      root.setRight(BSTInsert(root.getRight(), key));
    }
    return bringTreeToBalance(root);
  }

  public AvlNode<T> successor(AvlNode<T> root) {
    return root.getLeft() == null ? root : successor(root.getLeft());
  }

  AvlNode<T> root;

  public AvlNode<T> remove(AvlNode<T> root, T key) {
    if (root == null) {
      return root;
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
      return root;
    } else {
      return bringTreeToBalance(root);
    }
  }

  public AvlNode<T> findNode(AvlNode<T> root, T key) {
    if (root == null || key.equals(root.getValue())) {
      return root;
    }
    return key.compareTo(root.getValue()) < 0
            ? findNode(root.getLeft(), key) : findNode(root.getRight(), key);
  }

  public boolean add(T key) {
    if (findNode(root , key) == null) {
      root = BSTInsert(root , key);
      return true;
    } else {
      return false;
    }
  }

  public boolean contains(T key) {
    return findNode(root, key) == null;
  }

  public boolean delete(T key) {
    if (findNode(root , key) != null) {
      root = remove(root , key);
      return true;
    } else
      return false;
  }

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

  public void printPreOrder(AvlNode<T> root) {
    if (root == null) {
      System.out.println("Tree does not have any nodes");
      return;
    }
    System.out.println(root.getValue() + " ");
    if(root.getLeft() != null) {
      printPreOrder(root.getLeft());
    }
    if (root.getRight() != null) {
      printPreOrder(root.getRight());
    }
  }

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
}
package datastructureTests.trees;

import org.example.internals.datastructures.trees.AvlNode;
import org.example.internals.datastructures.trees.MarsikAvlTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMarsikAvlTree {

  @Test
  void testAddAndContains() {
    MarsikAvlTree<Integer> tree = new MarsikAvlTree<>();

    assertTrue(tree.add(10));
    assertTrue(tree.add(5));
    assertTrue(tree.add(15));

    assertTrue(tree.contains(10));
    assertTrue(tree.contains(5));
    assertTrue(tree.contains(15));

    assertFalse(tree.add(10));
  }

  @Test
  void testSingleRightRotation() {
    MarsikAvlTree<Integer> tree = new MarsikAvlTree<>();

    tree.add(30);
    tree.add(20);
    tree.add(10); // -> Right rotation

    assertEquals(20, tree.getRoot().getValue());
    assertEquals(10, tree.getRoot().getLeft().getValue());
    assertEquals(30, tree.getRoot().getRight().getValue());
  }

  @Test
  void testSingleLeftRotation() {
    MarsikAvlTree<Integer> tree = new MarsikAvlTree<>();

    tree.add(10);
    tree.add(20);
    tree.add(30); // -> Left rotation

    assertEquals(20, tree.getRoot().getValue());
    assertEquals(10, tree.getRoot().getLeft().getValue());
    assertEquals(30, tree.getRoot().getRight().getValue());
  }

  @Test
  void testLeftRightRotation() {
    MarsikAvlTree<Integer> tree = new MarsikAvlTree<>();

    tree.add(30);
    tree.add(10);
    tree.add(20); // LR rotation

    assertEquals(20, tree.getRoot().getValue());
    assertEquals(10, tree.getRoot().getLeft().getValue());
    assertEquals(30, tree.getRoot().getRight().getValue());
  }

  @Test
  void testRightLeftRotation() {
    MarsikAvlTree<Integer> tree = new MarsikAvlTree<>();

    tree.add(10);
    tree.add(30);
    tree.add(20); // RL rotation

    assertEquals(20, tree.getRoot().getValue());
    assertEquals(10, tree.getRoot().getLeft().getValue());
    assertEquals(30, tree.getRoot().getRight().getValue());
  }

  @Test
  void testDeleteLeaf() {
    MarsikAvlTree<Integer> tree = new MarsikAvlTree<>();
    tree.add(20);
    tree.add(10);
    tree.add(30);

    assertTrue(tree.delete(10));
    assertNull(tree.findNode(tree.getRoot(), 10));
  }

  @Test
  void testDeleteNodeWithOneChild() {
    MarsikAvlTree<Integer> tree = new MarsikAvlTree<>();
    tree.add(20);
    tree.add(10);
    tree.add(5);

    assertTrue(tree.delete(10));
    assertEquals(5, tree.getRoot().getLeft().getValue());
  }

  @Test
  void testDeleteNodeWithTwoChildren() {
    MarsikAvlTree<Integer> tree = new MarsikAvlTree<>();
    tree.add(20);
    tree.add(10);
    tree.add(30);
    tree.add(25);
    tree.add(40);

    assertTrue(tree.delete(30));

    assertNull(tree.findNode(tree.getRoot(), 30));
    assertTrue(isBalanced(tree.getRoot(), tree));
  }

  @Test
  void testTreeAlwaysBalancedAfterManyInserts() {
    MarsikAvlTree<Integer> tree = new MarsikAvlTree<>();

    for (int i = 1; i <= 100; i++) {
      tree.add(i);
    }

    assertTrue(isBalanced(tree.getRoot(), tree));
  }

  // 🔧 Helper
  private boolean isBalanced(AvlNode<Integer> node, MarsikAvlTree<Integer> tree) {
    if (node == null) return true;

    int balance = Math.abs(tree.balance(node));
    if (balance > 1) return false;

    return isBalanced(node.getLeft(), tree)
            && isBalanced(node.getRight(), tree);
  }
}

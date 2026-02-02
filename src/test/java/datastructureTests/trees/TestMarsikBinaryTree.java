package datastructureTests.trees;

import org.example.internals.datastructures.trees.MarsikBinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestMarsikBinaryTree {

  private MarsikBinaryTree<Integer> tree;

  @BeforeEach
  void setUp() {
    tree = new MarsikBinaryTree<>();
  }

  @Test
  void insertAndContains_singleElement() {
    tree.insert(10);

    assertTrue(tree.contains(10));
    assertFalse(tree.contains(5));
  }

  @Test
  void insert_multipleElements() {
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(3);
    tree.insert(7);

    assertTrue(tree.contains(10));
    assertTrue(tree.contains(5));
    assertTrue(tree.contains(15));
    assertTrue(tree.contains(3));
    assertTrue(tree.contains(7));
    assertFalse(tree.contains(99));
  }

  @Test
  void constructor_insertsElements() {
    MarsikBinaryTree<Integer> tree =
            new MarsikBinaryTree<>(10, 5, 15, 3, 7);

    assertTrue(tree.contains(10));
    assertTrue(tree.contains(3));
    assertTrue(tree.contains(15));
  }

  @Test
  void remove_leafNode() {
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);

    tree.remove(5);

    assertFalse(tree.contains(5));
    assertTrue(tree.contains(10));
    assertTrue(tree.contains(15));
  }

  @Test
  void remove_nodeWithOneChild() {
    tree.insert(10);
    tree.insert(5);
    tree.insert(2);

    tree.remove(5);

    assertFalse(tree.contains(5));
    assertTrue(tree.contains(2));
    assertTrue(tree.contains(10));
  }

  @Test
  void remove_nodeWithTwoChildren() {
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(12);
    tree.insert(18);

    tree.remove(15);

    assertFalse(tree.contains(15));
    assertTrue(tree.contains(12));
    assertTrue(tree.contains(18));
    assertTrue(tree.contains(10));
  }

  @Test
  void remove_rootNode() {
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);

    tree.remove(10);

    assertFalse(tree.contains(10));
    assertTrue(tree.contains(5));
    assertTrue(tree.contains(15));
  }

  @Test
  void remove_nonExistingElement() {
    tree.insert(10);
    tree.remove(42);

    assertTrue(tree.contains(10));
  }

  @Test
  void contains_onEmptyTree() {
    assertFalse(tree.contains(1));
  }
}
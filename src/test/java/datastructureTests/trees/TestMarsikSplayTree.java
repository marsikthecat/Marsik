package datastructureTests.trees;

import org.example.internals.datastructures.trees.MarsikSplayTree;
import org.example.internals.datastructures.trees.SplayNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMarsikSplayTree {

  private MarsikSplayTree<Integer> tree;

  @BeforeEach
  void setup() {
    tree = new MarsikSplayTree<>();
  }

  @Test
  void add_singleElement_becomesRoot() {
    tree.add(10);
    assertEquals(10, tree.find(10).getData());
  }

  @Test
  void add_multipleElements_lastInsertedIsRoot() {
    tree.add(10);
    tree.add(5);
    tree.add(20);

    assertEquals(20, tree.find(20).getData());
  }

  @Test
  void find_splaysNodeToRoot() {
    tree.add(10);
    tree.add(5);
    tree.add(20);
    tree.add(1);

    tree.find(5);

    assertEquals(5, tree.find(5).getData());
  }

  @Test
  void find_nonExisting_returnsNull() {
    tree.add(10);
    tree.add(5);
    tree.add(20);

    assertNull(tree.find(99));
  }

  @Test
  void zigRotation_rightChild() {
    tree.add(10);
    tree.add(20);

    assertEquals(20, tree.find(20).getData());
  }

  @Test
  void zigRotation_leftChild() {
    tree.add(20);
    tree.add(10);

    assertEquals(10, tree.find(10).getData());
  }

  @Test
  void zigZig_rightRight() {
    tree.add(10);
    tree.add(20);
    tree.add(30);

    assertEquals(30, tree.find(30).getData());
  }

  @Test
  void zigZag_leftRight() {
    tree.add(30);
    tree.add(10);
    tree.add(20);

    assertEquals(20, tree.find(20).getData());
  }

  @Test
  void findMin_splaysMinimumToRoot() {
    tree.add(10);
    tree.add(5);
    tree.add(20);
    tree.add(1);

    SplayNode<Integer> min = tree.findMin(tree.find(10));

    assertEquals(1, min.getData());
  }

  @Test
  void delete_leafNode() {
    tree.add(10);
    tree.add(5);
    tree.add(20);

    tree.delete(5);

    assertNull(tree.find(5));
  }

  @Test
  void delete_rootNode() {
    tree.add(10);
    tree.add(5);
    tree.add(20);

    tree.delete(10);

    assertNull(tree.find(10));
  }

  @Test
  void delete_nonExisting_doesNotCrash() {
    tree.add(10);
    tree.add(5);

    assertDoesNotThrow(() -> tree.delete(99));
  }

  @Test
  void repeatedAccess_movesNodeToRoot() {
    tree.add(10);
    tree.add(5);
    tree.add(20);
    tree.add(15);

    tree.find(5);
    tree.find(5);
    tree.find(5);

    assertEquals(5, tree.find(5).getData());
  }
}
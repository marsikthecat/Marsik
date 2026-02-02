package datastructureTests.graphs;

import org.example.internals.datastructures.graphs.MarsikGraph;
import org.example.internals.math.Matrix;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestMarsikGraph {

  @Test
  void addVertex_doesNotDuplicate() {
    MarsikGraph<String> g = new MarsikGraph<>();

    g.addVertex("A");
    g.addVertex("A");

    assertEquals(1, g.numberOfVertexes());
    assertTrue(g.getNeighbourVertexes("A").isEmpty());
  }

  @Test
  void removeVertex_removesIncomingEdges() {
    MarsikGraph<String> g = new MarsikGraph<>();
    g.addVertex("A");
    g.addVertex("B");
    g.addVertex("C");

    g.addEdge("A", "B");
    g.addEdge("C", "B");

    g.removeVertex("B");

    assertEquals(2, g.numberOfVertexes());
    assertFalse(g.getNeighbourVertexes("A").contains("B"));
    assertFalse(g.getNeighbourVertexes("C").contains("B"));
  }

  @Test
  void addEdge_throwsIfVertexMissing() {
    MarsikGraph<Integer> g = new MarsikGraph<>();
    g.addVertex(1);

    assertThrows(NoSuchElementException.class, () -> g.addEdge(1, 2));
  }

  @Test
  void removeEdge_doesNotCrashIfMissing() {
    MarsikGraph<String> g = new MarsikGraph<>();
    g.addVertex("A");
    g.addVertex("B");

    assertDoesNotThrow(() -> g.removeEdge("A", "B"));
    assertEquals(0, g.numberOfEdges());
  }

  @Test
  void numberOfEdges_countsDirectedEdges() {
    MarsikGraph<String> g = new MarsikGraph<>();
    g.addVertex("A");
    g.addVertex("B");

    g.addEdge("A", "B");
    g.addEdge("B", "A");

    assertEquals(2, g.numberOfEdges());
  }

  @Test
  void depthFirstTraversal_orderIsCorrect() {
    MarsikGraph<String> g = new MarsikGraph<>();
    g.addVertex("A");
    g.addVertex("B");
    g.addVertex("C");
    g.addVertex("D");

    g.addEdge("A", "B");
    g.addEdge("A", "C");
    g.addEdge("B", "D");

    Set<String> dfs = g.depthFirstTraversal("A");

    assertEquals(List.of("A", "C", "B", "D"), new ArrayList<>(dfs));
  }

  @Test
  void breadthFirstTraversal_orderIsCorrect() {
    MarsikGraph<String> g = new MarsikGraph<>();
    g.addVertex("A");
    g.addVertex("B");
    g.addVertex("C");
    g.addVertex("D");

    g.addEdge("A", "B");
    g.addEdge("A", "C");
    g.addEdge("B", "D");

    Set<String> bfs = g.breadthFirstTraversal("A");

    assertEquals(List.of("A", "B", "C", "D"), new ArrayList<>(bfs));
  }

  @Test
  void traversal_throwsIfRootMissing() {
    MarsikGraph<Integer> g = new MarsikGraph<>();

    assertThrows(NoSuchElementException.class, () -> g.depthFirstTraversal(1));
    assertThrows(NoSuchElementException.class, () -> g.breadthFirstTraversal(1));
  }

  @Test
  void getNeighbourVertexes_returnsLiveSet_bugExposure() {
    MarsikGraph<String> g = new MarsikGraph<>();
    g.addVertex("A");
    g.addVertex("B");

    Set<String> neighbors = g.getNeighbourVertexes("A");
    neighbors.add("B");

    assertEquals(1, g.numberOfEdges(), "External modification leaks into graph (probably unintended)");
  }

  @Test
  void adjacencyMatrix_basicDirectedGraph() {
    MarsikGraph<String> g = new MarsikGraph<>();
    g.addVertex("A");
    g.addVertex("B");
    g.addVertex("C");

    g.addEdge("A", "B");
    g.addEdge("C", "A");

    List<String> order = List.of("A", "B", "C");
    Matrix m = g.adjacencyMatrix(order);

    assertEquals(1, m.getNumber(0, 1)); // A -> B
    assertEquals(0, m.getNumber(1, 0)); // B -> A
    assertEquals(1, m.getNumber(2, 0)); // C -> A
  }

  @Test
  void printAdjacencyList_containsAllVertices() {
    MarsikGraph<String> g = new MarsikGraph<>();
    g.addVertex("X");
    g.addVertex("Y");

    String out = g.printAdjacencyList();

    assertTrue(out.contains("X"));
    assertTrue(out.contains("Y"));
  }
}

package datastructureTests.graphs;

import org.example.internals.datastructures.graphs.MarsikWeightedGraph;
import org.example.internals.datastructures.graphs.Vertex;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TestMarsikWeightedGraph {

  @Test
  void newGraph_isEmpty() {
    MarsikWeightedGraph<Integer> g = new MarsikWeightedGraph<>();

    assertTrue(g.isEmpty());
    assertEquals(0, g.numberOfVertexes());
    assertEquals(0, g.numberOfEdges());
  }

  @Test
  void addVertex_addsOnlyOnce() {
    MarsikWeightedGraph<Integer> g = new MarsikWeightedGraph<>();
    Vertex<Integer> v = new Vertex<>(1);

    g.addVertex(v);
    g.addVertex(v);

    assertEquals(1, g.numberOfVertexes());
    assertEquals(0, g.numberOfEdges());
  }

  @Test
  void removeVertex_removesIncomingEdges() {
    MarsikWeightedGraph<Integer> g = new MarsikWeightedGraph<>();
    Vertex<Integer> a = new Vertex<>(1);
    Vertex<Integer> b = new Vertex<>(2);

    g.addVertex(a);
    g.addVertex(b);

    g.addWeightedEdge(a, b, 5);

    assertEquals(1, g.numberOfEdges());

    g.removeVertex(b);

    assertEquals(1, g.numberOfVertexes());
    assertEquals(0, g.numberOfEdges());
  }

  @Test
  void addWeightedEdge_throwsIfVertexMissing() {
    MarsikWeightedGraph<Integer> g = new MarsikWeightedGraph<>();
    Vertex<Integer> a = new Vertex<>(1);
    Vertex<Integer> b = new Vertex<>(2);

    g.addVertex(a);

    assertThrows(NoSuchElementException.class, () -> g.addWeightedEdge(a, b, 10));
  }

  @Test
  void addWeightedEdge_addsEdgeCorrectly() {
    MarsikWeightedGraph<Integer> g = new MarsikWeightedGraph<>();
    Vertex<Integer> a = new Vertex<>(1);
    Vertex<Integer> b = new Vertex<>(2);

    g.addVertex(a);
    g.addVertex(b);

    g.addWeightedEdge(a, b, 3);

    assertEquals(1, g.numberOfEdges());
  }

  @Test
  void removeWeightedEdge_removesExactEdge() {
    MarsikWeightedGraph<Integer> g = new MarsikWeightedGraph<>();
    Vertex<Integer> a = new Vertex<>(1);
    Vertex<Integer> b = new Vertex<>(2);

    g.addVertex(a);
    g.addVertex(b);

    g.addWeightedEdge(a, b, 5);
    g.addWeightedEdge(a, b, 10);

    assertEquals(2, g.numberOfEdges());

    g.removeWeightedEdge(a, b, 5);

    assertEquals(1, g.numberOfEdges());
  }

  @Test
  void removeWeightedEdge_nonExistingDoesNothing() {
    MarsikWeightedGraph<Integer> g = new MarsikWeightedGraph<>();
    Vertex<Integer> a = new Vertex<>(1);
    Vertex<Integer> b = new Vertex<>(2);

    g.addVertex(a);
    g.addVertex(b);

    assertDoesNotThrow(() -> g.removeWeightedEdge(a, b, 42));
  }

  @Test
  void numberOfEdges_countsAcrossAllVertices() {
    MarsikWeightedGraph<Integer> g = new MarsikWeightedGraph<>();
    Vertex<Integer> a = new Vertex<>(1);
    Vertex<Integer> b = new Vertex<>(2);
    Vertex<Integer> c = new Vertex<>(3);

    g.addVertex(a);
    g.addVertex(b);
    g.addVertex(c);

    g.addWeightedEdge(a, b, 1);
    g.addWeightedEdge(a, c, 2);
    g.addWeightedEdge(b, c, 3);

    assertEquals(3, g.numberOfEdges());
  }

  @Test
  void graph_allowsParallelEdgesWithDifferentWeights() {
    MarsikWeightedGraph<Integer> g = new MarsikWeightedGraph<>();
    Vertex<Integer> a = new Vertex<>(1);
    Vertex<Integer> b = new Vertex<>(2);

    g.addVertex(a);
    g.addVertex(b);

    g.addWeightedEdge(a, b, 1);
    g.addWeightedEdge(a, b, 2);
    g.addWeightedEdge(a, b, 3);

    assertEquals(3, g.numberOfEdges());
  }
}
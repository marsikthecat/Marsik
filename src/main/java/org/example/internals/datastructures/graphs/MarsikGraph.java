package org.example.internals.datastructures.graphs;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import org.example.internals.math.Matrix;

/**
 * Represents a directed graph where vertices are of generic type {@code T}.
 * The graph uses an adjacency list representation internally, stored as a {@link HashMap}
 * from vertices to their set of neighbors.
 *
 * @param <T> the type of elements stored as vertices in the graph
 */
public class MarsikGraph<T> {

  private final HashMap<T, Set<T>> map = new HashMap<>();

  /**
   * Adds a vertex to the graph.
   * If the vertex already exists, this method does nothing.
   *
   * @param elem the element to add as a vertex
   */
  public void addVertex(T elem) {
    map.putIfAbsent(elem, new HashSet<>());
  }

  /**
   * Removes a vertex from the graph, along with any edges pointing to it.
   *
   * @param elem the vertex to remove
   */
  public void removeVertex(T elem) {
    map.remove(elem);
    for (Set<T> neighbors : map.values()) {
      neighbors.remove(elem);
    }
  }

  /**
   * Adds a directed edge from {@code source} to {@code destination}.
   *
   * @param source the source vertex
   * @param destination the destination vertex
   * @throws NoSuchElementException if either vertex does not exist in the graph
   */
  public void addEdge(T source, T destination) {
    if (!map.containsKey(source) || !map.containsKey(destination)) {
      throw new NoSuchElementException("At least one Element is not in the graph, bro");
    }
    map.get(source).add(destination);
  }

  /**
   * Removes the directed edge from {@code source} to {@code destination}.
   *
   * @param source the source vertex
   * @param destination the destination vertex
   */
  public void removeEdge(T source, T destination) {
    map.get(source).remove(destination);
  }

  /**
   * Returns the number of vertices in the graph.
   *
   * @return the vertex count
   */
  public int numberOfVertexes() {
    return map.size();
  }

  /**
   * Returns the total number of edges in the graph.
   *
   * @return the edge count
   */
  public int numberOfEdges() {
    int count = 0;
    for (Set<T> v : map.values()) {
      count += v.size();
    }
    return count;
  }

  /**
   * Checks if the graph contains no vertices.
   *
   * @return {@code true} if the graph is empty, {@code false} otherwise
   */
  public boolean isEmpty() {
    return map.isEmpty();
  }

  /**
   * Returns the set of neighbor vertices for a given vertex.
   *
   * @param value the vertex whose neighbors are requested
   * @return a set of neighboring vertices
   * @throws NoSuchElementException if the vertex does not exist in the graph
   */
  public Set<T> getNeighbourVertexes(T value) {
    if (!map.containsKey(value))  {
      throw new NoSuchElementException("Element " + value + " is not in the graph, bro");
    }
    return map.get(value);
  }

  /**
   * Performs a depth-first traversal starting from the given root vertex.
   *
   * @param rootElement the starting vertex
   * @return a set of visited vertices in DFS order
   * @throws NoSuchElementException if the starting vertex does not exist
   */
  public Set<T> depthFirstTraversal(T rootElement) {
    if (!map.containsKey(rootElement)) {
      throw new NoSuchElementException("Element " + rootElement + " does not exist, bro");
    }
    Set<T> visited = new LinkedHashSet<>();
    Stack<T> stack = new Stack<>();
    stack.push(rootElement);
    while (!stack.isEmpty()) {
      T vertex = stack.pop();
      if (!visited.contains(vertex)) {
        visited.add(vertex);
        for (T v : getNeighbourVertexes(vertex)) {
          stack.push(v);
        }
      }
    }
    return visited;
  }

  /**
   * Performs a breadth-first traversal starting from the given root vertex.
   *
   * @param rootElement the starting vertex
   * @return a set of visited vertices in BFS order
   * @throws NoSuchElementException if the starting vertex does not exist
   */
  public Set<T> breadthFirstTraversal(T rootElement) {
    if (!map.containsKey(rootElement)) {
      throw new NoSuchElementException("Element " + rootElement + " does not exist, bro");
    }
    Set<T> visited = new LinkedHashSet<>();
    Queue<T> queue = new LinkedList<>();
    queue.add(rootElement);
    visited.add(rootElement);
    while (!queue.isEmpty()) {
      T vertex = queue.poll();
      for (T v : getNeighbourVertexes(vertex)) {
        if (!visited.contains(v)) {
          visited.add(v);
          queue.add(v);
        }
      }
    }
    return visited;
  }

  /**
   * Returns a string representation of the adjacency list of the graph.
   *
   * @return the adjacency list as a formatted string
   */
  public String printAdjacencyList() {
    StringBuilder builder = new StringBuilder();
    for (T v : map.keySet()) {
      builder.append(v.toString()).append(": ");
      for (T neighbors : map.get(v)) {
        builder.append(neighbors.toString()).append(" ");
      }
      builder.append("\n");
    }
    return (builder.toString());
  }

  /**
   * Returns the adjacency matrix for the graph given an ordered list of vertices.
   * Each cell [i][j] is 1 if there is an edge from vertices.get(i) to vertices.get(j), 0 otherwise.
   *
   * @param vertices the list of vertices defining the order of rows and columns
   * @return a 2D Matrix representing the adjacency matrix
   */
  public Matrix adjacencyMatrix(List<T> vertices) {
    int n = vertices.size();
    org.example.internals.math.Matrix matrix = new Matrix(n, n);
    Map<T, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      indexMap.put(vertices.get(i), i);
    }
    for (int i = 0; i < n; i++) {
      T v = vertices.get(i);
      for (T neighbor : map.getOrDefault(v, Collections.emptySet())) {
        matrix.setNumber(i, indexMap.get(neighbor), 1);
      }
    }
    return matrix;
  }
}
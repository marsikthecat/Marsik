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

public class MarsikGraph<T> {

  private final HashMap<T, Set<T>> map = new HashMap<>();

  public void addVertex(T elem) {
    map.putIfAbsent(elem, new HashSet<>());
  }

  public void removeVertex(T elem) {
    map.remove(elem);
    for (Set<T> neighbors : map.values()) {
      neighbors.remove(elem);
    }
  }

  public void addEdge(T source, T destination) {
    if (!map.containsKey(source) || !map.containsKey(destination)) {
      throw new NoSuchElementException("At least one Element is not in the graph, bro");
    }
    map.get(source).add(destination);
  }

  public void removeEdge(T source, T destination) {
    map.get(source).remove(destination);
  }

  public int numberOfVertexes() {
    return map.keySet().size();
  }

  public int numberOfEdges() {
    int count = 0;
    for (Set<T> v : map.values()) {
      count += v.size();
    }
    return count;
  }

  public boolean isEmpty() {
    return map.isEmpty();
  }

  public Set<T> getNeighbourVertexes(T value) {
    if (!map.containsKey(value))  {
      throw new NoSuchElementException("Element " + value + " is not in the graph, bro");
    }
    return map.get(value);
  }

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

  public int[][] adjacencyMatrix(List<T> vertices) {
    int n = vertices.size();
    int[][] matrix = new int[n][n];
    Map<T, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      indexMap.put(vertices.get(i), i);
    }
    for (int i = 0; i < n; i++) {
      T v = vertices.get(i);
      for (T neighbor : map.getOrDefault(v, Collections.emptySet())) {
        matrix[i][indexMap.get(neighbor)] = 1;
      }
    }
    return matrix;
  }
}
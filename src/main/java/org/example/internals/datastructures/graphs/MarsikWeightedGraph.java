package org.example.internals.datastructures.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Represents a weighted directed graph where vertices are of type {@link Vertex<T>}
 * and edges have an associated weight.
 * Vertices must be comparable, and each edge is represented as an {@link EdgeWithWeight<T>}.
 * The graph is internally stored as an adjacency list using a {@link HashMap}.
 *
 * @param <T> the type of elements stored in the vertices; must implement {@link Comparable}
 */
public class MarsikWeightedGraph<T extends Comparable<T>> {

  private final HashMap<Vertex<T>, Set<EdgeWithWeight<T>>> graphMap;

  /**
   * Constructs an empty weighted graph.
   */
  public MarsikWeightedGraph() {
    this.graphMap = new HashMap<>();
  }

  /**
   * Adds a vertex to the graph.
   * If the vertex already exists, this method does nothing.
   *
   * @param newVertex the vertex to add
   */
  public void addVertex(Vertex<T> newVertex) {
    graphMap.putIfAbsent(newVertex, new HashSet<>());
  }

  /**
   * Removes a vertex and all edges pointing to it from the graph.
   *
   * @param vertex the vertex to remove
   */
  public void removeVertex(Vertex<T> vertex) {
    graphMap.remove(vertex);
    for (Set<EdgeWithWeight<T>> edges : graphMap.values()) {
      edges.removeIf(e -> e.getDestination().equals(vertex));
    }
  }

  /**
   * Adds a directed weighted edge from {@code src} to {@code dest}.
   *
   * @param src the source vertex
   * @param dest the destination vertex
   * @param weight the weight of the edge
   * @throws NoSuchElementException if either vertex does not exist in the graph
   */
  public void addWeightedEdge(Vertex<T> src, Vertex<T> dest, Number weight) {
    if (graphMap.containsKey(src) && graphMap.containsKey(dest)) {
      Set<EdgeWithWeight<T>> edgeWithWeights = graphMap.get(src);
      edgeWithWeights.add(new EdgeWithWeight<>(dest, weight));
    } else {
      throw new NoSuchElementException("One or both vertices not found");
    }
  }

  /**
   * Removes a directed weighted edge from {@code src} to {@code dest} with the specified weight.
   *
   * @param src the source vertex
   * @param dest the destination vertex
   * @param weight the weight of the edge
   */
  public void removeWeightedEdge(Vertex<T> src, Vertex<T> dest, Number weight) {
    if (graphMap.containsKey(src) && graphMap.containsKey(dest)) {
      Set<EdgeWithWeight<T>> edgeWithWeights = graphMap.get(src);
      edgeWithWeights.remove(new EdgeWithWeight<>(dest, weight));
    }
  }

  /**
   * Checks if the graph has no vertices.
   *
   * @return {@code true} if the graph is empty, {@code false} otherwise
   */
  public boolean isEmpty() {
    return graphMap.isEmpty();
  }

  /**
   * Returns the number of vertices in the graph.
   *
   * @return the vertex count
   */
  public int numberOfVertexes() {
    return graphMap.size();
  }

  /**
   * Returns the total number of edges in the graph.
   *
   * @return the edge count
   */
  public int numberOfEdges() {
    int count = 0;
    for (Set<EdgeWithWeight<T>> v : graphMap.values()) {
      count += v.size();
    }
    return count;
  }

  /**
   * Prints the graph as an adjacency list.
   * Each vertex is printed with its outgoing edges.
   */
  public void printGraph() {
    for (Map.Entry<Vertex<T>, Set<EdgeWithWeight<T>>> entry : graphMap.entrySet()) {
      System.out.println(entry.getKey() + " -> ");
      if (entry.getValue().isEmpty()) {
        System.out.println("(no edges)");
        continue;
      }
      for (EdgeWithWeight<T> edge : entry.getValue()) {
        System.out.println(edge + "  ");
      }
      System.out.println(" ");
    }
  }

  /**
   * Computes and prints the shortest path from {@code start} to {@code target}
   * using Dijkstra's algorithm.
   * Prints both the path as a list of vertices and the total distance.
   *
   * @param start the starting vertex
   * @param target the destination vertex
   */
  public void printShortestPath(Vertex<T> start, Vertex<T> target) {
    Map<Vertex<T>, Double> distances = new HashMap<>();
    final Map<Vertex<T>, Vertex<T>> previous = new HashMap<>();
    PriorityQueue<Vertex<T>> pq = new PriorityQueue<>(
            Comparator.comparingDouble(distances::get)
    );
    for (Vertex<T> v : graphMap.keySet()) {
      distances.put(v, Double.POSITIVE_INFINITY);
    }
    distances.put(start, 0.0);
    pq.add(start);
    while (!pq.isEmpty()) {
      Vertex<T> current = pq.poll();
      if (current.equals(target)) {
        break;
      }
      for (EdgeWithWeight<T> edge : graphMap.getOrDefault(current, new HashSet<>())) {
        Vertex<T> neighbor = edge.getDestination();
        double newDist = distances.get(current) + edge.getWeight().doubleValue();
        if (newDist < distances.get(neighbor)) {
          distances.put(neighbor, newDist);
          previous.put(neighbor, current);
          pq.remove(neighbor);
          pq.add(neighbor);
        }
      }
    }
    List<Vertex<T>> path = new ArrayList<>();
    for (Vertex<T> at = target; at != null; at = previous.get(at)) {
      path.add(at);
    }
    Collections.reverse(path);
    System.out.println("Path: " + path.stream().map(Vertex::elem).toList());
    System.out.println("Distance: " + distances.get(target));
  }
}
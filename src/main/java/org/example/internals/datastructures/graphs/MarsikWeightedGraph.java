package org.example.internals.datastructures.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;

public class MarsikWeightedGraph<T extends Comparable<T>> {

  private final HashMap<Vertex<T>, Set<EdgeWithWeight<T>>> graphMap;

  public MarsikWeightedGraph() {
    this.graphMap = new HashMap<>();
  }

  public void addVertex(Vertex<T> newVertex) {
    graphMap.putIfAbsent(newVertex, new HashSet<>());
  }

  public void removeVertex(Vertex<T> vertex) {
    graphMap.remove(vertex);
    for (Set<EdgeWithWeight<T>> edges : graphMap.values()) {
      edges.removeIf(e -> e.getDestination().equals(vertex));
    }
  }

  public void addWeightedEdge(Vertex<T> src, Vertex<T> dest, Number weight) {
    if (graphMap.containsKey(src) && graphMap.containsKey(dest)) {
      Set<EdgeWithWeight<T>> edgeWithWeights = graphMap.get(src);
      edgeWithWeights.add(new EdgeWithWeight<>(dest, weight));
    } else {
      throw new NoSuchElementException("One or both vertices not found");
    }
  }

  public void removeWeightedEdge(Vertex<T> src, Vertex<T> dest, Number weight) {
    if (graphMap.containsKey(src) && graphMap.containsKey(dest)) {
      Set<EdgeWithWeight<T>> edgeWithWeights = graphMap.get(src);
      edgeWithWeights.remove(new EdgeWithWeight<>(dest, weight));
    }
  }

  public boolean isEmpty() {
    return graphMap.isEmpty();
  }

  public int numberOfVertexes() {
    return graphMap.size();
  }

  public int numberOfEdges() {
    int count = 0;
    for (Set<EdgeWithWeight<T>> v : graphMap.values()) {
      count += v.size();
    }
    return count;
  }

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


  public void printShortestPath(Vertex<T> start, Vertex<T> target) {
    Map<Vertex<T>, Double> distances = new HashMap<>();
    Map<Vertex<T>, Vertex<T>> previous = new HashMap<>();
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
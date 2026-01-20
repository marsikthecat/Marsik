package org.example.internals.datastructures.graphs;

import java.util.Objects;

public class EdgeWithWeight<T extends Comparable<T>> {
  private final Vertex<T> destination;
  private Number weight;

  public EdgeWithWeight(Vertex<T> destination, Number weight) {
    this.destination = destination;
    this.weight = weight;
  }

  public Vertex<T> getDestination() {
    return destination;
  }

  public Number getWeight() {
    return weight;
  }

  public void setWeight(Number weight) {
    this.weight = weight;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EdgeWithWeight<?> edge = (EdgeWithWeight<?>) o;
    return Objects.equals(destination, edge.destination)
            && Objects.equals(weight, edge.weight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(destination, weight);
  }

  @Override
  public String toString() {
    return destination + "(" + weight + ")";
  }
}
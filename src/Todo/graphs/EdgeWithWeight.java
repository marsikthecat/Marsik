package org.example.internals.datastructures.graphs;

import java.util.Objects;

/**
 * Represents a directed, weighted edge in a graph.
 *
 * @param <T> the type of element stored in the destination vertex
 */
public class EdgeWithWeight<T extends Comparable<T>> {
  private final Vertex<T> destination;
  private Number weight;

  /**
   * Constructs a new edge with the specified destination vertex and weight.
   *
   * @param destination the vertex this edge points to
   * @param weight the weight of this edge
   */
  public EdgeWithWeight(Vertex<T> destination, Number weight) {
    this.destination = destination;
    this.weight = weight;
  }

  /**
   * Returns the destination vertex of this edge.
   *
   * @return the destination vertex
   */
  public Vertex<T> getDestination() {
    return destination;
  }

  /**
   * Returns the weight of this edge.
   *
   * @return the edge's weight
   */
  public Number getWeight() {
    return weight;
  }

  /**
   * Sets a new weight for this edge.
   *
   * @param weight the new weight to assign
   */
  public void setWeight(Number weight) {
    this.weight = weight;
  }

  /**
   * Checks if this edge is equal to another object.
   * Two edges are considered equal if both their destination vertices and weights are equal.
   *
   * @param o the object to compare with
   * @return {@code true} if the objects are equal, {@code false} otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EdgeWithWeight<?> edge = (EdgeWithWeight<?>) o;
    return Objects.equals(destination, edge.destination)
            && Objects.equals(weight, edge.weight);
  }

  /**
   * Returns a hash code value for this edge, based on its destination and weight.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(destination, weight);
  }

  /**
   * Returns a string representation of this edge in the format:
   * {@code destination(weight)}.
   *
   * @return the string representation
   */
  @Override
  public String toString() {
    return destination + "(" + weight + ")";
  }
}
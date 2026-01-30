package org.example.internals.datastructures.graphs;

import java.util.Objects;

/**
 * Represents a vertex (or node) in a graph with a generic element.
 * The element stored in the vertex must implement {@link Comparable} to allow
 * ordering if needed. This class overrides {@link #equals(Object)} and
 * {@link #toString()} for proper equality checking and string representation.
 *
 * @param <T> the type of element stored in the vertex; must implement {@link Comparable}
 */
public record Vertex<T extends Comparable<T>>(T elem) {

  /**
   * Checks if this vertex is equal to another object.
   * Two vertices are considered equal if they are of the same class and their
   * stored elements are equal.
   *
   * @param o the object to compare with
   * @return {@code true} if the vertices are equal, {@code false} otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vertex<?> vertex = (Vertex<?>) o;
    return Objects.equals(elem, vertex.elem);
  }

  /**
   * Returns a string representation of this vertex.
   * The string representation is the string form of the stored element.
   *
   * @return a string representing this vertex
   */
  @Override
  public String toString() {
    return elem.toString();
  }
}
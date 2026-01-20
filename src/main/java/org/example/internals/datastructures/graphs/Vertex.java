package org.example.internals.datastructures.graphs;

import java.util.Objects;

public record Vertex<T extends Comparable<T>>(T elem) {

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vertex<?> vertex = (Vertex<?>) o;
    return Objects.equals(elem, vertex.elem);
  }

  @Override
  public String toString() {
    return elem.toString();
  }
}
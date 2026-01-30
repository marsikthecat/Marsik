package org.example.internals.math;

/**
 * Represents a two-dimensional point with an identifier.
 * A {@code Point} consists of an {@code x} and {@code y} coordinate as well as
 * a human-readable identifier stored as a String.
 */
public class Point {

  private double xpos;
  private double ypos;
  private final String identifier;

  /**
   * Creates a new point with the given identifier and coordinates.
   *
   * @param identifier unique identifier for the point
   * @param x          x-coordinate
   * @param y          y-coordinate
   */
  public Point(String identifier, double x, double y) {
    this.identifier = identifier;
    this.xpos = x;
    this.ypos = y;
  }

  /**
   * Returns the x-coordinate of this point.
   *
   * @return x-coordinate
   */
  public double getX() {
    return xpos;
  }

  /**
   * Returns the y-coordinate of this point.
   *
   * @return y-coordinate
   */
  public double getY() {
    return ypos;
  }

  /**
   * Returns the identifier of this point.
   *
   * @return point identifier
   */
  public String getIdentifier() {
    return identifier;
  }

  /**
   * Sets a new x-coordinate for this point.
   *
   * @param x new x-coordinate
   */
  public void setX(double x) {
    this.xpos = x;
  }

  /**
   * Sets a new y-coordinate for this point.
   *
   * @param y new y-coordinate
   */
  public void setY(double y) {
    this.ypos = y;
  }

  /**
   * Returns a human-readable string representation of this point.
   *
   * @return string representation of the point
   */
  @Override
  public String toString() {
    return "Point " + identifier + ":" + " X = " + xpos + " , Y = " + ypos;
  }
}
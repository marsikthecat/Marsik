package org.example.internals.math;

public class Point {

  private double x;
  private double y;
  private final String identifier;

  public Point(String identifier, double x, double y) {
    this.identifier = identifier;
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return "Point " + identifier + ":" + " X = " + x + " , Y = " + y;
  }
}
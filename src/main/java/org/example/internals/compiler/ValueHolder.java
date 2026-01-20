package org.example.internals.compiler;

public class ValueHolder {
  public String javaType;
  public String javaExpr;

  public ValueHolder(String javaType, String javaExpr) {
    this.javaType = javaType;
    this.javaExpr = javaExpr;
  }
}
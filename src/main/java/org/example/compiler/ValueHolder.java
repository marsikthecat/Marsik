package org.example.compiler;

public class ValueHolder {
  public String type;
  public boolean isDeclared;

  public ValueHolder(String type, boolean isDeclared) {
    this.type = type;
    this.isDeclared = isDeclared;
  }

  public ValueHolder() {}

  public void itIsNowDeclared() {
    this.isDeclared = true;
  }

  public String getType() {
    return type;
  }
}
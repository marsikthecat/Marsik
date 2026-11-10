package org.example.compiler;

public class ValueHolder {
  public String type;
  public boolean isDeclared;
  public boolean isConst;

  public ValueHolder(String type, boolean isDeclared, boolean isConst) {
    this.type = type;
    this.isDeclared = isDeclared;
    this.isConst = isConst;
  }

  public ValueHolder() {}

  public void itIsNowDeclared() {
    this.isDeclared = true;
  }

  public boolean isConst() {
    return this.isConst;
  }

  public String getType() {
    return type;
  }
}
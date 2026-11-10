package org.example.compiler;

import java.util.ArrayList;
import java.util.List;

public class TypeHolder {
  public List<Field> fields = new ArrayList<>();

  public static class Field {
    public String type;
    public String name;
  }
}
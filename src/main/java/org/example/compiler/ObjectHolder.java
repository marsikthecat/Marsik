package org.example.compiler;

import java.util.ArrayList;
import java.util.List;

public class ObjectHolder {
  public String name;
  public List<Field> fields = new ArrayList<>();
  public List<Method> methods = new ArrayList<>();

  public ObjectHolder(String name) {
    this.name = name;
  }

  public static class Field {
    public String type;
    public String name;
    public boolean isPublic;
    public boolean isConst;
  }

  public static class Method {
    public String name;
    public String returnType;
    public boolean isInternal;
    public List<Parameter> parameters = new ArrayList<>();
    public String body;
  }

  public static class Parameter {
    public String type;
    public String name;

    public Parameter(String type, String name) {
      this.type = type;
      this.name = name;
    }
  }
}
package org.example.compiler;

import java.util.ArrayList;
import java.util.List;

public class ClassHolder {
  public String name;
  public List<FieldHolder> fields = new ArrayList<>();
  public List<MethodHolder> methods = new ArrayList<>();
  public ConstructorHolder constructor;
}

package org.example.compiler;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a custom object definition in Marsik code.
 * Similar to ClassHolder but for custom data structures that will be compiled to C.
 */
public class CustomObjectHolder {
  public String name;
  public List<FieldHolder> fields = new ArrayList<>();
  public List<MethodHolder> methods = new ArrayList<>();
  public boolean isGenerated = false;
  
  public CustomObjectHolder(String name) {
    this.name = name;
  }
}


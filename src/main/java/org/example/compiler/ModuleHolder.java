package org.example.compiler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModuleHolder {
  public final String name;
  public final List<Function> functions = new ArrayList<>();
  public final Set<String> requiredIncludes = new HashSet<>();
  public final Set<String> requiredDeclarations = new HashSet<>();

  public ModuleHolder(String name) {
    this.name = name;
  }

  public static class Function {
    public String name;
    public String returnType;
    public final List<Parameter> parameters = new ArrayList<>();
    public String body;
  }

  public static class Parameter {
    public final String type;
    public final String name;

    public Parameter(String type, String name) {
      this.type = type;
      this.name = name;
    }
  }
}

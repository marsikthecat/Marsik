package org.example.compiler;

import java.util.ArrayList;
import java.util.List;

public class MethodHolder {
  public String name;
  public String returnType; // null = void
  public boolean isInternal;
  public List<ParamHolder> params = new ArrayList<>();
  public String body; // Java-Code aus block
}


package org.example.compiler;

import java.util.List;

public record FunctionHolder(String name, String returnType, List<ParameterHolder> parameters, String body) {
}

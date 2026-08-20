#pragma once

#include "../../stringUtils.hpp"
#include "node.hpp"

typedef struct Graph {
    Node** nodes;
    int numberOfNodes;
    int nodesCapacity;
} Graph;

Graph init_graph();

void graph_addNode(Graph graph, Node node);

void graph_removeNode(Graph graph, Node node);

bool graph_containsNode(Graph graph, string identifier);

void graph_print(Graph graph);
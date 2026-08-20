#pragma once

#include "../../stringUtils.hpp"

typedef struct Edge Edge;
typedef struct Node Node;

struct Node {
    string identifier;
    int numberOfEdges;
    int edgesCapacity;
    Edge** edges;
};

Node init_node(string identifier);

string node_getIdentifier(Node node);

int node_getNumberOfEdges(Node node);

void node_addEdge(Node node, Edge edge);

void node_removeEdge(Node node, Edge edge);

bool node_containsEdge(Node node, string edgeIdentifier);
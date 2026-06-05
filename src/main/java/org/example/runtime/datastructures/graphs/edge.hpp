#pragma once

#include "../../string.hpp"

typedef struct Node Node;
typedef struct Edge Edge;

struct Edge {
    string identifier;
    double weight;
    Node* destination;
};

Edge init_edge(string identifier);

void edge_setWeight(Edge* edge, double weight);

void edge_setDestination(Edge* edge, Node* node);

Node edge_getDestination(Edge* edge);

double edge_getWeight(Edge* edge);
#include <stdio.h>
#include <stdlib.h>
#include "edge.hpp"
#include "node.hpp"

Edge init_edge(string identifier) {
    Edge edge;
    edge.identifier = identifier;
    edge.weight = 0.0;
    edge.destination = NULL;
    return edge;
}

void edge_setWeight(Edge edge, double weight) {
    edge.weight = weight;
}

void edge_setDestination(Edge edge, Node node) {
    edge.destination = &node;
}

Node edge_getDestination(Edge edge) {
    return *edge.destination;
}

double edge_getWeight(Edge edge) {
    return edge.weight;
}
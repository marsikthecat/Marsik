#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include "node.hpp"
#include "edge.hpp"
#include "../../allocator/allocator.hpp"

Node init_node(string identifier) {
    Node node;
    node.identifier = identifier;
    node.numberOfEdges = 0;
    node.edgesCapacity = 5;
    node.edges = (Edge**)allocateFromMarsik(sizeof(Edge*) * node.edgesCapacity);
    return node;
}

string node_getIdentifier(Node node) {
    return node.identifier;
}

int node_getNumberOfEdges(Node node) {
    return node.numberOfEdges;
}

static void node_ensureCapacity(Node node) {
    if (node.numberOfEdges >= node.edgesCapacity) {
        node.edgesCapacity *= 2;
        Edge** resized = (Edge**)allocateFromMarsik(sizeof(Edge*) * node.edgesCapacity);
        node.edges = resized;
    }
}

void node_addEdge(Node node, Edge edge) {
    node_ensureCapacity(node);
    node.edges[node.numberOfEdges++] = &edge;
}

void node_removeEdge(Node node, Edge edge) {
    int index = -1;
    for (int i = 0; i < node.numberOfEdges; i++) {
        Edge temp_edge = *node.edges[i];
        string t = temp_edge.identifier;
        string t2 = edge.identifier;
        if (str_stringEquals(t, t2)) {
            index = i;
            break;
        }
    }
    if (index < 0) {
        return;
    }
    for (int i = index; i < node.numberOfEdges - 1; i++) {
        node.edges[i] = node.edges[i + 1];
    }
    node.numberOfEdges--;
}

bool node_containsEdge(Node node, string edgeIdentifier) {
    for (int i = 0; i < node.numberOfEdges; i++) {
        Edge edge = *node.edges[i];
        if (str_stringEquals(edge.identifier, edgeIdentifier)) {
            return true;
        }
    }
    return false;
}
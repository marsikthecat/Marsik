#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include "node.hpp"
#include "edge.hpp"

Node init_node(string identifier) {
    Node node;
    node.identifier = identifier;
    node.numberOfEdges = 0;
    node.edgesCapacity = 5;
    node.edges = (Edge**)malloc(sizeof(Edge*) * node.edgesCapacity);
    if (node.edges == NULL) {
        fprintf(stderr, "FATAL ERROR: Out of memory\n");
        exit(1);
    }
    return node;
}

void node_free(Node* node) {
    free(node->edges);
}

string node_getIdentifier(Node* node) {
    return node->identifier;
}

int node_getNumberOfEdges(Node* node) {
    return node->numberOfEdges;
}

static void node_ensureCapacity(Node* node) {
    if (node->numberOfEdges >= node->edgesCapacity) {
        node->edgesCapacity *= 2;
        Edge** resized = (Edge**)realloc(node->edges, sizeof(Edge*) * node->edgesCapacity);
        if (resized == NULL) {
            fprintf(stderr, "FATAL ERROR: Out of memory\n");
            exit(1);
        }
        node->edges = resized;
    }
}

void node_addEdge(Node* node, Edge* edge) {
    node_ensureCapacity(node);
    node->edges[node->numberOfEdges++] = edge;
}

void node_removeEdge(Node* node, Edge* edge) {
    int index = -1;
    for (int i = 0; i < node->numberOfEdges; i++) {
        Edge temp_edge = *node->edges[i];
        string t = temp_edge.identifier;
        string t2 = edge->identifier;
        if (str_isEqual(&t, &t2)) {
            index = i;
            break;
        }
    }
    if (index < 0) {
        return;
    }
    for (int i = index; i < node->numberOfEdges - 1; i++) {
        node->edges[i] = node->edges[i + 1];
    }
    node->numberOfEdges--;
}

bool node_containsEdge(Node* node, string* edgeIdentifier) {
    for (int i = 0; i < node->numberOfEdges; i++) {
        Edge* edge = node->edges[i];
        if (str_isEqual(&edge->identifier, edgeIdentifier)) {
            return true;
        }
    }
    return false;
}
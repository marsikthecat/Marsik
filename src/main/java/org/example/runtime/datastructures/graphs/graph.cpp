#include <stdio.h>
#include <stdlib.h>
#include "../../stringUtils.hpp"
#include "graph.hpp"
#include "node.hpp"
#include "edge.hpp"
#include "../../allocator/allocator.hpp"
#include "../../error/error.hpp"

Graph init_graph() {
    Graph graph;
    graph.numberOfNodes = 0;
    graph.nodesCapacity = 4;
    graph.nodes = (Node**)allocateFromMarsik(sizeof(Node*) * graph.nodesCapacity);
    return graph;
}

static void graph_ensureCapacity(Graph graph) {
    if (graph.numberOfNodes >= graph.nodesCapacity) {
        graph.nodesCapacity *= 2;
        Node** resized = (Node**)allocateFromMarsik(sizeof(Node*) * graph.nodesCapacity);
        graph.nodes = resized;
    }
}

void graph_addNode(Graph graph, Node node) {
    graph_ensureCapacity(graph);
    graph.nodes[graph.numberOfNodes++] = &node;
}

void graph_removeNode(Graph graph, Node node) {
    int index = -1;
    for (int i = 0; i < graph.numberOfNodes; i++) {
        if (string_equals(graph.nodes[i]->identifier, node.identifier)) {
            index = i;
            break;
        }
    }
    if (index < 0) {
        runtimeWarning("Node to remove not found");
        return;
    }
    for (int i = index; i < graph.numberOfNodes - 1; i++) {
        graph.nodes[i] = graph.nodes[i + 1];
    }
    graph.numberOfNodes--;
}

bool graph_containsNode(Graph graph, string identifier) {
    for (int i = 0; i < graph.numberOfNodes; i++) {
        Node node = *graph.nodes[i];
        if (string_equals(node.identifier, identifier)) {
            return true;
        }
    }
    return false;
}

void graph_print(Graph graph) {
    printf("Graph: %d node(s)\n", graph.numberOfNodes);
    for (int i = 0; i < graph.numberOfNodes; i++) {
        Node node = *graph.nodes[i];
        printf("  Node %s (%d edge(s))\n", &node.identifier, node.numberOfEdges);
        for (int j = 0; j < node.numberOfEdges; j++) {
            Edge edge = *node.edges[j];
            printf("    Edge %s weight=%.2f\n", &edge.identifier, edge.weight);
        }
    }
}
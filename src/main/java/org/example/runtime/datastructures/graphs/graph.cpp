#include <stdio.h>
#include <stdlib.h>
#include "../../string.hpp"
#include "graph.hpp"
#include "node.hpp"
#include "edge.hpp"

Graph init_graph() {
    Graph graph;
    graph.numberOfNodes = 0;
    graph.nodesCapacity = 4;
    graph.nodes = (Node**)malloc(sizeof(Node*) * graph.nodesCapacity);
    if (graph.nodes == NULL) {
        fprintf(stderr, "FATAL ERROR: Out of memory\n");
        exit(1);
    }
    return graph;
}

void graph_free(Graph* graph) {
    for (int i = 0; i < graph->numberOfNodes; i++) {
        node_free(graph->nodes[i]);
    }
    free(graph->nodes);
}

static void graph_ensureCapacity(Graph* graph) {
    if (graph->numberOfNodes >= graph->nodesCapacity) {
        graph->nodesCapacity *= 2;
        Node** resized = (Node**)realloc(graph->nodes, sizeof(Node*) * graph->nodesCapacity);
        if (resized == NULL) {
            fprintf(stderr, "FATAL ERROR: Out of memory\n");
            exit(1);
        }
        graph->nodes = resized;
    }
}

void graph_addNode(Graph* graph, Node* node) {
    graph_ensureCapacity(graph);
    graph->nodes[graph->numberOfNodes++] = node;
}

void graph_removeNode(Graph* graph, Node* node) {
    if (graph == NULL || node == NULL) {
        return;
    }
    int index = -1;
    for (int i = 0; i < graph->numberOfNodes; i++) {
        if (graph->nodes[i] == node) {
            index = i;
            break;
        }
    }
    if (index < 0) {
        return;
    }
    node_free(node);
    for (int i = index; i < graph->numberOfNodes - 1; i++) {
        graph->nodes[i] = graph->nodes[i + 1];
    }
    graph->numberOfNodes--;
}

bool graph_containsNode(Graph* graph, string* identifier) {
    for (int i = 0; i < graph->numberOfNodes; i++) {
        Node* node = graph->nodes[i];
        if (str_isEqual(&node->identifier, identifier)) {
            return true;
        }
    }
    return false;
}

void graph_print(Graph* graph) {
    printf("Graph: %d node(s)\n", graph->numberOfNodes);
    for (int i = 0; i < graph->numberOfNodes; i++) {
        Node* node = graph->nodes[i];
        printf("  Node %s (%d edge(s))\n", &node->identifier, node->numberOfEdges);
        for (int j = 0; j < node->numberOfEdges; j++) {
            Edge* edge = node->edges[j];
            printf("    Edge %s weight=%.2f\n",
                   &edge->identifier, edge->weight);
        }
    }
}

#include <stdio.h>
#include <stdlib.h>
#include "allocator.hpp"
#include "../error/error.hpp"

#define MAX_MARSIK_HEAP_SIZE (10 * 1024 * 1024)

static char heap[MAX_MARSIK_HEAP_SIZE];
static size_t offset = 0;

void* allocateFromMarsik(size_t size) {
    if (offset + size > MAX_MARSIK_HEAP_SIZE) {
        runtimeFatalError("OUT OF MEMORY", true);
    }
    void* pointer = heap + offset;
    offset += size;
    return pointer;
}

void printMarsikHeap() {
    size_t end = offset + 10;
    if (end > MAX_MARSIK_HEAP_SIZE) {
        end = MAX_MARSIK_HEAP_SIZE;
    }
    for (size_t i = 0; i < end; i++) {
        printf("%c ", i < offset ? '#' : '-');
        unsigned char c = heap[i];
        if (c >= 32 && c <= 126) {
            printf("[%zu] '%c'\n", i, c);
        } else {
            printf("[%zu] %d\n", i, c);
        }
    }
}
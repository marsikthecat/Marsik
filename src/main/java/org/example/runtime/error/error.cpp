#include <stdio.h>
#include <stdlib.h>
#include "error.hpp"

void runtimeWarning(const char* msg) {
    fprintf(stderr, YELLOW "[WARNING]\033[0m %s\n" RESET, msg);
}

void runtimeError(const char* msg) {
    fprintf(stderr, RED "[ERROR]\033[0m %s\n" RESET, msg);
}

void runtimeFatalError(const char* msg, bool isAllocError) {
    fprintf(stderr, DARKRED "\033[91m[FATAL]\033[0m %s\n" RESET, msg);
    if (isAllocError) {
        printf("Marsik the Heap-Cat is terminating your program to prevent further crashes\n"); 
    }
    exit(1);
}
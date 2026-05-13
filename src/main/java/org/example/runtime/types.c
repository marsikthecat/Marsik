#include "types.h"
#include <string.h>
#include <stdbool.h>

int compare(const void* a, const void* b, Types type) {
    switch (type) {
        case INT: {
            int valA = *(int*)a;
            int valB = *(int*)b;
            return valA - valB;
        }
        case DOUBLE: {
            double valA = *(double*)a;
            double valB = *(double*)b;
            if (valA < valB) return -1;
            if (valA > valB) return 1;
            return 0;
        }
        case CHAR: {
            char valA = *(char*)a;
            char valB = *(char*)b;
            return valA - valB;
        }
        case BOOL: {
            bool valA = *(bool*)a;
            bool valB = *(bool*)b;
            return valA - valB;
        }
        case STRING: {
            return strcmp(*(char**)a, *(char**)b);
        }
        case OBJECT: {
            // For objects, compare pointers
            return (char*)a - (char*)b;
        }
        default:
            return 0;
    }
}
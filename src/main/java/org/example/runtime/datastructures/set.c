#include "set.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

static void _set_ensure_capacity(Set* set) {
    if (set->size >= set->capacity) {
        int new_capacity = set->capacity == 0 ? DEFAULT_SET_CAPACITY : set->capacity * 2;
        void** new_data = (void**)malloc(new_capacity * sizeof(void*));

        if (new_data == NULL) {
            fprintf(stderr, "ERROR: Memory allocation failed\n");
            return;
        }

        if (set->data != NULL) {
            memcpy(new_data, set->data, set->size * sizeof(void*));
            free(set->data);
        }

        set->data = new_data;
        set->capacity = new_capacity;
    }
}

Set* init_set(void) {
    return set_create_with_capacity(DEFAULT_SET_CAPACITY);
}

Set* set_create_with_capacity(int capacity) {
    Set* set = (Set*)malloc(sizeof(Set));

    if (set == NULL) {
        fprintf(stderr, "ERROR: Memory allocation failed for Set\n");
        return NULL;
    }

    if (capacity < 0) {
        capacity = DEFAULT_SET_CAPACITY;
    }

    set->data = capacity > 0 ? (void**)malloc(capacity * sizeof(void*)) : NULL;
    set->size = 0;
    set->capacity = capacity;

    return set;
}

bool set_add(Set* set, void* value) {
    if (set == NULL) {
        fprintf(stderr, "ERROR: Set is NULL\n");
        return false;
    }

    if (set_contains(set, value)) {
        return false;
    }

    _set_ensure_capacity(set);
    set->data[set->size++] = value;
    return true;
}

bool set_remove(Set* set, void* value) {
    if (set == NULL) {
        fprintf(stderr, "ERROR: Set is NULL\n");
        return false;
    }

    for (int i = 0; i < set->size; i++) {
        if (set->data[i] == value) {
            for (int j = i; j < set->size - 1; j++) {
                set->data[j] = set->data[j + 1];
            }
            set->size--;
            return true;
        }
    }
    return false;
}

bool set_contains(Set* set, void* value) {
    if (set == NULL) {
        fprintf(stderr, "ERROR: Set is NULL\n");
        return false;
    }

    for (int i = 0; i < set->size; i++) {
        if (set->data[i] == value) {
            return true;
        }
    }
    return false;
}

bool set_isEmpty(Set* set) {
    if (set == NULL) {
        fprintf(stderr, "ERROR: Set is NULL\n");
        return true;
    }

    return set->size == 0;
}

int set_size(Set* set) {
    if (set == NULL) {
        fprintf(stderr, "ERROR: Set is NULL\n");
        return 0;
    }

    return set->size;
}

int set_capacity(Set* set) {
    if (set == NULL) {
        fprintf(stderr, "ERROR: Set is NULL\n");
        return 0;
    }

    return set->capacity;
}

void set_clear(Set* set) {
    if (set == NULL) {
        fprintf(stderr, "ERROR: Set is NULL\n");
        return;
    }

    set->size = 0;
}

void set_free(Set* set) {
    if (set == NULL) {
        return;
    }

    if (set->data != NULL) {
        free(set->data);
        set->data = NULL;
    }

    free(set);
}
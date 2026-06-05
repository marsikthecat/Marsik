#pragma once

#include <stdbool.h>
#include <stdlib.h>

#define DEFAULT_SET_CAPACITY 10

template<typename T>
struct Set {
    T* data;
    int size;
    int capacity;
};

template<typename T>
Set<T> init_set(int capacity) {
    Set<T> set;
    if (capacity < 0) {
        capacity = DEFAULT_SET_CAPACITY;
    }
    set.data = malloc(capacity * sizeof(T));
    if (set.data == NULL) {
        fprintf(stderr, "FATAL ERROR: Out of memory\n");
        exit(1);
    }
    set.size = 0;
    set.capacity = capacity;
    return set;
}

template<typename T>
bool set_add(Set<T>* set, const T& value) {
    if (set_contains(set, value)) {
        return false;
    }
    if (set->size >= set->capacity) {
        fprintf(stderr, "ERROR: Set is full\n");
        return false;
    }
    _set_ensure_capacity(set);
    set->data[set->size++] = value;
    return true;
}

template<typename T>
bool set_remove(Set<T>* set, const T& value) {
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

template<typename T>
bool set_contains(Set<T>* set, const T& value) {
    for (int i = 0; i < set->size; i++) {
        if (set->data[i] == value) {
            return true;
        }
    }
    return false;
}

template<typename T>
bool set_isEmpty(Set<T>* set) {
    return set->size == 0;
}

template<typename T>
int set_size(Set<T>* set) {
    return set->size;
}

template<typename T>
int set_capacity(Set<T>* set) {
    return set->capacity;
}

template<typename T>
void set_clear(Set<T>* set) {
    set->size = 0;
}

template<typename T>
void set_free(Set<T>* set) {
    free(set->data);
}
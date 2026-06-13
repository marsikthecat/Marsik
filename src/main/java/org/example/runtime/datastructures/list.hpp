#pragma once

#include <stdbool.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <time.h>
#include "set.hpp"
#include "../allocator/allocator.hpp"
#include "../error/error.hpp"

#define DEFAULT_CAPACITY 10

template <typename T>
struct List {
    T* data;
    int size;
    int capacity;
};

template <typename T>
static void _list_ensure_capacity(List<T>* list) {
    if (list->size >= list->capacity) {
        int new_capacity = list->capacity == 0 ? DEFAULT_CAPACITY : list->capacity * 2;
        list->data = (T*)allocateFromMarsik(list->data, new_capacity * sizeof(T));
        list->capacity = new_capacity;
    }
}

template <typename T>
List<T> init_list(int capacity) {
    List<T> list;
    list.size = 0;
    if (capacity < 0) {
        capacity = DEFAULT_CAPACITY;
    }
    list.capacity = capacity;
    list.data = (T*)allocateFromMarsik(capacity * sizeof(T));
    return list;
}

template <typename T>
void list_add(List<T>* list, const T& value) {
    _list_ensure_capacity(list);
    list->data[list->size++] = value;
}

template <typename T>
void list_addAt(List<T>* list, int index, const T& value) {
    if (index < 0 || index > list->size) {
        fprintf(stderr, "ERROR: Index %d out of bounds (size: %d)\n", index, list->size);
        return;
    }
    _list_ensure_capacity(list);
    for (int i = list->size; i > index; i--) {
        list->data[i] = list->data[i - 1];
    }
    list->data[index] = value;
    list->size++;
}

template <typename T>
T list_get(List<T>* list, int index) {
    if (index < 0 || index >= list->size) {
        fprintf(stderr, "ERROR: Index %d out of bounds (size: %d)\n", index, list->size);
        return T();
    }
    return list->data[index];
}

template <typename T>
void list_set(List<T>* list, int index, const T& value) {
    if (index < 0 || index >= list->size) {
        fprintf(stderr, "ERROR: Index %d out of bounds (size: %d)\n", index, list->size);
        return;
    }
    list->data[index] = value;
}

template <typename T>
void list_removeAt(List<T>* list, int index) {
    if (index < 0 || index >= list->size) {
        fprintf(stderr, "ERROR: Index %d out of bounds (size: %d)\n", index, list->size);
        return;
    }
    for (int i = index; i < list->size - 1; i++) {
        list->data[i] = list->data[i + 1];
    }
    list->size--;
}

template <typename T>
bool list_remove(List<T>* list, const T& value) {
    int index = list_indexOf(list, value);
    if (index == -1) {
        return false;
    }
    list_removeAt(list, index);
    return true;
}

template <typename T>
void list_removeAll(List<T>* list, const T& value) {
    int removed_count = 0;
    for (int i = 0; i < list->size; i++) {
        if (list->data[i] == value) {
            list_removeAt(list, i);
            removed_count++;
            i--;
        }
    }
}

template <typename T>
bool list_contains(List<T>* list, const T& value) {
    return list_indexOf(list, value) != -1;
}

template <typename T>
int list_indexOf(List<T>* list, const T& value) {
    for (int i = 0; i < list->size; i++) {
        if (list->data[i] == value) {
            return i;
        }
    }
    return -1;
}

template <typename T>
int list_lastIndexOf(List<T>* list, const T& value) {
    for (int i = list->size - 1; i >= 0; i--) {
        if (list->data[i] == value) {
            return i;
        }
    }
    return -1;
}

template <typename T>
int list_size(List<T>* list) {
    return list->size;
}

template <typename T>
int list_capacity(List<T>* list) {
    return list->capacity;
}

template <typename T>
bool list_isEmpty(List<T>* list) {
    return list->size == 0;
}

template <typename T>
void list_clear(List<T>* list) {
    list->size = 0;
}

template <typename T>
void list_resize(List<T>* list, int new_capacity) {
    if (new_capacity < 0) {
        runtimeError("Capacity cannot be negative");
        return;
    }
    if (new_capacity == list->capacity) {
        return;
    }
    list->data = allocateFromMarsik(list->data, new_capacity * sizeof(T));
    list->capacity = new_capacity;
    if (list->size > new_capacity) {
        list->size = new_capacity;
    }
}

template <typename T>
void list_trim(List<T>* list) {
    if (list->size == 0) {
        list_resize(list, 0);
    } else if (list->size < list->capacity) {
        list_resize(list, list->size);
    }
}

template <typename T>
void list_removeDuplicateOf(List<T>* list, const T& value) {
    int first_index = list_indexOf(list, value);
    if (first_index == -1) {
        return;
    }
    for (int i = first_index + 1; i < list->size; i++) {
        if (list->data[i] == value) {
            list_removeAt(list, i);
            i--;
        }
    }
}

template <typename T>
List<T> list_withoutDuplicates(List<T>* list) {
    List<T> new_list = init_list<T>(list->size);
    for (int i = 0; i < list->size; i++) {
        if (!list_contains(new_list, list->data[i])) {
            list_add(new_list, list->data[i]);
        }
    }
    return new_list;
}

template <typename T>
List<T> list_clone(List<T>* list) {
    List<T> cloned = init_list<T>(list->capacity);
    if (list->size > 0) {
        memcpy(cloned.data, list->data, list->size * sizeof(T));
    }
    cloned.size = list->size;
    cloned.capacity = list->capacity;

    return cloned;
}

template <typename T>
void list_sort(List<T>* list) {
    qsort(list->data, list->size, sizeof(T), [](const void* a, const void* b) -> int {
        const T* elem_a = (const T*)a;
        const T* elem_b = (const T*)b;
        if (*elem_a < *elem_b) {
            return -1;
        } else if (*elem_a > *elem_b) {
            return 1;
        } else {
            return 0;
        }
    });
}

template <typename T>
T list_mostAppearingElement(List<T>* list) {
    T most_appearing = list->data[0];
    int max_count = 1;

    for (int i = 0; i < list->size; i++) {
        int count = 0;
        for (int j = 0; j < list->size; j++) {
            if (list->data[i] == list->data[j]) {
                count++;
            }
        }
        if (count > max_count) {
            max_count = count;
            most_appearing = list->data[i];
        }
    }
    return most_appearing;
}

template <typename T>
int list_mostAppearingElementCount(List<T>* list) {
    int max_count = 0;
    for (int i = 0; i < list->size; i++) {
        int count = 0;
        for (int j = 0; j < list->size; j++) {
            if (list->data[i] == list->data[j]) {
                count++;
            }
        }
        if (count > max_count) {
            max_count = count;
        }
    }
    return max_count;
}

template <typename T>
T list_randomElement(List<T>* list) {
    if (list->size == 0) {
        runtimeError("List is empty");
        return T();
    }
    static int seeded = 0;
    if (!seeded) {
        srand((unsigned int)time(nullptr));
        seeded = 1;
    }
    int random_index = rand() % list->size;
    return list->data[random_index];
}

template <typename T>
void list_print(List<T>* list, void (*print_element)(void*)) {
    printf("[");
    for (int i = 0; i < list->size; i++) {
        if (print_element != nullptr) {
            print_element(list->data[i]);
        } else {
            printf("null");
        }
        if (i < list->size - 1) {
            printf(", ");
        }
    }
    printf("]\n");
}

template <typename T>
Set<T> list_toSet(List<T>* list) {
    Set<T> set = init_set<T>(list->size);
    for (int i = 0; i < list->size; i++) {
        set_add(set, list->data[i]);
    }
    return set;
}
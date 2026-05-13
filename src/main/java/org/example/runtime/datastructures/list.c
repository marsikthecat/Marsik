#include "list.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <time.h>

static void _list_ensure_capacity(List* list) {
    if (list->size >= list->capacity) {
        int new_capacity = list->capacity == 0 ? DEFAULT_CAPACITY : list->capacity * 2;
        void** new_data = (void**)malloc(new_capacity * sizeof(void*));

        if (new_data == NULL) {
            fprintf(stderr, "ERROR: Memory allocation failed\n");
            return;
        }

        if (list->data != NULL) {
            memcpy(new_data, list->data, list->size * sizeof(void*));
            free(list->data);
        }

        list->data = new_data;
        list->capacity = new_capacity;
    }
}

List* init_list(void) {
    return list_create_with_capacity(DEFAULT_CAPACITY);
}

List* list_create_with_capacity(int capacity) {
    List* list = (List*)malloc(sizeof(List));

    if (list == NULL) {
        fprintf(stderr, "ERROR: Memory allocation failed for List\n");
        return NULL;
    }
    if (capacity < 0) {
        capacity = DEFAULT_CAPACITY;
    }
    list->data = capacity > 0 ? (void**)malloc(capacity * sizeof(void*)) : NULL;
    list->size = 0;
    list->capacity = capacity;

    return list;
}

void list_add(List* list, void* value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return;
    }

    _list_ensure_capacity(list);
    list->data[list->size++] = value;
}

void list_addAt(List* list, int index, void* value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return;
    }

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

void* list_get(List* list, int index) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return NULL;
    }

    if (index < 0 || index >= list->size) {
        fprintf(stderr, "ERROR: Index %d out of bounds (size: %d)\n", index, list->size);
        return NULL;
    }

    return list->data[index];
}

void* list_set(List* list, int index, void* value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return NULL;
    }

    if (index < 0 || index >= list->size) {
        fprintf(stderr, "ERROR: Index %d out of bounds (size: %d)\n", index, list->size);
        return NULL;
    }

    void* old_value = list->data[index];
    list->data[index] = value;
    return old_value;
}

void* list_removeAt(List* list, int index) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return NULL;
    }

    if (index < 0 || index >= list->size) {
        fprintf(stderr, "ERROR: Index %d out of bounds (size: %d)\n", index, list->size);
        return NULL;
    }

    void* removed = list->data[index];

    for (int i = index; i < list->size - 1; i++) {
        list->data[i] = list->data[i + 1];
    }

    list->size--;
    return removed;
}

bool list_remove(List* list, void* value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return false;
    }

    int index = list_indexOf(list, value);

    if (index == -1) {
        return false;
    }

    list_removeAt(list, index);
    return true;
}

bool list_contains(List* list, void* value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return false;
    }

    return list_indexOf(list, value) != -1;
}

int list_indexOf(List* list, void* value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return -1;
    }

    for (int i = 0; i < list->size; i++) {
        if (list->data[i] == value) {
            return i;
        }
    }

    return -1;
}

int list_size(List* list) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return 0;
    }

    return list->size;
}

int list_capacity(List* list) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return 0;
    }

    return list->capacity;
}

bool list_isEmpty(List* list) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return true;
    }

    return list->size == 0;
}

void list_clear(List* list) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return;
    }

    list->size = 0;
}

void list_resize(List* list, int new_capacity) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return;
    }
    if (new_capacity < 0) {
        fprintf(stderr, "ERROR: Capacity cannot be negative\n");
        return;
    }
    if (new_capacity == list->capacity) {
        return;
    }
    if (new_capacity == 0) {
        free(list->data);
        list->data = NULL;
        list->capacity = 0;
        if (list->size > 0) {
            list->size = 0;
        }
        return;
    }
    void** new_data = (void**)malloc(new_capacity * sizeof(void*));
    if (new_data == NULL) {
        fprintf(stderr, "ERROR: Memory allocation failed\n");
        return;
    }

    int copy_size = list->size < new_capacity ? list->size : new_capacity;
    if (list->data != NULL && copy_size > 0) {
        memcpy(new_data, list->data, copy_size * sizeof(void*));
        free(list->data);
    }

    list->data = new_data;
    list->capacity = new_capacity;
    if (list->size > new_capacity) {
        list->size = new_capacity;
    }
}

void list_trim(List* list) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return;
    }

    if (list->size == 0) {
        list_resize(list, 0);
    } else if (list->size < list->capacity) {
        list_resize(list, list->size);
    }
}

void list_free(List* list) {
    if (list == NULL) {
        return;
    }

    if (list->data != NULL) {
        free(list->data);
        list->data = NULL;
    }

    free(list);
}

int list_removeAll(List* list, void* value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return 0;
    }

    int removed_count = 0;
    for (int i = 0; i < list->size; i++) {
        if (list->data[i] == value) {
            list_removeAt(list, i);
            removed_count++;
            i--;
        }
    }

    return removed_count;
}

int list_lastIndexOf(List* list, void* value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return -1;
    }

    for (int i = list->size - 1; i >= 0; i--) {
        if (list->data[i] == value) {
            return i;
        }
    }

    return -1;
}

void list_removeDuplicateOf(List* list, void* value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return;
    }

    for (int i = list_indexOf(list, value) + 1; i < list->size; i++) {
        if (list->data[i] == value) {
            list_removeAt(list, i);
            i--;
        }
    }
}

List* list_withoutDuplicates(List* list) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return NULL;
    }

    List* new_list = list_create_with_capacity(list->size);

    for (int i = 0; i < list->size; i++) {
        if (!list_contains(new_list, list->data[i])) {
            list_add(new_list, list->data[i]);
        }
    }

    return new_list;
}

List* list_clone(List* list) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return NULL;
    }

    List* cloned = list_create_with_capacity(list->capacity);

    if (cloned == NULL) {
        return NULL;
    }

    memcpy(cloned->data, list->data, list->size * sizeof(void*));
    cloned->size = list->size;
    cloned->capacity = list->capacity;

    return cloned;
}

void list_sort(List* list, list_comparator cmp) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return;
    }

    if (cmp == NULL) {
        fprintf(stderr, "ERROR: Comparator is NULL\n");
        return;
    }

    qsort(list->data, list->size, sizeof(void*), (int (*)(const void*, const void*))cmp);
}

void* list_mostAppearingElement(List* list) {
    if (list == NULL || list->size == 0) {
        fprintf(stderr, "ERROR: List is NULL or empty\n");
        return NULL;
    }

    void* most_appearing = list->data[0];
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

int list_mostAppearingElementCount(List* list) {
    if (list == NULL || list->size == 0) {
        fprintf(stderr, "ERROR: List is NULL or empty\n");
        return 0;
    }

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

void* list_randomElement(List* list) {
    if (list == NULL || list->size == 0) {
        fprintf(stderr, "ERROR: List is NULL or empty\n");
        return NULL;
    }

    static int seeded = 0;
    if (!seeded) {
        srand((unsigned int)time(NULL));
        seeded = 1;
    }

    int random_index = rand() % list->size;
    return list->data[random_index];
}

void list_print(List* list, void (*print_element)(void*)) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: List is NULL\n");
        return;
    }

    printf("[");
    for (int i = 0; i < list->size; i++) {
        if (print_element != NULL) {
            print_element(list->data[i]);
        } else {
            printf("%p", list->data[i]);
        }
        if (i < list->size - 1) {
            printf(", ");
        }
    }
    printf("]\n");
}
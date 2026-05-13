#ifndef LIST_H
#define LIST_H

#include <stdbool.h>

#define DEFAULT_CAPACITY 10

typedef struct List {
    void** data;
    int size;
    int capacity;
} List;

typedef int (*list_comparator)(const void* a, const void* b);

List* init_list(void);

List* list_create_with_capacity(int capacity);

void list_add(List* list, void* value);

void list_addAt(List* list, int index, void* value);

void* list_get(List* list, int index);

void* list_set(List* list, int index, void* value);

void* list_removeAt(List* list, int index);

bool list_remove(List* list, void* value);

int list_removeAll(List* list, void* value);

bool list_contains(List* list, void* value);

int list_indexOf(List* list, void* value);

int list_lastIndexOf(List* list, void* value);

int list_size(List* list);

int list_capacity(List* list);

bool list_isEmpty(List* list);

void list_clear(List* list);

void list_resize(List* list, int new_capacity);

void list_trim(List* list);

void list_removeDuplicateOf(List* list, void* value);

List* list_withoutDuplicates(List* list);

List* list_clone(List* list);

void list_sort(List* list, list_comparator cmp);

void* list_mostAppearingElement(List* list);

int list_mostAppearingElementCount(List* list);

void* list_randomElement(List* list);

void list_print(List* list, void (*print_element)(void*));

void list_free(List* list);

#endif
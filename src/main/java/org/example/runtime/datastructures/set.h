#ifndef SET_H
#define SET_H
#include <stdbool.h>

#define DEFAULT_SET_CAPACITY 10

typedef struct Set {
    void** data;
    int size;
    int capacity;
} Set;

Set* init_set(void);

Set* set_create_with_capacity(int capacity);

bool set_add(Set* set, void* value);

bool set_remove(Set* set, void* value);

bool set_contains(Set* set, void* value);

bool set_isEmpty(Set* set);

int set_size(Set* set);

int set_capacity(Set* set);

void set_clear(Set* set);

void set_free(Set* set);

#endif
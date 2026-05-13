#ifndef HASHMAP_H
#define HASHMAP_H
#include <stdbool.h>

#define DEFAULT_HASHMAP_CAPACITY 10

typedef struct {
    void* key;
    void* value;
    bool used;
} HashMapEntry;

typedef struct HashMap {
    HashMapEntry* entries;
    int size;
    int capacity;
} HashMap;

HashMap* init_hashmap(void);

HashMap* hashmap_create_with_capacity(int capacity);

bool hashmap_put(HashMap* map, void* key, void* value);

void* hashmap_get(HashMap* map, void* key);

bool hashmap_remove(HashMap* map, void* key);

bool hashmap_containsKey(HashMap* map, void* key);

bool hashmap_isEmpty(HashMap* map);

int hashmap_size(HashMap* map);

int hashmap_capacity(HashMap* map);

void hashmap_clear(HashMap* map);

void hashmap_free(HashMap* map);

#endif
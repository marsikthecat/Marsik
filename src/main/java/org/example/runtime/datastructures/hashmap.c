#include "hashmap.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

static unsigned long _hashmap_hash(void* key, int capacity) {
    return (unsigned long)key % capacity;
}

static int _hashmap_find_entry(HashMap* map, void* key) {
    unsigned long index = _hashmap_hash(key, map->capacity);
    unsigned long start_index = index;

    while (map->entries[index].used) {
        if (map->entries[index].key == key) {
            return index;
        }
        index = (index + 1) % map->capacity;
        if (index == start_index) {
            return -1;
        }
    }

    return -1;
}

static int _hashmap_find_slot(HashMap* map, void* key) {
    unsigned long index = _hashmap_hash(key, map->capacity);
    unsigned long start_index = index;

    while (map->entries[index].used) {
        if (map->entries[index].key == key) {
            return index;
        }
        index = (index + 1) % map->capacity;
        if (index == start_index) {
            return -1;
        }
    }

    return index;
}

static void _hashmap_rehash(HashMap* map, int new_capacity) {
    HashMapEntry* old_entries = map->entries;
    int old_capacity = map->capacity;

    map->entries = (HashMapEntry*)malloc(new_capacity * sizeof(HashMapEntry));

    if (map->entries == NULL) {
        fprintf(stderr, "ERROR: Memory allocation failed during rehash\n");
        map->entries = old_entries;
        return;
    }

    for (int i = 0; i < new_capacity; i++) {
        map->entries[i].key = NULL;
        map->entries[i].value = NULL;
        map->entries[i].used = false;
    }

    map->capacity = new_capacity;
    int old_size = map->size;
    map->size = 0;

    for (int i = 0; i < old_capacity; i++) {
        if (old_entries[i].used) {
            hashmap_put(map, old_entries[i].key, old_entries[i].value);
        }
    }

    free(old_entries);
}

HashMap* init_hashmap(void) {
    return hashmap_create_with_capacity(DEFAULT_HASHMAP_CAPACITY);
}

HashMap* hashmap_create_with_capacity(int capacity) {
    HashMap* map = (HashMap*)malloc(sizeof(HashMap));

    if (map == NULL) {
        fprintf(stderr, "ERROR: Memory allocation failed for HashMap\n");
        return NULL;
    }

    if (capacity < 1) {
        capacity = DEFAULT_HASHMAP_CAPACITY;
    }

    map->entries = (HashMapEntry*)malloc(capacity * sizeof(HashMapEntry));

    if (map->entries == NULL) {
        fprintf(stderr, "ERROR: Memory allocation failed for HashMap entries\n");
        free(map);
        return NULL;
    }

    for (int i = 0; i < capacity; i++) {
        map->entries[i].key = NULL;
        map->entries[i].value = NULL;
        map->entries[i].used = false;
    }

    map->size = 0;
    map->capacity = capacity;

    return map;
}

bool hashmap_put(HashMap* map, void* key, void* value) {
    if (map == NULL) {
        fprintf(stderr, "ERROR: HashMap is NULL\n");
        return false;
    }

    if (key == NULL) {
        fprintf(stderr, "ERROR: Key cannot be NULL\n");
        return false;
    }

    if (map->size >= map->capacity * 0.75) {
        _hashmap_rehash(map, map->capacity * 2);
    }

    int index = _hashmap_find_slot(map, key);

    if (index == -1) {
        fprintf(stderr, "ERROR: HashMap is full\n");
        return false;
    }

    if (!map->entries[index].used) {
        map->size++;
    }

    map->entries[index].key = key;
    map->entries[index].value = value;
    map->entries[index].used = true;

    return true;
}

void* hashmap_get(HashMap* map, void* key) {
    if (map == NULL) {
        fprintf(stderr, "ERROR: HashMap is NULL\n");
        return NULL;
    }

    if (key == NULL) {
        fprintf(stderr, "ERROR: Key cannot be NULL\n");
        return NULL;
    }

    int index = _hashmap_find_entry(map, key);

    if (index == -1) {
        return NULL;
    }

    return map->entries[index].value;
}

bool hashmap_remove(HashMap* map, void* key) {
    if (map == NULL) {
        fprintf(stderr, "ERROR: HashMap is NULL\n");
        return false;
    }

    if (key == NULL) {
        fprintf(stderr, "ERROR: Key cannot be NULL\n");
        return false;
    }

    int index = _hashmap_find_entry(map, key);

    if (index == -1) {
        return false;
    }

    map->entries[index].used = false;
    map->entries[index].key = NULL;
    map->entries[index].value = NULL;
    map->size--;

    return true;
}

bool hashmap_containsKey(HashMap* map, void* key) {
    if (map == NULL) {
        fprintf(stderr, "ERROR: HashMap is NULL\n");
        return false;
    }

    if (key == NULL) {
        fprintf(stderr, "ERROR: Key cannot be NULL\n");
        return false;
    }

    return _hashmap_find_entry(map, key) != -1;
}

bool hashmap_isEmpty(HashMap* map) {
    if (map == NULL) {
        fprintf(stderr, "ERROR: HashMap is NULL\n");
        return true;
    }

    return map->size == 0;
}

int hashmap_size(HashMap* map) {
    if (map == NULL) {
        fprintf(stderr, "ERROR: HashMap is NULL\n");
        return 0;
    }

    return map->size;
}

int hashmap_capacity(HashMap* map) {
    if (map == NULL) {
        fprintf(stderr, "ERROR: HashMap is NULL\n");
        return 0;
    }

    return map->capacity;
}

void hashmap_clear(HashMap* map) {
    if (map == NULL) {
        fprintf(stderr, "ERROR: HashMap is NULL\n");
        return;
    }

    for (int i = 0; i < map->capacity; i++) {
        map->entries[i].key = NULL;
        map->entries[i].value = NULL;
        map->entries[i].used = false;
    }
    map->size = 0;
}

void hashmap_free(HashMap* map) {
    if (map == NULL) {
        return;
    }

    if (map->entries != NULL) {
        free(map->entries);
        map->entries = NULL;
    }

    free(map);
}
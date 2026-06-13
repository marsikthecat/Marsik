#pragma once

#include <stdbool.h>
#include <stdlib.h>
#include <stdio.h>
#include "../allocator/allocator.hpp"
#include "../error/error.hpp"

#define DEFAULT_HASHMAP_CAPACITY 10

template<typename K, typename V>
struct  HashMapEntry {
    K key;
    V value;
    bool used;
};

template<typename K, typename V>
struct HashMap {
    HashMapEntry<K, V>* entries;
    int size;
    int capacity;
};

template<typename K, typename V>
static unsigned long _hashmap_hash(K key, int capacity) {
    return (unsigned long)key % capacity;
}

template<typename K, typename V>
static int _hashmap_find_entry(HashMap<K, V>* map,const K& key) {
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

template<typename K, typename V>
static int _hashmap_find_slot(HashMap<K, V>* map, K key) {
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

template<typename K, typename V>
static void _hashmap_rehash(HashMap<K, V>* map, int new_capacity) {
    HashMapEntry* old_entries = map->entries;
    int old_capacity = map->capacity;

    map->entries = allocateFromMarsik(new_capacity * sizeof(HashMapEntry));
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

template<typename K, typename V>
HashMap<K, V> init_hashmap(int capacity) {
    HashMap<K, V> map;
    if (capacity < 1) {
        capacity = DEFAULT_HASHMAP_CAPACITY;
    }
    map.entries = allocateFromMarsik(capacity * sizeof(HashMapEntry));
    for (int i = 0; i < capacity; i++) {
        map.entries[i].key = NULL;
        map.entries[i].value = NULL;
        map.entries[i].used = false;
    }
    map.size = 0;
    map.capacity = capacity;
    return map;
}

template<typename K, typename V>
bool hashmap_put(HashMap<K, V>* map, K key, V value) {
    if (map->capacity >= map->capacity * 0.75) {
        _hashmap_rehash(map, map->capacity * 2);
    }
    int index = _hashmap_find_slot(map, key);
    if (index == -1) {
        runtimeError("HashMap is full");
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

template<typename K, typename V>
V hashmap_get(HashMap<K, V>* map, K key) {
    int index = _hashmap_find_entry(map, key);
    if (index == -1) {
        return NULL;
    }
    return map->entries[index].value;
}

template<typename K, typename V>
bool hashmap_remove(HashMap<K, V>* map, K key) {
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

template<typename K, typename V>
bool hashmap_containsKey(HashMap<K, V>* map, K key) {
    return _hashmap_find_entry(map, key) != -1;
}

template<typename K, typename V>
bool hashmap_isEmpty(HashMap<K, V>* map) {
    return map->size == 0;
}

template<typename K, typename V>
int hashmap_size(HashMap<K, V>* map) {
    return map->size;
}

template<typename K, typename V>
int hashmap_capacity(HashMap<K, V>* map) {
    return map->capacity;
}

template<typename K, typename V>
void hashmap_clear(HashMap<K, V>* map) {
    for (int i = 0; i < map->capacity; i++) {
        map->entries[i].key = NULL;
        map->entries[i].value = NULL;
        map->entries[i].used = false;
    }
    map->size = 0;
}
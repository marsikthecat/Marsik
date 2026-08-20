#pragma once
#include <stdbool.h>
#include <stdlib.h>
#include <stdio.h>
#include <string>
#include "set.hpp"
#include "../allocator/allocator.hpp"

using namespace std;

#define DEFAULT_HASHMAP_CAPACITY 10

template<typename V>
struct PerfectHashMapEntry {
    string key;
    V value;
};

template<typename V>
struct PerfectHashMap {
    PerfectHashMapEntry<V>* entries;
    Set<int> usedIndices;
    int size;
    int keysetSize;
};

template<typename V>
PerfectHashMap<V> init_perfecthashmap(int numberOfKeys) {
    PerfectHashMap<V> map;
    map.usedIndices = init_set(numberOfKeys);
    map.entries = allocateFromMarsik(numberOfKeys * sizeof(PerfectHashMapEntry<V>));
    map.size = 0;
    map.keysetSize = numberOfKeys;
    return map;
}

template<typename V>
bool perfecthashmap_defineKey(PerfectHashMap<V> map, const string& key) {
  int index = hash(key);
  if (set_contains(map.usedIndices, index)) {
    map.entries = allocateFromMarsik(map.entries, (map.keysetSize * 2) * sizeof(PerfectHashMapEntry<V>));
    map.keysetSize *= 2;
    map.entries[index].key = key;
  } else {
    PerfectHashMapEntry<V> entry;
    entry.key = key;
    set_add(map.usedIndices, index);
  }
  set_add(map.usedIndices, index);
}

static unsigned long hash(string key, int keysetSize) {
    return (unsigned long)key.c_str() % keysetSize;
}

template<typename V>
bool perfecthashmap_put(PerfectHashMap<V> map, const string& key, V value) {
    int index = hash(key, map.keysetSize);
    PerfectHashMapEntry<V> entry;
    entry.key = key;
    entry.value = value;
    map.entries[index] = entry;
}

template<typename V>
V perfecthashmap_get(PerfectHashMap<V> map, const string& key) {
    return map.entries[hash(key, map.keysetSize)].value;
}

template<typename V>
bool perfecthashmap_remove(PerfectHashMap<V> map, const string& key) {
    map.entries[hash(key, map.keysetSize)] = (PerfectHashMapEntry<V>) { .key = NULL, .value = NULL };
    return true;
}

template<typename V>
bool perfecthashmap_containsKey(PerfectHashMap<V> map, const string& key) {
    return set_contains(map.usedIndices, hash(key, map.keysetSize));
}

template<typename V>
bool perfecthashmap_isEmpty(PerfectHashMap<V> map) {
    return map.size == 0;
}

template<typename V>    
int perfecthashmap_size(PerfectHashMap<V> map) {
    return map.size;
}

template<typename V>
int perfecthashmap_capacity(PerfectHashMap<V> map) {
    return map.keysetSize;
}

template<typename V>
void perfecthashmap_clear(PerfectHashMap<V> map) {
    for (int i = 0; i < map.keysetSize; i++) {
        map.entries[i].key = NULL;
        map.entries[i].value = NULL;
    }
    map.size = 0;
}
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

static unsigned long _perfecthashmap_hash(const string& key, int keysetSize) {
    return std::hash<string>{}(key) % keysetSize;
}

template<typename V>
PerfectHashMap<V> init_perfecthashmap(int numberOfKeys) {
    PerfectHashMap<V> map;
    if (numberOfKeys < 1) {
        numberOfKeys = 1;
    }
    map.usedIndices = init_set<int>(numberOfKeys);
    map.entries = (PerfectHashMapEntry<V>*)allocateFromMarsik(numberOfKeys * sizeof(PerfectHashMapEntry<V>));
    map.size = 0;
    map.keysetSize = numberOfKeys;
    return map;
}

template<typename V>
bool perfecthashmap_defineKey(PerfectHashMap<V>& map, const string& key) {
    int index = _perfecthashmap_hash(key, map.keysetSize);
    if (set_contains(map.usedIndices, index)) {
        return false;
    }
    map.entries[index].key = key;
    map.entries[index].value = V();
    set_add(map.usedIndices, index);
    map.size++;
    return true;
}

template<typename V>
bool perfecthashmap_put(PerfectHashMap<V>& map, const string& key, V value) {
    int index = _perfecthashmap_hash(key, map.keysetSize);
    if (!set_contains(map.usedIndices, index) || map.entries[index].key != key) {
        return false;
    }
    PerfectHashMapEntry<V> entry;
    entry.key = key;
    entry.value = value;
    map.entries[index] = entry;
    return true;
}

template<typename V>
V perfecthashmap_get(const PerfectHashMap<V>& map, const string& key) {
    int index = _perfecthashmap_hash(key, map.keysetSize);
    if (!set_contains(map.usedIndices, index) || map.entries[index].key != key) {
        return V();
    }
    return map.entries[index].value;
}

template<typename V>
bool perfecthashmap_remove(PerfectHashMap<V>& map, const string& key) {
    int index = _perfecthashmap_hash(key, map.keysetSize);
    if (!set_contains(map.usedIndices, index) || map.entries[index].key != key) {
        return false;
    }
    map.entries[index].key = string();
    map.entries[index].value = V();
    set_remove(map.usedIndices, index);
    map.size--;
    return true;
}

template<typename V>
bool perfecthashmap_containsKey(const PerfectHashMap<V>& map, const string& key) {
    int index = _perfecthashmap_hash(key, map.keysetSize);
    return set_contains(map.usedIndices, index) && map.entries[index].key == key;
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
void perfecthashmap_clear(PerfectHashMap<V>& map) {
    for (int i = 0; i < map.keysetSize; i++) {
        map.entries[i].key = string();
        map.entries[i].value = V();
    }
    set_clear(map.usedIndices);
    map.size = 0;
}
#pragma once

#include <cstddef>
#include <cstdlib>
#include <string.h>
#include <stdio.h>
#include "../error/error.hpp"
#include "../allocator/allocator.hpp"
#include "./array.hpp"

#define DEFAULT_SPARSE_CAPACITY 10

using namespace std;

template <typename T>
struct SparseEntry {
    int index;
    T value;
    bool occupied;
};

template <typename T>
struct SparseArray {
    SparseEntry<T>* entries;   
    int* holes;           
    int size;                  
    int holeCount;  
    int capacity;             
    int holeCapacity;       
    int maxIndex;          
};

template <typename T>
SparseArray<T> init_sparsearray(int capacity) {
    if (capacity <= 0) {
        capacity = DEFAULT_SPARSE_CAPACITY;
    }
    SparseArray<T> sparse;
    sparse.entries = (SparseEntry<T>*)allocateFromMarsik(capacity * sizeof(SparseEntry<T>));
    sparse.holes = (int*)allocateFromMarsik(capacity * sizeof(int));
    sparse.size = 0;
    sparse.holeCount = 0;
    sparse.capacity = capacity;
    sparse.holeCapacity = capacity;
    sparse.maxIndex = -1;
    for (int i = 0; i < capacity; i++) {
        sparse.entries[i].occupied = false;
    }
    return sparse;
}

template <typename T>
void sparsearray_recordHole(SparseArray<T>& sparse, int index) {
    if (sparse.holeCount >= sparse.holeCapacity) {
        int new_capacity = sparse.holeCapacity * 2;
        int* new_holes = (int*)allocateFromMarsik(new_capacity * sizeof(int));
        memcpy(new_holes, sparse.holes, sparse.holeCount * sizeof(int));
        sparse.holes = new_holes;
        sparse.holeCapacity = new_capacity;
    }
    sparse.holes[sparse.holeCount++] = index;
}

template <typename T>
void sparsearray_set(SparseArray<T>& sparse, int index, const T& value) {
    if (index < 0) {
        runtimeError("Index cannot be negative");
        return;
    }
    for (int i = 0; i < sparse.size; i++) {
        if (sparse.entries[i].occupied && sparse.entries[i].index == index) {
            sparse.entries[i].value = value;
            return;
        }
    }
    for (int i = 0; i < sparse.holeCount; i++) {
        if (sparse.holes[i] == index) {
            for (int j = i; j < sparse.holeCount - 1; j++) {
                sparse.holes[j] = sparse.holes[j + 1];
            }
            sparse.holeCount--;
            break;
        }
    }
    if (sparse.size >= sparse.capacity) {
        int new_capacity = sparse.capacity * 2;
        SparseEntry<T>* new_entries = (SparseEntry<T>*)allocateFromMarsik(new_capacity * sizeof(SparseEntry<T>));
        memcpy(new_entries, sparse.entries, sparse.size * sizeof(SparseEntry<T>));
        sparse.entries = new_entries;
        sparse.capacity = new_capacity;
    }
    sparse.entries[sparse.size].index = index;
    sparse.entries[sparse.size].value = value;
    sparse.entries[sparse.size].occupied = true;
    sparse.size++;
    if (index > sparse.maxIndex) {
        for (int holeIndex = sparse.maxIndex + 1; holeIndex < index; holeIndex++) {
            sparsearray_recordHole(sparse, holeIndex);
        }
        sparse.maxIndex = index;
    }
}

template <typename T>
T sparsearray_get(const SparseArray<T>& sparse, int index) {
    if (index < 0 || index > sparse.maxIndex) {
        runtimeError("Index out of bounds");
        return T();
    }
    for (int i = 0; i < sparse.size; i++) {
        if (sparse.entries[i].occupied && sparse.entries[i].index == index) {
            return sparse.entries[i].value;
        }
    }
    runtimeWarning("No value set at this index, returning default value");
    return T();
}

template <typename T>
bool sparsearray_has(const SparseArray<T>& sparse, int index) {
    for (int i = 0; i < sparse.size; i++) {
        if (sparse.entries[i].occupied && sparse.entries[i].index == index) {
            return true;
        }
    }
    return false;
}

template <typename T>
void sparsearray_remove(SparseArray<T>& sparse, int index) {
    if (index < 0 || index > sparse.maxIndex) {
        runtimeError("Index out of bounds");
        return;
    }
    for (int i = 0; i < sparse.size; i++) {
        if (sparse.entries[i].occupied && sparse.entries[i].index == index) {
            sparse.entries[i].occupied = false;
            for (int j = i; j < sparse.size - 1; j++) {
                sparse.entries[j] = sparse.entries[j + 1];
            }
            sparse.size--;
            bool found = false;
            for (int j = 0; j < sparse.holeCount; j++) {
                if (sparse.holes[j] == index) {
                    found = true;
                    break;
                }
            }         
            if (!found) {
                    sparsearray_recordHole(sparse, index);
            }      
            return;
        }
    }
}
template <typename T>
T sparsearray_getRandomElement(const SparseArray<T>& sparse) {
    if (sparse.size == 0) {
        runtimeError("SparseArray is empty");
        return T();
    }
    static int seeded = 0;
    if (!seeded) {
        srand((unsigned int)time(nullptr));
        seeded = 1;
    }
    int randomIndex = rand() % sparse.size;
    return sparse.entries[randomIndex].value;
}

template <typename T>
int sparsearray_indexOf(const SparseArray<T>& sparse, const T& value) {
    for (int i = 0; i < sparse.size; i++) {
        if (sparse.entries[i].occupied && sparse.entries[i].value == value) {
            return sparse.entries[i].index;
        }
    }
    return -1;
}

template <typename T>
int sparsearray_lastIndexOf(const SparseArray<T>& sparse, const T& value) {
    for (int i = sparse.size - 1; i >= 0; i--) {
        if (sparse.entries[i].occupied && sparse.entries[i].value == value) {
            return sparse.entries[i].index;
        }
    }
    return -1;
}

template <typename T>
bool sparsearray_contains(const SparseArray<T>& sparse, const T& value) {
    return sparsearray_indexOf(sparse, value) != -1;
}

template <typename T>
int sparsearray_firstfreeSpot(const SparseArray<T>& sparse) {
    for (int i = 0; i <= sparse.maxIndex; i++) {
        if (!sparsearray_has(sparse, i)) {
            return i;
        }
    }
    return -1;
}

template <typename T>
int sparsearray_lastfreeSpot(const SparseArray<T>& sparse) {
    for (int i = sparse.maxIndex; i >= 0; i--) {
        if (!sparsearray_has(sparse, i)) {
            return i;
        }
    }
    return -1;
}

template <typename T>
void sparsearray_pushfromStart(SparseArray<T>& sparse, const T& value) {
    int index = sparsearray_firstfreeSpot(sparse);
    if (index == -1) {
        index = sparse.maxIndex + 1;
    }
    sparsearray_set(sparse, index, value);
}

template <typename T>
void sparsearray_pushfromEnd(SparseArray<T>& sparse, const T& value) {
    int index = sparsearray_lastfreeSpot(sparse);
    if (index == -1) {
        index = sparse.maxIndex + 1;
    }
    sparsearray_set(sparse, index, value);
}  

template <typename T>
Array<T> sparsearray_toArray(const SparseArray<T>& sparse) {
    Array<T> arr{};
    arr.length = sparse.size;
    int arrIndex = 0;
    for (int i = 0; i < sparse.size; i++) {
        arr.data[arrIndex++] = sparse.entries[i].value;
    }
    return arr;
}

template <typename T>
int sparsearray_size(const SparseArray<T>& sparse) {
    return sparse.size;
}

template <typename T>
int sparsearray_holeCount(const SparseArray<T>& sparse) {
    return sparse.holeCount;
}

template <typename T>
int sparsearray_maxIndex(const SparseArray<T>& sparse) {
    return sparse.maxIndex;
}

template <typename T>
bool sparsearray_isEmpty(const SparseArray<T>& sparse) {
    return sparse.size == 0;
}

template <typename T>
void sparsearray_clear(SparseArray<T>& sparse) {
    sparse.size = 0;
    sparse.holeCount = 0;
    sparse.maxIndex = -1;
    for (int i = 0; i < sparse.capacity; i++) {
        sparse.entries[i].occupied = false;
    }
}

template <typename T>
void sparsearray_printArray(const SparseArray<T>& sparse) {
    printf("SparseArray { size: %d, maxIndex: %d, holes: [", sparse.size, sparse.maxIndex);
    for (int i = 0; i < sparse.holeCount; i++) {
        printf("%d", sparse.holes[i]);
        if (i < sparse.holeCount - 1) {
            printf(", ");
        }
    }
    printf("], values: {");
    int count = 0;
    for (int i = 0; i < sparse.size; i++) {
        if (sparse.entries[i].occupied) {
            printf("%d -> %d", sparse.entries[i].index, (int)sparse.entries[i].value);
            if (count++ < sparse.size - 1) {
                printf(", ");
            }
        }
    }
    printf("} }\n");
}

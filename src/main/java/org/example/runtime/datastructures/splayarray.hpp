#pragma once

#include <cstddef>
#include <cstdlib>
#include <ctime>
#include <stdio.h>
#include <stdbool.h>
#include <string>
#include "../error/error.hpp"

#define DEFAULT_SPLAY_ARRAY_CAPACITY 10

using namespace std;

template<typename T>
struct SplayArray {
    T data[DEFAULT_SPLAY_ARRAY_CAPACITY];
    int visited[DEFAULT_SPLAY_ARRAY_CAPACITY];
    int length;
    string type;
};

template<typename T>
SplayArray<T> init_splayarray() {
    SplayArray<T> arr;
    arr.length = 0;
    for (int i = 0; i < DEFAULT_SPLAY_ARRAY_CAPACITY; i++) {
        arr.visited[i] = 0;
    }
    return arr;
}

template<typename T>
void updateVisited(SplayArray<T> arr, int index) {
    arr.visited[index]++;
}

template<typename T>
void splayarray_removeAt(SplayArray<T> arr, int index) {
    if (index < 0 || index >= arr.length) {
        runtimeError("Index out of bounds");
        return;
    }
    arr.data[index] = NULL;
    arr.visited[index] = 0;
}

template<typename T>
void splayarray_set(SplayArray<T> arr, int index, const T& element) {
    if (index < 0 || index >= arr.length) {
        runtimeError("Index out of bounds");
        return;
    }
    arr.data[index] = element;
    updateVisited(arr, index);
}

template<typename T>
T splayarray_get(SplayArray<T> arr, int index) {
    if (index < 0 || index >= arr.length) {
        runtimeError("Index out of bounds");
        return T();
    }
    updateVisited(arr, index);
    return arr.data[index];
}

template<typename T>
int splayarray_length(const SplayArray<T> arr) {
    return arr.length;
}

template<typename T>
int splayarray_memorySize(const SplayArray<T> arr) {
    return sizeof(T) * arr.length;
}

template<typename T>
bool splayarray_isEmpty(const SplayArray<T> arr) {
    return arr.length == 0;
}

template<typename T>
bool splayarray_contains(const SplayArray<T> arr, const T& element) {
    return splayarray_indexOf(arr, element) != -1;
}

template<typename T>
int splayarray_indexOf(const SplayArray<T> arr, const T& element) {
    for (int i = 0; i < arr.length; i++) {
        if (arr.data[i] == element) {
            updateVisited(arr, i);
            return i;
        }
    }
    return -1;
}

template<typename T>
T splayarray_getRandomElement(const SplayArray<T> arr) {
    if (arr.length == 0) {
        runtimeError("Array is empty");
        return T();
    }
    static int seeded = 0;
    if (!seeded) {
        srand((unsigned int)time(NULL));
        seeded = 1;
    }
    int randomIndex = rand() % arr.length;
    updateVisited(arr, randomIndex);
    return arr.data[randomIndex];
}

template<typename T>
SplayArray<T> splayarray_slice(const SplayArray<T> arr, int start, int end) {
    if (start < 0 || end > arr.length || start >= end) {
        runtimeError("Invalid arguments for splayarray slice");
        return SplayArray<T>{nullptr, 0, 0};
    }
    int newLength = end - start;

    T* newData = new T[newLength];

    for (int i = 0; i < newLength; i++) {
        newData[i] = arr.data[start + i];
    }
    return SplayArray<T>{newData, newLength, newLength};
}

template<typename T>
void splayarray_reverse(SplayArray<T> arr) {
    for (int i = 0; i < arr.length / 2; i++) {
        T temp = arr.data[i];
        arr.data[i] = arr.data[arr.length - 1 - i];
        arr.data[arr.length - 1 - i] = temp;
    }
}

template<typename T>
void splayarray_removeDuplicates(SplayArray<T> arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr.data[i] == arr.data[j]) {
                splayarray_removeAt(arr, j);
                j--;
            }
        }
    }
}

template<typename T>
void splayarray_removeDuplicateOf(SplayArray<T> arr, const T& element) {
    for (int i = 0; i < arr.length; i++) {
        if (arr.data[i] == element) {
            splayarray_removeAt(arr, i);
            i--;
        }
    }
}

template<typename T>
void splayarray_sort(SplayArray<T> arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr.data[j + 1] < arr.data[j]) {
                T tmp = arr.data[j];
                arr.data[j] = arr.data[j + 1];
                arr.data[j + 1] = tmp;
            }
        }
    }
}

template<typename T>
SplayArray<T> splayarray_clone(const SplayArray<T> arr) {
    SplayArray<T> copy;
    copy.length = arr.length;
    copy.capacity = arr.length;
    copy.data = new T[arr.length];
    for (int i = 0; i < arr.length; i++) {
        copy.data[i] = arr.data[i];
    }
    return copy;
}

template<typename T>
T splayarray_mostAppearingElement(const SplayArray<T> arr) {
    if (arr.length == 0) {
        return T();
    }
    T mostFrequentElement = arr.data[0];
    int maxCount = 1;
    for (int i = 0; i < arr.length; i++) {
        T currentElement = arr.data[i];
        int count = 1;
        for (int j = i + 1; j < arr.length; j++) {
            T nextElement = arr.data[j];
            if (currentElement == nextElement) {
                count++;
            }
        }
        if (count > maxCount) {
            maxCount = count;
            mostFrequentElement = currentElement;
        }
    }
    return mostFrequentElement;
}

template<typename T>
void splayarray_printArray(const SplayArray<T> arr) {
    printf("[");
    for (int i = 0; i < arr.length; i++) {
        printf("%d", arr.data[i]);
        if (i < arr.length - 1) {
            printf(", ");
        }
    }
    printf("]\n");
}

template<typename T>
void splayarray_shuffle(SplayArray<T> arr) {
    static int seeded = 0;
    if (!seeded) {
        srand((unsigned int)time(NULL));
        seeded = 1;
    }
    for (int i = arr.length - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        T temp = arr.data[i];
        arr.data[i] = arr.data[j];
        arr.data[j] = temp;
    }
}

template<typename T>
bool splayarray_isNumericArray(const SplayArray<T> arr) {
    return arr.type == "int" ||  arr.type == "double";
}

template<typename T>
void splayarray_rearrange(SplayArray<T> arr) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (arr.visited[j + 1] > arr.visited[j]) {
                T tempData = arr.data[j];
                int tempVisited = arr.visited[j];
                arr.data[j] = arr.data[j + 1];
                arr.visited[j] = arr.visited[j + 1];
                arr.data[j + 1] = tempData;
                arr.visited[j + 1] = tempVisited;
            }
        }
    }
}

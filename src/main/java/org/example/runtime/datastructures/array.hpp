#pragma once

#include <cstddef>
#include <cstdlib>
#include <ctime>
#include <stdio.h>
#include <stdbool.h>
#include <string>
#include "../error/error.hpp"

using namespace std;

#define DEFAULT_ARRAY_CAPACITY 10

template<typename T>
struct Array {
    T data[DEFAULT_ARRAY_CAPACITY];
    int length;
    string type;
};

template<typename T>
void array_removeAt(Array<T>* arr, int index) {
    if (index < 0 || index >= arr->length) {
        runtimeError("Index out of bounds");
        return;
    }
    arr->data[index] = NULL;
}

template<typename T>
void array_set(Array<T>* arr, int index, const T& element) {
    if (index < 0 || index >= arr->length) {
        runtimeError("Index out of bounds");
        return;
    }
    arr->data[index] = element;
}

template<typename T>
T array_get(Array<T>* arr, int index) {
    if (index < 0 || index >= arr->length) {
        runtimeError("Index out of bounds");
        return T();
    }
    return arr->data[index];
}

template<typename T>
int array_length(const Array<T>* arr) {
    return arr->length;
}

template<typename T>
int array_memorySize(const Array<T>* arr) {
    return sizeof(T) * arr->length;
}

template<typename T>
bool array_isEmpty(const Array<T>* arr) {
    return arr->length == 0;
}

template<typename T>
bool array_contains(const Array<T>* arr, const T& element) {
    return array_indexOf(arr, element) != -1;
}

template<typename T>
int array_indexOf(const Array<T>* arr, const T& element) {
    for (int i = 0; i < arr->length; i++) {
        if (arr->data[i] == element) {
            return i;
        }
    }
    return -1;
}

template<typename T>
T array_getRandomElement(const Array<T>* arr) {
    if (arr->length == 0) {
        runtimeError("Array is empty");
        return T();
    }
    static int seeded = 0;
    if (!seeded) {
        srand((unsigned int)time(NULL));
        seeded = 1;
    }
    int randomIndex = rand() % arr->length;
    return arr->data[randomIndex];
}

template<typename T>
Array<T> array_slice(const Array<T>* arr, int start, int end) {
    if (start < 0 || end > arr->length || start >= end) {
        runtimeError("Invalid arguments for array slice");
        return Array<T>{nullptr, 0, 0};
    }
    int newLength = end - start;

    T* newData = new T[newLength];

    for (int i = 0; i < newLength; i++) {
        newData[i] = arr->data[start + i];
    }
    return Array<T>{newData, newLength, newLength};
}

template<typename T>
void array_reverse(Array<T>* arr) {
    for (int i = 0; i < arr->length / 2; i++) {
        T temp = arr->data[i];
        arr->data[i] = arr->data[arr->length - 1 - i];
        arr->data[arr->length - 1 - i] = temp;
    }
}

template<typename T>
void array_removeDuplicates(Array<T>* arr) {
    for (int i = 0; i < arr->length; i++) {
        for (int j = i + 1; j < arr->length; j++) {
            if (arr->data[i] == arr->data[j]) {
                array_removeAt(arr, j);
                j--;
            }
        }
    }
}

template<typename T>
void array_removeDuplicateOf(Array<T>* arr, const T& element) {
    for (int i = 0; i < arr->length; i++) {
        if (arr->data[i] == element) {
            array_removeAt(arr, i);
            i--;
        }
    }
}

template<typename T>
void array_sort(Array<T>* arr) {
    for (int i = 0; i < arr->length - 1; i++) {
        for (int j = 0; j < arr->length - i - 1; j++) {
            if (arr->data[j + 1] < arr->data[j]) {
                T tmp = arr->data[j];
                arr->data[j] = arr->data[j + 1];
                arr->data[j + 1] = tmp;
            }
        }
    }
}

template<typename T>
Array<T> array_clone(const Array<T>* arr) {
    Array<T> copy;
    copy.length = arr->length;
    copy.capacity = arr->length;
    copy.data = new T[arr->length];
    for (int i = 0; i < arr->length; i++) {
        copy.data[i] = arr->data[i];
    }
    return copy;
}

template<typename T>
T array_mostAppearingElement(const Array<T>* arr) {
    if (arr->length == 0) {
        return T();
    }
    T mostFrequentElement = arr->data[0];
    int maxCount = 1;
    for (int i = 0; i < arr->length; i++) {
        T currentElement = arr->data[i];
        int count = 1;
        for (int j = i + 1; j < arr->length; j++) {
            T nextElement = arr->data[j];
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
void array_printArray(const Array<T>* arr) {
    printf("[");
    for (int i = 0; i < arr->length; i++) {
        printf("%d", arr->data[i]);
        if (i < arr->length - 1) {
            printf(", ");
        }
    }
    printf("]\n");
}

template<typename T>
void array_shuffle(Array<T>* arr) {
    static int seeded = 0;
    if (!seeded) {
        srand((unsigned int)time(NULL));
        seeded = 1;
    }
    for (int i = arr->length - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        T temp = arr->data[i];
        arr->data[i] = arr->data[j];
        arr->data[j] = temp;
    }
}

template<typename T>
bool arr_isNumericArray(const Array<T>* arr) {
    return arr->type == "int" ||  arr->type == "double";
}
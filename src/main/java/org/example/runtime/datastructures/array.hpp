#pragma once

#include <cstddef>
#include <cstdlib>
#include <ctime>
#include <stdio.h>
#include <stdbool.h>
#include <string>
#include "../error/error.hpp"

#define DEFAULT_ARRAY_CAPACITY 10

using namespace std;

template<typename T>
struct Array {
    T data[DEFAULT_ARRAY_CAPACITY];
    int length;
    string type;
};

template<typename T>
void array_set(Array<T>& arr, int index, const T& element) {
    if (index < 0 || index >= arr.length) {
        runtimeError("Index out of bounds");
        return;
    }
    arr.data[index] = element;
}

template<typename T>
T array_get(const Array<T>& arr, int index) {
    if (index < 0 || index >= arr.length) {
        runtimeError("Index out of bounds");
        return T();
    }
    return arr.data[index];
}

template<typename T>
int array_length(const Array<T>& arr) {
    return arr.length;
}

template<typename T>
int array_memorySize(const Array<T>& arr) {
    return sizeof(T) * arr.length;
}

template<typename T>
bool array_isEmpty(const Array<T>& arr) {
    return arr.length == 0;
}

template<typename T>
bool array_contains(const Array<T>& arr, const T& element) {
    return array_indexOf(arr, element) != -1;
}

template<typename T>
int array_indexOf(const Array<T>& arr, const T& element) {
    for (int i = 0; i < arr.length; i++) {
        if (arr.data[i] == element) {
            return i;
        }
    }
    return -1;
}

template<typename T>
T array_getRandomElement(const Array<T>& arr) {
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
    return arr.data[randomIndex];
}

template<typename T>
T array_getRandomElementFromRange(const Array<T>& arr, int start, int end) {
    if (start < 0 || end > arr.length || start >= end) {
        runtimeError("Invalid range for array");
        return T();
    }
    static int seeded = 0;
    if (!seeded) {
        srand((unsigned int)time(NULL));
        seeded = 1;
    }
    int randomIndex = start + (rand() % (end - start));
    return arr.data[randomIndex];
}

template<typename T>
Array<T> array_slice(const Array<T>& arr, int start, int end) {
    if (start < 0 || end > arr.length || start >= end) {
        runtimeError("Invalid arguments for array slice");
        return Array<T>{T(), 0, 0};
    }
    int newLength = end - start;
    Array<T> result{};
    result.length = newLength;
    result.type = arr.type;

    for (int i = 0; i < newLength; i++) {
        result.data[i] = arr.data[start + i];
    }
    return result;
}

template<typename T>
void array_reverse(Array<T>& arr) {
    for (int i = 0; i < arr.length / 2; i++) {
        T temp = arr.data[i];
        arr.data[i] = arr.data[arr.length - 1 - i];
        arr.data[arr.length - 1 - i] = temp;
    }
}

template<typename T>
void array_sort(Array<T>& arr) {
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
Array<T> array_clone(const Array<T>& arr) {
    Array<T> copy{};
    copy.length = arr.length;
    copy.type = arr.type;
    for (int i = 0; i < arr.length; i++) {
        copy.data[i] = arr.data[i];
    }
    return copy;
}

template<typename T>
T array_mostAppearingElement(const Array<T>& arr) {
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
int array_mostAppearingElementCount(Array<T>& arr) {
    if (arr.length == 0) {
        return 0;
    }
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
        }
    }
    return maxCount;
}

template<typename T>
void array_printArray(Array<T>& arr) {
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
Array<T> array_unionWith(Array<T>& arr1, Array<T>& arr2) {
    Array<T> result{};
    result.length = 0;
    result.type = arr1.type;
    for (int i = 0; i < arr1.length; i++) {
        result.data[result.length++] = arr1.data[i];
    }
    for (int j = 0; j < arr2.length; j++) {
        T element = arr2.data[j];
        if (!array_contains(result, element)) {
            result.data[result.length++] = element;
        }
    }
    return result;
}

template<typename T>
Array<T> array_intersectionWith(Array<T>& arr1, Array<T>& arr2) {
    Array<T> result{};
    result.length = 0;
    result.type = arr1.type;
    for (int i = 0; i < arr1.length; i++) {
        T element = arr1.data[i];
        if (array_contains(arr2, element) && !array_contains(result, element)) {
            result.data[result.length++] = element;
        }
    }
    return result;
}

template<typename T>
bool array_containsDuplicateElements(Array<T>& arr) {
    for (int i = 0; i < arr.length; i++) {
        T currentElement = arr.data[i];
        for (int j = i + 1; j < arr.length; j++) {
            if (currentElement == arr.data[j]) {
                return true;
            }
        }
    }
    return false;
}

template<typename T>
void array_shuffle(Array<T>& arr) {
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
bool array_isNumericArray(Array<T>& arr) {
    return arr.type == "int" ||  arr.type == "double";
}
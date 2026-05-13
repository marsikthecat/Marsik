#include "arrayutils.h"
#include "types.h"
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <time.h>

void array_set(struct Array *arr, int index, void *element) {
    if (index < 0 || index >= arr->length) {
        return;
    }
    void *targetElement = (char *)arr->data + index * arr->elementSize;
    memcpy(targetElement, element, arr->elementSize);
}

void* array_get(struct Array *arr, int index) {
    if (index < 0 || index >= arr->length) {
        return NULL;
    }
    return (char *)arr->data + index * arr->elementSize;
}

int array_length(struct Array *arr) {
    return arr->length;
}

int array_memorySize(struct Array *arr) {
    return arr->elementSize * arr->length;
}

bool array_isEmpty(struct Array *arr) {
    return arr->length == 0;
}

bool array_contains(struct Array *arr, void *element) {
    for (int i = 0; i < arr->length; i++) {
        void *currentElement = (char *)arr->data + i * arr->elementSize;
        if (compare(currentElement, element, arr->type) == 0) {
            return true;
        }
    }
    return false;
}

int array_indexOf(struct Array *arr, void *element) {
    for (int i = 0; i < arr->length; i++) {
        void *currentElement = (char *)arr->data + i * arr->elementSize;
        if (compare(currentElement, element, arr->type) == 0) {
            return i;
        }
    }
    return -1;
}

void array_getRandomElement(struct Array *arr, void *result) {
    if (arr->length == 0) {
        return;
    }
    static int seeded = 0;
    if (!seeded) {
        srand((unsigned int)time(NULL));
        seeded = 1;
    }
    int randomIndex = rand() % arr->length;
    void *randomElement = (char *)arr->data + randomIndex * arr->elementSize;
    memcpy(result, randomElement, arr->elementSize);
}

void array_slice(struct Array *arr, int start, int end) {
    if (start < 0 || end > arr->length || start >= end) {
        return;
    }
    int newLength = end - start;
    void *newData = malloc(newLength * arr->elementSize);
    memcpy(newData, (char *)arr->data + start * arr->elementSize, newLength * arr->elementSize);
    free(arr->data);
    arr->data = newData;
    arr->length = newLength;
}

void array_reverse(struct Array *arr) {
    for (int i = 0; i < arr->length / 2; i++) {
        void *temp = malloc(arr->elementSize);
        void *firstElement = (char *)arr->data + i * arr->elementSize;
        void *secondElement = (char *)arr->data + (arr->length - 1 - i) * arr->elementSize;
        memcpy(temp, firstElement, arr->elementSize);
        memcpy(firstElement, secondElement, arr->elementSize);
        memcpy(secondElement, temp, arr->elementSize);
        free(temp);
    }
}

void array_removeDuplicates(struct Array *arr) {
    if (arr->length == 0) {
        return;
    }
    int newLength = 1;
    for (int i = 1; i < arr->length; i++) {
        void *currentElement = (char *)arr->data + i * arr->elementSize;
        bool isDuplicate = false;
        for (int j = 0; j < newLength; j++) {
            void *uniqueElement = (char *)arr->data + j * arr->elementSize;
            if (compare(currentElement, uniqueElement, arr->type) == 0) {
                isDuplicate = true;
                break;
            }
        }
        if (!isDuplicate) {
            void *newElement = (char *)arr->data + newLength * arr->elementSize;
            memcpy(newElement, currentElement, arr->elementSize);
            newLength++;
        }
    }
    arr->length = newLength;
}

void array_removeDuplicateOf(struct Array *arr, void *element) {
    int newLength = 0;
    for (int i = 0; i < arr->length; i++) {
        void *currentElement = (char *)arr->data + i * arr->elementSize;
        if (compare(currentElement, element, arr->type) != 0) {
            void *newElement = (char *)arr->data + newLength * arr->elementSize;
            memcpy(newElement, currentElement, arr->elementSize);
            newLength++;
        }
    }
    arr->length = newLength;
}

void array_sort(struct Array *arr) {
    for (int i = 0; i < arr->length - 1; i++) {
        for (int j = 0; j < arr->length - i - 1; j++) {
            void *currentElement = (char *)arr->data + j * arr->elementSize;
            void *nextElement = (char *)arr->data + (j + 1) * arr->elementSize;
            if (compare(currentElement, nextElement, arr->type) > 0) {
                void *temp = malloc(arr->elementSize);
                memcpy(temp, currentElement, arr->elementSize);
                memcpy(currentElement, nextElement, arr->elementSize);
                memcpy(nextElement, temp, arr->elementSize);
                free(temp);
            }
        }
    }
}

struct Array* array_clone(struct Array *arr) {
    struct Array *newArr = (struct Array*)malloc(sizeof(struct Array));
    if (newArr == NULL) {
        return NULL;
    }

    newArr->data = malloc(arr->elementSize * arr->length);
    if (newArr->data == NULL) {
        free(newArr);
        return NULL;
    }

    memcpy(newArr->data, arr->data, arr->elementSize * arr->length);
    newArr->elementSize = arr->elementSize;
    newArr->length = arr->length;
    newArr->type = arr->type;

    return newArr;
}

void* array_mostAppearingElement(struct Array *arr) {
    if (arr->length == 0) {
        return NULL;
    }
    void *mostFrequentElement = arr->data;
    int maxCount = 1;
    for (int i = 0; i < arr->length; i++) {
        void *currentElement = (char *)arr->data + i * arr->elementSize;
        int count = 1;
        for (int j = i + 1; j < arr->length; j++) {
            void *nextElement = (char *)arr->data + j * arr->elementSize;
            if (compare(currentElement, nextElement, arr->type) == 0) {
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

void array_printArray(struct Array *arr) {
    printf("[");
    for (int i = 0; i < arr->length; i++) {
        void *currentElement = (char *)arr->data + i * arr->elementSize;
        switch (arr->type) {
            case INT:
                printf("%d", *(int*)currentElement);
                break;
            case DOUBLE:
                printf("%f", *(double*)currentElement);
                break;
            case CHAR:
                printf("'%c'", *(char*)currentElement);
                break;
            case BOOL:
                printf("%s", *(bool*)currentElement ? "true" : "false");
                break;
            case STRING:
                printf("\"%s\"", *(char**)currentElement);
                break;
            case OBJECT:
                printf("%p", currentElement);
                break;
        }
        if (i < arr->length - 1) {
            printf(", ");
        }
    }
    printf("]\n");
}

void array_shuffle(struct Array *arr) {
    for (int i = arr->length - 1; i > 0; i--) {
        int j = rand() % (i + 1);
        void *temp = malloc(arr->elementSize);
        void *currentElement = (char *)arr->data + i * arr->elementSize;
        void *randomElement = (char *)arr->data + j * arr->elementSize;
        memcpy(temp, currentElement, arr->elementSize);
        memcpy(currentElement, randomElement, arr->elementSize);
        memcpy(randomElement, temp, arr->elementSize);
        free(temp);
    }
}

bool array_isNumericArray(struct Array *arr) {
    return arr->type == INT || arr->type == DOUBLE;
}
#ifndef ARRAYUTILS_H
#define ARRAYUTILS_H

#include <stdio.h>
#include <stdbool.h>
#include "../types.h"

typedef struct Array {
    void *data;
    size_t elementSize;
    int length;
    Types type;
} Array;

void array_set(struct Array *arr, int index, void *element);

void* array_get(struct Array *arr, int index);

int array_length(struct Array *arr);

int array_memorySize(struct Array *arr);

bool array_isEmpty(struct Array *arr);

bool array_contains(struct Array *arr, void *element);

int array_indexOf(struct Array *arr, void *element);

void array_getRandomElement(struct Array *arr, void *result);

void array_slice(struct Array *arr, int start, int end);

void array_reverse(struct Array *arr);

void array_removeDuplicates(struct Array *arr);

void array_removeDuplicateOf(struct Array *arr, void *element);

void array_sort(struct Array *arr);

struct Array* array_clone(struct Array *arr);

void* array_mostAppearingElement(struct Array *arr);

void array_printArray(struct Array *arr);

void array_shuffle(struct Array *arr);

bool arr_isNumericArray(struct Array *arr);

#endif
#pragma once

#include <stdbool.h>
#include <string>

using namespace std;

typedef enum {
    TYPE_INT,
    TYPE_FLOAT,
    TYPE_DOUBLE,
    TYPE_CHAR,
    TYPE_BOOL,
    TYPE_STRING,
} GenericType;

typedef struct {
    GenericType type;
    int array_index;
} PositionInfo;

typedef struct GenericList{
    int* int_array;
    float* float_array;
    double* double_array;
    char* char_array;
    bool* bool_array;
    string* string_array;

    int int_capacity, float_capacity, double_capacity, char_capacity, bool_capacity, string_capacity;
    int int_size, float_size, double_size, char_size, bool_size, string_size;

    PositionInfo* positions;
    int size;
    int capacity;
} GenericList;

GenericList init_genericlist();

void genericlist_addInt(GenericList* list, int value);

void genericlist_addFloat(GenericList* list, float value);

void genericlist_addDouble(GenericList* list, double value);

void genericlist_addChar(GenericList* list, char value);

void genericlist_addBool(GenericList* list, bool value);

void genericlist_addString(GenericList* list, string*value);

void* genericlist_get(GenericList* list, int index);

GenericType genericlist_getType(GenericList* list, int index);

void genericlist_remove(GenericList* list, int index);

bool genericlist_contains(GenericList* list, void* value);

int genericlist_indexOf(GenericList* list, void* value);

int genericlist_size(GenericList* list);

bool genericlist_isEmpty(GenericList* list);

void genericlist_clear(GenericList* list);

bool genericlist_allNumeric(GenericList* list);

bool genericlist_allStrings(GenericList* list);

bool genericlist_allSameType(GenericList* list);
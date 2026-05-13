#include "genericlist.h"
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "../string.h"

#define DEFAULT_CAPACITY 10

static void _genericlist_ensure_capacity(GenericList* list) {
    if (list->size >= list->capacity) {
        int new_capacity = list->capacity == 0 ? DEFAULT_CAPACITY : list->capacity * 2;
        PositionInfo* new_positions = (PositionInfo*)malloc(new_capacity * sizeof(PositionInfo));

        if (new_positions == NULL) {
            fprintf(stderr, "ERROR: Memory allocation failed\n");
            return;
        }
        if (list->positions != NULL) {
            memcpy(new_positions, list->positions, list->size * sizeof(PositionInfo));
            free(list->positions);
        }
        list->positions = new_positions;
        list->capacity = new_capacity;
    }
}

static void _genericlist_ensure_int_capacity(GenericList* list) {
    if (list->int_size >= list->int_capacity) {
        int new_capacity = list->int_capacity == 0 ? DEFAULT_CAPACITY : list->int_capacity * 2;
        int* new_array = (int*)malloc(new_capacity * sizeof(int));

        if (new_array == NULL) {
            fprintf(stderr, "ERROR: Memory allocation failed\n");
            return;
        }
        if (list->int_array != NULL) {
            memcpy(new_array, list->int_array, list->int_size * sizeof(int));
            free(list->int_array);
        }
        list->int_array = new_array;
        list->int_capacity = new_capacity;
    }
}

static void _genericlist_ensure_float_capacity(GenericList* list) {
    if (list->float_size >= list->float_capacity) {
        int new_capacity = list->float_capacity == 0 ? DEFAULT_CAPACITY : list->float_capacity * 2;
        float* new_array = (float*)malloc(new_capacity * sizeof(float));

        if (new_array == NULL) {
            fprintf(stderr, "ERROR: Memory allocation failed\n");
            return;
        }
        if (list->float_array != NULL) {
            memcpy(new_array, list->float_array, list->float_size * sizeof(float));
            free(list->float_array);
        }
        list->float_array = new_array;
        list->float_capacity = new_capacity;
    }
}

static void _genericlist_ensure_double_capacity(GenericList* list) {
    if (list->double_size >= list->double_capacity) {
        int new_capacity = list->double_capacity == 0 ? DEFAULT_CAPACITY : list->double_capacity * 2;
        double* new_array = (double*)malloc(new_capacity * sizeof(double));

        if (new_array == NULL) {
            fprintf(stderr, "ERROR: Memory allocation failed\n");
            return;
        }
        if (list->double_array != NULL) {
            memcpy(new_array, list->double_array, list->double_size * sizeof(double));
            free(list->double_array);
        }
        list->double_array = new_array;
        list->double_capacity = new_capacity;
    }
}

static void _genericlist_ensure_char_capacity(GenericList* list) {
    if (list->char_size >= list->char_capacity) {
        int new_capacity = list->char_capacity == 0 ? DEFAULT_CAPACITY : list->char_capacity * 2;
        char* new_array = (char*)malloc(new_capacity * sizeof(char));

        if (new_array == NULL) {
            fprintf(stderr, "ERROR: Memory allocation failed\n");
            return;
        }
        if (list->char_array != NULL) {
            memcpy(new_array, list->char_array, list->char_size * sizeof(char));
            free(list->char_array);
        }
        list->char_array = new_array;
        list->char_capacity = new_capacity;
    }
}

static void _genericlist_ensure_bool_capacity(GenericList* list) {
    if (list->bool_size >= list->bool_capacity) {
        int new_capacity = list->bool_capacity == 0 ? DEFAULT_CAPACITY : list->bool_capacity * 2;
        bool* new_array = (bool*)malloc(new_capacity * sizeof(bool));

        if (new_array == NULL) {
            fprintf(stderr, "ERROR: Memory allocation failed\n");
            return;
        }
        if (list->bool_array != NULL) {
            memcpy(new_array, list->bool_array, list->bool_size * sizeof(bool));
            free(list->bool_array);
        }
        list->bool_array = new_array;
        list->bool_capacity = new_capacity;
    }
}

static void _genericlist_ensure_string_capacity(GenericList* list) {
    if (list->string_size >= list->string_capacity) {
        int new_capacity = list->string_capacity == 0 ? DEFAULT_CAPACITY : list->string_capacity * 2;
        string* new_array = (string*)malloc(new_capacity * sizeof(string));

        if (new_array == NULL) {
            fprintf(stderr, "ERROR: Memory allocation failed\n");
            return;
        }
        if (list->string_array != NULL) {
            memcpy(new_array, list->string_array, list->string_size * sizeof(string));
            free(list->string_array);
        }
        list->string_array = new_array;
        list->string_capacity = new_capacity;
    }
}

GenericList* init_genericlist(void) {
    GenericList* list = (GenericList*)malloc(sizeof(GenericList));
    if (list == NULL) {
        fprintf(stderr, "ERROR: Memory allocation failed for GenericList\n");
        return NULL;
    }
    list->int_array = NULL;
    list->float_array = NULL;
    list->double_array = NULL;
    list->char_array = NULL;
    list->bool_array = NULL;
    list->string_array = NULL;

    list->int_capacity = 0;
    list->float_capacity = 0;
    list->double_capacity = 0;
    list->char_capacity = 0;
    list->bool_capacity = 0;
    list->string_capacity = 0;

    list->int_size = 0;
    list->float_size = 0;
    list->double_size = 0;
    list->char_size = 0;
    list->bool_size = 0;
    list->string_size = 0;

    list->positions = NULL;
    list->size = 0;
    list->capacity = 0;

    return list;
}

void genericlist_addInt(GenericList* list, int value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return;
    }
    _genericlist_ensure_capacity(list);
    _genericlist_ensure_int_capacity(list);

    list->int_array[list->int_size] = value;
    list->positions[list->size].type = TYPE_INT;
    list->positions[list->size].array_index = list->int_size;

    list->int_size++;
    list->size++;
}

void genericlist_addFloat(GenericList* list, float value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return;
    }
    _genericlist_ensure_capacity(list);
    _genericlist_ensure_float_capacity(list);

    list->float_array[list->float_size] = value;
    list->positions[list->size].type = TYPE_FLOAT;
    list->positions[list->size].array_index = list->float_size;

    list->float_size++;
    list->size++;
}

void genericlist_addDouble(GenericList* list, double value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return;
    }
    _genericlist_ensure_capacity(list);
    _genericlist_ensure_double_capacity(list);

    list->double_array[list->double_size] = value;
    list->positions[list->size].type = TYPE_DOUBLE;
    list->positions[list->size].array_index = list->double_size;

    list->double_size++;
    list->size++;
}

void genericlist_addChar(GenericList* list, char value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return;
    }
    _genericlist_ensure_capacity(list);
    _genericlist_ensure_char_capacity(list);

    list->char_array[list->char_size] = value;
    list->positions[list->size].type = TYPE_CHAR;
    list->positions[list->size].array_index = list->char_size;

    list->char_size++;
    list->size++;
}

void genericlist_addBool(GenericList* list, bool value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return;
    }
    _genericlist_ensure_capacity(list);
    _genericlist_ensure_bool_capacity(list);

    list->bool_array[list->bool_size] = value;
    list->positions[list->size].type = TYPE_BOOL;
    list->positions[list->size].array_index = list->bool_size;

    list->bool_size++;
    list->size++;
}

void genericlist_addString(GenericList* list, string value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return;
    }
    _genericlist_ensure_capacity(list);
    _genericlist_ensure_string_capacity(list);

    list->string_array[list->string_size] = value;
    list->positions[list->size].type = TYPE_STRING;
    list->positions[list->size].array_index = list->string_size;

    list->string_size++;
    list->size++;
}

void* genericlist_get(GenericList* list, int index) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return NULL;
    }

    if (index < 0 || index >= list->size) {
        fprintf(stderr, "ERROR: Index %d out of bounds (size: %d)\n", index, list->size);
        return NULL;
    }

    PositionInfo pos = list->positions[index];

    switch (pos.type) {
        case TYPE_INT:
            return &list->int_array[pos.array_index];
        case TYPE_FLOAT:
            return &list->float_array[pos.array_index];
        case TYPE_DOUBLE:
            return &list->double_array[pos.array_index];
        case TYPE_CHAR:
            return &list->char_array[pos.array_index];
        case TYPE_BOOL:
            return &list->bool_array[pos.array_index];
        case TYPE_STRING:
            return list->string_array[pos.array_index];
        default:
            return NULL;
    }
}

GenericType genericlist_getType(GenericList* list, int index) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return TYPE_NULL;
    }
    if (index < 0 || index >= list->size) {
        fprintf(stderr, "ERROR: Index %d out of bounds (size: %d)\n", index, list->size);
        return TYPE_NULL;
    }
    return list->positions[index].type;
}

void genericlist_remove(GenericList* list, int index) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return;
    }
    if (index < 0 || index >= list->size) {
        fprintf(stderr, "ERROR: Index %d out of bounds (size: %d)\n", index, list->size);
        return;
    }
    for (int i = index; i < list->size - 1; i++) {
        list->positions[i] = list->positions[i + 1];
    }
    list->size--;
}

bool genericlist_contains(GenericList* list, void* value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return false;
    }
    return genericlist_indexOf(list, value) != -1;
}

int genericlist_indexOf(GenericList* list, void* value) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return -1;
    }
    for (int i = 0; i < list->size; i++) {
        PositionInfo pos = list->positions[i];
        void* current_value = NULL;
        switch (pos.type) {
            case TYPE_INT:
                current_value = &list->int_array[pos.array_index];
                break;
            case TYPE_FLOAT:
                current_value = &list->float_array[pos.array_index];
                break;
            case TYPE_DOUBLE:
                current_value = &list->double_array[pos.array_index];
                break;
            case TYPE_CHAR:
                current_value = &list->char_array[pos.array_index];
                break;
            case TYPE_BOOL:
                current_value = &list->bool_array[pos.array_index];
                break;
            case TYPE_STRING:
                current_value = list->string_array[pos.array_index];
                break;
        }
        if (current_value == value) {
            return i;
        }
    }
    return -1;
}

int genericlist_size(GenericList* list) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return 0;
    }
    return list->size;
}

bool genericlist_isEmpty(GenericList* list) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return true;
    }
    return list->size == 0;
}

void genericlist_clear(GenericList* list) {
    if (list == NULL) {
        fprintf(stderr, "ERROR: GenericList is NULL\n");
        return;
    }
    list->int_size = 0;
    list->float_size = 0;
    list->double_size = 0;
    list->char_size = 0;
    list->bool_size = 0;
    list->string_size = 0;
    list->size = 0;
}

bool genericlist_allNumeric(GenericList* list) {
    if (list == NULL || list->size == 0) {
        return false;
    }
    for (int i = 0; i < list->size; i++) {
        GenericType type = list->positions[i].type;
        if (type != TYPE_INT && type != TYPE_FLOAT && type != TYPE_DOUBLE) {
            return false;
        }
    }
    return true;
}

bool genericlist_allStrings(GenericList* list) {
    if (list == NULL || list->size == 0) {
        return false;
    }
    for (int i = 0; i < list->size; i++) {
        if (list->positions[i].type != TYPE_STRING) {
            return false;
        }
    }
    return true;
}

bool genericlist_allSameType(GenericList* list) {
    if (list == NULL || list->size <= 1) {
        return true;
    }
    GenericType first_type = list->positions[0].type;

    for (int i = 1; i < list->size; i++) {
        if (list->positions[i].type != first_type) {
            return false;
        }
    }
    return true;
}

void genericlist_free(GenericList* list) {
    if (list == NULL) {
        return;
    }
    if (list->int_array != NULL) free(list->int_array);
    if (list->float_array != NULL) free(list->float_array);
    if (list->double_array != NULL) free(list->double_array);
    if (list->char_array != NULL) free(list->char_array);
    if (list->bool_array != NULL) free(list->bool_array);
    if (list->string_array != NULL) free(list->string_array);
    if (list->positions != NULL) free(list->positions);
    free(list);
}
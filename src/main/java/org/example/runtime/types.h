#ifndef TYPES_H
#define TYPES_H

typedef enum {
    INT,
    DOUBLE,
    STRING,
    BOOL,
    CHAR,
    OBJECT
} Types;

int compare(const void* a, const void* b, Types type);

#endif
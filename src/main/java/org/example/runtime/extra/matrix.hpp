#pragma once

#include <stdbool.h>

typedef struct {
    int rows;
    int colums;
    int** data;
} Matrix;

Matrix matrix_init(int rows, int columns);

int matrix_get(Matrix* matrix, int row, int culumn);

void matrix_set(Matrix* matrix, int row, int column, int value);

int matrix_numberOfRows(Matrix* matrix);

int matrix_numberOfColumns(Matrix* matrix);

Matrix matrix_add(Matrix* matrix, Matrix* other);

Matrix matrix_multiply(Matrix* matrix, Matrix* other);

Matrix matrix_transpose(Matrix* matrix);

Matrix matrix_clone(Matrix* matrix); 
/* 
Matrix matrix_invert(Matrix* matrix);*/

double matrix_getDeterminant(Matrix* matrix);

void matrix_print(Matrix* matrix);
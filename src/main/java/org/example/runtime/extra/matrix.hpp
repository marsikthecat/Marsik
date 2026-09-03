#pragma once

#include <stdbool.h>

typedef struct Matrix{
    int rows;
    int columns;
    int** data;
} Matrix;

Matrix init_matrix(int rows, int columns);

int matrix_get(Matrix matrix, int row, int column);

void matrix_set(Matrix matrix, int row, int column, int value);

int matrix_numberOfRows(Matrix matrix);

int matrix_numberOfColumns(Matrix matrix);

int matrix_sum(Matrix matrix);

Matrix matrix_add(Matrix matrix, Matrix other);

Matrix matrix_multiply(Matrix matrix, Matrix other);

Matrix matrix_transpose(Matrix matrix);

Matrix matrix_clone(Matrix matrix); 

double matrix_getDeterminant(Matrix matrix);

bool matrix_isInvertible(Matrix matrix);

double matrix_trace(Matrix matrix);

double matrix_normal(Matrix matrix);

void matrix_print(Matrix matrix);
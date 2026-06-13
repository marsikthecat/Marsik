#include "matrix.hpp"
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "../allocator/allocator.hpp"
#include "../error/error.hpp"

Matrix matrix_init(int rows, int columns) {
    Matrix matrix;
    matrix.rows = rows;
    matrix.colums = columns;
    matrix.data = (int**)allocateFromMarsik(rows * sizeof(int*));
    for (int i = 0; i < rows; i++) {
        matrix.data[i] = (int*)allocateFromMarsik(columns * sizeof(int));
        for (int j = 0; j < columns; j++) {
            matrix.data[i][j] = 0;
        }
    }
    return matrix;
}

int matrix_get(Matrix* matrix, int row, int column) {
    if (row < 0 || row > matrix->rows) {
        runtimeError("Row does not match matrix");
        return -1;
    }
    if (column < 0 || column > matrix->colums ) {
        runtimeError("Column does not match matrix");
        return -1;
    }
    return matrix->data[row][column];
}

void matrix_set(Matrix* matrix, int row, int column, int value) {
    if (row < 0 || row > matrix->rows) {
        runtimeError("Row does not match matrix");
        return;
    }
    if (column < 0 || column > matrix->colums ) {
        runtimeError("Column does not match matrix");
        return;
    }
    matrix->data[row][column] = value;
}

int matrix_numberOfRows(Matrix* matrix) {
    return matrix->rows;
}

int matrix_numberOfColumns(Matrix* matrix) {
    return matrix->colums;
}

Matrix matrix_add(Matrix* matrix, Matrix* other) {
    if (matrix->rows == other->rows && matrix->colums == other->colums) {
        Matrix newMatrix;
        newMatrix.data = (int**)allocateFromMarsik(matrix->rows * sizeof(int*));
        newMatrix.rows = matrix->rows;
        newMatrix.colums = matrix->colums;
        for (int i = 0; i < newMatrix.rows; i++) {
            newMatrix.data[i] = (int*)allocateFromMarsik(matrix->colums * sizeof(int));
            for (int j = 0; j < newMatrix.colums; j++) {
               matrix_set(&newMatrix, i, j, matrix_get(matrix, i, j) + matrix_get(other, i, j));
        }
      }
      return newMatrix;
    } else {
        runtimeError("Matrix dimensions does not match for addition");
        return matrix_init(matrix->rows, matrix->colums);
    }
}

Matrix matrix_multiply(Matrix* matrix, Matrix* other) {
    if (matrix->rows == other->colums && matrix->colums == other->rows) {
        Matrix newMatrix;
        newMatrix.data = (int**)allocateFromMarsik(matrix->rows * sizeof(int*));
        newMatrix.rows = matrix->rows;
        newMatrix.colums = matrix->colums;
        for (int i = 0; i < newMatrix.rows; i++) {
            newMatrix.data[i] = (int*)allocateFromMarsik(matrix->colums * sizeof(int));
            for (int j = 0; j < newMatrix.colums; j++) {
               int sum = 0;
                for (int k = 0; k < matrix->colums; k++) {
                 sum += matrix_get(matrix, i, k) * matrix_get(other, k, j);
                }
            matrix_set(&newMatrix, i, j, sum);    
        }
      }
      return newMatrix;
    } else {
        runtimeError("Matrix dimensions does not match for multiplication");
        return matrix_init(matrix->rows, matrix->colums);
    }
}

Matrix matrix_transpose(Matrix* matrix) {
    Matrix transposed = matrix_init(matrix->rows, matrix->colums);
    for (int i = 0; i < matrix->rows; i++) {
      for (int j = 0; j < matrix->colums; j++) {
        transposed.data[j][i] = matrix->data[i][j];
      }
    }
    return transposed;
}

Matrix matrix_clone(Matrix* matrix) {
    Matrix cloned = matrix_init(matrix->rows, matrix->colums);
    for (int i = 0; i < matrix->rows; i++) {
      for (int j = 0; j < matrix->colums; j++) {
        cloned.data[i][j] = matrix->data[i][j];
      }
    }
    return cloned;
}

double matrix_getDeterminant(Matrix* matrix) {
    if (matrix->colums != matrix->rows) {
        runtimeError("Matrix must be square");
        return 0;
    }
    if (matrix->rows == 1) {
        return matrix_get(matrix, 0, 0);
    }
    if (matrix->rows == 2) {
        return matrix_get(matrix, 0, 0) * matrix_get(matrix, 1, 1) -
               matrix_get(matrix, 0, 1) * matrix_get(matrix, 1, 0);
    }
    if (matrix->rows == 3) {
        int x = matrix_get(matrix, 0, 0) * (matrix_get(matrix, 1, 1) * matrix_get(matrix, 2, 2) 
            - matrix_get(matrix, 1, 2) * matrix_get(matrix, 2, 1));
        int y = matrix_get(matrix, 0, 1) * (matrix_get(matrix, 1, 0) * matrix_get(matrix, 2, 2)
            - matrix_get(matrix, 1, 2) * matrix_get(matrix, 2, 0));
        int z = matrix_get(matrix, 0, 2) * (matrix_get(matrix, 1, 0)* matrix_get(matrix, 2, 1) 
            - matrix_get(matrix, 1, 1) * matrix_get(matrix, 2, 0));
        return x - y + z;
    }
    else {
        int rows = matrix->rows;
        int columns = matrix->colums;
        double temp[rows][columns];
        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < columns; j++) {
             temp[i][j] = matrix_get(matrix, i, j);
          }
        }
        double det = 1.0;

        for (int i = 0; i < rows; i++) {
          int pivot = i;
          for (int j = i + 1; j < rows; j++) {
            if (fabs(temp[j][i]) > fabs(temp[pivot][i])) {
              pivot = j;
          }
        }
        if (temp[pivot][i] == 0) {
          return 0;
        }
        if (i != pivot) {
          for (int j = 0; j < 10; j++) {
            double swap = temp[i][j];
            temp[i][j] = temp[pivot][j];
            temp[pivot][j] = swap;
          }
        }
        double pivotVal = temp[i][i];
        det *= pivotVal;
        for (int j = i + 1; j < rows; j++) {
          double factor = temp[j][i] / pivotVal;
          for (int k = i; k < columns; k++) {
            temp[j][k] -= factor * temp[i][k];
          }
        }
      }
      return det;
    } 
}

void matrix_print(Matrix* matrix) {
    for (int i = 0; i < matrix->rows; i++) {
      for (int j = 0; j < matrix->colums; j++) {
        printf("%d", matrix->data[i][j]);
      }
      printf(" \n");
    }
}
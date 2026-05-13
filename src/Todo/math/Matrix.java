package org.example.internals.math;

/**
 * Represents a two-dimensional integer matrix and provides basic
 * linear algebra operations.
 * This matrix implementation supports addition, multiplication,
 * transposition, inversion (via Gaussian elimination),
 * and determinant calculation.
 * All values are stored as integers. Some operations (e.g. inversion)
 * may lose precision due to integer division.
 */
public class Matrix {

  private final int[][] numbers;
  private final int rows;
  private final int columns;

  /**
   * Creates a new matrix with the given dimensions.
   *
   * @param rows    number of rows
   * @param columns number of columns
   */
  public Matrix(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.numbers = new int[rows][columns];
  }

  private Matrix(int[][] numbers) {
    this.numbers = numbers;
    this.rows = numbers.length;
    this.columns = numbers[0].length;
    for (int i = 0; i < rows; i++) {
      System.arraycopy(numbers[i], 0, this.numbers[i], 0, columns);
    }
  }

  /**
   * Returns the number of columns.
   *
   * @return column count
   */
  public int getColumns() {
    return columns;
  }

  /**
   * Returns the number of rows.
   *
   * @return row count
   */
  public int getRows() {
    return rows;
  }

  /**
   * Sets the value at the given matrix position.
   *
   * @param i     row index
   * @param j     column index
   * @param value value to set
   */
  public void setNumber(int i, int j, int value) {
    numbers[i][j] = value;
  }

  /**
   * Returns the value at the given matrix position.
   *
   * @param i row index
   * @param j column index
   * @return value at the specified position
   */
  public int getNumber(int i, int j) {
    return numbers[i][j];
  }

  /**
   * Adds this matrix to another matrix.
   *
   * @param other matrix to add
   * @return resulting matrix
   * @throws IllegalArgumentException if matrix dimensions do not match
   */
  public Matrix add(Matrix other) {
    if (this.rows == other.rows && this.columns == other.columns) {
      Matrix ret = new Matrix(rows, columns);
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          ret.setNumber(i, j, this.getNumber(i, j) + other.getNumber(i, j));
        }
      }
      return ret;
    }
    throw new IllegalArgumentException("Unable to perform add");
  }

  /**
   * Multiplies this matrix with another matrix.
   *
   * @param other matrix to multiply with
   * @return resulting matrix
   * @throws IllegalArgumentException if matrix dimensions are incompatible
   */
  public Matrix multiply(Matrix other) {
    if (this.rows == other.columns && this.columns == other.rows) {
      Matrix ret = new Matrix(this.rows, other.columns);
      for (int i = 0; i < ret.rows; i++) {
        for (int j = 0; j < ret.columns; j++) {
          int sum = 0;
          for (int k = 0; k < this.columns; k++) {
            sum += this.getNumber(i, k) * other.getNumber(k, j);
          }
          ret.setNumber(i, j, sum);
        }
      }
      return ret;
    }
    throw new IllegalArgumentException("Unable to perform add");
  }

  /**
   * Returns the transposed matrix.
   * Rows become columns and columns become rows.
   *
   * @return transposed matrix
   */
  public Matrix transposed() {
    int[][] transposedNumbers = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        transposedNumbers[j][i] = numbers[i][j];
      }
    }
    return new Matrix(transposedNumbers);
  }

  /**
   * Returns the inverse of this matrix using Gaussian elimination.
   * This method assumes the matrix is square and invertible.
   * <b>Precision loss may occur</b> due to integer arithmetic.
   *
   * @return inverted matrix
   * @throws IllegalArgumentException if the matrix is not square
   */
  public Matrix inverted() {
    if (this.rows != this.columns) {
      throw new IllegalArgumentException("Rows and columns must match");
    }
    int[][] a = numbers;
    int n = a.length;
    int[][] x = new int[n][n];
    int[][] b = new int[n][n];
    int[] index = new int[n];
    for (int i = 0; i < n; ++i) {
      b[i][i] = 1;
    }
    gaussian(a, index);
    for (int i = 0; i < n - 1; ++i) {
      for (int j = i + 1; j < n; ++j) {
        for (int k = 0; k < n; ++k) {
          b[index[j]][k] -= a[index[j]][i] * b[index[i]][k];
        }
      }
    }
    for (int i = 0; i < n; ++i) {
      x[n - 1][i] = b[index[n - 1]][i] / a[index[n - 1]][n - 1];
      for (int j = n - 2; j >= 0; --j) {
        x[j][i] = b[index[j]][i];
        for (int k = j + 1; k < n; ++k) {
          x[j][i] -= a[index[j]][k] * x[k][i];
        }
        x[j][i] /= a[index[j]][j];
      }
    }
    return new Matrix(x);
  }

  /**
   * Performs Gaussian elimination with partial pivoting.
   *
   * @param a     matrix to transform
   * @param index pivot index tracking array
   */
  private static void gaussian(int[][] a, int[] index) {
    int n = index.length;
    int[] c = new int[n];
    for (int i = 0; i < n; ++i) {
      index[i] = i;
    }
    for (int i = 0; i < n; ++i) {
      int c1 = 0;
      for (int j = 0; j < n; ++j) {
        int c0 = java.lang.Math.abs(a[i][j]);
        if (c0 > c1) {
          c1 = c0;
        }
      }
      c[i] = c1;
    }
    int k = 0;
    for (int j = 0; j < n - 1; ++j) {
      int pi1 = 0;
      for (int i = j; i < n; ++i) {
        int pi0 = java.lang.Math.abs(a[index[i]][j]) / c[index[i]];
        pi0 /= c[index[i]];
        if (pi0 > pi1) {
          pi1 = pi0;
          k = i;
        }
      }
      int temp = index[j];
      index[j] = index[k];
      index[k] = temp;
      for (int i = j + 1; i < n; ++i) {
        int pj = a[index[i]][j] / a[index[j]][j];
        a[index[i]][j] = pj;
        for (int l = j + 1; l < n; ++l) {
          a[index[i]][l] -= pj * a[index[j]][l];
        }
      }
    }
  }

  /**
   * Computes the determinant of this matrix.
   *
   * @return determinant value
   * @throws IllegalArgumentException if the matrix is not square
   */
  public double determinant() {
    if (rows != columns) {
      throw new IllegalArgumentException("Matrix must be square to compute determinant");
    }
    if (rows == 1) {
      return numbers[0][0];
    } else if (rows == 2) {
      return numbers[0][0] * numbers[1][1] - numbers[0][1] * numbers[1][0];
    } else if (rows == 3) {
      int x = numbers[0][0] * (numbers[1][1] * numbers[2][2] - numbers[1][2] * numbers[2][1]);
      int y = numbers[0][1] * (numbers[1][0] * numbers[2][2] - numbers[1][2] * numbers[2][0]);
      int z = numbers[0][2] * (numbers[1][0] * numbers[2][1] - numbers[1][1] * numbers[2][0]);
      return x - y + z;
    } else {
      double[][] temp = new double[rows][columns];
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          temp[i][j] = numbers[i][j];
        }
      }
      double det = 1.0;

      for (int i = 0; i < rows; i++) {
        int pivot = i;
        for (int j = i + 1; j < rows; j++) {
          if (java.lang.Math.abs(temp[j][i]) > java.lang.Math.abs(temp[pivot][i])) {
            pivot = j;
          }
        }
        if (temp[pivot][i] == 0) {
          return 0;
        }
        if (i != pivot) {
          double[] swap = temp[i];
          temp[i] = temp[pivot];
          temp[pivot] = swap;
          det *= -1;
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

  public void print() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        System.out.print(numbers[i][j] + " ");
      }
      System.out.println();
    }
  }
}
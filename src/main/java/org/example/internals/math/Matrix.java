package org.example.internals.math;

public class Matrix {

  private final int[][] numbers;
  private final int rows;
  private final int columns;
  public Matrix(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    this.numbers = new int[rows][columns];
  }

  public int getColumns() {
    return columns;
  }

  public int getRows() {
    return rows;
  }

  public void setNumber(int i, int j, int value) {
    numbers[i][j] = value;
  }

  public int getNumber(int i, int j) {
    return numbers[i][j];
  }

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

  public Matrix multiply(Matrix other) {
    if (this.rows == other.columns) {
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

  public Matrix transposed() {
    Matrix ret = new Matrix(this.rows, this.columns);
    for (int i = 0; i < ret.rows; i++) {
      for (int j = i + 1; j < ret.columns; j++) {
        int temp = this.getNumber(i, j);
        ret.setNumber(i, j, temp);
        ret.setNumber(j, i, temp);
      }
    }
    return ret;
  }

  public Matrix inverted() {
    int n = rows;
    int[][] x = new int[rows][rows];
    int[][] b = new int[rows][rows];
    int[] index = new int[n];
    for (int i = 0; i < n; ++i) {
      b[i][i] = 1;
    }
    gaussian(numbers, index);
    for (int i = 0; i < n - 1; ++i) {
      for (int j = i + 1; j < n; ++j) {
        for (int k = 0; k < n; ++k) {
          b[index[j]][k] -= numbers[index[j]][i] * b[index[i]][k];
        }
      }
    }
    for (int i = 0; i < n; ++i) {
      x[n - 1][i] = b[index[n - 1]][i] / numbers[index[n - 1]][n - 1];
      for (int j = n - 2; j >= 0; --j) {
        x[j][i] = b[index[j]][i];
        for (int k = j + 1; k < n; ++k) {
          x[j][i] -= numbers[index[j]][k] * x[k][i];
        }
        x[j][i] /= numbers[index[j]][j];
      }
    }
    Matrix matrix = new Matrix(n, n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix.setNumber(i, j, (int) x[j][i]);
      }
    }
    return matrix;
  }

  private static void gaussian(int[][] a, int[] index) {
    int n = index.length;
    double[] c = new double[n];
    for (int i = 0; i < n; ++i) {
      index[i] = i;
    }
    for (int i = 0; i < n; ++i) {
      double c1 = 0;
      for (int j = 0; j < n; ++j) {
        double c0 = java.lang.Math.abs(a[i][j]);
        if (c0 > c1) {
          c1 = c0;
        }
      }
      c[i] = c1;
    }
    for (int j = 0; j < n - 1; ++j) {
      double pi1 = 0;
      int k = j;
      for (int i = j; i < n; ++i) {
        double pi0 = java.lang.Math.abs(a[index[i]][j]) / c[index[i]];
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

  public double determinant() {
    if (rows != columns) {
      throw new IllegalArgumentException("Matrix must be square to compute determinant");
    }
    if (rows == 1) {
      return numbers[0][0];
    }
    else if (rows == 2) {
      return numbers[0][0] * numbers[1][1] - numbers[0][1] * numbers[1][0];
    }
    else if (rows == 3) {
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
}
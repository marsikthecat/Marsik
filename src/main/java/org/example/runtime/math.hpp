#pragma once

#include <stdbool.h>
#include "datastructures/array.hpp"

#define PI 3.14159265358979323846
#define E  2.71828182845904523536
#define PHI 1.61803398874989484820

int compare(const void *a, const void *b) {
  int *valA = (int *)a;
  int *valB = (int *)b;
  return *valA - *valB;
}

double pi();
double e();
double phi();

int roundBasic(double num);
int roundUp(double num);
int roundDown(double num);

double posDifference(double a, double b);

double toRadians(double degrees);
double toDegrees(double radians);

double sine(double num);
double cosine(double num);
double tangent(double num);

double asine(double num);
double acosine(double num);
double atangent(double num);

double squareRoot(double num);
double cubeRoot(double num);

double ln(double num);
double logarithm(double num);
double ePowX(double num);

int gcd(int a, int b);
int scd(int a, int b);

int factorial(int a);
int fibonacci(int a);

double hypotenuse(double a, double b);
double hypotenuse3D(double a, double b, double c);

bool isEven(int a);
bool isNegative(int a);
bool isPrime(int n);
bool areCongruentModuloM(int a, int b, int modulo);

int modInverse(int a, int m);

double calculateCapital(double capital, double interestRate, int years);
double increasingSum(int start, int end);

int max(int a, int b);
int max(int a, int b, int c);

double max(double a, double b);
double max(double a, double b, double c);

int min(int a, int b);
int min(int a, int b, int c);

double min(double a, double b);
double min(double a, double b, double c);

int randomInt(int min, int max);
double randomDouble(double min, double max);

template<typename T>
T max(Array<T> nums) {
  if (nums.length == 0) {
    return -1;
  }
  if (!arr_isNumericArray(&nums)) {
    runtimeError("Array is not Numeric!");
    return -1;
  }
  T max = nums.data[0];
  for (int i = 0; i < nums.length; i++ ) {
    T n = nums.data[i];
    if (n > max) {
      max = n;
    }
  }
  return max;
}

template<typename T>
T min(Array<T> nums) {
  if (nums.length == 0) {
    return -1;
  }
  if (!arr_isNumericArray(&nums)) {
    runtimeError("Array is not Numeric!");
    return -1;
  }
  T min = nums.data[0];
  for (int i = 0; i < nums.length; i++ ) {
    T n = nums.data[i];
    if (n < min) {
      min = n;
    }
  }
  return min;
}

template<typename T>
T sum(Array<T> nums) {
  if (nums.length == 0) {
    return -1;
  }
  if (!arr_isNumericArray(&nums)) {
    runtimeError("Array is not Numeric!");
    return -1;
  }
  T sum = 0;
  for (int i = 0; i < nums.length; i++ ) {
    sum += nums.data[i];
  }
  return sum;
}

template<typename T>
T avg(Array<T> nums) {
  if (nums.length == 0) {
    return -1;
  }
  if (!arr_isNumericArray(&nums)) {
    runtimeError("Array is not Numeric!");
    return -1;
  }
  return sum(nums) / nums.length;
}

template<typename T>
T median(Array<T> nums) {
  if (nums.length == 0) {
    return -1;
  }
  if (!arr_isNumericArray(&nums)) {
    runtimeError("Array is not Numeric!");
    return -1;
  }
  qsort(nums.data, nums.length, sizeof(T), compare);
  return nums.length % 2 == 0 ? (nums.data[nums.length / 2] + nums.data[nums.length / 2 - 1]) / 2.0: nums.data[nums.length / 2];
}

template<typename T>
T variance(Array<T> nums) {
  if (nums.length == 0) {
    return -1;
  }
  if (!arr_isNumericArray(&nums)) {
    runtimeError("Array is not Numeric!");
    return -1;
  }
  T avgResult = avg(nums);
  T a = 0;
  for (int i = 0; i < nums.length; i++) {
      T n = nums.data[i];
      a += pow((n - avgResult), 2);
  }
  return a / nums.length;
}

template<typename T>
T standardDeviation(Array<T> nums) {
  if (nums.length == 0) {
    return -1;
  }
  if (!arr_isNumericArray(&nums)) {
    runtimeError("Array is not Numeric!");
    return -1;
  }
  return sqrt(variance(nums));
}

double binomialCoefficient(int n, int k);
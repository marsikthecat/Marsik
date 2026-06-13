#pragma once

#include <stdbool.h>

#define PI 3.14159265358979323846
#define E  2.71828182845904523536

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

double max(double* nums, int length);
double min(double* nums, int length);
double sum(double* nums, int length);
double avg(double* nums, int length);
double median(double* nums, int length, int size);

int randomInt(int min, int max);
double randomDouble(double min, double max);

double variance(double* nums, int length);
double standardDeviation(double* nums, int length);
double binomialCoefficient(int n, int k);
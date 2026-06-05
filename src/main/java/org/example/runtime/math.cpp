#include <cmath>
#include <stdlib.h>
#include <stdbool.h>

#define PI 3.14159265358979323846
#define E  2.71828182845904523536

using namespace std;

int compare(const void *a, const void *b) {
  int *valA = (int *)a;
  int *valB = (int *)b;
  return *valA - *valB;
}

int roundBasic(double num) {
    return round(num);
}

int roundUp(double num) {
    return ceil(num);
}

int roundDown(double num) {
    return floor(num);
}

double ln(double num) {
    return log(num);
}

double logarithm(double num) {
    return log10(num);
}

int gcd(int a, int b) {
    return a == 0 ? b : gcd(b%a, a);
}

int scd(int a, int b) {
    return (a * b) / gcd(a, b);
}

int factorial(int a) {
    return a <= 1 ? 1 : a * factorial(a - 1);
}

int fibonacci(int a) {
    return a <= 1 ? a : fibonacci(a - 1) + fibonacci(a - 2);
}

double ePowX(double a) {
    return exp(a);
}

double hypotenuse(double a, double b) {
    return hypot(a,b);
}

double hypotenuse3D(double a, double b, double c) {
    return sqrt(pow(a, 2) + pow(b, 2) + pow(c, 2));
}

bool isEven(int a) {
    return a % 2 == 0;
  }

bool isPrime(int n) {
    if (n == 2 || n == 3) {
      return true;
    }
    if (n == 1 || n % 2 == 0 || n < 0) {
      return false;
    }
    for (int i = 3; i * i <= n; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
}

bool areCongruentModuloM(int a, int b, int modulo) {
    return a % modulo == b % modulo;
}

int modInverse(int a, int m) {
    int m0 = m;
    int y = 0;
    int x = 1;
    if (m == 1) {
      return 0;
    }
    while (a > 1) {
      int t = m;
      m = a % m;
      a = t;
      t = y;
      int q = a / m;
      y = x - q * y;
      x = t;
    }
    if (x < 0) {
      x += m0;
    }
    return x;
}

double calculateCapital(double capital, double interestRate, int years) {
    return capital * pow(1 + interestRate / 100, years);
}

double increasingSum(int start, int end) {
    return (double) (end * (end + 1)) / 2 - (double) ((start - 1) * start) / 2;
}

double max(double* nums, int length) {
    if (length == 0) {
      return -1;
    }
    double max = nums[0];
    for (int i = 0; i < length; i++ ) {
      int n = nums[i];
      if (n > max) {
        max = n;
      }
    }
    return max;
  }

 double min(double* nums, int length) {
    if (length == 0) {
      return -1;
    }
    double min = nums[0];
    for (int i = 0; i < length; i++ ) {
      int n = nums[i];
      if (n < min) {
        min = n;
      }
    }
    return min;
  }

  double sum(double* nums, int length) {
    if (length == 0) {
      return -1;
    }
    double sum = 0;
    for (int i = 0; i < length; i++ ) {
      sum += nums[i];
    }
    return sum;
  }

  double avg(double* nums, int length) {
    if (length == 0) {
      return -1;
    }
    return sum(nums, length) / length;
  }

  double median(double* nums, int length, int size) {
    if (length == 0) {
      return -1;
    }
    qsort(nums, length, size, compare);
    return length % 2 == 0 ? (nums[length / 2] + nums[length / 2 - 1]) / 2.0: nums[length / 2];
  }

  int randomInt(int min, int max) {
    if (max < min) {
        int tmp = min;
        min = max;
        max = tmp;
    }
    return min + rand() % (max - min + 1);
  }

  double variance(double* nums, int length) {
    if (length == 0) {
      return -1;
    }
    double avgResult = avg(nums, length);
    double a = 0;
    for (int i = 0; i < length; i++) {
        double n = nums[i];
        a += pow((n - avgResult), 2);
    }
    return a / length;
  }

  double standardDeviation(double* nums, int length) {
    if (length == 0) {
      return -1;
    }
    return sqrt(variance(nums, length));
  }

  double binomialCoefficient(int n, int k) {
    if (k < 0 || k > n) {
      return -1;
    }
    double b = factorial(k);
    double c = factorial(n - k);
    return factorial(n) / (b * c);
  }
package org.example.internals.math;

public class Math {

  public static final double PI = 3.14159265358979323846;

  public static final double EULER = 2.718281828459045;

  public static double round(double a) { return java.lang.Math.round(a); }

  public static double roundUp(double a) { return java.lang.Math.ceil(a); }

  public static double roundDown(double a) { return java.lang.Math.floor(a); }

  public static double sin(double a) {
    return java.lang.Math.sin(java.lang.Math.toRadians(a));
  }

  public static double asin(double a) { return java.lang.Math.asin(java.lang.Math.toRadians(a)); }

  public static double cos(double a) {
    return java.lang.Math.cos(java.lang.Math.toRadians(a));
  }

  public static double acos(double a) {  return java.lang.Math.acos(java.lang.Math.toRadians(a)); }

  public static double tan(double a) {
    return java.lang.Math.tan(java.lang.Math.toRadians(a));
  }

  public static double atan(double a) { return java.lang.Math.atan(java.lang.Math.toRadians(a)); }

  public static double ln(double a) {
    return java.lang.Math.log(a);
  }

  public static double log10(double a) {
    return java.lang.Math.log10(a);
  }

  public static double gcd(int a, int b) {
    return a == 0 ? b : gcd(b % a, a);
  }

  public static double scd(int a, int b) {
    return (a * b) / gcd(a, b);
  }

  public static double factorial(int a) {
    return a <= 1 ? 1 : a * factorial(a - 1);
  }

  public static double fibonacci(int a) {
    return a <= 1 ? a : fibonacci(a - 1) + fibonacci(a - 2);
  }

  public static double cbrt(double a) { return java.lang.Math.cbrt(a); }

  public static double ePowX(double a) { return java.lang.Math.exp(a); }

  public static double hypotenuse(double a, double b) { return java.lang.Math.hypot(a, b); }

  public static double hypotenuse3D(double a, double b, double c) {
    return Math.sqrt(a * a + b * b + c * c);
  }

  public static double sqrt(double a) { return java.lang.Math.sqrt(a); }

  public static boolean isEven(double a) {
    return a % 2 == 0;
  }

  public static boolean isPrime(int n) {
    if (n == 2 || n == 3)
      return true;
    if (n == 1 || n % 2 == 0)
      return false;
    for (int i = 3; i * i <= n; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean areCongruentModuloM(int a, int b, int modulo) {
    return a % modulo == b % modulo;
  }

  public static int modInverse(int a, int m) {
    int m0 = m;
    int y = 0, x = 1;
    if (m == 1) {
      return 0;
    }
    while (a > 1) {
      int q = a / m;
      int t = m;
      m = a % m;
      a = t;
      t = y;
      y = x - q * y;
      x = t;
    }
    if (x < 0) {
      x += m0;
    }
    return x;
  }

  public static double calculateCapital(double capital, double interestRate, int years) {
    return capital * java.lang.Math.pow(1 + interestRate / 100, years);
  }

  public static double increasingSum(int start, int end) {
    return (double) (end * (end + 1)) / 2 - (double) ((start - 1) * start) / 2;
  }

  public static double slope(Point p1, Point p2) {
    if (p2.getX() - p1.getX() == 0) {
      throw new ArithmeticException("Division by zero: x2 and x1 cannot be equal.");
    }
    return ((p2.getY() - p1.getY()) / (p2.getX() - p1.getX()));
  }

  public static double distance(Point p1, Point p2) {
    return java.lang.Math.sqrt(
            java.lang.Math.pow((p2.getX() - p1.getX()), 2) +
                    java.lang.Math.pow((p2.getY() - p1.getY()), 2));
  }

  public static String findLinearEquation(Point... points) {
    double sumX = 0;
    double sumY = 0;
    double sumXY = 0;
    double sumXX = 0;
    for (Point point : points) {
      sumX += point.getX();
      sumY += point.getY();
      sumXY += point.getX() * point.getY();
      sumXX += point.getX() * point.getX();
    }
    double denom = points.length * sumXX - sumX * sumX;
    double a = (points.length * sumXY - sumX * sumY) / denom;
    double b = (sumY - a * sumX) / points.length;
    return "y = " + a + " * x + " + b;
  }

  public static double max(double... nums) {
    if (nums.length == 0) {
      throw new IllegalArgumentException("Cannot find maximum out of nothing.");
    }
    double max = nums[0];
    for (double anInt : nums) {
      if (anInt > max) {
        max = anInt;
      }
    }
    return max;
  }

  public static double min(double... nums) {
    if (nums.length == 0) {
      throw new IllegalArgumentException("Cannot find minimum out of nothing.");
    }
    double min = nums[0];
    for (double anInt : nums) {
      if (anInt < min) {
        min = anInt;
      }
    }
    return min;
  }

  public static double sum(double... nums) {
    if (nums.length == 0) {
      throw new IllegalArgumentException("Cannot find sum out of nothing.");
    }
    double sum = nums[0];
    if (nums.length == 1) {
      return sum;
    }
    for (double anInt : nums) {
      sum += anInt;
    }
    return sum;
  }

  public static double avg(double... nums) {
    if (nums.length == 0) {
      throw new IllegalArgumentException("Cannot find average out of nothing.");
    }
    return sum(nums) / nums.length;
  }

  public static double median(double... nums) {
    if (nums.length == 0) {
      throw new IllegalArgumentException("Cannot find median out of nothing.");
    }
    java.util.Arrays.sort(nums);
    int length = nums.length;
    if (length % 2 == 0) {
      return (nums[length / 2] + nums[length / 2 - 1]) / 2.0;
    } else {
      return nums[length / 2];
    }
  }

  public static int random(int start, int end) {
    if (start >= end) {
      throw new IllegalArgumentException("Invalid range, my friend");
    }
    return (int) ((java.lang.Math.random() * (end - start + 1)) + start);
  }

  public static double random(double start, double end) {
    if (start >= end) {
      throw new IllegalArgumentException("Invalid range, my friend");
    }
    return (java.lang.Math.random() * (end - start + 1)) + start;
  }

  public static double variance(double... nums) {
    if (nums.length == 0) {
      throw new IllegalArgumentException("Cannot find variance out of nothing.");
    }
    double avg = avg(nums);
    double a = 0;
    for (double num : nums) {
      a += java.lang.Math.pow((num - avg), 2);
    }
    return a / nums.length;
  }

  public static double standardDeviation(double... nums) {
    if (nums.length == 0) {
      throw new IllegalArgumentException("Cannot find variance out of nothing.");
    }
    return java.lang.Math.sqrt(variance(nums));
  }
}
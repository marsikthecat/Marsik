package org.example.internals.math;

/**
 * Utility class providing common mathematical constants and functions.
 * This class contains trigonometric, algebraic, statistical, number-theoretic,
 * and geometry-related helper methods. All methods are static and the class
 * is not intended to be instantiated.
 */
public class Math {

  /** The mathematical constant π (pi). */
  public static final double PI = 3.14159265358979323846;

  /** The mathematical constant e (Euler's number). */
  public static final double EULER = 2.718281828459045;

  /**
   * Rounds a value to the nearest integer.
   *
   * @param a value to round
   * @return rounded value
   */
  public static double round(double a) {
    return java.lang.Math.round(a);
  }

  /**
   * Rounds a value up to the next integer.
   *
   * @param a value to round
   * @return smallest integer greater than or equal to {@code a}
   */
  public static double roundUp(double a) {
    return java.lang.Math.ceil(a);
  }

  /**
   * Rounds a value down to the previous integer.
   *
   * @param a value to round
   * @return largest integer less than or equal to {@code a}
   */
  public static double roundDown(double a) {
    return java.lang.Math.floor(a);
  }

  /**
   * Computes the sine of an angle in degrees.
   *
   * @param a angle in degrees
   * @return sine of the angle
   */
  public static double sin(double a) {
    return java.lang.Math.sin(java.lang.Math.toRadians(a));
  }

  /**
   * Computes the arcsine of a value.
   *
   * @param a value
   * @return arcsine in radians
   */
  public static double asin(double a) {
    return java.lang.Math.asin(java.lang.Math.toRadians(a));
  }

  /**
   * Computes the cosine of an angle in degrees.
   *
   * @param a angle in degrees
   * @return cosine of the angle
   */
  public static double cos(double a) {
    return java.lang.Math.cos(java.lang.Math.toRadians(a));
  }

  /**
   * Computes the arccosine of a value.
   *
   * @param a value
   * @return arccosine in radians
   */
  public static double acos(double a) {
    return java.lang.Math.acos(java.lang.Math.toRadians(a));
  }

  /**
   * Computes the tangent of an angle in degrees.
   *
   * @param a angle in degrees
   * @return tangent of the angle
   */
  public static double tan(double a) {
    return java.lang.Math.tan(java.lang.Math.toRadians(a));
  }

  /**
   * Computes the arctangent of a value.
   *
   * @param a value
   * @return arctangent in radians
   */
  public static double atan(double a) {
    return java.lang.Math.atan(java.lang.Math.toRadians(a));
  }

  /**
   * Computes the natural logarithm.
   *
   * @param a value
   * @return ln(a)
   */
  public static double ln(double a) {
    return java.lang.Math.log(a);
  }

  /**
   * Computes the base-10 logarithm.
   *
   * @param a value
   * @return log10(a)
   */
  public static double log10(double a) {
    return java.lang.Math.log10(a);
  }

  /**
   * Computes the greatest common divisor (GCD).
   *
   * @param a first integer
   * @param b second integer
   * @return greatest common divisor
   */
  public static double gcd(int a, int b) {
    return a == 0 ? b : gcd(b % a, a);
  }

  /**
   * Computes the smallest common divisor / least common multiple.
   *
   * @param a first integer
   * @param b second integer
   * @return least common multiple
   */
  public static double scd(int a, int b) {
    return (a * b) / gcd(a, b);
  }

  /**
   * Computes the factorial of a number.
   *
   * @param a non-negative integer
   * @return factorial of {@code a}
   */
  public static double factorial(int a) {
    return a <= 1 ? 1 : a * factorial(a - 1);
  }

  /**
   * Computes the Fibonacci number at position {@code a}.
   *
   * @param a index
   * @return Fibonacci value
   */
  public static double fibonacci(int a) {
    return a <= 1 ? a : fibonacci(a - 1) + fibonacci(a - 2);
  }

  /**
   * Computes the cube root.
   *
   * @param a value
   * @return cube root of {@code a}
   */
  public static double cbrt(double a) {
    return java.lang.Math.cbrt(a);
  }

  /**
   * Computes e raised to the power of x.
   *
   * @param a exponent
   * @return e^a
   */
  public static double epowX(double a) {
    return java.lang.Math.exp(a);
  }

  /**
   * Computes the hypotenuse of a right triangle.
   *
   * @param a first side
   * @param b second side
   * @return hypotenuse length
   */
  public static double hypotenuse(double a, double b) {
    return java.lang.Math.hypot(a, b);
  }

  /**
   * Computes the 3D hypotenuse.
   *
   * @param a x component
   * @param b y component
   * @param c z component
   * @return distance from origin
   */
  public static double hypotenuse3D(double a, double b, double c) {
    return Math.sqrt(a * a + b * b + c * c);
  }

  /**
   * Computes the square root.
   *
   * @param a value
   * @return square root of {@code a}
   */
  public static double sqrt(double a) {
    return java.lang.Math.sqrt(a);
  }

  /**
   * Checks whether a value is even.
   *
   * @param a value
   * @return {@code true} if even
   */
  public static boolean isEven(double a) {
    return a % 2 == 0;
  }

  /**
   * Checks whether a number is prime.
   *
   * @param n integer to test
   * @return {@code true} if prime
   */
  public static boolean isPrime(int n) {
    if (n == 2 || n == 3) {
      return true;
    }
    if (n == 1 || n % 2 == 0) {
      return false;
    }
    for (int i = 3; i * i <= n; i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks congruence modulo m.
   *
   * @param a first value
   * @param b second value
   * @param modulo modulus
   * @return {@code true} if congruent
   */
  public static boolean areCongruentModuloM(int a, int b, int modulo) {
    return a % modulo == b % modulo;
  }

  /**
   * Computes the modular multiplicative inverse.
   *
   * @param a value
   * @param m modulus
   * @return modular inverse
   */
  public static int modInverse(int a, int m) {
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

  /**
   * Calculates compound interest.
   *
   * @param capital initial capital
   * @param interestRate interest rate in percent
   * @param years number of years
   * @return resulting capital
   */
  public static double calculateCapital(double capital, double interestRate, int years) {
    return capital * java.lang.Math.pow(1 + interestRate / 100, years);
  }

  /**
   * Computes the sum of integers in a range.
   *
   * @param start start value
   * @param end end value
   * @return sum from start to end
   */
  public static double increasingSum(int start, int end) {
    return (double) (end * (end + 1)) / 2 - (double) ((start - 1) * start) / 2;
  }

  /**
   * Computes the slope between two points.
   *
   * @param p1 first point
   * @param p2 second point
   * @return slope
   */
  public static double slope(Point p1, Point p2) {
    if (p2.getX() - p1.getX() == 0) {
      throw new ArithmeticException("Division by zero: x2 and x1 cannot be equal.");
    }
    return ((p2.getY() - p1.getY()) / (p2.getX() - p1.getX()));
  }

  /**
   * Computes the distance between two points.
   *
   * @param p1 first point
   * @param p2 second point
   * @return distance
   */
  public static double distance(Point p1, Point p2) {
    return java.lang.Math.sqrt(
            java.lang.Math.pow((p2.getX() - p1.getX()), 2)
                    + java.lang.Math.pow((p2.getY() - p1.getY()), 2));
  }

  /**
   * Computes a linear regression equation from given points.
   *
   * @param points input points
   * @return linear equation as string
   */
  public static String findLinearEquation(Point... points) {
    double sumX = 0;
    double sumY = 0;
    double sumxY = 0;
    double sumxX = 0;
    for (Point point : points) {
      sumX += point.getX();
      sumY += point.getY();
      sumxY += point.getX() * point.getY();
      sumxX += point.getX() * point.getX();
    }
    double denom = points.length * sumxX - sumX * sumX;
    double a = (points.length * sumxY - sumX * sumY) / denom;
    double b = (sumY - a * sumX) / points.length;
    return "y = " + a + " * x + " + b;
  }

  /**
   * Returns the maximum value.
   *
   * @param nums values
   * @return maximum
   */
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

  /**
   * Returns the minimum value.
   *
   * @param nums values
   * @return minimum
   */
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

  /**
   * Computes the sum of values.
   *
   * @param nums values
   * @return sum
   */
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

  /**
   * Computes the average value.
   *
   * @param nums values
   * @return average
   */
  public static double avg(double... nums) {
    if (nums.length == 0) {
      throw new IllegalArgumentException("Cannot find average out of nothing.");
    }
    return sum(nums) / nums.length;
  }

  /**
   * Computes the median value.
   *
   * @param nums values
   * @return median
   */
  public static double median(double... nums) {
    if (nums.length == 0) {
      throw new IllegalArgumentException("Cannot find median out of nothing.");
    }
    java.util.Arrays.sort(nums);
    int length = nums.length;
    return length % 2 == 0 ? (nums[length / 2] + nums[length / 2 - 1]) / 2.0
            : nums[length / 2];
  }

  /**
   * Generates a random integer in a range.
   *
   * @param start inclusive start
   * @param end inclusive end
   * @return random integer
   */
  public static int random(int start, int end) {
    if (start >= end) {
      throw new IllegalArgumentException("Invalid range, my friend");
    }
    return (int) ((java.lang.Math.random() * (end - start + 1)) + start);
  }

  /**
   * Generates a random double in a range.
   *
   * @param start inclusive start
   * @param end inclusive end
   * @return random value
   */
  public static double random(double start, double end) {
    if (start >= end) {
      throw new IllegalArgumentException("Invalid range, my friend");
    }
    return (java.lang.Math.random() * (end - start + 1)) + start;
  }

  /**
   * Computes the variance.
   *
   * @param nums values
   * @return variance
   */
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

  /**
   * Computes the standard deviation.
   *
   * @param nums values
   * @return standard deviation
   */
  public static double standardDeviation(double... nums) {
    if (nums.length == 0) {
      throw new IllegalArgumentException("Cannot find variance out of nothing.");
    }
    return java.lang.Math.sqrt(variance(nums));
  }

  /**
   * Computes the binomial coefficient "n choose k", i.e., the number of ways to choose
   * k elements from a set of n elements.
   *
   * @param n total number of elements
   * @param k number of elements to choose
   * @return binomial coefficient (n choose k)
   * @throws IllegalArgumentException if k < 0, k > n, or n < 0
   */
  public static double binomialKoefficient(int n, int k) {
    if (k < 0 || k > n) {
      throw new IllegalArgumentException("Invalid k: must satisfy 0 <= k <= n");
    }
    double b = factorial(k);
    double c = factorial(n - k);
    return factorial(n) / (b * c);
  }
}
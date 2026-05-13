import org.example.internals.math.Matrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMath {

  @Test
  void gcdOfTwoPositiveNumbers() {
    assertEquals(6, Math.gcd(54, 24));
  }

  @Test
  void gcdWhenOneNumberIsZero() {
    assertEquals(10, Math.gcd(0, 10));
    assertEquals(15, Math.gcd(15, 0));
  }

  @Test
  void gcdOfTwoNegativeNumbers() {
    assertEquals(-4, Math.gcd(-8, -12));
  }

  @Test
  void gcdOfPositiveAndNegativeNumber() {
    assertEquals(5, Math.gcd(-15, 20));
  }

  @Test
  void scdOfTwoPositiveNumbers() {
    assertEquals(72, Math.scd(24, 18));
  }

  @Test
  void scdWhenOneNumberIsZero() {
    assertEquals(0, Math.scd(0, 10));
    assertEquals(0, Math.scd(15, 0));
  }

  @Test
  void factorialOfPositiveNumber() {
    assertEquals(120, Math.factorial(5));
  }

  @Test
  void factorialOfZero() {
    assertEquals(1, Math.factorial(0));
  }

  @Test
  void factorialOfOne() {
    assertEquals(1, Math.factorial(1));
  }

  @Test
  void fibonacciOfZero() {
    assertEquals(0, Math.fibonacci(0));
  }

  @Test
  void fibonacciOfOne() {
    assertEquals(1, Math.fibonacci(1));
  }

  @Test
  void fibonacciOfPositiveNumber() {
    assertEquals(21, Math.fibonacci(8));
  }

  @Test
  void calculates3DHypotenuseForPositiveValues() {
    assertEquals(7.071, Math.hypotenuse3D(3, 4, 5), 0.001);
  }

  @Test
  void calculates3DHypotenuseForZeroValues() {
    assertEquals(5.0, Math.hypotenuse3D(0, 0, 5), 0.001);
  }

  @Test
  void calculates3DHypotenuseForNegativeValues() {
    assertEquals(7.071, Math.hypotenuse3D(-3, -4, -5), 0.001);
  }

  @Test
  void identifiesEvenNumberCorrectly() {
    assertTrue(Math.isEven(4));
    assertTrue(Math.isEven(0));
    assertTrue(Math.isEven(-6));
  }

  @Test
  void identifiesOddNumberCorrectly() {
    assertFalse(Math.isEven(3));
    assertFalse(Math.isEven(-5));
    assertFalse(Math.isEven(555));
  }

  @Test
  void identifiesPrimeNumberCorrectly() {
    assertTrue(Math.isPrime(2));
    assertTrue(Math.isPrime(3));
    assertTrue(Math.isPrime(17));
    assertTrue(Math.isPrime(97));
  }

  @Test
  void identifiesNonPrimeNumberCorrectly() {
    assertFalse(Math.isPrime(1));
    assertFalse(Math.isPrime(0));
    assertFalse(Math.isPrime(-7));
    assertFalse(Math.isPrime(4));
    assertFalse(Math.isPrime(100));
  }

  @Test
  void identifiesCongruentNumbersModuloM() {
    assertTrue(Math.areCongruentModuloM(10, 4, 3));
    assertTrue(Math.areCongruentModuloM(15, 5, 5));
    assertTrue(Math.areCongruentModuloM(-7, 3, 5));
  }

  @Test
  void identifiesNonCongruentNumbersModuloM() {
    assertFalse(Math.areCongruentModuloM(10, 5, 3));
    assertFalse(Math.areCongruentModuloM(15, 6, 5));
    assertFalse(Math.areCongruentModuloM(-7, 4, 5));
  }

  @Test
  void calculatesModularInverseCorrectly() {
    assertEquals(3, Math.modInverse(3, 7));
    assertEquals(1, Math.modInverse(1, 5));
    assertEquals(4, Math.modInverse(3, 11));
  }

  @Test
  void throwsExceptionForInvalidModularInverse() {
    assertThrows(ArithmeticException.class, () -> Math.modInverse(6, 9));
  }

  @Test
  void calculatesCompoundInterestCorrectly() {
    assertEquals(121.0, Math.calculateCapital(100, 10, 2), 0.001);
    assertEquals(110.25, Math.calculateCapital(105, 5, 1), 0.001);
  }

  @Test
  void calculatesIncreasingSumCorrectly() {
    assertEquals(55.0, Math.increasingSum(1, 10), 0.001);
    assertEquals(0.0, Math.increasingSum(5, 4), 0.001);
  }

  @Test
  void calculatesSlopeBetweenTwoPoints() {
    assertEquals(1.0, Math.slope(new Point("a", 0, 0), new Point("b",1, 1)), 0.001);
    assertEquals(-1.0, Math.slope(new Point("c", 0, 0), new Point("d",1, -1)), 0.001);
  }

  @Test
  void throwsExceptionForVerticalSlope() {
    assertThrows(ArithmeticException.class, () -> Math.slope(new Point("e",1, 1), new Point("f",1, 5)));
  }

  @Test
  void calculatesDistanceBetweenTwoPoints() {
    assertEquals(5.0, Math.distance(new Point("g",0, 0), new Point("h",3, 4)), 0.001);
    assertEquals(0.0, Math.distance(new Point("i",2, 2), new Point("j",2, 2)), 0.001);
  }
  @Test
  void calculatesLinearEquationForTwoPoints() {
    Point p1 = new Point("A", 1, 2);
    Point p2 = new Point("B", 3, 4);
    assertEquals("y = 1.0 * x + 1.0", Math.findLinearEquation(p1, p2));
  }

  @Test
  void calculatesLinearEquationForHorizontalLine() {
    Point p1 = new Point("A", 1, 2);
    Point p2 = new Point("B", 3, 2);
    assertEquals("y = 0.0 * x + 2.0", Math.findLinearEquation(p1, p2));
  }

  @Test
  void calculatesLinearEquationForVerticalLine() {
    Point p1 = new Point("A", 2, 1);
    Point p2 = new Point("B", 2, 3);
    assertThrows(ArithmeticException.class, () -> Math.findLinearEquation(p1, p2));
  }

  @Test
  void calculatesLinearEquationForSinglePoint() {
    Point p1 = new Point("A", 1, 2);
    assertThrows(IllegalArgumentException.class, () -> Math.findLinearEquation(p1));
  }

  @Test
  void calculatesLinearEquationForNoPoints() {
    assertThrows(IllegalArgumentException.class, Math::findLinearEquation);
  }

  @Test
  void findsMaximumValueInArray() {
    assertEquals(10.5, Math.max(1.2, 3.4, 10.5, 7.8));
  }

  @Test
  void findsMaximumValueInSingleElementArray() {
    assertEquals(5.0, Math.max(5.0));
  }

  @Test
  void throwsExceptionForEmptyArrayInMax() {
    assertThrows(IllegalArgumentException.class, Math::max);
  }

  @Test
  void findsMinimumValueInArray() {
    assertEquals(1.2, Math.min(1.2, 3.4, 10.5, 7.8));
  }

  @Test
  void findsMinimumValueInSingleElementArray() {
    assertEquals(-5.0, Math.min(-5.0));
  }

  @Test
  void throwsExceptionForEmptyArrayInMin() {
    assertThrows(IllegalArgumentException.class, Math::min);
  }

  @Test
  void calculatesSumOfValuesInArray() {
    assertEquals(22.9, Math.sum(1.2, 3.4, 10.5, 7.8), 0.001);
  }

  @Test
  void calculatesSumForSingleElementArray() {
    assertEquals(5.0, Math.sum(5.0), 0.001);
  }

  @Test
  void throwsExceptionForEmptyArrayInSum() {
    assertThrows(IllegalArgumentException.class, Math::sum);
  }

  @Test
  void calculatesAverageOfValuesInArray() {
    assertEquals(5.725, Math.avg(1.2, 3.4, 10.5, 7.8), 0.001);
  }

  @Test
  void calculatesAverageForSingleElementArray() {
    assertEquals(5.0, Math.avg(5.0), 0.001);
  }

  @Test
  void throwsExceptionForEmptyArrayInAvg() {
    assertThrows(IllegalArgumentException.class, Math::avg);
  }

  @Test
  void calculatesMedianForOddNumberOfElements() {
    assertEquals(3.0, Math.median(1.0, 2.0, 3.0, 4.0, 5.0), 0.001);
  }

  @Test
  void calculatesMedianForEvenNumberOfElements() {
    assertEquals(3.5, Math.median(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), 0.001);
  }

  @Test
  void throwsExceptionForEmptyArrayInMedian() {
    assertThrows(IllegalArgumentException.class, Math::median);
  }

  @Test
  void generatesRandomIntegerWithinRange() {
    int randomValue = Math.random(1, 10);
    assertTrue(randomValue >= 1 && randomValue <= 10);
  }

  @Test
  void throwsExceptionForInvalidIntegerRange() {
    assertThrows(IllegalArgumentException.class, () -> Math.random(10, 1));
  }

  @Test
  void generatesRandomDoubleWithinRange() {
    double randomValue = Math.random(1.0, 10.0);
    assertTrue(randomValue >= 1.0 && randomValue <= 10.0);
  }

  @Test
  void throwsExceptionForInvalidDoubleRange() {
    assertThrows(IllegalArgumentException.class, () -> Math.random(10.0, 1.0));
  }

  @Test
  void calculatesVarianceForMultipleValues() {
    assertEquals(2, Math.variance(1.0, 2.0, 3.0, 4.0, 5.0), 0.001);
  }

  @Test
  void calculatesVarianceForSingleValue() {
    assertEquals(0.0, Math.variance(5.0), 0.001);
  }

  @Test
  void throwsExceptionForEmptyArrayInVariance() {
    assertThrows(IllegalArgumentException.class, Math::variance);
  }

  @Test
  void calculatesStandardDeviationForMultipleValues() {
    assertEquals(1.414, Math.standardDeviation(1.0, 2.0, 3.0, 4.0, 5.0), 0.001);
  }

  @Test
  void calculatesStandardDeviationForSingleValue() {
    assertEquals(0.0, Math.standardDeviation(5.0), 0.001);
  }

  @Test
  void throwsExceptionForEmptyArrayInStandardDeviation() {
    assertThrows(IllegalArgumentException.class, Math::standardDeviation);
  }

  @Test
  void calculatesBinomialCoefficientForValidInputs() {
    assertEquals(10.0, Math.binomialKoefficient(5, 2), 0.001);
    assertEquals(1.0, Math.binomialKoefficient(5, 0), 0.001);
    assertEquals(1.0, Math.binomialKoefficient(5, 5), 0.001);
  }

  @Test
  void throwsExceptionForInvalidBinomialCoefficientInputs() {
    assertThrows(IllegalArgumentException.class, () -> Math.binomialKoefficient(5, -1));
    assertThrows(IllegalArgumentException.class, () -> Math.binomialKoefficient(5, 6));
    assertThrows(IllegalArgumentException.class, () -> Math.binomialKoefficient(-5, 2));
  }

  // Point Class //

  @Test
  void createsPointWithValidCoordinatesAndIdentifier() {
    Point point = new Point("A", 3.5, 7.2);
    assertEquals("A", point.getIdentifier());
    assertEquals(3.5, point.getX(), 0.001);
    assertEquals(7.2, point.getY(), 0.001);
  }

  @Test
  void updatesXCoordinateSuccessfully() {
    Point point = new Point("B", 1.0, 2.0);
    point.setX(5.5);
    assertEquals(5.5, point.getX(), 0.001);
  }

  @Test
  void updatesYCoordinateSuccessfully() {
    Point point = new Point("C", 1.0, 2.0);
    point.setY(8.3);
    assertEquals(8.3, point.getY(), 0.001);
  }

  @Test
  void returnsCorrectStringRepresentation() {
    Point point = new Point("D", 4.0, 9.0);
    assertEquals("Point D: X = 4.0 , Y = 9.0", point.toString());
  }

  @Test
  void handlesNegativeCoordinates() {
    Point point = new Point("E", -3.0, -7.0);
    assertEquals(-3.0, point.getX(), 0.001);
    assertEquals(-7.0, point.getY(), 0.001);
  }

  @Test
  void handlesZeroCoordinates() {
    Point point = new Point("F", 0.0, 0.0);
    assertEquals(0.0, point.getX(), 0.001);
    assertEquals(0.0, point.getY(), 0.001);
  }

  // Matrix Class //

  @Test
  void createsMatrixWithValidDimensions() {
    Matrix matrix = new Matrix(3, 4);
    assertEquals(3, matrix.getRows());
    assertEquals(4, matrix.getColumns());
  }

  @Test
  void setsAndGetsMatrixValueCorrectly() {
    Matrix matrix = new Matrix(2, 2);
    matrix.setNumber(0, 1, 5);
    assertEquals(5, matrix.getNumber(0, 1));
  }

  @Test
  void throwsExceptionWhenAddingMatricesWithDifferentDimensions() {
    Matrix matrix1 = new Matrix(2, 3);
    Matrix matrix2 = new Matrix(3, 2);
    assertThrows(IllegalArgumentException.class, () -> matrix1.add(matrix2));
  }

  @Test
  void addsMatricesWithSameDimensionsCorrectly() {
    Matrix matrix1 = new Matrix(2, 2);
    matrix1.setNumber(0, 0, 1);
    matrix1.setNumber(0, 1, 2);
    matrix1.setNumber(1, 0, 3);
    matrix1.setNumber(1, 1, 4);

    Matrix matrix2 = new Matrix(2, 2);
    matrix2.setNumber(0, 0, 5);
    matrix2.setNumber(0, 1, 6);
    matrix2.setNumber(1, 0, 7);
    matrix2.setNumber(1, 1, 8);

    Matrix result = matrix1.add(matrix2);

    assertEquals(6, result.getNumber(0, 0));
    assertEquals(8, result.getNumber(0, 1));
    assertEquals(10, result.getNumber(1, 0));
    assertEquals(12, result.getNumber(1, 1));
  }

  @Test
  void throwsExceptionWhenMultiplyingMatricesWithIncompatibleDimensions() {
    Matrix matrix1 = new Matrix(2, 3);
    Matrix matrix2 = new Matrix(4, 2);
    assertThrows(IllegalArgumentException.class, () -> matrix1.multiply(matrix2));
  }

  @Test
  void multipliesMatricesWithCompatibleDimensionsCorrectly() {
    Matrix matrix1 = new Matrix(2, 3);
    matrix1.setNumber(0, 0, 1);
    matrix1.setNumber(0, 1, 2);
    matrix1.setNumber(0, 2, 3);
    matrix1.setNumber(1, 0, 4);
    matrix1.setNumber(1, 1, 5);
    matrix1.setNumber(1, 2, 6);

    Matrix matrix2 = new Matrix(3, 2);
    matrix2.setNumber(0, 0, 7);
    matrix2.setNumber(0, 1, 8);
    matrix2.setNumber(1, 0, 9);
    matrix2.setNumber(1, 1, 10);
    matrix2.setNumber(2, 0, 11);
    matrix2.setNumber(2, 1, 12);

    Matrix result = matrix1.multiply(matrix2);

    assertEquals(58, result.getNumber(0, 0));
    assertEquals(64, result.getNumber(0, 1));
    assertEquals(139, result.getNumber(1, 0));
    assertEquals(154, result.getNumber(1, 1));
  }

  @Test
  void transposesSquareMatrixCorrectly() {
    Matrix matrix = new Matrix(3, 3);
    matrix.setNumber(0, 0, 1);
    matrix.setNumber(0, 1, 2);
    matrix.setNumber(0, 2, 3);
    matrix.setNumber(1, 0, 4);
    matrix.setNumber(1, 1, 5);
    matrix.setNumber(1, 2, 6);
    matrix.setNumber(2, 0, 7);
    matrix.setNumber(2, 1, 8);
    matrix.setNumber(2, 2, 9);
    matrix.print();

    Matrix transposed = matrix.transposed();
    matrix.print();

    assertEquals(1, transposed.getNumber(0, 0));
    assertEquals(4, transposed.getNumber(0, 1));
    assertEquals(7, transposed.getNumber(0, 2));
    assertEquals(2, transposed.getNumber(1, 0));
    assertEquals(5, transposed.getNumber(1, 1));
    assertEquals(8, transposed.getNumber(1, 2));
    assertEquals(3, transposed.getNumber(2, 0));
    assertEquals(6, transposed.getNumber(2, 1));
    assertEquals(9, transposed.getNumber(2, 2));
  }

  @Test
  void transposesNonSquareMatrixCorrectly() {
    Matrix matrix = new Matrix(2, 3);
    matrix.setNumber(0, 0, 1);
    matrix.setNumber(0, 1, 2);
    matrix.setNumber(0, 2, 3);
    matrix.setNumber(1, 0, 4);
    matrix.setNumber(1, 1, 5);
    matrix.setNumber(1, 2, 6);

    Matrix transposed = matrix.transposed();

    assertEquals(1, transposed.getNumber(0, 0));
    assertEquals(4, transposed.getNumber(0, 1));
    assertEquals(2, transposed.getNumber(1, 0));
    assertEquals(5, transposed.getNumber(1, 1));
    assertEquals(3, transposed.getNumber(2, 0));
    assertEquals(6, transposed.getNumber(2, 1));
  }

  @Test
  void invertsSquareMatrixCorrectly() {
    Matrix matrix = new Matrix(2, 2);
    matrix.setNumber(0, 0, 4);
    matrix.setNumber(0, 1, 7);
    matrix.setNumber(1, 0, 2);
    matrix.setNumber(1, 1, 6);
    matrix.print();

    Matrix inverted = matrix.inverted();
    inverted.print();

    assertEquals(6, inverted.getNumber(0, 0));
    assertEquals(-7, inverted.getNumber(0, 1));
    assertEquals(-2, inverted.getNumber(1, 0));
    assertEquals(4, inverted.getNumber(1, 1));
  }

  @Test
  void throwsExceptionWhenInvertingNonSquareMatrix() {
    Matrix matrix = new Matrix(2, 3);
    assertThrows(IllegalArgumentException.class, matrix::inverted);
  }

  @Test
  void calculatesDeterminantOfSquareMatrix() {
    Matrix matrix = new Matrix(3, 3);
    matrix.setNumber(0, 0, 6);
    matrix.setNumber(0, 1, 1);
    matrix.setNumber(0, 2, 1);
    matrix.setNumber(1, 0, 4);
    matrix.setNumber(1, 1, -2);
    matrix.setNumber(1, 2, 5);
    matrix.setNumber(2, 0, 2);
    matrix.setNumber(2, 1, 8);
    matrix.setNumber(2, 2, 7);

    assertEquals(-306, matrix.determinant(), 0.001);
  }

  @Test
  void throwsExceptionWhenCalculatingDeterminantOfNonSquareMatrix() {
    Matrix matrix = new Matrix(2, 3);
    assertThrows(IllegalArgumentException.class, matrix::determinant);
  }
}
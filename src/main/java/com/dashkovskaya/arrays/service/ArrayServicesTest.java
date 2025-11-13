package com.dashkovskaya.arrays.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.impl.ArrayElementsChangeService;
import com.dashkovskaya.arrays.service.impl.AverageArrayValueService;
import com.dashkovskaya.arrays.service.impl.MaxArrayValueService;
import com.dashkovskaya.arrays.service.impl.MinArrayValueService;
import com.dashkovskaya.arrays.service.impl.PositiveNegativeCountService;
import com.dashkovskaya.arrays.service.impl.SumOfArrayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayServicesTest {

  private MaxArrayValueService maxService;
  private MinArrayValueService minService;
  private SumOfArrayService sumService;
  private AverageArrayValueService averageService;
  private PositiveNegativeCountService countService;
  private ArrayElementsChangeService changeService;

  @BeforeEach
  void setUp() {
    maxService = new MaxArrayValueService();
    minService = new MinArrayValueService();
    sumService = new SumOfArrayService();
    averageService = new AverageArrayValueService();
    countService = new PositiveNegativeCountService();
    changeService = new ArrayElementsChangeService();
  }

  @Test
  void testFindMaxArrayValue_NormalArray() throws ArrayException {
    int[] array = {2, 10, 5, 8};
    int max = maxService.findMaxArrayValue(array);

    assertEquals(10, max);
  }

  @Test
  void testFindMaxArrayValue_ThrowsExceptionForNull() {
    assertThrows(ArrayException.class, () -> maxService.findMaxArrayValue(null));
  }

  @Test
  void testFindMinArrayValue_NormalArray() throws ArrayException {
    int[] array = {4, -3, 9, 0};
    int min = minService.findMinArrayValue(array);

    assertEquals(-3, min);
  }

  @Test
  void testFindMinArrayValue_ThrowsExceptionForEmpty() {
    assertThrows(ArrayException.class, () -> minService.findMinArrayValue(new int[]{}));
  }

  @Test
  void testCalculateSumOfArray_NormalArray() throws ArrayException {
    int[] array = {2, 4, 6};
    int sum = sumService.calculateSumOfArray(array);

    assertEquals(12, sum);
  }

  @Test
  void testCalculateSumOfArray_WithNegatives() throws ArrayException {
    int[] array = {-2, 5, -3};
    int sum = sumService.calculateSumOfArray(array);

    assertEquals(0, sum);
  }

  @Test
  void testCalculateSumOfArray_ThrowsExceptionForNull() {
    assertThrows(ArrayException.class, () -> sumService.calculateSumOfArray(null));
  }

  @Test
  void testFindAverageArrayValue_NormalArray() throws ArrayException {
    int[] array = {2, 4, 6, 8};
    double average = averageService.findAverageArrayValue(array);

    assertEquals(5.0, average);
  }

  @Test
  void testFindAverageArrayValue_SingleElement() throws ArrayException {
    int[] array = {10};
    double average = averageService.findAverageArrayValue(array);

    assertEquals(10.0, average);
  }

  @Test
  void testCountPositiveAndNegative_MixedValues() throws ArrayException {
    int[] input = {-3, 0, 5, 7, -2};
    int[] result = countService.countPositiveAndNegative(input);

    assertEquals(2, result[0]); // positives
    assertEquals(2, result[1]); // negatives
  }

  @Test
  void testCountPositiveAndNegative_AllNegative() throws ArrayException {
    int[] input = {-1, -2, -3};
    int[] result = countService.countPositiveAndNegative(input);

    assertEquals(0, result[0]);
    assertEquals(3, result[1]);
  }

  @Test
  void testChangeArrayElements_ReplacesNegativesWithZero() throws ArrayException {
    int[] input = {-3, 5, -1, 2};
    int[] result = changeService.changeArrayElements(input);

    assertArrayEquals(new int[]{0, 5, 0, 2}, result);
  }

  @Test
  void testChangeArrayElements_NoNegatives() throws ArrayException {
    int[] input = {1, 2, 3};
    int[] result = changeService.changeArrayElements(input);

    assertArrayEquals(input, result);
  }
}

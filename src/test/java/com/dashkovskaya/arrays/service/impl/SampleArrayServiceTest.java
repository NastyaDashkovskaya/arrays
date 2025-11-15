package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SampleArrayServiceTest {

  int[] exampleArray;
  @BeforeEach
  public void setUp() throws ArrayException {
    SampleArray sampleArray = SampleArray.newBuilder()
            .setIdArray(1)
            .setArray(1, 0, -2, 3, 6, 7)
            .build();
    exampleArray = sampleArray.getArray();
  }

  @Test
  public void findMinArrayValue() throws ArrayException {
    int expected = -2;
    MinArrayValueService minService = new MinArrayValueService();
    int actual = minService.findMinArrayValue(exampleArray);
    assertEquals(expected, actual);
  }

  @Test
  public void findMaxArrayValue() throws ArrayException {
    int expected = 7;
    MaxArrayValueService maxService = new MaxArrayValueService();
    int actual = maxService.findMaxArrayValue(exampleArray);
    assertEquals(expected, actual);
  }

  @Test
  public void findAverageArrayValue() throws ArrayException {
    double expected = 2.5;
    AverageArrayValueService averageService = new AverageArrayValueService();
    double actual = averageService.findAverageArrayValue(exampleArray);
    assertEquals(expected, actual);
  }

  @Test
  public void calculateSumOfArray() throws ArrayException {
    double expected = 15;
    SumOfArrayService sumService = new SumOfArrayService();
    double actual = sumService.calculateSumOfArray(exampleArray);
    assertEquals(expected, actual);
  }

  @Test
  public void countPositiveAndNegative() throws ArrayException {
    int[] expected = {4,1};
    PositiveNegativeCountService countService = new PositiveNegativeCountService();
    int[] actual = countService.countPositiveAndNegative(exampleArray);
    assertArrayEquals(expected, actual);
  }

  @Test
  public void changeArrayElements() throws ArrayException {
    int[] expected = {1, 0, 0, 3, 6, 7};
    ArrayElementsChangeService changeService = new ArrayElementsChangeService();
    int[] actual = changeService.changeArrayElements(exampleArray);
    assertArrayEquals(expected, actual);
  }


}
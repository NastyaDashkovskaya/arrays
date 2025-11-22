package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.SumOfArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumOfArrayService implements SumOfArray {

  private final Logger logger = LogManager.getLogger();

  @Override
  public int calculateSumOfArray(int[] array) throws ArrayException {

    if (array == null) {
      logger.error("Array is null. Cannot calculate sum.");
      throw new ArrayException("Array is null");
    }
    int sum = 0;
    for (int i : array) {
      sum += i;
    }
    return sum;
  }
}

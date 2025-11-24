package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.SumOfArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumOfArrayService implements SumOfArray {

  private final Logger logger = LogManager.getLogger();

  @Override
  public int calculateSumOfArray(SampleArray sampleArray) throws ArrayException {

    if (sampleArray == null) {
      logger.error("Array is null. Cannot calculate sum.");
      throw new ArrayException("Array is null");
    }
    int[] array = sampleArray.getArray();
    int sum = 0;
    for (int i : array) {
      sum += i;
    }
    return sum;
  }
}

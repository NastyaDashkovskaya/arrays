package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.PositiveNegativeCount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PositiveNegativeCountService implements PositiveNegativeCount {

  private final Logger logger = LogManager.getLogger();

  public int[] countPositiveAndNegative(SampleArray sampleArray) throws ArrayException {

    if (sampleArray == null) {
      logger.error("Array is null. Cannot  count positive and negative.");
      throw new ArrayException("Array is null");
    }
    int[] array = sampleArray.getArray();
    int positiveCount = 0;
    int negativeCount = 0;

    for (int value : array) {
      if (value > 0) {
        positiveCount++;
      } else if (value < 0) {
        negativeCount++;
      }
    }
    return new int[]{positiveCount, negativeCount};
  }
}

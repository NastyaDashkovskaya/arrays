package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.AverageArrayValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AverageArrayValueService implements AverageArrayValue {

  private final Logger logger = LogManager.getLogger();

  public double findAverageArrayValue(int[] array) throws ArrayException {

    if (array == null) {
      logger.error("Array is null. Cannot  find average.");
      throw new ArrayException("Array is null");
    }
    double sum = 0;

    for (int value : array) {
      sum += value;
    }

    return sum / array.length;
  }
}

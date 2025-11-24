package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.MinArrayValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinArrayValueService   implements MinArrayValue {

  private final Logger logger = LogManager.getLogger();

  @Override
  public int findMinArrayValue(SampleArray sampleArray) throws ArrayException {

    if (sampleArray == null) {
      logger.error("Array is null. Cannot  count min.");
      throw new ArrayException("Array is null");
    }
    int[] array = sampleArray.getArray();
    int min = array[0];
    for (int i : array) {
      if (i < min) min = i;
    }
    return min;
  }
}

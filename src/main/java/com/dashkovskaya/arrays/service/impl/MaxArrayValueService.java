package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.MaxArrayValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MaxArrayValueService implements MaxArrayValue {

  private final Logger logger = LogManager.getLogger();

  public int findMaxArrayValue(SampleArray sampleArray) throws ArrayException {

    if (sampleArray == null) {
      logger.error("Array is null. Cannot  count max.");
      throw new ArrayException("Array is null");
    }
    int[] array = sampleArray.getArray();
    int max = array[0];
    for (int i : array) {
      if (i > max) max = i;
    }
    return max;
  }
}

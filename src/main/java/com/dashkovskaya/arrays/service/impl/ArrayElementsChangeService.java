package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.ArrayElementsChange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayElementsChangeService implements ArrayElementsChange {

  private final Logger logger = LogManager.getLogger();

  public int[] changeArrayElements(int[] array) throws ArrayException {

    if (array == null) {
      logger.error("Array is null. Cannot  change array.");
      throw new ArrayException("Array is null");
    }
    for (int i = 0; i < array.length; i++) {
      if (array[i] < 0) {
        array[i] = 0;
      }
    }
    return array;
  }
}


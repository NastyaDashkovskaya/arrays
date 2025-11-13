package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.MinArrayValue;
import com.dashkovskaya.arrays.validator.ArrayValidator;

public class MinArrayValueService   implements MinArrayValue {
  @Override
  public int findMinArrayValue(int[] array) throws ArrayException {
    ArrayValidator validator = new ArrayValidator();

    validator.validateArray(array);

    int min = array[0];
    for (int i : array) {
      if (i < min) min = i;
    }
    return min;
  }
}

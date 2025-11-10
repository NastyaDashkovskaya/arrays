package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.MaxArrayValue;
import com.dashkovskaya.arrays.service.validator.ArrayValidator;

public class MaxArrayValueService implements MaxArrayValue {
  public int findMaxArrayValue(int[] array) throws ArrayException {
    ArrayValidator validator = new ArrayValidator();

    validator.validateArray(array);

    int max = array[0];
    for (int i : array) {
      if (i > max) max = i;
    }
    return max;
}
}

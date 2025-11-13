package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.MaxArrayValue;

public class MaxArrayValueService implements MaxArrayValue {
  public int findMaxArrayValue(int[] array) throws ArrayException {

    int max = array[0];
    for (int i : array) {
      if (i > max) max = i;
    }
    return max;
}
}

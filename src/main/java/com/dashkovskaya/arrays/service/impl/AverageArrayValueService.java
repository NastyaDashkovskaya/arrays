package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.AverageArrayValue;

public class AverageArrayValueService implements AverageArrayValue {

  public double findAverageArrayValue(int[] array) throws ArrayException {

    double sum = 0;

    for (int value : array) {
      sum += value;
    }

    return sum / array.length;
  }
}

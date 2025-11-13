package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.PositiveNegativeCount;

public class PositiveNegativeCountService implements PositiveNegativeCount {

  public int[] countPositiveAndNegative(int[] array) throws ArrayException {


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

package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.SumOfArray;

public class SumOfArrayService implements SumOfArray {
  @Override
  public int calculateSumOfArray(int[] array) throws ArrayException {

    int sum = 0;
    for (int i : array) {
      sum += i;
    }
    return sum;
  }
}

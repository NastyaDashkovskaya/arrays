package com.dashkovskaya.arrays.service;

import com.dashkovskaya.arrays.exception.ArrayException;

public interface PositiveNegativeCount {
  int[] countPositiveAndNegative(int[] array) throws ArrayException;
}

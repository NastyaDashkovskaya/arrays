package com.dashkovskaya.arrays.service;

import com.dashkovskaya.arrays.exception.ArrayException;

public interface ArrayElementsChange {
  int[] changeArrayElements(int[] array) throws ArrayException;
}

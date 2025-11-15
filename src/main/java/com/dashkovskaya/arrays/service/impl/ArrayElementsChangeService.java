package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.ArrayElementsChange;

public class ArrayElementsChangeService implements ArrayElementsChange {

  public int[] changeArrayElements(int[] array) throws ArrayException {

    for (int i = 0; i < array.length; i++) {
      if (array[i] < 0) {
        array[i] = 0;
      }
    }

    return array;
  }
}


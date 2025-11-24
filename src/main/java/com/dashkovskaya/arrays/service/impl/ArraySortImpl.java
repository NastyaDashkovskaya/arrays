package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.ArraySort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArraySortImpl implements ArraySort {

  private final Logger logger = LogManager.getLogger();

  @Override
  public SampleArray bubblesort(SampleArray sampleArray) throws ArrayException{

    if (sampleArray == null) {
      logger.error("SampleArray is null. Cannot sort array.");
      throw new ArrayException("SampleArray is null");
    }
    int[] arraySort = Arrays.copyOf(sampleArray.getArray(), sampleArray.getArray().length);

    for (int i = 0; i < arraySort.length - 1; i++) {
      for (int j = 0; j < arraySort.length - 1 - i; j++) {
        if (arraySort[j] > arraySort[j + 1]) {
          int temp = arraySort[j];
          arraySort[j] = arraySort[j + 1];
          arraySort[j + 1] = temp;
        }
      }
    }
    return SampleArray.newBuilder()
            .setIdArray(sampleArray.getArrayId())
            .setArray(arraySort)
            .build();
  }

  @Override
  public SampleArray selectionSort(SampleArray sampleArray) throws ArrayException{

    if (sampleArray == null) {
      logger.error("SampleArray is null. Cannot sort array.");
      throw new ArrayException("SampleArray is null");
    }
    int[] arraySort = Arrays.copyOf(sampleArray.getArray(), sampleArray.getArray().length);

    for (int i = 0; i < arraySort.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arraySort.length; j++) {
        if (arraySort[j] < arraySort[minIndex]) {
          minIndex = j;
        }
      }
      int temp = arraySort[minIndex];
      arraySort[minIndex] = arraySort[i];
      arraySort[i] = temp;
    }
    return SampleArray.newBuilder()
            .setIdArray(sampleArray.getArrayId())
            .setArray(arraySort)
            .build();
  }

  @Override
  public SampleArray insertionSort(SampleArray sampleArray) throws ArrayException{

    if (sampleArray == null) {
      logger.error("SampleArray is null. Cannot sort array.");
      throw new ArrayException("SampleArray is null");
    }
    int[] arraySort = Arrays.copyOf(sampleArray.getArray(), sampleArray.getArray().length);

      for (int i = 1; i < arraySort.length; i++) {
        int key = arraySort[i];
        int j = i - 1;
        while (j >= 0 && arraySort[j] > key) {
          arraySort[j + 1] = arraySort[j];
          j--;
        }
        arraySort[j + 1] = key;
      }
    return SampleArray.newBuilder()
            .setIdArray(sampleArray.getArrayId())
            .setArray(arraySort)
            .build();
  }
}

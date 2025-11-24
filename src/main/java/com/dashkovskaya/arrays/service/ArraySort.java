package com.dashkovskaya.arrays.service;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;

public interface ArraySort {
  SampleArray bubblesort(SampleArray array) throws ArrayException;
  SampleArray selectionSort(SampleArray array) throws ArrayException;
  SampleArray insertionSort(SampleArray array) throws ArrayException;
}

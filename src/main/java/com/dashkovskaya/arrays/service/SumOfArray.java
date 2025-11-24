package com.dashkovskaya.arrays.service;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;

public interface SumOfArray {
  int calculateSumOfArray(SampleArray array) throws ArrayException;
}

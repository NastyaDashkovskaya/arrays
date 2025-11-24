package com.dashkovskaya.arrays.service;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;

public interface AverageArrayValue {
  double findAverageArrayValue(SampleArray array) throws ArrayException;
}

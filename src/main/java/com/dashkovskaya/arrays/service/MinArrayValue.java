package com.dashkovskaya.arrays.service;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;

public interface MinArrayValue {
  int findMinArrayValue(SampleArray array) throws ArrayException;
}

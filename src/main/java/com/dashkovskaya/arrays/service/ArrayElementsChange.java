package com.dashkovskaya.arrays.service;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;

public interface ArrayElementsChange {
  SampleArray changeArrayElements(SampleArray array) throws ArrayException;
}

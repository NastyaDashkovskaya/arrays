package com.dashkovskaya.arrays.specification.impl;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.impl.AverageArrayValueService;
import com.dashkovskaya.arrays.service.impl.MinArrayValueService;
import com.dashkovskaya.arrays.specification.SampleArraySpecificator;

public class SampleArrayMinLessSpecification implements SampleArraySpecificator {

  private int min;

  public SampleArrayMinLessSpecification(int min) {
    this.min = min;
  }

  @Override
  public boolean specs(SampleArray array)  {
    MinArrayValueService minArrayValueService = new MinArrayValueService();
    try {
      return minArrayValueService.findMinArrayValue(array) < min;
    } catch (ArrayException exception) {
      return false;
    }
  }
}

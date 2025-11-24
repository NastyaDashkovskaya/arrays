package com.dashkovskaya.arrays.specification.impl;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.impl.AverageArrayValueService;
import com.dashkovskaya.arrays.specification.SampleArraySpecificator;

public class SampleArrayAverageGreaterSpecification implements SampleArraySpecificator {

  private int value;

  public SampleArrayAverageGreaterSpecification(int value) {
    this.value = value;
  }

  @Override
  public boolean specs(SampleArray array) {
    AverageArrayValueService averageArrayValueService = new AverageArrayValueService();
    try {
      return averageArrayValueService.findAverageArrayValue(array) < value;
    } catch (ArrayException exception) {
      return false;
    }
  }
}

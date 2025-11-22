package com.dashkovskaya.arrays.specification.impl;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.specification.SampleArraySpecificator;

public class SampleArrayFindByIdSpecification implements SampleArraySpecificator {

  private int arrayId;

  public SampleArrayFindByIdSpecification(int id) {
    this.arrayId = id;
  }

  @Override
  public boolean specs(SampleArray array) {
    return array.getArrayId() == arrayId;
  }
}

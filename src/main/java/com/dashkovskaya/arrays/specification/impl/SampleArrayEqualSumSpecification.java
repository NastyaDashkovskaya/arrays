package com.dashkovskaya.arrays.specification.impl;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.service.impl.SumOfArrayService;
import com.dashkovskaya.arrays.specification.SampleArraySpecificator;

public class SampleArrayEqualSumSpecification implements SampleArraySpecificator {

  private int sum;

  public SampleArrayEqualSumSpecification(int sum) {
    this.sum = sum;
  }
  @Override
  public boolean specs(SampleArray array) {
    SumOfArrayService sumOfArrayService = new SumOfArrayService();
   try{
    return sum == sumOfArrayService.calculateSumOfArray(array);
   } catch (ArrayException exception){
     return false;
   }
  }
}

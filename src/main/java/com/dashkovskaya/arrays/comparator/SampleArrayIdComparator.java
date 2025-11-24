package com.dashkovskaya.arrays.comparator;

import com.dashkovskaya.arrays.entity.SampleArray;

import java.util.Comparator;

public class SampleArrayIdComparator implements Comparator<SampleArray> {
  @Override
  public int compare(SampleArray array1, SampleArray array2) {
    return Long.compare(array1.getArrayId(), array2.getArrayId());
  }
}

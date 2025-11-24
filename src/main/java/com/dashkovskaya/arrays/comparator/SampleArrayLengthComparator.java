package com.dashkovskaya.arrays.comparator;

import com.dashkovskaya.arrays.entity.SampleArray;

import java.util.Comparator;

public class SampleArrayLengthComparator implements Comparator<SampleArray> {
  @Override
  public int compare(SampleArray array1, SampleArray array2) {
    return Integer.compare(array1.getArray().length, array2.getArray().length);
  }
}

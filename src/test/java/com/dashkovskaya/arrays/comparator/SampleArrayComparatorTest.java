package com.dashkovskaya.arrays.comparator;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SampleArrayComparatorTest {
  @Test
  void compare_byLength_correctOrder() throws ArrayException {
    SampleArray a1 = SampleArray.newBuilder().setIdArray(1).setArray(new int[]{1}).build();
    SampleArray a2 = SampleArray.newBuilder().setIdArray(2).setArray(new int[]{1,2}).build();

    SampleArrayLengthComparator comparator = new SampleArrayLengthComparator();

    assertTrue(comparator.compare(a1, a2) < 0);
    assertTrue(comparator.compare(a2, a1) > 0);
  }

}
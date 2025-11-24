package com.dashkovskaya.arrays.sampleArrayTest;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SampleArrayTest {
  @Test
  void builder_NegativeId_ThrowsException() {
    assertThrows(ArrayException.class,
            () -> SampleArray.newBuilder().setIdArray(-1).setArray(1,2).build());
  }

  @Test
  void builder_EmptyArray_ThrowsException() {
    assertThrows(ArrayException.class,
            () -> SampleArray.newBuilder().setIdArray(1).setArray().build());
  }

  @Test
  void builder_ValidArray_CreatesObject() throws ArrayException {
    SampleArray array = SampleArray.newBuilder().setIdArray(1).setArray(1,2,3).build();
    assertEquals(1, array.getArrayId());
    assertArrayEquals(new int[]{1,2,3}, array.getArray());
  }

  @Test
  void observer_NotifyCalled() throws ArrayException {
    SampleArray array = SampleArray.newBuilder().setIdArray(1).setArray(1).build();
    final boolean[] updated = {false};

    array.addObserver(a -> updated[0] = true);
    array.notifySampleArrayObserver();
    assertTrue(updated[0]);
  }
}

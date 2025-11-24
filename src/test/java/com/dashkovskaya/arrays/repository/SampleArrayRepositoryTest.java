package com.dashkovskaya.arrays.repository;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.specification.SampleArraySpecificator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SampleArrayRepositoryTest {
  SampleArrayRepository repository;

  @BeforeEach
  void setUp() throws ArrayException {
    repository = SampleArrayRepository.getInstance();
    for (SampleArray arr : repository.getCustomArrays()) {
      repository.removeArray(arr);
    }
  }

  @Test
  void addArray_null_throwsException() {
    assertThrows(ArrayException.class, () -> repository.addArray(null));
  }

  @Test
  void addArray_validArray_addedSuccessfully() throws ArrayException {
    SampleArray array = SampleArray.newBuilder().setIdArray(1).setArray(new int[]{1,2,3}).build();

    repository.addArray(array);
    assertTrue(repository.getCustomArrays().contains(array));
  }

  @Test
  void removeArray_null_throwsException() {
    assertThrows(ArrayException.class, () -> repository.removeArray(null));
  }

  @Test
  void removeArray_existingArray_removedSuccessfully() throws ArrayException {
    SampleArray array = SampleArray.newBuilder().setIdArray(1).setArray(new int[]{1}).build();

    repository.addArray(array);
    repository.removeArray(array);

    assertFalse(repository.getCustomArrays().contains(array));
  }

  @Test
  void getCustomArrays_returnsCopy_notReference() throws ArrayException {
    SampleArray array = SampleArray.newBuilder().setIdArray(1).setArray(new int[]{1}).build();
    repository.addArray(array);

    List<SampleArray> list1 = repository.getCustomArrays();
    List<SampleArray> list2 = repository.getCustomArrays();

    assertNotSame(list1, list2);
    assertThrows(UnsupportedOperationException.class, () -> list1.add(array));
  }

  @Test
  void query_returnsCorrectArrays() throws ArrayException {
    SampleArray array1 = SampleArray.newBuilder().setIdArray(1).setArray(new int[]{1,2}).build();
    SampleArray array2 = SampleArray.newBuilder().setIdArray(2).setArray(new int[]{5,6}).build();

    repository.addArray(array1);
    repository.addArray(array2);
    SampleArraySpecificator specificator = array -> array.getArray()[0] == 1;

    List<SampleArray> result = repository.query(specificator);

    assertEquals(1, result.size());
    assertTrue(result.contains(array1));
  }

  @Test
  void sort_returnsSortedCopy_withoutModifyingOriginal() throws ArrayException {
    SampleArray a1 = SampleArray.newBuilder().setIdArray(1).setArray(new int[]{5,6}).build();
    SampleArray a2 = SampleArray.newBuilder().setIdArray(2).setArray(new int[]{1}).build();

    repository.addArray(a1);
    repository.addArray(a2);

    List<SampleArray> sorted = repository.sort(Comparator.comparingInt(a -> a.getArray().length));

    assertEquals(a2, sorted.get(0));
    assertEquals(a1, sorted.get(1));

    assertEquals(2, repository.getCustomArrays().size());
  }

}
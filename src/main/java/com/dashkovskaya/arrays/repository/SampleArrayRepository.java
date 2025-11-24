package com.dashkovskaya.arrays.repository;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.reader.SampleArrayReader;
import com.dashkovskaya.arrays.specification.SampleArraySpecificator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SampleArrayRepository {

  static final Logger logger = LogManager.getLogger();

  private static SampleArrayRepository instance;
  private final List<SampleArray> sampleArrays = new ArrayList<>();

  private SampleArrayRepository() {
  }

  public static SampleArrayRepository getInstance() {
    if (instance == null) {
      instance = new SampleArrayRepository();
    }
    return instance;
  }

  public void addArray(SampleArray sampleArray) throws ArrayException {
    if(sampleArray == null) {
      logger.warn("Array is null.");
      throw new ArrayException("Cannot add null array.");
    }
     sampleArrays.add(sampleArray);
  }

  public void removeArray(SampleArray sampleArray) throws ArrayException {
    if(sampleArray == null) {
      logger.warn("Trying to remove null array from repository");
      throw new ArrayException("Cannot remove null from repository");
    }
    sampleArrays.remove(sampleArray);
  }

  public List<SampleArray> getCustomArrays(){
    return List.copyOf(sampleArrays);
  }

  public List<SampleArray> query(SampleArraySpecificator specification) {
    List<SampleArray> result = new ArrayList<>();
    for (SampleArray array : sampleArrays) {
      if (specification.specs(array)) {
        result.add(array);
      }
    }
    return result;
  }

  public List<SampleArray> sort(Comparator<SampleArray> comparator) {
    List<SampleArray> sortedArray = new ArrayList<>(sampleArrays);
    sortedArray.sort(comparator);
    logger.info("Array was sorted.");
    return sortedArray;
  }
}

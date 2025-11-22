package com.dashkovskaya.arrays.repository;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.reader.SampleArrayReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
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

  public boolean addArray(SampleArray sampleArray) throws ArrayException {
    if(sampleArray == null) {
      logger.warn("Array is null.");
      throw new ArrayException("Cannot add null array.");
    }
    return sampleArrays.add(sampleArray);
  }

  public boolean removeArray(SampleArray sampleArray) throws ArrayException {
    if(sampleArray == null) {
      logger.warn("Trying to remove null array from repository");
      throw new ArrayException("Cannot remove null from repository");
    }
    return sampleArrays.remove(sampleArray);
  }

  public List<SampleArray> getCustomArrays(){
    return List.copyOf(sampleArrays);
  }

  @Override
  public List<SampleArray> query(Specification specification) {
    List<SampleArray> result = new ArrayList<>();
    for (SampleArray array : storage) {
      if (specification.match(array)) {
        result.add(array);
      }
    }
    return result;
  }

}

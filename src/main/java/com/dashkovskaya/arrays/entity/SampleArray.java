package com.dashkovskaya.arrays.entity;

import java.util.Arrays;

import com.dashkovskaya.arrays.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SampleArray {

  static final Logger logger = LogManager.getLogger();

  private int arrayId;
  private int[] array;

  private SampleArray() {
  }

  public int getArrayId() {
    return arrayId;
  }
  public int[] getArray() {
    return Arrays.copyOf(array, array.length);
  }

  public static Builder newBuilder() {
    return new SampleArray().new Builder();
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    SampleArray that = (SampleArray) o;
    if (arrayId == that.arrayId){
      return true;
    }

    for (int i = 0; i < array.length; i++) {
      if (array[i] != that.array[i]) {
        return false;
      }
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = arrayId;
    for (int i : array) {
      result = 31 * result + i;
    }
    return result;
  }

  @Override
  public String toString() {
    return "SampleArray{" +
            "IdArray=" + arrayId +
            ", array=" + Arrays.toString(array) +
            '}';
  }

  public class Builder {

    private Builder(){
    }
    public Builder setIdArray(int IdArray) throws ArrayException{
     if(IdArray < 0){
       logger.warn("Array's ID is not correct!");
       throw new ArrayException("Array's ID must be a positive number!");
     }
      SampleArray.this.arrayId = IdArray;
      return this;
    }

    public Builder setArray(int... array) throws ArrayException {
      if (array == null || array.length == 0){
        logger.warn("Array is empty!");
        throw new ArrayException("Array cannot be empty!");
      }
      SampleArray.this.array = Arrays.copyOf(array, array.length);
      return this;
    }

    public SampleArray build() {
      return SampleArray.this;
    }
  }
}

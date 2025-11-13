package com.dashkovskaya.arrays.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.dashkovskaya.arrays.exception.ArrayException;

public class ArrayValidator {

  static final Logger logger = LogManager.getLogger();

  public void validateArray(int[] array) throws ArrayException{
    if (array == null || array.length == 0){
      logger.warn("Array is empty!");
      throw new ArrayException("Array cannot be empty!");
    }
  }
}

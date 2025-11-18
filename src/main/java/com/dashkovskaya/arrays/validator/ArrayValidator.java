package com.dashkovskaya.arrays.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayValidator implements SampleArrayValidator{

  static final Logger logger = LogManager.getLogger();

  static final String SAMPLE_ARRAY_REGEX = "^[-0-9]+([ ,\\-]+[-0-9]+)*$";
  @Override
  public boolean isStringValid(String line) {
    if (line == null || line.isBlank()) {
      return false;
    }
    boolean resultOfValidation = line.matches(SAMPLE_ARRAY_REGEX);
    if (!resultOfValidation){
      logger.error("The line is not valid");
    }
    return resultOfValidation;
  }
}

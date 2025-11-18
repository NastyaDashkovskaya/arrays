package com.dashkovskaya.arrays.parser;

import com.dashkovskaya.arrays.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser implements SampleArrayParser {
  static final Logger logger = LogManager.getLogger();

  @Override
  public int[] parseArray(String stringToParse) throws ArrayException {
    if (stringToParse == null || stringToParse.isBlank()) {
      logger.error("The line is empty.");
      throw new ArrayException("Line can't be empty.");
    }

    try {
      String normalizedString = stringToParse.replace(",", " ").replace("-", " ");
      String[] parts = normalizedString.trim().split("\\s+");
      int[] array = new int[parts.length];

      for (int i = 0; i < parts.length; i++) {
        array[i] = Integer.parseInt(parts[i]);
      }
      return array;
    } catch (NumberFormatException exception) {
      logger.error("String conversion error: '{}'", stringToParse);
      throw new ArrayException("String conversion error. " + stringToParse, exception);
    }
  }
}

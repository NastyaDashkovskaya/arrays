package com.dashkovskaya.arrays.parser;

import com.dashkovskaya.arrays.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class TextParser implements SampleArrayParser {
  private final Logger logger = LogManager.getLogger();
  private final String SPLIT_REGEX = "\\s+";

  @Override
  public int[] parseArray(String lineArrayToParse) throws ArrayException {
    if (lineArrayToParse == null || lineArrayToParse.isBlank()) {
      logger.error("The line is empty.");
      throw new ArrayException("Line can't be empty.");
    }
    try {
      int[] array = Arrays.stream(lineArrayToParse
                      .replace(",", " ")
                      .replace("-", " ")
                      .trim()
                      .split(SPLIT_REGEX))
                      .mapToInt(Integer::parseInt)
                      .toArray();
      return array;
    } catch (NumberFormatException exception) {
      logger.error("String conversion error: '{}'", lineArrayToParse);
      throw new ArrayException("String conversion error. " + lineArrayToParse, exception);
    }
  }
}

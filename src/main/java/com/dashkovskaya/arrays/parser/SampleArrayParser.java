package com.dashkovskaya.arrays.parser;

import com.dashkovskaya.arrays.exception.ArrayException;

public interface SampleArrayParser {
  int[] parseArray(String lineArrayToParse) throws ArrayException;
}

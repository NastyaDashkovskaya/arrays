package com.dashkovskaya.arrays.reader;

import com.dashkovskaya.arrays.exception.ArrayException;

import java.util.List;

public interface SampleArrayReader {
  List<String> readLines(String filePath) throws ArrayException;
}

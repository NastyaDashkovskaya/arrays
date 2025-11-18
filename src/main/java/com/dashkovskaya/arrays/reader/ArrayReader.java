package com.dashkovskaya.arrays.reader;

import com.dashkovskaya.arrays.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayReader implements SampleArrayReader{
  static final Logger logger = LogManager.getLogger();
  private static final Path PATH = Path.of("src/main/resources/data.txt");
  @Override
  public List<String> readLines(String filePath) throws ArrayException {
    try{
    Path path = Path.of(filePath);
      if (!Files.exists(path)) {
        throw new ArrayException("File is not found. " + filePath);
      }
        return Files.lines(path)
                .filter(line -> line != null && !line.isBlank())
                .toList();
  } catch (IOException exception){
      logger.error("File reading error.");
      throw new ArrayException("File reading error. " + filePath, exception);
    }
}
}

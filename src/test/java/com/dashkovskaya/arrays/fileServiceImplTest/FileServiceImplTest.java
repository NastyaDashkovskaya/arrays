package com.dashkovskaya.arrays.fileServiceImplTest;

import com.dashkovskaya.arrays.comparator.SampleArrayLengthComparator;
import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.exception.ArrayException;
import com.dashkovskaya.arrays.parser.TextParser;
import com.dashkovskaya.arrays.reader.ArrayReader;
import com.dashkovskaya.arrays.repository.SampleArrayRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileServiceImplTest {

  static final Logger logger = LogManager.getLogger();

  ArrayReader reader = new ArrayReader();
  TextParser parser = new TextParser();
  SampleArrayRepository repository = SampleArrayRepository.getInstance();

  @Test
  void fullPipeline_ReadParseBuildStore(@TempDir Path tempDirectory) throws IOException {

    Path file = tempDirectory.resolve("data.txt");
    List<String> lines = List.of(
            "1, 3, 4, g",
            "3 4",
            "3..2 2 3 4 5",
            "1 f 35 5 3 1 9",
            "4 5 6 7",
            "8 4 7 5",
            "3",
            "2 4 5"
    );
    Files.write(file, lines);

    repository.getCustomArrays().forEach(a -> {
      try { repository.removeArray(a); } catch (ArrayException ignored) {}
    });

    List<String> fileLines;
    try {
      fileLines = reader.readLines(file.toString());
    } catch (ArrayException e) {
      logger.error("Cannot read file: " + e.getMessage());
      return;
    }

    int idCounter = 1;
    for (String line : fileLines) {
      try {
        int[] arrayData = parser.parseArray(line);
        SampleArray array = SampleArray.newBuilder()
                .setIdArray(idCounter++)
                .setArray(arrayData)
                .build();
        repository.addArray(array);
      } catch (ArrayException e) {
        logger.warn("Skipping invalid line '{}': {}", line, e.getMessage());
      }
    }

    List<SampleArray> sorted = repository.sort(new SampleArrayLengthComparator());
    int previousLength = 0;
    for (SampleArray arr : sorted) {
      assertTrue(arr.getArray().length >= previousLength);
      previousLength = arr.getArray().length;
    }
  }

}

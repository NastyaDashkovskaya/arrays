package com.dashkovskaya.arrays.reader;

import com.dashkovskaya.arrays.exception.ArrayException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayReaderTest {
  ArrayReader reader = new ArrayReader();

  @Test
  void readLines_FileNotFound_ThrowsException() {
    ArrayException ex = assertThrows(ArrayException.class, () -> reader.readLines("wrong.txt"));
    assertTrue(ex.getMessage().contains("File is not found"));
  }

  @Test
  void readLines_EmptyFile_ReturnsEmptyList(@TempDir Path tempDir) throws ArrayException, IOException {
    Path file = tempDir.resolve("empty.txt");
    Files.createFile(file);
    List<String> result = reader.readLines(file.toString());
    assertTrue(result.isEmpty());
  }

  @Test
  void readLines_FileWithContent_ReturnsLines(@TempDir Path tempDir) throws ArrayException, IOException {
    Path file = tempDir.resolve("data.txt");
    List<String> lines = Arrays.asList("1 2 3", "4 5 6");
    Files.write(file, lines);
    List<String> result = reader.readLines(file.toString());
    assertEquals(lines, result);
  }
}
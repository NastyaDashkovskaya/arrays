package com.dashkovskaya.arrays.parser;

import com.dashkovskaya.arrays.exception.ArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextParserTest {
  TextParser parser = new TextParser();

  @Test
  void parseArray_NullOrEmptyLine_ThrowsException() {
    assertThrows(ArrayException.class, () -> parser.parseArray(null));
    assertThrows(ArrayException.class, () -> parser.parseArray(""));
    assertThrows(ArrayException.class, () -> parser.parseArray("   "));
  }

  @Test
  void parseArray_InvalidLine_ThrowsException() {
    assertThrows(ArrayException.class, () -> parser.parseArray("1 2 a"));
  }

  @Test
  void parseArray_ValidLine_ReturnsIntArray() throws ArrayException {
    int[] expected = {1,2,3,4,5};
    assertArrayEquals(expected, parser.parseArray("1 2,3-4 5"));
  }
}
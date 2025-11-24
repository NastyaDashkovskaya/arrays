package com.dashkovskaya.arrays.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayValidatorTest {

  ArrayValidator validator = new ArrayValidator();

  @Test
  void validArray_returnsTrue() {
    assertTrue(validator.isStringValid("1 2 3"));
  }

  @Test
  void emptyString_returnsFalse() {
    assertFalse(validator.isStringValid(""));
  }

  @Test
  void invalidSymbols_returnsFalse() {
    assertFalse(validator.isStringValid("1 a 2"));
  }

  @Test
  void doubleDot_returnsFalse() {
    assertFalse(validator.isStringValid("3..5"));
  }

}
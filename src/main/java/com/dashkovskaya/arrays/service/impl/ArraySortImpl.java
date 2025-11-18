package com.dashkovskaya.arrays.service.impl;

import com.dashkovskaya.arrays.service.ArraySort;

import java.util.Arrays;

public class ArraySortImpl implements ArraySort {

  @Override
  public int[] bublesort(int[] array) {
    int[] arraySort = Arrays.copyOf(array, array.length);

    for (int i = 0; i < arraySort.length - 1; i++) {
      for (int j = 0; j < arraySort.length - 1 - i; j++) {
        if (arraySort[j] > arraySort[j + 1]) {
          int temp = arraySort[j];
          arraySort[j] = arraySort[j + 1];
          arraySort[j + 1] = temp;
        }
      }
    }
    return arraySort;
  }

  @Override
  public int[] selectionSort(int[] array) {
    int[] arraySort = Arrays.copyOf(array, array.length);

    for (int i = 0; i < arraySort.length - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < arraySort.length; j++) {
        if (arraySort[j] < arraySort[minIndex]) {
          minIndex = j;
        }
      }
      int temp = arraySort[minIndex];
      arraySort[minIndex] = arraySort[i];
      arraySort[i] = temp;
    }
    return arraySort;
  }

  @Override
  public int[] insertionsort(int[] array) {
    int[] arraySort = Arrays.copyOf(array, array.length);

      for (int i = 1; i < arraySort.length; i++) {
        int key = arraySort[i];
        int j = i - 1;
        while (j >= 0 && arraySort[j] > key) {
          arraySort[j + 1] = arraySort[j];
          j--;
        }
        arraySort[j + 1] = key;
      }
      return arraySort;
  }
}

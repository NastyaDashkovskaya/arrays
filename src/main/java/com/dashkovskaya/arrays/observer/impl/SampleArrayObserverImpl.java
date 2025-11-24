package com.dashkovskaya.arrays.observer.impl;

import com.dashkovskaya.arrays.entity.SampleArray;
import com.dashkovskaya.arrays.observer.SampleArrayObserver;
import com.dashkovskaya.arrays.service.impl.AverageArrayValueService;
import com.dashkovskaya.arrays.service.impl.MaxArrayValueService;
import com.dashkovskaya.arrays.service.impl.MinArrayValueService;
import com.dashkovskaya.arrays.service.impl.SumOfArrayService;
import com.dashkovskaya.arrays.statistics.SampleArrayStatistics;
import com.dashkovskaya.arrays.warehouse.SampleArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SampleArrayObserverImpl implements SampleArrayObserver {

  static final Logger logger = LogManager.getLogger();

  SumOfArrayService sumService = new SumOfArrayService();
  MaxArrayValueService maxService = new MaxArrayValueService();
  MinArrayValueService minService = new MinArrayValueService();
  AverageArrayValueService avgService = new AverageArrayValueService();
    @Override
    public void update(SampleArray sampleArray) {
      try {
      int sum = sumService.calculateSumOfArray(sampleArray);
      int max = maxService.findMaxArrayValue(sampleArray);
      int min = minService.findMinArrayValue(sampleArray);
      double avg = avgService.findAverageArrayValue(sampleArray);

      SampleArrayStatistics stats = new SampleArrayStatistics(sum, min, max, avg);

      SampleArrayWarehouse.getInstance().putSampleArrayStatistics(sampleArray.getArrayId(), stats);
      } catch (Exception e) {
        logger.warn("Statistics calculation error.");
      }
    }
}

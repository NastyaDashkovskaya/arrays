package com.dashkovskaya.arrays.warehouse;

import com.dashkovskaya.arrays.statistics.SampleArrayStatistics;

import java.util.HashMap;
import java.util.Map;

public class SampleArrayWarehouse {

  private static SampleArrayWarehouse instance;
  private final Map<Long, SampleArrayStatistics> arrayStatistics = new HashMap<Long, SampleArrayStatistics>();


  private SampleArrayWarehouse() {
  }

  public static SampleArrayWarehouse getInstance() {
    if(instance == null) {
      instance = new SampleArrayWarehouse();
    }
    return instance;
  }

  public SampleArrayStatistics get(long id) {
    return arrayStatistics.get(id);
  }

  public void putSampleArrayStatistics(long id, SampleArrayStatistics params) {
    arrayStatistics.put(id, params);
  }

  public void remove(long id) {
    arrayStatistics.remove(id);
  }
}


package com.tricentis.demowebshop.stepDefinitions.data;

import java.util.HashMap;
import java.util.Map;

public class StepData {
    private final Map<String, Object> dataMap = new HashMap<>();

    public void setData(EData key, Object value) {
        dataMap.put(key.toString(), value);
    }

    public Object getData(EData key) {
        return dataMap.getOrDefault(key.toString(), null);
    }
}

package com.zhangqiang.options.store;

public interface FloatStore {

    void put(String key, float value);

    float getFloat(String key, float defaultValue);
}

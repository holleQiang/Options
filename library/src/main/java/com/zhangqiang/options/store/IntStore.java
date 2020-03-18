package com.zhangqiang.options.store;

public interface IntStore {

    void put(String key, int value);

    int getInt(String key, int defaultValue);
}

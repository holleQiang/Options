package com.zhangqiang.options.store;

public interface LongStore {

    void put(String key, long value);

    long getLong(String key, long defaultValue);
}

package com.zhangqiang.options.store;

public interface StringStore {

    void put(String key, String value);

    String getString(String key, String defaultValue);
}

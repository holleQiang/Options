package com.zhangqiang.options.store;

public interface BooleanStore {

    void put(String key, boolean value);

    boolean getBoolean(String key, boolean defaultValue);
}

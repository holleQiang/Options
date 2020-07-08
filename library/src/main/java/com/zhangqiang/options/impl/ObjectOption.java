package com.zhangqiang.options.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zhangqiang.options.Option;

public class ObjectOption<V> extends Option<V> {

    public ObjectOption(@NonNull String key, @Nullable V defaultValue) {
        super(key, defaultValue);
    }

    @Override
    protected void saveValue(String key, V value) {

    }

    @Override
    protected V getValue(String key, V defaultValue) {
        return defaultValue;
    }
}

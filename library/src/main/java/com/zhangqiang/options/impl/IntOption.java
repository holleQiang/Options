package com.zhangqiang.options.impl;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zhangqiang.options.Option;
import com.zhangqiang.options.store.IntStore;

public class IntOption extends Option<Integer> {


    private IntStore intStore;

    public IntOption(@NonNull String key, @Nullable Integer defaultValue, @Nullable IntStore intStore) {
        super(key, defaultValue);
        this.intStore = intStore;
    }

    @Override
    protected void saveValue(String key, Integer value) {
        if (intStore != null) {
            intStore.put(key, value);
        }
    }

    @Override
    protected Integer getValue(String key, Integer defaultValue) {
        if (intStore == null) {
            return defaultValue;
        }
        return intStore.getInt(key, defaultValue);
    }
}

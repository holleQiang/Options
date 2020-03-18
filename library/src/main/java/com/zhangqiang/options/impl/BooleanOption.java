package com.zhangqiang.options.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zhangqiang.options.Option;
import com.zhangqiang.options.store.BooleanStore;

public class BooleanOption extends Option<Boolean> {


    private BooleanStore booleanStore;

    public BooleanOption(@NonNull String key, @Nullable Boolean defaultValue, @Nullable BooleanStore booleanStore) {
        super(key, defaultValue);
        this.booleanStore = booleanStore;
    }

    @Override
    protected void saveValue(String key, Boolean value) {
        if (booleanStore != null) {
            booleanStore.put(key, value);
        }
    }

    @Override
    protected Boolean getValue(String key, Boolean defaultValue) {
        if (booleanStore == null) {
            return defaultValue;
        }
        return booleanStore.getBoolean(key, defaultValue);
    }
}

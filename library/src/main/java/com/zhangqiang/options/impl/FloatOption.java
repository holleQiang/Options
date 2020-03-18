package com.zhangqiang.options.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zhangqiang.options.Option;
import com.zhangqiang.options.store.FloatStore;

public class FloatOption extends Option<Float> {


    private FloatStore floatStore;

    public FloatOption(@NonNull String key, @Nullable Float defaultValue, FloatStore floatStore) {
        super(key, defaultValue);
        this.floatStore = floatStore;
    }

    @Override
    protected void saveValue(String key, Float value) {
        floatStore.put(key,value);
    }

    @Override
    protected Float getValue(String key, Float defaultValue) {
        return floatStore.getFloat(key,defaultValue);
    }
}

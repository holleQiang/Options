package com.zhangqiang.options.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zhangqiang.options.Option;
import com.zhangqiang.options.Options;
import com.zhangqiang.options.store.StringStore;

public class DoubleOption extends Option<Double> {

    private Option<String> internalOption;

    public DoubleOption(@NonNull String key, @Nullable Double defaultValue, @Nullable StringStore store) {
        super(key, defaultValue);
        this.internalOption = Options.ofString(key, String.valueOf(defaultValue), store);
    }

    @Override
    protected void saveValue(String key, Double value) {
        internalOption.set(String.valueOf(value));
    }

    @Override
    protected Double getValue(String key, Double defaultValue) {
        String s = internalOption.get();
        try {
            return Double.valueOf(s);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}

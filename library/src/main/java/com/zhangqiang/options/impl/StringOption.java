package com.zhangqiang.options.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zhangqiang.options.Option;
import com.zhangqiang.options.store.StringStore;


public class StringOption extends Option<String> {

    private StringStore stringStore;

    public StringOption(@NonNull String key, @Nullable String defaultValue, StringStore stringStore) {
        super(key, defaultValue);
        this.stringStore = stringStore;
    }

    @Override
    protected void saveValue(String key, String value) {
        stringStore.put(key, value);
    }

    @Override
    protected String getValue(String key, String defaultValue) {
        return stringStore.getString(key, defaultValue);
    }
}

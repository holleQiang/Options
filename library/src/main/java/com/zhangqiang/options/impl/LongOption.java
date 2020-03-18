package com.zhangqiang.options.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zhangqiang.options.Option;
import com.zhangqiang.options.store.LongStore;

public class LongOption extends Option<Long> {

    private LongStore longStore;

    public LongOption(@NonNull String key, @Nullable Long defaultValue, @Nullable LongStore longStore) {
        super(key, defaultValue);
        this.longStore = longStore;
    }

    @Override
    protected void saveValue(String key, Long value) {
        if (longStore != null) {
            longStore.put(key, value);
        }
    }

    @Override
    protected Long getValue(String key, Long defaultValue) {
        if (longStore == null) {
            return defaultValue;
        }
        return longStore.getLong(key, defaultValue);
    }
}

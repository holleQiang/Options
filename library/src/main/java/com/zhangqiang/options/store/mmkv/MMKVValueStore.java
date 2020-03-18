package com.zhangqiang.options.store.mmkv;

import android.content.Context;

import com.zhangqiang.options.store.ValueStore;


public class MMKVValueStore implements ValueStore {

    private Context context;

    public MMKVValueStore(Context context) {
        this.context = context;
    }

    @Override
    public void put(String key, int value) {
        MMKVUtils.getInstance(context).putInt(key,value);
    }

    @Override
    public void put(String key, String value) {
        MMKVUtils.getInstance(context).putString(key, value);
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return MMKVUtils.getInstance(context).getInt(key, defaultValue);
    }

    @Override
    public String getString(String key, String defaultValue) {
        return MMKVUtils.getInstance(context).getString(key, defaultValue);
    }

    @Override
    public void put(String key, boolean value) {
        MMKVUtils.getInstance(context).putBoolean(key, value);
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return MMKVUtils.getInstance(context).getBoolean(key, defaultValue);
    }

    @Override
    public void put(String key, float value) {
        MMKVUtils.getInstance(context).putFloat(key, value);
    }

    @Override
    public float getFloat(String key, float defaultValue) {
        return MMKVUtils.getInstance(context).getFloat(key, defaultValue);
    }

    @Override
    public void put(String key, long value) {
        MMKVUtils.getInstance(context).putLong(key, value);
    }

    @Override
    public long getLong(String key, long defaultValue) {
        return MMKVUtils.getInstance(context).getLong(key, defaultValue);
    }
}

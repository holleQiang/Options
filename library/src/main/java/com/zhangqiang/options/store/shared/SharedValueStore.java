package com.zhangqiang.options.store.shared;

import android.content.Context;
import android.content.SharedPreferences;

import com.zhangqiang.options.store.ValueStore;


public class SharedValueStore implements ValueStore {

    private SharedPreferences sharedPreferences;
    private final Context context;
    private final String fileName;

    public SharedValueStore(Context context, String fileName) {
        this.context = context.getApplicationContext();
        this.fileName = fileName;
    }

    @Override
    public void put(String key, int value) {
        getSharedPreferences().edit().putInt(key, value).apply();
    }

    @Override
    public void put(String key, String value) {
        getSharedPreferences().edit().putString(key, value).apply();
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return getSharedPreferences().getInt(key, defaultValue);
    }

    @Override
    public String getString(String key, String defaultValue) {
        return getSharedPreferences().getString(key, defaultValue);
    }

    public SharedPreferences getSharedPreferences() {
        if (sharedPreferences == null) {
            synchronized (this) {
                if (sharedPreferences == null) {
                    sharedPreferences = context.getSharedPreferences(fileName, 0);
                }
            }
        }
        return sharedPreferences;
    }

    @Override
    public void put(String key, boolean value) {
        getSharedPreferences().edit().putBoolean(key, value).apply();
    }

    @Override
    public boolean getBoolean(String key, boolean defaultValue) {
        return getSharedPreferences().getBoolean(key, defaultValue);
    }

    @Override
    public void put(String key, float value) {
        getSharedPreferences().edit().putFloat(key, value).apply();
    }

    @Override
    public float getFloat(String key, float defaultValue) {
        return getSharedPreferences().getFloat(key, defaultValue);
    }

    @Override
    public void put(String key, long value) {
        getSharedPreferences().edit().putFloat(key,value).apply();
    }

    @Override
    public long getLong(String key, long defaultValue) {
        return getSharedPreferences().getLong(key, defaultValue);
    }
}

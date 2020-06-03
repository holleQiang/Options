package com.zhangqiang.options.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zhangqiang.options.Option;
import com.zhangqiang.options.Options;
import com.zhangqiang.options.store.StringStore;

public class JsonOption<T> extends Option<T>{

    private Option<String> internalStore;
    private JsonParser<T> jsonParser;

    public JsonOption(@NonNull String key, @Nullable T defaultValue, @Nullable StringStore stringStore,@NonNull JsonParser<T> jsonParser) {
        super(key, defaultValue);
        this.jsonParser = jsonParser;
        internalStore = Options.ofString(key,jsonParser.toJsonString(defaultValue),stringStore);
    }

    @Override
    protected void saveValue(String key, T value) {
        internalStore.set(jsonParser.toJsonString(value));
    }

    @Override
    protected T getValue(String key, T defaultValue) {
        T object = jsonParser.toObject(internalStore.get());
        if (object == null) {
            return defaultValue;
        }
        return object;
    }

    public interface JsonParser<T>{

        String toJsonString(T obj);

        T toObject(String jsonString);
    }
}

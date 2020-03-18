package com.zhangqiang.options;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zhangqiang.options.impl.BooleanOption;
import com.zhangqiang.options.impl.FloatOption;
import com.zhangqiang.options.impl.IntOption;
import com.zhangqiang.options.impl.LongOption;
import com.zhangqiang.options.impl.StringOption;
import com.zhangqiang.options.store.BooleanStore;
import com.zhangqiang.options.store.FloatStore;
import com.zhangqiang.options.store.IntStore;
import com.zhangqiang.options.store.LongStore;
import com.zhangqiang.options.store.StringStore;


public class Options {


    public static Option<Integer> ofInt(@NonNull String key, @Nullable Integer defaultValue, IntStore store) {
        return new IntOption(key, defaultValue, store);
    }

    public static Option<String> ofString(@NonNull String key, @Nullable String defaultValue, StringStore store) {
        return new StringOption(key, defaultValue, store);
    }

    public static Option<Float> ofFloat(@NonNull String key, @Nullable Float defaultValue, FloatStore store) {
        return new FloatOption(key, defaultValue, store);
    }

    public static Option<Long> ofLong(@NonNull String key, @Nullable Long defaultValue, LongStore store) {
        return new LongOption(key, defaultValue, store);
    }

    public static Option<Boolean> ofBoolean(@NonNull String key, @Nullable Boolean defaultValue, BooleanStore store) {
        return new BooleanOption(key, defaultValue, store);
    }

}

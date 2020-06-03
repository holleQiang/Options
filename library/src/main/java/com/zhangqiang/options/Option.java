package com.zhangqiang.options;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;

public abstract class Option<V> {

    private final String key;
    private final V defaultValue;
    private V value;
    private List<OnValueChangedListener> onValueChangedListeners;

    public Option(@NonNull String key, @Nullable V defaultValue) {
        this.key = key;
        this.defaultValue = defaultValue;
        checkKey();
    }

    public synchronized void set(V value) {
        if (this.value == null && value != null || this.value != null && !this.value.equals(value)) {
            this.value = value;
            saveValue(key, value);
            if (onValueChangedListeners != null) {
                for (int i = onValueChangedListeners.size() - 1; i >= 0; i--) {
                    onValueChangedListeners.get(i).onValueChanged();
                }
            }
        }
    }

    protected abstract void saveValue(String key, V value);

    protected abstract V getValue(String key, V defaultValue);

    public synchronized V get() {
        if (value != null) {
            return value;
        }
        return getValue(key, defaultValue);
    }

    public synchronized void addOnValueChangedListener(OnValueChangedListener listener) {
        if (onValueChangedListeners == null) {
            onValueChangedListeners = new ArrayList<>();
        }
        if (onValueChangedListeners.contains(listener)) {
            return;
        }
        onValueChangedListeners.add(listener);
    }

    public synchronized void removeOnValueChangedListener(OnValueChangedListener listener) {
        if (onValueChangedListeners == null) {
            return;
        }
        onValueChangedListeners.remove(listener);
    }

    private void checkKey() {
        if (key == null || key.length() <= 0) {
            throw new IllegalArgumentException("key cannot be null");
        }
    }

    public Observable<V> toObservable() {
        return Observable.create(new ObservableOnSubscribe<V>() {
            @Override
            public void subscribe(final ObservableEmitter<V> e) throws Exception {

                V v = get();
                e.onNext(v);
                final OnValueChangedListener listener = new OnValueChangedListener() {
                    @Override
                    public void onValueChanged() {
                        e.onNext(get());
                    }
                };
                addOnValueChangedListener(listener);
                e.setCancellable(new Cancellable() {
                    @Override
                    public void cancel() throws Exception {
                        removeOnValueChangedListener(listener);
                    }
                });
            }
        });
    }
}

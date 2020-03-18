package com.zhangqiang.options.sample;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhangqiang.options.Option;
import com.zhangqiang.options.Options;
import com.zhangqiang.options.store.shared.SharedValueStore;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function3;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Option<Integer> option = Options.ofInt("aaa", 1, new SharedValueStore(this, "aaaa"));
        Option<Integer> option1 = Options.ofInt("bbb", 1, new SharedValueStore(this, "aaaa"));
        Option<Integer> option2 = Options.ofInt("ccc", 1, new SharedValueStore(this, "aaaa"));

        Observable.combineLatest(option.toObservable(), option1.toObservable(), option2.toObservable(), new Function3<Integer, Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2, Integer integer3) throws Exception {
                return integer + integer2 + integer3;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer value) {
                Log.i("Test", "============" + value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}

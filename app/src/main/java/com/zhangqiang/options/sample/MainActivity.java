package com.zhangqiang.options.sample;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.zhangqiang.options.Option;
import com.zhangqiang.options.Options;
import com.zhangqiang.options.store.shared.SharedValueStore;

import java.util.concurrent.CountDownLatch;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function3;

public class MainActivity extends AppCompatActivity {

    Option<String> stringOption = Options.ofString("ssss", "aaa", null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {

                long currentTimeMillis = System.currentTimeMillis();
                for (int i = 0; i < 10000; i++) {
                    stringOption.set(i + "");
                }
                Log.i("Test", "=======写用时===========" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }).start();
        long currentTimeMillis = System.currentTimeMillis();

        final CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    String s = stringOption.get();
                }
                countDownLatch.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                for (int i = 0; i < 10000; i++) {
                    String s = stringOption.get();
                }
                countDownLatch.countDown();
            }
        }).start();
        try {
            countDownLatch.await();
            Log.i("Test", "=======读用时===========" + (System.currentTimeMillis() - currentTimeMillis));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

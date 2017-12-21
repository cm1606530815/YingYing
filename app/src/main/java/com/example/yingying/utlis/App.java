package com.example.yingying.utlis;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by samsung on 2017/12/14.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}

package com.example.day01;

import android.app.Application;
import android.util.Log;

class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("12","application onCreate");
    }
}

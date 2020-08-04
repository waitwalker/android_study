package com.example.day07thread;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

class MyService1 extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("1","onBind方法");
        return null;
    }

    @Override
    public void onCreate() {
        Log.d("1","onCreate方法");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("1","onStartCommand方法");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.d("1","unBindService方法");
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        Log.d("1","onDestroy");
        super.onDestroy();
    }
}

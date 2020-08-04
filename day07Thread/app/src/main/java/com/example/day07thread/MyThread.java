package com.example.day07thread;

import android.util.Log;

class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        doSomeThing();
    }

    private void doSomeThing() {
        Log.d("1","处理任务");
    }
}

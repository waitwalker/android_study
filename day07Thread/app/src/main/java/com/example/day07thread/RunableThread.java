package com.example.day07thread;

import android.util.Log;

class RunableThread implements Runnable {
    @Override
    public void run() {
        doSomeThing();
    }

    private void doSomeThing() {
        Log.d("1","Runnable方式创建线程,在这里处理任务");
    }
}

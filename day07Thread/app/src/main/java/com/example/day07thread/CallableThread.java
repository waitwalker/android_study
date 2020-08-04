package com.example.day07thread;

import android.util.Log;

import java.util.concurrent.Callable;

class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        doSomeThing();
        return "需要返回的值";
    }

    private void doSomeThing() {
        Log.d("1","Callable方式创建线程,在这里处理任务");
    }
}

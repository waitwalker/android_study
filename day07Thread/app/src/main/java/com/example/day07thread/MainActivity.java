package com.example.day07thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 方式1
        MyThread thread = new MyThread();
        thread.start();

        // 方式2
        RunableThread runableThread = new RunableThread();
        Thread thread1 = new Thread(runableThread);
        thread1.start();

        // 方式3
        CallableThread callableThread = new CallableThread();
        FutureTask<String> futureTask = new FutureTask<String>(callableThread);
        Thread thread2 = new Thread(futureTask);
        thread2.start();

        try {
            String string = futureTask.get();
            Log.d("1","Callable 返回值:"+ string);
        } catch (Exception e) {
            Log.d("1","ee"+e.getLocalizedMessage());
        }
    }
}
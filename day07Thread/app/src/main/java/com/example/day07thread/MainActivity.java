package com.example.day07thread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import java.util.concurrent.FutureTask;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnClickListener {

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

        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button2);

        button.setOnClickListener(this);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final Intent intent = new Intent(MainActivity.this, MyService1.class);
        switch (v.getId()) {
            case R.id.button:
                startService(intent);
                break;
            case R.id.button2:
                stopService(intent);
                break;
        }
    }
}
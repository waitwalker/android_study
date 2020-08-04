package com.example.day07thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyThread thread = new MyThread();
        thread.start();

        RunableThread runableThread = new RunableThread();
        Thread thread1 = new Thread(runableThread);
        thread1.start();

    }
}
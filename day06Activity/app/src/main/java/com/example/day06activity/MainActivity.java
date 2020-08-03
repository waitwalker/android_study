package com.example.day06activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("12","onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name","张三");
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.day06activity.ThirdActivity");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d("12","onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("12","onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("12","onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("12","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("12","onDestroy");
        super.onDestroy();
    }
}
package com.example.day07broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DynamicBReceiver dynamicBReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        // 1.1 动态注册广播接收器
        dynamicBReceiver = new DynamicBReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.day07broadcastreceiver.DynamicBReceiver");
        registerReceiver(dynamicBReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 1.2 取消动态注册广播接收器
        unregisterReceiver(dynamicBReceiver);
    }
}
package com.example.day07broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DynamicBReceiver dynamicBReceiver;
    NetReceiver netReceiver;

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

        // 2.1 接收系统提供的广播服务(不同App之间的广播)
        netReceiver = new NetReceiver();
        IntentFilter filter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(netReceiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 1.2 取消动态注册广播接收器
        unregisterReceiver(dynamicBReceiver);

        // 2.2 取消注册广播 停止接收系统发出的数据
        unregisterReceiver(netReceiver);
    }
}
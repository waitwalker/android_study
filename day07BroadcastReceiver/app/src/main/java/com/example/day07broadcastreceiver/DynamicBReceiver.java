package com.example.day07broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

class DynamicBReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            String string = intent.getStringExtra("name");
            if (string != null && string.length() > 0) {
                Toast.makeText(context,"接收到广播发送者发送来的数据:" + string, Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Log.d("1","广播接收器接收数据错误:" + e.getLocalizedMessage());
        }
    }
}

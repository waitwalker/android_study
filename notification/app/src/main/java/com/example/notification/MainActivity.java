package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnClickListener {

    /**
     * 通知基于安卓8.0以上
     *
     * */

    // views
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    // Notification
    private String kChannelID_1 = "Channel_ID_1";
    private String kChannelName_1 = "通知频道1";
    private String kChannelID_2 = "Channel_ID_2";
    private String kChannelName_2 = "通知频道2";

    // 通知ID
    private int commonNotificationID = 0x11;


    private Notification commonNotification;
    private NotificationManagerCompat commonManagerCompat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        commonNotification();
    }

    ///
    /// @name initView
    /// @description 初始化view
    /// @author liuca
    /// @date 2020/8/18
    ///
    private void initView() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    ///
    /// @name onClick
    /// @description 处理事件
    /// @author liuca
    /// @date 2020/8/18
    ///
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                sendCommonNotification();
                break;
            case R.id.button2:
                cancelCommonNotification();
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
        }
    }

    ///
    /// @name commonNotification
    /// @description 普通样式封装
    /// @author liuca
    /// @date 2020/8/18
    ///
    private void commonNotification() {

        // 1. 通过NotificationManager 创建channelID
        NotificationManager manager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel(kChannelID_1, kChannelName_1, NotificationManager.IMPORTANCE_HIGH);
        channel.setAllowBubbles(true);
        if (manager != null) {
            manager.createNotificationChannel(channel);
        }

        // 2. 设置点击事件
        Intent resultIntent = new Intent(this, MainActivity.class);
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        resultIntent.putExtra("name","张三");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        // 3. 设置Notification的各种属性并显示
        commonNotification = new NotificationCompat.Builder(this.getApplicationContext(), kChannelID_1)
                .setSound(Settings.System.DEFAULT_ALARM_ALERT_URI)
                .setSmallIcon(R.mipmap.ic_launcher_round)//设置通知图标
                .setTicker("有新的消息!!!!!")//设置通知栏的标题
                .setContentTitle("这个是标题")//设置标题
                .setContentText("这个是内容")//设置内容
                .setDefaults(NotificationCompat.DEFAULT_ALL)//设置默认提示音
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)//设置通知的优先级
                .setOngoing(false)//让通知左右滑的时候不能取消
                .setWhen(System.currentTimeMillis())//设置通知时间,默认为系统发出的通知的时间,通常不用设置
                .setAutoCancel(false)//打开程序后图标是否消失
                .setContentIntent(pendingIntent) //设置pending intent
                .build();
        commonManagerCompat = NotificationManagerCompat.from(this);
    }

    ///
    /// @name sendCommonNotification
    /// @description 发送普通样式的通知
    /// @author liuca
    /// @date 2020/8/18
    ///
    private void sendCommonNotification() {
        commonManagerCompat.notify(commonNotificationID, commonNotification);
    }

    ///
    /// @name cancelCommonNotification
    /// @description 取消普通样式消息
    /// @author liuca
    /// @date 2020/8/18
    ///
    private void cancelCommonNotification() {
        commonManagerCompat.cancel(commonNotificationID);
    }

}
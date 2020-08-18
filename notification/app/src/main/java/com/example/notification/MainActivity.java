package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
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
                break;
            case R.id.button2:
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
        }
    }

    private void commonNotification() {

    }

}
package com.example.day06popupwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        initPopWindow(v);
    }

    private void initPopWindow(View v) {
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_popup_layout, null, false);
        Button button1 = view.findViewById(R.id.button_1);
        Button button2 = view.findViewById(R.id.button_2);

        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        popupWindow.showAsDropDown(v,50,50);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击了Button1", Toast.LENGTH_LONG).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击了Button2", Toast.LENGTH_LONG).show();
            }
        });

    }
}
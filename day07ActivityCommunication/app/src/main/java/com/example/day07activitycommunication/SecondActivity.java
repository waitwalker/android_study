package com.example.day07activitycommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

public class SecondActivity extends AppCompatActivity implements CompoundButton.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        if (intent != null) {
            try {
              String string = intent.getStringExtra("name");
                Log.d("1","传递过来的值:" + string);
            } catch (Exception e) {
                Log.d("1","异常" + e.getLocalizedMessage());
            }
        }

        Button button = findViewById(R.id.button3);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button3:
                Intent intent = new Intent();
                intent.putExtra("back","王二");
                setResult(123, intent);
                finish();
                break;
        }
    }
}
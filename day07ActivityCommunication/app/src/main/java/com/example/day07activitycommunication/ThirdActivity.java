package com.example.day07activitycommunication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

public class ThirdActivity extends AppCompatActivity implements CompoundButton.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        if (intent != null) {
            try {
                String string = intent.getStringExtra("name");
                Log.d("1","传递过来的值:" + string);
            } catch (Exception e) {
                Log.d("1","异常" + e.getLocalizedMessage());
            }
        }

        Button button = findViewById(R.id.button4);
        button.setOnClickListener(this);

        Button button2 = findViewById(R.id.button6);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button4:
                Intent intent = new Intent();
                intent.putExtra("back","王三");
                setResult(1234,intent);
                finish();
                break;
            case R.id.button6:
                Intent intent1 = new Intent(this, ThirdActivity.class);
                intent1.putExtra("name","ahh");
                startActivityForResult(intent1,12345);

        }
    }
}
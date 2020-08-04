package com.example.day07activitycommunication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button7);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this,SecondActivity.class);
                intent.putExtra("name","张三");
                //startActivity(intent);
                startActivityForResult(intent,123);
                break;
            case R.id.button2:
                Intent intent1 = new Intent("ThirdActivity");
                intent1.putExtra("name","张三丰");
                //startActivity(intent1);

                startActivityForResult(intent1,1234);
                break;
            case R.id.button7:
                Intent intent2 = new Intent(this,FourthActivity.class);
                startActivityForResult(intent2,456);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("1","requestCode:" + requestCode);
        Log.d("1","resultCode:" + resultCode);
        try {
            String string = data.getStringExtra("back");
            Log.d("1","返回值:"+ string);
        } catch (Exception e) {
            Log.d("1","ee"+ e.getLocalizedMessage());
        }
    }
}
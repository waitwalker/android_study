package com.example.day08sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.day08sqlite.database.MyDBOpenHelper;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnClickListener {

    Context context;
    MyDBOpenHelper myDBOpenHelper;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        myDBOpenHelper = new MyDBOpenHelper(context, "my.db", null, 2);

        Button button1 = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        database = myDBOpenHelper.getWritableDatabase();
        switch (v.getId()) {
            case R.id.button:
                // 插入
                ContentValues values = new ContentValues();
                values.put("name","张三丰");
                database.insert("person",null,values);
                Toast.makeText(getApplicationContext(),"插入数据完毕",Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
        }
    }
}
package com.example.day01;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 变量计算

        char char1 = 'h';
        int i = 0;
        while (i < 10) {
            i++;
            Log.d("12","结果:"+i);
        };

        do {
            i--;
        } while (i >5);
        Log.d("13","结果:"+i);

        byte by1 = 5;
        Log.d("2", "数据byte:"+by1);
        double result = Math.sqrt(200);
        Log.d("1","数学计算公式:"+result);


        LocalDateTime localDateTime = LocalDateTime.now();


        Log.d("1234","当前日期:"+ localDateTime.getYear());

        new Action(){
            @Override
            public void execute(String content) {
                Log.d("123","content:" + content);
            }
        };

        Person person = new Person("zhangsan",12);
        person.info();;

        Student student = new Student();

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    static interface Action {
        void execute(String content);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
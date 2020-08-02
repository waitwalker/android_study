package com.etiantian.day05gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.etiantian.day05gridview.adapter.GridViewAdapter;
import com.etiantian.day05gridview.entity.News;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context;
    GridViewAdapter adapter;
    GridView gridView;
    List<News> list = new  ArrayList<News>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        for (int i =0; i < 30; i++) {
            String string = String.valueOf(i);
            list.add(new News("标题" + string, "内容:" + string, "索引:" + string));
        }

        gridView = findViewById(R.id.grid_view);
        adapter = new GridViewAdapter(context, list);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "点击了:" + position, Toast.LENGTH_LONG).show();
            }
        });

    }
}
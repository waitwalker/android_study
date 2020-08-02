package com.etiantian.day05listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    NewsAdapter mAdapter = null;
    Context mContext;
    ListView listView;
    LinkedList<News> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        mContext = this;
        listView = findViewById(R.id.listview);
        mData = new LinkedList<News>();
        for (int i = 0; i < 20; i++) {
            mData.add(new News("新闻标题号:" + i, "新闻内容号:" + i));
        }

        mAdapter = new NewsAdapter(mData, mContext);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext,"点击了第" + position + "条数据", Toast.LENGTH_LONG).show();
            }
        });
    }
}
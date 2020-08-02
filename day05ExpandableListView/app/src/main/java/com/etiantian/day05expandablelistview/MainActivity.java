package com.etiantian.day05expandablelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.etiantian.day05expandablelistview.adapter.MExpandableListAdapter;
import com.etiantian.day05expandablelistview.entity.Group;
import com.etiantian.day05expandablelistview.entity.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Group> gData = new ArrayList<Group>();
    ArrayList<ArrayList<Item>> iData = new ArrayList<ArrayList<Item>>();
    Context context;
    ExpandableListView expandableListView;
    MExpandableListAdapter adapter;
    private ArrayList<Item> lData = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        expandableListView = findViewById(R.id.expand);
        //数据准备
        gData = new ArrayList<Group>();
        iData = new ArrayList<ArrayList<Item>>();
        gData.add(new Group("AD"));
        gData.add(new Group("AP"));
        gData.add(new Group("TANK"));

        lData = new ArrayList<Item>();

        //AD组
        lData.add(new Item(1, "剑圣"));
        lData.add(new Item(2, "德莱文"));
        lData.add(new Item(3, "男枪"));
        lData.add(new Item(4, "韦鲁斯"));
        iData.add(lData);
        //AP组
        lData = new ArrayList<Item>();
        lData.add(new Item(1, "提莫"));
        lData.add(new Item(2, "安妮"));
        lData.add(new Item(3, "天使"));
        lData.add(new Item(4, "泽拉斯"));
        lData.add(new Item(5, "狐狸"));
        iData.add(lData);
        //TANK组
        lData = new ArrayList<Item>();
        lData.add(new Item(1,"诺手"));
        lData.add(new Item(2, "德邦"));
        lData.add(new Item(3, "奥拉夫"));
        lData.add(new Item(4, "龙女"));
        lData.add(new Item(5, "狗熊"));
        iData.add(lData);

        adapter = new MExpandableListAdapter(context,gData,iData);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(context, "你点击了：" + iData.get(groupPosition).get(childPosition).getiName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }
}
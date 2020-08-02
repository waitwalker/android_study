package com.etiantian.day05listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.etiantian.day05listviewdemo.adapter.FruitAdapter;
import com.etiantian.day05listviewdemo.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 20; i ++) {
            fruitList.add(new Fruit("水果编号:" + i));
        }

        FruitAdapter adapter = new FruitAdapter(getApplicationContext(), R.layout.fruit_item_layout, fruitList);
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(getApplicationContext(), fruit.getName(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
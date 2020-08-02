package com.etiantian.day05spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.etiantian.day05spinner.adapter.SAdapter;
import com.etiantian.day05spinner.entity.RegionModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Context context;
    List<RegionModel> list = new ArrayList<RegionModel>();
    Spinner spinner;
    SpinnerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        for (int i = 0;i< 16; i++) {
            list.add(new RegionModel("当前行数:" + i));
        }
        spinner = findViewById(R.id.spinner);
        adapter = new SAdapter(context, list);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        RegionModel model = (RegionModel) parent.getItemAtPosition(position);
        Toast.makeText(getApplicationContext(),"选中的是:" + model.getTitle(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
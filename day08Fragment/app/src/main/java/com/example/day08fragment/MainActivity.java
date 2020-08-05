package com.example.day08fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFragment2 fragment2 = new MyFragment2();

        Bundle bundle = new Bundle();
        bundle.putString("name","张三");
        fragment2.setArguments(bundle);
        fragment2.setCalllBack(new MyFragment2.CallBack() {
            @Override
            public void getResult(String result) {
                Log.d("1","result:" + result);
            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.rl_fragment, fragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
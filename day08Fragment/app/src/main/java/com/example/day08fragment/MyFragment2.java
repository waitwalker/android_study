package com.example.day08fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.concurrent.Callable;

import javax.security.auth.callback.Callback;

public class MyFragment2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        assert getArguments() != null;
        String string = (String) getArguments().getString("name");

        Log.d("1","传个Fragment的数据:"+ string);
        return inflater.inflate(R.layout.fragment_layout2, container,false);
    }

    public void setCalllBack(CallBack calllBack) {
        calllBack.getResult("123");
    }

    public interface CallBack {
        void getResult(String result);
    }
}

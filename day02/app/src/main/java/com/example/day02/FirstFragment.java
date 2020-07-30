package com.example.day02;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

//        TextView textView = new TextView(view.getContext());
//        textView.setText("输入框");
//        LinearLayout linearLayout = new LinearLayout(view.getContext());
//        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
//        layoutParams.leftMargin = 50;
//        layoutParams.topMargin = 240;
//        layoutParams.weight = 200;
//        layoutParams.height = 60;
//        textView.setLayoutParams(layoutParams);
//        linearLayout.addView(textView);


        Button button = view.findViewById(R.id.push_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

            }
        });

        float w = button.getWidth();
        float h = button.getHeight();

        float left = button.getLeft();
        float top = button.getTop();

        Log.d("11","w:" + w);
        Log.d("11","h:" + h);
        Log.d("11","left:" + left);
        Log.d("11","top:" + top);


    }

}
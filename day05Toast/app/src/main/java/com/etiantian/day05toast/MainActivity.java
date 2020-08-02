package com.etiantian.day05toast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toast toast = Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        LinearLayout layout = (LinearLayout) toast.getView();
        TextView textView = layout.findViewById(android.R.id.message);
        textView.setTextColor(Color.BLUE);


        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.show();
            }
        });
    }
}
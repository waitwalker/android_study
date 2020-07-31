package com.example.day03checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    CheckBox apple;
    CheckBox banana;
    CheckBox orange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apple = findViewById(R.id.apple);
        banana = findViewById(R.id.banana);
        orange = findViewById(R.id.orange);

        apple.setOnCheckedChangeListener(this);
        banana.setOnCheckedChangeListener(this);
        orange.setOnCheckedChangeListener(this);

        Button button = findViewById(R.id.commit);
        button.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String str = buttonView.getText().toString();
        if (buttonView.isChecked()) {
            Toast.makeText(getApplicationContext(),"选择的是:" + str, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        String choose = "";
        if (apple.isChecked()) choose += apple.getText().toString() + "";
        if (banana.isChecked()) choose += banana.getText().toString() + "";
        if (orange.isChecked()) choose += orange.getText().toString() + "";
        Toast.makeText(getApplicationContext(),choose, Toast.LENGTH_LONG).show();
    }
}
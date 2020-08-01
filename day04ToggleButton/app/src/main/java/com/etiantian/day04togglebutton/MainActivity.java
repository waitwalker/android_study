package com.etiantian.day04togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    ToggleButton toggleButton;
    Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggle);
        aSwitch = findViewById(R.id.switch_button);

        toggleButton.setOnCheckedChangeListener(this);
        aSwitch.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.toggle:
                if (buttonView.isChecked()) {
                    Toast.makeText(getApplicationContext(),"打开声音", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"关闭声音", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.switch_button:
                if (buttonView.isChecked()) {
                    Toast.makeText(getApplicationContext(),"打开开关",Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),"关闭开关", Toast.LENGTH_LONG).show();
                }
                break;

        }
    }
}
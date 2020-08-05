package com.example.day08sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnClickListener {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        editText = findViewById(R.id.text_field);
        textView = findViewById(R.id.textView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                String string = editText.getText().toString().trim();
                SharedPreferences sharedPreferences = getSharedPreferences("shared", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",string);
                boolean isSaveSuccess = editor.commit();
                if (isSaveSuccess) {
                    Toast.makeText(getApplicationContext(),"存储数据成功",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.button2:
                SharedPreferences sharedPreferences1 = getSharedPreferences("shared", MODE_PRIVATE);
                String string1 = sharedPreferences1.getString("name", "无");
                textView.setText(string1);
                break;
        }
    }
}
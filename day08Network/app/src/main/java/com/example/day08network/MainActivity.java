package com.example.day08network;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnClickListener {

    private String url = "https://www.baidu.com/home/other/data/weatherInfo?city=%E6%AD%A6%E6%B1%89&indextype=manht&_req_seqid=0xfc7ab7ff0008878d&asyn=1&t=1588658358650&sid=1421_31125_21122_31426_31342_31270_31464_31228_30823_26350_31164";

    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.obj != null) {
                Log.d("1","message:" + msg.obj);
                Map map = (Map) msg.obj;
                textView.setText(map.get("response").toString());
            }
        }
    };

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        textView = findViewById(R.id.text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:

                break;
            case R.id.button2:
                get();
                break;
        }
    }

    private void get() {
        // 1创建client对象
        OkHttpClient client = new OkHttpClient.Builder().build();

        // 2创建request对象
        final Request request = new Request.Builder().url(url).get().build();

        // 3创建Call对象
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d("1","请求失败:"+ e.getLocalizedMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result = Objects.requireNonNull(response.body()).string();
                Log.d("1","result:"+ result);
                Message message = myHandler.obtainMessage();
                Map map = new HashMap();
                map.put("response", result);
                message.obj = map;
                myHandler.sendMessage(message);
                //textView.setText(result);
            }
        });
    }

    private void post() {
        // 1创建http client
        OkHttpClient client = new OkHttpClient.Builder().build();

        // 2创建请求参数
        Map map = new HashMap();
        map.put("name","张三女");
        map.put("password","1233");
        JSONObject jsonObject = new JSONObject(map);
        String json = jsonObject.toString();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),json);

        // 3创建Request对象
        Request request = new Request.Builder().url("1234").addHeader("contentType","application/json;charset=UTF-8").post(requestBody).build();

        // 4 创建Call回调对象
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }
        });
    }
}
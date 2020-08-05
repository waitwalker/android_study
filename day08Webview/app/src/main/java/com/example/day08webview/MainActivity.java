package com.example.day08webview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    int strokeColor = Color.parseColor("#2E3135");//边框颜色
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {

                Log.d("1","title:"+title);

                super.onReceivedTitle(view, title);
            }
        });

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                Log.d("1","url:" + request.getUrl());

                return true;
            }
        });

        WebSettings webSettings = webView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);//自适应屏幕
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);//缩放图标
        webSettings.setSupportZoom(true);//支持缩放
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://developer.android.google.cn/");

        GradientDrawable gradientDrawable = new GradientDrawable();
        //gradientDrawable.setColor(strokeColor);
        gradientDrawable.setCornerRadius(10);
        gradientDrawable.setStroke(10, strokeColor);
        TextView textView = findViewById(R.id.textView);
        textView.setBackground(gradientDrawable);

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
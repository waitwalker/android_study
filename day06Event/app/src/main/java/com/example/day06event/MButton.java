package com.example.day06event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

class MButton extends Button {
    public MButton(Context context) {
        super(context);
    }

    public MButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);
        Log.e("1234","MButton: =====onTouchEvent" + event.getAction());
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("1234","MButton: ====dispatchTouchEvent" + event.getAction());
        return super.dispatchTouchEvent(event);
    }
}

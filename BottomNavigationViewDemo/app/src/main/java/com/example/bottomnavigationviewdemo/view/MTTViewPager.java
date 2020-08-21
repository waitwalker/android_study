package com.example.bottomnavigationviewdemo.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class MTTViewPager extends ViewPager {
    public MTTViewPager(@NonNull Context context) {
        super(context);
    }

    public MTTViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        super.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void setCurrentItem(int item) {
        //去除滚动动画
        super.setCurrentItem(item, false);
    }
}

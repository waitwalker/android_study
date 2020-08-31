package com.example.bottomnavigationviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.bottomnavigationviewdemo.fragment.AudioFragment;
import com.example.bottomnavigationviewdemo.fragment.BlankFragment;
import com.example.bottomnavigationviewdemo.fragment.HomeFragment;
import com.example.bottomnavigationviewdemo.fragment.MineFragment;
import com.example.bottomnavigationviewdemo.fragment.VideoFragment;
import com.example.bottomnavigationviewdemo.view.MTTViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener{

    private BottomNavigationView mBottomNavigationView;
    private MTTViewPager mViewPager;

    private HomeFragment homeFragment;
    private AudioFragment audioFragment;
    private VideoFragment videoFragment;
    private MineFragment mineFragment;

    private List<Fragment> fragmentList;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();
        initEvent();
    }

    private void initView() {
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mViewPager = findViewById(R.id.viewpager);
    }

    private void initData() {
        homeFragment = HomeFragment.newInstance();
        audioFragment = AudioFragment.newInstance();
        videoFragment = VideoFragment.newInstance();
        mineFragment = MineFragment.newInstance();
        fragmentList = new LinkedList<Fragment>();
        fragmentList.add(homeFragment);
        fragmentList.add(audioFragment);
        fragmentList.add(videoFragment);
        fragmentList.add(mineFragment);
    }

    private void initAdapter() {
        pagerAdapter = new HomePageFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
    }

    private void initEvent() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int itemId = 0;

        //mViewPager.setCurrentItem(itemId);
        switch (item.getItemId()) {
            case R.id.icon_home:
                itemId = 0;
                break;
            case R.id.icon_audio:
                itemId = 1;
                break;
            case R.id.icon_video:
                itemId = 2;
                break;
            case R.id.icon_mine:
                itemId = 3;
                break;
        }
        mViewPager.setCurrentItem(itemId);
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        Log.d("1","123");
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.d("1","123");
    }

    // bottom navigation view
    @Override
    public void onPageSelected(int position) {
        Log.d("1","123");
        mBottomNavigationView.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.d("1","123");
    }

    private class HomePageFragmentAdapter extends FragmentPagerAdapter {

        public HomePageFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public HomePageFragmentAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
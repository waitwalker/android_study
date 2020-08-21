package com.example.bottomnavigationviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.bottomnavigationviewdemo.fragment.AudioFragment;
import com.example.bottomnavigationviewdemo.fragment.BlankFragment;
import com.example.bottomnavigationviewdemo.fragment.HomeFragment;
import com.example.bottomnavigationviewdemo.fragment.MineFragment;
import com.example.bottomnavigationviewdemo.fragment.VideoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;
    private ViewPager mViewPager;

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
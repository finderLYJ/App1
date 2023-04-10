package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.app1.fragment.Fragment1;
import com.example.app1.fragment.Fragment2;
import com.example.app1.fragment.Fragment3;
import com.example.app1.fragment.Fragment4;
import com.example.app1.utils.myAddTab;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> titles;
    private List<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        mTabLayout=findViewById(R.id.tablayout);
        mViewPager=findViewById(R.id.vp);

        titles=new ArrayList<>();
        titles.add("兴趣培养");//手语舞，手语操
        titles.add("素质教育");
        titles.add("口手标音");
        titles.add("标准手语");

        fragments=new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        myAddTab.addTab(mTabLayout, mViewPager, fragments, titles, getSupportFragmentManager());
    }
}
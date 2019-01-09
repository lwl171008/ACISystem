package com.example.sion.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.sion.myapplication.Adapter.TabFragmentPageAdapter;
import com.example.sion.myapplication.Fragments.Fragment01;
import com.example.sion.myapplication.Fragments.Fragment02;
import com.example.sion.myapplication.Fragments.Fragment03;
import com.example.sion.myapplication.Fragments.Fragment04;
import com.qmuiteam.qmui.layout.QMUIButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ViewPager MyViewPage;
    private List<Fragment> fragments;
    private TabFragmentPageAdapter Tabadapter;
    private QMUIButton Home;
    private QMUIButton Select;
    private QMUIButton MyAction;
    private ViewPager MyVp;
    private Toolbar MyToolbar;
    private AppBarLayout AppBar;
    private String name;
    private QMUIButton Admin;
    private NestedScrollView nestedScrollView;
    private int body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        body = intent.getIntExtra("Body", 0);
        initView();

        Log.i("MyName", name+body);

    }


    private void initView() {

        MyViewPage = findViewById(R.id.MyViewPage);
        fragments = new ArrayList<>();
        fragments.add(new Fragment01(name));
        fragments.add(new Fragment02(name));
        fragments.add(new Fragment03(name));
        fragments.add(new Fragment04(body));
        Tabadapter = new TabFragmentPageAdapter(getSupportFragmentManager(), fragments);
        MyViewPage.setAdapter(Tabadapter);
        MyViewPage.setCurrentItem(0);

        Home = (QMUIButton) findViewById(R.id.Home);
        Home.setOnClickListener(this);
        Select = (QMUIButton) findViewById(R.id.Select);
        Select.setOnClickListener(this);
        MyAction = (QMUIButton) findViewById(R.id.MyAction);
        MyAction.setOnClickListener(this);
        SetViewPage(MyViewPage);
        MyVp = (ViewPager) findViewById(R.id.MyVp);
        MyVp.setOnClickListener(this);
        MyToolbar = (Toolbar) findViewById(R.id.MyToolbar);
        MyToolbar.setOnClickListener(this);
        AppBar = (AppBarLayout) findViewById(R.id.AppBar);
        AppBar.setOnClickListener(this);
        Admin = (QMUIButton) findViewById(R.id.Admin);
        Admin.setOnClickListener(this);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        nestedScrollView.setOnClickListener(this);
    }

    public void SetViewPage(ViewPager myViewPage) {
        MyViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                Log.i("2222", "onPageScrollStateChanged: " + i);
            }

            @Override
            public void onPageSelected(int i) {
                ((NestedScrollView) findViewById(R.id.nestedScrollView)).scrollTo(0, 0);
                Log.i("0000", "onPageSelected: " + i);
                ChangeText(i);


            }

            @Override
            public void onPageScrollStateChanged(int i) {
                Log.i("1111", "onPageScrollStateChanged: " + i);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Home:
                ChangeText(0);
                MyViewPage.setCurrentItem(0);
                break;
            case R.id.Select:
                ChangeText(1);
                MyViewPage.setCurrentItem(1);
                break;
            case R.id.MyAction:
                ChangeText(2);
                MyViewPage.setCurrentItem(2);
                break;
            case R.id.Admin:
                ChangeText(3);
                MyViewPage.setCurrentItem(3);
                break;
        }
    }

    public void ChangeText(int id) {
        if (id == 0) {
            Home.setTextColor(Color.RED);
            Select.setTextColor(Color.WHITE);
            MyAction.setTextColor(Color.WHITE);
            Admin.setTextColor(Color.WHITE);

        }
        if (id == 1) {
            Select.setTextColor(Color.RED);
            Home.setTextColor(Color.WHITE);
            MyAction.setTextColor(Color.WHITE);
            Admin.setTextColor(Color.WHITE);
        }
        if (id == 2) {
            MyAction.setTextColor(Color.RED);
            Select.setTextColor(Color.WHITE);
            Home.setTextColor(Color.WHITE);
            Admin.setTextColor(Color.WHITE);
        }
        if (id == 3) {
            Admin.setTextColor(Color.RED);
            MyAction.setTextColor(Color.WHITE);
            Select.setTextColor(Color.WHITE);
            Home.setTextColor(Color.WHITE);
        }
    }
}

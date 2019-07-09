package com.bawei.mvpdeom1.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 *@Auther:Lenovo
 *@Date: 2019/7/8
 *@Time: 20:28:13
 *@Description:
 * */public abstract class BeasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initView();
        initData();
    }
    abstract int getContentView();
    abstract void initView();
    abstract void initData();
    abstract void intEnvod();

}

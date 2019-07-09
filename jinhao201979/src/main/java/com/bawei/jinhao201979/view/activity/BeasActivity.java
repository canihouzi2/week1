package com.bawei.jinhao201979.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/*
 *@Auther:Lenovo
 *@Date: 2019/7/9
 *@Time: 09:13:55
 *@Description:
 * */public abstract class BeasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(intLayout());
        intView();
        intData();
    }
    protected abstract int intLayout();
    abstract void intView();
    abstract void intData();
    abstract void intEvid();
}

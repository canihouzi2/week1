package com.bawei.mvpdeom1.model.http;

import android.util.Log;

import com.bawei.mvpdeom1.model.contrant.IHomContrant;

/*
 *@Auther:Lenovo
 *@Date: 2019/7/8
 *@Time: 16:34:58
 *@Description:
 * */public class IadDadar implements IHomContrant {
    @Override
    public void ok(String str) {
        Log.i("sss","s="+str);
    }

    @Override
    public void error(int cor, String sbzy) {

    }
}

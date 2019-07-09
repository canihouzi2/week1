package com.bawei.mvpdeom1.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.mvpdeom1.Constant;
import com.bawei.mvpdeom1.model.contrant.IHomContrant;
import com.bawei.mvpdeom1.model.http.HttpUtils;
import com.bawei.mvpdeom1.view.activity.MainActivity;

/*
 *@Auther:Lenovo
 *@Date: 2019/7/8
 *@Time: 10:53:29
 *@Description:
 * */public class HomePrenter {
   private HttpUtils utils;


     public IHomContrant mcontrant;

     public HomePrenter(){
         utils=HttpUtils.getUitls();
     }
     public  void  attachView(IHomContrant iHomContrant){
       this.mcontrant=iHomContrant;
     }


    public void lodaServise() {
        utils.getstAsynTack(Constant.BASE_URL, new HttpUtils.getstBack() {
            @Override
            public void getData(String s) {
                mcontrant.ok(s);
            }
        });
    }

    public void dettachView() {
         this.mcontrant=null;
    }
}

package com.bawei.jinhao201979.prenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bawei.jinhao201979.Contrt;
import com.bawei.jinhao201979.modl.cont.IHompde;
import com.bawei.jinhao201979.modl.http.HttpUitls;
import com.bawei.jinhao201979.view.activity.MainActivity;

/*
 *@Auther:Lenovo
 *@Date: 2019/7/9
 *@Time: 09:24:13
 *@Description:
 * */public class HomePrent{
    private IHompde miHompde;
    private HttpUitls uitls;

    public HomePrent(){
        uitls=HttpUitls.getUitls();
    }
    public void attachView(IHompde iHompde) {
        this.miHompde=iHompde;
    }

    public void loadetecds() {
        uitls.AsynstTack(Contrt.BASE_URL, new HttpUitls.getstBack() {
            @Override
            public void getData(String s) {
                miHompde.ok(s);
            }
        });
    }

    public void dettachView() {
        this.miHompde=null;
    }
}

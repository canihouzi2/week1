package com.bawei.jinhao201979.view.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.ScrollView;

import com.bawei.jinhao201979.Contrt;
import com.bawei.jinhao201979.Mylistview;
import com.bawei.jinhao201979.R;
import com.bawei.jinhao201979.modl.bean.ShopBean;
import com.bawei.jinhao201979.modl.cont.IHompde;
import com.bawei.jinhao201979.modl.http.HttpUitls;
import com.bawei.jinhao201979.prenter.HomePrent;
import com.bawei.jinhao201979.view.adapter.LiAdapter;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BeasActivity implements IHompde {
     private String str="http://172.17.8.100/small/commodity/v1/findCommodityListByLabel?labelId=1003&count=10&page=";
     private int page=1;
     private HttpUitls uitls;
     private PullToRefreshScrollView pull1;
     public Mylistview mylistview;
    private List<ShopBean.ResultBean> result=new ArrayList<>();
    private LiAdapter adapter;
    private HomePrent homePrent;

    @Override
    protected int intLayout() {
        return R.layout.activity_main;
    }

    @Override
    void intView() {
         pull1=findViewById(R.id.pull);

         mylistview=findViewById(R.id.liu);
    }

    @Override
    void intData() {
        homePrent = new HomePrent();
        homePrent.attachView(this);
        homePrent.loadetecds();
        pull1.setMode(PullToRefreshScrollView.Mode.BOTH);
        uitls = HttpUitls.getUitls();
        getDataf();

    }
    private void getDataf() {

        uitls.AsynstTack(str+page, new HttpUitls.getstBack() {
            @Override
            public void getData(String s) {
                Gson gson=new Gson();
                ShopBean bean = gson.fromJson(s, ShopBean.class);
                List<ShopBean.ResultBean> lisdt = bean.result;
                result.addAll(lisdt);

                if (true){
                    adapter = new LiAdapter(result,MainActivity.this);
                    mylistview.setAdapter(adapter);
                }

                adapter.notifyDataSetChanged();
                pull1.onRefreshComplete();
            }
        });
    }

    @Override
    void intEvid() {
        pull1.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                result.clear();
                page=1;
                getDataf();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                page++;
                getDataf();
            }
        });
    }



    @Override
    public void ok(String str) {
       Log.i("sss","s="+str);
    }

    @Override
    public void error(int cor, String sbzy) {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePrent.dettachView();
    }
}

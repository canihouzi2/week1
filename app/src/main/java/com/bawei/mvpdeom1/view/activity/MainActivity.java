package com.bawei.mvpdeom1.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.bawei.mvpdeom1.Constant;
import com.bawei.mvpdeom1.Mylistview;
import com.bawei.mvpdeom1.R;
import com.bawei.mvpdeom1.model.bean.ShopBean;
import com.bawei.mvpdeom1.model.contrant.IHomContrant;
import com.bawei.mvpdeom1.model.http.HttpUtils;
import com.bawei.mvpdeom1.presenter.HomePrenter;
import com.bawei.mvpdeom1.view.adapter.LisrAdapter;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BeasActivity implements IHomContrant {
    private HomePrenter homePrenter;
    private Mylistview mylistview;
    private LisrAdapter adapter;
    private PullToRefreshScrollView pull;
    private int page=1;
    private List<ShopBean.DataBean.NewsBean> news=new ArrayList<>();

    @Override
    int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    void initView() {
        mylistview=findViewById(R.id.lui);
        pull=findViewById(R.id.pull);
    }

    @Override
    void initData() {
        homePrenter=new HomePrenter();
        homePrenter.attachView(this);
        homePrenter.lodaServise();
    }

    @Override
    void intEnvod() {

    }


    @Override
    public void ok(final String str) {
        pull.setMode(PullToRefreshScrollView.Mode.BOTH);
        adapter = new LisrAdapter(news,MainActivity.this);
        mylistview.setAdapter(adapter);
        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                news.clear();
                page=1;
                getDatean();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                page++;
               getDatean();
            }
            private void getDatean() {
                HttpUtils.getUitls().getstAsynTack(Constant.BASE_URL + page, new HttpUtils.getstBack() {
                    @Override
                    public void getData(String s) {
                        Gson gson=new Gson();
                        ShopBean bean = gson.fromJson(s, ShopBean.class);
                        List<ShopBean.DataBean.NewsBean> list = bean.data.news;
                        Log.i("sss",list+"");
                        news.addAll(list);
                        adapter.notifyDataSetChanged();
                        pull.onRefreshComplete();
                    }
                });
            }
        });
    }

    @Override
    public void error(int cor, String sbzy) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePrenter.dettachView();
    }
}

package com.bawei.mvpdeom1.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.mvpdeom1.R;
import com.bawei.mvpdeom1.model.bean.ShopBean;
import com.bumptech.glide.Glide;

import java.util.List;

/*
 *@Auther:Lenovo
 *@Date: 2019/7/8
 *@Time: 17:00:02
 *@Description:
 * */public class LisrAdapter extends BaseAdapter {
     private List<ShopBean.DataBean.NewsBean> news;
     private Context context;
    public LisrAdapter(List<ShopBean.DataBean.NewsBean> news, Context context) {
        this.news = news;
        this.context = context;
    }

    @Override
    public int getCount() {
        return news.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            convertView=View.inflate(context,R.layout.item,null);
            holder=new ViewHolder();
            holder.imageView=convertView.findViewById(R.id.item_iamg);
            holder.textView=convertView.findViewById(R.id.item_tete);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(news.get(position).title);
        Glide.with(context).load("http://blog.zhaoliang5156.cn/zixunnew/"+news.get(position).imageUrl).into(holder.imageView);
        return convertView;
    }
    static class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}

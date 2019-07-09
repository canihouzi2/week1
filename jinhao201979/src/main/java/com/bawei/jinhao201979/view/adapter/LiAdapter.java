package com.bawei.jinhao201979.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.jinhao201979.R;
import com.bawei.jinhao201979.modl.bean.ShopBean;
import com.bawei.jinhao201979.view.activity.BeasActivity;
import com.bumptech.glide.Glide;

import java.util.List;

/*
 *@Auther:Lenovo
 *@Date: 2019/7/9
 *@Time: 09:59:40
 *@Description:
 * */public class LiAdapter extends BaseAdapter {
    private List<ShopBean.ResultBean> result;
    private Context context;

    public LiAdapter(List<ShopBean.ResultBean> result, Context context) {
        this.result = result;
        this.context = context;
    }

    @Override
    public int getCount() {
        return result.size();
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
            holder.imageView=convertView.findViewById(R.id.item_iamev);
            holder.textView=convertView.findViewById(R.id.item_tete);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(result.get(position).commodityName);
        Glide.with(context).load(result.get(position).masterPic).into(holder.imageView);
        return convertView;
    }
    static class ViewHolder{
       ImageView imageView;
       TextView textView;
    }
}

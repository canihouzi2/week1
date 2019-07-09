package com.bawei.jinhao201979;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/*
 *@Auther:Lenovo
 *@Date: 2019/7/9
 *@Time: 10:21:01
 *@Description:
 * */public class Mylistview extends ListView {
    public Mylistview(Context context) {
        super(context);
    }

    public Mylistview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Mylistview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

package com.bawei.mvpdeom1.model.http;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 *@Auther:Lenovo
 *@Date: 2019/7/8
 *@Time: 15:26:53
 *@Description:
 * */public class HttpUtils {
     //单列模式
     //单列模式
     private HttpUtils(){}
    private static HttpUtils uitls;
    public static HttpUtils getUitls(){
        if (uitls==null){
            uitls=new HttpUtils();
        }
        return uitls;
    }
    //网络请求
    //网络请求数据
    public String getString(String strurl){
        HttpURLConnection connection=null;
        try {
            //将字符转换url
            URL url=new URL(strurl);
            //打开url
            connection = (HttpURLConnection) url.openConnection();
            //使用get请求
            connection.setRequestMethod("GET");
            //超时
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            //请求码
            int code = connection.getResponseCode();
            if (code==200){
                //获取文件
                InputStream stream = connection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
                //拼接字符串
                StringBuffer buffer=new StringBuffer();
                String str="";
                while ((str=reader.readLine())!=null){
                    buffer.append(str);
                }
                //关流
                stream.close();
                connection.disconnect();
                return buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void getstAsynTack(String strurl,final getstBack back){
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return getString(strings[0]);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                back.getData(s);
            }
        }.execute(strurl);
    }
    public interface getstBack{
        void getData(String s);
    }

}

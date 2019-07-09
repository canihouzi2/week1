package com.bawei.jinhao201979.modl.http;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 *@Auther:Lenovo
 *@Date: 2019/7/9
 *@Time: 09:12:40
 *@Description:
 * */public class HttpUitls {
     //单列模式
     private static HttpUitls uitls;
     private HttpUitls(){}
     public static HttpUitls getUitls(){
         if (uitls==null){
             return uitls=new HttpUitls();
         }
         return uitls;
     }
     //网络请求数据
    public String getString(String strurl){
        HttpURLConnection connection=null;
        try {
            URL url=new URL(strurl);
          connection = (HttpURLConnection) url.openConnection();
          connection.setRequestMethod("GET");
          connection.setConnectTimeout(5000);
          connection.setReadTimeout(5000);
            int code = connection.getResponseCode();
        if (code==200){
            InputStream stream = connection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer=new StringBuffer();
            String str="";
            while ((str=reader.readLine())!=null){
                buffer.append(str);
            }
            stream.close();
            connection.disconnect();
            return buffer.toString();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void AsynstTack(String strurl,final getstBack back){
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

package com.feicuiedu.retrofitdemo.demoOkHttpGet2;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 123 on 2016/11/7.
 */

public class NetClient implements UserApi{

    private static NetClient netClient;
    private final OkHttpClient okHttpClient;

    private NetClient(){

        okHttpClient = new OkHttpClient();
    }

    public static synchronized NetClient getInstance(){
        if (netClient==null){
            netClient = new NetClient();
        }
        return netClient;
    }

    @Override
    public Call getData(String url){
        // 构建请求
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        return okHttpClient.newCall(request);
    }
}

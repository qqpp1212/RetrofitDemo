package com.feicuiedu.retrofitdemo.demoOkHttpGet2;

import com.feicuiedu.retrofitdemo.demoOkHttpPost.User;
import com.feicuiedu.retrofitdemo.demoRetrofitGet.UserRetrofitApi;
import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by 123 on 2016/11/7.
 */

public class NetClient implements UserApi {

    private static NetClient netClient;
    private final OkHttpClient okHttpClient;

    private NetClient() {

        /**
         * Okhttp 提供了拦截器的功能，能将我们请求和响应的数据拦截下来，展示出来
         * 1. 添加依赖
         * 2. 使用：给OkHttpClient设置上
         */
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        /**
         * 1. 创建一个执行请求的类Retrofit
         * 2. 构建请求
         * 3. 执行请求
         * 4. 得到请求的数据
         */
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http:......")
//                .build();
//
//        UserRetrofitApi userRetrofitApi = retrofit.create(UserRetrofitApi.class);
//        // 执行的时候
//        userRetrofitApi.getData().enqueue();

    }

    public static synchronized NetClient getInstance() {
        if (netClient == null) {
            netClient = new NetClient();
        }
        return netClient;
    }

    @Override
    public Call getData(String url) {
        // 构建请求
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        return okHttpClient.newCall(request);
    }

    @Override
    public Call register(User user) {

        Gson gson = new Gson();

        RequestBody requestBody = RequestBody.create(null,gson.toJson(user));

        Request request = new Request.Builder()
                .post(requestBody)
                .url(UserApi.URL_REGISTER)
                .build();

        return okHttpClient.newCall(request);
    }
}

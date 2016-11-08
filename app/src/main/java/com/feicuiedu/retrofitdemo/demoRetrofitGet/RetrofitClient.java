package com.feicuiedu.retrofitdemo.demoRetrofitGet;

import com.feicuiedu.retrofitdemo.demoOkHttpPost.User;
import com.feicuiedu.retrofitdemo.demoRetrofitPost.UserResult;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

/**
 * Created by 123 on 2016/11/8.
 */

public class RetrofitClient implements UserRetrofitApi{

    private static RetrofitClient retrofitClient;
    private static final String BASE_URL = "http://admin.syfeicuiedu.com";
    private final UserRetrofitApi userRetrofitApi;

    private RetrofitClient() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                // 添加了Gson转换器
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userRetrofitApi = retrofit.create(UserRetrofitApi.class);

    }

    public static synchronized RetrofitClient getInstances() {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    @Override
    public Call<Result> getData() {
        return userRetrofitApi.getData();
    }

    @Override
    public Call<UserResult> register(@Body User user) {
        return userRetrofitApi.register(user);
    }
}

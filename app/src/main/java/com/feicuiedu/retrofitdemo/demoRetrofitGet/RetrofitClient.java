package com.feicuiedu.retrofitdemo.demoRetrofitGet;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

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
    public Call<ResponseBody> getData() {
        return userRetrofitApi.getData();
    }
}

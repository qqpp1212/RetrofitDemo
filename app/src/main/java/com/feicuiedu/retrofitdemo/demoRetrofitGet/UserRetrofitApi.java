package com.feicuiedu.retrofitdemo.demoRetrofitGet;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 123 on 2016/11/8.
 */

public interface UserRetrofitApi {

    // 在这个接口里面使用Retrofit来构建接口请求
    // 稍后会讲解注解这个内容

    /**
     * Request request = new Request.Builder()
     .get()
     .url(url)
     .build();
     */

    @GET("https://api.github.com/users/gqq")
    Call<ResponseBody> getData();

}

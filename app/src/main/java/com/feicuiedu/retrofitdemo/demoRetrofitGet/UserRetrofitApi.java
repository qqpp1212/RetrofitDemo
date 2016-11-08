package com.feicuiedu.retrofitdemo.demoRetrofitGet;

import com.feicuiedu.retrofitdemo.demoOkHttpPost.User;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by 123 on 2016/11/8.
 */

public interface UserRetrofitApi {

    // 在这个接口里面使用Retrofit来构建接口请求
    // 稍后会讲解注解这个内容

    @GET("https://api.github.com/users/gqq")
    Call<Result> getData();

    /**
     * 注解：
     * 消息的整体结构上会使用的注解：
     * 1. 消息的请求方式 : @GET,@POST
     * 2. 请求路径
     * 3. 请求头：@Headers({"Accept-Language:en","...","...","..."})添加请求头信息
     *           @Header("Accept-Lanuage")String lanuage 动态修改请求头信息
     * 4. 请求体：@Body String body
     *
     * url请求路径处理方面
     * 1. GET https://api.github.com/users/list?sort=desc&page=1&name=123
     *      方法的参数里面传入：@Query("sort")  @QueryMap Map<,> map
     *
     * 2. GET https://api.github.com/users/{id}/list，{id}可替换块，将他动态替换掉，形成一个完整的路径
     *        https://api.github.com/users/123/list
     *      方法参数里面传入：@Path("id")int id
     *
     * 3. GET https://api.github.com/users/{id}/list?sort=desc&page=1&name=123
     *
     * 4. 表单数据提交:name=....,age=...;@FormUrlEncoded,@Field("name")String name
     * 5. 多部分上传:@Multipart,@Part("photo")ResponseBody responseBody
     *
     *
     */
//    @GET
    /*@POST("url")
    @Headers({"Accept-Language:en","...","...","..."})
    Call<ResponseBody> getA(@Header("Accept-Lanuage")String lanuage, @Body User user);


    // 进行请求的时候，自动将网址拼接成https://api.github.com/users/list?sort=asc
    @GET("https://api.github.com/users/list")
    Call<ResponseBody> getB(
            @Query("sort")String desc,
            @Query("page")int page,
            @Query("name")String name,
            @QueryMap Map<String,String> map);

    @GET("https://api.github.com/users/{id}/list")
    Call<ResponseBody> getC(
            @Path("id")int id,
            @Query("sort") String sort,
            @Query("page") int page);

    @POST(".......")
    @FormUrlEncoded
    Call<ResponseBody> getD(
            @Field("name")String name,
            @Field("age")int age);

    @POST("")
    @Multipart
    Call<ResponseBody> getE(
            @Part("photo")ResponseBody responseBody,
            @Part("name")String name);*/

}

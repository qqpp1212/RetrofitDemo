package com.feicuiedu.retrofitdemo.demoOkHttpGet2;

import com.feicuiedu.retrofitdemo.demoOkHttpPost.User;

import okhttp3.Call;

/**
 * Created by 123 on 2016/11/7.
 */

public interface UserApi {

    String URL_REGISTER = "http://admin.syfeicuiedu.com/Handler/UserHandler.ashx?action=register";

    Call getData(String url);

    Call register(User user);

}

package com.feicuiedu.retrofitdemo.demoOkHttpGet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.feicuiedu.retrofitdemo.R;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpGetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_get);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_OkHttp_Get)
    public void onClick() {
        // 完成OkHttp的GET请求

        /**
         * 1. 请求操作类：OkHttpClient
         * 2. 构建请求
         * 3. 执行请求
         * 4. 得到响应之后，处理响应的数据
         */

        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .get()
                .url("https://api.github.com/users/gqq")
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {

            // 请求失败
            @Override
            public void onFailure(Call call, IOException e) {
                // 后台线程：不能做UI的操作
                Log.i("TAG","---请求失败"+e.getMessage());
            }
            // 响应成功
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 后台线程：不能做UI的操作
                Log.i("TAG","---响应成功");
            }
        });
    }
}

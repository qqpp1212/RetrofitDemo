package com.feicuiedu.retrofitdemo.demoOkHttpGet2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.feicuiedu.retrofitdemo.R;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OkHttpGet2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_get);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_OkHttp_Get)
    public void onClick() {

        // 去进行请求
        NetClient.getInstance().getData("https://api.github.com/users/gqq").enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("TAG", "--请求失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("TAG", "--响应成功");
            }
        });
    }
}

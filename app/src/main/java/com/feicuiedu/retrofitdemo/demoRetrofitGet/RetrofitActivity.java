package com.feicuiedu.retrofitdemo.demoRetrofitGet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.feicuiedu.retrofitdemo.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_get);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn_OkHttp_Get)
    public void onClick() {

        // 去执行请求
        RetrofitClient.getInstances().getData().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // Okhttp是后台线程，Retrofit是可以更新UI的
                Toast.makeText(RetrofitActivity.this, "--请求成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(RetrofitActivity.this, "--请求失败", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

package com.feicuiedu.retrofitdemo.demoOkHttpPost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.feicuiedu.retrofitdemo.R;
import com.feicuiedu.retrofitdemo.demoOkHttpGet2.NetClient;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OkHttpPostActivity extends AppCompatActivity {

    @BindView(R.id.et_Username)
    EditText etUsername;
    @BindView(R.id.et_Passrword)
    EditText etPassrword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_post);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_Register)
    public void onClick() {

        User user = new User(etUsername.getText().toString(),etPassrword.getText().toString());

        // 去进行网络请求
//        NetClient.getInstance().register(user).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.i("TAG","--请求失败");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.i("TAG","--响应成功");
//            }
//        });

        NetClient.getInstance().register(user).enqueue(new UICallback() {
            @Override
            public void onFailureInUI(Call call, IOException e) {
                Toast.makeText(OkHttpPostActivity.this, "--请求失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponseInUI(Call call, Response response) {
                Toast.makeText(OkHttpPostActivity.this, "--请求成功", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

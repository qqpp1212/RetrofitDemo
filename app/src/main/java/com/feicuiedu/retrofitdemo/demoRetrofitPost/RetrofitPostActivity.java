package com.feicuiedu.retrofitdemo.demoRetrofitPost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.feicuiedu.retrofitdemo.R;
import com.feicuiedu.retrofitdemo.demoOkHttpPost.User;
import com.feicuiedu.retrofitdemo.demoRetrofitGet.RetrofitClient;

import org.xmlpull.v1.XmlPullParser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitPostActivity extends AppCompatActivity {

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
        RetrofitClient.getInstances().register(user).enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call, Response<UserResult> response) {
                if (response.isSuccessful()){
                    
                    // 拿到数据之后进行处理
                    UserResult userResult = response.body();
                    if (userResult==null){
                        return;
                    }
                    Toast.makeText(RetrofitPostActivity.this, userResult.getErrmsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                    Toast.makeText(RetrofitPostActivity.this, "请求失败了"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}

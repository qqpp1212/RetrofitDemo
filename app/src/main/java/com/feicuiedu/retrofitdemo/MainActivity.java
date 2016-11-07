package com.feicuiedu.retrofitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.feicuiedu.retrofitdemo.demoOkHttpGet.OkHttpGetActivity;
import com.feicuiedu.retrofitdemo.demoOkHttpGet2.OkHttpGet2Activity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.listView)
    ListView listView;

    private Demo[] demos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        demos = createDemos();
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, demos));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(demos[position].intent);
    }

    private Demo[] createDemos(){
        return new Demo[]{
                new Demo("OkHttp的GET请求",new Intent(this,OkHttpGetActivity.class)),
                new Demo("OkHttp的GET请求(拆分)",new Intent(this, OkHttpGet2Activity.class))
        };
    }

    static class Demo {
        String name;
        Intent intent;

        private Demo(String name, Intent intent) {
            this.name = name;
            this.intent = intent;
        }

        public String toString() {
            return name;
        }
    }
}

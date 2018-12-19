package com.fanxin.android.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private List resList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);

        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        //设置数据源
        requestData();






    }

    private void requestData() {

        OkHttpClient mOkHttpClient = new OkHttpClient();
        String URL = "";
        Request.Builder requestBuild = new Request.Builder().url(URL);
        Request request = requestBuild.build();
        Call mcall = mOkHttpClient.newCall(request);
        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            //请求成功的回调函数
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String res = response.body().string();
                ImageData imageData = (ImageData) JsonUtil.fromJson(res, ImageData.class);
                List<ImageData.DataBean> data = imageData.getData();
                for (int i = 0; i < data.size(); i++) {
                    ImageData.DataBean dataBean = data.get(i);
                    String picBig = dataBean.getPicSmall();
                    resList.add(picBig);
                }

            }
        });


    }
}
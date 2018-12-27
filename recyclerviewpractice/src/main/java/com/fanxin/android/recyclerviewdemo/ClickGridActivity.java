package com.fanxin.android.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.fanxin.android.recyclerviewdemo.adapter.ImageClickAdapter;
import com.fanxin.android.recyclerviewdemo.utils.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ClickGridActivity extends AppCompatActivity {

    private static final String TAG = "ClickGridActivity-app";

    private List<String> resList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.id_recyclerView);

        //设置瀑布流的布局
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        //准备数据源
        requestData();

        //设置adapter
        ImageClickAdapter imageClickAdapter = new ImageClickAdapter(this,resList);
        recyclerView.setAdapter(imageClickAdapter);

        imageClickAdapter.setOnItemClickListener(new ImageClickAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int itemPosition) {
                Toast.makeText(ClickGridActivity.this,"点击项目： "+itemPosition,Toast.LENGTH_SHORT).show();
            }
        });


        imageClickAdapter.setOnItemLongClickListener(new ImageClickAdapter.OnItemLongClickListener() {
            @Override
            public void OnItemLongClick(int itemPosition) {
                Toast.makeText(ClickGridActivity.this,"长按项目： "+itemPosition,Toast.LENGTH_SHORT).show();
            }
        });






    }

    private void requestData() {

        OkHttpClient mOkHttpClient = new OkHttpClient();
        String URL = "https://www.imooc.com/api/teacher?type=2&page=1";
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
                    //在日志中输出获取到的图片地址
                    Log.d(TAG, "111 onResponse: "+picBig);

                    //取得小图的地址，添加到资源的集合中
                    resList.add(picBig);
                }
                System.out.println(" request Data: resList size is "+resList.size());

                //adapter.notifyDataSetChanged();

            }
        });

    }
}

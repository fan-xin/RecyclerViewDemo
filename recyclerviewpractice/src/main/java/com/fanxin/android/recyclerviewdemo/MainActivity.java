package com.fanxin.android.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.fanxin.android.recyclerviewdemo.adapter.MyAdapter;
import com.fanxin.android.recyclerviewdemo.adapter.NormalAdapter;
import com.fanxin.android.recyclerviewdemo.utils.JsonUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public List resList = new ArrayList();
    private static final String TAG = "MainActivity-app";
    //private MyAdapter adapter;
//    private NormalAdapter adapter;
    private MyAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);

        //设置布局管理器
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);

//        recyclerView.setLayoutManager(gridLayoutManager);

        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        //请求数据源
        requestData();

        try {
            //需要等待1.5才能解析完成
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main process resList size is "+resList.size());

//        输出图片地址
//        for (int i = 0; i < resList.size(); i++) {
//            System.out.println("hello "+resList.get(i));
//        }

        //设置适配器
        adapter = new MyAdapter(this,resList);
//        adapter = new NormalAdapter(resList);



        //adapter = new NormalAdapter(getData());
        //resList中装的是所有小图的链接
        recyclerView.setAdapter(adapter);

    }

    private List<String> getData() {
        List<String> data = new ArrayList<>();

        String temp = " item";
        for (int i = 0; i < 20; i++) {
            data.add(i+temp);
            System.out.println("get Data "+resList.toString());
//            data.add(resList.get(i).toString());
        }

        return data;

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

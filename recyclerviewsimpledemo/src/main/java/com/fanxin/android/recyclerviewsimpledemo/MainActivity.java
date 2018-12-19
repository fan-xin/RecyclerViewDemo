package com.fanxin.android.recyclerviewsimpledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定控件
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        //布局管理器
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        //设置adapter的数据源
        adapter = new NormalAdapter(getData());
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //设置adapter
        recyclerView.setAdapter(adapter);
    }

    //准备要显示的数据
    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<>();
        String temp = " item";
        for (int i = 0; i < 20; i++) {
            //将要显示的数据加入数据集
            data.add(i+temp);
        }

        return data;

    }
}

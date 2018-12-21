package com.fanxin.android.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.fanxin.android.recyclerviewdemo.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class StaggeredGridActivity extends AppCompatActivity {

    private List list;
    private List<Integer>resList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid);
        //初始化
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //设置layoutManager
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        //设置数据源
        initData();

        System.out.println("StaggeredGridActivity: resList is "+resList.size());

        ImageAdapter imageAdapter = new ImageAdapter(this,resList);

        recyclerView.setAdapter(imageAdapter);

    }

    private void initData() {
        for (int i = 0; i < 6; i++) {
            resList.add(R.drawable.flower1);
            resList.add(R.drawable.flower2);
            resList.add(R.drawable.flower3);

        }

    }
}

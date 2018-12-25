package com.fanxin.android.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.fanxin.android.recyclerviewdemo.adapter.SplitAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fan Xin <fanxin.hit@gmail.com>
 * 18/12/25  15:17
 */
public class SplitLineRecyActivity extends Activity {
    private List resList = new ArrayList();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.id_recyclerView);

        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //设置数据源
        initData();

        //设置适配器
        SplitAdapter splitAdapter = new SplitAdapter(this,resList);
        recyclerView.setAdapter(splitAdapter);

        //设置分割线
        RecycleViewDivider recycleViewDivider = new RecycleViewDivider(this, LinearLayoutManager.HORIZONTAL,R.drawable.splitline);
        recyclerView.addItemDecoration(recycleViewDivider);


    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            resList.add("Hello world: "+i);
        }
    }
}

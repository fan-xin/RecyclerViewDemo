package com.fanxin.android.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.fanxin.android.recyclerviewdemo.R;

import java.util.List;

/**
 * Created by Fan Xin <fanxin.hit@gmail.com>
 * 18/12/19  15:23
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MainViewHolder> {
    private List<String> list;//要显示的数据
    private Context context;//创建视图时需要

    private static final String TAG = "MyAdapter-app";

    //构造函数
    public MyAdapter(Context context, List<String> list){
        this.context = context;
        this.list = list;
        //notifyDataSetChanged();
    }



    /*
    * 创建视图
    * */
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //创建视图
        View view = LayoutInflater.from(context).inflate(R.layout.simple_item,viewGroup,false);
        //实例化MainviewHolder
        MainViewHolder holder = new MainViewHolder(view);

        return holder;
    }

    /*
     * 初始化控件
     * */
    public static class MainViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MainViewHolder(View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.id_imageView);
        }

    }

    /**
     * 为视图填充数据
     *
     * */
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MainViewHolder mainViewHolder, int i) {
        //获取图片地址
        String url = list.get(i);
        Log.d(TAG, "onBindViewHolder: "+url);

        //使用Glide框架获取图片
        Glide.with(context).load(url).into(mainViewHolder.imageView);
    }

    /**
     * 获取数据源的数量
     *
     * */
    public int getItemCount(){
        return list.size();
    }


}

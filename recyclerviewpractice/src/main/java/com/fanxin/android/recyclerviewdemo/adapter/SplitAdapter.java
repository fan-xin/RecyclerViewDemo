package com.fanxin.android.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Fan Xin <fanxin.hit@gmail.com>
 * 18/12/25  15:24
 */
public class SplitAdapter extends RecyclerView.Adapter<SplitAdapter.MainViewHolder> {
    private List<String> list;
    private Context context;

    public SplitAdapter(Context context, List<String> list){
        this.list = list;
        this.context = context;
    }

    //创建视图
    @NonNull
    @Override
    public SplitAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //创建视图
        //使用系统自带的布局simple_list_item_1
        View view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,viewGroup,false);

        //实例化ViewHolder
        MainViewHolder holder = new MainViewHolder(view);

        return holder;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{
        TextView textView;


        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            //初始化控件
            textView = (TextView)itemView.findViewById(android.R.id.text1);
        }
    }


    //填充数据
    @Override
    public void onBindViewHolder(@NonNull SplitAdapter.MainViewHolder mainView, int i) {

        mainView.textView.setText(list.get(i));

    }

    //获取item的个数
    @Override
    public int getItemCount() {
        return list.size();
    }
}

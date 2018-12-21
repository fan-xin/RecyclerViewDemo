package com.fanxin.android.recyclerviewsimpledemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Fan Xin <fanxin.hit@gmail.com>
 * 18/12/19  19:39
 */
public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.VH> {


    private static final String TAG = "NormalAdapter-app";

    //适配器要使用的数据集
    private ArrayList<String> mDatas;

    public static class VH extends RecyclerView.ViewHolder{
        //获取viewholder，并且设置view holder
        public final TextView title;
        public VH(View v){
            super(v);
            title = (TextView)v.findViewById(R.id.id_tv);
        }
    }

    //private List<String> mDatas;
    public NormalAdapter(ArrayList<String> data){
        this.mDatas = data;
        //notifyDataSetChanged();

    }

    public void updateData(ArrayList<String> data){
        this.mDatas = data;
        notifyDataSetChanged();
    }


    //实例化展示的View
    @NonNull
    @Override
    public NormalAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_1,viewGroup,false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NormalAdapter.VH vh, int i) {
        //绑定数据
        vh.title.setText(mDatas.get(i));
        final int temp = i;

        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onClick: 点击事件发生，"+"当前点击为"+temp);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

package com.fanxin.android.recyclerviewdemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fanxin.android.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fan Xin <fanxin.hit@gmail.com>
 * 18/12/19  19:39
 */
public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.VH> {

    private List<String> mDatas;

    public static class VH extends RecyclerView.ViewHolder{
        public final TextView title;
        public VH(View v){
            super(v);
            title = (TextView)v.findViewById(R.id.id_tv);
        }
    }

    //private List<String> mDatas;
    public NormalAdapter(List<String> data){
        this.mDatas = data;
        notifyDataSetChanged();

    }

//    public void updateData(ArrayList<String> data){
//        this.mDatas = data;
//        notifyDataSetChanged();
//    }



    @NonNull
    @Override
    public NormalAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.simple_item,viewGroup,false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NormalAdapter.VH vh, int i) {
        vh.title.setText(mDatas.get(i));
//        vh.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

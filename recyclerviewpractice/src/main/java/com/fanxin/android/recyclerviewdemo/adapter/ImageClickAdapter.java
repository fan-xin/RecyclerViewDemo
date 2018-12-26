package com.fanxin.android.recyclerviewdemo.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.fanxin.android.recyclerviewdemo.R;

import java.util.List;
import java.util.Random;

/**
 * Created by Fan Xin <fanxin.hit@gmail.com>
 * 18/12/26  17:10
 */
public class ImageClickAdapter extends RecyclerView.Adapter<ImageClickAdapter.MainViewHolder> {

    private Context context;
    private List<String> resList;

    public ImageClickAdapter(Context context, List<String> resList) {
        this.context = context;
        this.resList = resList;
    }

    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;



    //点击事件的接口
    public interface OnItemClickListener{
        public abstract void OnItemClick(int itemPosition);

    }

    //对外暴露点击事件的接口
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;

    }

    //对外暴露长按点击事件的接口
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener;

    }

    //长按事件的接口
    public interface OnItemLongClickListener{
        public abstract void OnItemLongClick(int itemPosition);
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MainViewHolder(View itemView){
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.id_imageView);

        }
    }


    @NonNull
    @Override
    public ImageClickAdapter onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        Glide.with(context).load(resList.get(i)).into(mainViewHolder.imageView);
        Random random = new Random();
        int height = random.nextInt(1000);
        mainViewHolder.imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,height));

        //添加点击事件
        


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

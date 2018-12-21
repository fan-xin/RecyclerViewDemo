package com.fanxin.android.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.fanxin.android.recyclerviewdemo.R;

import java.util.List;
import java.util.Random;

/**
 * Created by Fan Xin <fanxin.hit@gmail.com>
 * 18/12/21  17:16
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.MainViewHolder> {

    private Context context;
    private List<Integer> resList;

    public ImageAdapter(Context context, List<Integer> list){
        this.context = context;
        this.resList = list;
    }



    @NonNull
    @Override
    public ImageAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_item,viewGroup,false);
        MainViewHolder holder = new MainViewHolder(view);
        return holder;
    }

//    public static class MainViewHolder extends RecyclerView.ViewHolder {
//        ImageView imageView;
//        public MainViewHolder(@NonNull View itemView) {
//            super(itemView);
//            itemView = (ImageView)itemView.findViewById(R.id.mmimageView);
//
//        }
//    }

    public static class MainViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MainViewHolder(View itemView){
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.mmimageView);
        }

    }



    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.MainViewHolder mainViewHolder, int i) {

        if (mainViewHolder.imageView == null){
            System.out.println("image View is empty!!!");
        }
        System.out.println("i is "+i);

        System.out.println("resList is "+resList.get(i).toString());

        mainViewHolder.imageView.setBackgroundResource(resList.get(i));
        Random random = new Random();
        //高度按照随机数变化
        int height = random.nextInt(2000);
        mainViewHolder.imageView.setLayoutParams(
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height));
    }

    @Override
    public int getItemCount() {
        return resList.size();
    }


}

package com.example.admin.materialtest;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private Context mContext;
    private List<Fruit> mFruitList;
    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView fruitImage;
        TextView fruitName;
        public ViewHolder(View view) {super(view);
            cardView = (CardView) view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }
    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }
    @ Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        } View view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item,
                parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitName.setText(fruit.getName());
        //用Glide设置图片，
        // 这些水果图片像素都非常高，
        // 如果不进行压缩就直接展示的话， 很容易就会引起内存溢出。
        // 而使用Glide就完全不需要担心这回事
        // 因为Glide在内部做了许多非常复杂的逻辑操作， 其中就包括了图片压缩
        Glide.with(mContext).load(fruit.getImageId()).into(holder.fruitImage);
    }
    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
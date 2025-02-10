package com.example.momolog.ui.top.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.momolog.R;
import com.example.momolog.data.model.StoreInfo;

import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder> {

    private List<StoreInfo> storeInfoList;
    private CarouselAdapterListener listener;

    public interface CarouselAdapterListener {
        void onClickCarouselItem();
    }

    public CarouselAdapter(List<StoreInfo> storeInfoList){
        this.storeInfoList = storeInfoList;

    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.item_carousel, parent, false);
        return new CarouselViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselAdapter.CarouselViewHolder holder, int position) {
        StoreInfo storeInfo = storeInfoList.get(position);
        Context context = holder.itemView.getContext();
        int resId = context.getResources().getIdentifier(storeInfo.getImageName(), "drawable", context.getPackageName());
        Glide.with(context)
                .load(resId)
                .into(holder.imageView);
        holder.itemView.setOnClickListener(v -> {
            if(listener != null) {
                listener.onClickCarouselItem();
            }
        });

    }

    @Override
    public int getItemCount() {
        return storeInfoList.size();
    }

    public StoreInfo getStoreInfo(int position) {
        if(storeInfoList.size() > position) {
            return storeInfoList.get(position);
        }
        //取得出来なかった場合は空文字を返す。
        return null;
    }

    public void setStoreInfo(StoreInfo storeInfo, int position) {
        if(storeInfoList.size() > position) {
            storeInfoList.set(position, storeInfo);
        }else {
            storeInfoList.add(storeInfo);
        }
    }

    public void setListener(CarouselAdapterListener listener) {
        this.listener = listener;
    }

    static class CarouselViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public CarouselViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

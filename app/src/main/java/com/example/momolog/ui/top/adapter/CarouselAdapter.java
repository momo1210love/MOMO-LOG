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

import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder> {

    private List<String> imageUrls;
    private CarouselAdapterListener listener;

    public interface CarouselAdapterListener {
        void onClickCarouselItem();
    }

    public CarouselAdapter(List<String> imageUrls){
        this.imageUrls = imageUrls;

    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from((parent.getContext())).inflate(R.layout.item_carousel, parent, false);
        return new CarouselViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselAdapter.CarouselViewHolder holder, int position) {
        String imageName = imageUrls.get(position);
        Context context = holder.itemView.getContext();
        int resId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
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
        return imageUrls.size();
    }

    public String getImageUrl(int position) {
        if(imageUrls.size() > position) {
            return imageUrls.get(position);
        }
        //取得出来なかった場合は空文字を返す。
        return "";
    }

    public void setImageUrls(String imageUrl, int position) {
        if(imageUrls.size() > position) {
            imageUrls.set(position, imageUrl);
        }else {
            imageUrls.add(imageUrl);
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

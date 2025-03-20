package com.example.momolog.ui.top.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.momolog.R;
import com.example.momolog.data.Constants;
import com.example.momolog.data.model.Category;
import com.example.momolog.data.model.StoreInfo;
import com.example.momolog.ui.main.GridLayoutAdapter;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Category> dataList;
    private int cardWidth;
    private int cardHeight;

    // コンストラクタ
    public CategoryAdapter(List<Category> dataList, int cardWidth, int cardHeight) {
        this.dataList = dataList;
        this.cardWidth = cardWidth;
        this.cardHeight = cardHeight;
    }

    // ViewHolder（Adapter内で使用するデータをまとめるクラス）
    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imageView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            imageView = itemView.findViewById(R.id.image_view);

            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
            layoutParams.width = cardWidth;
            layoutParams.height = cardHeight;
            cardView.setLayoutParams(layoutParams);
        }
    }

    /**
     * ViewHolderを生成する処理
     * LayoutInflaterを使用してレイアウトファイルを読み込む
     * 生成されたViewを使用してViewHolderを生成する
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid_item, parent, false);
        return new CategoryAdapter.CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        Category category = dataList.get(position);
        String imageUrl = Constants.IMAGE_URL + category.getImageName();

        Glide.with(holder.itemView.getContext())
                .load(imageUrl)
                .into(holder.imageView);
    }

    /** リストに表示するアイテム数 */
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public Category getCategory(int position) {
        if(dataList.size() > position) {
            return dataList.get(position);
        }
        //取得出来なかった場合は空文字を返す。
        return null;
    }

    public void setCategory(Category category, int position) {
        if(dataList.size() > position) {
            dataList.set(position, category);
        }else {
            dataList.add(category);
        }
    }
}

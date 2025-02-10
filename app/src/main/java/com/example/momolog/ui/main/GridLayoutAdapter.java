package com.example.momolog.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.momolog.R;
import com.example.momolog.data.model.Category;

import java.util.List;

public class GridLayoutAdapter extends RecyclerView.Adapter<GridLayoutAdapter.ViewHolder>{

    private List<Category> dataList;
    private int cardWidth;
    private int cardHeight;

    // コンストラクタ
    public GridLayoutAdapter(List<Category> dataList, int cardWidth, int cardHeight) {
        this.dataList = dataList;
        this.cardWidth = cardWidth;
        this.cardHeight = cardHeight;
    }

    // ViewHolder（Adapter内で使用するデータをまとめるクラス）
    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * アイテム表示前の更新処理
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = dataList.get(position);
        holder.imageView.setImageResource(holder.itemView.getResources().getIdentifier(category.getImageName(), "drawable", holder.itemView.getContext().getPackageName()));
    }

    /** リストに表示するアイテム数 */
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}



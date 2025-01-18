package com.example.momolog.ui.top;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.momolog.R;
import com.example.momolog.date.model.Recommendation;
import com.example.momolog.ui.top.adapter.CarouselAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TopFragment extends Fragment {

    //ログ表示用タグ名
    private static final String TAG = TopFragment.class.getSimpleName();
    //カルーセル画面１ページあたりの表示時間
    private static final long DISPLAY_TIME = 3000L;

    private TopViewModel viewModel;
    private ViewPager2 viewPager;
    private CarouselAdapter carouselAdapter;
    private final List<View> pointerList = new ArrayList<>();
    private Runnable runnable;
    private int currentPage = 0;
    private final Handler handler = new Handler();

    public interface TopFragmentListener {
        void onClickCarouselItem();
    }

    public static Fragment newInstance() {
        return new TopFragment();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmant_top, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //ViewModelの設定
        settingViewModel();

        //ViewPagerの取得
        viewPager = view.findViewById(R.id.view_pager);

        //カルーセルポイントView
        pointerList.add(view.findViewById(R.id.pointer_first));
        pointerList.add(view.findViewById(R.id.pointer_second));
        pointerList.add(view.findViewById(R.id.pointer_third));

        // カルーセル用Adapterの生成とViewPagerへの設定
        carouselSettings(position -> {
            clearPointer();
            pointerList.get(position).setBackgroundResource(R.drawable.cicle_on_shape);
        });
    }

    //ViewModeの設定
    private void settingViewModel(){
        viewModel = new ViewModelProvider(this).get(TopViewModel.class);
        // LiveDateの監視設定
        viewModel.getRecommendationList().observe(requireActivity(), new Observer<List<Recommendation>>(){
            @Override
            public void onChanged(List<Recommendation> recommendations){
                //　おすすめ情報をUIに反映する処理
                for (int i = 0; i < recommendations.size(); i++) {
                    String imageUrl = carouselAdapter.getImageUrl(i);
                    if (!imageUrl.equals(recommendations.get(i).getPath())) {
                        carouselAdapter.setImageUrls(recommendations.get(i).getPath(), i);
                        carouselAdapter.notifyItemChanged(i);
                    }
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        // おすすめ情報の取得
        viewModel.loadRecommendationList();

        // 自動スクロール処理
        startAutoScroll();
    }

    private void clearPointer() {
        for (View pointer : pointerList) {
            pointer.setBackgroundResource(R.drawable.cicle_off_shape);
        }
    }

    /**
     *
     * 自動スクロール処理
     */
    private void startAutoScroll() {
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.removeCallbacks(this);
                if (viewPager.getAdapter() != null && currentPage >= viewPager.getAdapter().getItemCount()) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
                handler.postDelayed(this, DISPLAY_TIME);
            }
        };
        currentPage++;
        handler.postDelayed(runnable, DISPLAY_TIME);

    }
    //カルーセル設定
    private void carouselSettings(Consumer<Integer> consumer) {
        if (viewPager == null) {
            Log.w(TAG, "viewPager is null.");
            return;
        }
        carouselAdapter = new CarouselAdapter(new ArrayList<>());
        carouselAdapter.setListener(() -> {
            // TODO: TAP処理未実装

        });
        viewPager.setAdapter(carouselAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                consumer.accept(position);
            }
        });
    }
}

package com.example.momolog.ui.top;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.momolog.data.model.Category;
import com.example.momolog.data.model.StoreInfo;
import com.example.momolog.data.repository.CategoryRepository;
import com.example.momolog.data.repository.StoreInfoRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopViewModel extends ViewModel {

    // ログ表示用タグ名
    private static final String TAG = TopViewModel.class.getSimpleName();
    // カテゴリー情報リポジトリー
    private final CategoryRepository categoryRepository;
    // 店舗情報リポジトリー
    private final StoreInfoRepository storeInfoRepository;
    // カテゴリー情報リスト
    private final MutableLiveData<List<Category>> categoryList = new MutableLiveData<>(new ArrayList<>());
    // 店舗情報リスト
    private final MutableLiveData<List<StoreInfo>> storeInfoList = new MutableLiveData<>(new ArrayList<>());

    public TopViewModel() {
        categoryRepository = new CategoryRepository();
        storeInfoRepository = new StoreInfoRepository();
    }

    public LiveData<List<Category>> getCategoryList() {
        return categoryList;
    }

    public LiveData<List<StoreInfo>> getStoreInfoList() {
        return storeInfoList;
    }
    public void loadCategoryList() {
        if (categoryRepository == null){
            Log.e("error", "categoryRepository is null");
            return;
        }

        categoryRepository.getCategoryListAll(new CategoryRepository.CategoryRepositoryCallback() {
            @Override
            public void onSuccess(List<Category> categoryList) {
                // 成功した場合
                Log.d(TAG, "onSuccess: ");
                TopViewModel.this.categoryList.setValue(categoryList);
            }

            @Override
            public void onError(String error) {
                Log.e("error", error);
            }
        });
    }
    /**
     * おすすめ情報リストをロードする
     */
    public void loadRecommendationList() {
        if (storeInfoRepository == null) {
            Log.e("error", "storeInfoRepository is null");
            return;
        }

        storeInfoRepository.getStoreInfoListAll(new StoreInfoRepository.StoreInfoRepositoryCallback() {
            @Override
            public void onSuccess(List<StoreInfo> storeInfoList) {
                // 成功した場合
                Log.d(TAG, "onSuccess: ");
                List<StoreInfo> carouselList = Arrays.asList(storeInfoList.get(0), storeInfoList.get(1), storeInfoList.get(2));
                TopViewModel.this.storeInfoList.setValue(carouselList);
            }

            @Override
            public void onError(String error) {
                Log.e("Error", error);
            }
        });
    }
}

package com.example.momolog.ui.top;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.momolog.date.model.Recommendation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopViewModel extends ViewModel {

    //おすすめ情報リスト
    private final MutableLiveData<List<Recommendation>> recommendationList = new MutableLiveData<>(new ArrayList<>());

    public TopViewModel(){}

    public LiveData<List<Recommendation>> getRecommendationList() {
        return recommendationList;
    }

    /**
     * おすすめ情報リストをロードする
     */
    public void loadRecommendationList() {
        //TODO: Web APIでおすすめ情報を取得する
        List<Recommendation> data = Arrays.asList(
            new Recommendation("uni2"),
            new Recommendation("uni3"),
            new Recommendation("uni5")
        );
        recommendationList.setValue(data);
    }
}

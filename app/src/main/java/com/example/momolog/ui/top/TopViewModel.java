package com.example.momolog.ui.top;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.momolog.data.model.StoreInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopViewModel extends ViewModel {

    //おすすめ情報リスト
    private final MutableLiveData<List<StoreInfo>> storeInfoList = new MutableLiveData<>(new ArrayList<>());

    public TopViewModel(){}

    public LiveData<List<StoreInfo>> getStoreInfoList() {
        return storeInfoList;
    }

    /**
     * おすすめ情報リストをロードする
     */
    public void loadRecommendationList() {
        //TODO: Web APIでおすすめ情報を取得する
        List<StoreInfo> data = Arrays.asList(
            new StoreInfo(1, "uni1", "address1", "tel1", "openTime1", "holiday1", 1, "uni"),
            new StoreInfo(2, "uni2", "address2", "tel2", "openTime2", "holiday2", 1, "uni2"),
            new StoreInfo(3, "uni3", "address3", "tel3", "openTime3", "holiday3", 1, "uni3")
        );
        storeInfoList.setValue(data);
    }
}

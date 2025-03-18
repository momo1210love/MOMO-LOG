package com.example.momolog.data.api;

import com.example.momolog.data.model.Category;
import com.example.momolog.data.model.StoreInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    //カテゴリー一覧
    @GET("/api/v1/category/list")
    Call<List<Category>> getCategoryListAll();

    //店舗情報一覧
    @GET("/api/v1/storeinfo/list")
    Call<List<StoreInfo>> getStoreInfoListAll();
}

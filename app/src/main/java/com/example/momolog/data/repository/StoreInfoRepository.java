package com.example.momolog.data.repository;

import com.example.momolog.data.api.ApiService;
import com.example.momolog.data.api.RetrofitClient;
import com.example.momolog.data.model.StoreInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoreInfoRepository {

    private ApiService apiService;

    //  コンストラクタでApiServiceをインスタンス化
    public StoreInfoRepository() {
        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
    }

    public void getStoreInfoListAll(StoreInfoRepositoryCallback callback) {
        Call<List<StoreInfo>> call = apiService.getStoreInfoListAll();

        //非同期でRetrofitリクエストを実行
        call.enqueue(new Callback<List<StoreInfo>>() {
            @Override
            public void onResponse(Call<List<StoreInfo>> call, Response<List<StoreInfo>> response) {
                // 成功時にはデータを返す
                if (response.isSuccessful()){
                    callback.onSuccess(response.body());
                } else  {
                    callback.onError("response not success");
                }
            }

            @Override
            public void onFailure(Call<List<StoreInfo>> call, Throwable t) {
                //失敗時にはエラーメッセージを返す
                callback.onError("APIリクエストが失敗しました。" + t.getMessage());
            }
        });
    }

    public interface StoreInfoRepositoryCallback {
        void onSuccess(List<StoreInfo> storeInfoList);
        void onError(String error);
    }
}

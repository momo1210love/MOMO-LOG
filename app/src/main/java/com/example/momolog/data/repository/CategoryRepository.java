package com.example.momolog.data.repository;

import com.example.momolog.data.api.ApiService;
import com.example.momolog.data.api.RetrofitClient;
import com.example.momolog.data.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryRepository {

    private ApiService apiService;

    //  コンストラクタでApiServiceをインスタンス化
    public CategoryRepository() {
        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
    }

    public void getCategoryListAll(CategoryRepositoryCallback callback) {
        Call<List<Category>> call = apiService.getCategoryListAll();

        //非同期でRetrofitリクエストを実行
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                // 成功時にはデータを返す
                if (response.isSuccessful()){
                    callback.onSuccess(response.body());
                } else  {
                    callback.onError("response not success");
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                //失敗時にはエラーメッセージを返す
                callback.onError("APIリクエストが失敗しました。" + t.getMessage());
            }
        });
    }

    public interface CategoryRepositoryCallback {
        void onSuccess(List<Category> categoryList);
        void onError(String error);
    }
}

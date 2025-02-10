package com.example.momolog.data.repository;

import com.example.momolog.data.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GreetingRepository {

//    private ApiService apiService;
//
//    //  コンストラクタでApiServiceをインスタンス化
//    public GreetingRepository() {
//        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
//    }

//    public void getGreeting(GreetingRepositoryCallback callback) {
//        Call<Greeting> call = apiService.getGreeting();
//
//        //非同期でRetrofitリクエストを実行
//        call.enqueue(new Callback<Greeting>() {
//            @Override
//            public void onResponse(Call<Greeting> call, Response<Greeting> response) {
//                // 成功時にはデータを返す
//                if (response.isSuccessful()){
//                    callback.onSuccess(response.body());
//                } else  {
//                    callback.onError("response not success");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Greeting> call, Throwable t) {
//                //失敗時にはエラーメッセージを返す
//                callback.onError("APIリクエストが失敗しました。" + t.getMessage());
//            }
//        });
//    }
//
//    // リポジトリがデータ取得成功した時にコールバックで呼び出すインターフェース
//    public interface GreetingRepositoryCallback {
//        void onSuccess(Greeting greeting);
//        void onError(String error);
//    }
}


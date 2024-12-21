package com.example.momolog.ui.main;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.momolog.R;
import com.example.momolog.date.api.ApiService;
import com.example.momolog.date.api.RetrofitClient;
import com.example.momolog.date.model.Greeting;
import com.example.momolog.ui.top.TopFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Fragment fragment = TopFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, fragment)
                .commitNow();



//        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
//        Call<Greeting> call = apiService.getGreeting();
//
//        call.enqueue(new Callback<Greeting>() {
//
//
//            @Override
//            public void onResponse(Call<Greeting> call, Response<Greeting> response) {
//                if (response.isSuccessful() && response.body() != null){
//                    Greeting greeting = response.body();
//                    Log.d("MainActivity", "Greeting: " + greeting.getContent());
//                } else  {
//                    Log.e("mainActivity", "Response error: " + response.code());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Greeting> call, Throwable t) {
//                Log.e("MainActivity", "Network error: " + t.getMessage());
//            }
//        });
    }
}
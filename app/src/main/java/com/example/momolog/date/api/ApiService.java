package com.example.momolog.date.api;

import com.example.momolog.date.model.Greeting;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/greeting")
    Call<Greeting> getGreeting();
}

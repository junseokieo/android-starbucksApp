package com.cos.mystarbucks.service;


import com.cos.mystarbucks.model.Siren;
import com.cos.mystarbucks.util.Localhost;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface SirenService {
//http://192.168.0.50:8080/json.do
    @GET("/json.do")
    Call<Siren> repoContributors();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Localhost.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

package com.markswell.githubconector.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by markswell on 12/26/17.
 */

public class RetrofitUtils {
    public Retrofit obterRetrofit(String url) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
    }
}

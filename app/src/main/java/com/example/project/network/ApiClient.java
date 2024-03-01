package com.example.project.network;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
//    public static final String BASE_URL = "http://15.206.246.145/";
//    public static final String BASE_URL = "http://marryhelp.tranzsoftwaresolutions.com:8000/";
    public static final String BASE_URL = "https://iroidtechnologies.in/protienium/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory( GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static <S> S createService(Class<S> serviceClass, Context context) {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory( GsonConverterFactory.create())
                .build();

        return retrofit.create(serviceClass);
    }
}
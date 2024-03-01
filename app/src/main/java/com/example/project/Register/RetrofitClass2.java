package com.example.project.Register;

import android.app.Application;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass2 extends Application {

    public static final String BASE_URL = "http://iroidtechnologies.in/Fressery/Fressery_Api/";

    static OkHttpClient.Builder httpClient = null;
    private static Retrofit retrofit = null;


    public void onCreate() {
        super.onCreate();
    }

    private static OkHttpClient buildClient() {
        return new OkHttpClient
                .Builder()
                .build();
    }

    public static Retrofit getClient2() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(buildClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofit;
    }

}

package com.example.project;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class baseclass {
    private static Retrofit retrofit = null;
    public static endinterface getClient() {

        // change your base URL
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://iroidtechnologies.in/protienium/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        //Creating object for our interface
        endinterface api = retrofit.create(endinterface.class);
        return api; // return the APIInterface object
    }
}

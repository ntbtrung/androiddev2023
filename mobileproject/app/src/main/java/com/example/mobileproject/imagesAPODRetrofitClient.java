package com.example.mobileproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class imagesAPODRetrofitClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.nasa.gov/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
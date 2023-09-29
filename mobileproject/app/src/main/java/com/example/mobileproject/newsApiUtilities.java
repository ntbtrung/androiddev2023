package com.example.mobileproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class newsApiUtilities {

    private static Retrofit retrofit = null;

    public static newsApiInterface getApiInterface(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(newsApiInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(newsApiInterface.class);
    }

}

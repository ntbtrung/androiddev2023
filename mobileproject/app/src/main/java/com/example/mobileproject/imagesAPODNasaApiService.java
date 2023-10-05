package com.example.mobileproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface imagesAPODNasaApiService {
    @GET("planetary/apod")
    Call<imagesAPODResponse> getAPOD(@Query("api_key") String apiKey);
}
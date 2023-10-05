package com.example.mobileproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NasaApiService {
    @GET("/search")
    Call<NasaSearchResponse> search(
            @Query("q") String query,
            @Query("page") int page,
            @Query("media_type") String mediaType,
            @Query("year_start") int yearStart,
            @Query("year_end") int yearEnd
    );
}
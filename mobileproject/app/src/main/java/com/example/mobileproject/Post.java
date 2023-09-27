package com.example.mobileproject;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Post {
    @GET("api")
    static Call<List<latest_news>> getPost() {
        return null;
    }
}

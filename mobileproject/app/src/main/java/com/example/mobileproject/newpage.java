package com.example.mobileproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.carousel.CarouselLayoutManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Newpage extends AppCompatActivity {
    // private CardView cardView;
    // private ImageView newsImage;
    // private TextView newsTitle;

    private RecyclerView recyclerView;

    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpage);
        btnback = findViewById(R.id.btnBack);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /**
        * cardView = findViewById(R.id.cardview);
        * newsImage = cardView.findViewById(R.id.news_image);
        * newsTitle = cardView.findViewById(R.id.newsTitle);
        **/
        recyclerView = findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new CarouselLayoutManager());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.nasa.gov/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Post postHolder = retrofit.create(Post.class);
        Call<List<latest_news>> call = Post.getPost();
        call.enqueue(new Callback<List<latest_news>>() {

            @Override
            public void onResponse(Call<List<latest_news>> call, Response<List<latest_news>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(Newpage.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<latest_news> postList = response.body();
                PostAdapter postAdapter = new PostAdapter(Newpage.this , postList);
                recyclerView.setAdapter(postAdapter);
            }

            @Override
            public void onFailure(Call<List<latest_news>> call, Throwable t) {

                Toast.makeText(Newpage.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
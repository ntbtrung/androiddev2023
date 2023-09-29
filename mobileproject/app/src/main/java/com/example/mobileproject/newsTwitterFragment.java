package com.example.mobileproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class newsTwitterFragment extends Fragment {

    String api="d00092a65053481cb44c0908274df354";
    ArrayList<newsModelClass> newsModelClassArrayList;
    newsAdapter newsAdapter;
    String country = "us";

    private RecyclerView recyclerViewoftwitter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news_twitter,null);

        recyclerViewoftwitter = v.findViewById(R.id.recyclerviewoftwitter);
        newsModelClassArrayList = new ArrayList<>();
        recyclerViewoftwitter.setLayoutManager(new LinearLayoutManager(getContext()));
        newsAdapter = new newsAdapter(getContext(), newsModelClassArrayList);
        recyclerViewoftwitter.setAdapter(newsAdapter);

        findNews();

        return v;
    }

    private void findNews() {

        newsApiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<newsMainPage>() {
            @Override
            public void onResponse(Call<newsMainPage> call, Response<newsMainPage> response){
                if(response.isSuccessful()){
                    newsModelClassArrayList.addAll(response.body().getArticles());
                    newsAdapter.notifyDataSetChanged();;
                }
            }

            @Override
            public void onFailure(Call<newsMainPage> call, Throwable t) {

            }
        });
    }
}

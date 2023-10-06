package com.example.mobileproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class imagesSearchFragment extends Fragment {
    private NasaApiService apiService;
    private static final String TAG = imagesSearchFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private NasaItemAdapter adapter;
    private List<NasaItem> nasaItemList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_image_recyclerview,null);

        apiService = RetrofitClient.getRetrofitInstance().create(NasaApiService.class);
        recyclerView = v.findViewById(R.id.recyclerview);
        adapter = new NasaItemAdapter(nasaItemList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        SearchView searchView = v.findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // Trigger search when the user submits the query
                performSearch(query, 1, "image", 1920, 2023);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return v;
    }

    private void performSearch(String query,int page,String mediaType, int yearStart, int yearEnd) {
        Log.d(TAG, "Query: " + query);
        Call<NasaSearchResponse> call = apiService.search(query,page,mediaType,yearStart,yearEnd);
        call.enqueue(new Callback<NasaSearchResponse>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(Call<NasaSearchResponse> call, Response<NasaSearchResponse> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    nasaItemList.addAll(response.body().getCollection().getItems());
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e(TAG, "API request failed with code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<NasaSearchResponse> call, Throwable t) {
                Log.e(TAG, "Network error: " + t.getMessage(), t);
            }
        });
    }
}

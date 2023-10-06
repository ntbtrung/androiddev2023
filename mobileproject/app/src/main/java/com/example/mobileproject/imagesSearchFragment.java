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
    private NasaItemAdapter adapter;
    private List<NasaItem> nasaItemList;

    private RecyclerView recyclerView;
    private NasaItem nasaItem;

    private int currentPage = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_image_recyclerview, null);

        apiService = RetrofitClient.getRetrofitInstance().create(NasaApiService.class);
        recyclerView = v.findViewById(R.id.recyclerview);
        adapter = new NasaItemAdapter(nasaItemList, nasaItem);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        SearchView searchView = v.findViewById(R.id.searchview);

        recyclerView.setVisibility(View.GONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // Trigger search when the user submits the query
                currentPage = 1; // Reset page when performing a new search
                performSearch(query, currentPage, "image", 1920, 2023);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        // Add a scroll listener to implement infinite scrolling
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                if (!isLoading && !isLastPage) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                            && firstVisibleItemPosition >= 0) {
                        currentPage++; // Load the next page
                        performSearch(TAG, currentPage, "image", 1920, 2023);
                    }
                }
            }
        });

        return v;
    }

    private void performSearch(String query, int page, String mediaType, int yearStart, int yearEnd) {
        Log.d(TAG, "Query: " + query);
        isLoading = true; // Set loading flag

        Call<NasaSearchResponse> call = apiService.search(query, page, mediaType, yearStart, yearEnd);
        call.enqueue(new Callback<NasaSearchResponse>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<NasaSearchResponse> call, @NonNull Response<NasaSearchResponse> response) {
                isLoading = false; // Reset loading flag

                if (response.isSuccessful()) {
                    assert response.body() != null;
                    List<NasaItem> newItems = response.body().getCollection().getItems();
                    if (page == 1) {
                        // Clear the list when loading the first page
                        nasaItemList.clear();
                    }
                    nasaItemList.addAll(newItems);

                    if (newItems.isEmpty()) {
                        // If no new items are loaded, it's the last page
                        isLastPage = true;
                    }

                    recyclerView.setVisibility(View.VISIBLE);
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e(TAG, "API request failed with code: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<NasaSearchResponse> call, @NonNull Throwable t) {
                isLoading = false; // Reset loading flag
                Log.e(TAG, "Network error: " + t.getMessage(), t);
            }
        });
    }
}

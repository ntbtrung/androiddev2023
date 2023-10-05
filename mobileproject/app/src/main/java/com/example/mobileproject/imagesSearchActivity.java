package com.example.mobileproject;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class imagesSearchActivity extends AppCompatActivity {
    private NasaApiService apiService;
    private static final String TAG = imagesSearchActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private NasaItemAdapter adapter;
    private List<NasaItem> nasaItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nasa_recyclerview);

        apiService = RetrofitClient.getRetrofitInstance().create(NasaApiService.class);
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new NasaItemAdapter(nasaItemList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.searchview);
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
    }

    private void performSearch(String query,int page,String mediaType, int yearStart, int yearEnd) {
        Log.d(TAG, "Query: " + query);
        Call<NasaSearchResponse> call = apiService.search(query,page,mediaType,yearStart,yearEnd);
        call.enqueue(new Callback<NasaSearchResponse>() {
            @Override
            public void onResponse(Call<NasaSearchResponse> call, Response<NasaSearchResponse> response) {
                if (response.isSuccessful()) {
                    NasaSearchResponse nasaResponse = response.body();
                    assert nasaResponse != null;
                    List<NasaItem> items = nasaResponse.getCollection().getItems();
                    adapter.setNasaItemList(items);
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

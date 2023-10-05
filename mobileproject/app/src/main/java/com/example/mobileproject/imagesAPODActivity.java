package com.example.mobileproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class imagesAPODActivity extends AppCompatActivity {

    private ImageView apodImageView;
    private TextView apodTitleTextView;
    private TextView apodDateTextView;
    private TextView apodExplanationTextView;
    private imagesAPODNasaApiService apiService;
    private String apiKey = "Ik8WV87VrplVUZ3ehOm7nzSFuh9yaFNafi27MOam"; // Replace with your NASA API key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images_apod);

        // Initialize views
        apodImageView = findViewById(R.id.apodImageView);
        apodTitleTextView = findViewById(R.id.apodTitleTextView);
        apodDateTextView = findViewById(R.id.apodDateTextView);
        apodExplanationTextView = findViewById(R.id.apodExplanationTextView);

        // Initialize Retrofit service
        apiService = imagesAPODRetrofitClient.getRetrofitInstance().create(imagesAPODNasaApiService.class);

        // Fetch APOD data
        fetchApodData();
    }

    private void fetchApodData() {
        Call<imagesAPODResponse> call = apiService.getAPOD(apiKey);
        call.enqueue(new Callback<imagesAPODResponse>() {
            @Override
            public void onResponse(Call<imagesAPODResponse> call, Response<imagesAPODResponse> response) {
                if (response.isSuccessful()) {
                    imagesAPODResponse imagesApodResponse = response.body();
                    updateUI(imagesApodResponse);
                } else {
                    // Handle API error
                }
            }

            @Override
            public void onFailure(Call<imagesAPODResponse> call, Throwable t) {
                // Handle network error
            }
        });
    }

    private void updateUI(imagesAPODResponse imagesApodResponse) {
        // Load the image using Picasso
        Picasso.get().load(imagesApodResponse.getUrl()).into(apodImageView);

        // Set the title, date, and explanation
        apodTitleTextView.setText(imagesApodResponse.getTitle());
        apodDateTextView.setText(imagesApodResponse.getDate());
        apodExplanationTextView.setText(imagesApodResponse.getExplanation());
    }
}


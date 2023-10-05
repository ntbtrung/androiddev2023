package com.example.mobileproject;

import android.os.Bundle;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;


public class imagesPrimeActivity extends AppCompatActivity {

    private ScrollView scrollView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        scrollView = findViewById(R.id.image_scrollview);
    }

}

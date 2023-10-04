package com.example.mobileproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class imagesActivity extends AppCompatActivity {

    WebView webView;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        webView = findViewById(R.id.imagewebview);

        // Enable JavaScript (if the website relies on it)
        webView.getSettings().setJavaScriptEnabled(true);

        // Set a WebViewClient to handle page events
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.nasa.gov/images/");
    }
}
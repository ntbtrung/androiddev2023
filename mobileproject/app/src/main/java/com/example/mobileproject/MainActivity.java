package com.example.mobileproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageButton new1;
    ImageButton images;
    ImageButton live;
    ImageButton misson;
    ImageButton video;
    Button btnmenu1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new1 = findViewById(R.id.new1);
        images = findViewById(R.id.btnimages);
        live = findViewById(R.id.btnLive);
        misson = findViewById(R.id.btnmission);
        video = findViewById(R.id.btnvideo);
        btnmenu1 = findViewById(R.id.btnmenu);
        new1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newPgageintent = new Intent(MainActivity.this, newsMainActivity.class);
                startActivity(newPgageintent);
            }
        });

        images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imageintent = new Intent(MainActivity.this, ImageActivity.class);
                startActivity(imageintent);
            }
        });

        live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent liveintent = new Intent(MainActivity.this, LiveActivity.class);
                startActivity(liveintent);
            }
        });

        btnmenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuintent = new Intent(MainActivity.this, menutest.class);
                startActivity(menuintent);
            }
        });

        misson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent missonintent = new Intent(MainActivity.this, MissonActivity.class);
                startActivity(missonintent);
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent videointent = new Intent(MainActivity.this, videoActivity.class);
                startActivity(videointent);
            }
        });


    }
}
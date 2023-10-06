package com.example.mobileproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class imagesPrimeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mapod, msearch;
    imagesPagerAdapter imagesPagerAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        mapod = findViewById(R.id.apod);
        msearch = findViewById(R.id.search);

        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout = findViewById(R.id.include);

        imagesPagerAdapter = new imagesPagerAdapter(getSupportFragmentManager(),2);
        viewPager.setAdapter(imagesPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0|tab.getPosition()==1) {
                    imagesPagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

}

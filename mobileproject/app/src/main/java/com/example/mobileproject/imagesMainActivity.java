package com.example.mobileproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class imagesMainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mapod, mtwitter, mfacebook;
    imagesPagerAdapter imagesPagerAdapter;
    Toolbar mtoolbar;

    String api="Ik8WV87VrplVUZ3ehOm7nzSFuh9yaFNafi27MOam";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        mtoolbar = findViewById(R.id.toolbarImages);
        setSupportActionBar(mtoolbar);

        mapod = findViewById(R.id.apod);
        mfacebook = findViewById(R.id.facebook);
        mtwitter = findViewById(R.id.twitter);

        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout = findViewById(R.id.include);

        imagesPagerAdapter = new imagesPagerAdapter(getSupportFragmentManager(),3);
        viewPager.setAdapter(imagesPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0|tab.getPosition()==1|tab.getPosition()==2) {
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

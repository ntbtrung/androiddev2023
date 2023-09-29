package com.example.mobileproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class newsMainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mlatest, mtwitter, mfacebook;
    newsPagerAdapter newsPagerAdapter;
    Toolbar mtoolbar;

    String api="d00092a65053481cb44c0908274df354";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        mtoolbar = findViewById(R.id.toolbarNews);
        setSupportActionBar(mtoolbar);

        mlatest = findViewById(R.id.latestnews);
        mfacebook = findViewById(R.id.facebook);
        mtwitter = findViewById(R.id.twitter);

        ViewPager viewPager = findViewById(R.id.fragmentcontainer);
        tabLayout = findViewById(R.id.include);

        newsPagerAdapter = new newsPagerAdapter(getSupportFragmentManager(),3);
        viewPager.setAdapter(newsPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0|tab.getPosition()==1|tab.getPosition()==2) {
                    newsPagerAdapter.notifyDataSetChanged();
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

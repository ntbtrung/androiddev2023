package com.example.mobileproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class newsPagerAdapter extends FragmentPagerAdapter {

    int tabcount;

    public newsPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                return new newsLatestFragment();

            case 1:
                return new newsTwitterFragment();

            case 2:
                return new newsFacebookFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
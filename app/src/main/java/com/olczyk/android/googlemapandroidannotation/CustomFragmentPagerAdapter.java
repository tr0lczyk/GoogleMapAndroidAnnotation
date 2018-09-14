package com.olczyk.android.googlemapandroidannotation;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    List<Fragment> fragments;

    public CustomFragmentPagerAdapter(Context context, FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "markers";
        } else {
            return "line";
        }
    }
}

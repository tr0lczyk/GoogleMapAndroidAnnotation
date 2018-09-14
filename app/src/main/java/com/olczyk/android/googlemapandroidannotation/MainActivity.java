package com.olczyk.android.googlemapandroidannotation;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    ViewPager fragment_container;

    @ViewById
    TabLayout tabLayout;

    @AfterViews
    public void  aVoid(){

        Fragment fragmentMapMarkers = MapFragment_.builder().build();
        Fragment fragmentMapLine = MapFragmentNormal_.builder().build();

        List<Fragment> fragments = new ArrayList<>();

        fragments.add(fragmentMapLine);
        fragments.add(fragmentMapMarkers);

        CustomFragmentPagerAdapter pagerAdapter = new CustomFragmentPagerAdapter(this,getSupportFragmentManager(),fragments);
        fragment_container.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(fragment_container);
    }
}

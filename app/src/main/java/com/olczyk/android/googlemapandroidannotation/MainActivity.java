package com.olczyk.android.googlemapandroidannotation;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends SimpleAbstractFragmentClass {

    @Override
    protected Fragment createFragment() {
        return new MapFragment();
    }
}

package com.olczyk.android.googlemapandroidannotation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@EFragment(R.layout.fragment_map)
public class MapFragmentNormal extends Fragment {

    @ViewById
    MapView map_view;

    GoogleMap gogleMap;
    View rootView;

    LatLng first;
    LatLng second;
    LatLng third;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_map,container,false);

        map_view = rootView.findViewById(R.id.map_view);

        map_view.onCreate(savedInstanceState);
        map_view.onResume();

        final List<LatLng> latLngs = new ArrayList<>();

        first = new LatLng(42.390205,2.154007);
        second = new LatLng(53.237049,21.017532);
        third = new LatLng(52.4546600,30.5238000);

        latLngs.add(first);
        latLngs.add(second);
        latLngs.add(third);

        try {
            MapsInitializer.initialize(Objects.requireNonNull(getActivity()).getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        map_view.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                gogleMap = googleMap;
                LatLngBounds.Builder cameraBoundries = new LatLngBounds.Builder();

                MarkerOptions marker1 = new MarkerOptions().position(first).title("first");
                marker1.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
                cameraBoundries.include(first);

                googleMap.addMarker(marker1);

                MarkerOptions marker2 = new MarkerOptions().position(second).title("second");
                marker2.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
                cameraBoundries.include(second);

                googleMap.addMarker(marker2);

                MarkerOptions marker3 = new MarkerOptions().position(third).title("third");
                marker3.icon(BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_ROSE));
                googleMap.addMarker(marker3);
                cameraBoundries.include(third);

                PolylineOptions polylineOptions = new PolylineOptions()
                        .addAll(latLngs);
                polylineOptions.width(5).color(Color.RED);
                gogleMap.addPolyline(polylineOptions);

                LatLngBounds boundiresBuild = cameraBoundries.build();

                int width = getResources().getDisplayMetrics().widthPixels;
                int height = getResources().getDisplayMetrics().heightPixels;
                int padding = (int) (width * 0.10);
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(boundiresBuild, width,height,padding);

                googleMap.animateCamera(cameraUpdate);
            }
        });
        return rootView;
    }

    private double randomLat() {
        Random random = new Random();
        double result = random.nextDouble()*(-180.00) + 90.00;
        return result;
    }

    private double randomLng() {
        Random random = new Random();
        double result = random.nextDouble()*(-360.00) + 180.00;
        return result;
    }


    @Override
    public void onResume() {
        super.onResume();
        map_view.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        map_view.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        map_view.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        map_view.onLowMemory();
    }
}


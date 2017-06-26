package com.gulbalasalamov.mapdemo2;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapDemoActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_demo);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        UiSettings mapSettings;

        LatLng ankara = new LatLng(39.917797,32.812046);
        mMap.addMarker(new MarkerOptions()
                .position(ankara)
                .title("Ankara")
                .snippet("Ankara Şehirlerarası Terminal İşletmesi"));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ankara,100));

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        mapSettings = mMap.getUiSettings();
        mapSettings.setZoomControlsEnabled(true);
    }
}

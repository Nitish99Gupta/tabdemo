package com.example.nitish.slidingtabdemo;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class ActivityB extends AppCompatActivity implements OnMapReadyCallback,OnMarkerClickListener{

    ImageView imagerice;
    GoogleMap map;
    Marker myMarker;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_activity_b);
        View coordinatorLayout = findViewById(R.id.snackbar);
        Snackbar.make(coordinatorLayout, "US$0 - US$560", Snackbar.LENGTH_INDEFINITE)
                .setAction("GET TICKETS", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(),ActivityD.class);
                        startActivity(intent);

                    }
                })
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                .show();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                //do something you want
            }
        });

        imagerice = (ImageView) findViewById(R.id.imagerice);
        imagerice.setOnClickListener(new View.OnClickListener() {
            // Start new list activity
            public void onClick(View v) {
                Intent mainIntent = new Intent(getApplicationContext(),
                        ActivityC.class);
                startActivity(mainIntent);
            }
        });


        ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMapAsync(this);




    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        setUpMap();

    }

    private void setUpMap() {
        map.setOnMarkerClickListener(this);
       myMarker= map.addMarker(new MarkerOptions().position(new LatLng(28.5202046, 77.1704032)).title("Mehrauli"));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(28.5202046, 77.1704032), 15));



    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.equals(myMarker)) {
            Intent intent = new Intent(getApplicationContext(),GoogleDemo.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(),"You Are Fail",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}




package com.example.dylan.taxtimewithfriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class logTrip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_trip);
    }
    public void autoTripActivity (View auto){
        startActivity(new Intent(logTrip.this, autoAddTrip.class));
    }

    public void manualTripActivity (View manual){
        startActivity(new Intent(logTrip.this, manualAddTrip.class));
    }

}

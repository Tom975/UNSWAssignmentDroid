package com.example.dylan.taxtimewithfriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class autoAddTrip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_add_trip);

        TextView tv = (TextView) findViewById(R.id.timeAndDate);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm      |       dd - MM - yyyy");
        String currentDateandTime = sdf.format(new Date());
        tv.setText(currentDateandTime);

    }

    public void completeAutoTripActivity (View v){
        startActivity(new Intent(autoAddTrip.this, completeAutoTrip.class));
    }




    }

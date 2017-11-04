package com.example.dylan.taxtimewithfriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logTripActivity(View v){
        startActivity(new Intent(MainActivity.this, logTrip.class));
    }

    public void addDriverActivity (View v){
        startActivity(new Intent(MainActivity.this, addDriver.class));
    }

    public void addVehicleActivity (View v){
        startActivity(new Intent(MainActivity.this, addVehicle.class));
    }

    public void addExpenseActivity (View v){
        startActivity(new Intent(MainActivity.this, addExpense.class));
    }

    public void summaryActivity (View v){
        startActivity(new Intent(MainActivity.this, summary.class));
    }
}

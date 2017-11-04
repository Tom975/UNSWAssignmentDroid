package com.example.dylan.taxtimewithfriends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class manualAddTrip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_add_trip);
    }

    public void mainMenuActivity (View v){
        startActivity(new Intent(manualAddTrip.this, MainActivity.class));
    }
    
    public void clickFunction(View view){

        EditText manOdoStart = (EditText)findViewById(getResources(R.id.manualOdoStart));

        EditText manOdoEnd = (EditText)findViewById(getResources(R.id.manualOdoEnd));

        EditText manDate = (EditText)findViewById(getResources(R.id.manualDatgetResources(e));

        EditText manReason = (EditText)findViewById(getResources(R.id.manualReason));
        
        Log.i("Manual Trip added", manOdoStart.getText().toString(), manOdoEnd.getText().toString(), manDate.getText().toString(), manReason.getText().toString());

    }

}

package com.example.mainconnectivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("Tracking_Alexander/");
    DatabaseReference ref2 = database.getReference("Tracking_Philipp/");
    DatabaseReference ref3 = database.getReference("Tracking_Martin/");
    DatabaseReference ref4 = database.getReference("Tracking_Markus/");
    Data trackingObject;
    Handler handler = new Handler();
    Runnable runnable;
    int delay = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ref.setValue("Hey Storage");
        //ref.child("Location").setValue("12.23131");
        //ref.child("Location2").setValue("12.231");
        //ref2.child("sunny").setValue("23degree");


    }

    @Override
    protected void onResume() {
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                handler.postDelayed(runnable, delay);
                Toast.makeText(MainActivity.this, "This method is run every 10 seconds",
                        Toast.LENGTH_SHORT).show();
                       ref.child("Location").setValue("14");
                       ref.child("Location2").setValue("15");
                ref2.child("Location").setValue("14");
                ref2.child("Location2").setValue("15");
                ref3.child("Location").setValue("14");
                ref3.child("Location2").setValue("15");
                ref4.child("Location").setValue("14");
                ref4.child("Location2").setValue("15");

            }
        }, delay);
        super.onResume();
    }




}
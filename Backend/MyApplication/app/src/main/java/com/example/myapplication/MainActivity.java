package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    String dataTest1;
    String dataTest2;
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference databaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"Firebase connection success",Toast.LENGTH_LONG).show();
        databaseRef = db.getReference("Data");

    }

    public void sendData(){

        int counter=1;
        dataTest1 = "Test: "+counter;
        String id = databaseRef.push().getKey();
        Data data = new Data(dataTest1,id);
        databaseRef.child(id).setValue(data);

    }


}
package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Anchor extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference Redref,GreenRef,BlueRef,YellowRef,OrangeRef,myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anchor);

        database = FirebaseDatabase.getInstance();
        myref = database.getReference("LED_STATUS");
        Redref = database.getReference("RedTeam");
        BlueRef = database.getReference("BlueTeam");
        YellowRef = database.getReference("YellowTeam");
        GreenRef = database.getReference("GreenTeam");
        OrangeRef = database.getReference("OrangeTeam");

        Button resetAll = (Button) findViewById(R.id.resetAll);
        resetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myref.setValue(0);
                Redref.setValue(null);
                GreenRef.setValue(null);
                BlueRef.setValue(null);
                YellowRef.setValue(null);
                OrangeRef.setValue(null);
            }
        });
    }
}

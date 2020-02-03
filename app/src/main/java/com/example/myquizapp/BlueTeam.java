package com.example.myquizapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class BlueTeam extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myref,myref2,FlagRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_team);
        database = FirebaseDatabase.getInstance();
        myref = database.getReference("LED_STATUS");
        myref2 = database.getReference("BlueTeam");
        FlagRef = FirebaseDatabase.getInstance().getReference("FlagRef");


        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.click);
        final ImageButton buttonblue = (ImageButton) findViewById(R.id.buttonblue);

        FlagRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Boolean  Flagvalue= Boolean.valueOf(dataSnapshot.getValue().toString());
                buttonblue.setEnabled(Flagvalue);
                Toast.makeText(getApplicationContext(), Flagvalue.toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        buttonblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myref.setValue(3);
                myref2.setValue(3);
                Toast.makeText(getApplicationContext(),"click", Toast.LENGTH_SHORT).show();
                mp.start();
            }
        });

    }
}

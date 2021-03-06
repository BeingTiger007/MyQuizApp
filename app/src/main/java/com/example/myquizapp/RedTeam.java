package com.example.myquizapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class RedTeam extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myref,myref2,FlagRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_team);
        database = FirebaseDatabase.getInstance();
        myref = database.getReference("LED_STATUS");
        myref2 = database.getReference("RedTeam");
        FlagRef = FirebaseDatabase.getInstance().getReference("FlagRef");


        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.click);
        final ImageButton buttonred;
        buttonred = findViewById(R.id.buttonred);

        FlagRef.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                boolean Flagvalue= Boolean.parseBoolean(Objects.requireNonNull(dataSnapshot.getValue()).toString());
                buttonred.setEnabled(Flagvalue);
                Toast.makeText(getApplicationContext(), Boolean.toString(Flagvalue),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        buttonred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myref.setValue(4);
                myref2.setValue(4);
                Toast.makeText(getApplicationContext(),"click", Toast.LENGTH_SHORT).show();
                mp.start();
            }
        });

    }
}
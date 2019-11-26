package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OrangeTeam extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myref,myref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orange_team);
        database = FirebaseDatabase.getInstance();
        myref = database.getReference("LED_STATUS");
        myref2 = database.getReference("OrangeTeam");

        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.click);
        final ImageButton buttonorange = (ImageButton) findViewById(R.id.buttonorange);
        Switch switchEnableButton = findViewById(R.id.switch_enable_button);

        buttonorange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myref.setValue(4);
                myref2.setValue(4);
                //Toast.makeText(getApplicationContext(),"click", Toast.LENGTH_SHORT).show();
                mp.start();
            }
        });

        switchEnableButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    buttonorange.setEnabled(true);
                }
                else{
                    buttonorange.setEnabled(false);
                }
            }
        });
    }
}

package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;

public class BlueTeam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue_team);

        final ImageButton buttonblue = (ImageButton) findViewById(R.id.buttonblue);
        Switch switchEnableButton = findViewById(R.id.switch_enable_button);

        buttonblue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(MainActivity.this,"click",Toast.LENGTH_SHORT).show();
            }
        });

        switchEnableButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    buttonblue.setEnabled(true);
                }
                else{
                    buttonblue.setEnabled(false);
                }
            }
        });
    }
}

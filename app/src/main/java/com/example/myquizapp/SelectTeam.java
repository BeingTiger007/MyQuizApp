package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectTeam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_team);

        Button buttonRed = (Button) findViewById(R.id.buttonRed);
        Button buttonGreen = (Button) findViewById(R.id.buttonGreen);
        Button buttonBlue = (Button) findViewById(R.id.buttonBlue);
        Button buttonYellow = (Button) findViewById(R.id.buttonYellow);
        Button buttonOrange = (Button) findViewById(R.id.buttonOrange);
        Button buttonAnchor = (Button) findViewById(R.id.buttonAnchor);

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectTeam.this, RedTeam.class);
                startActivity(i);
            }
        });

        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectTeam.this, GreenTeam.class);
                startActivity(i);
            }
        });

        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectTeam.this, BlueTeam.class);
                startActivity(i);
            }
        });

        buttonYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectTeam.this, YellowTeam.class);
                startActivity(i);
            }
        });

        buttonOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectTeam.this, OrangeTeam.class);
                startActivity(i);
            }
        });

        buttonAnchor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectTeam.this, Anchor.class);
                startActivity(i);
            }
        });
    }
}

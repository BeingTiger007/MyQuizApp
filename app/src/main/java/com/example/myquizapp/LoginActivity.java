package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);

    Button nextbutton = (Button) findViewById(R.id.loginbutton);
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (username.getText().toString().equals("joykailas") || username.getText().toString().equals("mayamam") &&
                        password.getText().toString().equals("coc$it") || password.getText().toString().equals("6969")) {
                    Toast.makeText(getApplicationContext(), "Login Successful",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, SelectTeam.class);
                    startActivity(i);
                }

                else {
                    Toast.makeText(getApplicationContext(),"login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

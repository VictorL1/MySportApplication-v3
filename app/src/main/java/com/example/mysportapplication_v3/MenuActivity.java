package com.example.mysportapplication_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private Button b1,b2,b3,b4,b5,b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.buttonprofile);

        b1.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
            moveToActivity();
        });
        b2.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
            moveToActivity();
        });
        b3.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
            moveToActivity();
        });
        b4.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
            moveToActivity();
        });
        b5.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
            moveToChronometre();
        });
        b6.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
            moveToProfile();
        });
    }


    private void moveToActivity() {
        Intent intent = new Intent(MenuActivity.this, ActivitiesActivity.class);
        startActivity(intent);
    }

    private void moveToChronometre() {
        Intent intent = new Intent(MenuActivity.this, ChronometreActivity.class);
        startActivity(intent);
    }
    private void moveToProfile() {
        Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}
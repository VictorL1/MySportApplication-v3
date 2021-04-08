package com.example.mysportapplication_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivitiesActivity extends AppCompatActivity {

    Button desc, buttonback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);
        buttonback = (Button) findViewById(R.id.button8);
        desc = (Button) findViewById(R.id.button5);

        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToConnexionBDD();
            }
        });

        buttonback.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
            moveToActivity();
        });
    }

    private void moveToActivity() {
        Intent intent = new Intent(ActivitiesActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    private void moveToConnexionBDD() {
        Intent intent = new Intent(ActivitiesActivity.this, connexionBDD.class);
        startActivity(intent);
    }
}






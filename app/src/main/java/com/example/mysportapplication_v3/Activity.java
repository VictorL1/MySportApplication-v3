package com.example.mysportapplication_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class Activity extends AppCompatActivity {

    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        b1 = (Button) findViewById(R.id.button8);

        b1.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
            moveToMenu();
        });
    }

        private void moveToMenu() {
            Intent intent = new Intent(Activity.this, MenuActivity.class);
            startActivity(intent);
        }
    }

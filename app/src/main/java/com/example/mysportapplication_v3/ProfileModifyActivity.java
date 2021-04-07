package com.example.mysportapplication_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class ProfileModifyActivity extends AppCompatActivity {
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_profile);

        b1 = (Button) findViewById(R.id.button1);

        b1.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
            moveToActivity();
        });
    }
    private void moveToActivity() {
        Intent intent = new Intent(ProfileModifyActivity.this, ProfileActivity.class);
        startActivity(intent);
    }
}

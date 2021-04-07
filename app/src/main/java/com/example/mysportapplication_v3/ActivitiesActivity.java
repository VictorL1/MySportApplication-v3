package com.example.mysportapplication_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivitiesActivity extends AppCompatActivity {

    Button desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        desc = (Button) findViewById(R.id.button5);

        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToConnexionBDD();
            }
        });
    }

    private void moveToConnexionBDD() {
        Intent intent = new Intent(ActivitiesActivity.this, connexionBDD.class);
        startActivity(intent);
    }
}






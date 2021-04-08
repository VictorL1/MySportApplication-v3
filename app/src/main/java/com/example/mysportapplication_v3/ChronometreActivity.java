package com.example.mysportapplication_v3;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mysportapplication_v3.MenuActivity;
import com.example.mysportapplication_v3.R;

import java.util.Locale;
public class ChronometreActivity extends AppCompatActivity {

    Chronometer simpleChronometer;
    Button start, stop, restart, reset;

    private TextView textViewCounter;
    private Button buttoncounter;
    private Button buttonback;
    private static int counter = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometre);

        this.textViewCounter = (TextView) findViewById(R.id.textView_counter);
        this.buttoncounter = (Button) findViewById(R.id.button_counter);
        this.buttonback = (Button) findViewById(R.id.button12);
        textViewCounter.setText(String.valueOf(counter));
        this.reset = (Button) findViewById(R.id.buttonreset);

        // initiate views
        simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer);
        start = (Button) findViewById(R.id.startButton);
        stop = (Button) findViewById(R.id.stopButton);
        restart = (Button) findViewById(R.id.restartButton);

        // perform click  event on start button to start a chronometer
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                simpleChronometer.start();
            }
        });

        // perform click  event on stop button to stop the chronometer
        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                simpleChronometer.stop();
            }
        });

        // perform click  event on restart button to set the base time on chronometer
        restart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                simpleChronometer.setBase(SystemClock.elapsedRealtime());
            }
        });



        this.buttoncounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCounter();
            }
        });

        this.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetDoCounter();
            }
        });

        buttonback.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
            moveToActivity();
        });

    }



    private void moveToActivity() {
        Intent intent = new Intent(ChronometreActivity.this, MenuActivity.class);
        startActivity(intent);
    }
    private void doCounter(){
        counter++;
        textViewCounter.setText(String.valueOf(counter));
    }
    private void resetDoCounter(){
        counter=0;
        textViewCounter.setText(String.valueOf(counter));
    }
}




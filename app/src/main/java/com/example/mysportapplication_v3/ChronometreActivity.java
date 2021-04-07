package com.example.mysportapplication_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChronometreActivity extends AppCompatActivity {

    private TextView textViewInfo;
    private TextView textViewCounter;
    private Chronometer chronometer;
    private Button buttonStart;
    private Button buttonStop;
    private Button buttonResetBaseTime;
    private Button buttoncounter;
    private Button buttonback;
    private static int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometre);
        this.textViewInfo = (TextView) findViewById(R.id.textView_info);
        this.textViewCounter=(TextView)findViewById(R.id.textView_counter);
        this.chronometer = (Chronometer)findViewById(R.id.chronometerExample);

        this.buttonStart = (Button)findViewById(R.id.button_start);
        this.buttonStop = (Button)findViewById(R.id.button_stop);
        this.buttonResetBaseTime = (Button)findViewById(R.id.button_resetBaseTime);
        this.buttoncounter = (Button)findViewById(R.id.button_counter);

        this.buttonStop.setEnabled(false);
        this.buttonResetBaseTime.setEnabled(false);

        this.buttonback = (Button)findViewById(R.id.button12);


        textViewCounter.setText(String.valueOf(counter));
        this.buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doStart();
            }
        });
        this.buttoncounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCounter();
            }
        });

        this.buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doStop();
            }
        });


        this.buttonResetBaseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doResetBaseTime();
            }
        });

        buttonback.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
            moveToActivity();
        });
    }

    // @totalMilliseconds: milliseconds since system boot, including time spent in sleep.
    private void showInfo(long totalMilliseconds)  {
        // Seconds
        long totalSecs = totalMilliseconds / 1000;
        // Show Info
        long hours = totalSecs / 3600;
        long minutes = (totalSecs % 3600) / 60;
        long seconds = totalSecs % 60;

        this.textViewInfo.setText("Base Time: " + totalSecs +" ~ " + hours + " hours " + minutes+" minutes " + seconds + " seconds");
    }
    private void doCounter(){
        counter++;
        textViewCounter.setText(String.valueOf(counter));
    }

    private void doStart()  {
        // Returns milliseconds since system boot, including time spent in sleep.
        long elapsedRealtime = SystemClock.elapsedRealtime();
        // Set the time that the count-up timer is in reference to.
        this.chronometer.setBase(elapsedRealtime);
        this.chronometer.start();
        this.showInfo(elapsedRealtime);
        //
        this.buttonStart.setEnabled(false);
        this.buttonStop.setEnabled(true);
        this.buttonResetBaseTime.setEnabled(true);
    }

    private void doStop()  {
        this.chronometer.stop();
        //
        this.buttonStart.setEnabled(true);
        this.buttonStop.setEnabled(false);
        this.buttonResetBaseTime.setEnabled(false);
    }

    private void doResetBaseTime()  {
        // Returns milliseconds since system boot, including time spent in sleep.
        long elapsedRealtime = SystemClock.elapsedRealtime();
        // Set the time that the count-up timer is in reference to.
        this.chronometer.setBase(elapsedRealtime);
        this.showInfo(elapsedRealtime);
    }

    private void moveToActivity() {
        Intent intent = new Intent(ChronometreActivity.this, MenuActivity.class);
        startActivity(intent);
    }
}
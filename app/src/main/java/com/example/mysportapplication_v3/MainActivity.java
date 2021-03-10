package com.example.mysportapplication_v3;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {



    Button b1,b2,b3;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        b3 = (Button)findViewById(R.id.button3);
        b2 = (Button)findViewById(R.id.button2);
        tx1 = (TextView)findViewById(R.id.textView3);
        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(v -> {
            if(ed1.getText().toString().equals("admin") &&
                    ed2.getText().toString().equals("admin")) {
                Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
                moveToMenu();

            }else{
                Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();

                        tx1.setVisibility(View.VISIBLE);
                tx1.setBackgroundColor(Color.RED);
                counter--;
                tx1.setText(Integer.toString(counter));

                if (counter == 0) {
                    b1.setEnabled(false);
                }
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToCreateAccount();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void moveToMenu() {
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        startActivity(intent);
    }

    private void moveToCreateAccount() {
        Intent intent = new Intent(MainActivity.this, MenuAccountActivity.class);
        startActivity(intent);
    }
}
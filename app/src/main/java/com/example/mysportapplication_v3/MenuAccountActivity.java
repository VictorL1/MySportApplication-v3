package com.example.mysportapplication_v3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MenuAccountActivity extends AppCompatActivity {
    Button b1,b2;
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8, ed9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_account);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        ed1 = (EditText) findViewById(R.id.editText);
        ed3 = (EditText) findViewById(R.id.editText2);
        ed4 = (EditText) findViewById(R.id.editText3);
        ed5 = (EditText) findViewById(R.id.editText4);
        ed6 = (EditText) findViewById(R.id.editText5);
        ed7 = (EditText) findViewById(R.id.editText6);
        ed8 = (EditText) findViewById(R.id.editText7);
        ed9 = (EditText) findViewById(R.id.editText8);

        b1.setOnClickListener(v -> {
            if (!ed1.getText().toString().isEmpty() && !ed2.getText().toString().isEmpty() && !ed3.getText().toString().isEmpty() && !ed4.getText().toString().isEmpty() && !ed5.getText().toString().isEmpty() && !ed6.getText().toString().isEmpty() && !ed7.getText().toString().isEmpty() && !ed8.getText().toString().isEmpty() && !ed9.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                moveToMenu();

            } else {
                Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(v -> moveToMenu());
    }
        private void moveToMenu(){
            Intent intent = new Intent(MenuAccountActivity.this, MainActivity.class);
            startActivity(intent);
        }
}
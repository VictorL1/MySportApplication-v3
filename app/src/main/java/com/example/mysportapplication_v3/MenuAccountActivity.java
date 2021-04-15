package com.example.mysportapplication_v3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
        ed2 = (EditText) findViewById(R.id.editText);
        ed3 = (EditText) findViewById(R.id.editText2);
        ed4 = (EditText) findViewById(R.id.editText3);
        ed5 = (EditText) findViewById(R.id.editText4);
        ed6 = (EditText) findViewById(R.id.editText5);
        ed7 = (EditText) findViewById(R.id.editText6);
        ed8 = (EditText) findViewById(R.id.editText7);
        ed9 = (EditText) findViewById(R.id.editText8);


            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MenuAccountActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });


        b2.setOnClickListener(v -> moveToMenu());
    }


    public void sendCreated(View view){
        String prenomUtilisateur = ((EditText) findViewById(R.id.editText2)).getText().toString();

        if(prenomUtilisateur.length()!=0)
        {
            final DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
            db.open();

            // On vérifie que l'utilisateur n'existe pas déja
            boolean existe = db.existUser(prenomUtilisateur);

            // si l'uitlisateur n'existe pas on le créer
            if(!existe){
                db.addUser(prenomUtilisateur);
                String age = db.getAge(prenomUtilisateur);
            }
            else{
                Toast.makeText(this, "L'utilisateur " +prenomUtilisateur+ "est déja existant",Toast.LENGTH_SHORT).show();
            }

            db.close();
        }
        else{
            Toast.makeText(this, "Vous devez donner un prénom à votre utilisateur pour le créer",Toast.LENGTH_SHORT).show();

        }
    }


        private void moveToMenu(){
            Intent intent = new Intent(MenuAccountActivity.this, MainActivity.class);
            startActivity(intent);
        }
}
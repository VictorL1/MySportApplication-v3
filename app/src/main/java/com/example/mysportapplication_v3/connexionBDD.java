package com.example.mysportapplication_v3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.*;

public class connexionBDD extends AppCompatActivity
{

    //Test
    TextView n1,n2;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion_bdd);

        n1 = (TextView) findViewById(R.id.textView7);
        n2 = (TextView) findViewById(R.id.textView8);

        show = (Button) findViewById(R.id.button15);

        show.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                new Async().execute();
            }
        });

    }



    class Async extends AsyncTask<Void, Void, Void>
    {
        String records = "",error="";
        @Override
        protected Void doInBackground(Void... voids) {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/android", "root", "");

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT IdProgramme, NomProgramme FROM programme");

                while(resultSet.next()) {
                    records += resultSet.getInt(1) + " " + resultSet.getString(2) + "\n";
                }
            }

            catch(Exception e)
            {
                error = e.toString();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            n1.setText(records);

            if(error != "")
                n2.setText(error);
            super.onPostExecute(aVoid);

        }

    }


}

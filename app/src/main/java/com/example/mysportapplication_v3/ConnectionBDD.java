package com.example.mysportapplication_v3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.*;

public class ConnectionBDD extends AppCompatActivity {



    EditText text,errorText;

    Button show;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);







        text = (EditText) findViewById(R.id.editText10);

        errorText = (EditText)  findViewById(R.id.editText11);

        show = (Button) findViewById(R.id.button5);



        show.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                new Async().execute();

            }

        });

    }



    class Async extends AsyncTask<Void, Void, Void> {



        String records = "",error="";

        @Override

        protected Void doInBackground(Void... voids) {

            try

            {

                Class.forName("com.mysql.jdbc.Driver");

                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/android", "root", "");

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

        protected void onPostExecute(Void aVoid) {

            text.setText(records);

            if(!error.equals(""))

                errorText.setText(error);

            super.onPostExecute(aVoid);

        }





    }

}
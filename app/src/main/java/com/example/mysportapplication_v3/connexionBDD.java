package com.example.mysportapplication_v3;

import androidx.annotation.Nullable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class connexionBDD extends SQLiteOpenHelper
{


    private Context context;
    private static final String DATABASE_NAME = "applisport.db";
    private static final int DATABASE_VERSION = 1;
    /* Variables premiere table*/
    private static final String TABLE_NAME ="utilisateur";
    private static final String COLUMN_ID ="_id_user";
    private static final String COLUMN_NAME ="user_name";
    private static final String COLUMN_FIRSTNAME="user_firstname";
    private static final String COLUMN_AGE = "user_age";
    private static final String COLUMN_PSEUDO = "user_pseudo";
    private static final String COLUMN_MAIL = "user_mail";
    private static final String COLUMN_DATEN = "user_date_naissance";
    private static final String COLUMN_MDP = "user_password";
    private static final String COLUMN_POIDS = "user_weight";
    private static final String COLUMN_TAILLE = "user_height";
    private static final String COLUMN_SPORTIFLVL = "user_sport_lvl";
    private static final String COLUMN_ADMIN = "user_admin";
    /* Variables deuxième table*/
    private static final String TABLE_NAME2 ="programme";
    private static final String COLUMN_ID2 ="_id_programme";
    private static final String COLUMN_PROGNAME ="programme_name";
    private static final String COLUMN_DIFFICULTYLVL ="programme_lvl";
    private static final String COLUMN_TIMEMOYMIN ="programme_duree_moy_min";
    private static final String COLUMN_TIMEMOYMAX ="programme_duree_moy_max";
    /* Variables troisième table*/
    private static final String TABLE_NAME3 ="exercice";
    private static final String COLUMN_ID3 ="_id_exercice";
    private static final String COLUMN_ID4 ="_id_programme";
    private static final String COLUMN_EXONAME ="exercice_name";
    private static final String COLUMN_EXPLICATION ="exercice_explication";
    private static final String COLUMN_MUSCLETARGET ="exercice_partie_travaille";
    private static final String COLUMN_CALORIES ="exercice_calories_depensees";
    private static final String COLUMN_RISQUES ="exercice_risques";
    private static final String COLUMN_TIMEMOYMIN2 ="exercice_duree_moy_min";
    private static final String COLUMN_TIMEMOYMAX2 ="exercice_duree_moy_max";

    public connexionBDD(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION) ; // On appelle le contructeur de la super-classe
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_FIRSTNAME +  " TEXT, " +
                COLUMN_AGE +  " INTEGER, " +
                COLUMN_PSEUDO +  " TEXT, " +
                COLUMN_MAIL +  " TEXT, " +
                COLUMN_DATEN +  " DATE, " +
                COLUMN_MDP +  " TEXT, " +
                COLUMN_POIDS +  " TEXT, " +
                COLUMN_TAILLE +  " TEXT, " +
                COLUMN_SPORTIFLVL +  " TEXT, " +
                COLUMN_ADMIN +  " TEXT);";

        db.execSQL(query);
        query = "CREATE TABLE " + TABLE_NAME2 + " (" + COLUMN_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PROGNAME + " TEXT, " +
                COLUMN_DIFFICULTYLVL +  " TEXT, " +
                COLUMN_TIMEMOYMIN +  " INTEGER, " +
                COLUMN_TIMEMOYMAX +  " INTEGER);";

        db.execSQL(query);
        query = "CREATE TABLE " + TABLE_NAME3 + " (" + COLUMN_ID3 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                COLUMN_EXONAME + " TEXT, " +
                COLUMN_EXPLICATION +  " TEXT, " +
                COLUMN_MUSCLETARGET +  " TEXT, " +
                COLUMN_CALORIES +  " TEXT, " +
                COLUMN_RISQUES +  " TEXT, " +
                COLUMN_TIMEMOYMIN2 +  " DATE, " +
                COLUMN_TIMEMOYMAX2 +  " TEXT " +
                ", FOREIGN KEY (" + COLUMN_ID4 +") REFERENCES " + TABLE_NAME2 +"(" + COLUMN_ID2 + ") );"; /* Creation de la clef etrangère de programme dans exercice */

        db.execSQL(query);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        onCreate(db);
    }

/*
    public void insertUser(String user_name, String user_firstname, int user_age, String user_pseudo,
                           String user_mail, Date user_date_naissance, String user_password, String user_weight, String user_height, String user_sport_lvl)
    {
        String sql = "insert into utilisateur(user_name, user_firstname, user_age, user_pseudo, user_mail, user_date_naissance, user_password, user_weight, user_height, user_sport_lvl) values (" + user_name + ", " + user_firstname + ", " + user_age + " ," + user_pseudo + " , "+ user_mail +", "+ user_date_naissance +", "+ user_password +", "+ user_weight +", "+ user_height +", "+ user_sport_lvl + ")";
        this.getWritableDatabase().execSQL(sql);
        Log.i("DATABASE", "insertUser invoked");
    }

 */




}




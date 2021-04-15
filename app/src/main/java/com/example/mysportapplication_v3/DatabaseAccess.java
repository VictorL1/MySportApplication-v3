package com.example.mysportapplication_v3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.*;


public class DatabaseAccess {


    private static final String UTILISATEUR_NOM = "Nom";
    private static final String UTILISATEUR_TABLE_NAME = "Utilisateur";
    private static final String UTILISATEUR_AGE = "Age";


    private connexionBDD connexionBDD;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null; // Contient le résultat d'une requête effectuer dans la base de données

    // constructeur privée pour ne pas pouvoir créer cet object en dehors de la classe
    private DatabaseAccess(Context context)
    {
        this.connexionBDD = new connexionBDD(context);
    }

    //retourne l'instance de la classe
    public static DatabaseAccess getInstance(Context context){
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //ouvre la connexion à la BDD
    public void open(){
        this.db = connexionBDD.getWritableDatabase();
    }

    //ferme la connexion à la BDD
    public void close(){
        if(db != null){
            this.db.close();
        }
    }



    // Test 1ère requête
    // retourne l'âge pour un utilisateur
    public String getAge(String utilisateur){

        c = db.rawQuery("select Age from utilisateur where Nom = ?", new String[]{utilisateur});

        if(c.getCount() != 1){  // Si l'utilisateur n'existe pas, pas d'âge pour l'utilisateur donc rien ne vas être retourné et l'appli va planter
            return"erreur";     // On vérifie qu'il y a bien 1 et 1 seule réponse en comptant le nbr de résultat dans le curseur
        }
        c.moveToFirst();    // On pose le curseur sur le résultat
        return c.getString(0);  // transforme le res en chaine de caractère
    }



    public boolean existUser(String utilisateur){
        c = db.rawQuery("select " + UTILISATEUR_NOM + "from " + UTILISATEUR_TABLE_NAME + " where "+UTILISATEUR_NOM+" = ?", new String[]{utilisateur} );

        return c.getCount() == 1;
    }

    public void addUser(String utilisateur){
        ContentValues value = new ContentValues();
        value.put(UTILISATEUR_NOM, utilisateur);
        value.put(UTILISATEUR_AGE, 0);
        long l = db.insert(UTILISATEUR_TABLE_NAME, null, value);

    }
}

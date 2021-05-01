package com.example.projetfinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;

public class MyHelper  extends SQLiteOpenHelper {
    static final String DB_NAME = "Infospersonnel.db";
    static final String DB_VERSION = "1";
    public MyHelper(Context context) {
        super( context, DB_NAME, null, Integer.parseInt( DB_VERSION ) );
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE profil(id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT, prenom TEXT, mail TEXT, adresse TEXT, tel TEXT)";
        sqLiteDatabase.execSQL( sql );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void callCreateDatabase(){
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        Log.i(TAG, "Cretion de ma base de données réussie ... ");
    }
}

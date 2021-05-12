package com.example.schatzsuche;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Datenbank extends SQLiteOpenHelper {

    public Datenbank(Context c){
        super(c,"Person", null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String p1 = "create table Person (ID integer primary key autoincrement" + ", name text not null)";
        db.execSQL(p1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Person");
    }
}

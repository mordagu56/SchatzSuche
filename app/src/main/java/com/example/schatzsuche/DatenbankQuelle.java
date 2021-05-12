package com.example.schatzsuche;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class DatenbankQuelle implements SearchPerson{
    SQLiteDatabase db;
    Datenbank datenbank;

    public DatenbankQuelle(Context context) {
       datenbank = new Datenbank(context);
    }

    public void open(){
        db = datenbank.getReadableDatabase();

    }

    public void close(){
        datenbank.close();

    }
    public void createPerson(){
        String names[] = { "Helmut", "Martin", "Stephani"," Janachek", "Gerhard"," Maria", "Böhmer"};
        String dersler [] = {"ads","prg1","prg2","math", "statistik","hci","tgs","dse", "swe1"};
        Random r = new Random();
        int ras = r.nextInt(6);
        Vector<String>v = new Vector();
        v.add(dersler[ras]);
        v.add(dersler[ras]);
        v.add(dersler[ras]);
        Person p1 = new Person(r.nextInt(5000), names[ras], names[ras]+"@hotmail.com", "06767854521", "10-18", v);
        ContentValues val = new ContentValues();
        val.put("name", p1.getName());
        db.insert("Person", null, val);

    }

    public List<Person> liste (){
        String names[] = { "Helmut", "Martin", "Stephani"," Janachek", "Gerhard"," Maria", "Böhmer"};
        String dersler [] = {"ads","prg1","prg2","math", "statistik","hci","tgs","dse", "swe1"};
        Random r = new Random();
        int ras = r.nextInt(6);
        String kolonlar [] ={"id", "name"};
        List<Person> list = new ArrayList<Person>();

        Cursor c = db.query("Person", kolonlar, null, null, null, null, null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            int id = c.getInt(0);
            String name = c.getString(1);
            Vector<String>v = new Vector();
            v.add(dersler[r.nextInt(8)]);
            v.add(dersler[r.nextInt(8)]);
            v.add(dersler[r.nextInt(8)]);
            Person p1 = new Person(r.nextInt(5000), names[ras], names[ras]+"@hotmail.com", "06767854521", "10-18", v);
            list.add(p1);
            c.moveToNext();
        }
        c.close();
        return list;
    }

    @Override
    public Vector<Person> getPerson(String s) {
  //degisiklilker
        return null;
    }
}

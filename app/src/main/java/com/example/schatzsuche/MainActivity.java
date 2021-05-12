package com.example.schatzsuche;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends ListActivity {
    String data;
    DatenbankQuelle db;
    EditText et;
    Button createPerson;
    Button search;
    Person p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.editTextTextPersonName2);
        createPerson = findViewById(R.id.button);
        search = findViewById(R.id.searchButton);
        db = new DatenbankQuelle(this);
        db.open();
        createPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = et.getText().toString();
                db.getPerson(data);
            }
        });

        List<Person> personen = db.liste();
        ArrayAdapter<Person>adapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1, personen );
        setListAdapter(adapter);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.createPerson();
                Log.d("buarada", "buradad");
            }
        });
    }


}
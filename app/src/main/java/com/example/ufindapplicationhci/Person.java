package com.example.ufindapplicationhci;

import java.util.Vector;

public class Person {
    // Instanzvariablen
    private String name, mail, fax, officehours;
    private Vector<String> lehrveranstaltungen;

    // Konstruktor
    public Person(String n, String m, String f, String o, Vector<String> lv) {
        name = n;
        mail = m;
        fax = f;
        officehours = o;
        lehrveranstaltungen = lv;
    }

    // Getter Methoden
    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getFax() {
        return fax;
    }

    public String getOfficehours() {
        return officehours;
    }

    public Vector<String> getLehrveranstaltungen() {
        return lehrveranstaltungen;
    }
}

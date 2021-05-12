package com.example.schatzsuche;

import java.util.Vector;

public class Person {
    private int personID;
    private String name;
    private String mail;
    private String fax;
    private String officeHours;
    private Vector<String> lehrveranstaltungen;

    public Person(int personID, String name, String mail, String fax, String officeHours, Vector<String> lehrveranstaltungen) {
        this.personID = personID;
        this.name = name;
        this.mail = mail;
        this.fax = fax;
        this.officeHours = officeHours;
        this.lehrveranstaltungen = lehrveranstaltungen;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getFax() {
        return fax;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public Vector<String> getLehrveranstaltungen() {
        return lehrveranstaltungen;
    }




    @Override
    public String toString() {
        return "Lehrveranstaltungsleiter" + "\n" +
                "personID :" + personID + "\n"+
                "name :'" + name + '\'' + "\n" +
                "mail :" + mail + "\n" +
                "fax :'" + fax + "\n" +
                "officeHours :" + officeHours + "\n" +
                "lehrveranstaltungen :" + lehrveranstaltungen;

    }


}

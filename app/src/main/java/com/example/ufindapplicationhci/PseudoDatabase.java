package com.example.ufindapplicationhci;

import java.util.Vector;

public class PseudoDatabase {
    // s ist die Eingabe vom User, returnt wird ein Vector aller Personen, die diese Eingabe enthalten
    public Vector<Person> getPerson(String s) throws Exception {
        Vector<Person> result = new Vector<Person>();

        //PSEUDO DATENBANK: in der realen App wären Namen, Mailadressen etc aus einer Datenbank abzurufen
        // Hier wird eine Liste aller Prof. und Ass.-Prof. der Fakultät für Informatik abgefragt
        // Wenn der gesuchte Name in dieser Liste enthalten ist, gilt dies als "Hit"
        String[] possibleNames = {"Ivo Hofacker", "Arndt von Haeseler", "Monika Henzinger", "Stefan Schmid", "Peter Reichl", "Karl Anton Fröschl", "Torsten Möller", "Claudi Plant", "Sebastian Tschiatschek", "Benjamin Roth", "Nils Morten Kriege", "Helmut Hlavacs", "Renate Motschnig", "Günter Haring", "Dimitris Karagiannis", "Wolfgang Klas", "Gerald Quirchmayr", "A Min Tjoa", "Erich Neuhold", "Moritz Grosse-Wentrup", "Edgar Weippl", "Siegfried Benkner", "Eduard Mehofer", "Hans Zima", "Uwe Zdun", "Monika Henzinger", "Wilfried Gansterer", "Erich Schikuta", "Maria Leitner", "Martin Polaschek", "Maria Knobelsdorf", "Erich Neuwirth", "Gabriele Uchida", "Christian Cenker"};
        Vector<String> personsFound = new Vector<String>();

        // Prüfe, ob der gesuchte Name enthalten ist
        for(int i = 0; i < possibleNames.length; i++) {
            if(possibleNames[i].contains(s)) {
                personsFound.add(possibleNames[i]);
            }
        }

        // Es wurde keine Person gefunden: Error
        if(personsFound.isEmpty()) throw new Exception("Person kann nicht gefunden werden");

        // PSEUDO FUNKTION: Rufe Daten für Person ab und füge die Personen in den result Vector ein
        for(int i = 0; i < personsFound.size(); i++) {
            Vector<String> lv = new Vector<String>();
            lv.add("Lehrveranstaltung 1");
            lv.add("Lehrveranstaltung 2");
            lv.add("Lehrveranstaltung 3");
            String name = personsFound.elementAt(i);
            Person p = new Person(name, "mustermail@univie.ac.at", "+43 100 200 300", "Sonntag, 18 Uhr", lv);

            result.add(p);
        }

        // returne den Vector an gefundenen Personen
        return result;
    }

    // s ist die Eingabe vom User, returnt wird ein Vector aller Veranstaltungen, die diese Eingabe enthalten
    public Vector<Veranstaltung> getVeranstaltung(String s) throws Exception {
        Vector<Veranstaltung> result = new Vector<Veranstaltung>();
        String[] possibleNames = {"OV Orientierungsveranstaltung","VU Programmierung 1","VO Technische Grundlagen der Informatik","PUE Repetitorium Technische Grundlagen der Informatik","VO Mathematische Grundlagen der Informatik 1","PUE Repetitorium Mathematische Grundlagen der Informatik 1","VO Theoretische Informatik","PUE Repetitorium Theoretische Informatik","VU Programmierung 2","VU Modellierung","VO Betriebssysteme","UE Betriebssysteme","VU Algorithmen und Datenstrukturen 1","VU Database Systems","VU Software Engineering 1","VU Informationssicherheit","VO Informatik und Recht","VU Informatik und Gesellschaft","VU Projektmanagement","VU Mensch-Computer-Interaktion","VO Mathematische Grundlagen der Informatik 2","UE Mathematische Grundlagen der Informatik 2","VO Einführung in Mathematische Modellierung","UE Einführung in Mathematische Modellierung","VU Algorithms and Data Structures 2","VU Numerical Algorithms","VU Software Tools and Libraries for Scientific Computing","VU Algorithms for Software Protection","Foundations of Computer Graphics","VU Cloud Gaming","VU Advanced Topics in Computer Graphics - Real-Time Ray Tracing","VU Foundations of Data Analysis","VU Natural Language Processing","VU Scientific Data Management","VU Mining Massive Data","VU Information Management & Systems Engineering","VU Business Intelligence I","VU Multimedia Content Management","VU Distributed Systems Engineering","VU Interoperability","VU Signal and Image Processing","VU Multimedia and Semantic Technologies","VU Cooperative Systems","VU Network-Based Communication Ecosystems","VO Network Security","UE Network Security","VU Parallel Computing","VU High Performance Computing","VU Program Optimisations and Runtime Systems","Softwarepraktikum mit Bachelorarbeit"};
        Vector<String> eventsFound = new Vector<String>();

        // Prüfe, ob der gesuchte Name enthalten ist
        for(int i = 0; i < possibleNames.length; i++) {
            if(possibleNames[i].contains(s)) {
                eventsFound.add(possibleNames[i]);
            }
        }

        // Es wurde keine Veranstaltung gefunden: Error
        if(eventsFound.isEmpty()) throw new Exception("Veranstaltung kann nicht gefunden werden");

        // PSEUDO FUNKTION: Rufe Daten für Veranstaltung ab und füge die Veranstaltung in den result Vector ein
        for(int i = 0; i < eventsFound.size(); i++) {
            String motivation = "Hier steht die Motivation. Hier steht die Motivation. Hier steht die Motivation. Hier steht die Motiation.";
            String minimum = "Hier steht die Mindestleistung. Hier steht die Mindestleistung. Hier steht die Mindestleistung. Hier steht die Mindestleistung.";
            String assessment = "Hier stehen die Beurteilungskriterien. Hier stehen die Beurteilungskriterien. Hier stehen die Beurteilungskriterien. Hier stehen die Beurteilungskriterien.";
            int ECTS = 6;
            Vector<String> programme = new Vector<String>();
            Vector<String> vortragende = new Vector<String>();
            Vector<String> termine = new Vector<String>();
            programme.add("Bachelor Informatik - Allgemein");
            programme.add("Bachelor Informatik - Data Science");
            vortragende.add("VortragendeR Eins");
            vortragende.add("VortragendeR Zwei");

            // Hier die Termine smart hinzufügen, damit sie später für Semesterplanung genutzt werden können
            for(int j = 10; j < 40; j++) {
                if(eventsFound.elementAt(i).length() > j) {
                    String termin = "Termin " + String.valueOf(j);
                    termine.add(termin);
                }
            }

            // Veranstaltung erzeugen und an result übergeben
            String name = eventsFound.elementAt(i);
            Veranstaltung v = new Veranstaltung(name, motivation, minimum, assessment, ECTS, programme, vortragende, termine);

            result.add(v);
        }

        return result;
    }
}

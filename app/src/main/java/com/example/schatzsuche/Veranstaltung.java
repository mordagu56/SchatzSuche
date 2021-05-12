package com.example.schatzsuche;

import java.util.Vector;

public class Veranstaltung {
    private String name;
    private int ECTS;
    private Vector<String> programme;
    private Vector<String>vortagende;
    private String motivation;
    private String minimum;
    private String assessment;

    public Veranstaltung(String name, int ECTS, Vector<String> programme, Vector<String> vortagende, String motivation, String minimum, String assessment) {
        this.name = name;
        this.ECTS = ECTS;
        this.programme = programme;
        this.vortagende = vortagende;
        this.motivation = motivation;
        this.minimum = minimum;
        this.assessment = assessment;
    }

    public String getName() {
        return name;
    }

    public int getECTS() {
        return ECTS;
    }

    public Vector<String> getProgramme() {
        return programme;
    }

    public Vector<String> getVortagende() {
        return vortagende;
    }

    public String getMotivation() {
        return motivation;
    }

    public String getMinimum() {
        return minimum;
    }

    public String getAssessment() {
        return assessment;
    }
}

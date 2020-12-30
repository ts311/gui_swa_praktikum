package com.example.gui_swa_praktikum.model;

import java.util.Date;

public class Meeting {

    private int terminId;

    private String name;

    private String beschreibung;

    private String ort;

    private String frequenz;

    private Date datum_von;

    private Date datum_bis;

    private int kategorieId;

    public int getTerminId() {
        return terminId;
    }

    public void setTerminId(int terminId) {
        this.terminId = terminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getFrequenz() {
        return frequenz;
    }

    public void setFrequenz(String frequenz) {
        this.frequenz = frequenz;
    }

    public Date getDatum_von() {
        return datum_von;
    }

    public void setDatum_von(Date datum_von) {
        this.datum_von = datum_von;
    }

    public Date getDatum_bis() {
        return datum_bis;
    }

    public void setDatum_bis(Date datum_bis) {
        this.datum_bis = datum_bis;
    }

    public int getKategorieId() {
        return kategorieId;
    }

    public void setKategorieId(int kategorieId) {
        this.kategorieId = kategorieId;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "terminId=" + terminId +
                ", name='" + name + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                ", ort='" + ort + '\'' +
                ", frequenz='" + frequenz + '\'' +
                ", datum_von=" + datum_von +
                ", datum_bis=" + datum_bis +
                ", kategorieId=" + kategorieId +
                '}';
    }
}

package com.toboza;

public class Item {
    long id;
    String refka;
    String nazwa;
    String uom;
    double cena;

    @Override
    public String toString() {
        return id + "  "+refka + "  "+nazwa + "  "+uom + "  "+cena;
    }

    public Item(long id, String refka, String nazwa, String uom, double cena) {
        this.id = id;
        this.refka = refka;
        this.nazwa = nazwa;
        this.uom = uom;
        this.cena = cena;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRefka() {
        return refka;
    }

    public void setRefka(String refka) {
        this.refka = refka;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}

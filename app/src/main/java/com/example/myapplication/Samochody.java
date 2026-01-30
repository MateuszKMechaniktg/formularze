package com.example.myapplication;

public class Samochody {
    private Integer cena;
    private String marka;
    private String model;
    private Integer rok;
    private boolean wlasciciel;
    private String historia;

    public Samochody(Integer cena, String marka, String model, Integer rok, boolean wlasciciel, String historia) {
        this.cena = cena;
        this.marka = marka;
        this.model = model;
        this.rok = rok;
        this.wlasciciel = wlasciciel;
        this.historia = historia;
    }

    @Override
    public String toString() {
        return "Cena: "+cena + "zł\n" +
                "Marka: "+marka + "\n" +
                "Model: "+model + "\n" +
                "rok: "+rok + "\n" +
                "Pierwszy właściciel: "+(wlasciciel ? "tak":"nie")+"\n" +
                "Historia: "+historia;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public boolean isWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(boolean wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public Integer getrok() {
        return rok;
    }

    public void setrok(Integer rok) {
        this.rok = rok;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public Integer getCena() {
        return cena;
    }

    public void setCena(Integer cena) {
        this.cena = cena;
    }
}

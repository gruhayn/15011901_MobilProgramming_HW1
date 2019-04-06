package com.example.mobilodev1.Entity;

public class Ders {
    private String ad;
    private String kod;
    private int alanOgrSayi;
    private float not;

    public Ders(String ad, String kod, int alanOgrSayi, float not) {
        this.ad = ad;
        this.kod = kod;
        this.alanOgrSayi = alanOgrSayi;
        this.not = not;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public int getAlanOgrSayi() {
        return alanOgrSayi;
    }

    public void setAlanOgrSayi(int alanOgrSayi) {
        this.alanOgrSayi = alanOgrSayi;
    }

    public float getNot() {
        return not;
    }

    public void setNot(float not) {
        this.not = not;
    }
}

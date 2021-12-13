package com.codegym.model;

public class Dictionary {
    private String Eng;
    private String Viet;

    public Dictionary() {
    }

    public Dictionary(String eng, String viet) {
        Eng = eng;
        Viet = viet;
    }

    public String getEng() {
        return Eng;
    }

    public void setEng(String eng) {
        Eng = eng;
    }

    public String getViet() {
        return Viet;
    }

    public void setViet(String viet) {
        Viet = viet;
    }
}

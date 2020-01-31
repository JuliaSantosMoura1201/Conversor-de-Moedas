package com.julia.conversordemoedas.model;

public class Modelo {

    Rates rates = new Rates();

    private String base;
    private String date;

    public Rates getRates(){return  rates;}


    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }
}

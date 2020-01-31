package com.julia.conversordemoedas.model;

public class Item {

    private String rate;
    private String rate2;
    private String valDig;
    private String valFinal;

    public Item() {
    }

    public Item(String rate, String rate2, String valDig, String valFinal) {
        this.rate = rate;
        this.rate2 = rate2;
        this.valDig = valDig;
        this.valFinal = valFinal;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getRate2() {
        return rate2;
    }

    public void setRate2(String rate2) {
        this.rate2 = rate2;
    }

    public String getValDig() {
        return valDig;
    }

    public void setValDig(String valDig) {
        this.valDig = valDig;
    }

    public String getValFinal() {
        return valFinal;
    }

    public void setValFinal(String valFinal) {
        this.valFinal = valFinal;
    }
}
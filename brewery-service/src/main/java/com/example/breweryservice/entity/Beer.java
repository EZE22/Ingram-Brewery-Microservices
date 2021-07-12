package com.example.breweryservice.entity;

import java.math.BigInteger;

public class Beer {
    private BigInteger beerid;
    private String beername;
    private String brewdate;
    private double alcoholpercent;
    private int quantityonhand;

    public Beer() {
    }

    public BigInteger getBeerid() {
        return beerid;
    }

    public void setBeerid(BigInteger beerid) {
        this.beerid = beerid;
    }

    public String getBeername() {
        return beername;
    }

    public void setBeername(String beername) {
        this.beername = beername;
    }

    public String getBrewdate() {
        return brewdate;
    }

    public void setBrewdate(String brewdate) {
        this.brewdate = brewdate;
    }

    public double getAlcoholpercent() {
        return alcoholpercent;
    }

    public void setAlcoholpercent(double alcoholpercent) {
        this.alcoholpercent = alcoholpercent;
    }

    public int getQuantityonhand() {
        return quantityonhand;
    }

    public void setQuantityonhand(int quantityonhand) {
        this.quantityonhand = quantityonhand;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "beerid=" + beerid +
                ", beername='" + beername + '\'' +
                ", brewdate='" + brewdate + '\'' +
                ", alcoholpercent=" + alcoholpercent +
                ", quantityonhand=" + quantityonhand +
                '}';
    }
}

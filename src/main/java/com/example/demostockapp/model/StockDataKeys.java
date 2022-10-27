package com.example.demostockapp.model;

import java.io.Serializable;

//to create composite keys in JPA, create separate class which implements serializable
public class StockDataKeys implements Serializable {
    private int quarter;
    private String stock;
    private String date;

    public StockDataKeys()
    {
        //default constructor
    }

    public StockDataKeys(final int quarter, final String stock, final String date) {
        this.quarter = quarter;
        this.stock = stock;
        this.date = date;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

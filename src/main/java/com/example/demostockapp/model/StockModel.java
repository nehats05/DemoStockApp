package com.example.demostockapp.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stockdata")
@IdClass(StockDataKeys.class)       // to create composite keys in JPA
public class StockModel implements Serializable
{
    @Id
    private int quarter;
    @Id
    private String stock;
    @Id
    private String date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
    private double percent_change_price;

    @Column(name = "percent_change_volume_over_last_wk")
    private double percent_ch_vol_last_week;

    private double previous_weeks_volume;
    private double next_weeks_open;
    private double next_weeks_close;

    @Column(name = "percent_change_next_weeks_price")
    private double percent_ch_nxt_wk_price;

    private int days_to_next_dividend;

    @Column(name = "percent_return_next_dividend")
    private double percent_rt_nxt_dividend;

    public StockModel() {
        //default constructor
    }

    public StockModel(final int quarter, final String stock, final String date, final double open,
                      final double high, final double low, final double close, final double volume,
                      final double percent_change_price, final double percent_ch_vol_last_week, final double previous_weeks_volume,
                      final double next_weeks_open, final double next_weeks_close,
                      final double percent_ch_nxt_wk_price, final int days_to_next_dividend, final double percent_rt_nxt_dividend) {
        this.quarter = quarter;
        this.stock = stock;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.percent_change_price = percent_change_price;
        this.percent_ch_vol_last_week = percent_ch_vol_last_week;
        this.previous_weeks_volume = previous_weeks_volume;
        this.next_weeks_open = next_weeks_open;
        this.next_weeks_close = next_weeks_close;
        this.percent_ch_nxt_wk_price = percent_ch_nxt_wk_price;
        this.days_to_next_dividend = days_to_next_dividend;
        this.percent_rt_nxt_dividend = percent_rt_nxt_dividend;
    }

    public int getQuarter() {
        return this.quarter;
    }

    public void setQuarter(final int quarter) {
        this.quarter = quarter;
    }

    public String getStock() {
        return this.stock;
    }

    public void setStock(final String stock) {
        this.stock = stock;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(final String date) {
        this.date = date;
    }

    public double getOpen() {
        return this.open;
    }

    public void setOpen(final double open) {
        this.open = open;
    }

    public double getHigh() {
        return this.high;
    }

    public void setHigh(final double high) {
        this.high = high;
    }

    public double getLow() {
        return this.low;
    }

    public void setLow(final double low) {
        this.low = low;
    }

    public double getClose() {
        return this.close;
    }

    public void setClose(final double close) {
        this.close = close;
    }

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(final double volume) {
        this.volume = volume;
    }

    public double getPercent_change_price() {
        return this.percent_change_price;
    }

    public void setPercent_change_price(final double percent_change_price) {
        this.percent_change_price = percent_change_price;
    }

    public double getPercent_ch_vol_last_week() {
        return this.percent_ch_vol_last_week;
    }

    public void setPercent_ch_vol_last_week(final double percent_ch_vol_last_week) {
        this.percent_ch_vol_last_week = percent_ch_vol_last_week;
    }

    public double getPrevious_weeks_volume() {
        return this.previous_weeks_volume;
    }

    public void setPrevious_weeks_volume(final double previous_weeks_volume) {
        this.previous_weeks_volume = previous_weeks_volume;
    }

    public double getNext_weeks_open() {
        return this.next_weeks_open;
    }

    public void setNext_weeks_open(final double next_weeks_open) {
        this.next_weeks_open = next_weeks_open;
    }

    public double getNext_weeks_close() {
        return this.next_weeks_close;
    }

    public void setNext_weeks_close(final double next_weeks_close) {
        this.next_weeks_close = next_weeks_close;
    }

    public double getPercent_ch_nxt_wk_price() {
        return this.percent_ch_nxt_wk_price;
    }

    public void setPercent_ch_nxt_wk_price(final double percent_ch_nxt_wk_price) {
        this.percent_ch_nxt_wk_price = percent_ch_nxt_wk_price;
    }

    public int getDays_to_next_dividend() {
        return this.days_to_next_dividend;
    }

    public void setDays_to_next_dividend(final int days_to_next_dividend) {
        this.days_to_next_dividend = days_to_next_dividend;
    }

    public double getPercent_rt_nxt_dividend() {
        return this.percent_rt_nxt_dividend;
    }

    public void setPercent_rt_nxt_dividend(final double percent_rt_nxt_dividend) {
        this.percent_rt_nxt_dividend = percent_rt_nxt_dividend;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
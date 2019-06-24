package com.obpoo.gfsfabricsoftware.Dashboard.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 1/16/2019.
 */

public class RateResponse {
    @SerializedName("rates")
    @Expose
    private RateData rates;
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("date")
    @Expose
    private String date;

    public RateData getRates() {
        return rates;
    }

    public void setRates(RateData rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}

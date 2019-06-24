package com.obpoo.gfsfabricsoftware.Dashboard.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 1/15/2019.
 */

public class Analytic {
    @SerializedName("stock_in")
    @Expose
    private String stockIn;
    @SerializedName("total_remain")
    @Expose
    private String totalRemain;
    @SerializedName("stock_out")
    @Expose
    private String stockOut;
    @SerializedName("MonthYear")
    @Expose
    private String monthYear;

    public String getStockIn() {
        return stockIn;
    }

    public void setStockIn(String stockIn) {
        this.stockIn = stockIn;
    }

    public String getTotalRemain() {
        return totalRemain;
    }

    public void setTotalRemain(String totalRemain) {
        this.totalRemain = totalRemain;
    }

    public String getStockOut() {
        return stockOut;
    }

    public void setStockOut(String stockOut) {
        this.stockOut = stockOut;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }
}

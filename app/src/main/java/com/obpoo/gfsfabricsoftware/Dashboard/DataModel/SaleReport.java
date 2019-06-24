package com.obpoo.gfsfabricsoftware.Dashboard.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 1/15/2019.
 */

public class SaleReport {
    @SerializedName("income_this_month")
    @Expose
    private String incomeThisMonth;
    @SerializedName("pending_this_month")
    @Expose
    private String pendingThisMonth;
    @SerializedName("vat_this_month")
    @Expose
    private String vatThisMonth;
    @SerializedName("MonthYear")
    @Expose
    private String monthYear;

    public String getIncomeThisMonth() {
        return incomeThisMonth;
    }

    public void setIncomeThisMonth(String incomeThisMonth) {
        this.incomeThisMonth = incomeThisMonth;
    }

    public String getPendingThisMonth() {
        return pendingThisMonth;
    }

    public void setPendingThisMonth(String pendingThisMonth) {
        this.pendingThisMonth = pendingThisMonth;
    }

    public String getVatThisMonth() {
        return vatThisMonth;
    }

    public void setVatThisMonth(String vatThisMonth) {
        this.vatThisMonth = vatThisMonth;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String monthYear) {
        this.monthYear = monthYear;
    }
}

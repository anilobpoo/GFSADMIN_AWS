package com.obpoo.gfsfabricsoftware.Dashboard.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 1/15/2019.
 */

public class IncomeDeposits {
    @SerializedName("total_income")
    @Expose
    private String totalIncome;
    @SerializedName("total_pending")
    @Expose
    private String totalPending;
    @SerializedName("total_vat")
    @Expose
    private String totalVat;
    @SerializedName("income_this_month")
    @Expose
    private String incomeThisMonth;
    @SerializedName("pending_this_month")
    @Expose
    private String pendingThisMonth;
    @SerializedName("vat_this_month")
    @Expose
    private String vatThisMonth;
    @SerializedName("collection_this_month")
    @Expose
    private Double collectionThisMonth;

    public String getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(String totalIncome) {
        this.totalIncome = totalIncome;
    }

    public String getTotalPending() {
        return totalPending;
    }

    public void setTotalPending(String totalPending) {
        this.totalPending = totalPending;
    }

    public String getTotalVat() {
        return totalVat;
    }

    public void setTotalVat(String totalVat) {
        this.totalVat = totalVat;
    }

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

    public Double getCollectionThisMonth() {
        return collectionThisMonth;
    }

    public void setCollectionThisMonth(Double collectionThisMonth) {
        this.collectionThisMonth = collectionThisMonth;
    }

}

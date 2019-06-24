package com.obpoo.gfsfabricsoftware.Dashboard.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PHD on 1/15/2019.
 */

public class Data {
    @SerializedName("incomeDeposits")
    @Expose
    private IncomeDeposits incomeDeposits;
    @SerializedName("OrderCounts")
    @Expose
    private ArrayList<OrderCount> orderCounts = null;
    @SerializedName("poList")
    @Expose
    private ArrayList<PoList> poList = null;
    @SerializedName("saleReport")
    @Expose
    private ArrayList<SaleReport> saleReport = null;
    @SerializedName("fabricReport")
    @Expose
    private ArrayList<FabricReport> fabricReport = null;
    @SerializedName("analytics")
    @Expose
    private List<Analytic> analytics = null;

    public IncomeDeposits getIncomeDeposits() {
        return incomeDeposits;
    }

    public void setIncomeDeposits(IncomeDeposits incomeDeposits) {
        this.incomeDeposits = incomeDeposits;
    }

    public ArrayList<OrderCount> getOrderCounts() {
        return orderCounts;
    }

    public void setOrderCounts(ArrayList<OrderCount> orderCounts) {
        this.orderCounts = orderCounts;
    }

    public ArrayList<PoList> getPoList() {
        return poList;
    }

    public void setPoList(ArrayList<PoList> poList) {
        this.poList = poList;
    }

    public ArrayList<SaleReport> getSaleReport() {
        return saleReport;
    }

    public void setSaleReport(ArrayList<SaleReport> saleReport) {
        this.saleReport = saleReport;
    }

    public ArrayList<FabricReport> getFabricReport() {
        return fabricReport;
    }

    public void setFabricReport(ArrayList<FabricReport> fabricReport) {
        this.fabricReport = fabricReport;
    }

    public List<Analytic> getAnalytics() {
        return analytics;
    }

    public void setAnalytics(List<Analytic> analytics) {
        this.analytics = analytics;
    }

}

package com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 2/21/2019.
 */

public class FabricGraphResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<FabricResponseDetails> data = null;
    @SerializedName("1month_expected_order")
    @Expose
    private Integer _1monthExpectedOrder;
    @SerializedName("2month_expected_order")
    @Expose
    private Integer _2monthExpectedOrder;
    @SerializedName("3month_expected_order")
    @Expose
    private Integer _3monthExpectedOrder;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<FabricResponseDetails> getData() {
        return data;
    }

    public void setData(ArrayList<FabricResponseDetails> data) {
        this.data = data;
    }

    public Integer get1monthExpectedOrder() {
        return _1monthExpectedOrder;
    }

    public void set1monthExpectedOrder(Integer _1monthExpectedOrder) {
        this._1monthExpectedOrder = _1monthExpectedOrder;
    }

    public Integer get2monthExpectedOrder() {
        return _2monthExpectedOrder;
    }

    public void set2monthExpectedOrder(Integer _2monthExpectedOrder) {
        this._2monthExpectedOrder = _2monthExpectedOrder;
    }

    public Integer get3monthExpectedOrder() {
        return _3monthExpectedOrder;
    }

    public void set3monthExpectedOrder(Integer _3monthExpectedOrder) {
        this._3monthExpectedOrder = _3monthExpectedOrder;
    }
}

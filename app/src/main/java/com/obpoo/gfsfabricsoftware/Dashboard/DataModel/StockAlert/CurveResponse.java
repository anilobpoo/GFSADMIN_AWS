package com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 1/18/2019.
 */

public class CurveResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<CurveData> data = null;

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

    public ArrayList<CurveData> getData() {
        return data;
    }

    public void setData(ArrayList<CurveData>  data) {
        this.data = data;
    }
}

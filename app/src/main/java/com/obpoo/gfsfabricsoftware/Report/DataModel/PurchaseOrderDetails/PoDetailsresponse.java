package com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 2/22/2019.
 */

public class PoDetailsresponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<PoDetailsRespoDet> data = null;

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

    public ArrayList<PoDetailsRespoDet> getData() {
        return data;
    }

    public void setData(ArrayList<PoDetailsRespoDet> data) {
        this.data = data;
    }

}

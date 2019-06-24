package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 11/23/2018.
 */

public class poPOJO {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<poDatum> data = null;

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

    public ArrayList<poDatum> getData() {
        return data;
    }

    public void setData(ArrayList<poDatum> data) {
        this.data = data;
    }
}

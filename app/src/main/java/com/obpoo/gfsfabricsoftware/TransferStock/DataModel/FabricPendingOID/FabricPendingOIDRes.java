package com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 2/7/2019.
 */

public class FabricPendingOIDRes {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<FabricPendingOIDdetail> data = null;

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

    public ArrayList<FabricPendingOIDdetail> getData() {
        return data;
    }

    public void setData(ArrayList<FabricPendingOIDdetail> data) {
        this.data = data;
    }
}

package com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 2/21/2019.
 */

public class FabricHistoryResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<FabricHistoryDetails> data = null;

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

    public ArrayList<FabricHistoryDetails> getData() {
        return data;
    }

    public void setData(ArrayList<FabricHistoryDetails> data) {
        this.data = data;
    }
}

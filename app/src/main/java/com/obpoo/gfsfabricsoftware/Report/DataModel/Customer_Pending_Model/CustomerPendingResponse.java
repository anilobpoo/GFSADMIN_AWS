package com.obpoo.gfsfabricsoftware.Report.DataModel.Customer_Pending_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 2/19/2019.
 */

public class CustomerPendingResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<CustomerPendingDetails> data = null;

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

    public ArrayList<CustomerPendingDetails> getData() {
        return data;
    }

    public void setData(ArrayList<CustomerPendingDetails> data) {
        this.data = data;
    }
}

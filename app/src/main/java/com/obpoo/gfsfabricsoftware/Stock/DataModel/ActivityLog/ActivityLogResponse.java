package com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 2/4/2019.
 */

public class ActivityLogResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<ActivityLogResDet> data = null;

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

    public ArrayList<ActivityLogResDet> getData() {
        return data;
    }

    public void setData(ArrayList<ActivityLogResDet> data) {
        this.data = data;
    }

}

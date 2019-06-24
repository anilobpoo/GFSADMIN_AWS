package com.obpoo.gfsfabricsoftware.PUG.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 12/7/2018.
 */

public class NLData {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<NLdataItems> data = null;

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

    public ArrayList<NLdataItems> getData() {
        return data;
    }

    public void setData(ArrayList<NLdataItems> data) {
        this.data = data;
    }
}

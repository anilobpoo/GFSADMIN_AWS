package com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.AddCAG;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 11/20/2018.
 */

public class addCagPOJO {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<AddCadPOJOdata> data = null;

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

    public ArrayList<AddCadPOJOdata> getData() {
        return data;
    }

    public void setData(ArrayList<AddCadPOJOdata> data) {
        this.data = data;
    }
}

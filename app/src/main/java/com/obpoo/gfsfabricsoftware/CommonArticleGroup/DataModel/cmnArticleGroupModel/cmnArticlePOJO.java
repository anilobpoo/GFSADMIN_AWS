package com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.cmnArticleGroupModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 11/19/2018.
 */

public class cmnArticlePOJO {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<cmnArticelPOJOdata> data = null;

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

    public ArrayList<cmnArticelPOJOdata> getData() {
        return data;
    }

    public void setData(ArrayList<cmnArticelPOJOdata> data) {
        this.data = data;
    }

}

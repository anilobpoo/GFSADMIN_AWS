package com.obpoo.gfsfabricsoftware.Article.DataModel.FabricType;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by obpoo on 11/16/2018.
 */

public class fabricTypePOJO {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<FabricTypePOJOArrayData> data = null;

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

    public ArrayList<FabricTypePOJOArrayData> getData() {
        return data;
    }

    public void setData(ArrayList<FabricTypePOJOArrayData> data) {
        this.data = data;
    }
}

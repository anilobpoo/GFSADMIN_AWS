package com.obpoo.gfsfabricsoftware.salesorder.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CustomerDetailOrder {


    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("data")
    @Expose
    private ArrayList<CustomerDetailData> data;

    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<CustomerDetailData> getData() {
        return data;
    }

    public void setData(ArrayList<CustomerDetailData> data) {
        this.data = data;
    }
}

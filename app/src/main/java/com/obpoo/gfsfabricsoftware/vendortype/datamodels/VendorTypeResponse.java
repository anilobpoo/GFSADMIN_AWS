package com.obpoo.gfsfabricsoftware.vendortype.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class VendorTypeResponse {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private ArrayList<VendorTypeDetail> detail;

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


    public ArrayList<VendorTypeDetail> getDetail() {
        return detail;
    }

    public void setDetail(ArrayList<VendorTypeDetail> detail) {
        this.detail = detail;
    }
}

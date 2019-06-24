package com.obpoo.gfsfabricsoftware.Report.DataModel.PO_Fabric_List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 2/26/2019.
 */

public class PO_Fabric_Response {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<PO_fabric_response_details> data = null;

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

    public ArrayList<PO_fabric_response_details> getData() {
        return data;
    }

    public void setData(ArrayList<PO_fabric_response_details> data) {
        this.data = data;
    }

}

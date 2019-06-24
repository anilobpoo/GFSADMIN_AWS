package com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 2/18/2019.
 */

public class CustomerDetails {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private CustomerDetailedData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerDetailedData getData() {
        return data;
    }

    public void setData(CustomerDetailedData data) {
        this.data = data;
    }
}

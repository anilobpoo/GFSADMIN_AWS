package com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 1/3/2019.
 */

public class PacketDetails {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private ArrayList<PacketDetailsList> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<PacketDetailsList> getData() {
        return data;
    }

    public void setData(ArrayList<PacketDetailsList> data) {
        this.data = data;
    }
}

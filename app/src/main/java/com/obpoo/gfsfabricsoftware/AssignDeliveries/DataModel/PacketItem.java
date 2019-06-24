package com.obpoo.gfsfabricsoftware.AssignDeliveries.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 1/3/2019.
 */

public class PacketItem {
    @SerializedName("Waight")
    @Expose
    private String waight;
    @SerializedName("fabImage")
    @Expose
    private String fabImage;
    @SerializedName("fabricName")
    @Expose
    private String fabricName;
    @SerializedName("fabricQty")
    @Expose
    private String fabricQty;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("qc_description")
    @Expose
    private String qcDescription;
    @SerializedName("qc_status")
    @Expose
    private String qcStatus;

    public String getWaight() {
        return waight;
    }

    public void setWaight(String waight) {
        this.waight = waight;
    }

    public String getFabImage() {
        return fabImage;
    }

    public void setFabImage(String fabImage) {
        this.fabImage = fabImage;
    }

    public String getFabricName() {
        return fabricName;
    }

    public void setFabricName(String fabricName) {
        this.fabricName = fabricName;
    }

    public String getFabricQty() {
        return fabricQty;
    }

    public void setFabricQty(String fabricQty) {
        this.fabricQty = fabricQty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQcDescription() {
        return qcDescription;
    }

    public void setQcDescription(String qcDescription) {
        this.qcDescription = qcDescription;
    }

    public String getQcStatus() {
        return qcStatus;
    }

    public void setQcStatus(String qcStatus) {
        this.qcStatus = qcStatus;
    }

}

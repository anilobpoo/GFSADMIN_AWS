package com.obpoo.gfsfabricsoftware.Stock.DataModel.ActivityLog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 2/4/2019.
 */

public class ActivityLogResDet {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("cutting_by")
    @Expose
    private String cuttingBy;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("bundle_id")
    @Expose
    private String bundleId;
    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("updated_on")
    @Expose
    private String updatedOn;
    @SerializedName("action_by")
    @Expose
    private String actionBy;
    @SerializedName("fabric_details")
    @Expose
    private ALFabricDetails fabricDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCuttingBy() {
        return cuttingBy;
    }

    public void setCuttingBy(String cuttingBy) {
        this.cuttingBy = cuttingBy;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getActionBy() {
        return actionBy;
    }

    public void setActionBy(String actionBy) {
        this.actionBy = actionBy;
    }

    public ALFabricDetails getFabricDetails() {
        return fabricDetails;
    }

    public void setFabricDetails(ALFabricDetails fabricDetails) {
        this.fabricDetails = fabricDetails;
    }

}


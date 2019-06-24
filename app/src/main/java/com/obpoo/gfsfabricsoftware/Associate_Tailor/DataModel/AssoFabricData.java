package com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AssoFabricData implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("ts_id")
    @Expose
    private String tsId;
    @SerializedName("tailor_email")
    @Expose
    private String tailorEmail;
    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("associate_status")
    @Expose
    private String associateStatus;
    @SerializedName("approve_status")
    @Expose
    private String approveStatus;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("updated_on")
    @Expose
    private String updatedOn;
    @SerializedName("fab_name")
    @Expose
    private String fabName;
    @SerializedName("fab_img")
    @Expose
    private String fabImg;
    @SerializedName("tailor_info")
    @Expose
    private AssoFabricTailorInfo tailorInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTsId() {
        return tsId;
    }

    public void setTsId(String tsId) {
        this.tsId = tsId;
    }

    public String getTailorEmail() {
        return tailorEmail;
    }

    public void setTailorEmail(String tailorEmail) {
        this.tailorEmail = tailorEmail;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAssociateStatus() {
        return associateStatus;
    }

    public void setAssociateStatus(String associateStatus) {
        this.associateStatus = associateStatus;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
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

    public String getFabName() {
        return fabName;
    }

    public void setFabName(String fabName) {
        this.fabName = fabName;
    }

    public String getFabImg() {
        return fabImg;
    }

    public void setFabImg(String fabImg) {
        this.fabImg = fabImg;
    }

    public AssoFabricTailorInfo getTailorInfo() {
        return tailorInfo;
    }

    public void setTailorInfo(AssoFabricTailorInfo tailorInfo) {
        this.tailorInfo = tailorInfo;
    }

}

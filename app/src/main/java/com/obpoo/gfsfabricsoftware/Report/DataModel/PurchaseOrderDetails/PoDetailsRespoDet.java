package com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by PHD on 2/22/2019.
 */

public class PoDetailsRespoDet implements Serializable{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("factory_id")
    @Expose
    private String factoryId;
    @SerializedName("staff_id")
    @Expose
    private String staffId;
    @SerializedName("cc_email")
    @Expose
    private String ccEmail;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("contract_doc")
    @Expose
    private String contractDoc;
    @SerializedName("contract_xl")
    @Expose
    private String contractXl;
    @SerializedName("delivery_date")
    @Expose
    private String deliveryDate;
    @SerializedName("duedate")
    @Expose
    private String duedate;
    @SerializedName("sub_contract_doc")
    @Expose
    private String subContractDoc;
    @SerializedName("sub_contract_xl")
    @Expose
    private String subContractXl;
    @SerializedName("sub_sub_contract_doc")
    @Expose
    private String subSubContractDoc;
    @SerializedName("sub_sub_contract_xl")
    @Expose
    private String subSubContractXl;
    @SerializedName("final_qty_doc")
    @Expose
    private String finalQtyDoc;
    @SerializedName("created_by")
    @Expose
    private String createdBy;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("updated_by")
    @Expose
    private String updatedBy;
    @SerializedName("updated_on")
    @Expose
    private String updatedOn;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("factory")
    @Expose
    private String factory;
    @SerializedName("factory_email")
    @Expose
    private String factoryEmail;
    @SerializedName("staff")
    @Expose
    private String staff;
    @SerializedName("user_email")
    @Expose
    private String userEmail;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("items")
    @Expose
    private ArrayList<PoDetailsItems> items = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getCcEmail() {
        return ccEmail;
    }

    public void setCcEmail(String ccEmail) {
        this.ccEmail = ccEmail;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getContractDoc() {
        return contractDoc;
    }

    public void setContractDoc(String contractDoc) {
        this.contractDoc = contractDoc;
    }

    public String getContractXl() {
        return contractXl;
    }

    public void setContractXl(String contractXl) {
        this.contractXl = contractXl;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getSubContractDoc() {
        return subContractDoc;
    }

    public void setSubContractDoc(String subContractDoc) {
        this.subContractDoc = subContractDoc;
    }

    public String getSubContractXl() {
        return subContractXl;
    }

    public void setSubContractXl(String subContractXl) {
        this.subContractXl = subContractXl;
    }

    public String getSubSubContractDoc() {
        return subSubContractDoc;
    }

    public void setSubSubContractDoc(String subSubContractDoc) {
        this.subSubContractDoc = subSubContractDoc;
    }

    public String getSubSubContractXl() {
        return subSubContractXl;
    }

    public void setSubSubContractXl(String subSubContractXl) {
        this.subSubContractXl = subSubContractXl;
    }

    public String getFinalQtyDoc() {
        return finalQtyDoc;
    }

    public void setFinalQtyDoc(String finalQtyDoc) {
        this.finalQtyDoc = finalQtyDoc;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getFactoryEmail() {
        return factoryEmail;
    }

    public void setFactoryEmail(String factoryEmail) {
        this.factoryEmail = factoryEmail;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public ArrayList<PoDetailsItems> getItems() {
        return items;
    }

    public void setItems(ArrayList<PoDetailsItems> items) {
        this.items = items;
    }

}

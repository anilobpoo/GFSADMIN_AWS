package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by PHD on 11/23/2018.
 */

public class poDatum implements Parcelable {
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
    private String delivery_date;
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
    private ArrayList<poItem> items = null;

    protected poDatum(Parcel in) {
        id = in.readString();
        factoryId = in.readString();
        staffId = in.readString();
        ccEmail = in.readString();
        brandName = in.readString();
        contractDoc = in.readString();
        contractXl = in.readString();
        delivery_date = in.readString();
        subContractDoc = in.readString();
        subContractXl = in.readString();
        subSubContractDoc = in.readString();
        subSubContractXl = in.readString();
        createdBy = in.readString();
        createdOn = in.readString();
        updatedBy = in.readString();
        updatedOn = in.readString();
        status = in.readString();
        factory = in.readString();
        factoryEmail = in.readString();
        staff = in.readString();
        userEmail = in.readString();
        statusText = in.readString();
    }

    public static final Creator<poDatum> CREATOR = new Creator<poDatum>() {
        @Override
        public poDatum createFromParcel(Parcel in) {
            return new poDatum(in);
        }

        @Override
        public poDatum[] newArray(int size) {
            return new poDatum[size];
        }
    };

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
    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
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

    public ArrayList<poItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<poItem> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(factoryId);
        dest.writeString(staffId);
        dest.writeString(ccEmail);
        dest.writeString(brandName);
        dest.writeString(contractDoc);
        dest.writeString(contractXl);
        dest.writeString(delivery_date);
        dest.writeString(subContractDoc);
        dest.writeString(subContractXl);
        dest.writeString(subSubContractDoc);
        dest.writeString(subSubContractXl);
        dest.writeString(createdBy);
        dest.writeString(createdOn);
        dest.writeString(updatedBy);
        dest.writeString(updatedOn);
        dest.writeString(status);
        dest.writeString(factory);
        dest.writeString(factoryEmail);
        dest.writeString(staff);
        dest.writeString(userEmail);
        dest.writeString(statusText);
    }
}


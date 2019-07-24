package com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by PHD on 2/28/2019.
 */

public class Ts_data  implements Serializable{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("document")
    @Expose
    private String document;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("from_ware")
    @Expose
    private String fromWare;
    @SerializedName("to_ware")
    @Expose
    private String toWare;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_by")
    @Expose
    private String createdBy;
    @SerializedName("created_by_name")
    @Expose
    private String createdByName;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("fab_name")
    @Expose
    private String fabName;
    @SerializedName("unique_code")
    @Expose
    private String uniqueCode;
    @SerializedName("no_of_items")
    @Expose
    private String noOfItems;
    @SerializedName("wh")
    @Expose
    private String wh;
    @SerializedName("wh_name")
    @Expose
    private String whName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFromWare() {
        return fromWare;
    }

    public void setFromWare(String fromWare) {
        this.fromWare = fromWare;
    }

    public String getToWare() {
        return toWare;
    }

    public void setToWare(String toWare) {
        this.toWare = toWare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByName() {
        return createdByName;
    }

    public void setCreatedByName(String createdByName) {
        this.createdByName = createdByName;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getFabName() {
        return fabName;
    }

    public void setFabName(String fabName) {
        this.fabName = fabName;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(String noOfItems) {
        this.noOfItems = noOfItems;
    }

    public String getWh() {
        return wh;
    }

    public void setWh(String wh) {
        this.wh = wh;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }


}

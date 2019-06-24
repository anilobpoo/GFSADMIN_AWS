package com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by PHD on 2/28/2019.
 */

public class Ts_fabric implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("document")
    @Expose
    private String document;
    @SerializedName("fab_name")
    @Expose
    private String fabName;
    @SerializedName("unique_code")
    @Expose
    private String uniqueCode;
    @SerializedName("from_ware")
    @Expose
    private String fromWare;
    @SerializedName("to_ware")
    @Expose
    private String toWare;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("from_warehouse")
    @Expose
    private String fromWarehouse;
    @SerializedName("to_warehouse")
    @Expose
    private String toWarehouse;
    @SerializedName("zone")
    @Expose
    private String zone;
    @SerializedName("shelf")
    @Expose
    private String shelf;

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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getFromWarehouse() {
        return fromWarehouse;
    }

    public void setFromWarehouse(String fromWarehouse) {
        this.fromWarehouse = fromWarehouse;
    }

    public String getToWarehouse() {
        return toWarehouse;
    }

    public void setToWarehouse(String toWarehouse) {
        this.toWarehouse = toWarehouse;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    boolean checkScan;

    public boolean isCheckScan() {
        return checkScan;
    }

    public void setCheckScan(boolean checkScan) {
        this.checkScan = checkScan;
    }

    @Override
    public String toString(){
        return toWarehouse;
    }


}

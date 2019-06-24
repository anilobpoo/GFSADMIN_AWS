package com.obpoo.gfsfabricsoftware.TransferStock.DataModel.FabricPendingOID;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 2/7/2019.
 */

public class FabricPendingOIDdetail {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("oid")
    @Expose
    private String oid;
    @SerializedName("fab_id")
    @Expose
    private String fabId;
    @SerializedName("qty_final")
    @Expose
    private String qtyFinal;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("factory_id")
    @Expose
    private String factoryId;
    @SerializedName("fab_name")
    @Expose
    private String fabName;
    @SerializedName("fab_img")
    @Expose
    private String fabImg;
    @SerializedName("sell_pr_mtr")
    @Expose
    private String sellPrMtr;
    @SerializedName("po_satatus")
    @Expose
    private String poSatatus;
    @SerializedName("vendor")
    @Expose
    private String vendor;
    @SerializedName("country")
    @Expose
    private String country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getFabId() {
        return fabId;
    }

    public void setFabId(String fabId) {
        this.fabId = fabId;
    }

    public String getQtyFinal() {
        return qtyFinal;
    }

    public void setQtyFinal(String qtyFinal) {
        this.qtyFinal = qtyFinal;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
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

    public String getSellPrMtr() {
        return sellPrMtr;
    }

    public void setSellPrMtr(String sellPrMtr) {
        this.sellPrMtr = sellPrMtr;
    }

    public String getPoSatatus() {
        return poSatatus;
    }

    public void setPoSatatus(String poSatatus) {
        this.poSatatus = poSatatus;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return vendor;
    }
}

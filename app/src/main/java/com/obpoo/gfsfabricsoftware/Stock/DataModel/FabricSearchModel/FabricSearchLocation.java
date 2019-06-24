package com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by PHD on 2/4/2019.
 */

public class FabricSearchLocation implements Serializable{
    @SerializedName("warehouse_name")
    @Expose
    private String warehouseName;
    @SerializedName("warehouse_no")
    @Expose
    private String warehouseNo;
    @SerializedName("shopNo")
    @Expose
    private String shopNo;
    @SerializedName("shopname")
    @Expose
    private String shopname;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("shelve_name")
    @Expose
    private String shelveName;
    @SerializedName("unq_scan_code")
    @Expose
    private String unqScanCode;
    @SerializedName("zone_id")
    @Expose
    private String zoneId;
    @SerializedName("warehouse_id")
    @Expose
    private String warehouseId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("updated_on")
    @Expose
    private String updatedOn;

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseNo() {
        return warehouseNo;
    }

    public void setWarehouseNo(String warehouseNo) {
        this.warehouseNo = warehouseNo;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShelveName() {
        return shelveName;
    }

    public void setShelveName(String shelveName) {
        this.shelveName = shelveName;
    }

    public String getUnqScanCode() {
        return unqScanCode;
    }

    public void setUnqScanCode(String unqScanCode) {
        this.unqScanCode = unqScanCode;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}

package com.obpoo.gfsfabricsoftware.shelfbarcode.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShelfBarcodeDetail {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("warehouse_name")
    @Expose
    private String warehouse_name;
    @SerializedName("warehouse_no")
    @Expose
    private String warehouse_no;
    @SerializedName("shopNo")
    @Expose
    private String shopNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public String getWarehouse_no() {
        return warehouse_no;
    }

    public void setWarehouse_no(String warehouse_no) {
        this.warehouse_no = warehouse_no;
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

    public String getShelve_name() {
        return shelve_name;
    }

    public void setShelve_name(String shelve_name) {
        this.shelve_name = shelve_name;
    }

    public String getUnq_scan_code() {
        return unq_scan_code;
    }

    public void setUnq_scan_code(String unq_scan_code) {
        this.unq_scan_code = unq_scan_code;
    }

    public String getZone_id() {
        return zone_id;
    }

    public void setZone_id(String zone_id) {
        this.zone_id = zone_id;
    }

    public String getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(String warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getZone_name() {
        return zone_name;
    }

    public void setZone_name(String zone_name) {
        this.zone_name = zone_name;
    }

    @SerializedName("shopname")
    @Expose

    private String shopname;
    @SerializedName("shelve_name")
    @Expose
    private String shelve_name;

    @SerializedName("unq_scan_code")
    @Expose
    private String unq_scan_code;
    @SerializedName("zone_id")
    @Expose
    private String zone_id;
    @SerializedName("warehouse_id")
    @Expose
    private String warehouse_id;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("zone_name")
    @Expose
    private String zone_name;




}

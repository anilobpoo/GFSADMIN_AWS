package com.obpoo.gfsfabricsoftware.warehouse.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WarehouseDetail {
    public WarehouseDetail(String id, String warehouse_no, String zonecount, String warehouse_name, String shopNo, String locality, String address, String available_status, String shopname, String can_sell_part, String warebranch, String min_max_cat_id, String waretype) {
        this.id = id;
        this.warehouse_no = warehouse_no;
        this.zonecount = zonecount;
        this.warehouse_name = warehouse_name;
        this.shopNo = shopNo;
        this.locality = locality;
        this.address = address;
        Available_status = available_status;
        this.shopname = shopname;
        this.can_sell_part = can_sell_part;
        this.warebranch = warebranch;
        this.min_max_cat_id = min_max_cat_id;
        this.waretype = waretype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("warehouse_no")
    @Expose
    private String warehouse_no;

    public String getZonecount() {
        return zonecount;
    }

    public void setZonecount(String zonecount) {
        this.zonecount = zonecount;
    }

    @SerializedName("zonecount")
    @Expose
    private String zonecount;

    public String getWarehouse_no() {
        return warehouse_no;
    }

    public void setWarehouse_no(String warehouse_no) {
        this.warehouse_no = warehouse_no;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvailable_status() {
        return Available_status;
    }

    public void setAvailable_status(String available_status) {
        Available_status = available_status;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    @SerializedName("warehouse_name")
    @Expose
    private String warehouse_name;
    @SerializedName("shopNo")
    @Expose
    private String shopNo;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("Available_status")
    @Expose
    private String Available_status;
    @SerializedName("shopname")
    @Expose
    private String shopname;
    @SerializedName("can_sell_part")
    @Expose
    private String can_sell_part;

    public String getCan_sell_part() {
        return can_sell_part;
    }

    public void setCan_sell_part(String can_sell_part) {
        this.can_sell_part = can_sell_part;
    }

    public String getWarebranch() {
        return warebranch;
    }

    public void setWarebranch(String warebranch) {
        this.warebranch = warebranch;
    }

    public String getMin_max_cat_id() {
        return min_max_cat_id;
    }

    public void setMin_max_cat_id(String min_max_cat_id) {
        this.min_max_cat_id = min_max_cat_id;
    }

    public String getWaretype() {
        return waretype;
    }

    public void setWaretype(String waretype) {
        this.waretype = waretype;
    }

    @SerializedName("warebranch")
    @Expose

    private String warebranch;
    @SerializedName("min_max_cat_id")
    @Expose
    private String min_max_cat_id;
    @SerializedName("waretype")
    @Expose
    private String waretype;

    @Override
    public String toString(){
        return warehouse_name;
    }




}

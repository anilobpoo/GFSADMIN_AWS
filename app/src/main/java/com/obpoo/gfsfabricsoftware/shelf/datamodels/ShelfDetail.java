package com.obpoo.gfsfabricsoftware.shelf.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShelfDetail {
    public ShelfDetail(String id, String warehouse_id, String status, String shelve_name, String unq_scan_code, String zone_id) {
        this.id = id;
        this.warehouse_id = warehouse_id;
        this.status = status;
        this.shelve_name = shelve_name;
        this.unq_scan_code = unq_scan_code;
        this.zone_id = zone_id;
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

    @SerializedName("warehouse_id")

    @Expose
    private String warehouse_id;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("shelve_name")
    @Expose
    private String shelve_name;
    @SerializedName("unq_scan_code")
    @Expose
    private String unq_scan_code;
    @SerializedName("zone_id")
    @Expose
    private String zone_id;

    @Override
    public String toString(){
        return shelve_name ;
    }


}

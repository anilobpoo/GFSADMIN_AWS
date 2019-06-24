package com.obpoo.gfsfabricsoftware.zone.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ZoneDetail {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(String warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getShelfcount() {
        return shelfcount;
    }

    public void setShelfcount(String shelfcount) {
        this.shelfcount = shelfcount;
    }

    @SerializedName("id")
    @Expose

    private String id;
    @SerializedName("warehouse_id")
    @Expose
    private String warehouse_id;
    @SerializedName("active")
    @Expose
    private String active;
    @SerializedName("shelfcount")
    @Expose
    private String shelfcount;

    @Override
    public String toString(){
        return shelfcount ;
    }


}

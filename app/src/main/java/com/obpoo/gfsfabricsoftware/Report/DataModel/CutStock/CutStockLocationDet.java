package com.obpoo.gfsfabricsoftware.Report.DataModel.CutStock;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 2/20/2019.
 */

public class CutStockLocationDet {
    @SerializedName("shelf_id")
    @Expose
    private String shelfId;
    @SerializedName("shelve_name")
    @Expose
    private String shelveName;
    @SerializedName("warehouse_name")
    @Expose
    private String warehouseName;
    @SerializedName("remain")
    @Expose
    private String remain;
    @SerializedName("zone")
    @Expose
    private String zone;

    public String getShelfId() {
        return shelfId;
    }

    public void setShelfId(String shelfId) {
        this.shelfId = shelfId;
    }

    public String getShelveName() {
        return shelveName;
    }

    public void setShelveName(String shelveName) {
        this.shelveName = shelveName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}

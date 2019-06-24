package com.obpoo.gfsfabricsoftware.Report.DataModel.CutStock;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 2/20/2019.
 */

public class CutStockResponseDetails {
    @SerializedName("unique_code")
    @Expose
    private String uniqueCode;
    @SerializedName("fab_id")
    @Expose
    private String fabId;
    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("remain")
    @Expose
    private String remain;
    @SerializedName("reserve")
    @Expose
    private String reserve;
    @SerializedName("updated_by")
    @Expose
    private String updatedBy;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("location")
    @Expose
    private CutStockLocationDet location;
    @SerializedName("fab_name")
    @Expose
    private String fabName;
    @SerializedName("fab_img")
    @Expose
    private String fabImg;

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String getFabId() {
        return fabId;
    }

    public void setFabId(String fabId) {
        this.fabId = fabId;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public CutStockLocationDet getLocation() {
        return location;
    }

    public void setLocation(CutStockLocationDet location) {
        this.location = location;
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

}

package com.obpoo.gfsfabricsoftware.Report.DataModel.PO_Fabric_List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 2/26/2019.
 */

public class PO_fabric_response_details {
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
    @SerializedName("fab_name")
    @Expose
    private String fabName;
    @SerializedName("fab_img")
    @Expose
    private String fabImg;
    @SerializedName("po_satatus")
    @Expose
    private String poSatatus;

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

    public String getPoSatatus() {
        return poSatatus;
    }

    public void setPoSatatus(String poSatatus) {
        this.poSatatus = poSatatus;
    }

}

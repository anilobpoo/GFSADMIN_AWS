package com.obpoo.gfsfabricsoftware.Stock.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by PHD on 1/28/2019.
 */

public class StockInDetails implements Serializable {
    @SerializedName("article_no")
    @Expose
    private String articleNo;
    @SerializedName("color_code")
    @Expose
    private String colorCode;
    @SerializedName("fab_name")
    @Expose
    private String fabName;
    @SerializedName("fab_img")
    @Expose
    private String fabImg;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("packet_id")
    @Expose
    private String packetId;
    @SerializedName("unique_code")
    @Expose
    private String uniqueCode;
    @SerializedName("shelf_id")
    @Expose
    private String shelfId;
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
    @SerializedName("cut_stock")
    @Expose
    private String cutStock;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("created_by")
    @Expose
    private String createdBy;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("updated_by")
    @Expose
    private String updatedBy;

    @SerializedName("document_created")
    @Expose
    private String documentCreated;

    public String getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(String articleNo) {
        this.articleNo = articleNo;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPacketId() {
        return packetId;
    }

    public void setPacketId(String packetId) {
        this.packetId = packetId;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }

    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
    }

    public String getShelfId() {
        return shelfId;
    }

    public void setShelfId(String shelfId) {
        this.shelfId = shelfId;
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

    public String getCutStock() {
        return cutStock;
    }

    public void setCutStock(String cutStock) {
        this.cutStock = cutStock;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getDocumentCreated() {
        return documentCreated;
    }

    public void setDocumentCreated(String documentCreated) {
        this.documentCreated = documentCreated;
    }
}

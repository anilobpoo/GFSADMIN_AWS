package com.obpoo.gfsfabricsoftware.Report.DataModel.SoldFabrics;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 2/27/2019.
 */

public class SoldFabricsData {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("qrcode")
    @Expose
    private String qrcode;
    @SerializedName("orderid")
    @Expose
    private String orderid;
    @SerializedName("sub_order_id")
    @Expose
    private String subOrderId;
    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("extra_qty")
    @Expose
    private String extraQty;
    @SerializedName("qty_type")
    @Expose
    private String qtyType;
    @SerializedName("actual_price")
    @Expose
    private String actualPrice;
    @SerializedName("discount_for_user")
    @Expose
    private String discountForUser;
    @SerializedName("subtotal")
    @Expose
    private String subtotal;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("order_item_status")
    @Expose
    private String orderItemStatus;
    @SerializedName("cutting_by")
    @Expose
    private String cuttingBy;
    @SerializedName("stock_id_qty")
    @Expose
    private String stockIdQty;
    @SerializedName("qc_status")
    @Expose
    private String qcStatus;
    @SerializedName("qc_description")
    @Expose
    private String qcDescription;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("updated_on")
    @Expose
    private String updatedOn;

    @SerializedName("return_qty")
    @Expose
    private String returnQty;
    @SerializedName("stock_flag")
    @Expose
    private String stockFlag;
    @SerializedName("fab_name")
    @Expose
    private String fabName;
    @SerializedName("fab_img")
    @Expose
    private String fabImg;
    @SerializedName("status_text")
    @Expose
    private String statusText;

    public String getReturnQty() {
        return returnQty;
    }

    public void setReturnQty(String returnQty) {
        this.returnQty = returnQty;
    }

    public String getStockFlag() {
        return stockFlag;
    }

    public void setStockFlag(String stockFlag) {
        this.stockFlag = stockFlag;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    @SerializedName("orderdate")
    @Expose
    private String orderdate;
    @SerializedName("pay_mode")
    @Expose
    private String payMode;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(String subOrderId) {
        this.subOrderId = subOrderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getExtraQty() {
        return extraQty;
    }

    public void setExtraQty(String extraQty) {
        this.extraQty = extraQty;
    }

    public String getQtyType() {
        return qtyType;
    }

    public void setQtyType(String qtyType) {
        this.qtyType = qtyType;
    }

    public String getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getDiscountForUser() {
        return discountForUser;
    }

    public void setDiscountForUser(String discountForUser) {
        this.discountForUser = discountForUser;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderItemStatus() {
        return orderItemStatus;
    }

    public void setOrderItemStatus(String orderItemStatus) {
        this.orderItemStatus = orderItemStatus;
    }

    public String getCuttingBy() {
        return cuttingBy;
    }

    public void setCuttingBy(String cuttingBy) {
        this.cuttingBy = cuttingBy;
    }

    public String getStockIdQty() {
        return stockIdQty;
    }

    public void setStockIdQty(String stockIdQty) {
        this.stockIdQty = stockIdQty;
    }

    public String getQcStatus() {
        return qcStatus;
    }

    public void setQcStatus(String qcStatus) {
        this.qcStatus = qcStatus;
    }

    public String getQcDescription() {
        return qcDescription;
    }

    public void setQcDescription(String qcDescription) {
        this.qcDescription = qcDescription;
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

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

}

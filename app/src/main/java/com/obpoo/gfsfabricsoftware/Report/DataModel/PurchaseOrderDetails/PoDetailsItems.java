package com.obpoo.gfsfabricsoftware.Report.DataModel.PurchaseOrderDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by PHD on 2/22/2019.
 */

public class PoDetailsItems implements Serializable{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("oid")
    @Expose
    private String oid;
    @SerializedName("customer_id")
    @Expose
    private String customerId;
    @SerializedName("fab_id")
    @Expose
    private String fabId;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("art_no_id")
    @Expose
    private String artNoId;
    @SerializedName("color_code_id")
    @Expose
    private String colorCodeId;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("qty_on_contract")
    @Expose
    private String qtyOnContract;
    @SerializedName("qty_modified")
    @Expose
    private String qtyModified;
    @SerializedName("qty_final")
    @Expose
    private String qtyFinal;
    @SerializedName("cost_price")
    @Expose
    private String costPrice;
    @SerializedName("price_for_customer")
    @Expose
    private String priceForCustomer;
    @SerializedName("delivery_date")
    @Expose
    private String deliveryDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("pending_qty")
    @Expose
    private String pendingQty;
    @SerializedName("extra_qty")
    @Expose
    private String extraQty;
    @SerializedName("sort_description")
    @Expose
    private String sortDescription;
    @SerializedName("warehouse")
    @Expose
    private String warehouse;
    @SerializedName("warehouse_to")
    @Expose
    private String warehouseTo;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("customer_name")
    @Expose
    private Object customerName;
    @SerializedName("art_no")
    @Expose
    private String artNo;
    @SerializedName("color_code")
    @Expose
    private String colorCode;
    @SerializedName("img")
    @Expose
    private String img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFabId() {
        return fabId;
    }

    public void setFabId(String fabId) {
        this.fabId = fabId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getArtNoId() {
        return artNoId;
    }

    public void setArtNoId(String artNoId) {
        this.artNoId = artNoId;
    }

    public String getColorCodeId() {
        return colorCodeId;
    }

    public void setColorCodeId(String colorCodeId) {
        this.colorCodeId = colorCodeId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQtyOnContract() {
        return qtyOnContract;
    }

    public void setQtyOnContract(String qtyOnContract) {
        this.qtyOnContract = qtyOnContract;
    }

    public String getQtyModified() {
        return qtyModified;
    }

    public void setQtyModified(String qtyModified) {
        this.qtyModified = qtyModified;
    }

    public String getQtyFinal() {
        return qtyFinal;
    }

    public void setQtyFinal(String qtyFinal) {
        this.qtyFinal = qtyFinal;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getPriceForCustomer() {
        return priceForCustomer;
    }

    public void setPriceForCustomer(String priceForCustomer) {
        this.priceForCustomer = priceForCustomer;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPendingQty() {
        return pendingQty;
    }

    public void setPendingQty(String pendingQty) {
        this.pendingQty = pendingQty;
    }

    public String getExtraQty() {
        return extraQty;
    }

    public void setExtraQty(String extraQty) {
        this.extraQty = extraQty;
    }

    public String getSortDescription() {
        return sortDescription;
    }

    public void setSortDescription(String sortDescription) {
        this.sortDescription = sortDescription;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getWarehouseTo() {
        return warehouseTo;
    }

    public void setWarehouseTo(String warehouseTo) {
        this.warehouseTo = warehouseTo;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Object getCustomerName() {
        return customerName;
    }

    public void setCustomerName(Object customerName) {
        this.customerName = customerName;
    }

    public String getArtNo() {
        return artNo;
    }

    public void setArtNo(String artNo) {
        this.artNo = artNo;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by PHD on 11/23/2018.
 */

public class poItem implements Parcelable {
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

    @SerializedName("shiping_id")
    @Expose
    private String shiping_id;
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
    @SerializedName("delivery_date")
    @Expose
    private String deliveryDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("pending_qty")
    @Expose
    private String pendingQty;

    public poItem(String brandName, String artNo, String quantity, String colorCode,String customerName,String customerId,String shiping_id) {
        this.brandName = brandName;
        this.artNo = artNo;
        this.quantity = quantity;
        this.colorCode = colorCode;
        this.customerName=customerName;
        this.customerId=customerId;
        this.shiping_id=shiping_id;
    }

    @SerializedName("extra_qty")
    @Expose
    private String extraQty;
    @SerializedName("sort_description")
    @Expose
    private String sortDescription;
    @SerializedName("status_text")
    @Expose
    private String statusText;

    public poItem() {
    }

    @SerializedName("customer_name")
    @Expose
    private String customerName;
    @SerializedName("art_no")
    @Expose
    private String artNo;
    @SerializedName("color_code")
    @Expose
    private String colorCode;
    @SerializedName("img")
    @Expose
    private String img;

    protected poItem(Parcel in) {
        id = in.readString();
        oid = in.readString();
        customerId = in.readString();
        fabId = in.readString();
        brandName = in.readString();
        artNoId = in.readString();
        colorCodeId = in.readString();
        quantity = in.readString();
        qtyOnContract = in.readString();
        qtyModified = in.readString();
        qtyFinal = in.readString();
        costPrice = in.readString();
        deliveryDate = in.readString();
        status = in.readString();
        pendingQty = in.readString();
        extraQty = in.readString();
        sortDescription = in.readString();
        statusText = in.readString();
        customerName = in.readString();
        artNo = in.readString();
        colorCode = in.readString();
        img = in.readString();
    }

    public static final Creator<poItem> CREATOR = new Creator<poItem>() {
        @Override
        public poItem createFromParcel(Parcel in) {
            return new poItem(in);
        }

        @Override
        public poItem[] newArray(int size) {
            return new poItem[size];
        }
    };

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

    public String getShiping_id() {
        return shiping_id;
    }

    public void setShiping_id(String shiping_id) {
        this.shiping_id = shiping_id;
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

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(oid);
        dest.writeString(customerId);
        dest.writeString(fabId);
        dest.writeString(brandName);
        dest.writeString(artNoId);
        dest.writeString(colorCodeId);
        dest.writeString(quantity);
        dest.writeString(qtyOnContract);
        dest.writeString(qtyModified);
        dest.writeString(qtyFinal);
        dest.writeString(costPrice);
        dest.writeString(deliveryDate);
        dest.writeString(status);
        dest.writeString(pendingQty);
        dest.writeString(extraQty);
        dest.writeString(sortDescription);
        dest.writeString(statusText);
        dest.writeString(customerName);
        dest.writeString(artNo);
        dest.writeString(colorCode);
        dest.writeString(img);
    }
}

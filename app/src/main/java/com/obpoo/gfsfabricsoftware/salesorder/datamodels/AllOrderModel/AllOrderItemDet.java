package com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllOrderItemDet implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("qrcode")
    @Expose
    private String qrcode;
    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("actual_price")
    @Expose
    private String actualPrice;
    @SerializedName("discount_for_user")
    @Expose
    private String discountForUser;
    @SerializedName("subtotal")
    @Expose
    private String subtotal;
    @SerializedName("fab_name")
    @Expose
    private String fabName;
    @SerializedName("fab_img")
    @Expose
    private String fabImg;

    protected AllOrderItemDet(Parcel in) {
        id = in.readString();
        qrcode = in.readString();
        itemId = in.readString();
        quantity = in.readString();
        actualPrice = in.readString();
        discountForUser = in.readString();
        subtotal = in.readString();
        fabName = in.readString();
        fabImg = in.readString();
    }

    public static final Creator<AllOrderItemDet> CREATOR = new Creator<AllOrderItemDet>() {
        @Override
        public AllOrderItemDet createFromParcel(Parcel in) {
            return new AllOrderItemDet(in);
        }

        @Override
        public AllOrderItemDet[] newArray(int size) {
            return new AllOrderItemDet[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(qrcode);
        dest.writeString(itemId);
        dest.writeString(quantity);
        dest.writeString(actualPrice);
        dest.writeString(discountForUser);
        dest.writeString(subtotal);
        dest.writeString(fabName);
        dest.writeString(fabImg);
    }
}

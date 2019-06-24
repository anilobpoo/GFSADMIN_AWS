package com.obpoo.gfsfabricsoftware.salesorder.datamodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class ItemDetail_old implements Parcelable {

    @SerializedName("id")
    @Expose
    public String id;


    @SerializedName("fab_name")
    @Expose
    public String fab_name;

    @SerializedName("subtotal")
    @Expose
    public String subtotal;

    @SerializedName("discount_for_user")
    @Expose
    public String discount_for_user;
    @SerializedName("actual_price")
    @Expose
    public String actual_price;
    @SerializedName("quantity")
    @Expose
    public String quantity;


    @SerializedName("item_id")
    @Expose
    public String item_id;


    @SerializedName("qrcode")
    @Expose
    public String qrcode;


    @SerializedName("fab_img")
    @Expose
    public String fab_img;


    public ItemDetail_old(Parcel in) {
        id = in.readString();
        fab_name = in.readString();
        subtotal = in.readString();
        discount_for_user = in.readString();
        actual_price = in.readString();
        quantity = in.readString();
        item_id = in.readString();
        qrcode = in.readString();
        fab_img = in.readString();
    }

    public static final Creator<ItemDetail_old> CREATOR = new Creator<ItemDetail_old>() {
        @Override
        public ItemDetail_old createFromParcel(Parcel in) {
            return new ItemDetail_old(in);
        }

        @Override
        public ItemDetail_old[] newArray(int size) {
            return new ItemDetail_old[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFab_name() {
        return fab_name;
    }

    public void setFab_name(String fab_name) {
        this.fab_name = fab_name;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getDiscount_for_user() {
        return discount_for_user;
    }

    public void setDiscount_for_user(String discount_for_user) {
        this.discount_for_user = discount_for_user;
    }

    public String getActual_price() {
        return actual_price;
    }

    public void setActual_price(String actual_price) {
        this.actual_price = actual_price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getFab_img() {
        return fab_img;
    }

    public void setFab_img(String fab_img) {
        this.fab_img = fab_img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(fab_name);
        dest.writeString(subtotal);
        dest.writeString(discount_for_user);
        dest.writeString(actual_price);
        dest.writeString(quantity);
        dest.writeString(item_id);
        dest.writeString(qrcode);
        dest.writeString(fab_img);
    }
}

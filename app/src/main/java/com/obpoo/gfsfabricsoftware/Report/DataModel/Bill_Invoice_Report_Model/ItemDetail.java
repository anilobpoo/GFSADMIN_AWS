package com.obpoo.gfsfabricsoftware.Report.DataModel.Bill_Invoice_Report_Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 2/18/2019.
 */

public class ItemDetail {
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
}

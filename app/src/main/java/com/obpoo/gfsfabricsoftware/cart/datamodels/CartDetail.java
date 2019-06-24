package com.obpoo.gfsfabricsoftware.cart.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartDetail {




    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("orderid")
    @Expose
    private String orderid;
    @SerializedName("item_id")
    @Expose
    private String item_id;
    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("actual_price")
    @Expose
    private String actual_price;
    @SerializedName("discount_for_user")
    @Expose
    private String discount_for_user;
    @SerializedName("subtotal")
    @Expose
    private String subtotal;
    @SerializedName("order_total")
    @Expose
    private String order_total;
    @SerializedName("order_item_status")
    @Expose
    private String order_item_status;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("stock_id_qty")
    @Expose
    private String stock_id_qty;
    @SerializedName("qc_status")
    @Expose
    private String qc_status;
    @SerializedName("qc_description")
    @Expose
    private String qc_description;
    @SerializedName("article_id")
    @Expose
    private String article_id;


    @SerializedName("articleno")
    @Expose
    private String articleno;
    @SerializedName("color_id")
    @Expose
    private String color_id;
    @SerializedName("colorcode")
    @Expose
    private String colorcode;
    @SerializedName("composition_id")
    @Expose
    private String composition_id;



    @SerializedName("composition")
    @Expose
    private String composition;


    @SerializedName("fab_name")
    @Expose
    private String fab_name;
    @SerializedName("fab_img")
    @Expose
    private String fab_img;
    @SerializedName("sell_pr_mtr")
    @Expose
    private String sell_pr_mtr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getActual_price() {
        return actual_price;
    }

    public void setActual_price(String actual_price) {
        this.actual_price = actual_price;
    }

    public String getDiscount_for_user() {
        return discount_for_user;
    }

    public void setDiscount_for_user(String discount_for_user) {
        this.discount_for_user = discount_for_user;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getOrder_total() {
        return order_total;
    }

    public void setOrder_total(String order_total) {
        this.order_total = order_total;
    }

    public String getOrder_item_status() {
        return order_item_status;
    }

    public void setOrder_item_status(String order_item_status) {
        this.order_item_status = order_item_status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStock_id_qty() {
        return stock_id_qty;
    }

    public void setStock_id_qty(String stock_id_qty) {
        this.stock_id_qty = stock_id_qty;
    }

    public String getQc_status() {
        return qc_status;
    }

    public void setQc_status(String qc_status) {
        this.qc_status = qc_status;
    }

    public String getQc_description() {
        return qc_description;
    }

    public void setQc_description(String qc_description) {
        this.qc_description = qc_description;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getArticleno() {
        return articleno;
    }

    public void setArticleno(String articleno) {
        this.articleno = articleno;
    }

    public String getColor_id() {
        return color_id;
    }

    public void setColor_id(String color_id) {
        this.color_id = color_id;
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {
        this.colorcode = colorcode;
    }

    public String getComposition_id() {
        return composition_id;
    }

    public void setComposition_id(String composition_id) {
        this.composition_id = composition_id;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getFab_name() {
        return fab_name;
    }

    public void setFab_name(String fab_name) {
        this.fab_name = fab_name;
    }

    public String getFab_img() {
        return fab_img;
    }

    public void setFab_img(String fab_img) {
        this.fab_img = fab_img;
    }

    public String getSell_pr_mtr() {
        return sell_pr_mtr;
    }

    public void setSell_pr_mtr(String sell_pr_mtr) {
        this.sell_pr_mtr = sell_pr_mtr;
    }
}









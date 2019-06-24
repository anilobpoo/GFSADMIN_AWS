package com.obpoo.gfsfabricsoftware.shelfassignment.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PacketDetails {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("unique_id")
    @Expose
    private String unique_id;
    @SerializedName("file_name")
    @Expose
    private String file_name;
    @SerializedName("bundle_no")
    @Expose
    private String bundle_no;
    @SerializedName("article_no")
    @Expose
    private String article_no;
    @SerializedName("color_code")
    @Expose
    private String color_code;
    @SerializedName("fab_id")
    @Expose
    private String fab_id;
    @SerializedName("fab_price")
    @Expose
    private String fab_price;


    @SerializedName("po_id")
    @Expose
    private String po_id;
    @SerializedName("due_date")
    @Expose
    private String due_date;
    @SerializedName("delivery_date")
    @Expose
    private String delivery_date;
    @SerializedName("net_meters")
    @Expose
    private String net_meters;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("exchange_rate")
    @Expose
    private String exchange_rate;
    @SerializedName("note")
    @Expose
    private String note;


    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("baikon_no")
    @Expose
    private String baikon_no;
    @SerializedName("invoice_no")
    @Expose
    private String invoice_no;
    @SerializedName("no_of_carton")
    @Expose
    private String no_of_carton;
    @SerializedName("term")
    @Expose


    private String term;
    @SerializedName("total")
    @Expose
    private String total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getBundle_no() {
        return bundle_no;
    }

    public void setBundle_no(String bundle_no) {
        this.bundle_no = bundle_no;
    }

    public String getArticle_no() {
        return article_no;
    }

    public void setArticle_no(String article_no) {
        this.article_no = article_no;
    }

    public String getColor_code() {
        return color_code;
    }

    public void setColor_code(String color_code) {
        this.color_code = color_code;
    }

    public String getFab_id() {
        return fab_id;
    }

    public void setFab_id(String fab_id) {
        this.fab_id = fab_id;
    }

    public String getFab_price() {
        return fab_price;
    }

    public void setFab_price(String fab_price) {
        this.fab_price = fab_price;
    }

    public String getPo_id() {
        return po_id;
    }

    public void setPo_id(String po_id) {
        this.po_id = po_id;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public String getNet_meters() {
        return net_meters;
    }

    public void setNet_meters(String net_meters) {
        this.net_meters = net_meters;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExchange_rate() {
        return exchange_rate;
    }

    public void setExchange_rate(String exchange_rate) {
        this.exchange_rate = exchange_rate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBaikon_no() {
        return baikon_no;
    }

    public void setBaikon_no(String baikon_no) {
        this.baikon_no = baikon_no;
    }

    public String getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }

    public String getNo_of_carton() {
        return no_of_carton;
    }

    public void setNo_of_carton(String no_of_carton) {
        this.no_of_carton = no_of_carton;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getSum_discount() {
        return sum_discount;
    }

    public void setSum_discount(String sum_discount) {
        this.sum_discount = sum_discount;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getSum_total() {
        return sum_total;
    }

    public void setSum_total(String sum_total) {
        this.sum_total = sum_total;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    @SerializedName("discount")
    @Expose

    private String discount;
    @SerializedName("sum_discount")
    @Expose
    private String sum_discount;


    @SerializedName("vat")
    @Expose
    private String vat;
    @SerializedName("sum_total")
    @Expose
    private String sum_total;
    @SerializedName("deposit")
    @Expose
    private String deposit;
    @SerializedName("remain")
    @Expose
    private String remain;


}

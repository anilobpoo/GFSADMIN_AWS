package com.obpoo.gfsfabricsoftware.bundle.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BundleDetail {

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
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("exchange_rate")
    @Expose
    private String exchange_rate;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("baikon_no")
    @Expose
    private String baikon_no;



    @SerializedName("no_of_carton")
    @Expose

    private String no_of_carton;
    @SerializedName("invoice_no")
    @Expose
    private String invoice_no;
    @SerializedName("term")
    @Expose
    private String term;
    @SerializedName("total")
    @Expose
    private String total;
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
    @SerializedName("fab_price")
    @Expose
    private String fab_price;
    @SerializedName("fab_id")
    @Expose
    private String fab_id;

    public BundleDetail(String id, String unique_id, String file_name, String bundle_no, String article_no, String color_code, String po_id, String due_date, String delivery_date, String net_meters, String type, String status, String note, String exchange_rate, String currency, String baikon_no, String no_of_carton, String invoice_no, String term, String total, String discount, String sum_discount, String vat, String sum_total, String deposit, String remain, String fab_price, String fab_id) {
        this.id = id;
        this.unique_id = unique_id;
        this.file_name = file_name;
        this.bundle_no = bundle_no;
        this.article_no = article_no;
        this.color_code = color_code;
        this.po_id = po_id;
        this.due_date = due_date;
        this.delivery_date = delivery_date;
        this.net_meters = net_meters;
        this.type = type;
        this.status = status;
        this.note = note;
        this.exchange_rate = exchange_rate;
        this.currency = currency;
        this.baikon_no = baikon_no;
        this.no_of_carton = no_of_carton;
        this.invoice_no = invoice_no;
        this.term = term;
        this.total = total;
        this.discount = discount;
        this.sum_discount = sum_discount;
        this.vat = vat;
        this.sum_total = sum_total;
        this.deposit = deposit;
        this.remain = remain;
        this.fab_price = fab_price;
        this.fab_id = fab_id;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getExchange_rate() {
        return exchange_rate;
    }

    public void setExchange_rate(String exchange_rate) {
        this.exchange_rate = exchange_rate;
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

    public String getNo_of_carton() {
        return no_of_carton;
    }

    public void setNo_of_carton(String no_of_carton) {
        this.no_of_carton = no_of_carton;
    }

    public String getInvoice_no() {
        return invoice_no;
    }

    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
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

    public String getFab_price() {
        return fab_price;
    }

    public void setFab_price(String fab_price) {
        this.fab_price = fab_price;
    }

    public String getFab_id() {
        return fab_id;
    }

    public void setFab_id(String fab_id) {
        this.fab_id = fab_id;
    }







}

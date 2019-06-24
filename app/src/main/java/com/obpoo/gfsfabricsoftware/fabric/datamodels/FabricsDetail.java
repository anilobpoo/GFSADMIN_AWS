package com.obpoo.gfsfabricsoftware.fabric.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class FabricsDetail implements Serializable {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("article_no_id")
    @Expose
    private String article_no_id;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("colors_id")
    @Expose
    private String colors_id;
    @SerializedName("composition_code_id")
    @Expose
    private String composition_code_id;
    @SerializedName("fab_name")
    @Expose
    private String fab_name;
    @SerializedName("fab_img")
    @Expose
    private String fab_img;
    @SerializedName("bar_code")
    @Expose
    private String bar_code;
    @SerializedName("main_fabric")
    @Expose
    private String main_fabric;
    @SerializedName("cost_pr_mtr")
    @Expose
    private String cost_pr_mtr;
    @SerializedName("cost_pr_yrd")
    @Expose
    private String cost_pr_yrd;
    @SerializedName("sell_pr_mtr")
    @Expose
    private String sell_pr_mtr;
    @SerializedName("sell_pr_yrd")
    @Expose
    private String sell_pr_yrd;
    @SerializedName("min_stock_mtr")
    @Expose
    private String min_stock_mtr;


    @SerializedName("max_stock_mtr")
    @Expose
    private String max_stock_mtr;
    @SerializedName("min_stock_yrd")
    @Expose
    private String min_stock_yrd;
    @SerializedName("max_stock_yrd")
    @Expose
    private String max_stock_yrd;
    @SerializedName("del_status")
    @Expose
    private String del_status;

    public String getArticle_no_id() {
        return article_no_id;
    }

    public void setArticle_no_id(String article_no_id) {
        this.article_no_id = article_no_id;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getColors_id() {
        return colors_id;
    }

    public void setColors_id(String colors_id) {
        this.colors_id = colors_id;
    }

    public String getComposition_code_id() {
        return composition_code_id;
    }

    public void setComposition_code_id(String composition_code_id) {
        this.composition_code_id = composition_code_id;
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

    public String getBar_code() {
        return bar_code;
    }

    public void setBar_code(String bar_code) {
        this.bar_code = bar_code;
    }

    public String getMain_fabric() {
        return main_fabric;
    }

    public void setMain_fabric(String main_fabric) {
        this.main_fabric = main_fabric;
    }

    public String getCost_pr_mtr() {
        return cost_pr_mtr;
    }

    public void setCost_pr_mtr(String cost_pr_mtr) {
        this.cost_pr_mtr = cost_pr_mtr;
    }

    public String getCost_pr_yrd() {
        return cost_pr_yrd;
    }

    public void setCost_pr_yrd(String cost_pr_yrd) {
        this.cost_pr_yrd = cost_pr_yrd;
    }

    public String getSell_pr_mtr() {
        return sell_pr_mtr;
    }

    public void setSell_pr_mtr(String sell_pr_mtr) {
        this.sell_pr_mtr = sell_pr_mtr;
    }

    public String getSell_pr_yrd() {
        return sell_pr_yrd;
    }

    public void setSell_pr_yrd(String sell_pr_yrd) {
        this.sell_pr_yrd = sell_pr_yrd;
    }

    public String getMin_stock_mtr() {
        return min_stock_mtr;
    }

    public void setMin_stock_mtr(String min_stock_mtr) {
        this.min_stock_mtr = min_stock_mtr;
    }

    public String getMax_stock_mtr() {
        return max_stock_mtr;
    }

    public void setMax_stock_mtr(String max_stock_mtr) {
        this.max_stock_mtr = max_stock_mtr;
    }

    public String getMin_stock_yrd() {
        return min_stock_yrd;
    }

    public void setMin_stock_yrd(String min_stock_yrd) {
        this.min_stock_yrd = min_stock_yrd;
    }

    public String getMax_stock_yrd() {
        return max_stock_yrd;
    }

    public void setMax_stock_yrd(String max_stock_yrd) {
        this.max_stock_yrd = max_stock_yrd;
    }

    public String getDel_status() {
        return del_status;
    }

    public void setDel_status(String del_status) {
        this.del_status = del_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArticleno() {
        return articleno;
    }

    public void setArticleno(String articleno) {
        this.articleno = articleno;
    }

    public String getColor_code() {
        return color_code;
    }

    public void setColor_code(String color_code) {
        this.color_code = color_code;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    @SerializedName("description")
    @Expose
    private String description;


    @SerializedName("articleno")
    @Expose
    private String articleno;
    @SerializedName("color_code")
    @Expose
    private String color_code;
    @SerializedName("composition")
    @Expose
    private String composition;


    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    @SerializedName("texture")
    @Expose
    private String texture;

    @SerializedName("min_stock_user_mtr")
    @Expose
    private String min_stock_user_mtr;


    @SerializedName("min_stock_user_yrd")
    @Expose
    private String min_stock_user_yrd;

    @SerializedName("pricefullroll")
    @Expose
    private String pricefullroll;

    @SerializedName("price1to9")
    @Expose
    private String price1to9;

    @SerializedName("pricefullrollmtrs")
    @Expose
    private String pricefullrollmtrs;

    @SerializedName("price10plus")
    @Expose
    private String price10plus;


    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getMin_stock_user_mtr() {
        return min_stock_user_mtr;
    }

    public void setMin_stock_user_mtr(String min_stock_user_mtr) {
        this.min_stock_user_mtr = min_stock_user_mtr;
    }

    public String getMin_stock_user_yrd() {
        return min_stock_user_yrd;
    }

    public void setMin_stock_user_yrd(String min_stock_user_yrd) {
        this.min_stock_user_yrd = min_stock_user_yrd;
    }

    public String getPricefullroll() {
        return pricefullroll;
    }

    public void setPricefullroll(String pricefullroll) {
        this.pricefullroll = pricefullroll;
    }

    public String getPrice1to9() {
        return price1to9;
    }

    public void setPrice1to9(String price1to9) {
        this.price1to9 = price1to9;
    }

    public String getPricefullrollmtrs() {
        return pricefullrollmtrs;
    }

    public void setPricefullrollmtrs(String pricefullrollmtrs) {
        this.pricefullrollmtrs = pricefullrollmtrs;
    }

    public String getPrice10plus() {
        return price10plus;
    }

    public void setPrice10plus(String price10plus) {
        this.price10plus = price10plus;
    }

    public String getPrice1to9mtrs() {
        return price1to9mtrs;
    }

    public void setPrice1to9mtrs(String price1to9mtrs) {
        this.price1to9mtrs = price1to9mtrs;
    }

    public String getPrice10plusmtrs() {
        return price10plusmtrs;
    }

    public void setPrice10plusmtrs(String price10plusmtrs) {
        this.price10plusmtrs = price10plusmtrs;
    }

    public List getColor_desc() {
        return color_desc;
    }

    public void setColor_desc(List color_desc) {
        this.color_desc = color_desc;
    }

    @SerializedName("price1to9mtrs")

    @Expose
    private String price1to9mtrs;

    @SerializedName("price10plusmtrs")
    @Expose
    private String price10plusmtrs;


    @SerializedName("color_desc")
    @Expose
    private List color_desc;

}









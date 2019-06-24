package com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 1/17/2019.
 */

public class StockAlertData {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("article_no_id")
    @Expose
    private String articleNoId;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("colors_id")
    @Expose
    private String colorsId;
    @SerializedName("fab_name")
    @Expose
    private String fabName;
    @SerializedName("fab_img")
    @Expose
    private String fabImg;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("texture")
    @Expose
    private String texture;
    @SerializedName("bar_code")
    @Expose
    private String barCode;
    @SerializedName("reserve")
    @Expose
    private String reserve;
    @SerializedName("main_fabric")
    @Expose
    private String mainFabric;
    @SerializedName("cost_pr_mtr")
    @Expose
    private String costPrMtr;
    @SerializedName("cost_pr_yrd")
    @Expose
    private String costPrYrd;
    @SerializedName("sell_pr_mtr")
    @Expose
    private String sellPrMtr;
    @SerializedName("sell_pr_yrd")
    @Expose
    private String sellPrYrd;
    @SerializedName("pricefullroll")
    @Expose
    private String pricefullroll;
    @SerializedName("price1to9")
    @Expose
    private String price1to9;
    @SerializedName("price10plus")
    @Expose
    private String price10plus;
    @SerializedName("pricefullrollmtrs")
    @Expose
    private String pricefullrollmtrs;
    @SerializedName("price1to9mtrs")
    @Expose
    private String price1to9mtrs;
    @SerializedName("price10plusmtrs")
    @Expose
    private String price10plusmtrs;
    @SerializedName("min_stock_mtr")
    @Expose
    private String minStockMtr;
    @SerializedName("max_stock_mtr")
    @Expose
    private String maxStockMtr;
    @SerializedName("min_stock_yrd")
    @Expose
    private String minStockYrd;
    @SerializedName("max_stock_yrd")
    @Expose
    private String maxStockYrd;
    @SerializedName("min_stock_user_mtr")
    @Expose
    private String minStockUserMtr;
    @SerializedName("min_stock_user_yrd")
    @Expose
    private String minStockUserYrd;
    @SerializedName("del_status")
    @Expose
    private String delStatus;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("color_desc")
    @Expose
    private String colorDesc;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("updated_date")
    @Expose
    private String updatedDate;
    @SerializedName("articleno")
    @Expose
    private String articleno;
    @SerializedName("occassion")
    @Expose
    private String occassion;
    @SerializedName("pattern")
    @Expose
    private String pattern;
    @SerializedName("fabric_type")
    @Expose
    private String fabricType;
    @SerializedName("color_code")
    @Expose
    private String colorCode;
    @SerializedName("composition")
    @Expose
    private String composition;
    @SerializedName("composition_code_id")
    @Expose
    private String compositionCodeId;
    @SerializedName("remain")
    @Expose
    private double remain;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleNoId() {
        return articleNoId;
    }

    public void setArticleNoId(String articleNoId) {
        this.articleNoId = articleNoId;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getColorsId() {
        return colorsId;
    }

    public void setColorsId(String colorsId) {
        this.colorsId = colorsId;
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

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getMainFabric() {
        return mainFabric;
    }

    public void setMainFabric(String mainFabric) {
        this.mainFabric = mainFabric;
    }

    public String getCostPrMtr() {
        return costPrMtr;
    }

    public void setCostPrMtr(String costPrMtr) {
        this.costPrMtr = costPrMtr;
    }

    public String getCostPrYrd() {
        return costPrYrd;
    }

    public void setCostPrYrd(String costPrYrd) {
        this.costPrYrd = costPrYrd;
    }

    public String getSellPrMtr() {
        return sellPrMtr;
    }

    public void setSellPrMtr(String sellPrMtr) {
        this.sellPrMtr = sellPrMtr;
    }

    public String getSellPrYrd() {
        return sellPrYrd;
    }

    public void setSellPrYrd(String sellPrYrd) {
        this.sellPrYrd = sellPrYrd;
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

    public String getPrice10plus() {
        return price10plus;
    }

    public void setPrice10plus(String price10plus) {
        this.price10plus = price10plus;
    }

    public String getPricefullrollmtrs() {
        return pricefullrollmtrs;
    }

    public void setPricefullrollmtrs(String pricefullrollmtrs) {
        this.pricefullrollmtrs = pricefullrollmtrs;
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

    public String getMinStockMtr() {
        return minStockMtr;
    }

    public void setMinStockMtr(String minStockMtr) {
        this.minStockMtr = minStockMtr;
    }

    public String getMaxStockMtr() {
        return maxStockMtr;
    }

    public void setMaxStockMtr(String maxStockMtr) {
        this.maxStockMtr = maxStockMtr;
    }

    public String getMinStockYrd() {
        return minStockYrd;
    }

    public void setMinStockYrd(String minStockYrd) {
        this.minStockYrd = minStockYrd;
    }

    public String getMaxStockYrd() {
        return maxStockYrd;
    }

    public void setMaxStockYrd(String maxStockYrd) {
        this.maxStockYrd = maxStockYrd;
    }

    public String getMinStockUserMtr() {
        return minStockUserMtr;
    }

    public void setMinStockUserMtr(String minStockUserMtr) {
        this.minStockUserMtr = minStockUserMtr;
    }

    public String getMinStockUserYrd() {
        return minStockUserYrd;
    }

    public void setMinStockUserYrd(String minStockUserYrd) {
        this.minStockUserYrd = minStockUserYrd;
    }

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColorDesc() {
        return colorDesc;
    }

    public void setColorDesc(String colorDesc) {
        this.colorDesc = colorDesc;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getArticleno() {
        return articleno;
    }

    public void setArticleno(String articleno) {
        this.articleno = articleno;
    }

    public String getOccassion() {
        return occassion;
    }

    public void setOccassion(String occassion) {
        this.occassion = occassion;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getFabricType() {
        return fabricType;
    }

    public void setFabricType(String fabricType) {
        this.fabricType = fabricType;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getCompositionCodeId() {
        return compositionCodeId;
    }

    public void setCompositionCodeId(String compositionCodeId) {
        this.compositionCodeId = compositionCodeId;
    }

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }

}

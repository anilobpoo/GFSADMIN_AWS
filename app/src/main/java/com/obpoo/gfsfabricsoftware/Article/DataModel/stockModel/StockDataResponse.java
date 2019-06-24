package com.obpoo.gfsfabricsoftware.Article.DataModel.stockModel;

/**
 * Created by obpoo on 11/14/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StockDataResponse implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("articleno")
    @Expose
    private String articleno;
    @SerializedName("note")
    @Expose
    private String note;
    @SerializedName("fabrictype")
    @Expose
    private String fabrictype;
    @SerializedName("hidethis")
    @Expose
    private String hidethis;
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
    @SerializedName("composition")
    @Expose
    private String composition;
    @SerializedName("occassion")
    @Expose
    private String occassion;
    @SerializedName("pattern")
    @Expose
    private String pattern;
    @SerializedName("threadcount")
    @Expose
    private String threadcount;
    @SerializedName("weave")
    @Expose
    private String weave;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("lastupdated")
    @Expose
    private String lastupdated;
    @SerializedName("fabric_type_name")
    @Expose
    private String fabricTypeName;
    @SerializedName("composition_code")
    @Expose
    private String compositionCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleno() {
        return articleno;
    }

    public void setArticleno(String articleno) {
        this.articleno = articleno;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFabrictype() {
        return fabrictype;
    }

    public void setFabrictype(String fabrictype) {
        this.fabrictype = fabrictype;
    }

    public String getHidethis() {
        return hidethis;
    }

    public void setHidethis(String hidethis) {
        this.hidethis = hidethis;
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

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
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

    public String getThreadcount() {
        return threadcount;
    }

    public void setThreadcount(String threadcount) {
        this.threadcount = threadcount;
    }

    public String getWeave() {
        return weave;
    }

    public void setWeave(String weave) {
        this.weave = weave;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
    }

    public String getFabricTypeName() {
        return fabricTypeName;
    }

    public void setFabricTypeName(String fabricTypeName) {
        this.fabricTypeName = fabricTypeName;
    }

    public String getCompositionCode() {
        return compositionCode;
    }

    public void setCompositionCode(String compositionCode) {
        this.compositionCode = compositionCode;
    }
}
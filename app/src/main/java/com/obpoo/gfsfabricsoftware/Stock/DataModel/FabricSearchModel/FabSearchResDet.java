package com.obpoo.gfsfabricsoftware.Stock.DataModel.FabricSearchModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by PHD on 2/4/2019.
 */

public class FabSearchResDet implements Serializable{
    @SerializedName("id")
    @Expose
    private String id;
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
    @SerializedName("stock")
    @Expose
    private ArrayList<FabricSearchStock> stock = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ArrayList<FabricSearchStock> getStock() {
        return stock;
    }

    public void setStock(ArrayList<FabricSearchStock> stock) {
        this.stock = stock;
    }
}

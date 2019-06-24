package com.obpoo.gfsfabricsoftware.Stock.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by PHD on 1/28/2019.
 */

public class ViewStockDetails implements Serializable {
    @SerializedName("shelf_id")
    @Expose
    private String shelfId;
    @SerializedName("stock")
    @Expose
    private ArrayList<StockInDetails> stock = null;

    public String getShelfId() {
        return shelfId;
    }

    public void setShelfId(String shelfId) {
        this.shelfId = shelfId;
    }

    public ArrayList<StockInDetails> getStock() {
        return stock;
    }

    public void setStock(ArrayList<StockInDetails> stock) {
        this.stock = stock;
    }
}

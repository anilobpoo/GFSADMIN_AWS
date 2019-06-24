package com.obpoo.gfsfabricsoftware.Stock.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ViewStockNewResponse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("page_count")
    @Expose
    private Integer pageCount;
    @SerializedName("page_no")
    @Expose
    private Integer pageNo;
    @SerializedName("data")
    @Expose
    private ArrayList<StockInDetails> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public ArrayList<StockInDetails> getData() {
        return data;
    }

    public void setData(ArrayList<StockInDetails> data) {
        this.data = data;
    }
}

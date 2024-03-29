package com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PHD on 2/28/2019.
 */

public class Ts_Response {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("page_count")
    @Expose
    private Integer pageCount;
    @SerializedName("data")
    @Expose
    private ArrayList<Ts_data> data = null;

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

    public ArrayList<Ts_data> getData() {
        return data;
    }

    public void setData(ArrayList<Ts_data> data) {
        this.data = data;
    }

}

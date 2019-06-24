package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.AddPOModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by PHD on 11/27/2018.
 */

public class AddPoPojo {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("last_po_id")
    @Expose
    private List<String> lastPoId = null;
    @SerializedName("last_co_id")
    @Expose
    private String lastCoId;

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

    public List<String> getLastPoId() {
        return lastPoId;
    }

    public void setLastPoId(List<String> lastPoId) {
        this.lastPoId = lastPoId;
    }

    public String getLastCoId() {
        return lastCoId;
    }

    public void setLastCoId(String lastCoId) {
        this.lastCoId = lastCoId;
    }
}

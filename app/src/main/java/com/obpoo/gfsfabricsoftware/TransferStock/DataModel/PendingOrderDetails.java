package com.obpoo.gfsfabricsoftware.TransferStock.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 2/7/2019.
 */

public class PendingOrderDetails {


    @SerializedName("id")
    @Expose
    private String id;

    public PendingOrderDetails(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return id;
    }

}

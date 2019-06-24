package com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 2/21/2019.
 */

public class FabricResponseDetails {
    @SerializedName("Month")
    @Expose
    private String month;
    @SerializedName("ordered_quantity")
    @Expose
    private String orderedQuantity;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setOrderedQuantity(String orderedQuantity) {
        this.orderedQuantity = orderedQuantity;
    }
}

package com.obpoo.gfsfabricsoftware.Dashboard.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 1/15/2019.
 */

public class FabricReport {
    @SerializedName("percent")
    @Expose
    private Double percent;
    @SerializedName("type")
    @Expose
    private String type;

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

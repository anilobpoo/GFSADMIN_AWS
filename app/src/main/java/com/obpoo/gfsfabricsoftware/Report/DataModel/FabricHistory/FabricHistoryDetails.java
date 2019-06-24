package com.obpoo.gfsfabricsoftware.Report.DataModel.FabricHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 2/21/2019.
 */

public class FabricHistoryDetails {
    @SerializedName("fab_name")
    @Expose
    private String fabName;

    public String getFabName() {
        return fabName;
    }

    public void setFabName(String fabName) {
        this.fabName = fabName;
    }

    @Override
    public String  toString(){
        return fabName;
    }
}

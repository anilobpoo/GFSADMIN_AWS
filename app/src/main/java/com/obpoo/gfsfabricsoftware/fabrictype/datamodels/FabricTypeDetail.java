package com.obpoo.gfsfabricsoftware.fabrictype.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FabricTypeDetail {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    @SerializedName("id")
    @Expose
    private String id;


    public String getFabric_type() {
        return fabric_type;
    }

    public void setFabric_type(String fabric_type) {
        this.fabric_type = fabric_type;
    }

    @SerializedName("fabric_type")
    @Expose
    private String fabric_type;


}

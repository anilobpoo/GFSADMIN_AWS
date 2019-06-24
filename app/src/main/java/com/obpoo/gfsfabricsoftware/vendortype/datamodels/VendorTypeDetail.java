package com.obpoo.gfsfabricsoftware.vendortype.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VendorTypeDetail {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendortype() {
        return vendortype;
    }

    public void setVendortype(String vendortype) {
        this.vendortype = vendortype;
    }

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("vendortype")
    @Expose
    private String vendortype;


}

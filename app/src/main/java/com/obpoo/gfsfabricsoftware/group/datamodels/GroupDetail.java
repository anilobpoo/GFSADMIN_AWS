package com.obpoo.gfsfabricsoftware.group.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GroupDetail {


    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("discount_per")
    @Expose
    private String discount_per;

    @SerializedName("status")
    @Expose
    private String status;

    public String getDiscount_per() {
        return discount_per;
    }

    public void setDiscount_per(String discount_per) {
        this.discount_per = discount_per;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_default() {
        return is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default;
    }

    @SerializedName("is_default")
    @Expose
    private String is_default;






    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

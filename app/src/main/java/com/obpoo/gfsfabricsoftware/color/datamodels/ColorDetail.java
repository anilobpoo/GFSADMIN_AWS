package com.obpoo.gfsfabricsoftware.color.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ColorDetail implements Serializable {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    @SerializedName("id")
    @Expose
    private String id;


    public String getColor_code() {
        return color_code;
    }

    public void setColor_code(String color_code) {
        this.color_code = color_code;
    }

    @SerializedName("color_code")
    @Expose
    private String color_code;


}

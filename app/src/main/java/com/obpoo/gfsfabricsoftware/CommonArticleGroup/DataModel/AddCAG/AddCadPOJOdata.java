package com.obpoo.gfsfabricsoftware.CommonArticleGroup.DataModel.AddCAG;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by PHD on 11/20/2018.
 */

public class AddCadPOJOdata implements Serializable{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("color_code")
    @Expose
    private String colorCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }
}

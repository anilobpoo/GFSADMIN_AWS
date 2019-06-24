package com.obpoo.gfsfabricsoftware.Composition.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComposotionDetail {


    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("composition")
    @Expose
    private String composition;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }
}

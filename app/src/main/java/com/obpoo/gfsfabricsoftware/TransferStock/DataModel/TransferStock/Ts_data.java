package com.obpoo.gfsfabricsoftware.TransferStock.DataModel.TransferStock;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by PHD on 2/28/2019.
 */

public class Ts_data  implements Serializable{
    @SerializedName("document")
    @Expose
    private String document;
    @SerializedName("fabrics")
    @Expose
    private ArrayList<Ts_fabric> fabrics = null;

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public ArrayList<Ts_fabric> getFabrics() {
        return fabrics;
    }

    public void setFabrics(ArrayList<Ts_fabric> fabrics) {
        this.fabrics = fabrics;
    }
}

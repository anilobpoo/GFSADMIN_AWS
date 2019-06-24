package com.obpoo.gfsfabricsoftware.bank.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BankDetail {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    @SerializedName("id")
    @Expose
    private String id;

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    @SerializedName("bankname")
    @Expose
    private String bankname;


}

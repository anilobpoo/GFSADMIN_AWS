package com.obpoo.gfsfabricsoftware.salesorder.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerDetailData {


    @SerializedName("customer_name")
    @Expose
    private String customer_name;


    @SerializedName("address")
    @Expose
    private String address;


    @SerializedName("country")
    @Expose
    private String country;


    @SerializedName("phone")
    @Expose
    private String phone;


    @SerializedName("email")
    @Expose
    private String email;



    @SerializedName("zipcode")
    @Expose
    private String zipcode;


    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}

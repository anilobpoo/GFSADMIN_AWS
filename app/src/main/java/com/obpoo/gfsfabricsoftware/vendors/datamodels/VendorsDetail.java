package com.obpoo.gfsfabricsoftware.vendors.datamodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VendorsDetail implements Parcelable {



    @SerializedName("vendorID")
    @Expose
    private String vendorID;
    @SerializedName("vendorno")
    @Expose
    private String vendorno;

    @SerializedName("vendor")
    @Expose
    private String vendor;
    @SerializedName("vendortype")
    @Expose
    private String vendortype;



    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("telephone")
    @Expose
    private String telephone;

    protected VendorsDetail(Parcel in) {
        vendorID = in.readString();
        vendorno = in.readString();
        vendor = in.readString();
        vendortype = in.readString();
        address = in.readString();
        telephone = in.readString();
        fax = in.readString();
        email = in.readString();
        zipcode = in.readString();
        name = in.readString();
        country = in.readString();
    }

    public static final Creator<VendorsDetail> CREATOR = new Creator<VendorsDetail>() {
        @Override
        public VendorsDetail createFromParcel(Parcel in) {
            return new VendorsDetail(in);
        }

        @Override
        public VendorsDetail[] newArray(int size) {
            return new VendorsDetail[size];
        }
    };

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    public String getVendorno() {
        return vendorno;
    }

    public void setVendorno(String vendorno) {
        this.vendorno = vendorno;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendortype() {
        return vendortype;
    }

    public void setVendortype(String vendortype) {
        this.vendortype = vendortype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("country")
    @Expose
    private String country;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(vendorID);
        dest.writeString(vendorno);
        dest.writeString(vendor);
        dest.writeString(vendortype);
        dest.writeString(address);
        dest.writeString(telephone);
        dest.writeString(fax);
        dest.writeString(email);
        dest.writeString(zipcode);
        dest.writeString(name);
        dest.writeString(country);
    }
}

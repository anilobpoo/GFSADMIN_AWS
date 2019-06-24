package com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllOrderCusDet implements Parcelable {
    @SerializedName("customer_name")
    @Expose
    private String customerName;
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

    protected AllOrderCusDet(Parcel in) {
        customerName = in.readString();
        address = in.readString();
        country = in.readString();
        phone = in.readString();
        email = in.readString();
        zipcode = in.readString();
    }

    public static final Creator<AllOrderCusDet> CREATOR = new Creator<AllOrderCusDet>() {
        @Override
        public AllOrderCusDet createFromParcel(Parcel in) {
            return new AllOrderCusDet(in);
        }

        @Override
        public AllOrderCusDet[] newArray(int size) {
            return new AllOrderCusDet[size];
        }
    };

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(customerName);
        dest.writeString(address);
        dest.writeString(country);
        dest.writeString(phone);
        dest.writeString(email);
        dest.writeString(zipcode);
    }
}

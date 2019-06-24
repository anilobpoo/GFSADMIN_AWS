package com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllOrderStatusRes implements Parcelable {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<AllORderStatusData> data = null;

    protected AllOrderStatusRes(Parcel in) {
        status = in.readString();
        message = in.readString();
    }

    public static final Creator<AllOrderStatusRes> CREATOR = new Creator<AllOrderStatusRes>() {
        @Override
        public AllOrderStatusRes createFromParcel(Parcel in) {
            return new AllOrderStatusRes(in);
        }

        @Override
        public AllOrderStatusRes[] newArray(int size) {
            return new AllOrderStatusRes[size];
        }
    };

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<AllORderStatusData> getData() {
        return data;
    }

    public void setData(ArrayList<AllORderStatusData> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(message);
    }
}

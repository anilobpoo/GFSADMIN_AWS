package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TrackPOByCusRes implements Parcelable {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<TrackPObyCusData> data = null;

    protected TrackPOByCusRes(Parcel in) {
        status = in.readString();
        message = in.readString();
    }

    public static final Creator<TrackPOByCusRes> CREATOR = new Creator<TrackPOByCusRes>() {
        @Override
        public TrackPOByCusRes createFromParcel(Parcel in) {
            return new TrackPOByCusRes(in);
        }

        @Override
        public TrackPOByCusRes[] newArray(int size) {
            return new TrackPOByCusRes[size];
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

    public ArrayList<TrackPObyCusData> getData() {
        return data;
    }

    public void setData(ArrayList<TrackPObyCusData> data) {
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

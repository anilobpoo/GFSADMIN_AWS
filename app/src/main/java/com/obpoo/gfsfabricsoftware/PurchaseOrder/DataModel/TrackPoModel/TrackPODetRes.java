package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TrackPODetRes implements Parcelable {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<TrackPODetData> data = null;

    protected TrackPODetRes(Parcel in) {
        status = in.readString();
        message = in.readString();
        data = in.createTypedArrayList(TrackPODetData.CREATOR);
    }

    public static final Creator<TrackPODetRes> CREATOR = new Creator<TrackPODetRes>() {
        @Override
        public TrackPODetRes createFromParcel(Parcel in) {
            return new TrackPODetRes(in);
        }

        @Override
        public TrackPODetRes[] newArray(int size) {
            return new TrackPODetRes[size];
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

    public ArrayList<TrackPODetData> getData() {
        return data;
    }

    public void setData(ArrayList<TrackPODetData> data) {
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
        dest.writeTypedList(data);
    }
}

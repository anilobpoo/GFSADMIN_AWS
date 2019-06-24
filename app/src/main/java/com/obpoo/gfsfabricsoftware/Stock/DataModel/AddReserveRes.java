package com.obpoo.gfsfabricsoftware.Stock.DataModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by PHD on 2/12/2019.
 */

public class AddReserveRes implements Parcelable {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<AddReserveDet> data = null;

    protected AddReserveRes(Parcel in) {
        status = in.readString();
        message = in.readString();
        data = in.createTypedArrayList(AddReserveDet.CREATOR);
    }

    public static final Creator<AddReserveRes> CREATOR = new Creator<AddReserveRes>() {
        @Override
        public AddReserveRes createFromParcel(Parcel in) {
            return new AddReserveRes(in);
        }

        @Override
        public AddReserveRes[] newArray(int size) {
            return new AddReserveRes[size];
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

    public ArrayList<AddReserveDet> getData() {
        return data;
    }

    public void setData( ArrayList<AddReserveDet>  data) {
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

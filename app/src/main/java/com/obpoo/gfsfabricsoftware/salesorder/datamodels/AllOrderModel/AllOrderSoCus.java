package com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllOrderSoCus implements Parcelable {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private ArrayList<AllOrderCusDet> data = null;

    protected AllOrderSoCus(Parcel in) {
        status = in.readString();
        data = in.createTypedArrayList(AllOrderCusDet.CREATOR);
    }

    public static final Creator<AllOrderSoCus> CREATOR = new Creator<AllOrderSoCus>() {
        @Override
        public AllOrderSoCus createFromParcel(Parcel in) {
            return new AllOrderSoCus(in);
        }

        @Override
        public AllOrderSoCus[] newArray(int size) {
            return new AllOrderSoCus[size];
        }
    };

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<AllOrderCusDet> getData() {
        return data;
    }

    public void setData(ArrayList<AllOrderCusDet> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeTypedList(data);
    }
}

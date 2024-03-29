package com.obpoo.gfsfabricsoftware.vendors.datamodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class VendorsResponse implements Parcelable {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private ArrayList<VendorsDetail> detail;

    protected VendorsResponse(Parcel in) {
        status = in.readString();
        message = in.readString();
        detail = in.createTypedArrayList(VendorsDetail.CREATOR);
    }

    public static final Creator<VendorsResponse> CREATOR = new Creator<VendorsResponse>() {
        @Override
        public VendorsResponse createFromParcel(Parcel in) {
            return new VendorsResponse(in);
        }

        @Override
        public VendorsResponse[] newArray(int size) {
            return new VendorsResponse[size];
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


    public ArrayList<VendorsDetail> getDetail() {
        return detail;
    }

    public void setDetail(ArrayList<VendorsDetail> detail) {
        this.detail = detail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeString(message);
        dest.writeTypedList(detail);
    }
}

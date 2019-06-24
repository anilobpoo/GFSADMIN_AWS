package com.obpoo.gfsfabricsoftware.salesorder.datamodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class MyOrdersResponse implements Parcelable {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String message;

    protected MyOrdersResponse(Parcel in) {
        status = in.readString();
        message = in.readString();
        last_id = in.readString();
    }

    public static final Creator<MyOrdersResponse> CREATOR = new Creator<MyOrdersResponse>() {
        @Override
        public MyOrdersResponse createFromParcel(Parcel in) {
            return new MyOrdersResponse(in);
        }

        @Override
        public MyOrdersResponse[] newArray(int size) {
            return new MyOrdersResponse[size];
        }
    };

    public String getLast_id() {
        return last_id;
    }
    public void setLast_id(String last_id) {
        this.last_id = last_id;
    }

    @SerializedName("last_id")
    @Expose
    private String last_id;

    @SerializedName("data")
    @Expose
    private ArrayList<MyOrdersDetail> detail;

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


    public ArrayList<MyOrdersDetail> getDetail() {
        return detail;
    }

    public void setDetail(ArrayList<MyOrdersDetail> detail) {
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
        dest.writeString(last_id);
    }
}

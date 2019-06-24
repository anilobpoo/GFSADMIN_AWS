package com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllOrderRes implements Parcelable {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("page_count")
    @Expose
    private Integer pageCount;
    @SerializedName("data")
    @Expose
    private ArrayList<AllOrderSOData> data = null;

    protected AllOrderRes(Parcel in) {
        status = in.readString();
        message = in.readString();
        if (in.readByte() == 0) {
            pageCount = null;
        } else {
            pageCount = in.readInt();
        }
        data = in.createTypedArrayList(AllOrderSOData.CREATOR);
    }

    public static final Creator<AllOrderRes> CREATOR = new Creator<AllOrderRes>() {
        @Override
        public AllOrderRes createFromParcel(Parcel in) {
            return new AllOrderRes(in);
        }

        @Override
        public AllOrderRes[] newArray(int size) {
            return new AllOrderRes[size];
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

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public ArrayList<AllOrderSOData> getData() {
        return data;
    }

    public void setData(ArrayList<AllOrderSOData> data) {
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
        if (pageCount == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(pageCount);
        }
        dest.writeTypedList(data);
    }
}

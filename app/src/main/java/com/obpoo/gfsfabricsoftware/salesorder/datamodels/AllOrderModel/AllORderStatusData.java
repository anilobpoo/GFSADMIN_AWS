package com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllORderStatusData  implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("status_text")
    @Expose
    private String statusText;
    @SerializedName("status_desc")
    @Expose
    private String statusDesc;

    protected AllORderStatusData(Parcel in) {
        id = in.readString();
        statusText = in.readString();
        statusDesc = in.readString();
    }

    public static final Creator<AllORderStatusData> CREATOR = new Creator<AllORderStatusData>() {
        @Override
        public AllORderStatusData createFromParcel(Parcel in) {
            return new AllORderStatusData(in);
        }

        @Override
        public AllORderStatusData[] newArray(int size) {
            return new AllORderStatusData[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(statusText);
        dest.writeString(statusDesc);
    }
}

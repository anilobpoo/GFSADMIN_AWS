package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PoFilterResponse implements Parcelable {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<FilterDatum> data = null;

    protected PoFilterResponse(Parcel in) {
        status = in.readString();
        message = in.readString();
    }

    public static final Creator<PoFilterResponse> CREATOR = new Creator<PoFilterResponse>() {
        @Override
        public PoFilterResponse createFromParcel(Parcel in) {
            return new PoFilterResponse(in);
        }

        @Override
        public PoFilterResponse[] newArray(int size) {
            return new PoFilterResponse[size];
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

    public ArrayList<FilterDatum> getData() {
        return data;
    }

    public void setData(ArrayList<FilterDatum> data) {
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

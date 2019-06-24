package com.obpoo.gfsfabricsoftware.collections.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CollectionsDResponse implements Parcelable {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<CollectionDatum> data = null;

    protected CollectionsDResponse(Parcel in) {
        status = in.readString();
        message = in.readString();
        data = in.createTypedArrayList(CollectionDatum.CREATOR);
    }

    public static final Creator<CollectionsDResponse> CREATOR = new Creator<CollectionsDResponse>() {
        @Override
        public CollectionsDResponse createFromParcel(Parcel in) {
            return new CollectionsDResponse(in);
        }

        @Override
        public CollectionsDResponse[] newArray(int size) {
            return new CollectionsDResponse[size];
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

    public ArrayList<CollectionDatum> getData() {
        return data;
    }

    public void setData(ArrayList<CollectionDatum> data) {
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

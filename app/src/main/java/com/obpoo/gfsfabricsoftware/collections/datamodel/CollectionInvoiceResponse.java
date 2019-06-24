package com.obpoo.gfsfabricsoftware.collections.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CollectionInvoiceResponse implements Parcelable {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ArrayList<InvoiceDatum> data = null;

    protected CollectionInvoiceResponse(Parcel in) {
        status = in.readString();
        message = in.readString();
        data = in.createTypedArrayList(InvoiceDatum.CREATOR);
    }

    public static final Creator<CollectionInvoiceResponse> CREATOR = new Creator<CollectionInvoiceResponse>() {
        @Override
        public CollectionInvoiceResponse createFromParcel(Parcel in) {
            return new CollectionInvoiceResponse(in);
        }

        @Override
        public CollectionInvoiceResponse[] newArray(int size) {
            return new CollectionInvoiceResponse[size];
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

    public ArrayList<InvoiceDatum> getData() {
        return data;
    }

    public void setData(ArrayList<InvoiceDatum> data) {
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

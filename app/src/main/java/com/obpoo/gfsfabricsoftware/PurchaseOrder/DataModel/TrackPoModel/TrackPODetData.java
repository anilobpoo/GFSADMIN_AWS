package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.TrackPoModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TrackPODetData implements Parcelable {
    @SerializedName("items")
    @Expose
    private ArrayList<TrackPODetItems> items = null;

    protected TrackPODetData(Parcel in) {
        items = in.createTypedArrayList(TrackPODetItems.CREATOR);
    }

    public static final Creator<TrackPODetData> CREATOR = new Creator<TrackPODetData>() {
        @Override
        public TrackPODetData createFromParcel(Parcel in) {
            return new TrackPODetData(in);
        }

        @Override
        public TrackPODetData[] newArray(int size) {
            return new TrackPODetData[size];
        }
    };

    public ArrayList<TrackPODetItems> getItems() {
        return items;
    }

    public void setItems(ArrayList<TrackPODetItems> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(items);
    }
}

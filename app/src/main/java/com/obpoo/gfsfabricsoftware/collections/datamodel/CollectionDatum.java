package com.obpoo.gfsfabricsoftware.collections.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CollectionDatum implements Parcelable {

    @SerializedName("pickup_guy")
    @Expose
    private String pickupGuy;
    @SerializedName("transactions")
    @Expose
    private List<Transactions> transactions = null;

    protected CollectionDatum(Parcel in) {
        pickupGuy = in.readString();
        transactions = in.createTypedArrayList(Transactions.CREATOR);
    }

    public static final Creator<CollectionDatum> CREATOR = new Creator<CollectionDatum>() {
        @Override
        public CollectionDatum createFromParcel(Parcel in) {
            return new CollectionDatum(in);
        }

        @Override
        public CollectionDatum[] newArray(int size) {
            return new CollectionDatum[size];
        }
    };

    public String getPickupGuy() {
        return pickupGuy;
    }

    public void setPickupGuy(String pickupGuy) {
        this.pickupGuy = pickupGuy;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pickupGuy);
        dest.writeTypedList(transactions);
    }
}

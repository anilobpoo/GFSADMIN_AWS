package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilterDatum implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;

    protected FilterDatum(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public static final Creator<FilterDatum> CREATOR = new Creator<FilterDatum>() {
        @Override
        public FilterDatum createFromParcel(Parcel in) {
            return new FilterDatum(in);
        }

        @Override
        public FilterDatum[] newArray(int size) {
            return new FilterDatum[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
    }
}

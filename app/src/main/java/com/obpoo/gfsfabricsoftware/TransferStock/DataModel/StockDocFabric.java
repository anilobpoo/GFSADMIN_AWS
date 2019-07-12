package com.obpoo.gfsfabricsoftware.TransferStock.DataModel;import android.os.Parcel;import android.os.Parcelable;import com.google.gson.annotations.Expose;import com.google.gson.annotations.SerializedName;public class StockDocFabric implements Parcelable {    @SerializedName("id")    @Expose    private String id;    @SerializedName("document")    @Expose    private String document;    @SerializedName("fab_name")    @Expose    private String fabName;    @SerializedName("unique_code")    @Expose    private String uniqueCode;    @SerializedName("from_ware")    @Expose    private String fromWare;    @SerializedName("to_ware")    @Expose    private String toWare;    @SerializedName("status")    @Expose    private String status;    @SerializedName("created")    @Expose    private String created;    @SerializedName("from_warehouse")    @Expose    private String fromWarehouse;    @SerializedName("to_warehouse")    @Expose    private String toWarehouse;    @SerializedName("zone")    @Expose    private Boolean zone;    @SerializedName("shelf")    @Expose    private Boolean shelf;    protected StockDocFabric(Parcel in) {        id = in.readString();        document = in.readString();        fabName = in.readString();        uniqueCode = in.readString();        fromWare = in.readString();        toWare = in.readString();        status = in.readString();        created = in.readString();        fromWarehouse = in.readString();        toWarehouse = in.readString();        byte tmpZone = in.readByte();        zone = tmpZone == 0 ? null : tmpZone == 1;        byte tmpShelf = in.readByte();        shelf = tmpShelf == 0 ? null : tmpShelf == 1;    }    public static final Creator<StockDocFabric> CREATOR = new Creator<StockDocFabric>() {        @Override        public StockDocFabric createFromParcel(Parcel in) {            return new StockDocFabric(in);        }        @Override        public StockDocFabric[] newArray(int size) {            return new StockDocFabric[size];        }    };    public String getId() {        return id;    }    public void setId(String id) {        this.id = id;    }    public String getDocument() {        return document;    }    public void setDocument(String document) {        this.document = document;    }    public String getFabName() {        return fabName;    }    public void setFabName(String fabName) {        this.fabName = fabName;    }    public String getUniqueCode() {        return uniqueCode;    }    public void setUniqueCode(String uniqueCode) {        this.uniqueCode = uniqueCode;    }    public String getFromWare() {        return fromWare;    }    public void setFromWare(String fromWare) {        this.fromWare = fromWare;    }    public String getToWare() {        return toWare;    }    public void setToWare(String toWare) {        this.toWare = toWare;    }    public String getStatus() {        return status;    }    public void setStatus(String status) {        this.status = status;    }    public String getCreated() {        return created;    }    public void setCreated(String created) {        this.created = created;    }    public String getFromWarehouse() {        return fromWarehouse;    }    public void setFromWarehouse(String fromWarehouse) {        this.fromWarehouse = fromWarehouse;    }    public String getToWarehouse() {        return toWarehouse;    }    public void setToWarehouse(String toWarehouse) {        this.toWarehouse = toWarehouse;    }    public Boolean getZone() {        return zone;    }    public void setZone(Boolean zone) {        this.zone = zone;    }    public Boolean getShelf() {        return shelf;    }    public void setShelf(Boolean shelf) {        this.shelf = shelf;    }    @Override    public int describeContents() {        return 0;    }    @Override    public void writeToParcel(Parcel dest, int flags) {        dest.writeString(id);        dest.writeString(document);        dest.writeString(fabName);        dest.writeString(uniqueCode);        dest.writeString(fromWare);        dest.writeString(toWare);        dest.writeString(status);        dest.writeString(created);        dest.writeString(fromWarehouse);        dest.writeString(toWarehouse);        dest.writeByte((byte) (zone == null ? 0 : zone ? 1 : 2));        dest.writeByte((byte) (shelf == null ? 0 : shelf ? 1 : 2));    }}
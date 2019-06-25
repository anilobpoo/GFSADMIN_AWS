package com.obpoo.gfsfabricsoftware.Stock.DataModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by PHD on 2/12/2019.
 */

public class AddReserveDet implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("fab_name")
    @Expose
    private String fabName;
    @SerializedName("fab_img")
    @Expose
    private String fabImg;

    protected AddReserveDet(Parcel in) {
        id = in.readString();
        fabName = in.readString();
        fabImg = in.readString();
        colorCode = in.readString();
        qtyType = in.readString();
        qrcode = in.readString();
        articleno = in.readString();
        composition = in.readString();
        qty = in.readString();
    }

    public static final Creator<AddReserveDet> CREATOR = new Creator<AddReserveDet>() {
        @Override
        public AddReserveDet createFromParcel(Parcel in) {
            return new AddReserveDet(in);
        }

        @Override
        public AddReserveDet[] newArray(int size) {
            return new AddReserveDet[size];
        }
    };

    public String getQtyType() {
        return qtyType;
    }

    public void setQtyType(String qtyType) {
        this.qtyType = qtyType;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    @SerializedName("color_code")
    @Expose
    private String colorCode;

    String qtyType,qrcode;



    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @SerializedName("articleno")
    @Expose
    private String articleno;
    @SerializedName("composition")
    @Expose
    private String composition;

    String qty;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFabName() {
        return fabName;
    }

    public void setFabName(String fabName) {
        this.fabName = fabName;
    }

    public String getFabImg() {
        return fabImg;
    }

    public void setFabImg(String fabImg) {
        this.fabImg = fabImg;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getArticleno() {
        return articleno;
    }

    public void setArticleno(String articleno) {
        this.articleno = articleno;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    public AddReserveDet(String fabName, String composition, String qty) {
        this.fabName = fabName;
        this.composition = composition;
        this.qty = qty;
    }

    public AddReserveDet(String id, String qtyType, String qrcode, String qty) {
        this.id = id;
        this.qtyType = qtyType;
        this.qrcode = qrcode;
        this.qty = qty;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(fabName);
        dest.writeString(fabImg);
        dest.writeString(colorCode);
        dest.writeString(qtyType);
        dest.writeString(qrcode);
        dest.writeString(articleno);
        dest.writeString(composition);
        dest.writeString(qty);
    }
}

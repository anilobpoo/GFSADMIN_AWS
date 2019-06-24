package com.obpoo.gfsfabricsoftware.collections.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transactions implements Parcelable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("updated_on")
    @Expose
    private String updatedOn;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("type_id")
    @Expose
    private String typeId;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("applied_ammount")
    @Expose
    private String appliedAmmount;
    @SerializedName("chq_no")
    @Expose
    private String chqNo;
    @SerializedName("due_date")
    @Expose
    private String dueDate;
    @SerializedName("bank")
    @Expose
    private String bank;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("sv_confirm")
    @Expose
    private String svConfirm;
    @SerializedName("cash_confirm")
    @Expose
    private String cashConfirm;
    @SerializedName("asv_confirm")
    @Expose
    private String asvConfirm;
    @SerializedName("pick_up_guy")
    @Expose
    private String pickUpGuy;
    @SerializedName("created_by")
    @Expose
    private String createdBy;
    @SerializedName("sum")
    @Expose
    private String sum;
    @SerializedName("counts")
    @Expose
    private String counts;

    protected Transactions(Parcel in) {
        id = in.readString();
        createdOn = in.readString();
        updatedOn = in.readString();
        from = in.readString();
        type = in.readString();
        typeId = in.readString();
        number = in.readString();
        notes = in.readString();
        appliedAmmount = in.readString();
        chqNo = in.readString();
        dueDate = in.readString();
        bank = in.readString();
        currency = in.readString();
        status = in.readString();
        svConfirm = in.readString();
        cashConfirm = in.readString();
        asvConfirm = in.readString();
        pickUpGuy = in.readString();
        createdBy = in.readString();
        sum = in.readString();
        counts = in.readString();
    }

    public static final Creator<Transactions> CREATOR = new Creator<Transactions>() {
        @Override
        public Transactions createFromParcel(Parcel in) {
            return new Transactions(in);
        }

        @Override
        public Transactions[] newArray(int size) {
            return new Transactions[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAppliedAmmount() {
        return appliedAmmount;
    }

    public void setAppliedAmmount(String appliedAmmount) {
        this.appliedAmmount = appliedAmmount;
    }

    public String getChqNo() {
        return chqNo;
    }

    public void setChqNo(String chqNo) {
        this.chqNo = chqNo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSvConfirm() {
        return svConfirm;
    }

    public void setSvConfirm(String svConfirm) {
        this.svConfirm = svConfirm;
    }

    public String getCashConfirm() {
        return cashConfirm;
    }

    public void setCashConfirm(String cashConfirm) {
        this.cashConfirm = cashConfirm;
    }

    public String getAsvConfirm() {
        return asvConfirm;
    }

    public void setAsvConfirm(String asvConfirm) {
        this.asvConfirm = asvConfirm;
    }

    public String getPickUpGuy() {
        return pickUpGuy;
    }

    public void setPickUpGuy(String pickUpGuy) {
        this.pickUpGuy = pickUpGuy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(createdOn);
        dest.writeString(updatedOn);
        dest.writeString(from);
        dest.writeString(type);
        dest.writeString(typeId);
        dest.writeString(number);
        dest.writeString(notes);
        dest.writeString(appliedAmmount);
        dest.writeString(chqNo);
        dest.writeString(dueDate);
        dest.writeString(bank);
        dest.writeString(currency);
        dest.writeString(status);
        dest.writeString(svConfirm);
        dest.writeString(cashConfirm);
        dest.writeString(asvConfirm);
        dest.writeString(pickUpGuy);
        dest.writeString(createdBy);
        dest.writeString(sum);
        dest.writeString(counts);
    }
}

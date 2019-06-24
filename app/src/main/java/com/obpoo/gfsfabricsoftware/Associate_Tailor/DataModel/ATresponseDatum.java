package com.obpoo.gfsfabricsoftware.Associate_Tailor.DataModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ATresponseDatum implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("ts_id")
    @Expose
    private String tsId;
    @SerializedName("tailor_email")
    @Expose
    private String tailorEmail;
    @SerializedName("activity")
    @Expose
    private String activity;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("tailor_info")
    @Expose
    private ATTailorInfo tailorInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTsId() {
        return tsId;
    }

    public void setTsId(String tsId) {
        this.tsId = tsId;
    }

    public String getTailorEmail() {
        return tailorEmail;
    }

    public void setTailorEmail(String tailorEmail) {
        this.tailorEmail = tailorEmail;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public ATTailorInfo getTailorInfo() {
        return tailorInfo;
    }

    public void setTailorInfo(ATTailorInfo tailorInfo) {
        this.tailorInfo = tailorInfo;
    }

}

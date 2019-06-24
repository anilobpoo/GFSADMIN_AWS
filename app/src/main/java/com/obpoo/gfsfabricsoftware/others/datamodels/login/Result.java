package com.obpoo.gfsfabricsoftware.others.datamodels.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result{

        @SerializedName("user_id")
        @Expose
        private String user_id;
        @SerializedName("active")
        @Expose
        private String active;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("profile_pic")
        @Expose
        private String profile_pic;
        @SerializedName("designation")
        @Expose
        private String designation;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPreviledges() {
        return previledges;
    }

    public void setPreviledges(String previledges) {
        this.previledges = previledges;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getLog_details_id() {
        return log_details_id;
    }

    public void setLog_details_id(String log_details_id) {
        this.log_details_id = log_details_id;
    }

    @SerializedName("previledges")

        @Expose
        private String previledges;
        @SerializedName("dept_id")
        @Expose
        private String dept_id;
        @SerializedName("dept_name")
        @Expose
        private String dept_name;
        @SerializedName("log_details_id")
        @Expose
        private String log_details_id;
}

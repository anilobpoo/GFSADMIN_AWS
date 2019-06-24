package com.obpoo.gfsfabricsoftware.user.datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class UserDetail implements Serializable {


    @SerializedName("user_id")
    @Expose
    private String id;

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

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("token")
    @Expose
    private String token;


    @SerializedName("previledges")
    @Expose
    private ArrayList<String> previledges;

    @SerializedName("dept_id")
    @Expose
    private String dept_id;

    @SerializedName("created")
    @Expose
    private String created;


    @SerializedName("updated")
    @Expose
    private String updated;

    @SerializedName("created_by")
    @Expose
    private String created_by;

    @SerializedName("updated_by")
    @Expose
    private String updated_by;

    @SerializedName("deptname")
    @Expose
    private String deptname;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ArrayList<String> getPreviledges() {
        return previledges;
    }

    public void setPreviledges(ArrayList<String> previledges) {
        this.previledges = previledges;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
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

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }




}

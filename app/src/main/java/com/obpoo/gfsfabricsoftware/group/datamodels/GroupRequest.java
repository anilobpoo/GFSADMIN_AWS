package com.obpoo.gfsfabricsoftware.group.datamodels;

public class GroupRequest {


    String method;
    String id;
    String discount_per;
    String admin_id;

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getMethod() {
        return method;
    }

    public GroupRequest(String id, String method,String name, String discount_per,String admin_id) {
        this.id = id;
        this.name = name;
        this.discount_per = discount_per;
        this.method = method;
        this.admin_id = admin_id;

    }
    public GroupRequest(String method,String name, String discount_per,String admin_id) {

        this.name = name;
        this.discount_per = discount_per;
        this.method = method;
        this.admin_id=admin_id;

    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiscount_per() {
        return discount_per;
    }

    public void setDiscount_per(String discount_per) {
        this.discount_per = discount_per;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public GroupRequest(String method,String admin_id) {
        this.method = method;
        this.admin_id=admin_id;
    }

    public GroupRequest(String method,String id,String del) {
        this.method = method;
        this.id=id;
    }
}

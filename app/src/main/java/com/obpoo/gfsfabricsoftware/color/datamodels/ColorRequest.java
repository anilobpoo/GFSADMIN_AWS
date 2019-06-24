package com.obpoo.gfsfabricsoftware.color.datamodels;

public class ColorRequest {


    String method;
    String id;

    public String getMethod() {
        return method;
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

    public String getColor_code() {
        return color_code;
    }

    public void setColor_code(String color_code) {
        this.color_code = color_code;
    }

    String color_code;

    public ColorRequest(String method) {
        this.method = method;
    }

    public ColorRequest(String method,String id) {
        this.method = method;
        this.id = id;
    }
    public ColorRequest(String method,String color_code,String add) {
        this.method = method;
        this.color_code = color_code;
    }
    public ColorRequest(String method,String color_code,String id,String update) {
        this.method = method;
        this.color_code = color_code;
        this.id = id;
    }
}

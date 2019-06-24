package com.obpoo.gfsfabricsoftware.shop.datamodels;

public class ViewShopRequest {


    String method;
    String name;
    String min_max_type;
    String id;
    String location;
    String address;

    public ViewShopRequest(String method) {
        this.method = method;
    }

    public ViewShopRequest(String method, String name, String location, String address, String min_max_type) {
        this.address = address;
        this.min_max_type = min_max_type;
        this.location = location;
        this.method = method;
        this.address = address;
        this.name = name;
    }

    public ViewShopRequest(String method,String name, String location, String address,String min_max_type, String id) {
        this.address = address;
        this.min_max_type = min_max_type;
        this.location = location;
        this.method = method;
        this.address = address;
        this.name = name;
        this.id = id;
    }
    public ViewShopRequest(String method,String id) {
        this.method = method;
        this.id = id;
    }
    public ViewShopRequest(String method,String id,String editone) {
        this.method = method;
        this.id = id;
    }

}

package com.obpoo.gfsfabricsoftware.vendortype.datamodels;

public class VendorTypeRequest {


    String method,name,id;

    public VendorTypeRequest(String method) {
        this.method = method;
    }
    public VendorTypeRequest(String method,String name) {
        this.name = name;
        this.method = method;
    }
    public VendorTypeRequest(String method,String name,String id) {
        this.name = name;
        this.method = method;
        this.id = id;
    }
    public VendorTypeRequest(String method,String id,String del,String dels) {
        this.method = method;
        this.id = id;
    }
}

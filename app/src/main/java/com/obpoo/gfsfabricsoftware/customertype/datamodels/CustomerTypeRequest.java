package com.obpoo.gfsfabricsoftware.customertype.datamodels;

public class CustomerTypeRequest {


    String method;
    String customer_type;String id;

    public CustomerTypeRequest(String method) {
        this.method = method;
    }
    public CustomerTypeRequest(String method,String customer_type,String id) {
        this.method = method;
        this.customer_type = customer_type;
        this.id = id;
    }
    public CustomerTypeRequest(String method,String customer_type) {
        this.method = method;
        this.customer_type = customer_type;
    }
    public CustomerTypeRequest(String method,String id,String del,String dels) {
        this.method = method;
        this.id = id;
    }

}

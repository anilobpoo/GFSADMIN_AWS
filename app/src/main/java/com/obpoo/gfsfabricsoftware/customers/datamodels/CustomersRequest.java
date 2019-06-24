package com.obpoo.gfsfabricsoftware.customers.datamodels;

public class CustomersRequest {


    String method;
    String user_id;

    String customer_name,customer_type_id,vat_name,password,shop_id,customer_group,address,user_name,country,zipcode,phone,fax,email,id;

    public CustomersRequest(String method,String user_id) {
        this.method = method;
        this.user_id = user_id;
    }

    public CustomersRequest(String method,String id,String del) {
        this.method = method;
        this.id = id;
    }
    public CustomersRequest(String method,String user_id,String customer_name,String customer_type_id,String vat_name,
                            String password,String shop_id,String customer_group,
                            String address,String user_name,String country,String zipcode,String phone,String fax,String email ) {
        this.method = method;
        this.user_id = user_id;
        this.customer_name = customer_name;
        this.customer_type_id = customer_type_id;
        this.vat_name = vat_name;
        this.password = password;
        this.customer_group = customer_group;
        this.user_name = user_name;
        this.country = country;
        this.zipcode = zipcode;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.shop_id = shop_id;
        this.address = address;
    }

    public CustomersRequest(String id ,String method,String user_id,String customer_name,String customer_type_id,String vat_name,
                            String password,String shop_id,String customer_group,
                            String address,String user_name,String country,String zipcode,String phone,String fax,String email ) {
        this.method = method;
        this.user_id = user_id;
        this.customer_name = customer_name;
        this.customer_type_id = customer_type_id;
        this.vat_name = vat_name;
        this.password = password;
        this.customer_group = customer_group;
        this.user_name = user_name;
        this.country = country;
        this.zipcode = zipcode;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.shop_id = shop_id;
        this.address = address;
        this.id = id;
    }


    public CustomersRequest(String method,String id,String del,String getone) {
        this.method = method;
        this.id = id;
    }
}

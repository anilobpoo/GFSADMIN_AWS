package com.obpoo.gfsfabricsoftware.vendors.datamodels;

public class ViewVendorsRequest {


    String method,vendorno,vendor,vendortype,address,country,zipcode,telephone,fax,email,id;

    public ViewVendorsRequest(String method) {
        this.method = method;
    }
    public ViewVendorsRequest(String method,String id) {
        this.method = method;
        this.id = id;
    }

    public ViewVendorsRequest(String method,String id,String del) {
        this.method = method;
        this.id = id;
    }


    public ViewVendorsRequest(String method,String vendorno,String vendor,
                              String vendortype,String address,String country,
                              String zipcode,String telephone,String fax,String email ) {
        this.method = method;
        this.vendorno = vendorno;
        this.vendor = vendor;
        this.vendortype = vendortype;
        this.address = address;
        this.country = country;
        this.zipcode = zipcode;
        this.telephone = telephone;
        this.fax = fax;
        this.email = email;

    }
    public ViewVendorsRequest(String method,String vendorno,String vendor,
                              String vendortype,String address,String country,
                              String zipcode,String telephone,String fax,String email,String id ) {
        this.method = method;
        this.vendorno = vendorno;
        this.vendor = vendor;
        this.vendortype = vendortype;
        this.address = address;
        this.country = country;
        this.zipcode = zipcode;
        this.telephone = telephone;
        this.fax = fax;
        this.email = email;
        this.id = id;

    }
}

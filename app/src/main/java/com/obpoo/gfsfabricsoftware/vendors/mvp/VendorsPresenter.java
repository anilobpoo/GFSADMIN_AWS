package com.obpoo.gfsfabricsoftware.vendors.mvp;

public interface VendorsPresenter {
   // void validate(String name, String location,String type,String method,String address);
   void viewAll(String methodname);
   void getone(String methodname,String id);
   void delete(String methodname,String id,String del);
   void add(String methodname,String vendorno,String vendor,String vendortype,String address,String country,String zipcode,String telephone,String fax,String email);
   void update(String methodname,String vendorno,String vendor,String vendortype,String address,String country,String zipcode,String telephone,String fax,String email,String id);
}

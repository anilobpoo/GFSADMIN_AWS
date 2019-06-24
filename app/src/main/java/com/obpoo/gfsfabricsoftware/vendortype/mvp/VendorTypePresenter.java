package com.obpoo.gfsfabricsoftware.vendortype.mvp;

public interface VendorTypePresenter {
   // void validate(String name, String location,String type,String method,String address);
   void viewAll(String methodname);
   void add(String methodname,String name);
   void delete(String methodname,String id,String del,String dells);
   void edit(String methodname,String name,String id);
}

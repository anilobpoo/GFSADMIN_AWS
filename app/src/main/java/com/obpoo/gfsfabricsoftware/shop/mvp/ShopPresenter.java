package com.obpoo.gfsfabricsoftware.shop.mvp;

public interface ShopPresenter {
   // void validate(String name, String location,String type,String method,String address);
   void viewAll(String methodname);
   void add(String methodname,String name,String location,String address,String min_max_type);
   void delete(String methodname,String id);
   void edit(String methodname,String name,String location,String address,String min_max_type,String id);
   void getone(String methodname,String id,String getone);
}

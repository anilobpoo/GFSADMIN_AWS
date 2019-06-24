package com.obpoo.gfsfabricsoftware.minmax.mvp;

public interface MinMaxPresenter {
   // void validate(String name, String location,String type,String method,String address);
   void viewAll(String methodname);
   void add(String methodname,String title);
   void del(String methodname,String title,String del,String dels);
   void update(String methodname,String title,String id);
}

package com.obpoo.gfsfabricsoftware.customertype.mvp;

public interface CustomerTypePresenter {

   void viewAll(String methodname);
   void add(String methodname,String customer_type);
   void delete(String methodname,String id,String del,String dels);
   void edit(String methodname,String customer_type,String id );
}

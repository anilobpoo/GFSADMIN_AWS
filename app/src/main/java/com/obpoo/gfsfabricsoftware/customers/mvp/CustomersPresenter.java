package com.obpoo.gfsfabricsoftware.customers.mvp;

public interface CustomersPresenter {
   // void validate(String name, String location,String type,String method,String address);
   void viewAll(String methodname,String user_id);
   void add(String method,String user_id,String customer_name,String customer_type_id,String vat_name,
            String password,String shop_id,String customer_group,
            String address,String user_name,String country,String zipcode,String phone,String fax,String email);
   void del(String methodname,String id,String del);
   void upddate(String id,String method,String user_id,String customer_name,String customer_type_id,String vat_name,
            String password,String shop_id,String customer_group,
            String address,String user_name,String country,String zipcode,String phone,String fax,String email);
   void getone(String methodname,String id,String del,String getone);
}

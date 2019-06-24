package com.obpoo.gfsfabricsoftware.warehouse.mvp;

public interface WarehousePresenter {
   // void validate(String name, String location,String type,String method,String address);
   void viewAll(String methodname);
   void add(String method,String warehouse_name,
            String warehouse_no,String can_sell_part,String locality,String address,String Available_status,String shopNo);
   void edit(String method,String warehouse_name,
             String warehouse_no,String can_sell_part,String locality,String address,String Available_status,String shopNo,String id);
   void getone(String methodname,String id);
}

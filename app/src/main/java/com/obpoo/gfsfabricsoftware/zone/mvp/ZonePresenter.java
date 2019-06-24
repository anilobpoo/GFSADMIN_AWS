package com.obpoo.gfsfabricsoftware.zone.mvp;

public interface ZonePresenter {

   void viewAll(String methodname,String warehouse_id);
   void add(String methodname, String warehouse_id, String no_of_zone);
   void addShelf(String methodname, String warehouse_id, String zone_id,String zone_no,String no_of_shelf);
   void viewShelf(String methodname, String zone_id,String shelf,String shelfs);

}

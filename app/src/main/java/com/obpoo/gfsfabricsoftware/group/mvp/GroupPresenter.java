package com.obpoo.gfsfabricsoftware.group.mvp;

public interface GroupPresenter {
   void viewAll(String methodname,String admin_id);
   void addAll(String methodname,String name, String discount_per,String admin_id);
   void updateAll(String id,String methodname,String name, String discount_per,String admin_id);
   void delete(String methodname,String id,String del);
}

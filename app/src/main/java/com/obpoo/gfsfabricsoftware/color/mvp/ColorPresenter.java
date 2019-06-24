package com.obpoo.gfsfabricsoftware.color.mvp;

public interface ColorPresenter {
   void viewAll(String methodname);
   void delete(String methodname,String id);
   void add(String methodname,String color_code,String add);
   void update(String methodname,String color_code,String id,String update);
}

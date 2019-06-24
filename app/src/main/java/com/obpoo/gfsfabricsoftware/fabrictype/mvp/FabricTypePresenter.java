package com.obpoo.gfsfabricsoftware.fabrictype.mvp;

public interface FabricTypePresenter {
   void viewAll(String methodname);
   void delete(String methodname, String id,String del,String dells);
   void add(String methodname, String color_code);
   void update(String methodname, String color_code, String id);
}

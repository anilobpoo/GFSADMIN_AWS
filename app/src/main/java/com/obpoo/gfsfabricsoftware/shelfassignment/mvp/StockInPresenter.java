package com.obpoo.gfsfabricsoftware.shelfassignment.mvp;

import java.util.List;

public interface StockInPresenter {

   void add(String shelf_id, String method, List<String> unique_codes, String created_by, String updated_by);
   void view(String shelf_id, String method);
   void move(String shelf_id, String method,List<String> unique_codes);


}

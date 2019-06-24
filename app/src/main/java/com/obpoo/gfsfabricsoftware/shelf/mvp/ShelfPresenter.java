package com.obpoo.gfsfabricsoftware.shelf.mvp;

public interface ShelfPresenter {


   void addShelf(String methodname, String warehouse_id, String zone_id, String zone_no, String no_of_shelf);
   void viewShelf(String methodname, String zone_id);

}

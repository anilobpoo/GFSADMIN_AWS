package com.obpoo.gfsfabricsoftware.cart.mvp;

public interface CartPresenter {
   // void validate(String name, String location,String type,String method,String address);
   void view(String method, String orderid);
   void delete(String method, String id, String del);
   void changestatus(String method, String id, String status, String changestatus);
   void editItem(String method, String id, String qunatity, String actual_price, String subtotal);
   void add(String method, String orderid, String item_id, String quantity, String actual_price, String discount_for_user, String subtotal,
            String stock_id_qty, String qc_description);

}

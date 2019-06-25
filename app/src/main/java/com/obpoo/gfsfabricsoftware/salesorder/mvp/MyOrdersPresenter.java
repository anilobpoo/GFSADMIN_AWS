package com.obpoo.gfsfabricsoftware.salesorder.mvp;

public interface MyOrdersPresenter {
   // void validate(String name, String location,String type,String method,String address);
   void view(String methodname,int page_no);
   void add(String methodname, String customer_id, String discount_type, String canceled_by, String order_by, String order_no,
            String advance, String leftover, String order_total, String coupon_per, String coupon_discount_price, String group_id,
            String pg_assign_time, String pg_delivery_time, String delivery_by, String discount,
            String pickup_time, String Dellivery_address, String pay_mode, String credit_time, String delivery_type, String lattitude, String longitude);
   void update(String methodname, String advance, String leftover, String order_total, String coupon_per, String coupon_discount_price, String Dellivery_address, String pay_mode, String credit_time, String delivery_type, String lattitude, String longitude, String id, String complete_status);
   void delete(String methodname, String id, String status);
   void onPassAllORderSo(String method,String page_no);
   void onPassAllSOorderdateFilter(String method,String from,String to,String page_no);
   void onPassAllOrderSoStatus(String method);
   void onPassAllOrderselectedStatus(String method,String status);

}

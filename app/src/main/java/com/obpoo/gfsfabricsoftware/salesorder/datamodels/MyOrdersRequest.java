package com.obpoo.gfsfabricsoftware.salesorder.datamodels;

public class MyOrdersRequest {




    String method,id;
    String customer_id;
    String order_by;
    String order_no;
    String advance;
    String leftover; String order_total;
    String coupon_per;
    String coupon_discount_price; String group_id;
    String pg_assign_time;

    public MyOrdersRequest(String method, int page_no) {
        this.method = method;
        this.page_no = page_no;
    }

    String pg_delivery_time;
    String delivery_by; String pickup_time;
    String Dellivery_address;
    String discount;
    String canceled_by,discount_type;
    String pay_mode,credit_time;
    String delivery_type,lattitude,longitude,status,complete_status;
    int  page_no;

    public MyOrdersRequest(String method) {
        this.method = method;
    }
    public MyOrdersRequest(String method, String customer_id) {
        this.method = method;
        this.customer_id = customer_id;
    }

    public MyOrdersRequest(String method, String id,String status) {
        this.method = method;
        this.id = id;this.status = status;
    }
    public MyOrdersRequest(String methodname, String customer_id, String discount_type, String canceled_by, String order_by, String order_no,
                           String advance, String leftover, String order_total, String coupon_per, String coupon_discount_price, String group_id,
                           String pg_assign_time, String pg_delivery_time, String delivery_by, String discount,
                           String pickup_time, String Dellivery_address, String pay_mode, String credit_time, String delivery_type, String lattitude, String longitude) {
        this.method = methodname;
        this.customer_id = customer_id;
        this.order_by = order_by;
        this.order_no = order_no;
        this.advance = advance;
        this.leftover = leftover;
        this.order_total = order_total;
        this.coupon_per = coupon_per;
        this.coupon_discount_price = coupon_discount_price;
        this.group_id = group_id;
        this.pg_assign_time = pg_assign_time;
        this.pg_delivery_time = pg_delivery_time;
        this.delivery_by = delivery_by;
        this.discount = discount;
        this.pickup_time = pickup_time;
        this.discount_type = discount_type;
        this.canceled_by = canceled_by;
        this.Dellivery_address = Dellivery_address;
        this.pay_mode = pay_mode;
        this.credit_time = credit_time;
        this.delivery_type = delivery_type;
        this.lattitude = lattitude;
        this.longitude = longitude;

    }

    public MyOrdersRequest(String methodname, String advance, String leftover, String order_total, String coupon_per, String coupon_discount_price,
                           String Dellivery_address, String pay_mode, String credit_time, String delivery_type, String lattitude, String longitude, String id,String complete_status) {
        this.method = methodname;
        this.advance = advance;
        this.leftover = leftover;
        this.order_total = order_total;
        this.coupon_per = coupon_per;
        this.coupon_discount_price = coupon_discount_price;
        this.Dellivery_address = Dellivery_address;
        this.pay_mode = pay_mode;
        this.credit_time = credit_time;
        this.delivery_type = delivery_type;
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.id = id;
        this.complete_status = complete_status;

    }


}

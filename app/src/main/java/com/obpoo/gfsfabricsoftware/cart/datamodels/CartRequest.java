package com.obpoo.gfsfabricsoftware.cart.datamodels;

public class CartRequest {




    String method;String orderid;String item_id;String quantity; String actual_price;String discount_for_user;String subtotal;
    String status,id,stock_id_qty,qc_description;


    public CartRequest(String method, String orderid) {
        this.orderid=orderid;
        this.method=method;
    }

    public CartRequest(String method,String id,String quantity,String actual_price, String subtotal) {
        this.id=id;
        this.method=method;
        this.quantity=quantity;
        this.actual_price=actual_price;
        this.subtotal=subtotal;
    }

    public CartRequest(String method,String id,String del) {
        this.id=id;
        this.method=method;

    }

    public CartRequest(String method,String id,String status,String changestatus) {
        this.id=id;
        this.method=method;
        this.status=status;

    }

    public CartRequest(String method,String orderid,String item_id,String quantity, String actual_price,String discount_for_user,String subtotal,
                       String stock_id_qty,String qc_description) {
        this.orderid=orderid;
        this.method=method;
        this.item_id=item_id;
        this.quantity=quantity;
        this.actual_price=actual_price;
        this.discount_for_user=discount_for_user;
        this.subtotal=subtotal;
        this.stock_id_qty=stock_id_qty;
        this.qc_description=qc_description;

    }
}

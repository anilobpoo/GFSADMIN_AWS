package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel;

public class PoOrderRequest {
    String method,from_date,to_date,page_no;

    public PoOrderRequest(String method, String from_date, String to_date, String page_no) {
        this.method = method;
        this.from_date = from_date;
        this.to_date = to_date;
        this.page_no = page_no;
    }
}

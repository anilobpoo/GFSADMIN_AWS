package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel;

public class ViewPgnRequest {
    String method,page_no;

    public ViewPgnRequest(String method,String page_no) {
        this.method = method;
        this.page_no = page_no;
    }
}

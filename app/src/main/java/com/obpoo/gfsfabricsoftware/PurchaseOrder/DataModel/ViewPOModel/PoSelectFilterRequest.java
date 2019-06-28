package com.obpoo.gfsfabricsoftware.PurchaseOrder.DataModel.ViewPOModel;

public class PoSelectFilterRequest  {
    String method,status,page_no;

    public PoSelectFilterRequest(String method, String status, String page_no) {
        this.method = method;
        this.status = status;
        this.page_no = page_no;
    }
}

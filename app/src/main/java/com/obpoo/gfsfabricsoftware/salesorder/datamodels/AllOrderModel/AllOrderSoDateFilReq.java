package com.obpoo.gfsfabricsoftware.salesorder.datamodels.AllOrderModel;

public class AllOrderSoDateFilReq {
    String method, from, to, page_no;

    public AllOrderSoDateFilReq(String method, String from, String to, String page_no) {
        this.method = method;
        this.from = from;
        this.to = to;
        this.page_no = page_no;
    }
}

package com.obpoo.gfsfabricsoftware.Report.DataModel.ItemSalesRe;

public class ItemSalesReq {
    String status,from,method,to,page_no;

    public ItemSalesReq(String status, String from, String method, String to, String page_no) {
        this.status = status;
        this.from = from;
        this.method = method;
        this.to = to;
        this.page_no = page_no;
    }
}

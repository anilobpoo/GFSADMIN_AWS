package com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert;

/**
 * Created by PHD on 1/17/2019.
 */

public class StockAlertRequest {
    String method,page_no;

    public StockAlertRequest(String method, String page_no) {
        this.method = method;
        this.page_no = page_no;
    }
}

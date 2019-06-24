package com.obpoo.gfsfabricsoftware.Stock.DataModel;

/**
 * Created by PHD on 1/29/2019.
 */

public class ViewStockShelvRequest {
    String method,shelf_id,page_no;

    public ViewStockShelvRequest(String method, String shelf_id,String page_no) {
        this.method = method;
        this.shelf_id = shelf_id;
        this.page_no = page_no;
    }
}

package com.obpoo.gfsfabricsoftware.Stock.DataModel;

/**
 * Created by PHD on 1/29/2019.
 */

public class ViewStockRequest {
    String method,wh_id;

    public ViewStockRequest(String method, String wh_id) {
        this.method = method;
        this.wh_id = wh_id;
    }
}

package com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert;

/**
 * Created by PHD on 1/21/2019.
 */

public class StockSearchRequest {
    String method,fab_name;

    public StockSearchRequest(String method, String fab_name) {
        this.method = method;
        this.fab_name = fab_name;
    }
}

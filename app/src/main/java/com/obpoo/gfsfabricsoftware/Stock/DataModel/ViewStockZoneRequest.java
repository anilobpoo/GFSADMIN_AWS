package com.obpoo.gfsfabricsoftware.Stock.DataModel;

/**
 * Created by PHD on 1/29/2019.
 */

public class ViewStockZoneRequest {
    String method,zone_id;

    public ViewStockZoneRequest(String method, String zone_id) {
        this.method = method;
        this.zone_id = zone_id;
    }
}

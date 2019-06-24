package com.obpoo.gfsfabricsoftware.Dashboard.DataModel.StockAlert;

/**
 * Created by PHD on 1/18/2019.
 */

public class CurveRequest {
    String method,fab_id,year;

    public CurveRequest(String method, String fab_id, String year) {
        this.method = method;
        this.fab_id = fab_id;
        this.year = year;
    }
}

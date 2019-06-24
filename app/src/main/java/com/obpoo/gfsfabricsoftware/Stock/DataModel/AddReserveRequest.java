package com.obpoo.gfsfabricsoftware.Stock.DataModel;

/**
 * Created by PHD on 2/12/2019.
 */

public class AddReserveRequest {
    String method,search;

    public AddReserveRequest(String method, String search) {
        this.method = method;
        this.search = search;
    }
}
